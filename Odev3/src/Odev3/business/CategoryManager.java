package Odev3.business;

import Odev3.core.logging.Logger;
import Odev3.dataAccess.CategoryDao;
import Odev3.entities.Category;

public class CategoryManager {
	private CategoryDao categoryDao;
	private Logger[] loggers;
	public CategoryManager(CategoryDao _categoryDao, Logger[] loggers) {
		this.categoryDao = _categoryDao;
		this.loggers = loggers;
	}
	public void add(Category category, Category[] categories) throws Exception{
		for (Category category1 : categories) {
			if(category1.getName() == category.getName()) {
				throw new Exception("Ayni isimde 2 kategori olamaz!");
			}
			
		}
		categoryDao.add(category);
		for(Logger logger: loggers) {
			logger.log(category.getName());
		}
	}
}
