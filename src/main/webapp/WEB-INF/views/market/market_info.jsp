<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>전통시장 상세정보</h1>
    <table width="500" border="1">
      <form action="${pageContext.request.contextPath}/market/content_view2" method="post">
          <c:forEach var="market" items="${markets}">
	          <input type="hidden" name="market_code" value="${market.market_code}">
	          <tr>
	            <td>시장코드</td>
	            <td>${market.market_code}</td>      
	         </tr>
	          <tr>
	            <td>시장명</td>
	            <td>${market.market_name}</td>      
	         </tr>
	          <tr>
	            <td>시장개설유형</td>
	            <td>${market.open_type_name}</td>      
	         </tr>
	          <tr>
	            <td>5일장날</td>
	            <td>${market.mrk_open_date}</td>      
	         </tr>
	          <tr>
	            <td>시장주소</td>
	            <td>${market.market_address}</td>      
	         </tr>
	          <tr>
	            <td>엘리베이터보유여부</td>
	            <td>${market.elb_yn}</td>      
	         </tr>
	          <tr>
	            <td>엘리베이터보유여부</td>
	            <td>${market.elb_yn}</td>      
	         </tr>
         </c:forEach>
         
      </form>
   </table>
   
</body>

</html>