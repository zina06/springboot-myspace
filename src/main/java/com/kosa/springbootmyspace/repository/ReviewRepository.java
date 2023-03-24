package com.kosa.springbootmyspace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kosa.springbootmyspace.domain.Member;
import com.kosa.springbootmyspace.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    List<Review> findByMember(Member member);

}
