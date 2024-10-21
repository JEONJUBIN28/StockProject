<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.seongsu.stockproject.VO.infomarketVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<style type="text/css">
header {
	background-color: steelblue;
	color: white;
	height: 70px;
	line-height: 70px;
	text-align: center;
}

exebtn {
	text-align: center;
	margin: auto;
}

nav {
	background-color: black;
	color: white;
	height: 40px;
	line-height: 40px;
	text-align: center;
}

section {
	magin: 0;
	background-color: #d3d3d3;
	color: black;
	min-height: 100px;
}

footer {
	background-color: black;
	color: white;
	height: 50px;
	line-height: 50px;
	text-align: center;
	font-size: 12px;
}

a:link, a:visited {
	color: white;
	text-decoration: none;
}

button {
	background-color: steelblue;
	color: white;
	width: 80px;
	display: block;
	margin: auto;
}

table {
	width: 100%;
	max-width: 1300px;
	height: 50px;
	border: 1px solid #dfdfdf;
	border-collapse: collapse;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.15);
	border-radius: 5px;
	overflow: hidden;
	margin-left: auto;
	margin-right: auto;
}

tr, td {
	border-bottom: 1px solid #ffffff;
	border-left: 1px solid #ffffff;
	padding: 10px;
	background-color: #f4f4f4;
}
</style>

<script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=3aa5afcfd2ce2ecf6f97c5fd47ea7712&libraries=services"></script>
<!-- <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=bf8a6db3fda86ed31560967cf7a7cc9d&libraries=services"></script> -->
<div id="map" style="width:100%;height:350px;"></div>
<script type="text/javascript">
        
        // 지도 표시 함수 (주소로 조회)


     // GPS 좌표로 지도 표시 함수
        function showMapByCoords(lat, lng, mrk_name, map) {
            if (lat && lng) {
                var coords = new kakao.maps.LatLng(lat, lng);

                // 지도 중심을 GPS 좌표로 이동
                map.setCenter(coords);

                // 마커를 GPS 좌표 위치에 표시
                var marker = new kakao.maps.Marker({
                    map: map,
                    position: coords
                });

                // 마커에 장소명을 표시하는 인포윈도우 추가
                var infowindow = new kakao.maps.InfoWindow({
                    content: '<div style="padding:5px;">' + mrk_name + '</div>'
                });
                infowindow.open(map, marker);
            } else {
                alert('좌표 정보가 없습니다.');
            }
        }
</script>

<script type="text/javascript">

function showMapByAddress(address, mrk_name,lat, lng){  
	
	console.log(lat, lng);
	
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
        
    mapOption = { 
            center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 초기 중심 좌표
            level: 3 // 지도의 확대 레벨
        }; 

    var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성

    // 주소가 존재할 경우
    if (address && address !== '') {
        var geocoder = new kakao.maps.services.Geocoder();
        
        // 주소로 좌표를 검색
        geocoder.addressSearch(address, function(result, status) {
            if (status === kakao.maps.services.Status.OK) {
                var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

                // 지도 중심을 검색된 좌표로 이동
                map.setCenter(coords);

                // 마커를 지도에 표시
                var marker = new kakao.maps.Marker({
                    map: map,
                    position: coords
                });
             	// 마커에 장소명을 표시하는 인포윈도우 추가
                var infowindow = new kakao.maps.InfoWindow({
                    content: '<div style="padding:5px;">' + mkk_name + '</div>'
                });
                infowindow.open(map, marker);
                
                
            } else {
                // 주소 검색이 실패하면 GPS 좌표로 지도 이동
                alert('주소 검색에 실패했습니다. GPS 좌표로 지도를 표시합니다.');
                showMapByCoords(lat, lng, mrk_name,map);
            }
        });
    } else {
        // 주소가 없으면 GPS 좌표로 지도 표시
        showMapByCoords(lat, lng, mrk_name, map);
    }          
    
}
</script>


<script>

        function searchMarketList() {
            const area_code = $('#area_code').val();
            const mrk_open_type = $('#mrk_open_type').val();
            const market_name = $('#market_name').val();
            
            $.ajax({
                url: '/market/marketlist',
                method: 'GET',
                dataType: 'json',  // 서버 응답 데이터가 JSON 형식임을 명시
                data: { area_code: area_code, mrk_open_type: mrk_open_type ,market_name: market_name  },
                success: function(data) {
                	
                	console.log(data);
                	 
                	
                    $('#result').empty();
                    data.forEach(function(marketlist) {
                        console.log(marketlist);
                        console.log(marketlist.mrk_open_type);
                        console.log(`marketlist1========= ${'${marketlist.mrk_open_type}'} `);
   
    					/* <td align="center"><a href="#"  class="btn btn-success"
						onclick="showMapByAddress(${'${marketlist.market_address}'},${'${marketlist.market_name}'}, ${'${marketlist.wido}'}, ${'${marketlist.gyungdo}'})">
					</a>지도</td> */
					
                    	$('#result').append(`
                            <tr>
            					<td align="center">${'${marketlist.market_code}'}</td>
            					<td align="center">${'${marketlist.market_name}'}</td>
            					<td align="center">${'${marketlist.area_name}'}</td>
            					<td align="center">${'${marketlist.market_address}'}</td>
            					<td align="center">${'${marketlist.open_type_name}'}</td>
            					<td align="center">${'${marketlist.mrk_open_date}'}</td>
            					
            					<input type="hidden" class="market_code" 	value="${'${marketlist.market_code}'}">
            					<input type="hidden" class="market_name" 	value="${'${marketlist.market_name}'}">
            					<input type="hidden" class="market_address" value="${'${marketlist.market_address}'}">
            					<input type="hidden" class="area_code" 		value="${'${marketlist.area_code}'}">
            					<input type="hidden" class="mrk_open_type" 	value="${'${marketlist.mrk_open_type}'}">
            					<input type="hidden" class="ark_yn" 		value="${'${marketlist.ark_yn}'}">
            					<input type="hidden" class="elb_yn" 		value="${'${marketlist.elb_yn}'}">
            					<input type="hidden" class="cus_yn" 		value="${'${marketlist.cus_yn}'}">
            					<input type="hidden" class="spr_yn" 		value="${'${marketlist.spr_yn}'}">
            					<input type="hidden" class="fire_yn" 		value="${'${marketlist.fire_yn}'}">
            					<input type="hidden" class="child_yn" 		value="${'${marketlist.child_yn}'}">
            					<input type="hidden" class="call_yn" 		value="${'${marketlist.call_yn}'}">
            					<input type="hidden" class="hyu_yn" 		value="${'${marketlist.hyu_yn}'}">
            					<input type="hidden" class="mo_yn" 			value="${'${marketlist.mo_yn}'}">
            					<input type="hidden" class="mulpum_yn" 		value="${'${marketlist.mulpum_yn}'}">
            					<input type="hidden" class="cycle_yn" 		value="${'${marketlist.cycle_yn}'}">
            					<input type="hidden" class="play_yn" 		value="${'${marketlist.play_yn}'}">
            					<input type="hidden" class="book_yn" 		value="${'${marketlist.book_yn}'}">
            					<input type="hidden" class="cart_yn" 		value="${'${marketlist.cart_yn}'}">
            					<input type="hidden" class="frgn_yn" 		value="${'${marketlist.frgn_yn}'}">
            					<input type="hidden" class="road_yn" 		value="${'${marketlist.road_yn}'}">
            					<input type="hidden" class="broad_yn" 		value="${'${marketlist.broad_yn}'}">
            					<input type="hidden" class="culture_yn" 	value="${'${marketlist.culture_yn}'}">
            					<input type="hidden" class="cargo_yn" 		value="${'${marketlist.cargo_yn}'}">
            					<input type="hidden" class="parking_yn" 	value="${'${marketlist.parking_yn}'}">
            					<input type="hidden" class="edu_yn" 		value="${'${marketlist.edu_yn}'}">
            					<input type="hidden" class="meeting_yn" 	value="${'${marketlist.meeting_yn}'}">
            					<input type="hidden" class="heart_yn" 		value="${'${marketlist.heart_yn}'}">
            					<input type="hidden" class="toilet_yn" 		value="${'${marketlist.toilet_yn}'}">
            					<input type="hidden" class="wido" 			value="${'${marketlist.wido}'}">
            					<input type="hidden" class="gyungdo" 		value="${'${marketlist.gyungdo}'}">
            					<input type="hidden" class="homepage" 		value="${'${marketlist.homepage}'}">
            					<input type="hidden" class="tel_no" 		value="${'${marketlist.tel_no}'}">
            					<input type="hidden" class="area_name" 		value="${'${marketlist.area_name}'}">
            					<input type="hidden" class="open_type_name" value="${'${marketlist.open_type_name}'}">
            					<input type="hidden" class="mrk_open_date" 	value="${'${marketlist.mrk_open_date}'}">
            					
            					<td align="center"><button  class="btn btn-success map-button">지도</button></td>
            					<td align="center"><button  class="btn btn-success mrk-button">상세보기</button></td>
            					
                            </tr>  
                        `);                   	
                    	
                    });
                    $(document).on("click",".map-button",function(){
                    	console.log(this);
                    	
                    	let market_address = $(this).parent().parent().find(".market_address").val();
                    	let market_name = $(this).parent().parent().find(".market_name").val();
                    	let wido = $(this).parent().parent().find(".wido").val();
                    	let gyungdo = $(this).parent().parent().find(".gyungdo").val();
                    	
                    	showMapByAddress(market_address,market_name,wido,gyungdo);
                    	console.log(test);
                    });
                    
                    $(document).on("click",".mrk-button",function(){
                    	console.log(this);
                    	
                    	let market_code = $(this).parent().parent().find(".market_code").val();
                    	
                    	console.log("market_list.jsp >>> =========" + market_code);

                        $.ajax({
                            url: '/market/marketinfo/'+ market_code,
                            method: 'POST',
                            success: function(response) {
                                var newWindow = window.open('', '_blank');
                                newWindow.document.write(response);
                                newWindow.document.close();
                            },
                            error: function() {
                                alert('상세정보 조회 중 오류가 발생했습니다.');
                            }
                        });
                    });
                    
                },
                error: function() {
                    alert('조회 중 오류가 발생했습니다.');
                }
            });
        }

</script>
<script>

</script>


</head>




<body>

	<header>
		<h1>김삿갓팀 전통시장 안내시스템</h1>
	</header>

	<form onsubmit="event.preventDefault(); searchMarketList();">

		<section>
			<br>

			<div class="text-center mt-3 mb-3">

				<td>
					<div class="text-center">
						<span>지역구분</span> <select id="area_code" name=area_code>
							<option value="" selected disabled>지역 선택</option>
							<option value="99">전체</option>
							<option value="10">강원도</option>
							<option value="11">경기도</option>
							<option value="12">경상남도</option>
							<option value="13">경상북도</option>
							<option value="14">광주광역시</option>
							<option value="15">대구광역시</option>
							<option value="16">대전광역시</option>
							<option value="17">부산광역시</option>
							<option value="18">서울특별시</option>
							<option value="19">세종특별시</option>
							<option value="20">울산광역시</option>
							<option value="21">인천관역시</option>
							<option value="22">전라남도</option>
							<option value="23">전라북도</option>
							<option value="24">제주특별시</option>
							<option value="25">충청남도</option>
							<option value="26">충청북도</option>
						</select> 
						<span>시장유형</span> <select id="mrk_open_type" name=mrk_open_type>
							<option value="" selected disabled>시장유형선택</option>
							<option value="9">전체</option>
							<option value="1">상설장</option>
							<option value="2">상설+5일장</option>
							<option value="3">5일장</option>
						</select> 
						<span>시장명</span>
						<td><input type="text" id="market_name" name="market_name"></td>

					<input type="submit" value="조회하기"> <input type="reset"
						value="지우기">

					</div>
				</td>
			</div>
<!-- 			<div class="text-center mt-3 mb-5">
				<div class="text-center">
					<input type="submit" value="조회하기"> <input type="reset"
						value="지우기">
				</div>
			</div>
 -->		</section>
	</form>

	<section>
		<table border="1">
			<thead>
				<tr align="center">

					<td>시장ID</td>
					<td>시장명</td>
					<td>지역</td>
					<td>시장주소</td>
					<td>시장유형</td>
					<td>5일장</td>
					<td>지도보기</td>
					<td>상세정보</td>
				</tr>
			</thead>

			<tbody id="result">
			</tbody>

		</table>
	</section>

	<footer> </footer>

</body>
</html>