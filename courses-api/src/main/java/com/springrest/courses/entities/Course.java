package com.springrest.courses.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long courseId;

	@NotBlank(message = "Course Title must not be blank")
	@Size(min = 5, max = 30, message = "Course Title must be of size between 5 and 20")
	private String courseTitle;

	@NotBlank(message = "Course Description must not be blank")
	@Size(min = 10, max = 100, message = "Course Description must be of size between 10 and 100")
	private String courseDescription;

	public long getCourseId() {
		return this.courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseTitle() {
		return this.courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseDescription() {
		return this.courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public Course(long courseId, String courseTitle, String courseDescription) {
		super();
		this.courseId = courseId;
		this.courseTitle = courseTitle;
		this.courseDescription = courseDescription;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Course [courseId=" + this.courseId + ", courseTitle=" + this.courseTitle + ", courseDescription="
				+ this.courseDescription + "]";
	}

}
