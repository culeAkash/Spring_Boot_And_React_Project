package com.springrest.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.courses.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
