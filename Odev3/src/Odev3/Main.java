package Odev3;

import Odev3.business.CategoryManager;
import Odev3.business.CourseManager;
import Odev3.core.logging.DatabaseLogger;
import Odev3.core.logging.FileLogger;
import Odev3.core.logging.Logger;
import Odev3.dataAccess.HibernateCategoryDao;
import Odev3.dataAccess.HibernateCourseDao;
import Odev3.entities.Category;
import Odev3.entities.Course;
import Odev3.entities.Instructor;

public class Main {

	public static void main(String[] args) throws Exception {
		Course course1 = new Course(1,"Yazilim Gelistirici Yetistirme Kampi (C# + Angular)",50);
		Course course2 = new Course(2,"Yazilim Gelistirici Yetistirme Kampi (JavaScript)",50);
		Instructor instructor1 = new Instructor(1, "Engin Demirog");
		Category category1 = new Category(1, "Yazilim");
		Category category2 = new Category(2, "Web");
		
		Category[] categories = new Category[] {new Category(2, "Otomasyon")};
		Course[] courses = new Course[] {new Course(3, "(2022) Yazilim Gelistirici Yetistirme Kampı - JAVA", 50)};
		Logger[] loggers = {new DatabaseLogger(), new FileLogger()};
		CourseManager courseManager = new CourseManager(new HibernateCourseDao(), loggers);
		courseManager.add(course2, courses);
		courseManager.add(course1, courses);
		
		CategoryManager categoryManager = new CategoryManager(new HibernateCategoryDao(), loggers);
		categoryManager.add(category2, categories);

	}

}
