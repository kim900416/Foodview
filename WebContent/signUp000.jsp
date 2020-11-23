<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>  
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
		<caption>회원가입</caption>
		<colgroup>
                <col width="100" />
                <col width="1000" />
            </colgroup>
		<tr>
			<th>아이디 : </th>
			<td><input type="text" value="아아디를 입력하세요." name=""></td>
		</tr>
		<tr>
			<th>이름 : </th>
			<td><input type="text" value="이름을 입력하세요." name=""></td>
		</tr>
		<tr>
			<th>성별 : </th>
			<td>
				<input type="radio" name="chk_info" value="남" checked="checked">남
				<input type="radio" name="chk_info" value="여">여
			</td>
		</tr>
		<tr>
			<th>핸드폰 : </th>
			<td><input type="text" value="번호를 입력하세요" name=""></td>
		</tr>
		<tr>
			<th>이메일 : </th>
			<td>
				<input type="text" value="이메일을 입력하세요." name="">@<input type="text" value="직접입력" name="">
				<select>
				<option value="no">직접입력</option>
				<option value="naver">naver.com</option>
				<option value="nate">empas.net</option>
				<option value="google">gmail.com</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>암호 : </th>
			<td><input type="text" value="암호를 입력하세요." name=""></td>
		</tr>
	</table>
</div>
<div style="margin:0 60px auto">
	<a href="index.jsp"><input type="button" value="확인" onclick="sendData()" class="pull-right" id="getTag"/></a>
</div>
</body>
</html>