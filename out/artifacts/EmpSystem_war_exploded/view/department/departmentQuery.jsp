<%--
  Created by IntelliJ IDEA.
  User: wangh
  Date: 2020/5/22
  Time: 11:20
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

<form    class="form-inline">
    <div class="row alert alert-info" style="margin:0px; padding:0px; padding-left:50px;">
        <div class="form-group">
            <label>部门名称</label>
            <input type="text" class="form-control" placeholder="请输入部门名称">

        </div>
        <input type="submit" class="btn btn-danger" value="查询">
        <a href="departmentAdd.jsp" class="btn btn-success">添加部门信息</a>
    </div>
    <div class="row"  style="padding:15px;">
        <table class="table" >
            <tr>
                <th>部门编号</th>
                <th>部门名称</th>
                <th>部门描述</th>
                <th>操作</th>
            </tr>
            <tr>
                <td>10001</td>
                <td><a href="departmentInfo.jsp">技术部</a></td>
                <td>java程序员</td>
                <td>
                    <a href="departmentUpdate.jsp">修改</a>
                    <a href="#">删除</a>
                </td>
            </tr>
            <tr>
                <td>10001</td>
                <td><a href="departmentInfo.jsp">技术部</a></td>
                <td>java程序员</td>
                <td>
                    <a href="departmentUpdate.jsp">修改</a>
                    <a href="#">删除</a>
                </td>
            </tr>            <tr>
            <td>10001</td>
            <td><a href="departmentInfo.jsp">技术部</a></td>
            <td>java程序员</td>
            <td>
                <a href="departmentUpdate.jsp">修改</a>
                <a href="#">删除</a>
            </td>
        </tr>            <tr>
            <td>10001</td>
            <td><a href="departmentInfo.jsp">技术部</a></td>
            <td>java程序员</td>
            <td>
                <a href="departmentUpdate.jsp">修改</a>
                <a href="#">删除</a>
            </td>
        </tr>            <tr>
            <td>10001</td>
            <td><a href="departmentInfo.jsp">技术部</a></td>
            <td>java程序员</td>
            <td>
                <a href="departmentUpdate.jsp">修改</a>
                <a href="#">删除</a>
            </td>
        </tr>            <tr>
            <td>10001</td>
            <td><a href="departmentInfo.jsp">技术部</a></td>
            <td>java程序员</td>
            <td>
                <a href="departmentUpdate.jsp">修改</a>
                <a href="#">删除</a>
            </td>
        </tr>
        </table>

    </div>
</form>

</body>
</html>

