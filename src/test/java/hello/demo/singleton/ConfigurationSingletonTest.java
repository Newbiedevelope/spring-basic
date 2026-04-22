package hello.demo.singleton;

import hello.demo.AppConfig;
import hello.demo.member.MemberRepository;
import hello.demo.member.MemberServiceImpl;
import hello.demo.order.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberRepository1 = " + memberRepository1);
        System.out.println("memberRepository2 = " + memberRepository2);
        System.out.println("memberRepository origin = " + memberRepository);

        Assertions.assertEquals(memberService.getMemberRepository(), memberRepository);
        Assertions.assertEquals(orderService.getMemberRepository(), memberRepository);
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
        //--==>> class hello.demo.AppConfig$$SpringCGLIB$$0
        // 실제 AppConfig 가 아닌, AppConfig 를 모방한 임의의 클래스를 생성함
        // 즉 @Configuration 클래스에 대해 싱글톤을 보장하기 위해서
        // @Bean 이 붙은 메서드 마다 스프링 빈이 존재하면 존재하는 빈을 반환하고
        // 없으면 생성해서 싱글톤을 유지한다.

        // AppConfigCGLIB 는 AppConfig 의 자식타입이 되므로 타입으로 조회 가능하며
        // 모든 메서드 등을 오버라이드한다.(예상)
    }

}
