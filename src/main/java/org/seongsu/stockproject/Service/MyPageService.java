package org.seongsu.stockproject.Service;

import org.seongsu.stockproject.Mapper.BoardMapper;
import org.seongsu.stockproject.Mapper.UserMapper;
import org.seongsu.stockproject.VO.membersVO;
import org.seongsu.stockproject.VO.myPageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyPageService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private BoardMapper boardMapper;
	
	public myPageVO getMyPage(String id) {
		myPageVO myPage = new myPageVO();
		
		myPage.setMembers(userMapper.findByName(id));
		myPage.setReviewboardM(boardMapper.selectMyReviewM(id));
		myPage.setReviewboardT(boardMapper.selectMyReviewT(id));
		
		return myPage;
	}
	
	public void updateMember(membersVO member) {
		userMapper.updateMember(member);
	}
	
}
