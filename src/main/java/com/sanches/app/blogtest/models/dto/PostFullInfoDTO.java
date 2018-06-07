package com.sanches.app.blogtest.models.dto;

import com.sanches.app.blogtest.models.Comment;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PostFullInfoDTO {

    private Long id;

    private String title;

    private String text;

    private String urlImage;

    private Date date;

    private String category;

    private List<Comment> comments;
}
