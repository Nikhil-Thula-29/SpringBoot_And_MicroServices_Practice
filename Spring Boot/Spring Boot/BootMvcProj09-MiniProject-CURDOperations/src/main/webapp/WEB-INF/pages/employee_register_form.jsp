<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>	<!-- using spring form tags -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Form</title>
</head>
<body>
<h1 style="color:blue;text-align:center">Employee Registration Form</h1>
<frm:form action="register" method="POST" modelAttribute="emp">	<!-- check action=register(/register) path -->
<table border="0" bgcolor="cyan" align="center">
<tr>
<td>Employee Name:: </td>
<td><frm:input path="ename"/></td>
</tr>

<tr>
<td>JOB:: </td>
<td><frm:input path="job"/></td>
</tr>

<tr>
<td>Employee SALARY:: </td>
<td><frm:input path="sal"/></td>
</tr>

<tr>
<td>DEPTNO:: </td>
<td><frm:input path="deptno"/></td>
</tr>

<tr>
<td><input type="submit" value="register"></td>
</tr>

</table>
</frm:form>
</body>
</html>