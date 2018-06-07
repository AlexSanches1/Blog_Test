package com.sanches.app.blogtest.repositories;

import com.sanches.app.blogtest.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
