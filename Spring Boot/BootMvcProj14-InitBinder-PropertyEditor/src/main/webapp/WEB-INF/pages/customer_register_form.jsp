<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>	<!-- using spring form tags -->
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Form</title>
<script type="text/javascript" src="js/validation.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
<h1 style="color:blue;text-align:center">Customer Registration Form</h1>
<frm:form action="register" method="POST" modelAttribute="cust"> <!-- this keyword is fixed this will all DOM Object of form -->	<!-- check action=register(/register) path -->

<%-- <p style="color:red;text-align:center">		<!-- for errors -->
<frm:errors path="*"/>
</p> --%>

<table border="0" bgcolor="cyan" align="center">

<tr>
<td>Customer No:: </td>
<td><frm:input path="cno"/></td>
</tr>

<tr>
<td>Customer Name:: </td>
<td><frm:input path="cname"/></td>
</tr>



<tr>
<td>Customer DOB(DD-MM-YYYY):: </td>
<td><frm:input path="dob"/></td>
</tr>



<tr>
<td>Customer DOJ(Joining):: </td>
<td><frm:input path="doj" type="date"/></td>
</tr>


<tr>
<td>Customer DOP(Purchase):: </td>
<td><frm:input path="dop" type="datetime-local"/></td>
</tr>


<tr>
<td>Customer TOB(Birth):: </td>
<td><frm:input path="tob" type="time"/></td>
</tr>

<tr>
<td><input type="submit" value="register"></td>
</tr>

</table>
</frm:form>
</body>
</html>