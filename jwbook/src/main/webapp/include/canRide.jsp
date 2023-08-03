<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="include.*"%>
<%@ page import="org.apache.commons.lang3.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="child" class="include.Child" scope="request" />
	<jsp:setProperty property="*" name="child" />

	<%
	for (String attraction : child.getAttractions()) {
	%>
	<jsp:include page='<%=attraction + ".jsp"%>'>
		<jsp:param value="true" name="include" />
	</jsp:include>
	<%
	}
	%>
</body>
</html>