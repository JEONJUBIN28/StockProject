package org.seongsu.stockproject.Service;

import java.util.List;

import org.seongsu.stockproject.Mapper.TourMapper;
import org.seongsu.stockproject.VO.infotourVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class TourService{
    
    private final TourMapper tourMapper;

    public List<infotourVO> getTourList() {
        return tourMapper.getTourList(); // 전체 게시물 목록 조회
    }
    
    public List<infotourVO> searchTour(String keyword) {
        return tourMapper.searchTour(keyword); // Mapper 메서드 호출
    }

    public int getTotalPages(int pageSize) {
        int totalCount = tourMapper.getTotalCount();
        return (int) Math.ceil((double) totalCount / pageSize);
    }

    public infotourVO getTourDetail(String tour_code) {
        return tourMapper.getTourDetail(tour_code);
    }

    public void updateTour(infotourVO tour) {
        tourMapper.updateTour(tour);
    }

    public void createTour(infotourVO tour) {
        tourMapper.createTour(tour); // 게시물 생성 메서드
    }

    public void deleteTour(String tour_code) {
        tourMapper.deleteTour(tour_code); // 게시물 삭제 메서드
    }
}

