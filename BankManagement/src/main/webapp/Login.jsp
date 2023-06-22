<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel = "stylesheet" href = "External.css"></link>
<style>
#own{
width:350px;
height:250px;
background-color: cyan;
margin-top:150px;
}
input{
width:180px;
height:25px;
border:3px black solid;
font-size: 15px;
}
h2{
font-size: 30px;
}
#a
{
width:80px;
height:25px;
border:black 2px solid ;
margin-left:50px;
}
#b
{
color:black;
font-size: 20px;
}
</style>
</head>
<body>
<center>
<div id="own">
<h2>Login</h1>
<form action="login" method="post">
<input type="text" placeholder="enter the accountnumber" name="accno" required="required"><br><br>
<input placeholder="enter the password" name="pwd" required="required"><br><br>
<input id="a" type="submit" value="Login">&nbsp&nbsp<a id="b"href="Registration.jsp">NotRegistered yet?</a>
</form>
</div>
<link rel = "stylesheet" href = "External.css"></link>
<%String no=(String)request.getAttribute("msg1");
if(no!=null)
{%>
<h1 style="color:red"><%=no %></h1>
<%} %>
</center>
</body>
</html>