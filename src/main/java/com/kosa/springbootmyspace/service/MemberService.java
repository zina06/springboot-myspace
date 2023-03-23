package com.kosa.springbootmyspace.service;

import java.util.List;

import com.kosa.springbootmyspace.domain.Member;

public interface MemberService {

    Member save(Member member);

    Member update(Member member);

    Member delete(int idx);

    Member findById(int idx);

    List<Member> findAll();
}
