package com.sanches.app.blogtest.services;

import com.sanches.app.blogtest.models.Post;
import com.sanches.app.blogtest.models.dto.PostDTO;
import com.sanches.app.blogtest.models.dto.PostFullInfoDTO;
import com.sanches.app.blogtest.models.dto.RequestPostInfoDTO;
import com.sanches.app.blogtest.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ConvertService convertService;


    public PostDTO getPostDTO(RequestPostInfoDTO postInfoDTO) {
        Post post = convertService.convertToPost(postInfoDTO);
        Post saveData = postRepository.save(post);
        return convertService.convertToPostDTO(saveData);
    }

    public PostFullInfoDTO postInfo(Long id) {
        Post post = postRepository.getOne(id);
        return convertService.convertToFullInfoPost(post);
    }

    public List<PostDTO> listPost() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(post -> convertService.convertToPostDTO(post))
                .collect(Collectors.toList());
    }
}
