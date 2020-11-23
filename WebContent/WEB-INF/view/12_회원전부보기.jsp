<%@page import="admin.model.UserVariable"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="UserMember" class="admin.model.User"/>

<!DOCTYPE html>
<html>
<head>
<title>게시글 목록</title>
</head>
<body>
<form action="grade.do" method="post">
<table border="3">
	<tr>
		<td>이름</td>
		<td>아이디</td>
		<td>이메일</td>
		<td>전화번호</td>
		<td>성별</td>
		<td>등급</td>
		<td>벤</td>
	</tr>
<c:if test="${UserPage.hasNoReviews()}">
	<tr>
		<td colspan="7">게시글이 없습니다.</td>
	</tr>
</c:if>
<c:forEach var="user" items="${UserPage.content}">	
<input type="hidden" value="${user.id}" name="userId">
	<tr>		
		<td>${user.name}</td>
		<td>${user.id}</td>	
		<td>${user.email}</td>
		<td>${user.phoneNum}</td>
		<td>${user.sex}</td>
		<td>
		<select name="changeGrade">			
			<option value="1" <c:if test="${user.grade eq '1'}">selected</c:if>>관리자</option> 
			<option value="0" <c:if test="${user.grade eq '0'}">selected</c:if>>일반</option> 				
		</select>
		</td>
		<td>
		<select name="blackList">			
			<option value="1" <c:if test="${user.blackList eq '1'}">selected</c:if>>벤</option> 
			<option value="0" <c:if test="${user.blackList eq '0'}">selected</c:if>>일반</option>			
		</select>
		</td>		
	</tr>
</c:forEach>
<c:if test="${UserPage.hasReviews()}">
	<tr>
		<td colspan="7">
			<c:if test="${UserPage.startPage > 5}">
			<a href="list.do?pageNo=${UserPage.startPage - 5}">[이전]</a>
			</c:if>
			<c:forEach var="pNo" 
					   begin="${UserPage.startPage}" 
					   end="${UserPage.endPage}">
			<a href="list.do?pageNo=${pNo}">[${pNo}]</a>
			</c:forEach>
			<c:if test="${UserPage.endPage < UserPage.totalPages}">
			<a href="list.do?pageNo=${UserPage.startPage + 5}">[다음]</a>
			</c:if>
		</td>
	</tr>
</c:if>
<input type="submit" value="회원정보수정">
</table>
</body>
</html>