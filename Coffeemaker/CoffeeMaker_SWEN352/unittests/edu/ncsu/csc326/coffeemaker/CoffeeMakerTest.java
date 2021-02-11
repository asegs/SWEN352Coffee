package edu.ncsu.csc326.coffeemaker;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import junit.framework.TestCase;

public class CoffeeMakerTest extends TestCase{
	CoffeeMaker CuT = new CoffeeMaker();
	Recipe r1 = new Recipe();
	Recipe r2 = new Recipe();
	Recipe r3 = new Recipe();
	Recipe r4 = new Recipe();
	Recipe r5 = new Recipe();
	
	@Test
	public void testRecipeAddNormal() {
		CoffeeMaker CuT = new CoffeeMaker();
		Recipe r1 = new Recipe();
		Recipe r2 = new Recipe();
		Recipe r3 = new Recipe();
		Recipe r4 = new Recipe();
		r1.setName("R1");
		r2.setName("R2");
		r3.setName("R3");
		r4.setName("R4");
		CuT.addRecipe(r1);
		CuT.addRecipe(r2);
		CuT.addRecipe(r3);
		assertTrue(CuT.addRecipe(r4));
	}
	
	@Test
	public void testAddTooManyRecipes() {
		CoffeeMaker CuT = new CoffeeMaker();
		Recipe r1 = new Recipe();
		Recipe r2 = new Recipe();
		Recipe r3 = new Recipe();
		Recipe r4 = new Recipe();
		Recipe r5 = new Recipe();
		r1.setName("R1");
		r2.setName("R2");
		r3.setName("R3");
		r4.setName("R4");
		r5.setName("R5");
		CuT.addRecipe(r1);
		CuT.addRecipe(r2);
		CuT.addRecipe(r3);
		CuT.addRecipe(r4);
		assertFalse(CuT.addRecipe(r5));
	}
	
	@Test
	public void deleteNothingTest() {
		CoffeeMaker CuT = new CoffeeMaker();
		assertEquals(null,CuT.deleteRecipe(0));
	}
	
	@Test
	public void deleteNormalTest() {
		CoffeeMaker CuT = new CoffeeMaker();
		Recipe r1 = new Recipe();
		r1.setName("R1");
		CuT.addRecipe(r1);
		assertEquals("R1",CuT.deleteRecipe(0));
	}
	
	@Test
	public void deleteFullyResetsTest() {
		CoffeeMaker CuT = new CoffeeMaker();
		Recipe r1 = new Recipe();
		r1.setName("R1");
		CuT.addRecipe(r1);
		CuT.deleteRecipe(0);
		CuT.addRecipe(r1);
		assertEquals("R1",CuT.deleteRecipe(0));
		
	}
	
	@Test
	public void rightRecipeReplacedTest() {
		CoffeeMaker CuT = new CoffeeMaker();
		Recipe r1 = new Recipe();
		r1.setName("R1");
		CuT.addRecipe(r1);
		Recipe r2 = new Recipe();
		r2.setName("R2");
		assertEquals("R1",CuT.editRecipe(0, r2));
	}
	
	@Test
	public void newRecipeCorrectTest() {
		CoffeeMaker CuT = new CoffeeMaker();
		Recipe r1 = new Recipe();
		r1.setName("R1");
		CuT.addRecipe(r1);
		Recipe r2 = new Recipe();
		r2.setName("R2");
		CuT.editRecipe(0, r2);
		assertEquals("R2",CuT.getRecipes()[0].getName());
	}
	
	@Test
	public void testNoRecipe() {
		CoffeeMaker CuT = new CoffeeMaker();
		Recipe r1 = new Recipe();
		r1.setName("R1");
		assertEquals(null,CuT.editRecipe(0, r1));
	}
	
	@Test
	public void addInventoryNormalTest() throws InventoryException {
		CoffeeMaker CuT = new CoffeeMaker();
		CuT.addInventory("15", "1", "1000", "1");
	}
	
	@Test
	public void addInventoryNegativeTest() {
		CoffeeMaker CuT = new CoffeeMaker();
		try {
			CuT.addInventory("15", "-1", "1000", "1");
			assertTrue(false);
		} catch (InventoryException e) {
			;
		}
	}
	
	@Test
	public void addInventoryText() {
		CoffeeMaker CuT = new CoffeeMaker();
		try {
			CuT.addInventory("a", "1", "1000", "1");
			assertTrue(false);
		} catch (InventoryException e) {
			;
		}
	}
	
	@Test
	public void checkInventoryTest() {
		CoffeeMaker CuT = new CoffeeMaker();
		CuT.checkInventory();
	}
	
	@Test
	public void buyNothingTest() {
		CoffeeMaker CuT = new CoffeeMaker();
		assertEquals(15,CuT.makeCoffee(0, 15));	
	}
	
	@Test
	public void buyNormalCoffeeTest() throws RecipeException {
		CoffeeMaker CuT = new CoffeeMaker();
		Recipe r1 = new Recipe();
		r1.setAmtChocolate("10");
		r1.setAmtCoffee("10");
		r1.setAmtMilk("10");
		r1.setAmtSugar("10");
		r1.setName("R1");
		CuT.addRecipe(r1);
		r1.setPrice("10");
		assertEquals(5,CuT.makeCoffee(0, 15));
		
	}
	
	@Test
	public void buyInvalidCoffeeTest() {
		CoffeeMaker CuT = new CoffeeMaker();
		assertEquals(15,CuT.makeCoffee(-1, 15));
	}
	
	@Test
	public void dontHaveEnoughIngredientsTest() throws RecipeException {
		CoffeeMaker CuT = new CoffeeMaker();
		Recipe r1 = new Recipe();
		r1.setAmtChocolate("16");
		r1.setAmtCoffee("16");
		r1.setAmtMilk("16");
		r1.setAmtSugar("16");
		r1.setName("R1");
		CuT.addRecipe(r1);
		r1.setPrice("10");
		assertEquals(15,CuT.makeCoffee(0, 15));
		
	}
	
	@Test
	public void buyExpensiveCoffeeTest() throws RecipeException {
		CoffeeMaker CuT = new CoffeeMaker();
		Recipe r1 = new Recipe();
		r1.setAmtChocolate("10");
		r1.setAmtCoffee("10");
		r1.setAmtMilk("10");
		r1.setAmtSugar("10");
		r1.setName("R1");
		CuT.addRecipe(r1);
		r1.setPrice("16");
		assertEquals(15,CuT.makeCoffee(0, 15));
		
	}
}
