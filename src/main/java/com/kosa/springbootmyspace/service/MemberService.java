package com.kosa.springbootmyspace.service;

import java.util.List;

import com.kosa.springbootmyspace.domain.Member;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService {

    Member save(Member member);

    int update(Member member);

    int delete(int idx);

    Member findById(int idx);

    List<Member> findAll();

    Member findByLoginId(String loginId);

}
