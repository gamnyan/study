<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 목록</title>
</head>
<body>
	<form method="post" action="/jwbook/ocontrol?action=customerList">
		<button onclick="button">고객</button>
	</form>
	<form method="post" action="/jwbook/ocontrol?action=bookList">
		<button onclick="button">도서</button>
	</form>
	<hr>
	<h2>주문 목록</h2>
	<hr>
	<div class="container">
		<form method="post" action="/jwbook/ocontrol?action=addOrder" id="order_form">
			<div class="container">
				<label>고객</label> <br />
				<c:forEach var="c" varStatus="i" items="${customers }">
					<input type="radio" name="customerId" value="${c.id }" /> ${c.name }
			</c:forEach>
			</div>
			<hr>
			<div class="container">
				<label>도서</label> <br />
				<c:forEach var="b" varStatus="i" items="${books }">
					<input type="radio" name="bookId" value="${b.id}" /> ${b.name} ( ${b.price}원 )<br>
				</c:forEach>
			</div>
			<hr>
			<div class="container">
				<label>주문하기</label> <br /> <input type="number" id="saleprice"
					data-role="input" data-prepend="판매가: " />
				<!-- <button class="button" id="orderbutton">주문</button> -->
				<input type="submit" value="주문" id="orderButton" />
			</div>
		</form>
		<hr>
		<div class="container">
			<label>주문</label> <br />
			<div id="orderPage" class="container bg-primary">
				<table border="1" class="table" data-role="table"
					data-show-search="false" data-show-rows-steps="false"
					data-show-table-info="false" style="text-align: center">
					<thead>
						<tr>
							<th>고객번호</th>
							<th>고객명</th>
							<th>도서번호</th>
							<th>도서명</th>
							<th>판매가격</th>
							<th>주문일자</th>
						</tr>
					</thead>
					<tbody id="orderPageTb">
						<c:forEach var="o" varStatus="i" items="${orders }">
							<tr>
								<td>${o.customerId }</td>
								<td><c:forEach var="c" varStatus="i" items="${customers }">
										<c:if test="${(o.customerId)==(c.id) }">
											<a href="/jwbook/ocontrol?action=customerInfo&id=${c.id }">${c.name }</a>
										</c:if>
									</c:forEach></td>
								<td>${o.bookId }</td>
								<td><c:forEach var="b" varStatus="i" items="${books }">
										<c:if test="${(o.bookId)==(b.id) }">
											<a href="/jwbook/ocontrol?action=bookInfo&id=${b.id }">${b.name }</a>
										</c:if>
									</c:forEach></td>
								<td>${o.saleprice }</td>
								<td><fmt:formatDate value="${o.orderDate}"
										pattern="yyyy-MM-dd" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>