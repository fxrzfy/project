<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.io.*,java.text.*,java.util.*,java.sql.*,java.text.SimpleDateFormat,java.text.DateFormat,java.util.Date,javax.servlet.*,javax.servlet.http.*,DBstep.iDBManager2000.*" %>
<%
    //自动获取OfficeServer和OCX文件完整URL路径
    String mHttpUrlName=request.getRequestURI();
    String mScriptName=request.getServletPath();
    String mServerName="OfficeServer";
    String mServerUrl="http://"+request.getServerName()+":"+request.getServerPort()+mHttpUrlName.substring(0,mHttpUrlName.lastIndexOf(mScriptName))+"/"+mServerName;//取得OfficeServer文件的完整URL
%>

<html>
<head>
    <title>在线打开/保存Word文档</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script src="/view/common/plugs/jinge/WebOffice.js"></script>


    <script type="text/javascript">
        var WebOfficeObj = new WebOffice2015(); //创建WebOffice对象
    </script>

    <script language="javascript">
        //有进度条打开文档
        function Load()
        {
            try
            {
                WebOfficeObj.WebUrl = "<%=mServerUrl%>";
                WebOfficeObj.UserName = "演示人";
                WebOfficeObj.FileName = "sample.doc";
                WebOfficeObj.FileType = ".doc";            //FileType:文档类型  .doc  .xls
                WebOfficeObj.DebugMode = false;						//开启or关闭调试模式  true：开启  false：关闭
                WebOfficeObj.ShowWindow = true;					//true显示进度条//false隐藏进度条
                WebOfficeObj.EditType = "1";				//设置加载文档类型 0 锁定文档，1无痕迹模式，2带痕迹模式
                WebOfficeObj.ShowMenu = 0;
                WebOfficeObj.ShowToolBar = 0;
                // WebOfficeObj.SetCaption(WebOfficeObj.UserName + "正在编辑文档");
                SetGraySkin();			//设置控件皮肤
                if(WebOfficeObj.WebOpen())
                {
                    StatusMsg(WebOfficeObj.Status);
                }
            }
            catch(e){
                StatusMsg(e.description);
            }
        }

        //保存文档
        function SaveDocument()
        {
            if (!$("#addForm").valid()) {
                return;
            }
            var wh = $("#addForm input[name='wh']").val();
            var bt = $("#addForm input[name='bt']").val();
            var id = $("#addForm input[name='id']").val();
            console.log(wh + "==================" + bt);
            WebOffice.RecordID = '{"wh":"' + wh + '","bt":"' + bt + '","id":"' + id + '"}';
            if (WebOfficeObj.WebSave()){    //交互OfficeServer的OPTION="SAVEFILE"
                WebOfficeObj.WebClose();
                window.close();
            }else{
                alert(WebOfficeObj.Status);
                StatusMsg(WebOfficeObj.Status);
            }
        }

        //设置页面中的状态值
        function StatusMsg(mValue) {
            try {
                document.getElementById('StatusBar').value = mValue;
            } catch (e) {
                return false;
            }
        }

        //烟枪灰皮肤
        function SetGraySkin(){
            //参数顺序依次为：控件标题栏颜色、自定义菜单开始颜色、自定义工具栏按钮开始颜色、自定义工具栏按钮结束颜色、
            //自定义工具栏按钮边框颜色、自定义工具栏开始颜色、控件标题栏文本颜色（默认值为：0x000000）
            if (!WebOfficeObj.WebSetSkin(0xdbdbdb, 0xeaeaea, 0xeaeaea, 0xdbdbdb, 0xdbdbdb, 0xdbdbdb, 0x000000))
                alert(WebOfficeObj.Status);
        }

        function OnUnLoad(){
            WebOfficeObj.WebClose();
        }

        //前后台交互，key在后台接收
        function SendMessage()
        {
            var info = window.prompt("请输入要传到服务器处理页面上的内容:","参数内容");
            if (info==null){return false}
            WebOfficeObj.WebSetMsgByName("TESTINFO",info);  //USERNAME在后获取
            if(WebOfficeObj.WebSendMessage()){  		// 交互信息为INPORTTEXT
                alert(WebOfficeObj.WebGetMsgByName("RETURNINFO")); //USERNAME值为对应后台的key
            }else{
                alert("客户端Web发送数据包命令没有合适的处理函数");
            }
        }
    </script>

    <script language="javascript" for="WebOffice" event="OnReady()">
        WebOfficeObj.setObj(document.getElementById('WebOffice'));//给2015对象赋值
        Load();//避免页面加载完，控件还没有加载情况
    </script>

    <!--以下是多浏览器的事件方法 -->
    <script>
        function OnReady(){
            WebOfficeObj.setObj(document.getElementById('WebOffice'));//给2015对象赋值
            //Load();//避免页面加载完，控件还没有加载情况
            window.onload = function(){Load();} //IE和谷歌可以直接调用Load方法，火狐要在页面加载完后去调用
        }
    </script>

</head>

<body  onbeforeunload="OnUnLoad()" onUnload="OnUnLoad();">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-xs-24 col-sm-24 col-md-24 col-lg-24">
            <div class="ibox float-e-margins">
                <div class="ibox-content" style="height: 300px">
                    <form id="addForm" class="form-horizontal">
                        <input type="hidden" name="id">
                        <div class="form-group form-group-sm">
                            <div class="input-tip">
                                <label class="col-xs-3 col-sm-3 col-md-3 col-lg-3 control-label">文号</label>
                                <div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
                                    <input class="form-control required" name="wh" placeholder="请输入文号"/>
                                </div>
                            </div>
                            <div class="input-tip">
                                <label class="col-xs-3 col-sm-3 col-md-3 col-lg-3 control-label">标题</label>
                                <div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
                                    <input class="form-control required" name="bt" placeholder="请输入标题"/>
                                </div>
                            </div>
                            <div class="input-tip">
                                <label class="col-xs-3 col-sm-3 col-md-3 col-lg-3 control-label">发布时间</label>
                                <div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
                                    <input class="form-control required date" name="fbsj" placeholder="请输入发布时间"/>
                                    <i class="dateicon"></i>
                                </div>
                            </div>
                        </div>
                        <div class="form-group form-group-sm hide" id="check">
                            <div class="input-tip">
                                <label class="col-xs-3 col-sm-3 col-md-3 col-lg-3 control-label">文号</label>
                                <div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
                                    <input class="form-control required" name="wh" placeholder="请输入文号"/>
                                </div>
                            </div>
                            <div class="input-tip">
                                <label class="col-xs-3 col-sm-3 col-md-3 col-lg-3 control-label">标题</label>
                                <div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
                                    <input class="form-control required" name="bt" placeholder="请输入标题"/>
                                </div>
                            </div>
                            <div class="input-tip">
                                <label class="col-xs-3 col-sm-3 col-md-3 col-lg-3 control-label">发布时间</label>
                                <div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
                                    <input class="form-control required date" name="fbsj" placeholder="请输入发布时间"/>
                                    <i class="dateicon"></i>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-24 col-sm-24 col-md-24 col-lg-24">
                                <button type="button" class="btn btn-primary" onclick="SaveDocument()"
                                        modal="enter"></span><span>&nbsp;保存&nbsp;</span>
                                </button>&nbsp;&nbsp;
                                <button type="button" class="btn btn-primary" onclick="WebOpenLocal()"
                                        modal="enter"></span><span>&nbsp;打开本地文件&nbsp;</span>
                                </button>&nbsp;&nbsp;
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="ibox float-e-margins">
            </div>
        </div>
    </div>
</div>
<div style="width: 100%; height: 100%">
    <div style="width: 100%;">
        <input style="color:Red;" type=button value="有进度条打开文档" onclick="OnUnLoad();Load()">
        <input style="color:Red;" type=button value="保存文档到服务器" onclick="SaveDocument()">
        <input style="color:Red;" type=button value="前后台交互信息" onclick="SendMessage()">
        <input style="color:Red;" type=button value="打开本地文档(有窗口)" onclick="WebOfficeObj.WebOpenLocal()">
        <input style="color:Red;" id="StatusBar" type="text" name="StatusBar" readonly  style="WIDTH:40%">&nbsp;|←状态信息
    </div>
    <div style="width: 100%; height: 80%;" ><script src="/view/common/plugs/jinge/iWebOffice2015.js"></script></object></div>
</div>
</body>
<script language="javascript">
    var i = document.getElementById('WebOffice').height =document.documentElement.clientHeight-50 +"px";
    document.getElementById('WebOffice').style.height = i;
    window.onresize = function(){
        var i = document.getElementById('WebOffice').height =document.documentElement.clientHeight-50 +"px";
        document.getElementById('WebOffice').style.height = i;
    };
</script>
</html>