package com.study.springboota2.member;

public class MemberServiceImpl implements MemberService {

    // 클라이언트가 직접 구현체를 의존하고 있음
    // private final MemberRepository memberRepository = new MemoryMemberRepository();

    private MemberRepository memberRepository;

    // 어떤 멤버레파지토리가 들어갈지는 생성자를 통해서
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
