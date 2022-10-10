package Odev3.dataAccess;

import java.util.List;

import Odev3.entities.Instructor;

public interface InstructorDao {
	void add(Instructor instructor);
	void delete(Instructor instructor);
	void update(Instructor instructor);
	List<Instructor> getInstructors();
}
