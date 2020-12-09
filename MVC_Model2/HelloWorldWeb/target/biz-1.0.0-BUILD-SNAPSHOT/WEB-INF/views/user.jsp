<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="myvariable" value="${job}" />

<ul>
	<li>이름 : ${username}</li>
	<li>나이 : <c:out value="${userage}"/></li>
	<li>직업 : <c:out value="${myvariable}"/></li>
</ul>

