package com.study.springboota2.order;

import com.study.springboota2.discount.DiscountPolicy;
import com.study.springboota2.discount.FixDiscountPolicy;
import com.study.springboota2.discount.RateDiscountPolicy;
import com.study.springboota2.member.Member;
import com.study.springboota2.member.MemberRepository;
import com.study.springboota2.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    // 대신 누가 구체 클래스를 넣어줘야 한다.
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        // 단일책임원칙. 주문 클래스는 할인 로직과 완전히 분리되어 있다
        int discountPrice = discountPolicy.dicount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
