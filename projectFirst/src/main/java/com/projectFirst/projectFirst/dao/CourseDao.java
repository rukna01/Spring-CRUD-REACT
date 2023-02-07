package com.projectFirst.projectFirst.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectFirst.projectFirst.entities.Course;

public interface CourseDao extends JpaRepository<Course,Long> {

}
