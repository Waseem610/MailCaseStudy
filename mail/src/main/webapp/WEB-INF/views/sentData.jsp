<%@page import="com.te.mail.mailinfo.Mail_Info"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: lightgreen">

<% List<Mail_Info> list=(List<Mail_Info>)request.getAttribute("sent"); %>

<h2 style="color: green;">Sent</h2>
<hr> <hr>
<%for(Mail_Info info:list){ %>
<h4>To:<%=info.getTo_Id() %></h4>
<h4>subject:<%=info.getSubject() %></h4>
<h4>Message:<%=info.getMessage() %></h4>

<hr>
<%} %>
</body>
</html>