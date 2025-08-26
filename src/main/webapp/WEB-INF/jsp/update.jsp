<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="update" method="post">
<input type="hidden" name="id" placeholder="Enter the ID" value = "${cust.id }">
<input type="text" name="name" placeholder="Enter the Name" value = "${cust.name }">
<input type="text" name="address" placeholder="Enter the the Address " value = "${cust.address }">
<input type="text" name="doc" placeholder="Enter the Date of Creation" value = "${cust.doc }">
<input type="text" name="type" placeholder="Enter the Type od Account" value = "${cust.type }">
<input type="text" name="balance" placeholder="Enter the Balance" value = "${cust.balance }">
<input type="text" name="minbal" placeholder="Enter the minimum balance" value = "${cust.minbal }">
<input type="text" name="status" placeholder="Enter the Account Status" value = "${cust.status }">
<input type="submit" value="Update Record">
</form>
</body>
</html>