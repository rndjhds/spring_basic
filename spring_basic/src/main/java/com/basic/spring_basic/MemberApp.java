package com.basic.spring_basic;

import com.basic.spring_basic.member.Grade;
import com.basic.spring_basic.member.Member;
import com.basic.spring_basic.member.MemberService;
import com.basic.spring_basic.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = " + findMember.getName());
        System.out.println("member = " + member.getName());


    }
}
