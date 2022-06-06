package alkemy.api.disney.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import alkemy.api.disney.exceptions.BadRequestException;
import alkemy.api.disney.exceptions.ErrorEnum;
import alkemy.api.disney.exceptions.NotFoundException;
import alkemy.api.disney.models.MovieModel;

@Repository
public class MovieDAOImplem {

	@Autowired
	MovieDAO movieDAO;
	@Autowired
	CharacterDAO charDAO;

	public List<MovieDTO> getAllMovies() {
		List<MovieModel> movies = movieDAO.findAll();
		List<MovieDTO> moviesDTO = new ArrayList<>();

		if (movies == null) {
			throw new NotFoundException(ErrorEnum.INVALIDMOVIE);
		} else {
			movies.forEach(m -> {
				var movieDTO = new MovieDTO(m);
				moviesDTO.add(movieDTO);
			});
			return moviesDTO;
		}
	}

	public MovieDTO getMovieById(Integer id) {
		var movieFound = movieDAO.findById(id);
		if (movieFound == null) {
			throw new NotFoundException(ErrorEnum.INVALIDMOVIE);
		} else {
			var movieDTO = new MovieDTO(movieFound);
			return movieDTO;
		}
	}

	public MovieDTO getMovieByTitle(String title) {
		var movieFound = movieDAO.findByTitle(title);
		if (movieFound == null) {
			throw new NotFoundException(ErrorEnum.INVALIDMOVIE);
		} else {
			var movieDTO = new MovieDTO(movieFound);
			return movieDTO;
		}
	}

	public List<MovieDTO> getMoviesByOrder(String order) {
		List<MovieModel> movies;
		List<MovieDTO> moviesDTO = new ArrayList<>();

		switch (order) {
		case "ASC":
			movies = movieDAO.findAllOrderByDateAsc();
			if (movies == null) {
				throw new NotFoundException(ErrorEnum.INVALIDMOVIE);
			} else {
				movies.forEach(m -> {
					var movieDTO = new MovieDTO(m);
					moviesDTO.add(movieDTO);
				});
			}
			break;
		case "DESC":
			movies = movieDAO.findAllOrderByDateDes();
			if (movies == null) {
				throw new NotFoundException(ErrorEnum.INVALIDMOVIE);
			} else {
				movies.forEach(m -> {
					var movieDTO = new MovieDTO(m);
					moviesDTO.add(movieDTO);
				});
			}
			break;
		default:
			throw new BadRequestException("Invalid Order", ErrorEnum.WRONGORDER);
		}
		return moviesDTO;
	}
	
	public MovieDTO postMovie(MovieModel movie) {
		var existingMovieId = movie.getIdMovie();
		var existingMovieName = movieDAO.findByTitle(movie.getTitle());
		
		if (existingMovieId != null || existingMovieName != null) {
			throw new BadRequestException("This movie already exists", ErrorEnum.EXISTINGMOVIE);
		} else {
			movieDAO.save(movie);
			var movieDTO = new MovieDTO(movie);
			return movieDTO;
		}
	}
	
	public String deleteMovie(Integer id) {
		var movieFound = movieDAO.findById(id);
		if(movieFound == null) {
			throw new NotFoundException(ErrorEnum.INVALIDMOVIE);
		} else {
			movieDAO.deleteById(id);
			return "Removed character";
		}
	}
	
	public MovieDTO deleteCharacter(Integer idMovie, Integer idCharacter) {
		var movieFound = movieDAO.findById(idMovie);
		var characterFound = charDAO.findById(idCharacter);
		
		if(movieFound == null) {
			throw new NotFoundException(ErrorEnum.INVALIDMOVIE);
		} else if (characterFound == null) {
			throw new NotFoundException(ErrorEnum.INVALIDCHARACTER);
		} else {
			movieFound.get().removeCharacter(characterFound.get());
			movieDAO.save(movieFound.get());
			return new MovieDTO(movieDAO.findById(idMovie));
		}
	}
	
	public MovieDTO putMovie(MovieModel movie) {
		var movieFound = movieDAO.findByTitle(movie.getTitle());
		if(movieFound == null) {
			throw new NotFoundException(ErrorEnum.INVALIDMOVIE);
		} else if(movie.equals(movieFound)) {
			throw new BadRequestException("The movie has no modification", ErrorEnum.EXISTINGMOVIE);
		} else {
			movieDAO.save(movie);
			var movieDTO = new MovieDTO(movie);
			return movieDTO;
		}
	}

}
