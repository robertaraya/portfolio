package rbrt.portfolio.generics.example;

import java.util.List;

import org.springframework.stereotype.Service;

import rbrt.portfolio.generics.AbstractBaseService;


@Service
public class CategoryService extends AbstractBaseService<StoreCategory, String, CategoryRepository>{
	
	public CategoryService(CategoryRepository repository) {
		super(repository);
	}
	
	public List<StoreCategory> findByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public boolean hasInvalidFields(StoreCategory entity) {
		return entity.getName().isBlank();
	}
}
