<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ include file="header.jsp" %>
<html>
<head>
<title>board</title>

<style>
p{
margin: 20px auto;	
}

.h2{
color: #86E57F;
}
.bu01 {
	text-align: center;
	-webkit-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-moz-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-ms-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-o-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	
	margin: 20px auto;	
	text-decoration: none;
	border-radius: 4px;
	padding: 20px 30px;
	color: rgba(30, 22, 54, 0.6);
	box-shadow: rgba(30, 22, 54, 0.4) 0 0px 0px 2px inset;
	
	width:700px;
  	height:50px;
  	font-size:20px;
}



</style>
</head>
<body>

<%String fnum = request.getParameter("fnum");%>

<div style= bborder: align="center">

<form action="write.do" method="post">

	<br/><br/><br/>
	<h2 class="h2"> 제목 </h2><br/>
	
	<input class="bu01"
	type="text" name="title" value="${param.title}">
	<c:if test="${errors.title}">제목을 입력하세요.</c:if><br/><br/><br/>



	<h2 class="h2"> 내용 </h2><br/>
	<textarea class="bu01" name="content" rows="5" cols="30">${param.content}</textarea><br/><br/><br/>

	<h2 class="h2"> 평점 </h2><br/><br/>
	<input type="text" name="grade" value="${param.grade}">
	<c:if test="${errors.title}">제목을 입력하세요.</c:if>
	
	<INPUT TYPE="hidden" NAME="fnum" value="<%=fnum%>">

	<br/><br/><br/>
	<input type="submit" value="새 글 등록">
</form>
</div>
</body>
</html>
<%@ include file="footer.jsp" %>   