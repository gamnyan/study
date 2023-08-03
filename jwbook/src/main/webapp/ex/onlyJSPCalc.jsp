<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String n1String = request.getParameter("n1");
String n2String = request.getParameter("n2");
String opString = request.getParameter("op");
int n1;
int n2;
String op;
if (n1String == null) {
	n1 = 0;
} else {
	n1 = Integer.parseInt(n1String);
}
if (n2String == null) {
	n2 = 0;
} else {
	n2 = Integer.parseInt(n1String);
}
if (opString == null) {
	op = "";
} else {
	op = opString;
}

long result = 0;

switch (op) {
case "+":
	result = n1 + n2;
	break;
case "-":
	result = n1 - n2;
	break;
case "*":
	result = n1 * n2;
	break;
case "/":
	result = n1 / n2;
	break;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>계산기</h2>
	<hr>
	<form>
		<input type="text" name="n1"><select name="op">
			<option>+</option>
			<option>-</option>
			<option>*</option>
			<option>/</option>
		</select><input type="text" name="n2"> <input type="submit" value="실행">
	</form>
	<hr>
	<h2>계산 결과</h2>
	<%=n1%>
	<%=op%>
	<%=n2%>
	=
	<%=result%>
</body>
</html>