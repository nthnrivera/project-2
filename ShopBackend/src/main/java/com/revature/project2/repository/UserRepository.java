package com.revature.project2.repository;

import com.revature.project2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends  JpaRepository<User, Integer>{

    User findByUsername(String username);
}
