<%--
  Created by IntelliJ IDEA.
  User: wangh
  Date: 2020/5/22
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>部门管理</title>
    <link href="../../static/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <script src="../../static/js/jquery-1.9.1.min.js"></script>
    <script src="../../static/assets/js/bootstrap.min.js"></script>
</head>

<body>

<form  class="form-horizontal">
    <h5 class="page-header alert-info" style="margin:0px; padding:10px; margin-bottom:10px;">
        基本信息
    </h5>

    <!-- 111 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">员工姓名</label>
                <div  class="col-sm-9">
                    <p class="form-control-static">张三</p>

                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">员工年龄</label>
                <div  class="col-sm-9">
                    <p class="form-control-static">18</p>

                </div>
            </div>
        </div>
    </div>
    <!-- 111 -->
    <!-- 222 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">员工年龄</label>
                <div  class="col-sm-9">
                    <p class="form-control-static">18</p>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">电话号码</label>
                <div  class="col-sm-9">
                    <p class="form-control-static">199999999999999</p>


                </div>
            </div>
        </div>
    </div>
    <!-- 2222 -->
    <!-- 3333 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">员工性别</label>
                <div  class="col-sm-3">
                    <p class="form-control-static">男</p>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">电子邮件</label>
                <div  class="col-sm-9">
                    <p class="form-control-static">12313213@qq.com</p>

                </div>
            </div>
        </div>
    </div>
    <!-- 3333 -->
    <h5 class="page-header alert-info" style="margin:0px; padding:10px; margin-bottom:10px;">
        账户信息
    </h5>
    <!-- 222 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">员工帐号</label>
                <div  class="col-sm-9">
                    <p class="form-control-static">zhangsan</p>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">员工密码</label>
                <div  class="col-sm-9">
                    <p class="form-control-static">admin</p>

                </div>
            </div>
        </div>
    </div>
    <!-- 2222 -->

    <div class="row">
        <div class="col-sm-3 col-sm-offset-4">
            <a href="employeeQuery.jsp" class="btn btn-warning">返回上一级</a>
        </div>
    </div>


</form>

</body>
</html>

