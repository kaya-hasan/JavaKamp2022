package kodlama.io.devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlama.io.devs.entities.concretes.ProgrammingLanguageTechnology;


public interface ProgrammingLanguageTechnologyRepository extends JpaRepository<ProgrammingLanguageTechnology, Integer>{

}
