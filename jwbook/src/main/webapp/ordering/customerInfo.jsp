<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객정보 조회</title>
</head>
<body>
	<div class="container">
		<label>고객 추가/수정/삭제 하기</label> <br /> <br />
		<form id="customer_form" action="/jwbook/ocontrol?action=addCustomer"
			method="post">
			<!-- <input type="hidden" name="action" id="customer_form_action"/> -->
			<div class="row">
				<label class="cell-2">고객번호</label>
				<div class="cell-10">
					<input type="number" data-role="input" name="id" value="${c.id}"
						id="id" readonly />
				</div>
			</div>
			<div class="row">
				<label class="cell-2">고객명</label>
				<div class="cell-10">
					<input type="text" data-role="input" name="name" value="${c.name}"
						id="name" />
				</div>
			</div>
			<div class="row">
				<label class="cell-2">주소</label>
				<div class="cell-10">
					<input type="text" data-role="input" name="address"
						value="${c.address}" id="address" />
				</div>
			</div>
			<div class="row">
				<label class="cell-2">전화번호</label>
				<div class="cell-10">
					<input type="text" data-role="input" name="phone"
						value="${c.phone}" id="phone" />
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
		<form id="customer_form" action="/jwbook/ocontrol?action=setCustomer"
			method="post">
			<div class="row">
				<label class="cell-2">고객번호</label>
				<div class="cell-10">
					<input type="hidden" data-role="input" name="id" value="${c.id}"
						id="id" readonly />
				</div>
			</div>
			<div class="row">
				<label class="cell-2">고객명</label>
				<div class="cell-10">
					<input type="text" data-role="input" name="name" value="${c.name}"
						id="name" />
				</div>
			</div>
			<div class="row">
				<label class="cell-2">주소</label>
				<div class="cell-10">
					<input type="text" data-role="input" name="address"
						value="${c.address}" id="address" />
				</div>
			</div>
			<div class="row">
				<label class="cell-2">전화번호</label>
				<div class="cell-10">
					<input type="text" data-role="input" name="phone"
						value="${c.phone}" id="phone" />
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
		<form id="customer_form"
			action="/jwbook/ocontrol?action=removeCustomer" method="post">
			<!-- <input type="hidden" name="action" id="customer_form_action"/> -->
			<div class="row">
				<div class="cell-10">
					<input type="hidden" data-role="input" name="id" value="${c.id}"
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

	<%-- <h2>고객정보 조회</h2>
	<hr>
	<ul>
		<li>고객번호: ${c.id }</li>
		<li>고객명: ${c.name }</li>
		<li>주소: ${c.address }</li>
		<li>전화번호: ${c.phone }</li>
	</ul> --%>
</body>
</html>