<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
<frm:form action="register" method="POST"  modelAttribute="stud">
<table border="0" bgcolor="cyan" align="center">

<tr>
<td>Student Id:: </td>
<td><frm:input path="sno"/></td>
</tr>

<tr>
<td>Student Name:: </td>
<td><frm:input path="sname"/></td>
</tr>

<tr>
<td>Student Address:: </td>
<td><frm:input path="sadd"/></td>
</tr>

<tr>
<td>Student Average:: </td>
<td><frm:input path="avg"/></td>
</tr>

<tr>
<td colspan="2"><input type="submit" value="register button"></td>
</tr>

</table>
</frm:form>
</body>
</html>