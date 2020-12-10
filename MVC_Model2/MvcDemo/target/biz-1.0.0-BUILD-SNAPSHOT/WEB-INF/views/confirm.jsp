<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<h1>유저 정보</h1>
	<ul>
		<li>아이디 : ${userid}</li>
		<li>패스워드 : ${passwd}</li>
		<li>사용자 이름 : ${name}</li>
		<li>나이 : ${age}</li>
		<li>성별 : ${gender}</li>
		<li>취미: <c:forEach items="${hobbies}" var="hobby">
				<c:out value="${hobby}" />
			</c:forEach>
		</li>
	</ul>
</body>
</html>