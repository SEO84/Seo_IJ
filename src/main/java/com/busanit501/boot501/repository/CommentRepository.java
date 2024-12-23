package com.busanit501.boot501.repository;

import com.busanit501.boot501.domain.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comments, Integer> {

    List<Comments> findByPost_PostIdOrderByCreatedAtDesc(Integer postId);

    // 기타 메서드...
}
