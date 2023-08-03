<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서</title>
</head>
<body>
	[
	<a href="/jwbook/orderingControl?action=customerList">고객</a>] [
	<a href="/jwbook/orderingControl?action=orderingList">주문</a>]
	<hr>
	<table border="1">
		<tr>
			<th>도서번호</th>
			<th>도서명</th>
			<th>출판사</th>
			<th>가격</th>
		</tr>
		<c:forEach items="${books}" var="b">
			<tr>
				<td><a href="/jwbook/orderingControl?action=bookInfo&id=${b.id-1}">${b.id}</a></td>
				<td>${b.title}</td>
				<td>${b.publisher}</td>
				<td>${b.price}</td>
			</tr>
		</c:forEach>
	</table>
	<form method="post" action="/jwbook/orderingControl?action=bookInfo&id=-1">
		<button onclick="button">추가</button>
	</form>
</body>
</html>