package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.GetAllProgrammingLanguageResponse;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<GetAllProgrammingLanguageResponse> getAll() {
		List<ProgrammingLanguage> programmingLanguages = new ArrayList<>();
		List<GetAllProgrammingLanguageResponse> getAllProgrammingLanguageResponses = new ArrayList<>();
		programmingLanguages = programmingLanguageRepository.findAll();
		for (ProgrammingLanguage language : programmingLanguages) {
			GetAllProgrammingLanguageResponse getAllProgrammingLanguageResponse = new GetAllProgrammingLanguageResponse();
			getAllProgrammingLanguageResponse.setId(language.getId());
			getAllProgrammingLanguageResponse.setName(language.getName());
			getAllProgrammingLanguageResponses.add(getAllProgrammingLanguageResponse);
		}
		return getAllProgrammingLanguageResponses;
	}

	@Override
	public GetAllProgrammingLanguageResponse getById(int id) {
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(id).get();
		GetAllProgrammingLanguageResponse getAllProgrammingLanguageResponse = new GetAllProgrammingLanguageResponse();
		getAllProgrammingLanguageResponse.setName(programmingLanguage.getName());
		return getAllProgrammingLanguageResponse;
	}

	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		if(createProgrammingLanguageRequest.getName().isEmpty() || createProgrammingLanguageRequest.getName().isBlank()) {
			throw new Exception("Programlama ismi bos olamaz!");
		} else {
			ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
			programmingLanguage.setName(createProgrammingLanguageRequest.getName());
			programmingLanguageRepository.save(programmingLanguage);
		}
	}

	@Override
	public void delete(int id) throws Exception {
		programmingLanguageRepository.deleteById(id);
		
	}

	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
		if(updateProgrammingLanguageRequest.getName().isEmpty() || updateProgrammingLanguageRequest.getName().isBlank()) {
			throw new Exception("Programlama dili guncellemmesi bos olamaz");
		} else {
			ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(updateProgrammingLanguageRequest.getId()).orElseThrow(()-> new Exception("Id bos kalamaz"));
			programmingLanguage.setName(updateProgrammingLanguageRequest.getName());
			programmingLanguageRepository.save(programmingLanguage);
			
		}
		
	}


}
