<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>  
  <div class="clear"></div>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
        integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
        integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
        <link href="css/star.css" rel="stylesheet">
    </meta>
    <title>게시판 목록</title>
    <style type="text/css">
        * {
            font-size: 9pt;
        }

        p {
            width: 400px;
            text-align: right;
        }

        table thead tr th {
            background-color: gray;
        }
    </style>

    <script type="text/javascript">
        function goUrl(url) {
            location.href = url;
        }
    </script>
</head>

<body style="background-color: #191919;">
    <form action="" method="get" name="searchForm">
    </form>
    <div class="container">
        <table class="table table-bordered">
            <caption>게시판 목록</caption>
            <colgroup>
                <col width="200" />
                <col width="1000" />
                <col width="200" />
                <col width="110" />
                <col width="80" />
            </colgroup>
            <tbody>
                <tr>
                    <td rowspan="2" align="center"><img src="#"></td>
                    <td rowspan="2"><a href="review.jsp">사장님이 말하는 소갯말...</a></td>
                    <td align="center">사장 이름</td>
                    <td align="center">작성 날짜</td>
                    <td rowspan="2" align="center">더보기</td>
                </tr>
                <tr>
                    <td align="left">
                    	<div class="wrap-star">
                    		<div class='star-rating'>
                    			<span style ="width:80%"></span>
                    		</div>
                    	</div>
                    </td>
                    <td align="center">조회수</td>
                </tr>
            </tbody>
            <tfoot>
                <tr>
                    <td align="center" colspan="5">1</td>
                </tr>
            </tfoot>
        </table>
    </div>
    <span style="text-align: right; margin:0 5% 0 0; float: right;">
        <input type="button" value="목록" />
        <input type="button" value="글쓰기" />
    </span>

    
</body>

</html>