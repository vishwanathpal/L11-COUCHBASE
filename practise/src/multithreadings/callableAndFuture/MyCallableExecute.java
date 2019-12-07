package multithreadings.callableAndFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyCallableExecute {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		MyCallable[] jobs = {new MyCallable(10),
							 new MyCallable(20),
							 new MyCallable(30),
							 new MyCallable(40),
							 new MyCallable(50),
							 new MyCallable(60)};
		ExecutorService service = Executors.newFixedThreadPool(3);
		for(MyCallable job : jobs) {
			Future future = service.submit(job);
			System.out.println(future.get());
		}
	}
}
