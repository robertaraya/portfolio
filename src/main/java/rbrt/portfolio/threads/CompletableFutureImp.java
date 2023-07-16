package rbrt.portfolio.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureImp {
	
	public void runExamples() throws InterruptedException, ExecutionException {
		System.out.println(completableFutureSupplyAsync());
		System.out.println(completableFutureApply());
		System.out.println(completableFutureCompose());
		System.out.println(completableFutureCombine());
	}
	
	public String completableFutureSupplyAsync() throws InterruptedException, ExecutionException {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");
		
		return future.get();
	}
	
	public String completableFutureApply() throws InterruptedException, ExecutionException {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");

		CompletableFuture<String> future = completableFuture.thenApply(s -> s + " World");

		return future.get();
	}
	
	public String completableFutureCompose() throws InterruptedException, ExecutionException {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello")
		    .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));

		return completableFuture.get();
	}
	
	public String completableFutureCombine() throws InterruptedException, ExecutionException {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello")
		.thenCombine(CompletableFuture.supplyAsync( () -> " World"), (s1, s2) -> s1 + s2 );

		return completableFuture.get();
	}

	public void completableFutureAcceptBoth() throws InterruptedException, ExecutionException {
		CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> "Hello")
				  .thenAcceptBoth(CompletableFuture.supplyAsync(() -> " World"), (s1, s2) -> System.out.println(s1 + s2));
		future.get();
	}
	
}
