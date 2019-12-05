
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




<%@ include file="layout/footer.jsp"%>