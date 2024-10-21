package org.seongsu.stockproject;

import org.junit.jupiter.api.Test;
import org.seongsu.stockproject.Mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StockProjectApplicationTests {

	@Autowired
	private BoardMapper boardRepository;
	
    @Test
    void contextLoads() {
    	System.out.println(boardRepository.selectAllNotice());
    }

}
