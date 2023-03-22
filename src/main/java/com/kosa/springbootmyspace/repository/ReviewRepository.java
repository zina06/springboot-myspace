package com.kosa.springbootmyspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kosa.springbootmyspace.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
