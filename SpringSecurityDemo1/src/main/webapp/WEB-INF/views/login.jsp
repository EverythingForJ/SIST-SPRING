<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<script>
	function doLogin() {
		if (!frm.j_username.value) {
			alert("아이디를 입력해주세요.");
			frm.j_username.focus();
			return;
		}
		if (!frm.j_password.value) {
			alert("패스워드를 입력해주세요.");
			frm.j_password.focus();
			return;
		}
		frm.submit();
	}
</script>
</head>
<body>
	<form name="frm" action="j_spring_security_check" method="post">
		<ul>
			<li>
				<label for="userID">ID</label>
				<input type="text" name="j_username" placeholder="아이디를 입력합니다." 
					required id="userID"/>
			</li>
			<li>
				<label for="password">Password</label>
				<input type="password" name="j_password" 
					placeholder="패스워드를 입력합니다." required id="password"></li>
			<li>
				<input type="button" value="로그인" onclick="doLogin()"/>
			</li>
		</ul>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<c:if test="${not empty error}">
		<div class="error">${error}</div>
	</c:if>
	<c:if test="${not empty msg}">
		<div class="msg">${msg}</div>
	</c:if>
</body>
</html>