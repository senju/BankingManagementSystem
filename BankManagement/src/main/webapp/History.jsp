<%@page import="com.jsp.service.entity.SenderDto"%>
<%@page import="java.util.List"%>
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
<table border="4" bordercolor="#ffffff" style = "font-size : 30px;background-color : black;margin-top : 100px;margin-left : 290px; font-weight : bold; color :white;
 padding:40px;">
		<tr>
			<th>Transaction ID</th>
			<th>Accountno</th>
			<th>Amount</th>
			<th>Date</th>
		</tr>
<%List<SenderDto> list=(List<SenderDto>)request.getAttribute("record");
if(list!=null)
{
	for(SenderDto senderdto:list)
	{%>
	<tr>
	            <td><%=senderdto.getTid()%></td>
	            <td><%=senderdto.getAccountno() %>
				<td><%=senderdto.getAmount()%></td>
				<td><%=senderdto.getTdate()%></td>
	</tr>		
			<%
				}
			}
			%>

</body>
</html>