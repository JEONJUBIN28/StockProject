package org.seongsu.stockproject.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.seongsu.stockproject.VO.infotourVO;


@Mapper
public interface TourMapper {
    // 모든 게시물 목록을 가져옵니다.
    List<infotourVO> getTourList();
    
    // 검색 메서드 추가
    List<infotourVO> searchTour(String keyword);

    // 전체 게시물 수를 가져옵니다.
    int getTotalCount();

    // 특정 게시물의 세부 정보를 가져옵니다.
    infotourVO getTourDetail(String tour_code);

    // 게시물 정보를 업데이트합니다.
    void updateTour(infotourVO tour);

    // 새 게시물을 생성합니다.
    void createTour(infotourVO tour);

    // 특정 게시물을 삭제합니다.
    void deleteTour(String tour_code);

	
}
