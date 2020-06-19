package myRecipes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RecipeTest {
	private Recipe recipe = new Recipe("recipe test", "test ingredients", "test directions");

	@Test
	void testGetName() {
		String expected = "recipe test";
		String actual = recipe.getName();
		assertEquals(expected, actual);
	}

}
