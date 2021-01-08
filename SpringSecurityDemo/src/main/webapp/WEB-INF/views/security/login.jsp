<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>login.jsp</h1>
	<c:if test="${not empty pageContext.request.userPrincipal}">
		<p>현재 로그인 상태</p>
	</c:if>
	<c:if test="${empty pageContext.request.userPrincipal}">
		<p>현재 로그아웃 상태</p>
	</c:if>
	User ID : ${pageContext.request.userPrincipal.name}<br />
	<a href="${pageContext.request.contextPath}/">Log Out</a>
</body>
</html>