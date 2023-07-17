package rbrt.portfolio.generics.example;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<StoreCategory, String>{
	List<StoreCategory> findByName(String name);
	List<StoreCategory> findByNameAndIdNotContaining(String name, String id);
}
