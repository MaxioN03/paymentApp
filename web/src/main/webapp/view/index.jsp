<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>
    <title>Index</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<form>
    <form>
        Login:<br>
        <input type="text" name="login"><br>
        Password:<br>
        <input type="password" name="password"><br>
        <input type="submit" value="Login" name="command" formaction="../controller.do" formmethod="get">
    </form>
</form>
    <c:out value="${requestScope.get(\"error\")}"></c:out>
</body>
</html>