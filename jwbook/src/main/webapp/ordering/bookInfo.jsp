<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책정보 조회</title>
</head>
<body>
	<div class="container">
		<label>도서 추가/수정/삭제 하기</label> <br /> <br />
		<form id="book_form" action="/jwbook/ocontrol?action=addBook"
			method="post">
			<!-- <input type="hidden" name="action" id="customer_form_action"/> -->
			<div class="row">
				<label class="cell-2">도서번호</label>
				<div class="cell-10">
					<input type="number" data-role="input" name="id" value="${b.id}"
						id="id" readonly />
				</div>
			</div>
			<div class="row">
				<label class="cell-2">도서명</label>
				<div class="cell-10">
					<input type="text" data-role="input" name="name" value="${b.name}"
						id="name" />
				</div>
			</div>
			<div class="row">
				<label class="cell-2">출판사</label>
				<div class="cell-10">
					<input type="text" data-role="input" name="address"
						value="${b.publisher}" id="address" />
				</div>
			</div>
			<div class="row">
				<label class="cell-2">가격</label>
				<div class="cell-10">
					<input type="text" data-role="input" name="phone"
						value="${b.price}" id="phone" />
				</div>
			</div>
			<div class="row">
				<div class="cell-3"></div>
				<div class="cell-3">
					<button class="button" id="save_button">저장</button>
				</div>
				<div class="cell-3"></div>
				<div class="cell-3"></div>
			</div>
		</form>
		<br />
		<form id="book_form" action="/jwbook/ocontrol?action=setBook"
			method="post">
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
					<input type="text" data-role="input" name="name" value="${b.name}"
						id="name" />
				</div>
			</div>
			<div class="row">
				<label class="cell-2">출판사</label>
				<div class="cell-10">
					<input type="text" data-role="input" name="address"
						value="${b.publisher}" id="address" />
				</div>
			</div>
			<div class="row">
				<label class="cell-2">가격</label>
				<div class="cell-10">
					<input type="text" data-role="input" name="phone"
						value="${b.price}" id="phone" />
				</div>
			</div>
			<div class="row">
				<div class="cell-3"></div>
				<div class="cell-3">
					<button class="button" id="update_button">수정</button>
				</div>
				<div class="cell-3"></div>
				<div class="cell-3"></div>
			</div>
		</form>
		<br />
		<form id="book_form"
			action="/jwbook/ocontrol?action=removeBook" method="post">
			<!-- <input type="hidden" name="action" id="customer_form_action"/> -->
			<div class="row">
				<div class="cell-10">
					<input type="hidden" data-role="input" name="id" value="${b.id}"
						id="id" readonly />
				</div>
			</div>
			<div class="row">
				<div class="cell-3"></div>
				<div class="cell-3">
					<button class="button" id="delete_button">삭제</button>
				</div>
				<div class="cell-3"></div>
				<div class="cell-3"></div>
			</div>
		</form>
	</div>
</body>
</html>