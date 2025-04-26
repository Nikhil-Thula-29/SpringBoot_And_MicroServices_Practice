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
<h1 style="color:blue;text-align:center">Employee Registration Form</h1>
<frm:form action="register" method="POST" modelAttribute="emp" onsubmit="return validation(this)"> <!-- this keyword is fixed this will all DOM Object of form -->	<!-- check action=register(/register) path -->

<%-- <p style="color:red;text-align:center">		<!-- for errors -->
<frm:errors path="*"/>
</p> --%>

<table border="0" bgcolor="cyan" align="center">
<tr>
<td>Employee Name:: </td>
<td><frm:input path="ename"/><frm:errors path="ename"></frm:errors> <span id="enameErr"></span></td>
</tr>

<tr>
<td>JOB:: </td>
<td><frm:input path="job"/><frm:errors path="job"></frm:errors><span id="jobErr"></span></td>
</tr>

<tr>
<td>Employee SALARY:: </td>
<td><frm:input path="sal"/><frm:errors path="sal" ></frm:errors><span id="salErr"></span></td>
</tr>

<tr>
<td>DEPTNO:: </td>
<td><frm:select path="deptno">
<frm:options items="${dnoList}"/>
</frm:select>
<frm:errors path="deptno"></frm:errors><span id="deptErr"></span></td>
</tr>


<tr>
<td><frm:hidden path="vflag1"/> </td>
</tr>

<tr>
<td><input type="submit" value="register"></td>
</tr>

</table>
</frm:form>
</body>
</html>