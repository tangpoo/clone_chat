package com.study.chat.domain.member.controller;

import com.study.chat.domain.common.controller.dto.ResponseDto;
import com.study.chat.domain.member.controller.facade.MemberFacade;
import com.study.chat.domain.member.controller.response.MemberInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberFacade memberFacade;

    @GetMapping
    public ResponseEntity<?> getInfo(Authentication auth){
        String name = auth.getName();
        MemberInfoResponse info = memberFacade.getInfo(name);

        return new ResponseEntity<>(
            new ResponseDto<>(
                "회원 조회를 완료했습니다.",
                info
            ),
            HttpStatus.OK
        );
    }
}
