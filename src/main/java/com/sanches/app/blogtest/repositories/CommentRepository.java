package com.sanches.app.blogtest.repositories;

import com.sanches.app.blogtest.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
