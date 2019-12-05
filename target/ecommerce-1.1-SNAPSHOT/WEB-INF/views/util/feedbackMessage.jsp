
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <c:if test="${not empty feedback }">

	<c:choose>
		<c:when test="${ feedback.error}">
			<c:set var="feedbackClass" value="alert alert-danger"/>
		</c:when>
		<c:otherwise>
			<c:set var="feedbackClass" value="alert alert-success"/>
		</c:otherwise>
	</c:choose>
	<div class="${feedbackClass}">
 ${feedback.message }
 </div>
 </c:if>