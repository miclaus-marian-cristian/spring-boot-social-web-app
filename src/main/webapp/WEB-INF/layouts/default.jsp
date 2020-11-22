<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Latest compiled and minified CSS -->
<!-- Latest compiled and minified CSS -->
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!-- Bootstrap -->
<link href="${contextRoot}/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextRoot}/css/main.css" rel="stylesheet">
<title><tiles:insertAttribute name="title" /></title>

</head>
<body>
	<script src="${contextRoot}/js/jquery-3.5.1.min.js"></script>
	<!-- Static navbar -->
	<nav class="navbar navbar-default navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/">Spring Boot Tutorial</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="${contextRoot}/">Home</a></li>
					<li class=""><a href="${contextRoot}/about">About</a></li>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li class=""><a href="${contextRoot}/addstatus">AddStatus</a></li>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
						<li><a href="${contextRoot}/viewstatus">View Statuses</a></li>
					</sec:authorize>
					
				</ul>
				<ul class="nav navbar-nav navbar-right">
					
					<sec:authorize access="!isAuthenticated()">
						<li><a href="${contextRoot}/register">Register</a></li>
					</sec:authorize>
					
					<sec:authorize access="!isAuthenticated()">
						<li><a href="${contextRoot}/login">Login</a></li>
					</sec:authorize>
					
					<sec:authorize access="isAuthenticated()">
						<li id="logout"><a href="<c:url value="/logout" />">Logout</a></li>
					</sec:authorize>
					
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<c:url var="logoutUrl" value="/logout"/>
	<form name="logoutForm" action="${logotUrl}" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${ _csrf.token }"/>
	</form>

	<div class="container">
		<tiles:insertAttribute name="content" />
	</div>
	

<%-- 	<script src="${contextRoot}/js/bootstrap.min.js"></script> --%>
<!-- 	<script> -->
// 		let logoutLink = document.getElementById("logout");
// 		logoutLink.onclick = function(){
// 			document.forms["logoutForm"].submit();
// 		};
<!-- 	</script> -->
</body>
</html>