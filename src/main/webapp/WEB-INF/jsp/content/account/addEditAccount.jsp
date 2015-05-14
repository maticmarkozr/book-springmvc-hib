<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/tagLibs.jsp"%>

<h2><fmt:message key="page.addAccountEdit.header"/></h2>


	<div id="addEditAccount">
		<c:url var="action" value="/accounts" />
		<form:form id="formAccount" action="${action}" method="post"
			modelAttribute="account">
		<fieldset>
				<form:hidden path="id" />
				<form:label path="firstName"><fmt:message key="page.addAccountEdit.firstName"/></form:label>
				<form:input path="firstName"/>
				<form:errors path="firstName"/>
				<br>
				<br>
				<form:label path="lastName"><fmt:message key="page.addAccountEdit.lastName"/></form:label>
				<form:input path="lastName"/>
				<form:errors path="lastName"/>
				<br>
				<br>
				<form:label path="dateOfBirth"><fmt:message key="page.addAccountEdit.dateOfBirth"/></form:label>
				<form:input name="dateOfBirth" path="dateOfBirth" placeholder="dd-mm-yyyy" cssErrorClass="error"/>
				<form:errors path="dateOfBirth" cssClass="errorMessage"/>
				<br>
				<br>
				<form:label path="emailAddress"><fmt:message key="page.addAccountEdit.emailAddres"/></form:label>
				<form:input path="emailAddress" cssErrorClass="error"/>
				<form:errors path="emailAddress" cssClass="errorMessage"/>
				<br>
				<br>
				<form:label path="mobPhone"><fmt:message key="page.addAccountEdit.mobPhone"/></form:label>
				<form:input path="mobPhone"/>
				<form:errors path="mobPhone"/>
				<br>
				<br>
				<form:label path="username"><fmt:message key="page.addAccountEdit.userName"/></form:label>
				<form:input path="username" cssErrorClass="error"/>
				<form:errors path="username" cssClass="errorMessage"/>
				<br>
				<br>
				<form:label path="password"><fmt:message key="page.addAccountEdit.password"/></form:label>
				<form:password path="password" cssErrorClass="error"/>
				<form:errors path="password" cssClass="errorMessage"/>	
				<br>
				<br>
				<form:label path="street"><fmt:message key="page.addAccountEdit.street"/></form:label>
				<form:input path="street" cssErrorClass="error"/>
				<form:errors path="street" cssClass="errorMessage"/>	
				<br>
				<br>
				<form:label path="city"><fmt:message key="page.addAccountEdit.city"/></form:label>
				<form:input path="city" cssErrorClass="error"/>
				<form:errors path="city" cssClass="errorMessage"/>
				<br>
				<br>
				<form:label path="postalCode"><fmt:message key="page.addAccountEdit.postalCode"/></form:label>
				<form:input path="postalCode" cssErrorClass="error"/>
				<form:errors path="postalCode" cssClass="errorMessage"/>	
				<br>
				<br>
				<form:label path="country"><fmt:message key="page.addAccountEdit.country"/></form:label>
				<form:input path="country" cssErrorClass="error"/>
				<form:errors path="country" cssClass="errorMessage"/>
		</fieldset>
		<br />
		
		<p>
			<button type="submit" name="save"><fmt:message key="common.action.save" /></button>
			<button type="submit" name="cancel"><fmt:message key="common.action.cancel" /></button>
		</p>
		
		</form:form>
	</div>