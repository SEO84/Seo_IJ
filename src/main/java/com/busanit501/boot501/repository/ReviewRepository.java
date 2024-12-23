package com.busanit501.boot501.repository;

import com.busanit501.boot501.domain.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Reviews, Integer> {
    // 예) 특정 사용자가 받은 리뷰
    // List<Reviews> findByReviewedUserUserId(Integer reviewedId);
}
