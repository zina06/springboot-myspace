package com.kosa.springbootmyspace.service;

import com.kosa.springbootmyspace.domain.Score;

import java.util.List;

public interface ScoreService {
    Score save(Score score);
    int update(Score score);
    int delete(int idx);
    Score findById(int idx);
    List<Score> findAll();

}
