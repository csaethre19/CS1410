package queueExample;

public class Customer {
	@SuppressWarnings("unused")
	private boolean isServed;
	private String name;
	
	public Customer (String name) {
		isServed = false;
		this.name = name;
	}
	
	public void serve() {
		isServed = true;
		System.out.println(name + " has been served.");
	}

	@Override
	public String toString() {
		return name;
	}
	
}
