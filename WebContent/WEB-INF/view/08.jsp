<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header2.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"  href="https://han3283.cafe24.com/js/lightslider/css/lightslider.css"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="https://han3283.cafe24.com/js/lightslider/js/lightslider.js"></script>
<link href="../css/star.css" rel="stylesheet">
<link href="../css/kategorie.css" rel="stylesheet">
</head>
<body>
<% String fnum = request.getParameter("fnum"); %>
	<div id="front">
    	<h2> Total Review Kategorie</h2>
   			<a href="write.do?fnum=<%=fnum%>">[게시글쓰기]</a>
	</div>
    <div id="bestReview">
    	<table>
            <colgroup>
                <col width="200" />
                <col width="1000" />
                <col width="200" />
                <col width="110" />
                <col width="80" />
            </colgroup>
            <tbody>
               <c:forEach var="review" items="${ReviewPage.content}">
                <tr>
                    <td rowspan="2" align="center">${review.number}</td>
                    <td rowspan="2">
                    <a href="read.do?no=${review.number}&pageNo=${ReviewPage.currentPage}" style="color:black;" >
                    <c:out value="${review.title}"/></a>
                    </td>
                    <td align="center">평점</td>
                    <td align="center">작성자</td>
                    <td rowspan="2" align="center"><a href="../review/list.do?fnum=${foodIntro.fnum}" style="color:#3498db">더보기</a></td>
                </tr>
                <tr>
                    <td align="left">
                    	<div class="wrap-star">
                    		<div class='star-rating'>
                    			<c:set var="gradeNum" value="${review.grade}"/>
                    			<% 
                    			String grade = (String)pageContext.getAttribute("gradeNum");
                    			grade = Integer.toString(Integer.parseInt(grade)*20);
                    			String aa = "width:"+grade+"%"; %>
                    			<span style =<%=aa%>></span>
                    		</div>
                    	</div>
                    </td>
                    <td align="center">${review.writer.name}</td>
                </tr>
                </c:forEach>
            </tbody>
<c:if test="${ReviewPage.hasReviews()}">
	<tr>
		<td colspan="4">
			<c:if test="${ReviewPage.startPage > 5}">
			<a href="list.do?pageNo=${ReviewPage.startPage - 5}" style="color:black;">[이전]</a>
			</c:if>
			<c:forEach var="pNo" 
					   begin="${ReviewPage.startPage}" 
					   end="${ReviewPage.endPage}">
			<a href="list.do?pageNo=${pNo}" style="color:black;">[${pNo}]</a>
			</c:forEach>
			<c:if test="${ReviewPage.endPage < ReviewPage.totalPages}">
			<a href="list.do?pageNo=${ReviewPage.startPage + 5}" style="color:black;">[다음]</a>
			</c:if>
		</td>
	</tr>
</c:if>
   </table>
    </div>
  	<div class="clear"></div>
  	<script>
        $(document).ready(function() {
            $("#slider").lightSlider({
                mode:'slide',    // 이미지가 표시되는 형식 (fade / slide)
                loop:true,       // 무한반복 할 것인지
                auto:true,       // 자동 슬라이드
                keyPress:true,   // 키보드 탐색 허용
                pager:false,     // 페이지 표시
                speed:1500,      // 슬라이드 되는 속도
                pause:3000       // 이미지가 머무는 시간
            });
        });
    </script>
</body>
</html>	
<%@ include file="footer.jsp" %>    