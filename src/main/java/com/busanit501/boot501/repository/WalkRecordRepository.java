package com.busanit501.boot501.repository;

import com.busanit501.boot501.domain.WalkRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalkRecordRepository extends JpaRepository<WalkRecords, Integer> {
    // 예) 특정 사용자 최근 산책기록 가져오기
    // List<WalkRecords> findByUserUserIdOrderByStartTimeDesc(Integer userId);
}
