package rbrt.portfolio.designpatterns.singleton;

public class SingletonExample {

    private static SingletonExample Instance = null;
    private String testName;
    
    private SingletonExample() {}

    public static SingletonExample getInstance() {
        if (Instance == null)
            Instance = new SingletonExample();
        return Instance;
    }

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}
}
