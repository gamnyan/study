<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/jwbook/ocontrol?action=customerList">
		<button onclick="button">고객</button>
	</form>
	<form method="post" action="/jwbook/ocontrol?action=orderList">
		<button onclick="button">주문</button>
	</form>
	<hr>
	<h2>도서 목록</h2>
	<hr>
	<table border="1">
		<tr>
			<th>도서번호</th>
			<th>도서명</th>
			<th>출판사</th>
			<th>가격</th>
		</tr>
		<c:forEach var="b" varStatus="i" items="${books }">
			<tr>
				<th><a href="/jwbook/ocontrol?action=bookInfo&id=${b.id }">${b.id }</a></th>
				<th>${b.name }</th>
				<th>${b.publisher }</th>
				<th>${b.price }</th>
			</tr>
		</c:forEach>
	</table>
	<form method="post" action="/jwbook/ocontrol?action=bookInfo&id=-1">
		<button onclick="button">추가</button>
	</form>
</body>
</html>