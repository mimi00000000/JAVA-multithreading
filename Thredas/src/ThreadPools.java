import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPools implements Runnable{
	private int id;
	
	public ThreadPools(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Starting : " + id);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Completed : " + id);
	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
			ExecutorService executor = Executors.newFixedThreadPool(2);
			for(int i = 0; i < 5; i ++) {
				executor.submit(new ThreadPools(i));
			}
			executor.shutdown();
			
			System.out.println("All tasks submitted");
			
			executor.awaitTermination(1, TimeUnit.DAYS);
			
			System.out.println("All tasks completed. ");
		
		}
}

	

 
 
 
 