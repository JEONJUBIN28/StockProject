<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>게시물 생성</title>
    <style>
        form {
            margin: 20px;
        }
        input, textarea {
            width: 100%;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<h2>게시물 생성</h2>
<form action="${pageContext.request.contextPath}/tour/create" method="post">
    <label for="tour_code">투어 코드:</label>
    <input type="text" id="tour_code" name="tour_code" required>

    <label for="tour_name">투어 이름:</label>
    <input type="text" id="tour_name" name="tour_name" required>

    <label for="area_code">지역 코드:</label>
    <input type="text" id="area_code" name="area_code" required>

    <label for="tour_address">투어 주소:</label>
    <input type="text" id="tour_address" name="tour_address" required>

    <label for="tour_cmmt">관광지 설명:</label>
    <textarea id="tour_cmmt" name="tour_cmmt" required></textarea>

    <label for="tour_telno">관리기관 전화번호:</label>
    <input type="text" id="tour_telno" name="tour_telno" required>

    <label for="custom_cnt">수용 인원 수:</label>
    <input type="number" id="custom_cnt" name="custom_cnt" required>

    <label for="car_cnt">주차 가능 수:</label>
    <input type="number" id="car_cnt" name="car_cnt" required>

    <input type="submit" value="등록">
</form>
</body>
</html>
