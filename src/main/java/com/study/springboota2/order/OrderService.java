package com.study.springboota2.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
