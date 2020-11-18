package com.study.springboota2.order;

import com.study.springboota2.discount.DiscountPolicy;
import com.study.springboota2.discount.FixDiscountPolicy;
import com.study.springboota2.discount.RateDiscountPolicy;
import com.study.springboota2.member.Member;
import com.study.springboota2.member.MemberRepository;
import com.study.springboota2.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        // 단일책임원칙. 주문 클래스는 할인 로직과 완전히 분리되어 있다
        int discountPrice = discountPolicy.dicount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
