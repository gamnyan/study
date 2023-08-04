<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="include.*"%>
<%@ page import="org.apache.commons.lang3.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%!boolean canRide(Child c) {
		boolean canRideBumpercar = false;
		if (c.getHeight() >= 120) {
			if (c.getAge() >= 6 || c.isParent() != false) {
				canRideBumpercar = true;
			} else {
				canRideBumpercar = false;
			}
		} else {
			canRideBumpercar = false;
		}
		return canRideBumpercar;
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
<%=canRide%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>범퍼카</title>
</head>
<body>

</body>
</html>