<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<form action="/regist" method="post">
	<label for="user-id">ID:
		<input type="text" name ="user-id" id="user-id">
	</label>
		<label for="user-pw">password:
		<input type="text" name ="user-pw" id="user-pw">
	</label>
		<label for="user-name">name:
		<input type="text" name ="user-name" id="user-name">
	</label>
	<button>회원가입</button>
</form>

</body>
</html>