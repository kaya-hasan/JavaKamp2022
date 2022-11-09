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

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.GetAllProgrammingLanguageResponse;


@RestController
@RequestMapping("/api/languages")
public class ProgrammingLanguageControllers {

	private ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguageControllers(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}
	@GetMapping("/getall")
	public List<GetAllProgrammingLanguageResponse> getAll() throws Exception{
		return programmingLanguageService.getAll();
	}
	
	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable int id) throws Exception {
		programmingLanguageService.delete(id);
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		programmingLanguageService.add(createProgrammingLanguageRequest);
	}
	
	@PutMapping("/language")
	public void updateProgrammingLanguage(@RequestBody UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
		programmingLanguageService.update(updateProgrammingLanguageRequest);
	}
	
	@GetMapping("/{id}")
	public GetAllProgrammingLanguageResponse getById(@PathVariable int id) throws Exception{
		return programmingLanguageService.getById(id);
	}
	
	
	
}
