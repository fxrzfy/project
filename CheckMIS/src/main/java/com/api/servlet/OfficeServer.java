package com.api.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DBstep.iDBManager2000;
import DBstep.iMsgServer2015;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.biz.dto.GzzdDto;
import com.biz.service.GzzdService;
import com.biz.service.SpringContextUtil;
import com.core.pageModel.SessionInfo;
import com.util.ConfigUtil;
import com.util.DateUtil;
import com.util.StringUtil;

/**
 * 
 * @author 陈益特
 * @time  2015-01-09
 */

public class OfficeServer  extends HttpServlet{
    private iMsgServer2015 MsgObj = new iMsgServer2015();
    private iDBManager2000 DbaObj = new iDBManager2000();
	String mOption;
	String mUserName;
	String mRecordID;
	String mFileName;
	String mFileType;
    String mCommand;
    String mInfo;
    String mTemplate;
    String mContent;
    String mRemoteFile;
    String mImageName;
	byte[] mFileBody;	
	int mFileSize = 0;
    String mFilePath; //取得服务器路径
    String mDirectory; 
    //数据库相关功能开始
    //打印控制
    private String mOfficePrints;
    private int mCopies;
    
    //更新打印份数
    private boolean UpdataCopies(int mLeftCopies) {
      boolean mResult = true;
      //该函数可以把打印减少的次数记录到数据库
      //根据自己的系统进行扩展该功能
      return mResult;
    }
    
    //保存书签
    private boolean SaveBookMarks() {
      boolean mResult = false;
      String mBookMarkName;
      int mIndex;
      try {
        if (DbaObj.OpenConnection()) {
          try {
            java.sql.PreparedStatement prestmt = null;
            String Sql = "DELETE FROM Template_BookMarks Where RecordID='" + mTemplate + "'";
            prestmt = DbaObj.Conn.prepareStatement(Sql);
            
            prestmt.execute();
            int getFieldCount = MsgObj.GetFieldCount();
            prestmt.close();
            for (mIndex = 0; mIndex < getFieldCount - 2; mIndex++) {
              java.sql.PreparedStatement prestmtx = null;
              mBookMarkName = MsgObj.GetFieldName(mIndex);
              Sql = "insert into Template_BookMarks (RecordId,BookMarkName) values ('" + mTemplate + "','" + mBookMarkName + "')";
              prestmtx = DbaObj.Conn.prepareStatement(Sql);
              prestmtx.execute();
              prestmtx.close();
            }
            mResult = true;
          }
          catch (SQLException e) {
            System.out.println(e.toString());
            mResult = false;
          }
        }
      }
      finally {
        DbaObj.CloseConnection();
      }
      return (mResult);
    }
    
    //装入书签
    private boolean LoadBookMarks() {
      boolean mResult = false;
      String Sql = " select b.BookMarkName,b.BookMarkText from Template_BookMarks a,BookMarks b where a.BookMarkname=b.BookMarkName and a.RecordID='" + mTemplate + "'";
      try {
        if (DbaObj.OpenConnection()) {
          try {
            ResultSet result = DbaObj.ExecuteQuery(Sql);
            while (result.next()) {
              try {
                //说明：我们测试程序把SQL语句直接写到替换标签内容
                //实际使用中，这个标签内容是通过Sql语句得到的。
                //生成SQL查询语句  result.getString("BookMarkText") & "条件"
                //当前纪录号位 mRecordID
                //BookMarkValue=生成SQL运行结果
                String mBookMarkName = result.getString("BookMarkName");
                String mBookMarkValue = result.getString("BookMarkText");
                MsgObj.SetMsgByName(mBookMarkName, mBookMarkValue);
              }
              catch (Exception ex) {
                System.out.println(ex.toString());
              }
            }
            result.close();
            mResult = true;
          }
          catch (SQLException e) {
            System.out.println(e.getMessage());
            mResult = false;
          }
        }
      }
      finally {
        DbaObj.CloseConnection();
      }
      return (mResult);
    }
	private GzzdDto convert(String str) {
		GzzdDto gzzd = new GzzdDto();
		JSONObject j = JSON.parseObject(str);
		String id = j.getString("id");
		if (!StringUtil.isEmpty(id)) {
			gzzd.setId(Long.parseLong(id));
		}
		String fbsj = j.getString("fbsj");
		if (!StringUtil.isEmpty(fbsj)) {
			gzzd.setFbsj(DateUtil.parseDate10(fbsj));
		}
		gzzd.setWh(j.getString("wh"));
		gzzd.setBt(j.getString("bt"));
		gzzd.setFbnr(j.getString("fbnr"));
		gzzd.setJl(j.getString("jl"));
		return gzzd;
	}
    //数据库相关功能结束
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		mCommand = "";
		  mFilePath = request.getSession().getServletContext().getRealPath("");       //取得服务器路径
		SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(ConfigUtil.getSessionInfoName());
		   try{
			   GzzdService gzzdService = SpringContextUtil.getBean("gzzdService");
			   if(request.getMethod().equalsIgnoreCase("POST")){//判断请求方式
				   MsgObj.setSendType("JSON");
				   MsgObj.Load(request); //解析请求
				   mOption = MsgObj.GetMsgByName("OPTION");//请求参数
				   mUserName = MsgObj.GetMsgByName("USERNAME");  //取得系统用户
				   System.out.println(mOption);

				   String mFilePath = ConfigUtil.get("file_dir") + "/gzzd/";//取得操作信息
				   String mFileType = MsgObj.GetMsgByName("FILETYPE");                        //取得文档类型
				   String fullPath = mFilePath + mRecordID + mFileType;       //文档的完整路径

				   if(mOption.equalsIgnoreCase("LOADFILE")){
					    mRecordID = MsgObj.GetMsgByName("RECORDID");                        //取得文档编号
				        mFileName = MsgObj.GetMsgByName("FILENAME");//取得文档名称
				        MsgObj.MsgTextClear();//清除文本信息
				        System.out.println(fullPath);
				        if (MsgObj.MsgFileLoad(fullPath)){
				        	System.out.println(mRecordID+"文档已经加载");
				        }
				   }else if(mOption.equalsIgnoreCase("SAVEFILE")){
					   System.out.println(mRecordID+"文档上传中");
					    mRecordID = MsgObj.GetMsgByName("RECORDID");                        //取得文档编号
				        mFileName = MsgObj.GetMsgByName("FILENAME");//取得文档名称
				        MsgObj.MsgTextClear();//清除文本信息
				        if (MsgObj.MsgFileSave(mFilePath+"\\Document\\"+mFileName)){
				        	System.out.println(mRecordID+"文档已经保存成功");
				        }					   
				   }else if(mOption.equalsIgnoreCase("SAVEPDF")){
					   System.out.println(mRecordID+"文档转PDF");
					   mRecordID = MsgObj.GetMsgByName("RECORDID");                        //取得文档编号
				       mFileName = MsgObj.GetMsgByName("FILENAME");//取得文档名称
				       MsgObj.MsgTextClear();//清除文本信息
				       mFilePath = mFilePath+"\\PDF";
				       MsgObj.MakeDirectory(mFilePath); 
				        if (MsgObj.MsgFileSave(mFilePath + "\\"+mFileName)){
				        	System.out.println(mRecordID+"文档已经转换成功");
				        }					   
				   
				   }else if(mOption.equalsIgnoreCase("SAVEHTML")){
					   System.out.println(mRecordID+"文档上传中");
					    mRecordID = MsgObj.GetMsgByName("RECORDID");                        //取得文档编号
				        mFileName = MsgObj.GetMsgByName("FILENAME");//取得文档名称
				        mDirectory = MsgObj.GetMsgByName("DIRECTORY"); //获取目录名称
				        MsgObj.MsgTextClear();//清除文本信息
				        System.out.println("mDirectory=="+mDirectory);
				        if (mDirectory.equalsIgnoreCase("")) {
			                mFilePath = mFilePath + "\\HTML";
			              }
			              else {
			                mFilePath = mFilePath + "\\HTML\\" + mDirectory;
			                System.out.println("mFilePath==="+mFilePath);
			              }
				        MsgObj.MakeDirectory(mFilePath); 
				        System.out.println("开始MsgFileSave"+mFilePath);
				        if (MsgObj.MsgFileSave(mFilePath + "\\" + mFileName)){
				        	System.out.println(mRecordID+"文档已经保存成功");
				        }	
				   	}else if (mOption.equalsIgnoreCase("SAVEIMAGE")) {                     //下面的代码为将OFFICE存为HTML图片页面
				   		  mFileName = MsgObj.GetMsgByName("FILENAME");                        //取得文件名称
			              mDirectory = MsgObj.GetMsgByName("DIRECTORY");                      //取得目录名称
			              MsgObj.MsgTextClear();
			              if (mDirectory.trim().equalsIgnoreCase("")) {
			                mFilePath = mFilePath + "\\HTMLIMAGE";
			              }
			              else {
			                mFilePath = mFilePath + "\\HTMLIMAGE\\" + mDirectory;
			              }
			              MsgObj.MakeDirectory(mFilePath);                                    //创建路径
			              if (MsgObj.MsgFileSave(mFilePath + "\\" + mFileName)) {             //保存HTML文件
			            	  System.out.println(mRecordID+"文档已经保存成功");               //设置状态信息
			              }else {
			                  System.out.println("保存HTML图片失败!");
			              }
			            }else if (mOption.equalsIgnoreCase("LOADTEMPLATE")) {                  //下面的代码为打开服务器数据库里的模板文件
		                 mTemplate = MsgObj.GetMsgByName("TEMPLATE");                        //取得模板文档类型
		                 //本段处理是否调用文档时打开模版，还是套用模版时打开模版。
		                 MsgObj.MsgTextClear();//清除文本信息
		                 if (MsgObj.MsgFileLoad(mFilePath + "\\Document\\" + mTemplate)) { //从服务器文件夹中调入模板文档
		                	System.out.println(mTemplate+"文档已经转换成功");                              //清除错误信息
		                 }
			              
		            }else if (mOption.equalsIgnoreCase("SAVETEMPLATE")) {                  //下面的代码为打开服务器数据库里的模板文件
		            	mTemplate = MsgObj.GetMsgByName("TEMPLATE");//取得模板名称
		            	System.out.println(mTemplate+"模板上传中");
				        MsgObj.MsgTextClear();//清除文本信息
				        if (MsgObj.MsgFileSave(mFilePath+"\\Document\\"+mTemplate)){
				        	System.out.println(mTemplate+"模板保存成功");
				        }			
	            	}else if (mOption.equalsIgnoreCase("INSERTFILE")) {                  //下面的代码为打开服务器数据库里的模板文件
	            		System.out.println("进入INSERTFILE");
		            	mTemplate = MsgObj.GetMsgByName("TEMPLATE");//取得模板名称
		            	System.out.println(mTemplate+"模板上传中");
				        MsgObj.MsgTextClear();//清除文本信息
				        if (MsgObj.MsgFileLoad(mFilePath+"\\Document\\"+mTemplate)){
				        	System.out.println(mRecordID+"模板保存成功");
				        }			
	            	}else if (mOption.equalsIgnoreCase("LOADBOOKMARKS")) {                 //下面的代码为取得文档标签
	                    mTemplate = MsgObj.GetMsgByName("RECORDID");                        //取得模板编号
	                    mFileName = MsgObj.GetMsgByName("FILENAME");                        //取得文档名称
	                    mFileType = MsgObj.GetMsgByName("FILETYPE");                        //取得文档类型
	                    MsgObj.MsgTextClear();
	                    System.out.println("mTemplate:=" + mTemplate);
	                    if (LoadBookMarks()) {
	                    	System.out.println("获取书签信息成功");                                          //清除错误信息
	                    }
	                    else {
	                    	System.out.println("获取书签信息失败");                            //设置错误信息
	                    }
	                  }else if(mOption.equalsIgnoreCase("GETFILE")){
						   System.out.println("开始下载文档");
						   mRecordID = MsgObj.GetMsgByName("RECORDID");                 //取得文档编号
						   mRemoteFile = MsgObj.GetMsgByName("REMOTEFILE");				//取得远程文件名称
						   MsgObj.MsgTextClear();//清除文本信息
						   System.out.println(mFilePath+"\\Document\\"+mRemoteFile);
					        if (MsgObj.MsgFileLoad(mFilePath+"\\Document\\"+mRemoteFile)){
					        	System.out.println(mRemoteFile+"文档已经下载");
					        }				   
					   }else if(mOption.equalsIgnoreCase("PUTFILE")){
						   System.out.println("开始下载文档");
						   mRemoteFile = MsgObj.GetMsgByName("REMOTEFILE");				//取得远程文件名称
						   MsgObj.MsgTextClear();//清除文本信息
						   System.out.println(mFilePath+"\\Document\\"+mRemoteFile);
						   if (MsgObj.MsgFileSave(mFilePath+"\\Document\\"+mRemoteFile)){
							   System.out.println(mRemoteFile+"文档已经上传成功");
						   }				   
					   }else if(mOption.equalsIgnoreCase("DELFILE")){
						   mRemoteFile=MsgObj.GetMsgByName("REMOTEFILE");				//取得远程文件名称
						   MsgObj.MsgTextClear();									//清除文本信息
						   if (MsgObj.DelFile(mFilePath+"\\Document\\"+mRemoteFile)){							//删除文档
							   System.out.println("删除文件成功");
						   }
						   else{
							   System.out.println("删除文件失败");							//设置错误信息
						   }
						 }else if (mOption.equalsIgnoreCase("SENDMESSAGE")) {                   //下面的代码为Web页面请求信息[扩展接口]
			                mCommand = MsgObj.GetMsgByName("COMMAND");                          //取得自定义的操作类型
			                mOfficePrints = MsgObj.GetMsgByName("OFFICEPRINTS");                //取得Office文档的打印次数
			                mUserName = MsgObj.GetMsgByName("USERNAME");
			                mInfo = MsgObj.GetMsgByName("TESTINFO");
			                MsgObj.MsgTextClear();
			                if(mCommand == null){
			                	mCommand = "INPORTTEXT";
			                }
			                if(mCommand.equalsIgnoreCase("COPIES")) {                     //打印份数控制功能
			                  System.out.println("mOfficePrints:"+mOfficePrints);
			                  mCopies = Integer.parseInt(mOfficePrints);                        //获得客户需要打印的份数
			                  System.out.println("mCopies:"+mCopies);
			                  if (mCopies <= 2) {                                               //比较打印份数，拟定该文档允许打印的总数为2份，注：可以在数据库中设置好文档允许打印的份数
			                    if (UpdataCopies(2 - mCopies)) {                                //更新打印份数
			                    	MsgObj.SetMsgByName("STATUS", "1");                           //设置状态信息，允许打印
			                    	System.out.println("在打印范围内开始打印");
			                    }
			                  }
			                  else {
			                    MsgObj.SetMsgByName("STATUS", "0");                             //不允许打印
			                    System.out.println("超过打印限度不允许打印");
			                  }
			                }else if(mCommand.equalsIgnoreCase("INPORTTEXT")){
			                	mInfo = "服务器端收到客户端传来的信息：“" + mInfo + "” | ";
			                	mInfo = mInfo + "当前服务器时间：" + DbaObj.GetDateTime();        //组合返回给客户端的信息
			                	MsgObj.SetMsgByName("RETURNINFO", mInfo);
			                	System.out.println("发送数据到前台名为:" + mInfo);
			                }
			                
			              }else if (mOption.equalsIgnoreCase("SAVEBOOKMARKS")) {                 //下面的代码为取得标签文档内容
			                  mTemplate = MsgObj.GetMsgByName("TEMPLATE");                        //取得模板编号
			                  if (SaveBookMarks()) {
			                    System.out.println("保存书签信息成功!");                                              //清除错误信息
			                  }
			                  else {
			                	  System.out.println("保存书签信息失败!");                             //设置错误信息
			                  }
			                  MsgObj.MsgTextClear();                                              //清除文本信息
			                  MsgObj.ListClear();
			              }else if (mOption.equalsIgnoreCase("INSERTIMAGE")) {                   //下面的代码为插入服务器图片
			                  mRecordID = MsgObj.GetMsgByName("RECORDID");                        //取得文档编号
			                  mImageName = MsgObj.GetMsgByName("IMAGENAME");                      //图片名
			                  mFilePath = mFilePath + "\\Document\\" + mImageName;                //图片在服务器的完整路径
			                  MsgObj.MsgTextClear();
			                  if (MsgObj.MsgFileLoad(mFilePath)) {                                //调入图片
			                    System.out.println("插入图片成功!");    
			                  }
			                  else {
			                	System.out.println("插入图片失败!");                                    //设置错误信息
			                  }
			                }
				 System.out.println("SendPackage");
				 MsgObj.Send(response);   
			   }
			}catch (Exception e) {
				e.printStackTrace();   
		    }
	}

}
