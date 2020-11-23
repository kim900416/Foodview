<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>  
<%@ include file="StrollButton.jsp" %>

<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet"  href="https://han3283.cafe24.com/js/lightslider/css/lightslider.css"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="https://han3283.cafe24.com/js/lightslider/js/lightslider.js"></script>

<link href="css/button.css" rel="stylesheet">     
<link href="css/star.css" rel="stylesheet">
<link href="css/kategorie.css" rel="stylesheet">
</head>
<body>
<div class="slide-wrap" style="margin:20px 0 180px 200px;">
        <div class="slide-content">
            <ul id="slider" class="slider">
                <li class="item1">
                    <a href="noticeboard.jsp"><h3></h3></a>
                </li>
                <li class="item2">
                    <a href="noticeboard.jsp"><h3></h3></a>
                </li>
                <li class="item3">
                    <a href="noticeboard.jsp"><h3></h3></a>
                </li>
                <li class="item4">
                    <a href="noticeboard.jsp"><h3></h3></a>
                </li>
                <li class="item5">
                    <a href="noticeboard.jsp"><h3></h3></a>
                </li>
                <li class="item6">
                    <a href="noticeboard.jsp"><h3></h3></a>
                </li>
                <li class="item7">
                    <a href="noticeboard.jsp"><h3></h3></a>
                </li>
                <li class="item8">
                    <a href="noticeboard.jsp"><h3></h3></a>
                </li>
            </ul>
        </div>
    </div>
    
	<div id="front">
    	<h2> 리뷰 보기 </h2>
   			<a href="admin/read.do">+more</a>
	</div>

    <div id="bestReview">
    	
            
            	리뷰보기
               	              	           	
  					<a href="#" class="bu01">Hover Me!</a> 
  					<a href="#" class="bu01">Hover Me!</a>  				 	 					
												
        
    </div>
    
    
    
    <div id="front">
    	<h2> 리뷰 쓰기 </h2>
   			<a href="noticeboard.jsp">+more</a>
	</div>
     <div id="bestReview">
    	
            <colgroup>
                <col width="200" />
                <col width="1000" />
                <col width="100" />
                <col width="110" />
                <col width="80" />
            </colgroup>
            	왜안나와
               	             	
  					               	           	
  						<a href="#" class="bu02">Hover Me!</a> 
  						<a href="#" class="bu02">Hover Me!</a>  				 	 					
					
  						
  							
				</div>	
        
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