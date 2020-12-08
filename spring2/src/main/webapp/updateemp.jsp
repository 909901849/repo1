
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/empupdate" method="post"  >
    <table>
        <tr>
            <td>员工ID</td>
            <td>
                ${empupdata.id}
                    <input type="hidden" name="id" value="${empupdata.id}" />
                </td>
        </tr>
        <tr>
            <td>员工姓名</td>
            <td><input type="text" name="ename" value="${empupdata.name}" /></td>
        </tr>
        <tr>
            <td>员工年龄</td>
            <td><input type="text" name="age" value="${empupdata.age}" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="修改" /> </td>
            <td><input type="reset" value="清空" /></td>
        </tr>
    </table>
</form>
</body>
</html>
