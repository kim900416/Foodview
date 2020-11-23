<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link href="css/review.css" rel="stylesheet">
</head>
<body>
<div style="background-color:#fff; width:100%;height:520px;">
<div class="slideshow-container">

<div class="mySlides">
  <div class="numbertext">1 / 3</div>
  <img src="images/food.jpg" style="width:100%">
  <div class="text">Caption One</div>
</div>

<div class="mySlides">
  <div class="numbertext">2 / 3</div>
  <img src="images/food.jpg" style="width:100%">
  <div class="text">Caption Two</div>
</div>

<div class="mySlides">
  <div class="numbertext">3 / 3</div>
  <img src="images/food.jpg" style="width:100%">
  <div class="text">Caption Three</div>
</div>

</div>
<br>

<div style="text-align:center">
  <span class="dot"></span> 
  <span class="dot"></span> 
  <span class="dot"></span> 
</div>
</div>


	<input type="hidden" id="board_id" name="board_id" value="${boardView.id}" />
		<div align="center">
            </br>
            </br>
            <table border="1" width="1200px" id="reply_area">
                <tr reply_type="all"><!-- 뒤에 댓글 붙이기 쉽게 선언 -->
                    <td colspan="4"></td>
                </tr>
                <!-- 댓글이 들어갈 공간 -->
            </table>
            <table border="1" width="1200px" bordercolor="#46AA46">
                <tr>
                    <td width="500px">   
                        이미지 삽입: <input type="file" name="filename">
                        별점 등록:  <span id="star_grade">
        			<a href="#">★</a>
        			<a href="#">★</a>
        			<a href="#">★</a>
        			<a href="#">★</a>
        			<a href="#">★</a>
					</span>
                    </td>
                </tr>
                <tr>
                    <td>
                        <textarea id="reply_content" name="reply_content" rows="4" cols="50" placeholder="댓글을 입력하세요."></textarea>
                    </td>
                </tr>
            </table>
            <table width="1200px">
                <tr>
                    <td align="right">
                    	<button id="reply_save">댓글 등록</button>
                        <a href="noticeboard.jsp"><button id="list" name="list">게시판</button></a>
                    </td>
                </tr>
            </table>
        </div>
   <script>
        var slideIndex = 0;
        showSlides();

        function showSlides() {
    	var i;
    	var slides = document.getElementsByClassName("mySlides");
    	var dots = document.getElementsByClassName("dot");
    	for (i = 0; i < slides.length; i++) {
    	   slides[i].style.display = "none";  
   		}
    	slideIndex++;
    	if (slideIndex > slides.length) {slideIndex = 1}    
    	for (i = 0; i < dots.length; i++) {
        	dots[i].className = dots[i].className.replace(" active", "");
    	}
    	slides[slideIndex-1].style.display = "block";  
    	dots[slideIndex-1].className += " active";
    	setTimeout(showSlides, 2000); // Change image every 2 seconds
		}
        
        $('#star_grade a').click(function(){
            $(this).parent().children("a").removeClass("on");  /* 별점의 on 클래스 전부 제거 */ 
            $(this).addClass("on").prevAll("a").addClass("on"); /* 클릭한 별과, 그 앞 까지 별점에 on 클래스 추가 */
            return false;
        });
	</script>
    </body>
</html>