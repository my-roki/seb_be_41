package com.codestates.slice;

import com.codestates.exception.BusinessLogicException;
import com.codestates.member.entity.Member;
import com.codestates.member.repository.MemberRepository;
import com.codestates.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;


// Note. Spring을 사용하지 않고 Mockito 기능을 사용하기 위해선 @ExtendWith 어노테이션을 이용합니다.
@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {
    // ? @Mock vs @MockBean
    @Mock
    private MemberRepository memberRepository;

    // Note. @InjectionMock 필드에 @Mock 객체를 주입합니다.
    @InjectMocks
    private MemberService memberService;

    @Test
    public void createMemberTest() {
        Member member = new Member("roki@hello.com", "roki", "010-1111-1111");

        // Note. memberRepository Mock 객체로 Stubbing
        given(memberRepository.findByEmail(member.getEmail())).willReturn(Optional.of(member));

        assertThrows(BusinessLogicException.class, () -> memberService.createMember((member)));
    }
}

