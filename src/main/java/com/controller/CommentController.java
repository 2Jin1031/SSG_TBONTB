package com.controller;

import com.dto.comment.CommentDto;
import com.dto.comment.CommentUpdateAllDto;
import com.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/list")
    public ResponseEntity<List<CommentDto>> getCommentList() {
        List<CommentDto> comments = commentService.findAll();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> updateCommentAll(@RequestBody CommentDto commentInfo) {
        commentService.addComment(commentInfo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*@PostMapping("/update-all")
    public ResponseEntity<Void> updateCommentAll(@RequestBody CommentUpdateAllDto commentInfo) {
        commentService.updateCommentAll(commentInfo);
        return new ResponseEntity<>(HttpStatus.OK);
    }*/

}
