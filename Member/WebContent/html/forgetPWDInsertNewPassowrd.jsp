<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../CSS/RegisteredMember.css">
</head>
<body>

<form action="../forgetPWDInsertNewPassowrd.do" method="post">
<input type="hidden" name="account" value="${param.account}">
<input type="hidden" name="token" value="${param.token}">
 <fieldset>
<legend>修改密碼</legend>
<div class="div1">
<label class='label1'>舊密碼:</label><input type="text" id="oldpassword" name="oldpassword">
</div>
<div class="div1">
<label class='label1'>新密碼:</label><input type="password" id="password" name="newpassword"><span id="msg_password"></span>

</div>
<div class="div1">
<label class='label1'>請重複輸入新密碼:</label><input type="password" id="password" name="newpassword"><span id="msg_password"></span>

</div>
<div class="div1" style="text-align: center">
<input name="insert" type="submit" value="送出">

</div>

</fieldset>
</form>
</body>
</html>