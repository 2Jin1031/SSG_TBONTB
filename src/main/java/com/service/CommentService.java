package com.service;

import com.domain.Comment;
import com.dto.comment.CommentDto;
import com.dto.comment.CommentUpdateAllDto;
import com.exception.NotFoundException;
import com.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.service.TotalUpdateService.convertCommentToCommentDto;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class CommentService {

    private final CommentRepository commentRepository;


    public List<CommentDto> findAll() {
        List<Comment> all = commentRepository.findAll();
        List<CommentDto> commentDtoList = convertCommentToCommentDto(all);
        return commentDtoList;
    }

    @Transactional
    public Long addComment(CommentDto infoDto){
        Comment comment = Comment.builder()
                .commentContent(infoDto.getCommentContent())
                .commentDate(infoDto.getCommentDate())
                .build();

        commentRepository.save(comment);
        return comment.getId();
    }

}
