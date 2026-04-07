package hello.demo.singleton;

import hello.demo.AppConfig;
import hello.demo.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        // 조회 1 : 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        // 조회 2 : 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        Assertions.assertNotEquals(memberService1, memberService2);
    }

}
