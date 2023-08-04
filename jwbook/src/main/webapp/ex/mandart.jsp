
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.PrintWriter"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
Map<String, List<String>> firstMap = new HashMap<>();
firstMap.put("점심", Arrays.asList("중식", "일식", "고기", "라면", "기타", "한식", "치킨", "분식/야식 디저트"));

List<String> firstList = new ArrayList<>();
firstList.addAll(firstMap.get("점심"));
firstList.add(4, "점심");

Map<String, List<String>> secondMap = new HashMap<>();
for (String s : firstMap.get("점심")) {
	secondMap.put(s, null);
}

secondMap.put("중식", Arrays.asList("탕수육", "깐풍기", "칠리새우", "짬뽕", "사천 탕수육", "짜장면", "유린기", "북경식 탕수육"));
secondMap.put("일식", Arrays.asList("초밥", "돈부리", "참치회", "소바", "오코노미야끼", "라멘", "장어덮밥", "우동"));
secondMap.put("고기", Arrays.asList("삼겹살", "갈비", "갈매기살", "항정살", "목살", "가브리살", "등심", "안심"));
secondMap.put("라면", Arrays.asList("비빔면", "신라면", "짜파게티", "너구리", "불닭볶음면", "삼양라면", "진라면", "안성탕면"));
secondMap.put("기타", Arrays.asList("스테이크", "파스타", "훈제오리", "햄버거", "베트남칼국수", "피자", "만두", "커리"));
secondMap.put("한식", Arrays.asList("냉면", "설렁탕", "닭도리탕", "간장게장", "김치찌개", "된장찌개", "불고기백반", "곱창"));
secondMap.put("치킨", Arrays.asList("양념치킨", "뿌링클", "파닭", "고추바사삭", "후라이드", "간장치킨", "마요네즈치킨", "옛날통닭"));
secondMap.put("분식/야식 디저트", Arrays.asList("떡볶이", "순대", "김밥", "어묵", "빙수", "케이크", "빵", "푸딩"));

String goal = request.getParameter("goal");

List<String> secondList = new ArrayList<>();

if (goal != null) {
	secondList.addAll(secondMap.get(goal));
	secondList.add(4, goal);
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>점심 메뉴 고르기</title>
</head>
<body>
	<form method="get">
		<table border="1">
			<%
			for (int i = 0; i < 3; i++) {
			%>
			<tr>
				<%
				for (int j = 0; j < 3; j++) {
				%>
				<%
				if (3 * i + j == 4) {
				%>
				<td><%=firstList.get(3 * i + j)%></td>
				<%
				} else {
				%>
				<td><input type="submit" name="goal"
					value="<%=firstList.get(3 * i + j)%>"></td>
				<%
				}
				%>
				<%
				}
				%>
			</tr>
			<%
			}
			%>
		</table>
	</form>
	<hr>
	<form>
		<%
		if (goal != null) {
		%>
		<table border="1">
			<%
			for (int i = 0; i < 3; i++) {
			%>
			<tr>
				<%
				for (int j = 0; j < 3; j++) {
				%>
				<td><%=secondList.get(3 * i + j)%></td>
				<%
				}
				%>
			</tr>
			<%
			}
			%>
			<%
			}
			%>
		</table>
	</form>
</body>
</html>

<!-- //풀어서
Set<Map.Entry<String, List<String>>> entrySet = secondMap.entrySet();
for (Map.Entry<String, List<String>> entry : entrySet) {

	List<String> value = entry.getValue();
	if (value.contains(s)) {
		s = entry.getKey();
	}			
}

//간단하게
for (Map.Entry<String, List<String>> entry : secondMap.entrySet()) {
	if (entry.getValue().contains(s)) {
		s = entry.getKey();
	}
}
System.out.println(s);

for (Map.Entry<String, List<String>> entry : firstMap.entrySet()) {
	if (entry.getValue().contains(s)) {
		s = entry.getKey();
	}
}
System.out.println(s);

List<String> secondList = new ArrayList<>();
secondList.addAll(secondMap.get("중식"));
secondList.add(4, "중식");

List<String> thirdList = new ArrayList<>();
thirdList.addAll(secondMap.get("일식"));
thirdList.add(4, "일식");
} -->