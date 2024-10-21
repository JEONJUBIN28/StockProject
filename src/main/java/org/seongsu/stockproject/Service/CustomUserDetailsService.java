package org.seongsu.stockproject.Service;

import lombok.RequiredArgsConstructor;
import org.seongsu.stockproject.VO.CustomUserDetails;
import org.seongsu.stockproject.VO.membersVO;

import java.util.NoSuchElementException;

import org.seongsu.stockproject.Mapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
	
    private final UserMapper userMapper;

    public membersVO findNameByAccount(String id){

        return userMapper.findByName(id);
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
    	
    	System.out.println("userid: + " + id);
    	membersVO userData = userMapper.findByAccount(id);

        if (userData != null){
            return new CustomUserDetails(userData);
        }else {
        	throw new NoSuchElementException("유저를 찾을 수 없습니다.");
        }
        
    }
}
