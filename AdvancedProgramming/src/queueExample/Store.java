package queueExample;

import java.util.LinkedList;

public class Store {

	public static void main(String[] args) {
		LinkedList<Customer> queue = new LinkedList<Customer>();
		queue.add(new Customer("Freddy"));
		queue.add(new Customer("Angela"));
		queue.add(new Customer("Jamie"));
		queue.add(new Customer("Henry"));
		queue.add(new Customer("Rebecca"));
		System.out.println(queue);
		serveCustomer(queue);
		System.out.println(queue);
		
		
	}
	
	public static void serveCustomer(LinkedList<Customer> queue) {
		//poll method returns the first item of linkedlist and removes it
		Customer c = queue.poll();
		c.serve();
	}

}
