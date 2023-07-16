package rbrt.portfolio.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureImp {
	private ExecutorService executor = Executors.newSingleThreadExecutor();

	public Future<Integer> multiply(Integer input, Integer input2) {
		return executor.submit(() -> {
			Thread.sleep(1000);
			return input * input2;
		});
	}

}
