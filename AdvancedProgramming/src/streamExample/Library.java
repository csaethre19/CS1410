package streamExample;

import java.util.ArrayList;
import java.util.List;

public class Library {

	public static void main(String[] args) {
		List<Book> books = populateLibrary();
		books.stream().filter(book -> {
			return book.getAuthor().startsWith("J");
		}).filter(book -> {
			return book.getTitle().startsWith("E");
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
