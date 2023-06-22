<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel = "stylesheet" href = "External.css"></link>
<style >
#own{
width:500px;
height:700px;
background-color: darkslateblue;
padding-left: 50px;
}
h1{
font-size: 45px;
color:cyan;
}
input{
width:200px;
height:25px;
border:black 2px solid ;
margin-left:50px;
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
color:red;
position:absolute;
top:300px;
left:1200px;
}
</style>
</head>
<body>
<center>
<div id="own">
<form action="register" method="post">
<h1>Registration</h1>
<label>Firstname</label>
<input type="text" placeholder="enter the first name" name="firstname" required="required"><br><br>
<label>Lastname</label>
<input type="text" placeholder="enter the last name" name="lastname"><br><br>
<label>Mobileno</label>
<input type="number" placeholder="enter the mobile" name="mobile" required="required"><br><br>
<label>Pancard</label>
<input type="text" placeholder="enter the pancard" name="pancard" required="required"><br><br>
<label>Aadhar</label>
<input type="text" placeholder="enter the aadhar" name="aadhar" required="required"><br><br>
<label>Email</label>
<input type="email" placeholder="enter the email" name="email" required="required"><br><br>
<label>Address</label>
<input type="text" placeholder="enter the address" name="address" required="required"><br><br>
<label>DOB</label>
<input type="date" placeholder="enter the date of birth" name="dob" required="required"><br><br>
<label>Gender</label>
<input type = "radio" name = "gender" value="M" class = "r">&nbsp&nbsp<label>Male</label></input>
<input type = "radio" name = "gender" value="F" class = "r">&nbsp&nbsp<label>Female</label></input><br><br>
<label>AccountType</label>
<input type = "radio" name = "accounttype" value="SB" class = "r">&nbsp&nbsp<label>SB</label></input>
							&nbsp&nbsp&nbsp&nbsp
<input type = "radio" name = "accounttype" value="FD" class = "r">&nbsp&nbsp<label>FD</label></input><br><br>
<label>Password</label>
<input type="password" placeholder="enter the password" name="password" required="required"><br><br>
<label>Amount</label>
<input type="number" placeholder="enter the amount" name="balance" required="required" ><br><br>
<input id="a" type="submit">&nbsp&nbsp&nbsp&nbsp<input id="a" type="reset" value="clear">
</form>
<a href = "Login.jsp" ><input type="submit" value="Registered? Login"></a>
<%String no=(String)request.getAttribute("acno");
if(no!=null)
{%>
<h1 id="b"><%=no %></h1>
<%} %>
</div>
</center>

</body>
</html>