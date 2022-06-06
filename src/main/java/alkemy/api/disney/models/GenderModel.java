package alkemy.api.disney.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "genders")
public class GenderModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idGender;
	private String name;
	private String image;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.LAZY, mappedBy = "gender")
	private List<MovieModel> movies = new ArrayList<>();
	
	public GenderModel() {
	}

	public GenderModel(Integer idGender, String name, String image, List<MovieModel> movies) {
		this.idGender = idGender;
		this.name = name;
		this.image = image;
		this.movies = movies;
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

	public List<MovieModel> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieModel> movies) {
		this.movies = movies;
	}
}
