package com.kosa.springbootmyspace.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.springbootmyspace.domain.Review;
import com.kosa.springbootmyspace.service.ReviewService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/save")
    public ResponseEntity<Review> save(@RequestBody Review review) {
        try {
            Review saveReview = reviewService.save(review);
            if (saveReview != null) {
                return new ResponseEntity<>(saveReview, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return new ResponseEntity<Review>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<Review> update(@RequestBody Review review) {
        try {
            int result = reviewService.update(review);
            if (result == 1) {
                Review updateReview = reviewService.findById(review.getIdx());
                return new ResponseEntity<Review>(updateReview, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return new ResponseEntity<Review>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{idx}")
    public ResponseEntity<Integer> delete(@PathVariable int idx) {
        try {
            int result = reviewService.delete(idx);
            if (result == 1) {
                return new ResponseEntity<Integer>(result, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{idx}")
    public ResponseEntity<Review> findById(@PathVariable int idx) {
        try {
            Review findReview = reviewService.findById(idx);
            if (findReview != null) {
                return new ResponseEntity<Review>(findReview, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return new ResponseEntity<Review>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Review>> findAll() {
        try {
            List<Review> reviewList = reviewService.findAll();
            if (reviewList != null) {
                return new ResponseEntity<List<Review>>(reviewList, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return new ResponseEntity<List<Review>>(HttpStatus.NO_CONTENT);
    }

    /**
     * member의 idx로 리뷰목록을 조회하는 엔드포인트 입니다.
     * 
     * @param idx
     * @return
     */
    @GetMapping("/member/{idx}")
    public ResponseEntity<List<Review>> findAllByMemberIdx(@PathVariable int idx) {
        try {
            List<Review> reviewList = reviewService.findAllByMemberIdx(idx);
            if (reviewList != null) {
                return new ResponseEntity<List<Review>>(reviewList, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return new ResponseEntity<List<Review>>(HttpStatus.NO_CONTENT);
    }

    /**
     * product의 idx로 리뷰목록을 조회하는 엔드포인트 입니다.
     *
     * @param idx
     * @return
     */
    public ResponseEntity<List<Review>> findAllByProductIdx(@PathVariable int idx) {
        try {
            List<Review> reviewList = reviewService.findAllByProductIdx(idx);
            if (reviewList != null) {
                return new ResponseEntity<List<Review>>(reviewList, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return new ResponseEntity<List<Review>>(HttpStatus.NO_CONTENT);
    }
}
