<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel = "stylesheet" href = "External.css"></link>
</head>
<body>
<center>
<h1 style = "font-size : 50px;"><marquee>WELCOME TO BANK OF Business!!!</marquee></h1>
<%String no=(String)request.getAttribute("msg");%>
<h2 style = "color : green;">your AccountNumber is  <%=no %></h1>
</center>
</body>
</html>