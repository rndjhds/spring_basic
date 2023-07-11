package com.basic.spring_basic;

import com.basic.spring_basic.member.MemberRepository;
import com.basic.spring_basic.member.MemberService;
import com.basic.spring_basic.member.MemberServiceImpl;
import com.basic.spring_basic.member.MemoryMemberRepository;
import com.basic.spring_basic.member.discount.DiscountPolicy;
import com.basic.spring_basic.member.discount.RateDiscountPolicy;
import com.basic.spring_basic.member.order.OrderService;
import com.basic.spring_basic.member.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
