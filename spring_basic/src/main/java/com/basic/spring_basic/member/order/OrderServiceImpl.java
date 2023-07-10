package com.basic.spring_basic.member.order;

import com.basic.spring_basic.member.Member;
import com.basic.spring_basic.member.MemberRepository;
import com.basic.spring_basic.member.MemoryMemberRepository;
import com.basic.spring_basic.member.discount.DiscountPolicy;
import com.basic.spring_basic.member.discount.FixDiscountPolicy;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
