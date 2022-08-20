package com.springrest.courses.services;

import java.util.List;

import com.springrest.courses.entities.Course;

public interface CourseService {

	// method to get all courses
	public List<Course> getCourses();

	public Course getCourseById(long courseId);

	public Course createCourse(Course course);

	public Course updateCourse(Course course, long courseId);

	public void deleteCourse(long courseId);

}
