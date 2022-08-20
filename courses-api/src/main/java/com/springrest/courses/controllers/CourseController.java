package com.springrest.courses.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.courses.entities.Course;
import com.springrest.courses.exceptions.ApiResponse;
import com.springrest.courses.services.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getCourses() {
		return new ResponseEntity<List<Course>>(this.courseService.getCourses(), HttpStatus.OK);
	}

	@GetMapping("/courses/{courseId}")
	public ResponseEntity<Course> getCourseById(@PathVariable long courseId) {
		Course course = this.courseService.getCourseById(courseId);
		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}

	@PostMapping("/courses")
	public ResponseEntity<Course> createCourse(@Valid @RequestBody Course course) {
		Course createdCourse = this.courseService.createCourse(course);
		return new ResponseEntity<Course>(createdCourse, HttpStatus.CREATED);
	}

	@PutMapping("/courses/{courseId}")
	public ResponseEntity<Course> updateCourse(@Valid @RequestBody Course course, @PathVariable long courseId) {
		Course updatedCourse = this.courseService.updateCourse(course, courseId);
		return new ResponseEntity<Course>(updatedCourse, HttpStatus.OK);
	}

	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<ApiResponse> deleteCourse(@PathVariable long courseId) {
		this.courseService.deleteCourse(courseId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Course Deleted Successfully", true), HttpStatus.OK);
	}
}
