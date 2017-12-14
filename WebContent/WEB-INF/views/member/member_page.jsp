<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Member page</title>
</head>
<body>

	<h1>Members list:</h1>
	<table>
		<tr>
			<th>Name:</th>
			<th>Last name:</th>
			<th>Adress:</th>
			<th>City:</th>
			<th>Username:</th>
			<th colspan ="2">Action</th>
		</tr>
		<c:forEach items="${listMember}" var="row">
		<tr>
		
		<td>${row.name}</td>   <!-- Tagna fråm Members.java och blir lowercase -->
		<td>${row.lName}</td>
		<td>${row.adress}</td>
		<td>${row.city}</td>
		<td>${row.userName}</td>
		
		<td>
		<spring:url value="update/${row.id}" var="updateURL"/>
		<a href="${updateURL}">Update</a>
		</td>
		<td>
		<spring:url value="delete/${row.id}" var="deleteURL"/>
		<a href="${deleteURL}">Delete</a>
		</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>