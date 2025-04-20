<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
<h1 style="color:red;text-align:center">Global Error Page Information</h1>
<table bgcolor="cyan" align="center" border="1">
<tr>
<td>status</td>
<td>${status }</td>		<!-- these are the readymade modelattributes like status,type,timestamp -->
</tr>
<tr>
<td>message</td>
<td>${message }</td>
</tr>
<tr>
<td>type</td>
<td>${type }</td>
</tr>
<tr>
<td>timestamp</td>
<td>${timestamp }</td>
</tr>
</table>
</body>
</html>