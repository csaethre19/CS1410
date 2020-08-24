package threadExample;

public class Main {

	public static void main(String[] args) {
		//Everytime you run a java program it creates at least one thread, demonstrated by 
		//print statement below
		//System.out.println(Thread.activeCount());
		
		//Create another thread by making instance of ThreadExample class
		ThreadExample thread1 = new ThreadExample();
		thread1.setName("My first thread");
		//thread is in waiting state until start method called
		//start will call run method
		thread1.start();
		
		ThreadExample thread2 = new ThreadExample();
		thread2.setName("My second thread");
		thread2.start();
		
		
	}

}
