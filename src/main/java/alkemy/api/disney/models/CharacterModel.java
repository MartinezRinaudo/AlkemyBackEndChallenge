package alkemy.api.disney.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "characters")
public class CharacterModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCharacter;
	private String image;
	private String name;
	private Integer age;
	private Double weight;
	private String history;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH},fetch = FetchType.LAZY)
	@JoinTable(name = "characters_movies", joinColumns = @JoinColumn(name="id_character"), 
	inverseJoinColumns = @JoinColumn(name="idMovie"))
	private List<MovieModel> movies = new ArrayList<>();
	
	public CharacterModel() {
	}

	public CharacterModel(Integer idCharacter, String image, String name, Integer age, Double weight, String history,
			List<MovieModel> movies) {
		this.idCharacter = idCharacter;
		this.image = image;
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.history = history;
		this.movies = movies;
	}

	public Integer getIdCharacter() {
		return idCharacter;
	}

	public void setIdCharacter(Integer idCharacter) {
		this.idCharacter = idCharacter;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public List<MovieModel> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieModel> movies) {
		this.movies = movies;
	}
	
	public void addMovie(MovieModel movie) {
		this.movies.add(movie);
		movie.getCharacters().add(this);
	}
	
	public void removeMovie(MovieModel movie) {
		this.movies.remove(movie);
		movie.getCharacters().remove(this);
	}
}
