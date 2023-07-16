package rbrt.portfolio.threads;

public class RunnableImp implements Runnable  {
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(i);			
		}
	}
}
