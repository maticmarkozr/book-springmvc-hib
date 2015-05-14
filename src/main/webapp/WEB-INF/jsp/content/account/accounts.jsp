<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/tagLibs.jsp"%>

<h1><fmt:message key="page.accounts.header"/></h1>

	<div id="accounts">
	<table>
			<tr>
				<th><fmt:message key="common.label.id"/></th>
				<th><fmt:message key="page.addAccountEdit.userName"/></th>
			</tr>
			<c:forEach items="${accounts}" var = "account">
					<tr>
						<td><c:out value="${account.id}"/></td>
						<td><c:out value="${account.username}"/></td>
						
						
						<td><a href="<c:url value="/accounts/edit/${account.id}"/>"><fmt:message key="common.action.edit"/></a></td>
						<td><a href="<c:url value="/accounts/remove/${account.id}"/>"><fmt:message key="common.action.remove"/></a></td>
					</tr>	
				</c:forEach>
			
		</table>
	</div>
	<div id="newAccounts">
		<a href="<c:url value="/accounts/new"/>"><fmt:message key="page.accounts.action.addNewAccount"/></a>
	</div>
