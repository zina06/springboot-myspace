package com.kosa.springbootmyspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kosa.springbootmyspace.domain.Score;

public interface ScoreRepository extends JpaRepository<Score, Integer> {

}
