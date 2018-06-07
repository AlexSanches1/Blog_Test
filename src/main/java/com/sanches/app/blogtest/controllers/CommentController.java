package com.sanches.app.blogtest.controllers;

import com.sanches.app.blogtest.models.dto.RequestCommentDTO;
import com.sanches.app.blogtest.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/create")
    public ResponseEntity saveComment(RequestCommentDTO commentDTO) {
        return ResponseEntity.ok(commentService.getComment(commentDTO));
    }
}
