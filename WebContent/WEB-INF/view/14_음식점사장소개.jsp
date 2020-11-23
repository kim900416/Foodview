<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>푸드 소개</title>
</head>
<body>

<table border="3">
	<tr>
	<u:isLogin>
		<u:admin>
		관리자모드로 로그인하셨습니다	
		<td colspan="5"><a href="write.do">[게시글쓰기]</a></td>	
		</u:admin>
	</u:isLogin>
	</tr>
		
<c:forEach var="foodIntro" items="${foodPage.content}">
	<tr>		
		<td>				
		<a href="../review/list.do?fnum=${foodIntro.fnum}">
		<c:out value="${foodIntro.imageAddress}"/>		
		</a>
		</td>
		<td>${foodIntro.title}</td>
		<td>${foodIntro.content}</td>
		<td>${foodIntro.introduce}</td>	
		<td>${foodIntro.grade}</td>			
		
		<u:isLogin>		
			<u:admin>						
			<td colspan="5"><a href="write.do">[게시글수정]</a></td>				
			</u:admin>			
		</u:isLogin>
		
	</tr>
</c:forEach>


</table>
</body>
</html>