<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>투어 상세 정보</title>
<style>
table {
width: 100%;
border-collapse: collapse;
}
th, td {
padding: 8px;
text-align: left;
border: 1px solid #ddd;
}
th {
background-color: #f2f2f2;
}
.button {
margin-top: 20px;
padding: 10px 15px;
background-color: #007BFF; /* 버튼 배경색 */
color: white; /* 버튼 글자색 */
border: none;
border-radius: 5px; /* 모서리 둥글게 */
cursor: pointer; /* 마우스 커서 변경 */
text-decoration: none; /* 링크의 파란 줄 제거 */
}
.button:hover {
background-color: #0056b3; /* hover 시 색상 변화 */
}
</style>
</head>
<body>
<h2>투어 상세 정보</h2>
<table>
<tr>
<th>투어 코드</th>
<td>${tour.tour_code}</td>
</tr>
<tr>
<th>투어 이름</th>
<td>${tour.tour_name}</td>
</tr>
<tr>
<th>투어 주소</th>
<td>${tour.tour_address}</td>
</tr>
<tr>
<th>관광지 설명</th>
<td>${tour.tour_cmmt}</td>
</tr>
<tr>
<th>관리기관 전화번호</th>
<td>${tour.tour_telno}</td>
</tr>
<tr>
<th>수용 인원 수</th>
<td>${tour.custom_cnt}명</td>
</tr>
<tr>
<th>주차 가능 수</th>
<td>${tour.car_cnt}대</td>
</tr>
</table>
<a class="button" href="${pageContext.request.contextPath}/tour/edit?tour_code=${tour.tour_code}">수정</a>
<a href="${pageContext.request.contextPath}/tour/list">목록</a>
</body>
</html>
