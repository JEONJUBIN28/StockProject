package org.seongsu.stockproject.Mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyPageMapperTest {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private BoardMapper boardMapper;
	
	//@Disabled
	@Test
	void selectMyReviewTest() {
		System.out.println("test" + userMapper.findByName("admin2").toString());
		System.out.println("test" + boardMapper.selectMyReviewM("admin2").toString());
		System.out.println("test" + boardMapper.selectMyReviewT("admin2").toString());
	}

}
