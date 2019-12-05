<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<nav aria-label="Page navigation example">



	<ul class="pagination">
		<c:if test="${block.showPrevious}">
			<!-- 		This helps keeping context root -->
			<spring:url value="${block.urlPrevious}" var="urlPrevious"></spring:url>
			<li class="page-item"><a class="page-link" href="${urlPrevious}">Previous</a>
			</li>


		</c:if>

		<c:if test="${block.showNext}">
			<spring:url value="${block.urlNext}" var="urlNext"></spring:url>
			<li class="page-item"><a class="page-link" href="${urlNext}">Next</a>

			</li>


		</c:if>
	</ul>
</nav>
