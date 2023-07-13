package com.basic.spring_basic;

import com.basic.spring_basic.member.MemberRepository;
import com.basic.spring_basic.member.MemberService;
import com.basic.spring_basic.member.MemberServiceImpl;
import com.basic.spring_basic.member.MemoryMemberRepository;
import com.basic.spring_basic.discount.DiscountPolicy;
import com.basic.spring_basic.discount.RateDiscountPolicy;
import com.basic.spring_basic.order.OrderService;
import com.basic.spring_basic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
