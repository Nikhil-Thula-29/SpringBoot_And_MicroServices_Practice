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
<h1 style="color:blue;text-align:center">JobSeeker Registration Form</h1>
<frm:form action="js_register" method="POST" modelAttribute="jsdet" enctype="multipart/form-data"> 


<table border="0" bgcolor="cyan" align="center">
<tr>
<td>JobSeeker Name:: </td>
<td><frm:input path="jsName"/></td>
</tr>

<tr>
<td>JobSeeker Address:: </td>
<td><frm:input path="jsAddrs"/></td>
</tr>

<tr>
<td>JobSeeker Qualification:: </td>
<td><frm:input path="jsQlfy"/></td>
</tr>

<tr>
<td>Select Resume:: </td>
<td><frm:input type="file" path="resume"/></td>
</tr>

<tr>
<td>Select Photo:: </td>
<td><frm:input type="file" path="photo"/></td>
</tr>

<tr>
<td><input type="submit" value="register"></td>
</tr>

</table>
</frm:form>
</body>
</html>