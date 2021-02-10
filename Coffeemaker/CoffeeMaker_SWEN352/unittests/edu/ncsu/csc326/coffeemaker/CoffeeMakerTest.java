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
	public void deleteFullyResets() {
		CoffeeMaker CuT = new CoffeeMaker();
		Recipe r1 = new Recipe();
		r1.setName("R1");
		CuT.addRecipe(r1);
		CuT.deleteRecipe(0);
		CuT.addRecipe(r1);
		assertEquals("R1",CuT.deleteRecipe(0));
		
	}
	
	@Test
	public void rightRecipeReplaced() {
		CoffeeMaker CuT = new CoffeeMaker();
		Recipe r1 = new Recipe();
		r1.setName("R1");
		CuT.addRecipe(r1);
		Recipe r2 = new Recipe();
		r2.setName("R2");
		assertEquals("R1",CuT.editRecipe(0, r2));
	}
	
	@Test
	public void newRecipeCorrect() {
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
	public void addInventoryNormal() throws InventoryException {
		CoffeeMaker CuT = new CoffeeMaker();
		CuT.addInventory("15", "1", "1000", "1");
	}
	
	@Test
	public void addInventoryNegative() {
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
	
}
