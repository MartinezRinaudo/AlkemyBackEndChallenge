package alkemy.api.disney.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import alkemy.api.disney.models.CharacterModel;

@Repository
public interface CharacterDAO extends CrudRepository<CharacterModel, Integer>{
	public List<CharacterModel> findAll();
	public CharacterModel findByName(String name);
	public List<CharacterModel> findByAge(Integer age);
	
}
