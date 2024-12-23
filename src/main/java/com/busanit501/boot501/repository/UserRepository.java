package com.busanit501.boot501.repository;

import com.busanit501.boot501.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    // 예: 이메일로 사용자 찾기
    // Optional<Users> findByEmail(String email);
}
