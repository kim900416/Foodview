<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>게시글 목록</title>
</head>
<body>
<% String fnum = request.getParameter("fnum"); %>
<table border="3">
	<tr>
		<td colspan="4"><a href="write.do?fnum=<%=fnum%>">[게시글쓰기]</a></td>
	</tr>
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>조회수</td>
	</tr>
<c:if test="${ReviewPage.hasNoReviews()}"> 
	<tr>
		<td colspan="4">게시글이 없습니다.</td>
	</tr>
</c:if>
<c:forEach var="review" items="${ReviewPage.content}">
	<tr>
		<td>${review.number}</td>
		<td>		
		<a href="read.do?no=${review.number}&pageNo=${ReviewPage.currentPage}">
		<c:out value="${review.title}"/>		
		</a>
		</td>
		<td>${review.writer.name}</td>
		<td>${review.readCount}</td>
	</tr>
</c:forEach>
<c:if test="${ReviewPage.hasReviews()}">
	<tr>
		<td colspan="4">
			<c:if test="${ReviewPage.startPage > 5}">
			<a href="list.do?pageNo=${ReviewPage.startPage - 5}">[이전]</a>
			</c:if>
			<c:forEach var="pNo" 
					   begin="${ReviewPage.startPage}" 
					   end="${ReviewPage.endPage}">
			<a href="list.do?pageNo=${pNo}">[${pNo}]</a>
			</c:forEach>
			<c:if test="${ReviewPage.endPage < ReviewPage.totalPages}">
			<a href="list.do?pageNo=${ReviewPage.startPage + 5}">[다음]</a>
			</c:if>
		</td>
	</tr>
</c:if>
</table>
</body>
</html>