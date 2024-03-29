
public class App {
	private int count = 0;
	
	public synchronized void increment() {
		count++;
	}
	
	public synchronized void decrement() {
		count--;
	}
	
	
	public static void main(String[] args) {
		
		App app = new App();
		app.doWork();
	}
	
	public void doWork() {
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 0; i<1000; i++) {
					increment();
				}
				
			}
			
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 0; i<1000; i++) {
					increment();
				}
			}
			
		});
		
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 0; i<1000; i++) {
					decrement();
				}
			}
			
		});
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Count is :" + count);
	}

}

