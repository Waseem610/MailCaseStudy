<%@page import="com.te.mail.mailinfo.Mail_Info"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table, th, td {
	border: 1px solid black;
	width: 60%
}
</style>
</head>

<body style="background-color: lightgreen">

<%String user=(String)request.getAttribute("userName"); %>
<center>
<h2 style="color: red">Welcome  <%=user %></h2>
</center>
<br> 
<a href="./sent">Sent Items</a>  <br>
<a href="./draft">Draft Items</a>  <br>
<a href="./compose">Compose Mail</a> <br>
<a href="./logout">Logout</a> <br>
<%List<Mail_Info> list=(List<Mail_Info>)request.getAttribute("inbox"); %>
<h3 style="color: blue;">Inbox</h3>
<table>
<tr>
<td>From</td>
<td>Subject</td>
<td>message</td>
</tr>
<%for(Mail_Info info:list){ %>
<tr>
<td><h4><%=info.getFrom_Id() %></h4></td>
<td><h4><%=info.getSubject() %></h4></td>
<td><h4><%=info.getMessage() %></h4></td>
</tr>




<%} %> 

</table>
</body>
</html>