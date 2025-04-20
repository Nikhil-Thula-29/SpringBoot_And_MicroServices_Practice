<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="sp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<h1 style="text-align:center"><sp:message code="home.title"></sp:message></h1>
<br>
<br>
<h3 style="text-align:center"><a href="register"><sp:message code="home.link"></sp:message></a></h3>

<br><br>
<p style="text-align:center">
<a href="?lang=en_US">English</a>&nbsp;&nbsp;	<!-- takes default myfiles.properties -->
<a href="?lang=de_DE">German</a>&nbsp;&nbsp;
<a href="?lang=hi_IN">Hindi</a>&nbsp;&nbsp;
<a href="?lang=zh_CN">Chinese</a>&nbsp;&nbsp;
</p>
</body>
</html>