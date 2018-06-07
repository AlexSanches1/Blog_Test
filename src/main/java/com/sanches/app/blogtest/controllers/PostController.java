package com.sanches.app.blogtest.controllers;

import com.sanches.app.blogtest.models.dto.RequestPostInfoDTO;
import com.sanches.app.blogtest.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public ResponseEntity createPost(RequestPostInfoDTO postInfoDTO) {
        return ResponseEntity.ok(postService.getPostDTO(postInfoDTO));
    }

    @GetMapping("/info")
    public ResponseEntity detailedInfoPost(Long id) {
        return ResponseEntity.ok(postService.postInfo(id));
    }

    @GetMapping("/list")
    public ResponseEntity listPost() {
        return ResponseEntity.ok(postService.listPost());
    }
}
