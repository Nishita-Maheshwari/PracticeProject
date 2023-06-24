package com.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.springrest.entities.Course;


@Service
public class CourseServiceimpl implements CourseService {
	
  List<Course> list;
  
       public CourseServiceimpl(){
    	list = new ArrayList<>();
		list.add(new Course(145, "Java Core Course", "This Course Containts Advance java"));
		list.add(new Course(146, "Java Advance Course", "This Course Containts Basic java"));

	    }
	
	@Override
	public List<Course> getCourses(){
		return list;
	}

	@Override
	public Course getCourse(long courseId) {
		Course c=null;
		for(Course course:list) {
			if(course.getId()==courseId) {
				c=course;
			    break;
		}
	}
		return c;
		
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		list.forEach(e ->{
	    if(e.getId()==course.getId()) {
			e.setTitle(course.getTitle());
			e.setDescription(course.getDescription());
	}
	});
	return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
	
		
	}

}
