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
width:180px;
height:80px;
font-size: 30px;
background-color: cyan;
color:black;
}
</style>
</head>
<body>
<form action="Home.jsp">
				<input type = "Submit" value = "HOME" style = "border-radius : 30px; height : 80px;"></input>
			</form>
<div style = "float:right">
			<form action = "LogoutController" method = "get">
			<input type = "submit" value = "LOGOUT" style = "height : 80px;width : 180px;border-radius : 40px;
			margin-left : 40px;margin-top : 10px;"></input>
			</form>
			</div>
			<br></br>
			<center>
<%String name=(String)request.getAttribute("msg");%>
<h1>welcome  <%=name %></h1>
<%RegisterDto dto=(RegisterDto)request.getAttribute("msg2");
if(dto!=null)
{%>
<h1>your Balance  <%=dto.getBalance() %></h1>
<%} %>
</center>
</body>
</html>