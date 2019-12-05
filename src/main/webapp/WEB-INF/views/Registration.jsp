<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>






<%@ include file="layout/header.jsp"%>

<spring:url value="/register" var="registerUrl"></spring:url>

<spring:hasBindErrors name="user" >
<div class="alert alert-danger">
	<c:forEach var="error" items="${errors.allErrors}">
		<b><spring:message message="${error}" /></b>
		<br />
	</c:forEach>
	</div>
</spring:hasBindErrors>

<%@ include file="util/feedbackMessage.jsp"%>

    <form:form method="POST" action="${registerUrl}" modelAttribute="user" class="form-signin">
       
        <h2 class="form-signin-heading">Create your account</h2>
        
        
        
            <div class="form-group">
                <form:input type="text" path="firstName" class="form-control" placeholder="first name"
                            autofocus="true"></form:input>
                             <div class="invalid-feedback">
                <form:errors path="firstName"></form:errors>
                </div>
            </div>
        
        
          <div class="form-group">
                <form:input type="text" path="lastName" class="form-control" placeholder="last name"
                            autofocus="true"></form:input>
                             <div class="invalid-feedback">
                <form:errors path="lastName"></form:errors>
                </div>
            </div>
            
            <div class="form-group">
                <form:input type="email" path="email" class="form-control" placeholder="email"
                            autofocus="true"></form:input>
                             <div class="invalid-feedback">
                <form:errors path="email"></form:errors>
                </div>
            </div>

            <div class="form-group">
                <form:input type="text" path="loginName" class="form-control" placeholder="Username"
                            autofocus="true"></form:input>
                             <div class="invalid-feedback">
                <form:errors path="loginName"></form:errors>
                </div>
            </div>



            <div class="form-group">
                <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
               <div class="invalid-feedback">
                <form:errors path="password"></form:errors>
                </div>
            </div>



            <div class="form-group">
                <form:input type="password" path="passwordConfirm" class="form-control"
                            placeholder="Confirm your password"></form:input>
                             <div class="invalid-feedback">
                <form:errors path="passwordConfirm"></form:errors>
                </div>
            </div>


        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

<%@ include file="layout/footer.jsp"%>
