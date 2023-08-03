<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:set var="ages" value="${[5,6] }" />
	<c:set var="heights" value="${[110,120] }" />
	<c:set var="parents" value="${[true,false] }" />
	<c:set var="heartDiseases" value="${[true,false] }" />


	<form style="text-align: center">
		<table border="1">
			<tr style="color: blue">
				<td>No</td>
				<td>나이</td>
				<td>키</td>
				<td>부모동반</td>
				<td>심장질환</td>
				<td>탑승여부</td>
			</tr>
			<c:forEach var="age" items="${ages}">
				<c:forEach var="height" items="${heights}">
					<c:forEach var="parent" items="${parents}">
						<c:forEach var="heartDisease" items="${heartDiseases}">
							<c:set var="i" value="${i+1 }" />
							<c:set var="canRide"
								value="${height>=120&&heartDisease!=false&&(age>=6||parent!=false)?'가능':'불가' }" />

							<tr>
								<td style="color: blue">${i}</td>
								<c:choose>
									<c:when test="${age>=6 }">
										<td style="color: green">${age }</td>
									</c:when>
									<c:otherwise>
										<td style="color: red">${age }</td>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${height>=120 }">
										<td style="color: green">${height }</td>
									</c:when>
									<c:otherwise>
										<td style="color: red">${height }</td>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${parent!=false }">
										<td style="color: green">${parent }</td>
									</c:when>
									<c:otherwise>
										<td style="color: red">${parent }</td>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${heartDisease!=false }">
										<td style="color: green">${heartDisease }</td>
									</c:when>
									<c:otherwise>
										<td style="color: red">${heartDisease }</td>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${canRide!='불가' }">
										<td style="color: green">${canRide }</td>
									</c:when>
									<c:otherwise>
										<td style="color: red">${canRide }</td>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
					</c:forEach>
				</c:forEach>
			</c:forEach>
		</table>
	</form>
</body>
</html> --%>