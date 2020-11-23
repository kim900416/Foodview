<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/login.css" rel="stylesheet">  
</head>
<body>
<form class="box" action="login.do" method="post">
<h1>Login</h1>
<input type="text" name="id"  value="${param.id}" placeholder="Username">
<input type="password" type="password" name="password" placeholder="Password">
<input type="submit" name="" value="login">
</form>
</body>
</html>