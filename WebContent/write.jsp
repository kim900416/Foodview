<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>  
  <div class="clear"></div>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <link href="css/write.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
</head>
<body>
    <div class="wrap">
        <table class="table table-bordered">
            <thead>
                <caption style="color:#fff"> 글쓰기 수정 </caption>
            </thead>
            <tbody>
                <form class="info" action="#" method="post">
                    <tr>
                        <th style="color:#fff">가게 이름: </th>
                        <td><input type="text" placeholder="제목을 입력하세요. " name="subject" class="form-control" /></td>
                    </tr>
                    <tr>
                        <th style="color:#fff">내&emsp;&emsp;용: </th>
                        <td><textarea cols="10" placeholder="내용을 입력하세요. " name="content" class="form-control"></textarea></td>
                    </tr>
                    <tr>
                        <th style="color:#fff">첨부파일: </th>
                        <td><input type="text" placeholder="이미지경로를 지정하세요. " name="subject" class="form-control" /></td>
                    </tr>
                    <tr>
                        <th style="color:#fff">태&emsp;&emsp;그: </th>
                        <td>
                        	<select>
                        		<option value="카페">카페</option>
                        		<option value="바베큐">바베큐</option>
                        		<option value="한국">한국</option>
                        		<option value="시푸드">시푸드</option>
                        		<option value="이탈리아">이탈리아</option>
                        		<option value="일본">일본</option>
                        		<option value="베트남">베트남</option>
                        		<option value="중국">중국</option>
                        	</select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="button" value="등록" onclick="sendData()" class="pull-right" id="getTag"/>
                            <input type="reset" value="reset" class="pull-left" />
                            <input type="button" value="목록" class="pull-right" />
                        </td>
                    </tr>
                </form>
            </tbody>
        </table>
    </div>
    <script type="text/javascript">
    $("#getTag").on("click", function() {
    	  var txt = $("#txt").val();
    	  var tags = [];
    	  txt = txt.replace(/#[^#\s,;]+/gm, function(tag) {
    	    tags.push(tag);
    	  });
    	  $("#tags").html(tags.join('<br />'));
    	});
    </script>
</body>
</html>