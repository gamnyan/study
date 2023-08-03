<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
	<sql:query var="rs" dataSource="jdbc/jwbookdb">
	SELECT id, name, address, phone FROM customer
	</sql:query>
	<c:forEach var="c" items="${rs.rows}">
	${c.id} / ${c.name} / ${c.address} / ${c.phone}
	<br />
	</c:forEach>
</body>
</html>