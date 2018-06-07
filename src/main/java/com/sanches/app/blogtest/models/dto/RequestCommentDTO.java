package com.sanches.app.blogtest.models.dto;

import lombok.Data;

@Data
public class RequestCommentDTO {

    private String text;

    private Long postId;
}
