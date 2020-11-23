<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>회원제 게시판 예제</title>
</head>
<body>

<u:isLogin>
	CT: ${authUser.name}님, 안녕하세요.
	<a href="logout.do">[로그아웃하기]</a>
	<a href="changePwd.do">[암호변경하기]</a>
	<a href="review/write.do">[글쓰기]</a>
	<a href="review/list.do">[리스트보기]</a>
	음식점등록: <a href="admin/write.do">[음식점등록]</a>
	음식점목록: <a href="admin/read.do">[음식점목록]</a>
	
	

	<u:admin>
	<br/><br/>
	
	관리자모드로 로그인하셨습니다
	관리자모드: <a href="admin/user.do">[회원보기]</a>	
	</u:admin>

</u:isLogin>

<u:notLogin>
	CT: <a href="join.do">[회원가입하기]</a>
	<a href="login.do">[로그인하기]</a>
	<a href="review/write.do">[글쓰기]</a>
	<a href="review/list.do">[리스트보기]</a>	
	관리자모드: <a href="admin/user.do">[회원보기]</a>
	음식점등록: <a href="admin/write.do">[음식점등록]</a>
	음식점목록: <a href="admin/read.do">[음식점목록]</a>
	
</u:notLogin>


<br/>
</body>
</html>