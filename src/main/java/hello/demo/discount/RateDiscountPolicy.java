package hello.demo.discount;

import hello.demo.member.Grade;
import hello.demo.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;

//@Qualifier("mainDiscountPolicy")
@Primary
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPernect = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){
            return price * discountPernect / 100;
        } else {
            return 0;
        }
    }
}
