package alkemy.api.disney.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import alkemy.api.disney.models.CharacterModel;

public class CharacterDTO {

	private static List<String> movies = new ArrayList<>();
	private Integer idCharacter;
	private String image;
	private String name;
	private Integer age;
	private Double weight;
	private String history;
	private List<String>films;
	
	public CharacterDTO() {
	}
	
	public CharacterDTO(CharacterModel character) {
		this.idCharacter = character.getIdCharacter();
		this.image = character.getImage();
		this.name = character.getName();
		this.age = character.getAge();
		this.weight = character.getWeight();
		this.history = character.getHistory();
		movies.clear();
		character.getMovies().forEach(m -> {
			movies.add(m.getTitle());
		});
		this.films = movies;
	}

	public CharacterDTO(Optional<CharacterModel> character) {
		this.idCharacter = character.get().getIdCharacter();
		this.image = character.get().getImage();
		this.name = character.get().getName();
		this.age = character.get().getAge();
		this.weight = character.get().getWeight();
		this.history = character.get().getHistory();
		movies.clear();
		character.get().getMovies().forEach(m -> {
			movies.add(m.getTitle());
		});
		this.films = movies;
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

	public List<String> getFilms() {
		return films;
	}

	public void setFilms(List<String> films) {
		this.films = films;
	}

	
	
	
}
