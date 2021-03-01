package com.mirbag.costtracker.repository;

import com.mirbag.costtracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByIsActiveTrue();
}
