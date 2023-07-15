package com.basic.spring_basic.discount;

import com.basic.spring_basic.annotation.MainDiscountPolicy;
import com.basic.spring_basic.member.Grade;
import com.basic.spring_basic.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

    private final int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {

        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
