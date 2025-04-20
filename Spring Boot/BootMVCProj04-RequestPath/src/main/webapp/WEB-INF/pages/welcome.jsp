<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<h1 style="color:red;text-align:center">Welcome Page</h1>
<a href="getreport">Get Report</a>
<form action="postreport" method="POST">
	<input type="submit" value="submit">
</form>
</body>
</html>