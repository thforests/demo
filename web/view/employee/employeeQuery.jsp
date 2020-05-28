<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>员工管理</title>
    <link href="../../static/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <script src="../../static/js/jquery-1.9.1.min.js"></script>
    <script src="../../static/assets/js/bootstrap.min.js"></script>
</head>

<body>

<form class="form-inline">
    <div class="row alert alert-info" style="margin:0px; padding:0px; padding-left:50px;">
        <div class="form-group">
            <label>员工编号</label>
            <input type="text" class="form-control" placeholder="请输入员工编号">
            <label>员工姓名</label>
            <input type="text" class="form-control" placeholder="请输入员工姓名">
            <label>员工帐号</label>
            <input type="text" class="form-control" placeholder="请输入员工帐号">
        </div>
        <input type="submit" id="btnSelect" class="btn btn-danger" value="查询">
        <a href="employeeAdd.jsp" class="btn btn-success">添加员工</a>
    </div>
    <div class="row"  style="padding:15px;">
        <table class="table" >
            <tr>
                <th>员工编号</th>
                <th>员工姓名</th>
                <th>员工性别</th>
                <th>部门名称</th>
                <th>员工年龄</th>
                <th>电话号码</th>
                <th>员工帐号</th>
                <th>操作</th>
            </tr>

            <tbody class="trs">

            </tbody>

        </table>

        <script type="text/javascript">
            $(function () {
                getAjax();

                $("btnSelect").click(function () {
                    var emp_id = $("#emp_id").val();
                    if(emp_id.toString().trim()!=null) {
                        $.ajax({
                            type: "POST",
                            url: "employeeServlet?method=selectM",
                            data: {"emp_id": emp_id.toString().trim()},
                            dataType: "JSON",
                            success: function (result) {
                                if (result.length > 0) {
                                    window.alert("成功 " + result.length);
                                    $(".trs").empty();
                                    var strs = "";
                                    $.each(result, function (i, obj) {
                                        strs = "<tr><td>" + obj.empId + "</td><td><a href='employeeInfo.jsp'>" + obj.empName + " </a></td><td>" + obj.empSex + "</td><td>技术部</td><td>" + obj.empAge + "</td><td>" + obj.phone + "</td><td>" + obj.username + "</td><td><a href='employeeServlet?method=update&empId=" + obj.empId + "'>修改</a>|<a href='employeeServlet?method=delete&empId=" + obj.empId + "'>删除</a></td></tr>";
                                        $(".trs").append(strs);
                                    });
                                } else {
                                    window.alert("输入框不能为空");
                                }
                            },
                            error: function (xth, errorMsg, error) {

                            }
                        });
                    }else{
                        window.alert("失败");
                    }
                });


            function getAjax() {
                $.ajax({
                    type: "POST",
                    url: "employeeServlet",//
                    data: {"method": "select"},
                    dataType: "JSON",
                    success: function (result) {
                        console.log(result);
                        if (result != null) {
                            var strs = "";
                            $.each(result, function (i, obj) {
                                console.log(i, obj.empId + " : " + obj.empName);
                                strs = "<tr><td>" + obj.empId + "</td><td><a href='employeeInfo.jsp'>" + obj.empName + " </a></td><td>" + obj.empSex + "</td><td>技术部</td><td>" + obj.empAge + "</td><td>" + obj.phone + "</td><td>" + obj.username + "</td><td><a href='employeeServlet?method=update&empId=" + obj.empId + "'>修改</a>|<a href='employeeServlet?method=delete&empId=" + obj.empId + "'>删除</a></td></tr>";
                                $(".table").append(strs);
                            });
                        }
                    },
                    error: function (xth, errorMsg, error) {

                    }
                });
            }
            });
        </script>

    </div>
</form>

</body>
</html>

