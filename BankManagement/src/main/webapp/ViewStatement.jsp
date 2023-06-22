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
#c{
font-size :30px;
	color : cyan;
	font-weight : bold;
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
<form action="history" method="post">
<label id="c">StartDate</label>
<input id="a" placeholder="YYYY-mm-dd" name="sd"><br><br>
<label id="c">EndDate</label>
<input id="a" placeholder="YYYY-mm-dd" name="ed"><br><br>
<input  id="a" type="submit">
</form>
</div>
<center>
<%String records=(String)request.getAttribute("record");
if(records!=null)
{%>
<h1 style="color:green"><%=records %></h1>
<%} %>
</center>
</body>
</html>