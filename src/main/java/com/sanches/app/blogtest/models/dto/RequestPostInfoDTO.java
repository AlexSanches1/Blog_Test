package com.sanches.app.blogtest.models.dto;

import lombok.Data;

@Data
public class RequestPostInfoDTO {

    private String title;

    private String text;

    private String urlImage;

    private Long categoryId;
}