package Odev3.business;

import Odev3.core.logging.Logger;
import Odev3.dataAccess.InstructorDao;
import Odev3.entities.Instructor;

public class InstructorManager {
	private InstructorDao instructorDao;
	private Logger[] loggers;
	
	public InstructorManager(InstructorDao instructorDao, Logger[] loggers) {
		this.instructorDao = instructorDao;
		this.loggers = loggers;
		
	}
	public void add(Instructor instructor) {
		instructorDao.add(instructor);
	}
}
