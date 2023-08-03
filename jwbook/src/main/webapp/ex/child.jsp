<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Child</title>
</head>
<body>
	<!-- <script>
		function canRide() {
			document.forms['canride'].action = document.forms['canride'].attractions.value
					+ 'canRide.jsp';
			document.forms['canride'].submit();
		}
	</script> -->
	<form action="canRide.jsp" method="post">
		나이: <input type="text" name="age"><br>키: <input
			type="text" name="height"><br>부모 동반: <input
			type="checkbox" name="parent" value="true"><br>심장병: 여 <input
			type="radio" name="heartDisease" value="true"> 부 <input
			type="radio" name="heartDisease" value="false" checked><br>선호
		놀이 기구: 롤러코스터 <input type="checkbox" name="attractions" value="롤러코스터">
		범퍼카 <input type="checkbox" name="attractions" value="범퍼카">
		회전목마 <input type="checkbox" name="attractions" value="회전목마">
		<hr>
		<input type="submit" />
	</form>
</body>
</html>