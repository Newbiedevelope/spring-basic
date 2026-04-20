package hello.demo;

import hello.demo.discount.DiscountPolicy;
import hello.demo.discount.FixDiscountPolicy;
import hello.demo.discount.RateDiscountPolicy;
import hello.demo.member.MemberService;
import hello.demo.member.MemberServiceImpl;
import hello.demo.member.MemoryMemberRepository;
import hello.demo.order.OrderService;
import hello.demo.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // 두 개의 서로 다른 빈이 호출될 때 같은 빈을 요청 및 생성에 활용한다.
    // 이런 경우 둘 다 new 생성자로 반환되는데 싱글톤이 준수되고 있는 것인가?
    // @Bean memberService → new MemoryMemberRepository()
    // @Bean orderService → new MemoryMemberRepository()

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        // 할인 정책 변경 시 이제 AppConfig 의 discountPolicy 메서드
        // 구현부만 수정해주면 된다.
        return new RateDiscountPolicy();
    }

}
