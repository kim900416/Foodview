<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>게시글 수정</title>
</head>
<body>

게시글을 수정했습니다.
<br>
${ctxPath = pageContext.request.contextPath ; ''}
<a href="${ctxPath}/review/list.do">[게시글목록보기]</a>
<a href="${ctxPath}/review/read.do?no=${modReq.reviewNumber}">[게시글내용보기]</a>
</body>
</html>