package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.CreateProgrammingLanguageTechnologyRequest;
import kodlama.io.devs.business.requests.UpdateProgrammingLanguageTechnologyRequest;
import kodlama.io.devs.business.responses.GetAllProgrammingLanguageTechnologyResponse;

public interface ProgrammingLanguageTechnologyService {

	List<GetAllProgrammingLanguageTechnologyResponse> getAll();
	void add(CreateProgrammingLanguageTechnologyRequest createProgrammingLanguageTechnologyRequest) throws Exception;
	void delete(int id);
	void update(UpdateProgrammingLanguageTechnologyRequest updateProgrammingLanguageTechnologyRequest) throws Exception;
	
}
