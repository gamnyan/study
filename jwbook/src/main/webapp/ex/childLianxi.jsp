<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.*"%>
<%@page import="ex.Child"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
List<Integer> ageList = new ArrayList<>();
List<Integer> heightList = new ArrayList<>();
List<Boolean> parentList = new ArrayList<>();
List<Boolean> heartDiseaseList = new ArrayList<>();

for (int i = 0; i < 100; i++) {
	int r = (int) Math.floor(Math.random() * 17 + 1);
	ageList.add(r);
}
for (int i = 0; i < 100; i++) {
	int r = (int) Math.floor(Math.random() * 160 + 40);
	heightList.add(r);
}
for (int i = 0; i < 100; i++) {
	boolean flag = false;
	int r = (int) Math.floor(Math.random() * 2);
	if (r == 1) {
		flag = false;
	} else {
		flag = true;
	}
	parentList.add(flag);
}
for (int i = 0; i < 100; i++) {
	boolean flag = false;
	int r = (int) Math.floor(Math.random() * 2);
	if (r == 1) {
		flag = false;
	} else {
		flag = true;
	}
	heartDiseaseList.add(flag);
}

List<Child> childs = new ArrayList<>();
pageContext.setAttribute("childs", childs);

for (int i = 0; i < ageList.size(); i++) {
	Child child = new Child();
	child.setAge(ageList.get(i));
	child.setHeight(heightList.get(i));
	child.setParent(parentList.get(i));
	child.setHeartDisease(heartDiseaseList.get(i));
	childs.add(child);
}
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Child</title>

<style>
td {
	width: 100px;
	height: 70px;
	text-align: center;
}

span {
	display: inline-block;
	width: 120px;
	text-align: center;
}

div {
	width: 100%;
	height: 100%;
	line-height: 70px;
	font-size: 1.3em;
	font-weight: bold;
}
</style>
</head>
<body>


	<h1>Child List</h1>

	<table border="1">
		<tr>
			<td>No</td>
			<td>나이</td>
			<td>키</td>
			<td>부모 동반</td>
			<td>심장병</td>
			<td>탑승</td>
		</tr>

		<c:forEach var="child" varStatus="i" items="${childs}">
			<tr>
				<td><div>${i.index + 1}</div></td>

				<c:if test="${child.age >= 6 }">
					<td><div style="color: green">${child.age }</div></td>
				</c:if>
				<c:if test="${child.age < 6 }">
					<td><div style="color: red">${child.age }</div></td>
				</c:if>

				<c:if test="${child.height >= 120 }">
					<td><div style="color: green">${child.height }</div></td>
				</c:if>
				<c:if test="${child.height < 120 }">
					<td><div style="color: red">${child.height }</div></td>
				</c:if>

				<c:if test="${child.parent == true }">
					<td><div style="color: green">${child.parent }</div></td>
				</c:if>
				<c:if test="${child.parent != true }">
					<td><div style="color: red">${child.parent }</div></td>
				</c:if>

				<c:if test="${child.heartDisease == true }">
					<td><div style="color: green">${child.heartDisease }</div></td>
				</c:if>
				<c:if test="${child.heartDisease != true }">
					<td><div style="color: red">${child.heartDisease }</div></td>
				</c:if>

				<c:if test="${child.canRide == '가능' }">
					<td><div style="color: green">${child.canRide }</div></td>
				</c:if>
				<c:if test="${child.canRide != '가능' }">
					<td><div style="color: red">${child.canRide }</div></td>
				</c:if>

			</tr>
		</c:forEach>
	</table>

</body>
</html>