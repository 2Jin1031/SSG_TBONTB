package com.dto.review;

import com.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @ToString
public class ReviewUpdateAllDto {
    private String reviewContent; // 리뷰 내용

    private String grade; // 평점

    private LocalDateTime creatDate; // 작성일

    public ReviewUpdateAllDto(Review review) {
        this.reviewContent = review.getReviewContent();
        this.grade = review.getGrade();
        this.creatDate = review.getCreatDate();
    }

}
