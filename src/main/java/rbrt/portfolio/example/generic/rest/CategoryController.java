package rbrt.portfolio.example.generic.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rbrt.portfolio.example.generic.base.AbstractBaseController;


@RestController
@RequestMapping("/category")
public class CategoryController extends AbstractBaseController<Category, String, CategoryService>{
	
	public CategoryController(CategoryService service) {
		super(service);
	}
}