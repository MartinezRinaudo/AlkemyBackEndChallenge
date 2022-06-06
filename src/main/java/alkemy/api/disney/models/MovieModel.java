package alkemy.api.disney.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class MovieModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idMovie;
	private String image;
	private String title;
	private LocalDate date;
	private Byte qualification;
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH},fetch = FetchType.LAZY, mappedBy = "movies")
	private List<CharacterModel> characters = new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "gender_id")
	private GenderModel gender;
	
	public MovieModel() {
	}

	public MovieModel(Integer idMovie, String image, String title, LocalDate date, Byte qualification,
			List<CharacterModel> characters, GenderModel gender) {
		this.idMovie = idMovie;
		this.image = image;
		this.title = title;
		this.date = date;
		this.qualification = qualification;
		this.characters = characters;
		this.gender = gender;
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

	public List<CharacterModel> getCharacters() {
		return characters;
	}

	public void setCharacters(List<CharacterModel> characters) {
		this.characters = characters;
	}

	public GenderModel getGender() {
		return gender;
	}

	public void setGender(GenderModel gender) {
		this.gender = gender;
	}
	
	public void addCharacter(CharacterModel character) {
		this.characters.add(character);
		//character.getMovies().add(this);
	}
	
	public void removeCharacter(CharacterModel character) {
		this.characters.remove(character);
		//character.getMovies().remove(this);
	}
}
