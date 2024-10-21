package org.seongsu.stockproject.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.seongsu.stockproject.JoinVO.reviewboardMNameVO;
import org.seongsu.stockproject.JoinVO.reviewboardTNameVO;
import org.seongsu.stockproject.VO.noticeboardVO;
import org.seongsu.stockproject.VO.reviewboardVO;

@Mapper
public interface BoardMapper {
	List<noticeboardVO> selectAllNotice();

	noticeboardVO selectNotice(Long id);

	void insertNotice(noticeboardVO notice);

	void updateNotice(noticeboardVO notice);

	void deleteNotice(Long id);

	// 위는 공지사항 게시판 아래는 리뷰게시판
	
	List<reviewboardVO> selectAllReview(String code);

	reviewboardVO selectReview(Long id);

	void insertReview(reviewboardVO review);

	void updateReview(reviewboardVO review);

	void deleteReview(Long id);
	
	// 마이페이지
	List<reviewboardMNameVO> selectMyReviewM(String id);
	List<reviewboardTNameVO> selectMyReviewT(String id);
}
