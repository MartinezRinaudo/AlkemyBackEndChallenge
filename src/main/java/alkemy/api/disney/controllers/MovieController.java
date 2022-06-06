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

import alkemy.api.disney.models.MovieModel;
import alkemy.api.disney.services.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	/*
	 * SWAGGER-UI
	 * http://localhost:8080/swagger-ui/index.html
	*/
	
	@Autowired
	MovieService movieServ;
	
	@GetMapping
	ResponseEntity<?> getmovies() {
		return new ResponseEntity<>(movieServ.findMovies(), HttpStatus.OK);
	}
	
	@GetMapping(params = "title")
	ResponseEntity<?> getMovieByTitle(@RequestParam(name = "title") String title) {
		return new ResponseEntity<>(movieServ.findMovieByTitle(title), HttpStatus.OK);
	}
	
	@GetMapping(params = "gender")
	ResponseEntity<?> getMoviesByGenderId(@RequestParam(name = "gender") Integer id) {
		return new ResponseEntity<>(movieServ.findMovieByGenderId(id), HttpStatus.OK);
	}
	
	@GetMapping(params = "order")
	ResponseEntity<?> getMoviesByOrder(@RequestParam(name = "order") String order) {
		return new ResponseEntity<>(movieServ.findMoviesByOrder(order), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	ResponseEntity<?> getMovieById(@PathVariable(name = "id") Integer id) {
		return new ResponseEntity<>(movieServ.findMovieById(id), HttpStatus.OK);
	}
	
	@PostMapping
	ResponseEntity<?> postMovie(@RequestBody MovieModel movie) {
		return new ResponseEntity<>(movieServ.createMovie(movie), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	ResponseEntity<?>deleteMovie(@PathVariable(name = "id") Integer id) {
		return new ResponseEntity<>(movieServ.removeMovie(id), HttpStatus.OK);
	}
	
	@PutMapping()
	ResponseEntity<?> putCharacter(@RequestBody MovieModel movie) {
		return new ResponseEntity<>(movieServ.updateMovie(movie), HttpStatus.OK);
	}
	
	@DeleteMapping(path= "/{idMovie}/characters/{idCharacter}")
	ResponseEntity<?>deleteCharacter(@PathVariable(name = "idMovie") Integer idMovie, @PathVariable(name="idCharacter") Integer idCharacter) {
		return new ResponseEntity<>(movieServ.removeCharacter(idMovie, idCharacter), HttpStatus.OK);
	}
	
	
}
