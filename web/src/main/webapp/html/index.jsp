<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
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
        <input type="submit" value="Enter" name="button" formaction="../controller.do" formmethod="get">
    </form>
</form>

<c:set var="salary" scope="session" value="${2002*2}"/>

<c:if test="${salary > 2000}">
<p>My salary is: <c:out value="${salary}"/><p>
</c:if>

</body>
</html>