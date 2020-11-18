package com.study.springboota2;

import com.study.springboota2.member.Grade;
import com.study.springboota2.member.Member;
import com.study.springboota2.member.MemberService;
import com.study.springboota2.member.MemberServiceImpl;
import com.study.springboota2.order.Order;
import com.study.springboota2.order.OrderService;
import com.study.springboota2.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println(order);
        System.out.println(order.calculatePrice());
    }
}
