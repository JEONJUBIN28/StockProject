package org.seongsu.stockproject.Service;

import org.seongsu.stockproject.Mapper.UserMapper;
import org.seongsu.stockproject.VO.membersVO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final UserMapper userMapper;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public membersVO joinProcess(membersVO membersVO) {
        String id = membersVO.getId();

        String isExist = userMapper.existsByAccount(id);

        if (isExist != null) {
            return null;
        }

        membersVO userEntity = membersVO.builder()
                .id(membersVO.getId())
                .passwd(bCryptPasswordEncoder.encode(membersVO.getPasswd()))
                .name(membersVO.getName())
                .birthday(membersVO.getBirthday())
                .telno(membersVO.getTelno())
                .email(membersVO.getEmail())
                .build();

        userMapper.save(userEntity);

        return userEntity;
    }
}
