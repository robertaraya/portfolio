package rbrt.portfolio.generics.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rbrt.portfolio.generics.AbstractBaseController;


@RestController
@RequestMapping("/store/category")
public class CategoryController extends AbstractBaseController<StoreCategory, String, CategoryService>{
	
	public CategoryController(CategoryService service) {
		super(service);
	}
}