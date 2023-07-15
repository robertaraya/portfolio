package rbrt.portfolio.designpatterns.abstractfactory;

public class Dog {
    private String name;
    private String skills;

    protected Dog() {}
    
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}



	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getInfo(){        
        return "\nNombre: " + this.name + 
               "\nTrucos: " + this.skills;
    }       
}
