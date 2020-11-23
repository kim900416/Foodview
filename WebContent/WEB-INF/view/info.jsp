<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>  
<div class="clear"></div>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <link href="css/edit.css" rel="stylesheet">  
<title>Insert title here</title>
<link href="css/info.css" rel="stylesheet">  
<link href="css/main.css" rel="stylesheet">  
</head>
<body>
<div class="container">
	<table class="table table-bordered" id="a">
		<caption>내 정보</caption>
		<colgroup>
                <col width="100" />
                <col width="1000" />
            </colgroup>
		<tr>
			<th>아이디 : </th>
			<td></td>
		</tr>
		<tr>
			<th>이름 : </th>
			<td></td>
		</tr>
		<tr>
			<th>성별 : </th>
			<td></td>
		</tr>
		<tr>
			<th>핸드폰 : </th>
			<td></td>
		</tr>
		<tr>
			<th>이메일 : </th>
			<td></td>
		</tr>
		<tr>
			<th>암호 : </th>
			<td></td>
		</tr>
	</table>
</div>
<div style="margin:0 60px auto">
	<a href="infoedit.jsp"><input type="button" value="번경" onclick="sendData()" class="pull-right" id="getTag"/></a>
</div>
</body>
</html>