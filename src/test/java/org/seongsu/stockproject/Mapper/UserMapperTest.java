package org.seongsu.stockproject.Mapper;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.seongsu.stockproject.VO.membersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class UserMapperTest {

	@Autowired
	UserMapper userMapper;

	@Disabled
	@Test
	void findByNameTest() {

	}

	@Disabled
	@Test
	void findByAccountTest() {
		userMapper.findByAccount("admin2");
	}
	
	@Disabled
	@Test
	void existsByAccountTest() {
		String tf = userMapper.existsByAccount("ad");
		System.out.println(tf);
	}
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//@Disabled
	@Test
	void saveTest() {
		membersVO member = new membersVO();
		
		member.setId("admin");
		member.setPasswd(bCryptPasswordEncoder.encode("admin"));
		member.setName("김선우");
		member.setBirthday("880811");
		member.setTelno("01012342580");
		member.setEmail("admin1234@gmail.com");
		
		userMapper.save(member);
	}

}
