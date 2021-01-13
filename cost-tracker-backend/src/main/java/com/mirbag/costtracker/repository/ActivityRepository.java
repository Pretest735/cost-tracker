package com.mirbag.costtracker.repository;

import com.mirbag.costtracker.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
