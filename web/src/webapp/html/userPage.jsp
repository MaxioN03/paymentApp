<!DOCTYPE html>
<html>
<head>
	<title>User page</title>
	<link rel="stylesheet" type="text/css" href="../css/style.css">
	<link rel="stylesheet" type="text/css" href="../css/tabs.css">
	<script src="../js/tabs.js"></script>
</head>
<body>
	Account list:<br><br>
	<table>
		<tr>
			<th>Account number</th>
			<th>Card number</th>
			<th>Amount, BYN</th>
			<th>Block Status</th>
		</tr>
		<tr>
			<td>3</td>
			<td>0000 0000 0000 0001</td>
			<td>150</td>
			<td>NOT Locked</td>
		</tr>
	</table>
	<br><br><br>

<div class="tab">
  <button class="tablinks" onclick="openTab(event, 'makePayment')">Make a payment</button>
  <button class="tablinks" onclick="openTab(event, 'fillAccount')">Fill account</button>
  <button class="tablinks" onclick="openTab(event, 'blockAccount')">Block account</button>
</div>

<div id="makePayment" class="tabcontent">
  <form action="servlet.do" method="post">
  Account number:<br>
  <select name="accNumber">
  	<option>1</option>
  </select><br>  
  Recipient's account number:<br>
  <input type="number" name="recAccNumber"><br>
  Amount, BYN:<br>
  <input type="number" name="amount"><br>
  Card valid thru:<br>
  <input type="text" name="validThru1" style="width: 2%; margin-right: 0.5%;"></input>
  /<input type="text" name="validThru2" style="width: 2%; margin-left: 0.5%;"></input><br>
  <input type="submit" name="button" value="Transfer"></input>

  </form>
</div>

<div id="fillAccount" class="tabcontent">
  FILL ACCOUNT
</div>

<div id="blockAccount" class="tabcontent">
  <form action="servlet.do" method="post">
  	Account number:<br>
  	<select name="accNumber">
  		<option>1</option>
  	</select><br> 
  	<p style="color: #c70000">Remember, the card will be unavailable.<br>
	Only the administrator can unlock the lock.</p>	
	<input type="submit" name="button" value="Block"></input>
  </form>
</div>

</body>
</html>