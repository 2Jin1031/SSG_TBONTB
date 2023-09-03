package com.dto.post;

import com.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @ToString
public class PostUpdateAllDto {
    private String postTitle; // 게시물 제목

    private String postContent; // 게시물 내용

    private LocalDateTime postDate; // 게시일

    public PostUpdateAllDto(Post post) {
        this.postTitle = post.getPostTitle();
        this.postContent = post.getPostContent();
        this.postDate = post.getPostDate();
    }

}
