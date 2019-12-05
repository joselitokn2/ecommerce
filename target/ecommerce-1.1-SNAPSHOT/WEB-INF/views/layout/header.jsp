<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/ecommerce.css" />
<title>E-commerce</title>



<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">



</head>
<body>



	<div class="container">
		<header>
			<h1>E-commerce</h1>
			


			<c:set value="${pageContext.request.servletPath}" var="currentPage" />
			<div>
<!-- 			Show in all pages but in login -->
				<c:if test="${not fn:endsWith(currentPage, 'Login.jsp')}">
					<c:choose>
						<c:when test="${sessionScope.userProfileId != null}">
							<c:out value="Hola ${sessionScope.userFirstName}!" />

							<spring:url value="/logout" var="logoutUrl"></spring:url>
							<a href="${logoutUrl}">Logout</a>
						</c:when>
						<c:otherwise>
							<spring:url value="/login" var="loginUrl"></spring:url>
							<a href="${loginUrl}">Login</a>
						</c:otherwise>
					</c:choose>
				</c:if>
			</div>

		</header>