package org.seongsu.stockproject.Mapper;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.seongsu.stockproject.VO.noticeboardVO;
import org.seongsu.stockproject.VO.reviewboardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardMapperTest {

	@Autowired
	private BoardMapper boardMapper;
	
	@Disabled
	@Test
	void selectAllNoticeTest() {
		System.out.println(boardMapper.selectAllNotice());
	}
	
	//@Disabled
	@Test
	void selectNoticeTest() {
		System.out.println(boardMapper.selectNotice(1L));
	}
	
	@Disabled
	@Test
	void insertNoticeTest() {
		noticeboardVO vo = new noticeboardVO();
		
		vo.setName("테스트작성자");
		vo.setTitle("테스트제목");
		vo.setContent("테스트글내용");
		
		boardMapper.insertNotice(vo);
	}
	
	@Disabled
	@Test
	void updateNoticeTest() {
		noticeboardVO vo = new noticeboardVO();
		
		vo.setNotice_id(2);
		vo.setTitle("테스트제목바꾸기");
		vo.setContent("테스트글내용바꾸기");
		
		boardMapper.updateNotice(vo);
	}
	
	@Disabled
	@Test
	void deleteNoticeTest() {
		boardMapper.deleteNotice(2L);
	}
	
	// 위는 공지사항 게시판 아래는 리뷰게시판

	@Disabled
	@Test
	void selectAllReviewTest() {
		System.out.println(boardMapper.selectAllReview("T1159"));
	}
	
	@Disabled
	@Test
	void selectReviewTest() {
		System.out.println(boardMapper.selectReview(1L));
	}
	
	@Disabled
	@Test
	void insertReviewTest() {
		reviewboardVO vo = new reviewboardVO();
		
		vo.setStar(10);
		vo.setName("테스트1호기");
		vo.setContent("테스트1호기내용");
		vo.setMarket_tour_code("T1159");
		
		boardMapper.insertReview(vo);
	}
	
	@Disabled
	@Test
	void updateReviewTest() {
		reviewboardVO vo = new reviewboardVO();
		
		vo.setReview_id(2);
		vo.setStar(9);
		vo.setContent("테스트1호기내용변경");
		
		boardMapper.updateReview(vo);
	}
	
	@Disabled
	@Test
	void deleteReviewTest() {
		boardMapper.deleteReview(2L);
	}
}
