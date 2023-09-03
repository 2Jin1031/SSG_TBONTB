package com.dto.post;

import com.domain.Post;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostDto {
    private Long id;

    private String postTitle; // 게시물 제목

    private String postContent; // 게시물 내용

    private LocalDateTime postDate; // 게시일

    public PostDto(Post post) {
        this.id = post.getId();
        this.postTitle = post.getPostTitle();
        this.postContent = post.getPostContent();
        this.postDate = post.getPostDate();
    }

    public PostDto() {
    }
}
