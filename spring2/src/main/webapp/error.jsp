
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ERROR</title>
</head>
<body>
    <h1>ERROR:</h1>
    <h3> <%=request.getSession().getAttribute("error")%> </h3>
</body>
</html>
