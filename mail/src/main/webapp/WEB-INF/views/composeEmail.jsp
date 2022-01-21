<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: lightblue">
<h2 style="color:blue; ">Compose>> </h2>
<form action="./compose" method="post">
From: <input type="text" name="from_Id" required="required"> <br> <br>
To: <input type="text" name="to_Id" > <br> <br>
Subject: <input type="text" name="subject" > <br> <br>
Message: <br> <br>
<textarea rows="20" cols="90" name="message"></textarea> <br> <br>
<input type="submit" value="send" name="status">
<input type="submit" value="saveToDraft" name="status">
</form>
</body>
</html>