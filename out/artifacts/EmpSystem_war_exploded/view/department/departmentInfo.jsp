<%--
  Created by IntelliJ IDEA.
  User: wangh
  Date: 2020/5/22
  Time: 11:22
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
    <div class="row">
        <div class="col-sm-7">
            <div class="form-group">
                <label class="col-sm-3 control-label">部门名称</label>
                <div  class="col-sm-9">
                    <p class="form-control-static">技术部</p>
                </div>
            </div>
        </div>
        <div class="col-sm-7">
            <div class="form-group">
                <label class="col-sm-3 control-label">部门描述</label>
                <div  class="col-sm-9">
                    <p class="form-control-static">全部都是java程序员</p>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-3 col-sm-offset-3">
            <a href="departmentQuery.jsp" class="btn btn-warning">返回上一级</a>
        </div>
    </div>


</form>

</body>
</html>

