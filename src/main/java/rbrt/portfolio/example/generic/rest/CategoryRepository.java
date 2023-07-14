package rbrt.portfolio.example.generic.rest;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String>{
	List<Category> findByName(String name);
	List<Category> findByNameAndIdNotContaining(String name, String id);
}
