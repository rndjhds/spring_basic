package com.basic.spring_basic;

import com.basic.spring_basic.member.MemberService;
import com.basic.spring_basic.member.MemberServiceImpl;
import com.basic.spring_basic.member.MemoryMemberRepository;
import com.basic.spring_basic.member.discount.FixDiscountPolicy;
import com.basic.spring_basic.member.order.OrderService;
import com.basic.spring_basic.member.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
