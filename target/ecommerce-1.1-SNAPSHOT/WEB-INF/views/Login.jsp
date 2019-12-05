
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%@ include file="layout/header.jsp"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<spring:url value="/register" var="registerUrl"></spring:url>
<spring:url value="/login" var="loginUrl"></spring:url>

<form:form method="POST" action="${loginUrl}" class="form-signin"
	modelAttribute="user">
	<h2 class="form-heading">Log in</h2>

	<spring:hasBindErrors name="user">
		<div class="alert alert-danger">
			<c:forEach var="error" items="${errors.allErrors}">
				<b><spring:message message="${error}" /></b>
				<br />
			</c:forEach>
		</div>
	</spring:hasBindErrors>

	<%@ include file="util/feedbackMessage.jsp"%>

	<div class="form-group ">
		<div class="form-group">
			<form:input name="username" type="text" class="form-control"
				placeholder="login name" autofocus="true" path="loginName" />

			<div class="invalid-feedback">
				<form:errors path="loginName"></form:errors>
			</div>
		</div>
		<div class="form-group">

			<form:input name="password" type="password" path="password"
				class="form-control" placeholder="Password" />

			<div class="invalid-feedback">
				<form:errors path="password"></form:errors>
			</div>
		</div>
		<div class="form-group">
			<button class="btn btn-lg btn-primary btn-block" type="submit">Log
				In</button>

			<h4 class="text-center">
				<a href="${registerUrl}">Create an account</a>
			</h4>
		</div>
	</div>

</form:form>


<%@ include file="layout/footer.jsp"%>

