<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 목록</title>
</head>
<body>
	<form method="post" action="/jwbook/ocontrol?action=orderList">
		<button onclick="button">주문</button>
	</form>
	<form method="post" action="/jwbook/ocontrol?action=bookList">
		<button onclick="button">도서</button>
	</form>
	<hr>
	<h2>고객 목록</h2>
	<hr>
	<table border="1">
		<tr>
			<th>고객번호</th>
			<th>고객명</th>
			<th>주소</th>
			<th>전화번호</th>
		</tr>
		<c:forEach var="c" varStatus="i" items="${customers }">
			<tr>
				<th><a href="/jwbook/ocontrol?action=customerInfo&id=${c.id }">${c.id }</a></th>
				<th>${c.name }</th>
				<th>${c.address }</th>
				<th>${c.phone }</th>
			</tr>
		</c:forEach>
	</table>
	<form method="post" action="/jwbook/ocontrol?action=customerInfo&id=-1">
		<button onclick="button">추가</button>
	</form>
	<!-- <div class="container">
		<form id="goto_form" action="/jwbook/ocontrol" method="get">
			<input type="hidden" name="action" value="customer" /> <input
				type="hidden" name="id" value="-1" /> <input type="submit"
				value="추가" id="customerButton" />
		</form>
	</div> -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
		integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>

	<script>
		let hasOrder = ${hasOrder};

		/* window.addEventListener('load', function() {
			if (hasOrder) {
				alert("주문이 있습니다.");
			}
		}); */
		$(function() {
			if (hasOrder) {
				alert("주문이 있습니다.");
			}
		});
	</script>

	<c:set var="hasOrder" scope="session" value="false" />
</body>
</html>