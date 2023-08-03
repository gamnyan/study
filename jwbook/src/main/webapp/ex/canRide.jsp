<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="ex.*"%>
<%@ page import="org.apache.commons.lang3.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
request.setCharacterEncoding("utf-8");
String ageString = request.getParameter("age");
String heightString = request.getParameter("height");
String parentString = request.getParameter("parent");
String heartDiseaseString = request.getParameter("heartDisease");
String[] attractions = request.getParameterValues("attractions");

int age;
int height;
boolean parent;
boolean heartDisease;

age = Integer.parseInt(StringUtils.defaultIfEmpty(ageString, "0"));
height = Integer.parseInt(StringUtils.defaultIfEmpty(heightString, "0"));
parent = Boolean.parseBoolean(StringUtils.defaultIfEmpty(parentString, "false"));
heartDisease = Boolean.parseBoolean(StringUtils.defaultIfEmpty(heartDiseaseString, "false"));
attractions = ArrayUtils.nullToEmpty(attractions);

Child child = new Child();
child.setAge(age);
child.setHeight(height);
child.setParent(parent);
child.setHeartDisease(heartDisease);
child.setAttractions(attractions);

pageContext.setAttribute("child", child);
/* Object o = pageContext.getAttribute("child");
Child c = (Child) o;
c.getAge(); <이건 위의 반대>*/
%>

<%-- <jsp:useBean id="child" class="ex.Child" />
<jsp:setProperty property="*" name="child" /> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Can Ride</title>
</head>
<body>

	<%-- <%=child.getAge()%><br>
	<%=child.getHeight()%><br>
	<%=child.isParent()%><br>
	<%=child.isHeartDisease()%><br> --%>
	<%
	for (String attraction : child.getAttractions()) {
	%>
	<h2><%=attraction%></h2>
	<br> 탑승

	<%
	if (attraction.equals("롤러코스터")) {
	%>
	<%=child.getCanRideRollerCoaster()%><hr>
	<%
	}
	%>
	<%
	if (attraction.equals("범퍼카")) {
	%>
	<%=child.getCanRideBumpercar()%><hr>
	<%
	}
	%>
	<%
	if (attraction.equals("회전목마")) {
	%>
	<%=child.getCanRideMerrygoround()%><hr>
	<%
	}
	%>
	<%
	}
	%><br>


	<%-- <jsp:getProperty property="age" name="child" />
	<jsp:getProperty property="height" name="child" />
	<jsp:getProperty property="parent" name="child" />
	<jsp:getProperty property="heartDisease" name="child" />
	<jsp:getProperty property="attractions" name="child" />
	<jsp:getProperty property="canRideRollerCoaster" name="child" />
	<%
	for (String attraction : child.getAttractions()) {
	%>
	<%=attraction%>
	<%
	}
	%> --%>

	<%-- ${child.age }
	<br> ${child.height }
	<br> ${child.parent }
	<br> ${child.heartDisease }
	<br> ${child.attractions }
	<br> --%>

	<%-- <c:out value="${child.age }" />
	<br>
	<c:out value="${child.height }" />
	<br>
	<c:out value="${child.parent }" />
	<br>
	<c:out value="${child.heartDisease }" />
	<br>
	<c:out value="${child.attractions }" />
	<br> --%>
</body>
</html>