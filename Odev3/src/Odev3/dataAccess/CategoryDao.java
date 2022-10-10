package Odev3.dataAccess;



import java.util.List;

import Odev3.entities.Category;

public interface CategoryDao {
	void add(Category category);
	void delete(Category category);
	void update(Category category);
	
	List<Category> getAllCategories(List<Category> categories);
}
