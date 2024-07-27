package com.goldbalance.dive.domain.member.api;

import com.goldbalance.dive.domain.member.dto.MemberLogin;
import com.goldbalance.dive.domain.member.dto.request.MemberSignin;
import com.goldbalance.dive.domain.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<Void> signin(@Valid @RequestBody MemberSignin request) {
        memberService.signin(request);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
    }

    @PostMapping("/login")
    public ResponseEntity<MemberLogin> login(@Valid @RequestBody MemberLogin request) {
        MemberLogin response = memberService.login(request);
        return ResponseEntity.ok(response);
    }
}
