package org.seongsu.stockproject.Service;

import java.util.List;

import org.seongsu.stockproject.Mapper.UserMapper;
import org.seongsu.stockproject.VO.membersVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final UserMapper userMapper;

	@Transactional
	public List<membersVO> getAllMember() {
		return userMapper.selectAllMember();
	}

	@Transactional
	public membersVO getMember(String id) {
		return userMapper.selectMember(id);
	}

	@Transactional
	public void deleteMember(String id) {
		userMapper.deleteMember(id);
	}
	
}
