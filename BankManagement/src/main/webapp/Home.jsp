<%@page import="com.jsp.service.entity.RegisterDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel = "stylesheet" href = "External.css"></link>
<style>
input
{
width:100%;
height:40px;
font-size: 30px;
background-color: cyan;
color:black;
}
</style>
</head>
<body>
<center>
<div style = "float:right">
			<form action = "LogoutController" method = "get">
			<input type = "submit" value = "LOGOUT" style = "height : 80px;width : 180px;border-radius : 40px;
			margin-left : 40px;margin-top : 10px;"></input>
			</form>
			</div>
			<br></br>
<%String name=(String)request.getAttribute("msg");
if(name!=null)
{%>
<h1>welcome  <%=name %></h1></center>
<%} %>
<table>
			<tr>
			<td style = "padding-right : 200px;">
<form action="home" method="post">
<input type="submit" value="viewBalance">
</form>
</td>
<td style = "padding-right : 200px;">
<form action="MoneyTransfer.jsp" method="post">
<input type="submit" value="MoneyTransfer">
</form>
</td>
<td style = "padding-right : 200px;">
<form action="ViewStatement.jsp" method="post">
<input type="submit" value="Transactions">
</form>
</td>
</tr>
</table>
</body>
</html>