<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css" />

 
 <link href="${contextPath}/resources/css/common.css" rel="stylesheet">


<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<h3>Authorised Users Only!</h3>

<table class="formtable">
<tr><td>Username</td><td>Email</td><td>Enabled</td></tr>

<c:forEach var="user" items="${users}">
<td><c:out value="${user.username}"></c:out></td>
<td><c:out value="${user.email}"></c:out></td>
<td><c:out value="${user.enabled}"></c:out></td>
</tr>

</c:forEach>

</table>
</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>