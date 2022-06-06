package alkemy.api.disney.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import alkemy.api.disney.models.GenderModel;

public class GenderDTO {
	private static List<String> movies = new ArrayList<>();
	private Integer idGender;
	private String name;
	private String image;
	private List<String> moviesName;
	
	public GenderDTO(GenderModel gender) {
		this.idGender = gender.getIdGender();
		this.name = gender.getName();
		this.image = gender.getImage();
		movies.clear();
		gender.getMovies().forEach(m-> {
			movies.add(m.getTitle());
		});
		this.moviesName = movies;
	}
	
	public GenderDTO(Optional<GenderModel> gender) {
		this.idGender = gender.get().getIdGender();
		this.name = gender.get().getName();
		this.image = gender.get().getImage();
		movies.clear();
		gender.get().getMovies().forEach(m-> {
			movies.add(m.getTitle());
		});
		this.moviesName = movies;
	}

	public Integer getIdGender() {
		return idGender;
	}

	public void setIdGender(Integer idGender) {
		this.idGender = idGender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<String> getMoviesName() {
		return moviesName;
	}

	public void setMoviesName(List<String> moviesName) {
		this.moviesName = moviesName;
	}

	
	
	
	
}
