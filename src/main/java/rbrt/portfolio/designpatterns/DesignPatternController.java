package rbrt.portfolio.designpatterns;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rbrt.portfolio.designpatterns.abstractfactory.AbstractFactory;
import rbrt.portfolio.designpatterns.abstractfactory.IAbstractFactory;
import rbrt.portfolio.designpatterns.abstractfactory.Dog;
import rbrt.portfolio.designpatterns.abstractfactory.Person;
import rbrt.portfolio.designpatterns.builder.Computer;
import rbrt.portfolio.designpatterns.singleton.SingletonExample;

@RestController
@RequestMapping("/pattern")
public class DesignPatternController {

	@GetMapping("/singleton")
    public List<SingletonExample> testSingleton() {
		List<SingletonExample> singletonExampleList = new ArrayList<>();
		
    	SingletonExample instance1  = SingletonExample.getInstance();
    	SingletonExample instance2  = SingletonExample.getInstance();
    	
    	instance1.setTestName(String.valueOf(instance1.hashCode()));
    	instance2.setTestName(String.valueOf(instance2.hashCode()));
    	
    	singletonExampleList.add(instance1);
    	singletonExampleList.add(instance2);
    	
    	return singletonExampleList;
    }
	
	@GetMapping("/abstractfactory")
    public String testAbstractfactory() {
		String result = "";
		
		IAbstractFactory factory = new AbstractFactory();
		result = "Factory Created";
		
        Dog dog = factory.createDog();
        Person person = factory.createPerson();
        
        result = result + "\n"+dog.getInfo();
        result = result + "\nName: "+person.getName() + "\nAge: "+person.getAge()+"\nID: "+person.getId();
        
    	return result;
    }
	
	@GetMapping("/builder")
    public Computer testBuilder() {
		Computer comp = new Computer.ComputerBuilder(
				"500 GB", "8 GB").setBluetoothEnabled(true)
				.setGraphicsCardEnabled(true).build();
        
    	return comp;
    }
    
}
