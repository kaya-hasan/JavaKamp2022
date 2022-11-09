package kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageTechnologyService;
import kodlama.io.devs.business.requests.CreateProgrammingLanguageTechnologyRequest;
import kodlama.io.devs.business.requests.UpdateProgrammingLanguageTechnologyRequest;
import kodlama.io.devs.business.responses.GetAllProgrammingLanguageTechnologyResponse;

@RestController
@RequestMapping("/api/languageTechnology")
public class ProgrammingLanguageTechnologyControllers {
	private ProgrammingLanguageTechnologyService programmingLanguageTechnologyService;

	@Autowired
	public ProgrammingLanguageTechnologyControllers(
			ProgrammingLanguageTechnologyService programmingLanguageTechnologyService) {
		this.programmingLanguageTechnologyService = programmingLanguageTechnologyService;
	}
	@GetMapping("/getalltechnology")
	public List<GetAllProgrammingLanguageTechnologyResponse> getAll() throws Exception{
		return programmingLanguageTechnologyService.getAll();
	}
	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable int id) throws Exception {
		programmingLanguageTechnologyService.delete(id);
	}
	
	@PostMapping("/addTechnology")
	public void add(@RequestBody CreateProgrammingLanguageTechnologyRequest createProgrammingLanguageTechnologyRequest) throws Exception {
		programmingLanguageTechnologyService.add(createProgrammingLanguageTechnologyRequest);
	}
	@PutMapping("/language")
	public void updateProgrammingLanguage(@RequestBody UpdateProgrammingLanguageTechnologyRequest updateProgrammingLanguageTechnologyRequest) throws Exception {
		programmingLanguageTechnologyService.update(updateProgrammingLanguageTechnologyRequest);
	}
	
	
	
	
}
