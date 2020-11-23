<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" rel="stylesheet">
<link href="../css/strollbutton.css" rel="stylesheet"> 
</head>
<body>
    <a id="backToTop" class="scrolltop" href="#">
      <i class="fas fa-chevron-circle-up"></i>
    </a>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>
      jQuery(document).ready(function () {
        $(window).scroll(function () {
          if ($(this).scrollTop() > 100) {
            $('#backToTop').fadeIn(500);
          } else {
            $('#backToTop').fadeOut('slow');
          }
        });
        $('#backToTop').click(function (e) {
          e.preventDefault();
          $('html, body').animate({scrollTop: 0}, 200);
        });
      });
    </script>
</body>
</html>