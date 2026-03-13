package hello.demo.order;

import hello.demo.discount.DiscountPolicy;
import hello.demo.discount.FixDiscountPolicy;
import hello.demo.discount.RateDiscountPolicy;
import hello.demo.member.Member;
import hello.demo.member.MemberRepository;
import hello.demo.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    // DIP 를 지키기 위해 구현체를 생성하지 않음
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private DiscountPolicy discountPolicy;
    
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
