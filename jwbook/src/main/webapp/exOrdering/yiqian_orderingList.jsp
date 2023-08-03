<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문</title>
</head>
<body>
	[
	<a href="/jwbook/orderingControl?action=bookList">도서</a>] [
	<a href="/jwbook/orderingControl?action=customerList">고객</a>]
	<hr>
	<table border="1">
		<tr>
			<th>주문번호</th>
			<th>고객명</th>
			<th>도서명</th>
			<th>판매가격</th>
			<th>주문날짜</th>
		</tr>
		<c:forEach items="${orderings}" var="o">
			<tr>
				<%-- <td>${o.id}</td>
				<td>${o.customerId}</td>
				<td>${o.bookId}</td>
				<td>${o.sellingPrice}</td>
				<td>${o.orderingDate}</td> --%>
				<td>${o.id}</td>
				<c:forEach items="${customers}" var="c">
					<c:if test="${o.customerId==c.id}">
						<td>${c.name}</td>
					</c:if>
				</c:forEach>
				<c:forEach items="${books}" var="b">
					<c:if test="${o.bookId==b.id}">
						<td>${b.title}</td>
					</c:if>
				</c:forEach>
				<td>${o.sellingPrice}</td>
				<td>${o.orderingDate}</td>
			</tr>
		</c:forEach>
	</table>
	<%-- <form action="<c:url value="studentControl"/>" method="get">
		<table border="1">

		</table>
	</form> --%>
</body>
</html>