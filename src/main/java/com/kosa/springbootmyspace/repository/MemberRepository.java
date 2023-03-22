package com.kosa.springbootmyspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kosa.springbootmyspace.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
