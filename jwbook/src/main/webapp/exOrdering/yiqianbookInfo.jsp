<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 조회</title>
</head>
<body>
	<%-- <table border="1">
		<tr>
			<th>도서번호</th>
			<th>도서명</th>
			<th>출판사</th>
			<th>가격</th>
		</tr>
		<c:forEach items="${books}" var="b">
			<tr>
				<td>${b.id}</td>
				<td>${b.title}</td>
				<td>${b.publisher}</td>
				<td>${b.price}</td>
			</tr>
		</c:forEach>
	</table> --%>
	<hr>
	<h2>도서 추가</h2>
	<hr>
	<form method="post" action="/jwbook/orderingControl">
		<%-- <label>도서명</label> <input type="text" name="title" value="${b.title}" /><br> --%>
		<label>도서명</label> <input type="text" name="title" /><br> <label>출판사</label>
		<input type="text" name="publisher" /><br> <label>가격</label> <input
			type="text" name="price" /><br>
		<button type="submit" name="action" value="addBook">등록</button>
		<button type="submit" name="action" value="removeBook">등록</button>
	</form>

	<%-- <form method="post" action="/jwbook/orderingControl">
		<label>도서명</label> <input type="text" data-role="input" name="title" value="${b.title}"><br> <label>출판사</label>
		<input type="text" name="publisher" data-role="input" value="${b.publisher}"><br> <label>가격</label>
		<input type="text" name="price" data-role="input" value="${b.price}"><br>
		<button type="submit" name="action" value="addBook">등록</button>
		<button type="submit" name="action" value="updateBook">수정</button>
		<button type="submit" name="action" value="removeBook">삭제</button>
	</form> --%>

	<%-- <div class="container">
		<label>도서 추가/수정/삭제 하기</label> <br /> <br />
		<form id="book_form" action="/jwbook/orderingControl" method="post">
			<div class="row">
				<label class="cell-2">도서번호</label>
				<div class="cell-10">
					<input type="hidden" data-role="input" name="id" value="${b.id}"
						id="id" readonly />
				</div>
			</div>
			<div class="row">
				<label class="cell-2">도서명</label>
				<div class="cell-10">
					<input type="text" data-role="input" name="title"
						value="${b.title}" id="title" />
				</div>
			</div>
			<div class="row">
				<label class="cell-2">출판사</label>
				<div class="cell-10">
					<input type="text" data-role="input" name="publisher"
						value="${b.publisher}" id="publisher" />
				</div>
			</div>
			<div class="row">
				<label class="cell-2">가격</label>
				<div class="cell-10">
					<input type="text" data-role="input" name="price"
						value="${b.price}" id="price" />
				</div>
			</div>
			<button type="submit" name="action" value="addBook">등록</button>
			<button type="submit" name="action" value="updateBook">수정</button>
			<button type="submit" name="action" value="removeBook">삭제</button>
		</form>
	</div> --%>
</body>
</html>