package Odev3.business;

import Odev3.core.logging.Logger;
import Odev3.dataAccess.CourseDao;
import Odev3.entities.Course;

public class CourseManager {
	private CourseDao courseDao;
	private Logger[] loggers; 
	
	public CourseManager(CourseDao courseDao, Logger[] loggers) {
		this.courseDao = courseDao;
		this.loggers = loggers;
	}
	public void add(Course course, Course[] courses) throws Exception{
		for (Course course1 : courses) {
			if(course1.getName() == course.getName()) {
				throw new Exception("Ayni isimde kurs bulunmamaktadir");
			}
			if(course.getPrice() < 0) {
				throw new Exception("Kurs fiyati 0'dan kucuk bir fiyatta olamaz!");
			}
			courseDao.add(course);
			for (Logger logger : loggers) {
				logger.log(course.getName());
			}
		}
	}
}
