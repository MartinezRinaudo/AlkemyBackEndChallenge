package alkemy.api.disney.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import alkemy.api.disney.models.CharacterModel;
import alkemy.api.disney.services.CharacterService;

@RestController
@RequestMapping("/characters")
public class CharacterController {

	/*
	 * SWAGGER-UI
	 * http://localhost:8080/swagger-ui/index.html
	*/
	
	@Autowired
	CharacterService charServ;
	
	@GetMapping
	ResponseEntity<?> getCharacters() {
		return new ResponseEntity<>(charServ.findCharacters(), HttpStatus.OK);
	}
	
	@GetMapping(params = "name")
	ResponseEntity<?> getCharacterByName(@RequestParam(name = "name") String name) {
		return new ResponseEntity<>(charServ.findCharacterByName(name), HttpStatus.OK);
	}
	
	@GetMapping(params = "age")
	ResponseEntity<?> getCharacterByAge(@RequestParam(name = "age") Integer age) {
		return new ResponseEntity<>(charServ.findCharacterByAge(age), HttpStatus.OK);
	}
	
	@GetMapping(params = "movies")
	ResponseEntity<?> getCharacterByMovieId(@RequestParam(name = "movies") Integer id) {
		return new ResponseEntity<>(charServ.findCharacterByMovieId(id), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	ResponseEntity<?> getCharacterById(@PathVariable(name = "id") Integer id) {
		return new ResponseEntity<>(charServ.findCharacter(id), HttpStatus.OK);
	}
	
	@PostMapping
	ResponseEntity<?> postCharacters(@RequestBody CharacterModel character) {
		return new ResponseEntity<>(charServ.createCharacter(character), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	ResponseEntity<?>deleteCharacter(@PathVariable(name = "id") Integer id) {
		return new ResponseEntity<>(charServ.removeCharacter(id), HttpStatus.OK);
	}
	
	@PutMapping()
	ResponseEntity<?> putCharacter(@RequestBody CharacterModel character) {
		return new ResponseEntity<>(charServ.updateCharacter(character), HttpStatus.OK);
	}
	
	
}
