package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageTechnologyService;
import kodlama.io.devs.business.requests.CreateProgrammingLanguageTechnologyRequest;
import kodlama.io.devs.business.requests.UpdateProgrammingLanguageTechnologyRequest;
import kodlama.io.devs.business.responses.GetAllProgrammingLanguageTechnologyResponse;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageTechnologyRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguageTechnology;

@Service
public class ProgrammingLanguageTechnologyManager implements ProgrammingLanguageTechnologyService{

	private ProgrammingLanguageTechnologyRepository programmingLanguageTechnologyRepository;
	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	
	@Autowired
	public ProgrammingLanguageTechnologyManager(
			ProgrammingLanguageTechnologyRepository programmingLanguageTechnologyRepository,
			ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageTechnologyRepository = programmingLanguageTechnologyRepository;
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<GetAllProgrammingLanguageTechnologyResponse> getAll() {
		List<ProgrammingLanguageTechnology> programmingLanguageTechnologies = programmingLanguageTechnologyRepository.findAll();
		List<GetAllProgrammingLanguageTechnologyResponse> getAllProgrammingLanguageTechnologyResponses = new ArrayList<>();
		for (ProgrammingLanguageTechnology language : programmingLanguageTechnologies) {
			GetAllProgrammingLanguageTechnologyResponse getAllProgrammingLanguageTechnologyResponse = new GetAllProgrammingLanguageTechnologyResponse();
			getAllProgrammingLanguageTechnologyResponse.setId(language.getId());
			getAllProgrammingLanguageTechnologyResponse.setName(language.getName());
			getAllProgrammingLanguageTechnologyResponse.setLanguageId(language.getProgrammingLanguage().getId());
			getAllProgrammingLanguageTechnologyResponses.add(getAllProgrammingLanguageTechnologyResponse);
		}
		return getAllProgrammingLanguageTechnologyResponses;
	}

	@Override
	public void add(CreateProgrammingLanguageTechnologyRequest createProgrammingLanguageTechnologyRequest) throws Exception {
		if(createProgrammingLanguageTechnologyRequest.getName().isBlank() || createProgrammingLanguageTechnologyRequest.getName().isEmpty()) {
			throw new Exception("Programlama Dili Bos Olamaz");
		}
		else {
			ProgrammingLanguageTechnology programmingLanguageTechnology = new ProgrammingLanguageTechnology();
			programmingLanguageTechnology.setName(createProgrammingLanguageTechnologyRequest
					.getName());
			programmingLanguageTechnologyRepository.save(programmingLanguageTechnology);
		}
		
	}
		
	

	@Override
	public void delete(int id) {
		programmingLanguageTechnologyRepository.deleteById(id);
		
	}

	@Override
	public void update(UpdateProgrammingLanguageTechnologyRequest updateProgrammingLanguageTechnologyRequest) throws Exception {
		if(updateProgrammingLanguageTechnologyRequest.getName().isBlank() || updateProgrammingLanguageTechnologyRequest.getName().isEmpty()) {
			throw new Exception("Guncellerken bos deger giremezsiniz");
		}
		else {
			ProgrammingLanguageTechnology programmingLanguageTechnology = new ProgrammingLanguageTechnology();
			programmingLanguageTechnology.setName(updateProgrammingLanguageTechnologyRequest.getName());
			programmingLanguageTechnologyRepository.save(programmingLanguageTechnology);
		}
		
	}
	
}
