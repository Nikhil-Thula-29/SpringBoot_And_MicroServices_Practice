<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page isELIgnored="false"  import="java.util.*"%> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<h1 style="color:red;text-align:center">Welcome Page</h1>
The name is:: ${name}
The age is:: ${age}
<br>

<%-- <%= %> this is expression tag --%>
<%-- <% %> this is scriplet tag used for writing java --%>


<%-- nickNames are :: <%=Arrays.toString(((String[])request.getAttribute("nickNames")))%> --%>
<%-- The String array is:: ${nickNames} --%>   <!-- error -->
<!-- It is not good to write java code in jsp so use jstl lib by adding apache jstl depency -->



<%-- <br>
The List is:: ${friends}
<br>
The set is:: ${phoneNumbers}
<br>
The Map is:: ${idDetails} --%>

<!-- through jstl -->

<%-- <c:if test="${!empty nickNames}">
<br>
<b>the nicknames are:: </b>
<c:forEach var="nick" items="${nickNames}">
	${nick}
</c:forEach>
</c:if>


<c:if test="${!empty friends}">
<br>
<b>the Friends are:: </b>
<c:forEach var="fr" items="${friends}">
	${fr},
</c:forEach>
</c:if>


<c:if test="${!empty phoneNumbers}">
<br>
<b>the PhoneNumbers are:: </b>
<c:forEach var="phno" items="${phoneNumbers }">
	${phno},
</c:forEach>
</c:if>

<c:if test="${!empty idDetails}">
<br>
<b>the IdDetails are:: </b>
<c:forEach var="iddet" items="${idDetails}">
	${iddet}
</c:forEach>
</c:if> --%>

<%-- <b>Emp Data:: ${empsData}</b>
<br>
<c:if test="${!empty empsData}">
<b>Emp Data:: ${empsData}</b>
</c:if> --%>



<c:choose>
<c:when test="${!empty empslistData}">
<table bgcolor="yellow" align="center" border="1">
<tr><th>eno</th> <th>ename</th> <th>eaddrs</th> <th>salary</th></tr>
<c:forEach var="emp" items="${empslistData}">
<tr>
<td>${emp.eno}</td>		<!-- here eno,ename,eaddrs is matching with model variable name -->
<td>${emp.ename}</td>
<td>${emp.eaddrs}</td>
<td>${emp.salary}</td>
</tr>
</c:forEach>
</table>
</c:when>
</c:choose>
</body>
</html>