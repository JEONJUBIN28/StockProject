package org.seongsu.stockproject.Controller;

import org.seongsu.stockproject.Service.JoinService;
import org.seongsu.stockproject.VO.membersVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/signUp")
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    @PostMapping("/join")
    public ResponseEntity<membersVO> joinNewUser(@RequestBody membersVO membersVO) {
    	membersVO members = joinService.joinProcess(membersVO);
    	
    	System.out.println(members);
    	
        return ( membersVO != null ) ? ResponseEntity.status(HttpStatus.OK).body(members) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
