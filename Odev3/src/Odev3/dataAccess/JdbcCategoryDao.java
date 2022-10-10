package Odev3.dataAccess;

import java.util.List;

import Odev3.entities.Category;

public class JdbcCategoryDao implements CategoryDao{

	@Override
	public void add(Category category) {
		System.out.println("Kurs kategorileri " + category.getName() + "Jdbc ile eklendi");
		
	}

	@Override
	public void delete(Category category) {
		System.out.println("Kurs kategorileri" + category.getName() + "Jdbc ile silindi");
		
	}

	@Override
	public void update(Category category) {
		System.out.println("Kurs kategorileri" + category.getName() + "Jdbc ile guncellendi");
		
	}

	@Override
	public List<Category> getAllCategories(List<Category> categories) {
		// TODO Auto-generated method stub
		return categories;
	}

}
