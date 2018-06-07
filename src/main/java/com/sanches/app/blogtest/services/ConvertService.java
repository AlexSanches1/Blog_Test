package com.sanches.app.blogtest.services;

import com.sanches.app.blogtest.models.Category;
import com.sanches.app.blogtest.models.Comment;
import com.sanches.app.blogtest.models.Post;
import com.sanches.app.blogtest.models.dto.*;
import com.sanches.app.blogtest.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ConvertService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDTO convertToDTO(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setCategory(category.getName());
        dto.setId(category.getId());
        return dto;
    }

    public Post convertToPost(RequestPostInfoDTO postInfoDTO) {
        Post post = new Post();
        post.setText(postInfoDTO.getText());
        post.setTitle(postInfoDTO.getTitle());
        post.setUrlImage(postInfoDTO.getUrlImage());
        Category category = categoryRepository.getOne(postInfoDTO.getCategoryId());
        post.setCategory(category);
        post.setDate(new Date());
        return post;
    }

    public PostDTO convertToPostDTO(Post post) {
        PostDTO dto = new PostDTO();
        dto.setId(post.getId());
        dto.setText(post.getText());
        dto.setTitle(post.getTitle());
        dto.setUrlImage(post.getUrlImage());
        dto.setDate(post.getDate());
        dto.setCategory(post.getCategory().getName());
        return dto;
    }

    public PostFullInfoDTO convertToFullInfoPost(Post post) {
        PostFullInfoDTO dto = new PostFullInfoDTO();
        dto.setId(post.getId());
        dto.setText(post.getText());
        dto.setTitle(post.getTitle());
        dto.setUrlImage(post.getUrlImage());
        dto.setDate(post.getDate());
        dto.setCategory(post.getCategory().getName());
        dto.setComments(post.getComment());
        return dto;
    }

    public CommentDTO convertToCommentDTO(Comment comment) {
        CommentDTO dto = new CommentDTO();
        dto.setId(comment.getId());
        dto.setText(comment.getText());
        return dto;
    }
}
