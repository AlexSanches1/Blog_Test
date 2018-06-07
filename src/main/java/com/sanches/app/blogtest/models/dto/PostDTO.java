package com.sanches.app.blogtest.models.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PostDTO {

    private Long id;

    private String title;

    private String text;

    private String urlImage;

    private Date date;

    private String category;
}
