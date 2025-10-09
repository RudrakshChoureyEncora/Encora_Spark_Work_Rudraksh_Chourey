<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method ="post" action="login.do">
	<input type ="hidden" name = "action" value="login">
	user name:<input type="text" name="uname">
	password:<input type="password" name="upass">
	<input type ="submit" value="login..">
</form>

</body>
</html>