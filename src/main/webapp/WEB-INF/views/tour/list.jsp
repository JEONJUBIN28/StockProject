<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>게시판 목록</title>
<style>
table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}

tr {
	transition: background-color 0.3s;
}

tr:hover {
	background-color: #f1f1f1;
}
</style>
</head>
<body>
	<h2>게시판 목록</h2>
	<a href="${pageContext.request.contextPath}/tour/create"
		style="margin-bottom: 20px; display: inline-block; padding: 10px 15px; background-color: #007BFF; color: white; text-decoration: none; border-radius: 5px;">게시물
		등록</a>

	<!-- 검색 폼 추가 -->
	<form action="${pageContext.request.contextPath}/tour/search" method="get">
		<input type="text" name="keyword" placeholder="검색어 입력" required>
		<input type="submit" value="검색">
	</form>

	<!-- 돌아가기 버튼 추가 -->
	<a href="${pageContext.request.contextPath}/tour/list"
		style="margin-top: 20px; display: inline-block; padding: 10px 15px; background-color: #6c757d; color: white; text-decoration: none; border-radius: 5px;">돌아가기</a>

	<table>
		<tr>
			<th>투어 이름</th>
			<th>투어 주소</th>
			<th></th>
		</tr>
		<c:forEach var="tour" items="${tourList}">
			<tr>
				<td><a
					href="${pageContext.request.contextPath}/tour/detail?tour_code=${tour.tour_code}">${tour.tour_name}</a></td>
				<td>${tour.tour_address}</td>
				<td>
					<form action="${pageContext.request.contextPath}/tour/delete" method="post" style="display: inline;">
						<input type="hidden" name="tour_code" value="${tour.tour_code}">
						<input type="submit" value="삭제"
							onclick="return confirm('삭제하시겠습니까?');">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
