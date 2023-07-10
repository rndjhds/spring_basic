package com.basic.spring_basic.order;

import com.basic.spring_basic.member.Grade;
import com.basic.spring_basic.member.Member;
import com.basic.spring_basic.member.MemberService;
import com.basic.spring_basic.member.MemberServiceImpl;
import com.basic.spring_basic.member.order.Order;
import com.basic.spring_basic.member.order.OrderService;
import com.basic.spring_basic.member.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService oreOrderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = oreOrderService.createOrder(memberId, "itemA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
