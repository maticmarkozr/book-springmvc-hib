<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/tagLibs.jsp"%>

<h2><fmt:message key="page.addBookEdit.header"/></h2>


	<div id="addEditBook">
		<c:url var="action" value="/books" />
		<form:form id="formBooks" action="${action}" method="post"
			modelAttribute="book">
		<fieldset>
				<form:hidden path="id" />
				<form:label path="name"><fmt:message key="common.label.name"/></form:label>
				<form:input path="name"/>
				<form:errors path="name"/>
				<br>
				<br>
				<form:label path="author"><fmt:message key="common.label.author"/></form:label>
				<form:input path="author"/>
				<form:errors path="author"/>
				<br>
				<br>
				<form:label path="price"><fmt:message key="common.label.price"/></form:label>
				<form:input path="price"/>
				<form:errors path="price"/>
				<br>
				<br>
				<form:label path="amount"><fmt:message key="common.label.amount"/></form:label>
				<form:input path="amount"/>
				<form:errors path="amount"/>
				<br>
				<br>
				<form:label path="publisher"><fmt:message key="common.label.publisher"/></form:label>
				<form:input path="publisher"/>
				<form:errors path="publisher"/>
				
		</fieldset>
		<br />
		<form:label path="category"><fmt:message key="page.addBookEdit.label.category"/></form:label>
		<form:select path="category">
			<form:option value="-1">-- Must enter category --</form:option>
			<form:options items="${categories}" itemLabel="name" itemValue="id" />
		</form:select>
		<p>
			<button type="submit" name="save"><fmt:message key="common.action.save" /></button>
			<button type="submit" name="cancel"><fmt:message key="common.action.cancel" /></button>
		</p>
		
		</form:form>
	</div>