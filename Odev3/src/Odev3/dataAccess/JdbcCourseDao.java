package Odev3.dataAccess;

import java.util.ArrayList;
import java.util.List;

import Odev3.entities.Course;

public class JdbcCourseDao implements CourseDao{

	List<Course> courses = new ArrayList<>();
	@Override
	public void add(Course course) {
		System.out.println("Kurslar " + course.getName() + "Jdbc ile eklendi");
		
	}

	@Override
	public void delete(Course course) {
		System.out.println("Kurslar" + course.getName() + "Jdbc ile silindi");
		
	}

	@Override
	public void update(Course course) {
		System.out.println("Kurslar" + course.getName() + "Jdbc ile guncellendi");
		
	}

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return courses;
	}

	

	

	

}
