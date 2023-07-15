package rbrt.portfolio.designpatterns.abstractfactory;

public class Person {
	
	private int id;
    private String name;
    private int age;

    protected Person() {}

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
    
    
}
