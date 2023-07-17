package rbrt.portfolio.generics.example;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import rbrt.portfolio.generics.AbstractBaseEntity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "categories")
public class StoreCategory extends AbstractBaseEntity<String>{
	
	
	public StoreCategory(String id, @NotBlank String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	@Id
	private String id;
	
	@NotBlank
	@Indexed(unique = true)
	private String name;
	
	private double price;
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	private List<String> aliasList;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<String> getAliasList() {
		return aliasList;
	}
	public void setAliasList(List<String> aliasList) {
		this.aliasList = aliasList;
	}
}
