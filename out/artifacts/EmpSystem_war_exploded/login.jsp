<%--
  Created by IntelliJ IDEA.
  User: Xinxin
  Date: 2020/5/22
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>员工管理系统</title>
    <link href="static/assets/css/bootstrap.min.css" rel="stylesheet" />
    <script src="static/js/jquery-1.9.1.min.js"></script>
    <script src="static/assets/js/bootstrap.min.js"></script>
    <style  type="text/css">
        body{
            background:url("static/images/bg.jpg");
            background-position:center;
            background-repeat:no-repeat;
            background-size:cover;/*让背景基于容器*/
            background-attachment:fixed;/*当内容高度大雨图片高度，背景图像的位置相对viewport固定*/
            margin-left:auto;
            margin-right:auto;
            margin-top:200px;
            width:20em;
        }
    </style>
</head>

<body>
<form id="formData">
    <div class="form-group">
        <label class="sr-only" for="userId">帐号</label>
        <div class="input-group">
            <div class="input-group-addon">帐号</div>
            <input type="text" class="form-control" name="userId" id="userId" placeholder="请输入帐号"/>
        </div>
    </div>
    <div class="form-group">
        <label class="sr-only" for="userId">密码</label>
        <div class="input-group">
            <div class="input-group-addon">密码</div>
            <input type="password" class="form-control" name="password" id="password" placeholder="请输入密码"/>
        </div>
    </div>
    <!-- 按钮-->
    <input type="button" style="width:280px;" value="登 录" class="btn btn-success"/>
</form>

<script type="text/javascript">
    $(function () {
        $(".btn").click(function () {
            var userIdValue =$("#userId").val();
            var passwordValue =$("#password").val();
            if(userIdValue.toString().trim() !="" & passwordValue.toString().trim() !=""){
                //Ajax请求
                $.ajax({
                    type:"POST",
                    url:"loginServlet",
                    data:$("#formData").serialize(),
                    dataType:"JSON",
                    success:function (result) {
                        if(result.flag){
                            window.alert("登录成功");
                            window.location.href="index.jsp";
                        }else{
                            window.alert("用户名密码输入错误！");
                            window.location.href="login.jsp";
                        }
                    },
                    error:function (xhr,errorMsg,error) {

                    }
                });
            }else {
                window.alert("输入框不能为空");
            }
        });
    });
</script>
</body>
</html>