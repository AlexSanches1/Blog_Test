package com.sanches.app.blogtest.services;

import com.sanches.app.blogtest.exceptions.NotFoundException;
import com.sanches.app.blogtest.models.Comment;
import com.sanches.app.blogtest.models.Post;
import com.sanches.app.blogtest.models.dto.CommentDTO;
import com.sanches.app.blogtest.models.dto.RequestCommentDTO;
import com.sanches.app.blogtest.repositories.CommentRepository;
import com.sanches.app.blogtest.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ConvertService convertService;
    @Autowired
    private PostRepository postRepository;


    @Transactional
    public CommentDTO getComment(RequestCommentDTO requestDTO) {
        Post post = postRepository.getOne(requestDTO.getPostId());
        List<Comment> list = post.getComment();
        Comment comment = new Comment();
        if (requestDTO.getText() != null) {
            comment.setText(requestDTO.getText());
        }else {
            throw new NotFoundException();
        }
        Comment saveData = commentRepository.save(comment);
        list.add(saveData);
        return convertService.convertToCommentDTO(saveData);
    }
}
