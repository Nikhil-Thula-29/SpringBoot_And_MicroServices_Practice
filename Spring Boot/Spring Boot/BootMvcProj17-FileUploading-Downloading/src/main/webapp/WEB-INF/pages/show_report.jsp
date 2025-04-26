<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reports</title>
</head>
<body>
<c:choose>
<c:when test="${!empty jsinfo}">
<h1 style="color:red;text-align:center">JobSeeker Report</h1>
<table border="1" bgcolor="cyan" align="center">
<tr>
<th>JsId</th><th>JsName</th><th>JsAddress</th><th>Qualification</th><th>download resume</th><th>download photo</th>
</tr>
<c:forEach var="js" items="${jsinfo}">
<tr>
<td>${js.jsid}</td>
<td>${js.jsName}</td>
<td>${js.jsAddrs}</td>
<td>${js.jsQlfy}</td>
<td><a href="download?id=${js.jsid}&type=resume">download</a></td>
<td><a href="download?id=${js.jsid}&type=photo">download</a></td>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
<h1 style="color:red;text-align:center">Records not found</h1>
</c:otherwise>
</c:choose>
</body>
</html>