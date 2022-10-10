package Odev3.dataAccess;

import java.util.ArrayList;
import java.util.List;

import Odev3.entities.Instructor;

public class JdbcInstructorDao implements InstructorDao{

	List<Instructor> instructors = new ArrayList<>();


	@Override
	public void add(Instructor instructor) {
		System.out.println("Egitmen " + instructor.getName() + "Jdbc ile eklendi");
		
	}

	@Override
	public void delete(Instructor instructor) {
		System.out.println("Egitmen " + instructor.getName() + "Jdbc ile silindi");
		
	}

	@Override
	public void update(Instructor instructor) {
		System.out.println("Egitmen " + instructor.getName() + "Jdbc ile guncellendi");
		
	}
	

	@Override
	public List<Instructor> getInstructors() {
		// TODO Auto-generated method stub
		return instructors;
	}

}
