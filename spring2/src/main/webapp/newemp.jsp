
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增员工信息</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/empsave" method="post">
    <table>
        <tr>
            <td>员工ID</td>
            <td><input type="text" name="id" /></td>
        </tr>
        <tr>
            <td>员工姓名</td>
            <td><input type="text" name="name" /></td>
        </tr>
        <tr>
            <td>员工年龄</td>
            <td><input type="text" name="age" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="新增" /> </td>
            <td><input type="reset" value="清空" /></td>
        </tr>
    </table>
</form>
</body>
</html>
