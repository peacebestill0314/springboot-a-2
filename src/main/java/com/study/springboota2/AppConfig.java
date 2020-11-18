package com.study.springboota2;

import com.study.springboota2.discount.DiscountPolicy;
import com.study.springboota2.discount.RateDiscountPolicy;
import com.study.springboota2.member.MemberRepository;
import com.study.springboota2.member.MemberService;
import com.study.springboota2.member.MemberServiceImpl;
import com.study.springboota2.member.MemoryMemberRepository;
import com.study.springboota2.order.OrderService;
import com.study.springboota2.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 구현 객체를 생성하고 연결하는 책임을 갖는 별도의 설정 클래스

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(MemberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(MemberRepository(), DiscountPolicy());
    }

    @Bean
    public MemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy DiscountPolicy() {
        return new RateDiscountPolicy();
    }
}
