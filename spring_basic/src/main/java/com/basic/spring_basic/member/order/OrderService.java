package com.basic.spring_basic.member.order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);
}
