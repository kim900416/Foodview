<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Food Review</title>
<link href="../css/main.css" rel="stylesheet">  
</head>

<body>
                                                                                           
<!--헤더파일 들어가는 곳 시작 -->
  <header>
    <!--로고 들어가는 곳 시작--->  
    <div id="logo">
       <a href="/review/index.jsp">
        <img src="../images/logo.PNG" width="150" height="90" alt="review_logo"> 
      </a>  
    </div>
    <!--로고 들어가는 곳 끝-->
    
    
    <!--타이틀 들어가는 곳 시작--->
    <div id="title">
        <img src="../images/title.PNG" width="180" height="100" alt="review_title">
    </div>
    <!--타이틀 들어가는 곳 끝-->
    
    <nav id="catagory_menu">
     <ul>
       <c:choose>
       <c:when test="${empty sessionScope.loginUser}">
       <li>
       	<u:notLogin>       		         
        
        </u:notLogin>         	  
        <u:isLogin>
       
         
        <u:admin>
	    
	    </u:admin>
	    </u:isLogin>
	    
	   </li>		       
       </c:when>
       <c:otherwise>
       <li style="color:orange">
         ${sessionScope.loginUser.name}(${sessionScope.loginUser.id})
       </li>
       </c:otherwise>       
       </c:choose>
     </ul>
    </nav>

    <div class="clear"></div>
    <hr>
  </header>
  <!--헤더파일 들어가는 곳 끝 -->