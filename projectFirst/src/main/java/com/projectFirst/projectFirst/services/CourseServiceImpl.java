package com.projectFirst.projectFirst.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectFirst.projectFirst.dao.CourseDao;
import com.projectFirst.projectFirst.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDoa;
	public CourseServiceImpl() {
		
	}
	
	@Override
	public List<Course> getCourses(){
		return courseDoa.findAll();
	}

	@Override
	public Optional<Course> getCourse(long courseId) {
		return courseDoa.findById(courseId);
	}

	@Override
	public Course addCourse(Course course) {
		courseDoa.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {

		return courseDoa.save(course);
	}

	@Override
	public void deleteCourse(long parseLong) {
		Course data = courseDoa.getReferenceById(parseLong);
		courseDoa.delete(data);
	}
	
	
}
