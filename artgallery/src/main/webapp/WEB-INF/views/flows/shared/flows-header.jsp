<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Art Gallery - ${title}</title>
<!-- 
<link href="${csss}/bootstrap.min.css" rel="stylesheet">
	<script type="text/javascript" src="${jss}/jquery.min.js"></script>
	<script type="text/javascript" src="${jss}/bootstrap.min.js"></script>
	<script type="text/javascript" src="${jss}/popper.min.js"></script>
-->

<script>
	window.menu = '${title}';
	
	window.contextRoot = '${contextRoot}';
</script>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.css"/>
<link href="${css}/myapp.css" rel="stylesheet">
</head>

<body>

	<div class="wrapper">
		<!-- Navigation bar -->
		<%@include file="flows-navbar.jsp" %>



