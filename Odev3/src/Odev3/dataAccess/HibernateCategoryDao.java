package Odev3.dataAccess;

import java.util.List;

import Odev3.entities.Category;

public class HibernateCategoryDao implements CategoryDao{

	@Override
	public void add(Category category) {
		System.out.println("Kurs kategorisi " + category.getName() + "Hibernate ile kaydedildi");
		
	}

	@Override
	public void delete(Category category) {
		System.out.println("Kurs kategorisi" + category.getName() + "Hibernate ile silindi");
		
	}

	@Override
	public void update(Category category) {
		System.out.println("Kurs kategorisi" + category.getName() + "Hibernate ile guncellendi");
		
	}

	@Override
	public List<Category> getAllCategories(List<Category> categories) {
		// TODO Auto-generated method stub
		return categories;
	}

}
