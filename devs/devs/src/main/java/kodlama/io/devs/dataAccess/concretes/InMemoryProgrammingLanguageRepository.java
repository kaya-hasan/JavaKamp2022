package kodlama.io.devs.dataAccess.concretes;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository{

	
	
	private List<ProgrammingLanguage> programmingLanguages;
	
	
	public InMemoryProgrammingLanguageRepository() {
		programmingLanguages = new ArrayList<ProgrammingLanguage>();
		programmingLanguages.add(new ProgrammingLanguage(1,"Bos"));
		programmingLanguages.add(new ProgrammingLanguage(2,"C#"));
		programmingLanguages.add(new ProgrammingLanguage(3,"Java"));
		programmingLanguages.add(new ProgrammingLanguage(4,"Python"));
		programmingLanguages.add(new ProgrammingLanguage(5,"C++"));
		
	}


	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguages;
	}
	

	@Override
	public ProgrammingLanguage addProgrammingLanguage(ProgrammingLanguage programmingLanguage) throws Exception{
		for (ProgrammingLanguage pL : programmingLanguages) {
			if (pL.getName().equals(programmingLanguage.getName())) {
				throw new Exception("Aynı isimde programlama dili zaten var.");
			}
		}
		programmingLanguages.add(programmingLanguage);
		return programmingLanguage;
	}


	@Override
	public ProgrammingLanguage getProgrammingLanguageById(int programmingLanguageId) {
		return programmingLanguages.get(programmingLanguageId);
	}


	@Override
	public ProgrammingLanguage updateProgrammingLanguage(int programmingLanguageId,
			ProgrammingLanguage programmingLanguage) {
		programmingLanguages.set(programmingLanguageId, programmingLanguage);
		return null;
	}


	@Override
	public void deleteProgrammingLanguage(int programmingLanguageId) {
		programmingLanguages.remove(programmingLanguageId);
		
	}


}
