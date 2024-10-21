<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>게시판 수정</title>
</head>
<body>
<h2>게시판 수정</h2>
<form action="${pageContext.request.contextPath}/tour/update" method="post">
<input type="hidden" name="tour_code" value="${tour.tour_code}"/>
<label for="tour_name">투어 이름:</label>
<input type="text" name="tour_name" value="${tour.tour_name}"/><br/>

<label for="tour_address">투어 주소:</label>
<input type="text" name="tour_address" value="${tour.tour_address}"/><br/>

<label for="tour_cmmt">설명:</label>
<textarea name="tour_cmmt">${tour.tour_cmmt}</textarea><br/>

<label for="tour_telno">전화번호:</label>
<input type="text" name="tour_telno" value="${tour.tour_telno}"/><br/>

<label for="custom_cnt">수용 인원 수:</label>
<input type="number" name="custom_cnt" value="${tour.custom_cnt}"/><br/>

<label for="car_cnt">주차 가능 수:</label>
<input type="number" name="car_cnt" value="${tour.car_cnt}"/><br/>

<button type="submit">수정</button>
</form>
</body>
</html>
