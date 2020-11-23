<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>음식점 올리기</title>
</head>
<body>
<form action="write.do" method="post">
<p>
	음식점 이름:<br/><input type="text" name="f_title" value="${param.f_title}">
</p>
<p>
	메인메뉴 및 인사말:<br/>
	<textarea name="f_introduce" rows="5" cols="30">${param.f_introduce}</textarea>
</p>
<p>
	음식점 소개:<br/>
	<textarea name="f_content" rows="5" cols="30">${param.f_content}</textarea>
</p>

<p>
	음식점 사진 URI:<br/><input type="text" name="f_imageAddress" value="${param.f_imageAddress}">	
</p>
<input type="submit" value="음식점 등록">
</form>
</body>
</html>