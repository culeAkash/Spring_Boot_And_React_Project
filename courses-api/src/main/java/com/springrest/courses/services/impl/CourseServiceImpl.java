package com.springrest.courses.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.courses.entities.Course;
import com.springrest.courses.exceptions.ResourceNotFoundException;
import com.springrest.courses.repository.CourseRepository;
import com.springrest.courses.services.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public List<Course> getCourses() {
		List<Course> allCourses = this.courseRepository.findAll();
		return allCourses;
	}

	@Override
	public Course getCourseById(long courseId) {
		Course course = this.courseRepository.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("Course", "Course Id", courseId));
		return course;
	}

	@Override
	public Course createCourse(Course course) {
		Course saved = this.courseRepository.save(course);
		return saved;
	}

	@Override
	public Course updateCourse(Course course, long courseId) {
		Course course1 = this.courseRepository.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("Course", "Course Id", courseId));
		if (course.getCourseTitle() != null) {
			course1.setCourseTitle(course.getCourseTitle());
		}
		if (course.getCourseDescription() != null) {
			course1.setCourseDescription(course.getCourseDescription());
		}

		Course saved = this.courseRepository.save(course1);
		return saved;
	}

	@Override
	public void deleteCourse(long courseId) {
		Course coursefind = this.courseRepository.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("Course", "Course Id", courseId));
		this.courseRepository.delete(coursefind);
	}

}
