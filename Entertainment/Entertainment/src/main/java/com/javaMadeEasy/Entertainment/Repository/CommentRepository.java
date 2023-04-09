package com.javaMadeEasy.Entertainment.Repository;

import com.javaMadeEasy.Entertainment.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    Comment findAllCommentByPostId(long postId);
}
