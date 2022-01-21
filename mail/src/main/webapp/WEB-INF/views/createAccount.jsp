<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: pink;">
<br>
<br>

<center>
<h1 style="color: blue;">Welcome to Mail</h1>
<form action="./createAccount" method="post">
Username:      <input type="text" name="userName" placeholder="Username" required="required"><br> <br>
Email Address: <input type="email" name="email" placeholder="Email Address" required="required"> <br> <br>
Password:      <input type="password" name="password" placeholder="Password" required="required"><br> <br>
<input type="submit" value="SignUp">
</form>
</body>
</html>
</center>