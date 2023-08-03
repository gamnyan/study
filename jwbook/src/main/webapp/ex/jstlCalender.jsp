<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.time.*" import="java.time.temporal.*"
	import="java.util.stream.*" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
LocalDate ld = LocalDate.of(2023, 7, 1);
LocalDate start = ld.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
LocalDate end = start.plusDays(42);
List<LocalDate> days = start.datesUntil(end).collect(Collectors.toList());

pageContext.setAttribute("days", days);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>달력</title>
</head>
<body>
	<h1>2023년 7월</h1>
	<table border="1">
		<c:set var="i" value="0" />
		<c:forEach begin="1" end="6" step="1">
			<tr>
				<c:forEach begin="1" end="7" step="1">
					<c:choose>
						<c:when test="${days[i].monthValue!=7 }">
							<td><c:out value="" /></td>
						</c:when>
						<c:otherwise>
							<td><c:out value="${days[i] }" /></td>
						</c:otherwise>
					</c:choose>
					<c:set var="i" value="${i+1 }" />
				</c:forEach>
		</c:forEach>

	</table>
</body>
</html>