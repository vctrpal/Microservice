package com.example.user.repository;

import com.example.user.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDetail,Long> {
    UserDetail findByUserId(Long userId);
}
