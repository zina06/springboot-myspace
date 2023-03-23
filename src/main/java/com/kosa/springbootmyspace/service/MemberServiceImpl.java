package com.kosa.springbootmyspace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.springbootmyspace.domain.Member;
import com.kosa.springbootmyspace.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member delete(int idx) {
        Member findMember = memberRepository.findById(idx).get();
        memberRepository.delete(findMember);
        return findMember;
    }

    @Override
    public Member findById(int idx) {
        return memberRepository.findById(idx).get();
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member update(Member member) {
        return memberRepository.save(member);
    }

}
