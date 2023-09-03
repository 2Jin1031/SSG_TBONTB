package com.dto.review;

import com.domain.Review;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewDto {
    private Long id;

    private String reviewContent; // 리뷰 내용

    private String grade; // 평점

    private LocalDateTime creatDate; // 작성일

    public ReviewDto(Review review) {
        this.id = review.getId();
        this.reviewContent = review.getReviewContent();
        this.grade = review.getGrade();
        this.creatDate = review.getCreatDate();
    }

    public ReviewDto() {
    }
}
