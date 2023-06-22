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
#a{
width:180px;
height:40px;
font-size:20px;
background-color:black;
color:white;
}
#b{
width:400px;
height:200px;
margin-left:450px;
margin-top: 100px;
padding-left: 180px;
padding-top: 30px;
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

<div id="b">
<form action="transfer" method="post">
<input id="a" type="text" placeholder="enter the accno" name="raccno"><br><br>
<input id="a" type="number" placeholder="enter the amount" name="amt"><br><br>
<input id="a" type="submit" value="Transfer">
</form>
</div>
<center>
<%String status=(String)request.getAttribute("status");
if(status!=null)
{%>
<h1 style="color:green"><%=status %></h1>
<%} %>
</center>
</body>
</html>