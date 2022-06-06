package alkemy.api.disney.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import alkemy.api.disney.exceptions.BadRequestException;
import alkemy.api.disney.exceptions.ErrorEnum;
import alkemy.api.disney.exceptions.NotFoundException;
import alkemy.api.disney.models.CharacterModel;

@Repository
public class CharacterDAOImplem {

	@Autowired
	CharacterDAO characterDAO;

	public List<CharacterDTO> getAllCharacters() {
		List<CharacterModel> characters = characterDAO.findAll();
		List<CharacterDTO> charactersDTO = new ArrayList<>();

		if (characters == null) {
			throw new NotFoundException(ErrorEnum.INVALIDCHARACTER);
		} else {
			characters.forEach(c -> {
				var characterDTO = new CharacterDTO(c);
				charactersDTO.add(characterDTO);
			});
			return charactersDTO;
		}
	}

	public CharacterDTO getCharacterByName(String name) {
		var characterFound = characterDAO.findByName(name);
		if (characterFound == null) {
			throw new NotFoundException(ErrorEnum.INVALIDCHARACTER);
		} else {
			var characterDTO = new CharacterDTO(characterFound);
			return characterDTO;
		}
	}
	
	public List<CharacterDTO> getCharacterByAge(Integer age) {
		var charactersFound = characterDAO.findByAge(age);
		
		List<CharacterDTO> charactersDTO = new ArrayList<>();
		
		if (charactersFound == null) {
			throw new NotFoundException(ErrorEnum.INVALIDCHARACTER);
		} else {
			charactersFound.forEach(c -> {				
				var characterDTO = new CharacterDTO(c);
				charactersDTO.add(characterDTO);
		});
			return charactersDTO;
		}
	}

	public CharacterDTO getCharacterById(Integer id) {
		var characterFound = characterDAO.findById(id);
		if (characterFound == null) {
			throw new NotFoundException(ErrorEnum.INVALIDCHARACTER);
		} else {
			var characterDTO = new CharacterDTO(characterFound);
			return characterDTO;
		}
	}

	public CharacterDTO postCharacter(CharacterModel character) {
		var existingCharacterId = character.getIdCharacter();
		var existingCharacterName = characterDAO.findByName(character.getName());
		
		if (existingCharacterId != null || existingCharacterName != null) {
			throw new BadRequestException("This character already exists", ErrorEnum.EXISTINGCHARACTER);
		} else {
			characterDAO.save(character);
			var characterDTO = new CharacterDTO(character);
			return characterDTO;
		}
	}
	
	public String deleteCharacter(Integer id) {
		var characterFound = characterDAO.findById(id);
		if(characterFound == null) {
			throw new NotFoundException(ErrorEnum.INVALIDCHARACTER);
		} else {
			characterDAO.deleteById(id);
			return "Removed character";
		}
	}
	
	public CharacterDTO putCharacter(CharacterModel character) {
		var characterFound = characterDAO.findByName(character.getName());
		if(characterFound == null) {
			throw new NotFoundException(ErrorEnum.INVALIDCHARACTER);
		} else if(character.equals(characterFound)) {
			throw new BadRequestException("The character has no modification", ErrorEnum.EXISTINGCHARACTER);
		} else {
			characterDAO.save(character);
			var characterDTO = new CharacterDTO(character);
			return characterDTO;
		}
	}
}
