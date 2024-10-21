package org.seongsu.stockproject.Mapper;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TourMapperTest {

	@Autowired
	private TourMapper tourMapper;
	
	@Disabled
	@Test
	void getTourListTest() {
		System.out.println(tourMapper.getTourList());
	}

}
