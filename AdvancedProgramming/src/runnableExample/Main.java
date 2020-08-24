package runnableExample;

public class Main {

	public static void main(String[] args) {
		Thread thread1 = new Thread(new RunnableExample());
		thread1.setName("Thread 1");
		thread1.start();
		
		Thread thread2 = new Thread(() -> {
				int i = 1;
				while (i <= 100) {
					System.out.println(i + " " + Thread.currentThread().getName());
					i++;
				}
			
		});
		thread2.setName("Thread 2");
		thread2.start();
	}

}
