package rbrt.portfolio.designpatterns.abstractfactory;

public class AbstractFactory implements IAbstractFactory {
	
    @Override
    public Animal createAnimal() {
        return new Animal();
    }

    @Override
    public Dog createDog() {
        Dog bobby = new Dog();
        bobby.setName("Bobby");
        bobby.setSkills("Ladra, cuida, muerde");
        return bobby;
    }

    @Override
    public Person createPerson() {
        Person p = new Person();
        p.setName("Test Name");
        p.setAge(30);
        return p;
    }

}
