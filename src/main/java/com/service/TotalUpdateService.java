package com.service;

import com.dto.security.TokenInfoDto;

import com.domain.Post;
import com.dto.post.PostDto;
import com.repository.PostRepository;

import com.domain.Problem;
import com.dto.problem.ProblemDto;
import com.repository.ProblemRepository;

import com.domain.Review;
import com.dto.review.ReviewDto;
import com.repository.ReviewRepository;

import com.domain.Comment;
import com.dto.comment.CommentDto;
import com.repository.CommentRepository;

import com.domain.Work;
import com.dto.work.WorkDto;
import com.repository.WorkRepository;

import com.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)

public class TotalUpdateService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final ProblemRepository problemRepository;
    private final ReviewRepository reviewRepository;
    private final WorkRepository workRepository;
    private final JwtTokenProvider jwtTokenProvider;


    static List<CommentDto> convertCommentToCommentDto(List<Comment> commentList) {
        List<CommentDto> commentDtoList = commentList.stream()
                .map(a -> new CommentDto(a))
                .collect(Collectors.toList());
        return commentDtoList;
    }

    static List<PostDto> convertPostToPostDto(List<Post> postList) {
        List<PostDto> postDtoList = postList.stream()
                .map(a -> new PostDto(a))
                .collect(Collectors.toList());
        return postDtoList;
    }
    static List<ProblemDto> convertProblemToProblemDto(List<Problem> problemList) {
        List<ProblemDto> problemDtoList = problemList.stream()
                .map(a -> new ProblemDto(a))
                .collect(Collectors.toList());
        return problemDtoList;
    }
    static List<ReviewDto> convertReviewToReviewDto(List<Review> reviewList) {
        List<ReviewDto> reviewDtoList = reviewList.stream()
                .map(a -> new ReviewDto(a))
                .collect(Collectors.toList());
        return reviewDtoList;
    }
    public static List<WorkDto> convertWorkToWorkDto(List<Work> workList) {
        List<WorkDto> workDtoList = workList.stream()
                .map(a -> new WorkDto(a))
                .collect(Collectors.toList());
        return workDtoList;
    }

}
