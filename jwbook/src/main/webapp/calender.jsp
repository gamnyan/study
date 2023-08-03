<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.time.*"
    import="java.time.temporal.*"
    import="java.util.stream.*" 
    import= "java.util.*"%>
<% 

LocalDate ld = LocalDate.of(2023,7,1);
LocalDate start = ld.with(
		TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY)
		);
LocalDate end = start.plusDays(42);
List<LocalDate> days = start.datesUntil(end).collect(Collectors.toList());

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calendar Making</title>
</head>
<body>
<p>2023년 7월</p>
    <table border="1">
	<%for (int i = 0; i <= 5; i++) {%>
	<tr>
    	<%for( int j=0;j<7;j++){%>
  			<td><%=days.get(7*i+j)%> </td>
    	<%}%>
    </tr>
    <%}%>
    </table>
</body>
</html>