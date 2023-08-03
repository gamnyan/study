<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="include.*"%>
<%@ page import="org.apache.commons.lang3.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%!boolean canRide(Child c) {
		boolean canRideMerrygoround = true;
		return canRideMerrygoround;
	}%>
<%
Child child = (Child) request.getAttribute("child");
String canRide = "";
if (canRide(child)) {
	canRide = "탑승 가능";
} else {
	canRide = "탑승 불가능";
}
%>
<h1>회전목마</h1>
<%=canRide%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>