package com.service;

import com.domain.Post;
import com.domain.Post;
import com.domain.Post;
import com.dto.post.PostDto;
import com.dto.post.PostDto;
import com.dto.post.PostUpdateAllDto;
import com.dto.post.PostDto;
import com.dto.post.PostUpdateAllDto;
import com.exception.NotFoundException;
import com.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.service.TotalUpdateService.convertPostToPostDto;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class PostService {

    private final PostRepository postRepository;

    public List<PostDto> findAll() {
        List<Post> all = postRepository.findAll();
        List<PostDto> postDtoList = convertPostToPostDto(all);
        return postDtoList;
    }

    @Transactional
    public Long addPost(PostDto infoDto){
        Post post = Post.builder()
                .postContent(infoDto.getPostContent())
                .postDate(infoDto.getPostDate())
                .build();

        postRepository.save(post);
        return post.getId();
    }


}
