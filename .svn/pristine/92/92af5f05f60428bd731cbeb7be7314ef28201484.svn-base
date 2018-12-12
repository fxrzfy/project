<%@page contentType="text/html; charset=gb2312" %>
<%@page import="java.io.*" %>
<%@page import="java.text.*" %>
<%@page import="java.util.*" %>
<%@page import="com.biz.service.SpringContextUtil" %>
<%@page import="DBstep.iMsgServer2000.*" %>
<%@ page import="com.core.model.checkmis.Gzzd" %>
<%@ page import="com.alibaba.fastjson.JSONObject" %>
<%@ page import="com.alibaba.fastjson.JSON" %>
<%@ page import="com.util.StringUtil" %>
<%@ page import="com.util.DateUtil" %>
<%@ page import="com.core.pageModel.SessionInfo" %>
<%@ page import="com.util.ConfigUtil" %>
<%@ page import="com.biz.service.GzzdService" %>
<%@ page import="com.biz.dto.GzzdDto" %>
<%!
    public class iWebOffice {
        private String mOption;
        private String mRecordID;
        private String mUserName;
        private String mFileType;
        private String mFilePath;
        private DBstep.iMsgServer2000 MsgObj;

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

        public void ExecuteRun(HttpServletRequest request, HttpServletResponse response) throws Exception {
            SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(ConfigUtil.getSessionInfoName());
            System.out.println("--------------------------------");
            DBstep.iMsgServer2000 MsgObj = new DBstep.iMsgServer2000();                                   //创建服务对象
            request.setCharacterEncoding("gb2312");
            MsgObj.Load(request);
            //解析客户端发送的数据
            System.out.println("============================s");
            String mRecordID = MsgObj.GetMsgByName("RECORDID"); //取得文档编号,用来封装前台传过来参数
            String DBSTEP = MsgObj.GetMsgByName("DBSTEP");
            try {
                GzzdService gzzdService = SpringContextUtil.getBean("gzzdService");
                if ("DBSTEP".equalsIgnoreCase(DBSTEP)) {//如果是合法的信息包
                    String mOption = MsgObj.GetMsgByName("OPTION");
                    String mFilePath = ConfigUtil.get("file_dir") + "/gzzd/";//取得操作信息
                    String mFileType = MsgObj.GetMsgByName("FILETYPE");                        //取得文档类型
                    String fullPath = mFilePath + mRecordID + mFileType;       //文档的完整路径
                    if ("SAVEFILE".equalsIgnoreCase(mOption)) {                           //下面的代码为保存为全文批注格式文件
                        GzzdDto gzzd = convert(mRecordID);
                        System.out.println("convert" + JSON.toJSONString(gzzd));
                        gzzdService.valiadate(gzzd);
                        Long id = gzzdService.saveUpdate(gzzd, sessionInfo);
                        mRecordID = id.toString();
                        fullPath = mFilePath + mRecordID + mFileType;       //文档的完整路径
//                mFileBody=MsgObj.MsgFileBody();			                              //取得文档内容 mFileBody可以保存到数据库中，类型byte[]
                        MsgObj.MsgTextClear();                                              //清除文本信息
                        File f = new File(mFilePath);
                        if (!f.exists()) {
                            f.mkdirs();
                        }
                        System.out.println(fullPath);
                        if (MsgObj.MsgFileSave(fullPath)) {                                //保存文档
                            MsgObj.SetMsgByName("Status", "200");                   //设置状态信息
                            System.out.println(MsgObj.GetMsgByName("Status"));
                            MsgObj.MsgError("");                                              //清除错误信息
                        } else {
                            System.out.println("-----------------------------------------------------");
                            MsgObj.MsgError("保存文档失败!");                                 //设置错误信息
                        }
                        MsgObj.MsgFileClear();

                    } else if ("LOADFILE".equalsIgnoreCase(mOption)) {                      //下面的代码为调入全文批注格式文件
                        MsgObj.MsgTextClear();                                              //清除文本信息
                        if (MsgObj.MsgFileLoad(fullPath)) {                                //调入文档内容
                            //MsgObj.MsgFileBody(mFileBody);			                            //将文件信息打包，mFileBody为从数据库中读取，类型byte[]
                            MsgObj.SetMsgByName("Status", "200");                             //设置状态信息
                            MsgObj.MsgError("");                                              //清除错误信息
                        } else {
                            MsgObj.MsgError("打开文档失败!");                                 //设置错误信息
                        }
                    }

                } else {
                    MsgObj.MsgError("客户端发送数据包错误!");
                    MsgObj.MsgTextClear();
                    MsgObj.MsgFileClear();
                }
            } catch (Exception e) {
                e.printStackTrace();
                MsgObj.MsgError(e.getMessage());
                MsgObj.SetMsgByName("Status", e.getMessage());
                MsgObj.MsgTextClear();
                MsgObj.MsgFileClear();
            }
            System.out.println("===========================输出");
            System.out.println(MsgObj.GetMsgByName("Status"));
            MsgObj.Send(response);                                                  //将结果数据包返回给客户端
        }
    }
%>
<%
    iWebOffice officeServer = new iWebOffice();
    response.setCharacterEncoding("GB2312");
    System.out.println(request.getContextPath());
    System.out.println(request.getPathInfo());
    System.out.println(request.getServletPath());
    officeServer.ExecuteRun(request, response);
%>