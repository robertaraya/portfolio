package rbrt.portfolio.example.generic.rest;

import java.util.List;
import org.springframework.stereotype.Service;
import rbrt.portfolio.example.generic.base.AbstractBaseService;


@Service
public class CategoryService extends AbstractBaseService<Category, String, CategoryRepository>{
	
	public CategoryService(CategoryRepository repository) {
		super(repository);
	}
	
	public List<Category> findByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public boolean hasInvalidFields(Category entity) {
		return entity.getName().isBlank();
	}
}
