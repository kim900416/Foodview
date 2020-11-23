<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
 a:link { color: white; text-decoration: none;}
 a:visited { color: white; text-decoration: none;}
 a:hover { color: white; text-decoration: none;} 
</style>

<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/login.css" rel="stylesheet">  
</head>
<body>
<form class="box" action="login.do" method="post">
<h1>Food Review</h1>
<input type="text" name="id"  value="${param.id}" placeholder="아이디">
<input type="password" type="password" name="password" placeholder="패스워드">

<input type="submit" name="" value="로그인"> 
</form>
</body>
</html>