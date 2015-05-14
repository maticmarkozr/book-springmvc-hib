<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/tagLibs.jsp"%>

<h1><fmt:message key="page.books.header"/></h1>

	<div id="books">
	<table>
			<tr>
				<th><fmt:message key="common.label.id"/></th>
				<th><fmt:message key="common.label.name"/></th>
				<th><fmt:message key="common.label.author"/></th>
				<th><fmt:message key="common.label.price"/></th>
				<th><fmt:message key="common.label.publisher"/></th>
				<th><fmt:message key="common.label.amount"/></th>
				<th><fmt:message key="page.book.label.category"/></th>
				
				
			</tr>
			<c:forEach items="${books}" var = "bookVar">
				
					<c:forEach items="${bookVar.value}" var="book">
					<tr>
						<td><c:out value="${book.id}"/></td>
						<td><c:out value="${book.name}"/></td>
						<td><c:out value="${book.author}"/></td>
						<td><c:out value="${book.price}"/></td>
						<td><c:out value="${book.publisher}"/></td>
						<td><c:out value="${book.amount}"/></td>
						<td><c:out value="${bookVar.key}"/></td>
						
<!-- 						<td> -->
<%-- 						<c:choose> --%>
<%-- 							<c:when test="${bookVar.key != 'Uncategorized'}"> --%>
<%-- 									${bookVar.key} --%>
<%-- 							</c:when> --%>
<%-- 							<c:otherwise> --%>
<%-- 								<fmt:message key="page.book.uncategorized" /> --%>
<%-- 							</c:otherwise> --%>
<%-- 						</c:choose> --%>
						
<!-- 						</td> -->
						<td><a href="<c:url value="/books/edit/${book.id}"/>"><fmt:message key="common.action.edit"/></a></td>
						<td><a href="<c:url value="/books/remove/${book.id}"/>"><fmt:message key="common.action.remove"/></a></td>
					</tr>	
				</c:forEach>
			</c:forEach>
		</table>
	</div>
	<div id="newBook">
		<a href="<c:url value="/books/new"/>"><fmt:message key="page.books.action.addNewBook"/></a>
	</div>
