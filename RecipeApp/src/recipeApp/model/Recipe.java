package recipeApp.model;
/**
 * 
 * @author charl
 *
 */
public class Recipe {
		private String recipeName;
		private String recipeIngredients;
		private String recipeDirections;
		
		public Recipe(String recipeName, String recipeIngredients, String recipeDirections) {
			this.recipeName = recipeName;
			this.recipeIngredients = recipeIngredients;
			this.recipeDirections = recipeDirections;
			
		}

		public String getRecipeName() {
			return recipeName;
		}

		public void setRecipeName(String recipeName) {
			this.recipeName = recipeName;
		}

		public String getRecipeIngredients() {
			return recipeIngredients;
		}

		public void setRecipeIngredients(String recipeIngredients) {
			this.recipeIngredients = recipeIngredients;
		}

		public String getRecipeDirections() {
			return recipeDirections;
		}

		public void setRecipeDirections(String recipeDirections) {
			this.recipeDirections = recipeDirections;
		}
}
