package recipeApp.model;
/**
 * Describes a recipe that a user can create including a name, ingredients, and directions.
 * 
 * @author Charlotte Saethre
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

		/**
		 * Returns name of recipe.
		 * 
		 * @return recipeName
		 */
		public String getRecipeName() {
			return recipeName;
		}

		/**
		 * Sets name of recipe.
		 * 
		 * @param recipeName
		 */
		public void setRecipeName(String recipeName) {
			this.recipeName = recipeName;
		}

		/**
		 * Returns ingredients of recipe.
		 * 
		 * @return recipe ingredients
		 */
		public String getRecipeIngredients() {
			return recipeIngredients;
		}

		/**
		 * Sets ingredients of recipe.
		 * 
		 * @param recipeIngredients
		 */
		public void setRecipeIngredients(String recipeIngredients) {
			this.recipeIngredients = recipeIngredients;
		}

		/**
		 * Returns directions of recipe. 
		 * 
		 * @return recipe directions
		 */
		public String getRecipeDirections() {
			return recipeDirections;
		}

		/**
		 * Sets directions of recipe. 
		 * 
		 * @param recipeDirections
		 */
		public void setRecipeDirections(String recipeDirections) {
			this.recipeDirections = recipeDirections;
		}
}
