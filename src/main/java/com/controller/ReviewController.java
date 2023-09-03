package com.controller;

import com.dto.review.ReviewDto;
import com.dto.review.ReviewUpdateAllDto;
import com.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/list")
    public ResponseEntity<List<ReviewDto>> getReviewList() {
        List<ReviewDto> reviews = reviewService.findAll();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> updateReviewAll(@RequestBody ReviewDto reviewInfo) {
        reviewService.addReview(reviewInfo);
        return new ResponseEntity<>(HttpStatus.OK);
    }
//    @PostMapping("/update-all")
//    public ResponseEntity<Void> updateReviewAll(@RequestBody ReviewUpdateAllDto reviewInfo) {
//        reviewService.updateReviewAll(reviewInfo);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

}
