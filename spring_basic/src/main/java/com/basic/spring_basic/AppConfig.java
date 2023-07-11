package com.basic.spring_basic;

import com.basic.spring_basic.member.MemberRepository;
import com.basic.spring_basic.member.MemberService;
import com.basic.spring_basic.member.MemberServiceImpl;
import com.basic.spring_basic.member.MemoryMemberRepository;
import com.basic.spring_basic.member.discount.DiscountPolicy;
import com.basic.spring_basic.member.discount.RateDiscountPolicy;
import com.basic.spring_basic.member.order.OrderService;
import com.basic.spring_basic.member.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
