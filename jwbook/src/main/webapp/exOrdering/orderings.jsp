<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="metro4:locale" content="ko-KR" />
<meta name="metro4:init" content="false" />

<title>Madang Metro</title>

<link rel="stylesheet"
	href="https://cdn.korzh.com/metroui/v4.5.1/css/metro-all.min.css" />
</head>

<body>
	<div data-role="appbar">
		<ul class="app-bar-menu">
			<li><a href="<c:url value="orderingControl?action=orderings"/>">주문</a></li>
			<li><a href="<c:url value="orderingControl?action=customers"/>">고객</a></li>
			<li><a href="<c:url value="orderingControl?action=books"/>">도서</a></li>
		</ul>
	</div>

	<br />
	<br />
	<br />

	<div class="container">
		<form id="ordering_form"
			action="<c:url value="orderingControl?action=createOrdering"/>"
			method="post">
			<div class="container">
				<label>고객</label> <br />
				<div id="customers">
					<c:forEach var="c" items="${customerList}">
						<input type="radio" data-role="radio" name="customerId"
							value="${c.id}" data-caption="${c.name}" />
					</c:forEach>
				</div>
			</div>
			<div class="container">
				<label>도서</label> <br />
				<div id="books">
					<c:forEach var="b" items="${bookList}">
						<input type="radio" data-role="radio" name="bookId"
							value="${b.id}" data-caption="${b.title} (\ ${b.price})" />
					</c:forEach>
				</div>
			</div>
			<div class="container">
				<label>주문 하기</label> <br /> <input type="number"
					name="sellingPrice" id="selling_price" data-role="input"
					data-prepend="판매가: " /> <input type="button" value="주문"
					id="ordering_button" />
			</div>
		</form>
		<div class="container">
			<label>주문</label> <br />
			<table class="table" data-role="table" data-rows="-1"
				data-show-pagination="false" data-show-search="false"
				data-show-rows-steps="false" data-show-table-info="false">
				<thead>
					<tr>
						<th>고객명</th>
						<th>도서명</th>
						<th>판매가격</th>
						<th>주문일자</th>
					</tr>
				</thead>
				<tbody id="orderings">
					<c:forEach var="o" items="${orderingList}">
						<tr>
							<%-- <td>${o.id}</td> --%>
							<td>${o.customer.name}</td>
							<td>${o.book.title}</td>
							<td>${o.sellingPrice}</td>
							<td><fmt:formatDate value="${o.orderingDate}"
									pattern="yyyy-MM-dd" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<script src="https://cdn.korzh.com/metroui/v4.5.1/js/metro.min.js"></script>
	<script>
            Metro.utils.addLocale({
                'ko-KR': {
                    calendar: {
                        months: [
                            'January',
                            'February',
                            'March',
                            'April',
                            'May',
                            'June',
                            'July',
                            'August',
                            'September',
                            'October',
                            'November',
                            'December',
                            'Jan',
                            'Feb',
                            'Mar',
                            'Apr',
                            'May',
                            'Jun',
                            'Jul',
                            'Aug',
                            'Sep',
                            'Oct',
                            'Nov',
                            'Dec',
                        ],
                        days: [
                            'Sunday',
                            'Monday',
                            'Tuesday',
                            'Wednesday',
                            'Thursday',
                            'Friday',
                            'Saturday',
                            'Su',
                            'Mo',
                            'Tu',
                            'We',
                            'Th',
                            'Fr',
                            'Sa',
                            'Sun',
                            'Mon',
                            'Tus',
                            'Wen',
                            'Thu',
                            'Fri',
                            'Sat',
                        ],
                        time: {
                            days: 'DAYS',
                            hours: 'HOURS',
                            minutes: 'MINS',
                            seconds: 'SECS',
                            month: 'MON',
                            day: 'DAY',
                            year: 'YEAR',
                        },
                        weekStart: 0,
                    },
                    buttons: {
                        ok: 'OK',
                        cancel: 'Cancel',
                        done: 'Done',
                        today: 'Today',
                        now: 'Now',
                        clear: 'Clear',
                        help: 'Help',
                        yes: 'Yes',
                        no: 'No',
                        random: 'Random',
                        save: 'Save',
                        reset: 'Reset',
                    },
                    table: {
                        rowsCount: 'Show entries:',
                        search: 'Search:',
                        info: 'Showing $1 to $2 of $3 entries',
                        prev: 'Prev',
                        next: 'Next',
                        all: 'All',
                        inspector: 'Inspector',
                        skip: 'Goto page',
                        empty: 'N/A',
                    },
                    colorSelector: {
                        addUserColorButton: 'ADD TO SWATCHES',
                        userColorsTitle: 'USER COLORS',
                    },
                    switch : {
                        on: 'on',
                        off: 'off',
                    },
                },
            });
            Metro.init();
        </script>
	<script src="exOrdering/orderings.js"></script>
</body>
</html>