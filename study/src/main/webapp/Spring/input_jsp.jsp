<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/study/spring/inputDate" method="post">
		<input type="text" name="hangul" value="안녕" />
		<input type="date" name="date" />
		<button type="submit"></button>
	</form>
	<form action="/study/spring/inputDate2" method="post">
		<input type="text" name="hangul" value="안녕" />
		<input type="date" name="date" />
		<button type="submit"></button>
	</form>
</body>
</html>