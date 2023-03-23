package com.kosa.springbootmyspace.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.springbootmyspace.domain.Member;
import com.kosa.springbootmyspace.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public int delete(int idx) {
        Optional<Member> findMember = memberRepository.findById(idx);
        int result = 0;
        if (findMember.isPresent()) {
            memberRepository.delete(findMember.get());
            result = 1;
        }
        return result;
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
    public int update(Member member) {
        Optional<Member> findMember = memberRepository.findById(member.getIdx());
        int result = 0;
        if (findMember.isPresent()) {
            Member dbMember = findMember.get();
            dbMember.setLogin_id(member.getLogin_id());
            dbMember.setPassword(member.getPassword());
            dbMember.setName(member.getName());
            dbMember.setEmail(member.getEmail());
            dbMember.setPhone(member.getPhone());
            dbMember.setBirth(member.getBirth());
            memberRepository.save(dbMember);
            result = 1;
        }
        return result;
    }

}