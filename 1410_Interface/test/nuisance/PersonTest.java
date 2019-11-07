package nuisance;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {
	private Person person1;
	private Person person2;
	@SuppressWarnings("unused")
	private Person notPerson;
	@SuppressWarnings("unused")
	private Person notPerson2;
	
	@BeforeEach
	void setUp() throws Exception {
		person1 = new Person("Kate", 31);
		person2 = new Person("Deejay", 32);
	}

	@Test
	void personConstructor_CreatingPersonWithAge0_ThrowsIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {notPerson = new Person("Berry", 0);});
	}

	@Test
	void personConstructor_CreatingPersonWithNegativeAge_ThrowsIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {notPerson2 = new Person("Carrie", -1);});
	}

	@Test
	void getAge_GettingPerson1Age_ReturnsKatesAge() {
		int expected = 31;
		int actual = person1.getAge();
		assertEquals(expected, actual);
	}
	
	@Test
	void getName_GettingPerson2Name_ReturnsDeejay() {
		String expected = "Deejay";
		String actual = person2.getName();
		assertEquals(expected, actual);
	}

}
