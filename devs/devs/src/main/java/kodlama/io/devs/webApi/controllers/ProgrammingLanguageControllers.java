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
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api")
public class ProgrammingLanguageControllers {

	private ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguageControllers(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll(){
		return this.programmingLanguageService.getAll();
	}
	
	 @GetMapping("{id}")
	 public ProgrammingLanguage getProgrammingLanguageById(@PathVariable("id") int programmingLanguageId)  {
			return programmingLanguageService.getProgrammingLanguageById(programmingLanguageId);
		}
	 
	 @PostMapping()
	 public ProgrammingLanguage addProgrammingLanguage(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
			return programmingLanguageService.addProgrammingLanguage(programmingLanguage);
		}
	 @PutMapping("{id}")
	 public ProgrammingLanguage updateProgrammingLanguage(@PathVariable("id") int programmingLanguageId, @RequestBody ProgrammingLanguage programmingLanguage) {
			return programmingLanguageService.updateProgrammingLanguage(programmingLanguageId, programmingLanguage);
		}
	 @DeleteMapping("{id}")
		public void deleteProgrammingLanguage(@PathVariable("id") int programmingLanguageId) {
			programmingLanguageService.deleteProgrammingLanguage(programmingLanguageId);
		}
	 
	 
}
