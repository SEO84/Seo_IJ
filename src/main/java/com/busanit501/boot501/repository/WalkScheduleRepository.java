package com.busanit501.boot501.repository;

import com.busanit501.boot501.domain.WalkSchedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalkScheduleRepository extends JpaRepository<WalkSchedules, Integer> {
    // 예) 사용자별 예정된 산책만 찾기
    // List<WalkSchedules> findByUserUserIdAndStatus(Integer userId, WalkSchedules.WalkStatus status);
}
