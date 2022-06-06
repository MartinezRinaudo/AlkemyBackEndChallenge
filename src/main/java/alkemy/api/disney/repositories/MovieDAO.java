package alkemy.api.disney.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import alkemy.api.disney.models.MovieModel;

@Repository
public interface MovieDAO extends CrudRepository<MovieModel, Integer>{	
	List<MovieModel> findAll();
	MovieModel findByTitle(String title);
	
	@Query("FROM MovieModel ORDER BY date ASC")
	List<MovieModel> findAllOrderByDateAsc();
	
	@Query("FROM MovieModel ORDER BY date DESC")
	List<MovieModel> findAllOrderByDateDes();
	
	
}
