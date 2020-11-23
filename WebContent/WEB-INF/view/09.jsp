<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>게시글 읽기</title>
</head>
<body>
<table border="1" width="100%">
<tr>
	<td>번호</td>
	<td>${ReviewData.review.number}</td>
</tr>
<tr>
	<td>작성자</td>
	<td>${ReviewData.review.writer.name}</td>
</tr>
<tr>
	<td>제목</td>
	<td><c:out value='${ReviewData.review.title}' /></td>
</tr>
<tr>
	<td>내용</td>
	<td><u:pre value='${ReviewData.content}'/></td>
</tr>
<tr>
	<td colspan="2">
		<c:set var="pageNo" value="${empty param.pageNo ? '1' : param.pageNo}" />
		<a href="list.do?pageNo=${pageNo}">[목록]</a>
		<c:if test="${authUser.id == ReviewData.review.writer.id}">
		<a href="modify.do?no=${ReviewData.review.number}">[게시글수정]</a>
		<a href="delete.do?no=${ReviewData.review.number}">[게시글삭제]</a>
		</c:if>
	</td>
</tr>
</table>

</body>
</html>