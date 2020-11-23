<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>게시글 등록</title>
</head>
<body>

${grade}
게시글을 등록했습니다.

<br>
${ctxPath = pageContext.request.contextPath ; ''}
<a href="${ctxPath}/review/list.do">[게시글목록보기]</a>
<a href="${ctxPath}/review/read.do?no=${newArticleNo}">[게시글내용보기]</a>
</body>
</html>