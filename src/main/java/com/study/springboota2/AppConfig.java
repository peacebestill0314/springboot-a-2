package com.study.springboota2;

import com.study.springboota2.discount.RateDiscountPolicy;
import com.study.springboota2.member.MemberService;
import com.study.springboota2.member.MemberServiceImpl;
import com.study.springboota2.member.MemoryMemberRepository;
import com.study.springboota2.order.OrderService;
import com.study.springboota2.order.OrderServiceImpl;

// 구현 객체를 생성하고 연결하는 책임을 갖는 별도의 설정 클래스
public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());
    }

}
