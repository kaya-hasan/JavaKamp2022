package Odev3.dataAccess;

import java.util.List;

import Odev3.entities.Course;

public interface CourseDao {
	void add(Course course);
	void delete(Course course);
	void update(Course course);
	
	List<Course> getAllCourses();
}
