package alkemy.api.disney.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alkemy.api.disney.models.MovieModel;
import alkemy.api.disney.repositories.GenderDAOImplem;
import alkemy.api.disney.repositories.GenderDTO;
import alkemy.api.disney.repositories.MovieDAOImplem;
import alkemy.api.disney.repositories.MovieDTO;

@Service
public class MovieService {

	@Autowired
	MovieDAOImplem movDAO;
	@Autowired
	GenderDAOImplem genDAO;

	public List<?> findMovies() {
		return movDAO.getAllMovies();
	}
	
	public MovieDTO findMovieByTitle(String title) {
		return movDAO.getMovieByTitle(title);
	}
	
	public MovieDTO findMovieById(Integer id) {
		return movDAO.getMovieById(id);
	}

	public GenderDTO findMovieByGenderId(Integer id) {
		return genDAO.getGenderById(id);
	}
	
	public List<?> findMoviesByOrder(String order){
		return movDAO.getMoviesByOrder(order.toUpperCase());
	}
	
	public MovieDTO createMovie(MovieModel movie) {
		return movDAO.postMovie(movie);
	}
	
	public String removeMovie(Integer id) {
		return movDAO.deleteMovie(id);
	}
	
	public MovieDTO removeCharacter(Integer idMovie, Integer idCharacter) {
		return movDAO.deleteCharacter(idMovie, idCharacter);
	}
	
	public MovieDTO updateMovie(MovieModel movie) {
		return movDAO.putMovie(movie);
	}
}

