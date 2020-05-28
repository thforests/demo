<%--
  Created by IntelliJ IDEA.
  User: wangh
  Date: 2020/5/22
  Time: 11:13
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

<form  class="form-horizontal" id="formData">
    <h5 class="page-header alert-info" style="margin:0px; padding:10px; margin-bottom:10px;">
        基本信息
    </h5>
    <!-- 111 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">员工姓名</label>
                <div  class="col-sm-9">
                    <input type="text" class="form-control" value="${requestScope.employee.empName}" id="empName" name="empName" placeholder="请输入员工姓名"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">员工年龄</label>
                <div  class="col-sm-9">
                    <input type="text" class="form-control" id="empAge" value="${requestScope.employee.empAge}"  name="empAge" placeholder="请输入员工年龄"/>
                </div>
            </div>
        </div>
    </div>
    <!-- 111 -->
    <!-- 222 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">员工编号</label>
                <div  class="col-sm-9">
                    <input type="text" class="form-control" id="empNum" value="${requestScope.employee.empId}" name="empNum" placeholder="请输入员工编号"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">联系方式</label>
                <div  class="col-sm-9">
                    <input type="text" class="form-control" id="empPhone" value="${requestScope.employee.phone}" name="empPhone" placeholder="请输入电话号码"/>
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
                    <select class="form-control" id="empSex" value="${requestScope.employee.empSex}" name="empSex">
                        <option>保密</option>
                        <option selected>男</option>
                        <option>女</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">员工部门</label>
                <div  class="col-sm-9">
                    <input type="text" class="form-control" id="depNumber" value="技术" name="depNumber" placeholder="请输入员工部门"/>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户级别</label>
                <div  class="col-sm-9">
                    <input type="text" class="form-control" id="empLeval" value="${requestScope.employee.level}" name="empLevel" placeholder="请输入用户级别"/>
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
                    <input type="text" class="form-control" id="name" name="name" value="${requestScope.employee.username}" placeholder="请输入员工帐号"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">员工密码</label>
                <div  class="col-sm-9">
                    <input type="text" class="form-control" id="pwd" name="pwd"  value="${requestScope.employee.password}" placeholder="请输入员工密码"/>
                </div>
            </div>
        </div>
    </div>
    <!-- 2222 -->

    <div class="row">
        <div class="col-sm-3 col-sm-offset-4">
            <input type="button" id="btn" class="btn btn-success" value="修改员工">
            <input type="reset" class="btn  btn-danger" value="重置信息">
        </div>
    </div>
</form>

<script>
    $(function () {

        $("#btn").click(function () {
            var empName=$("#empName").val().toString().trim();
            if(empName !==""){
                $.ajax({
                    type:"POST",
                    url:"employeeServlet?method=updateEmp",
                    data:$("#formData").serialize(),
                    dataType:"JSON",
                    success:function (result) {
                        /*window.alert(result.msg);*/
                        if(result.msg){
                            window.alert("修改成功");
                            window.location.href="employeeQuery.jsp"
                        }else {
                            window.alert("修改失败");
                        }
                    },
                    error:function (xth,errorMsg,error) {

                    }
                });
            }else {
                window.alert("输入框不能为空！！！")
            }

        });

    });
</script>

</body>
</html>
