package com.dto.comment;

import com.domain.Comment;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentUpdateAllDto {
    private Long id;

    private String commentContent; // 댓글 내용

    private LocalDateTime commentDate; // 작성일

    public CommentUpdateAllDto(Comment comment) {
        this.id = comment.getId();
        this.commentContent = comment.getCommentContent();
        this.commentDate = comment.getCommentDate();
    }
}
