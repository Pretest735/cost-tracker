package com.mirbag.costtracker.repository;

import com.mirbag.costtracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByIsActiveTrue();
    Optional<User> findByUserName(String name);
    Optional<User> findByUserNameAndIdNot(String name, Long id);
}
