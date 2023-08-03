<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String d = request.getParameter("d");
int result = 0;
if (d.indexOf("+") != -1) {
	String[] op = d.split(("\\+")); //'+'
	int op1 = Integer.parseInt(op[0]);
	int op2 = Integer.parseInt(op[1]);
	result = op1 + op2;
} else if (d.indexOf("-") != -1) {
	String[] op = d.split("-");
	int op1 = Integer.parseInt(op[0]);
	int op2 = Integer.parseInt(op[1]);
	result = op1 - op2;
} else if (d.indexOf("*") != -1) {
	String[] op = d.split("\\*");
	int op1 = Integer.parseInt(op[0]);
	int op2 = Integer.parseInt(op[1]);
	result = op1 * op2;
} else if (d.indexOf("/") != -1) {
	String[] op = d.split("/");
	int op1 = Integer.parseInt(op[0]);
	int op2 = Integer.parseInt(op[1]);
	result = op1 / op2;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기 JSP</title>
</head>
<body>
	<h2>계산 결과-JSP</h2>
	<hr>
	결과:
	<%=result%>
</body>
</html>