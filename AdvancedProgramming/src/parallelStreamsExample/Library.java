package parallelStreamsExample;

import java.util.ArrayList;
import java.util.List;

public class Library {

	public static void main(String[] args) {
		//instead of using stream() method we use parallelStream() method
		//same output
		//difference is in the speed of the performance
		//performance impact when using very large amount of data
		List<Book> books = populateLibrary();
		books.parallelStream().filter(book -> {
			return book.getAuthor().startsWith("J");
		}).forEach(System.out::println);
		
	}

	private static List<Book> populateLibrary() {
		List<Book> books = new ArrayList<>();
		books.add(new Book("Alice Walker", "This Color Purple"));
		books.add(new Book("Toni Morrison", "Beloved"));
		books.add(new Book("John Steinbeck", "Paradise"));
		books.add(new Book("Jane Austen", "Pride and Prejudice"));
		books.add(new Book("Jane Austen", "Emma"));

		return books;
	}

}
