package com.mirbag.costtracker.repository;

import com.mirbag.costtracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
