package com.study.springboota2.discount;

import com.study.springboota2.member.Grade;
import com.study.springboota2.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int dicount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }else {
            return 0;
        }
    }
}
