<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
<form action="register" method="POST" >
<table border="0" bgcolor="cyan" align="center">

<tr>
<td>Student Id:: </td>
<td><input type="text" name="sno"></td>
</tr>

<tr>
<td>Student Name:: </td>
<td><input type="text" name="sname"></td>
</tr>

<tr>
<td>Student Address:: </td>
<td><input type="text" name="sadd"></td>
</tr>

<tr>
<td>Student Average:: </td>
<td><input type="text" name="avg"></td>
</tr>

<tr>
<td colspan="2"><input type="submit" value="register button"></td>
</tr>

</table>
</form>
</body>
</html>