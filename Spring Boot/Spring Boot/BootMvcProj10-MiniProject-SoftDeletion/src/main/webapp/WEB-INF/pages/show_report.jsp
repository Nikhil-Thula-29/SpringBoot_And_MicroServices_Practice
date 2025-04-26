<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reports</title>
</head>
<body>
<c:choose>
<c:when test="${!empty empInfo}">
<table bgcolor="yellow" border="1" align="center">
<tr>
<th>EMPNO</th><th>EMPNAME</th><th>JOB</th><th>SALARY</th><th>DEPTNO</th><th>OPERATIONS</th>
</tr>
<c:forEach var="emp" items="${empInfo}">
<tr bgcolor="pink">
<td>${emp.empno}</td>
<td>${emp.ename}</td>
<td>${emp.job}</td>
<td>${emp.sal}</td>
<td>${emp.deptno}</td>
<td>
	<a href="edit?no=${emp.empno}"><img src="images/edit.jpeg" width="35" height="35"></a>
	<a href="delete?no=${emp.empno}"><img src="images/delete.png" width="35" height="35" onclick="return confirm('are sure you want to delete this record?')"></a>
</td>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
<h1 style="color:red;text-align:center">Records not found</h1>
</c:otherwise>
</c:choose>

<h2 style="text-align:center;color:green">${resultMsg}</h2>

<h1 style="color:red;text-align:center"><a href="register"><img src="images/add.jpeg" width="50" height="65"></a> &nbsp;&nbsp;
										<a href="./"><img src="images/home.png" width="90" height="90"></a></h1>
</body>
</html>