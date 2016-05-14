<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page session="false"%>

<div class="internal-buttons">
	<ul class="nav nav-sidebar">
		<li><a href="${context}/home">Home</a></li>
		<li><a href="${context}/Registration">Registration</a></li>
		<sec:authorize access="hasRole('ROLE_USER')">
			<li><a href="${context}/users">Users</a></li>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_USER')">
			<li><a href="${context}/users/mypage">Mypage</a></li>
		</sec:authorize>
	</ul>
</div>
