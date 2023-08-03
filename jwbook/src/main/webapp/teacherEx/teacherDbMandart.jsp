<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="view" -->
<title>Insert title here</title>
</head>
<body>
	<form action="<c:url value="/mandalaart"/>" method="get">
		<table border="1">
			<c:forEach var="i" begin="0" end="2">
				<tr>
					<c:forEach var="j" begin="0" end="2">
						<c:if test="${3 * i + j == 4}">
							<td>${firstList[3*i+j]}</td>
						</c:if>
						<c:if test="${3 * i + j != 4}">
							<td><input type="submit" name="goal"
								value="${firstList[3 * i + j]}"></td>
						</c:if>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
	</form>

	<c:if test="${! empty param.goal}">
		<table border="1">
			<c:forEach var="i" begin="0" end="2">
				<tr>
					<c:forEach var="j" begin="0" end="2">
						<c:if test="${3 * i + j == 4}">
							<td>${secondList[3*i+j]}</td>
						</c:if>
						<c:if test="${3 * i + j != 4}">
							<td>${secondList[3 * i + j]}</td>
						</c:if>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>