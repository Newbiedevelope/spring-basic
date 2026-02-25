package hello.demo;

import hello.demo.member.Member;
import hello.demo.member.Grade;
import hello.demo.member.MemberService;
import hello.demo.member.MemberServiceImpl;

public class MemberApp {
    // 구현한 메서드가 정상적으로 작동하는지 테스트
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
        // 출력 결과
        /*
        new member = memberA
        findMember = memberA
        */
    }
}
