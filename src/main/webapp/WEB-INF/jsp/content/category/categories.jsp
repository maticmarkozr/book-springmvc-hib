<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/tagLibs.jsp"%>

<h1><fmt:message key="page.categories.header" /></h1>

	<div id="categories">
		<table>
			<tr>
				<th><fmt:message key="common.label.id"/></th>
				<th><fmt:message key="common.label.name" /></th>
				<th></th>
			</tr>
			<c:forEach items="${categories}"  var="category">
				<tr>	
					<td><c:out value="${category.id}"/></td>				
					<td><c:out value="${category.name}"/></td>
					<td><a href="<c:url value="/categories/edit/${category.id}"/>"><fmt:message key="common.action.edit" /></a></td>
					<td><a href="<c:url value="/categories/remove/${category.id}"/>"><fmt:message key="common.action.remove" /></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>	
	<div id="newCategory">
		<a href="<c:url value="/categories/new"/>"><fmt:message key="page.categories.action.addNewCategory" /></a>
	</div>
