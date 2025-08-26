<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 style="color:red">${errorMsg }</h2>
<form action="login" method="post">
<input type="text" name="uname" placeholder="Enter the user name">
<input type="text" name="pwd" placeholder="Enter the Password">
<input type="submit" value="Login">
</form>
</body>
</html>