package com.basic.spring_basic.member;

import com.basic.spring_basic.member.order.Order;
import com.basic.spring_basic.member.order.OrderService;
import com.basic.spring_basic.member.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 1000);

        System.out.println("order = " + order);

    }
}
