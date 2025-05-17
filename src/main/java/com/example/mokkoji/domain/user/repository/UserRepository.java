package com.example.mokkoji.domain.user.repository;

import com.example.mokkoji.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
