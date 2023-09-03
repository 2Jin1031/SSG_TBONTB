package com.controller;

import com.dto.post.PostDto;
import com.dto.post.PostDto;
import com.dto.post.PostUpdateAllDto;
import com.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @GetMapping("/list")
    public ResponseEntity<List<PostDto>> getPostList() {
        List<PostDto> posts = postService.findAll();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Void> updatePostAll(@RequestBody PostDto postInfo) {
        postService.addPost(postInfo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PostMapping("/update-all")
//    public ResponseEntity<Void> updatePostAll(@RequestBody PostUpdateAllDto postInfo) {
//        postService.updatePostAll(postInfo);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

}
