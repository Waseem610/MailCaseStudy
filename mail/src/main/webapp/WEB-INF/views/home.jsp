<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<html>
<body style="background-color: Lightgreen">
<br>
<br>
<center>
<h2 style="color: green;">Welcome to Mail</h2>
<form action="./login" method="post">
Username: <input type="text" name="userName" placeholder="Username" required="required"><br> <br>
Password: <input type="password" name="password" placeholder="Password" required="required"><br> <br>
<input type="submit" value="Login">
</form>
<a href="./forgotPassword">Forgot Password?</a><br>
<a href="./createAccount"> Create new account?</a>
<br> <br>
</center>
</body>
</html>

</body>
</html>