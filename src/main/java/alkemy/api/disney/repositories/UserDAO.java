package alkemy.api.disney.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import alkemy.api.disney.models.UserModel;

@Repository
public interface UserDAO extends CrudRepository<UserModel, Integer>{
	public UserModel findByUserName(String userName);
}
