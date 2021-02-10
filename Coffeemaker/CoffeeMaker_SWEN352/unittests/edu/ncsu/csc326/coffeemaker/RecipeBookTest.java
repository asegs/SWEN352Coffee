package edu.ncsu.csc326.coffeemaker;

import junit.framework.TestCase;
import org.junit.Test;

public class RecipeBookTest extends TestCase {

	private RecipeBook mockRecipeBook;
	private Recipe mockRecipe;

	private final String def_size = "15";
	private final String def_price = "40";

	protected void setUp() throws Exception {
		System.out.println("Set up RecipeBook Test Processing");
		this.mockRecipeBook = new RecipeBook();
		this.mockRecipe = new Recipe();
		this.mockRecipe.setAmtChocolate(def_size);
		this.mockRecipe.setAmtCoffee(def_size);
		this.mockRecipe.setAmtMilk(def_size);
		this.mockRecipe.setAmtSugar(def_size);
		this.mockRecipe.setName("Test Name 1");
		this.mockRecipe.setPrice(def_price);
		System.out.println("Set up RecipeBook Test Completed");
		super.setUp();
	}

	@Test
	public void testGetRecipesLength() {
		this.mockRecipeBook.addRecipe(this.mockRecipe);
		int expectAmt = 4;
		Recipe[] recipes = this.mockRecipeBook.getRecipes();
		assertEquals(expectAmt, recipes.length);
	}

	@Test
	public void testGetRecipes() {
		this.mockRecipeBook.addRecipe(this.mockRecipe);
		boolean allPresent = true;
		for (Recipe recipe : this.mockRecipeBook.getRecipes()) {
			if(recipe != null && !recipe.equals(this.mockRecipe)) {
				allPresent = false;
			}
		}
		assertTrue(allPresent);
	}

	@Test
	public void testAddOneRecipe() {
		this.mockRecipeBook.addRecipe(this.mockRecipe);
		Recipe[] recipes = this.mockRecipeBook.getRecipes();
		assertEquals(recipes[0], this.mockRecipe);
	}

	@Test
	public void testAddTwoRecipe() {
		this.mockRecipeBook.addRecipe(this.mockRecipe);

		// There is a new recipe if the names are different
		// irrespective of the ingredients used in it.
		Recipe anotherRecipe = new Recipe();
		anotherRecipe.setName("Test Name 2");
		this.mockRecipeBook.addRecipe(anotherRecipe);
		Recipe[] recipes = this.mockRecipeBook.getRecipes();
		int expectAmt = 2;
		int recipeLeft = 0;
		for(Recipe recipe : recipes) {
			if(recipe != null) {
				recipeLeft++;
			}
		}
		assertEquals(expectAmt, recipeLeft);
	}

	@Test
	public void testAddDuplicateRecipe() {
		this.mockRecipeBook.addRecipe(this.mockRecipe);
		this.mockRecipeBook.addRecipe(this.mockRecipe);
		this.mockRecipeBook.addRecipe(this.mockRecipe);
		this.mockRecipeBook.addRecipe(this.mockRecipe);
		int totalRecipesInBook = 1;
		int expectAmt = 1;
		Recipe[] recipes = this.mockRecipeBook.getRecipes();
		for(Recipe recipe : recipes) {
			if(recipe != null && !recipe.equals(this.mockRecipe)) {
				totalRecipesInBook++;
			}
		}

		assertEquals(expectAmt, totalRecipesInBook);
	}

	@Test
	public void testDeleteRecipe() {
		this.mockRecipeBook.addRecipe(this.mockRecipe);
		String recipe = this.mockRecipeBook.deleteRecipe(0);
		Recipe[] recipes = this.mockRecipeBook.getRecipes();
		assertNull(recipes[0]);
	}

	@Test
	public void testDeleteRecipeName() {
		this.mockRecipeBook.addRecipe(this.mockRecipe);
		String recipe = this.mockRecipeBook.deleteRecipe(0);
		boolean isSame = recipe.equals(this.mockRecipe.getName());
		assertTrue(isSame);
	}

	@Test
	public void testDeleteRecipeAtFirstIndexReturnNull() {
		this.mockRecipeBook.addRecipe(this.mockRecipe);
		String recipe = this.mockRecipeBook.deleteRecipe(1);
		assertNull(recipe);
	}

	@Test
	public void testDeleteRecipeAt0Index() {
		String recipe = this.mockRecipeBook.deleteRecipe(0);
		assertNull(recipe);
	}

	@Test
	public void testMaximumRecipeCount() {
		Recipe r1 = new Recipe();
		Recipe r2 = new Recipe();
		Recipe r3 = new Recipe();
		Recipe r4 = new Recipe();
		Recipe r5 = new Recipe();
		Recipe r6 = new Recipe();
		r1.setName("Test 1");
		r2.setName("Test 2");
		r3.setName("Test 3");
		r4.setName("Test 4");
		r5.setName("Test 5");
		r6.setName("Test 6");
		this.mockRecipeBook.addRecipe(r1);
		this.mockRecipeBook.addRecipe(r2);
		this.mockRecipeBook.addRecipe(r3);
		this.mockRecipeBook.addRecipe(r4);
		this.mockRecipeBook.addRecipe(r5);
		this.mockRecipeBook.addRecipe(r6);

		Recipe[] recipes = this.mockRecipeBook.getRecipes();
		int expectAmt = 4;
		assertEquals(expectAmt, recipes.length);
	}

	@Test
	public void testEditRecipe() {
		Recipe replace = new Recipe();
		this.mockRecipeBook.addRecipe(this.mockRecipe);
		this.mockRecipeBook.editRecipe(0, replace);
		assertEquals(replace, this.mockRecipeBook.getRecipes()[0]);

	}

	@Test
	public void testEditRecipeNull() {
		Recipe toReplaceWith = new Recipe();
		this.mockRecipeBook.addRecipe(this.mockRecipe);
		assertNull(this.mockRecipeBook.editRecipe(1, toReplaceWith));

	}

	@Test
	public void testEditRecipeName() {
		Recipe replace = new Recipe();
		replace.setName("Moises");
		this.mockRecipeBook.addRecipe(this.mockRecipe);
		this.mockRecipeBook.editRecipe(0, replace);
		assertEquals(replace.getName(), this.mockRecipeBook.getRecipes()[0].getName());
	}


	protected void tearDown() throws Exception {
		System.out.println("Set down RecipeBook Test Tearing");
		this.mockRecipeBook = null;
		this.mockRecipe = null;
		System.out.println("Set down RecipeBook Test Completed");
		assertNull(this.mockRecipe);
		assertNull(this.mockRecipeBook);
		super.tearDown();
	}
}
