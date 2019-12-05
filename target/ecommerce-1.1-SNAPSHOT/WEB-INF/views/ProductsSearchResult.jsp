
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.wirtz.ecommerce.model.util.Global" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ include file="layout/header.jsp"%>
<h2>Products search</h2>

<c:set var="pageCount" value="${Global.PAGE_SIZE }"/>
<spring:url value="/products/search/0/${pageCount}" var="productsSearchUrl"></spring:url>

<!-- Actual search box -->
<form action="${productsSearchUrl}" method="GET">
	<div class="form-group has-search">
		<span class="fa fa-search form-control-feedback"></span> <input
			type="text" name="keyWords" class="form-control"
			placeholder="Search..." required />
	</div>
</form>


<h3>Search results</h3>
<c:if test="${not empty block.items}">

<%@ include file="util/pageBlock.jsp"%>

	<div class="table-responsive">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Title</th>
					<th>Price</th>
					<c:if test="${sessionScope.userProfileId != null}">
					<th>Add to cart...</th>
					</c:if>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${block.items}" var="product">
					<tr>
						<td><spring:url value="/products/${product.productId }"
								var="pDetailsUrl"></spring:url> <a href="${pDetailsUrl}">${product.name}</a>
						</td>
						<td>${product.price}</td>

						<c:if test="${sessionScope.userProfileId != null}">
							<td><spring:url value="/cart/${product.productId}"
									var="addCartUrl"></spring:url> <a href="${addCartUrl}">Add
									to cart</a></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</c:if>


<c:if test="${empty block.items}">
No results found
</c:if>

<%@ include file="layout/footer.jsp"%>