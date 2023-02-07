package com.projectFirst.projectFirst.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projectFirst.projectFirst.entities.Course;
import com.projectFirst.projectFirst.services.CourseService;

@RestController
@CrossOrigin // To provide a permission to ui to interact with api.
public class MyController {

	 @GetMapping("/demo")
	 public String demo() {
		 return "This is demo page.";
	 }
	 
	 @Autowired
	 private CourseService courseService;
	 
	 @GetMapping("/courses")
	 public List<Course> getCourses() {
		 return courseService.getCourses();
	 }
	 
	 @GetMapping("/courses/{courseId}")
	 public Optional<Course> getCourse(@PathVariable String courseId) {
		 return this.courseService.getCourse(Long.parseLong(courseId));
	 }
	 
	 @PostMapping("/courses")
	 public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course); 
	 }
	 
	 @PutMapping("/courses")
	 public Course updateCourse(@RequestBody Course course) {
		 return this.courseService.updateCourse(course); 
	 }
	 
	 @DeleteMapping("/courses/{courseId}")
	 public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
		 try {
			 this.courseService.deleteCourse(Long.parseLong(courseId));
			 return new ResponseEntity<>(HttpStatus.OK);
		 } catch (Exception e) {
			 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		 
	 }
}
