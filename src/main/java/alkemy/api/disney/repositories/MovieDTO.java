package alkemy.api.disney.repositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import alkemy.api.disney.models.MovieModel;

public class MovieDTO {
	private static List<String> characters = new ArrayList<>();
	private Integer idMovie;
	private String image;
	private String title;
	private LocalDate date;
	private Byte qualification;
	private List<String> charactersName;
	private String gender;
	
	public MovieDTO(MovieModel movie) {
		this.idMovie = movie.getIdMovie();
		this.image = movie.getImage();
		this.title = movie.getTitle();
		this.date = movie.getDate();
		this.qualification = movie.getQualification();
		characters.clear();
		movie.getCharacters().forEach(m-> {
			characters.add(m.getName());
		});
		this.charactersName = characters;
		this.gender = movie.getGender().getName();
	}
	
	public MovieDTO(Optional<MovieModel> movie) {
		this.idMovie = movie.get().getIdMovie();
		this.image = movie.get().getImage();
		this.title = movie.get().getTitle();
		this.date = movie.get().getDate();
		this.qualification = movie.get().getQualification();
		characters.clear();
		movie.get().getCharacters().forEach(m-> {
			characters.add(m.getName());
		});
		this.charactersName = characters;
		this.gender = movie.get().getGender().getName();
	}

	public static List<String> getCharacters() {
		return characters;
	}

	public static void setCharacters(List<String> characters) {
		MovieDTO.characters = characters;
	}

	public Integer getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(Integer idMovie) {
		this.idMovie = idMovie;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Byte getQualification() {
		return qualification;
	}

	public void setQualification(Byte qualification) {
		this.qualification = qualification;
	}

	public List<String> getCharactersName() {
		return charactersName;
	}

	public void setCharactersName(List<String> charactersName) {
		this.charactersName = charactersName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	
}
