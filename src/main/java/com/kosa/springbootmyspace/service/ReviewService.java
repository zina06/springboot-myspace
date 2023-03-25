package com.kosa.springbootmyspace.service;

import java.util.List;

import com.kosa.springbootmyspace.domain.Review;

public interface ReviewService {

    Review save(Review review);

    int update(Review review);

    int delete(int idx);

    Review findById(int idx);

    List<Review> findAllByMemberIdx(int idx);

    List<Review> findAll();

    List<Review> findAllByProductIdx(int idx);

}
