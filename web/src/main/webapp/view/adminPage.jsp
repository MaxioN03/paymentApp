<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Admin page</title>
	<link rel="stylesheet" type="text/css" href="../css/style.css">
	<link rel="stylesheet" type="text/css" href="../css/tabs.css">
	<script src="../js/tabs.js"></script>
	<script>
        function openTab(evt, tabName) {
            var i, tabcontent, tablinks;
            tabcontent = document.getElementsByClassName("tabcontent");
            for (i = 0; i < tabcontent.length; i++) {
                tabcontent[i].style.display = "none";
            }
            tablinks = document.getElementsByClassName("tablinks");
            for (i = 0; i < tablinks.length; i++) {
                tablinks[i].className = tablinks[i].className.replace(" active", "");
            }
            document.getElementById(tabName).style.display = "block";
            evt.currentTarget.className += " active";
        }
	</script>
</head>
<body>
	Account list:<br><br>
	<table>
		<tr>
			<th>Account number</th>
			<th>Card id</th>
			<th>Card number</th>
			<th>User id</th>
			<th>User login</th>
			<th>Block Status</th>
		</tr>
		<c:forEach var="MainTable" items="${requestScope.get(\"mainTable\")}">
			<tr>
				<td><c:out value="${MainTable[0]}"/></td>
				<td><c:out value="${MainTable[1]}"/></td>
				<td><c:out value="${MainTable[2]}"/></td>
				<td><c:out value="${MainTable[3]}"/></td>
				<td><c:out value="${MainTable[4]}"/></td>
				<td><c:out value="${MainTable[5]}"/></td>
			</tr>
		</c:forEach>
	</table>
	<br><br><br>
	<c:out value="${requestScope.get(\"error\")}"></c:out>
<br><br><br>
<div class="tab">
  <button class="tablinks" onclick="openTab(event, 'unblockAccount')">Block/Unblock account</button>
</div>

<div id="unblockAccount" class="tabcontent">
  <form>
  	Account number:<br>
  	<select name="accNumberBlock">
		<c:forEach var="MainTable" items="${requestScope.get(\"mainTable\")}">
			<option><c:out value="${MainTable[0]}"/></option>
		</c:forEach>
  	</select><br>
	  <input type="submit" value="Block" name="command" formaction="../controller.do" formmethod="get">
	  <input type="submit" value="Unblock" name="command" formaction="../controller.do" formmethod="get">
  </form>
</div>

</body>
</html>