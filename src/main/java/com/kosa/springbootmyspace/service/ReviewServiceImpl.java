package com.kosa.springbootmyspace.service;

import java.util.List;
import java.util.Optional;

import com.kosa.springbootmyspace.domain.Product;
import com.kosa.springbootmyspace.repository.OrderRepository;
import com.kosa.springbootmyspace.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.springbootmyspace.domain.Member;
import com.kosa.springbootmyspace.domain.Review;
import com.kosa.springbootmyspace.repository.MemberRepository;
import com.kosa.springbootmyspace.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public int delete(int idx) {
        Optional<Review> findReview = reviewRepository.findById(idx);
        int result = 0;
        if (findReview.isPresent()) {
            reviewRepository.delete(findReview.get());
            result = 1;
        }
        return result;
    }

    @Override
    public List<Review> findAllByMemberIdx(int idx) {
        Optional<Member> findMember = memberRepository.findById(idx);
        if (findMember.isPresent()) {
            return reviewRepository.findByMember(findMember.get());
        }
        return null;
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findById(int idx) {
        Optional<Review> findReview = reviewRepository.findById(idx);
        if (findReview.isPresent()) {
            return findReview.get();
        }
        return null;
    }

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public int update(Review review) {
        Optional<Review> findReview = reviewRepository.findById(review.getIdx());
        int result = 0;
        if (findReview.isPresent()) {
            Review dbReview = findReview.get();
            dbReview.setContent(review.getContent());
            dbReview.setImage(review.getImage());
            reviewRepository.save(dbReview);
            result = 1;
        }
        return result;
    }

    @Override
    public List<Review> findAllByProductIdx(int idx) {
        Optional<Product> product = productRepository.findById(idx);

        return reviewRepository.findByProduct(product.get());
    }
}
