<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/tagLibs.jsp"%>

<tiles:importAttribute name="title" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><fmt:message key="${title}"/></title>
<link href="<c:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
<link rel="shortcut icon" href="http://freefavicons.org/download/open-book/open-book.png"  type="image/png" />
<script src="<c:url value="/js/lib/jquery/jquery.min.js"/>"></script>
<script src="<c:url value="/js/main.js"/>"></script>
</head>
<body>
	<header>
		<div id="topHeader">
			<a href="<c:url value="/home?lang=sr" />"><fmt:message key="common.header.language.sr" /></a>
			<a href="<c:url value="/home?lang=en" />"><fmt:message key="common.header.language.en" /></a>
			<a href="<c:url value="j_spring_security_logout" />"> <fmt:message key="common.logout" /></a>
		</div>
		<p>Welcome <sec:authentication property="name"></sec:authentication>!</p>
		<h1><fmt:message key="common.header.title"/></h1>
		<ul id="mainMenu">
			<li><a href="<c:url value="/home"/>"><fmt:message key="common.menu.home"/></a></li>
			<li><a href="<c:url value="/categories"/>"><fmt:message key="common.menu.categories"/></a></li>
			<li><a href="<c:url value="/books"/>"><fmt:message key="common.menu.books"/></a></li>
			<li><a href="<c:url value="/accounts"/>"><fmt:message key="common.menu.accounts"/></a></li>
		</ul>
	</header>
	<section id="mainContent">
		<tiles:insertAttribute name="content" />
	</section>
	<footer>
		<div><fmt:message key="common.footer.copyright"/></div>
	</footer>
</body>
</html>