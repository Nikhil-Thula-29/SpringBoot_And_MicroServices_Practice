<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="sp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
<h1 style="color:red;text-align:center"><sp:message code="customer.register.title"></sp:message> </h1>
<frm:form action="register" method="POST" modelAttribute="cust">
<table border="0" align="center"> 
<tr>
<td><sp:message code="customer.register.name"></sp:message> </td>
<td><frm:input path="cname"/></td>
</tr>

<tr>
<td><sp:message code="customer.register.address"></sp:message> </td>
<td><frm:input path="cadd"/></td>
</tr>

<tr>
<td><sp:message code="customer.register.billAmt"></sp:message> </td>
<td><frm:input path="billAmt"/></td>
</tr>

<tr>
<td><input type="submit" value="<sp:message code="customer.button.caption"/>"></td>
</tr>
</table>
</frm:form>

<br><br>
<p style="text-align:center">
<a href="?lang=en_US">English</a>&nbsp;&nbsp;	<!-- takes default myfiles.properties -->
<a href="?lang=de_DE">German</a>&nbsp;&nbsp;
<a href="?lang=hi_IN">Hindi</a>&nbsp;&nbsp;
<a href="?lang=zh_CN">Chinese</a>&nbsp;&nbsp;
</p>
</body>
</html>