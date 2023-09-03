package com.service;

import com.domain.Review;
import com.domain.Review;
import com.domain.Review;
import com.dto.review.ReviewDto;
import com.dto.review.ReviewDto;
import com.dto.review.ReviewUpdateAllDto;
import com.dto.review.ReviewDto;
import com.dto.review.ReviewUpdateAllDto;
import com.exception.NotFoundException;
import com.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.service.TotalUpdateService.convertReviewToReviewDto;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public List<ReviewDto> findAll() {
        List<Review> all = reviewRepository.findAll();
        List<ReviewDto> reviewDtoList = convertReviewToReviewDto(all);
        return reviewDtoList;
    }

    @Transactional
    public Long addReview(ReviewDto infoDto){
        Review review = Review.builder()
                .reviewContent(infoDto.getReviewContent())
                .grade(infoDto.getGrade())
                .creatDate(infoDto.getCreatDate())
                .build();

        reviewRepository.save(review);
        return review.getId();
    }


}
