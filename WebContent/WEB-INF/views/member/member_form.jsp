<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script src="../js/bootstrap.min.js"></script>
<title>Member form</title>
</head>
<body>
	<spring:url value="/member/save" var="saveURL" />

	<form:form modelAttribute="memberForm" method="POST"
		action="${saveURL}">
		<form:hidden name="${_csrf.parameterName}" value="${_csrf.token}" path="Id" />
Firstname: <form:input path="name" />
		</br>
Last name: <form:input path="lName" />
		</br>
Adress: <form:input path="adress" />
		</br>
City: <form:input path="city" />
		</br>
Username: <form:input path="userName" />
		</br>
		</br>
		<button type="submit">Save</button>

	</form:form>
</body>
</html>

<!-- 36.24 -->