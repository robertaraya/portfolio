package rbrt.portfolio.designpatterns.abstractfactory;

public interface IAbstractFactory {
    public Animal createAnimal();
    public Dog createDog();
    public Person createPerson();    
}
