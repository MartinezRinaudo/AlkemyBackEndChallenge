package alkemy.api.disney.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import alkemy.api.disney.models.GenderModel;

@Repository
public interface GenderDAO extends CrudRepository<GenderModel, Integer>{	
	List<GenderModel> findAll();
	GenderModel findByName(String name);
}
