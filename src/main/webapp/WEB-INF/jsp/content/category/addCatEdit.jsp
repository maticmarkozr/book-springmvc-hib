<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/tagLibs.jsp"%>	


<h2><fmt:message key="page.addCatEdit.header" /></h2>

	<div id="addCategoryEdit">
		<c:url var="action" value="/categories" />
		<form:form id="formCategory" action="${action}" method="post" modelAttribute="category">
			<fieldset>
				<form:hidden path="id" />
				<form:label path="name"><fmt:message key="common.label.name" /></form:label>
				<form:input path="name" />
				<form:errors path="name"/>
			</fieldset>
			<p>
			<button type="submit" name="save"><fmt:message key="common.action.save" /></button>
			<button type="submit" name="cancel"><fmt:message key="common.action.cancel" /></button>
			</p>
			
		</form:form>
	</div>	
