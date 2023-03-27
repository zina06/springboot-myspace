package com.kosa.springbootmyspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kosa.springbootmyspace.domain.Score;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Integer> {
    List<Score> findByReviewIdx(int review_idx);
}
