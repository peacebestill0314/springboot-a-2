package com.study.springboota2.discount;

import com.study.springboota2.member.Member;

public interface DiscountPolicy {

    int dicount(Member member, int price);

}
