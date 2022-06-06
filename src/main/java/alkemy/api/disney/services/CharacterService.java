package alkemy.api.disney.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alkemy.api.disney.models.CharacterModel;
import alkemy.api.disney.repositories.CharacterDAOImplem;
import alkemy.api.disney.repositories.CharacterDTO;
import alkemy.api.disney.repositories.MovieDAOImplem;
import alkemy.api.disney.repositories.MovieDTO;

@Service
public class CharacterService {

	@Autowired
	CharacterDAOImplem charDAO;
	@Autowired
	MovieDAOImplem movDAO;

	public List<?> findCharacters() {
		return charDAO.getAllCharacters();
	}
	
	public CharacterDTO findCharacterByName(String name) {
		return charDAO.getCharacterByName(name);
	}

	public List<CharacterDTO> findCharacterByAge(Integer age) {
		return charDAO.getCharacterByAge(age);
	}
	
	public MovieDTO findCharacterByMovieId(Integer id) {
		return movDAO.getMovieById(id);
	}
	
	public CharacterDTO findCharacter(Integer id) {
		return charDAO.getCharacterById(id);
	}
	public CharacterDTO createCharacter(CharacterModel character) {
		return charDAO.postCharacter(character);
	}
	
	public String removeCharacter(Integer id) {
		return charDAO.deleteCharacter(id);
	}
	
	public CharacterDTO updateCharacter(CharacterModel character) {
		return charDAO.putCharacter(character);
	}
}

