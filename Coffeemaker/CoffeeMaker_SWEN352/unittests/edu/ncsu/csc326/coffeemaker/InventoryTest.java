package edu.ncsu.csc326.coffeemaker;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import junit.framework.TestCase;

public class InventoryTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void testSetAndGetChocolate() {
		Inventory CuT = new Inventory();
		CuT.setChocolate(100);
		assertEquals(100,CuT.getChocolate());
	}
	
	@Test
	public void testAddChocolateNormal() throws InventoryException {
		Inventory CuT = new Inventory();
		CuT.setChocolate(0);
		CuT.addChocolate("1");
		assertEquals(1,CuT.getChocolate());
	}
	
	@Test
	public void testAddChocolateNegative() throws InventoryException {
		Inventory CuT = new Inventory();
		CuT.setChocolate(0);
		try {
			CuT.addChocolate("-15");
		}
		catch(InventoryException ie) {
			;
		}
		assertEquals(0,CuT.getChocolate());
	}
	
	@Test
	public void testAddChocolateNonNumeric() {
		Inventory CuT = new Inventory();
		CuT.setChocolate(0);
		try {
			CuT.addChocolate("beebop");
		}
		catch(InventoryException ie) {
			;
		}
		assertEquals(0,CuT.getChocolate());
	}
	
	@Test
	public void testSetAndGetMilk() {
		Inventory CuT = new Inventory();
		CuT.setMilk(100);
		assertEquals(100,CuT.getMilk());
	}
	
	@Test
	public void testAddMilkNormal() throws InventoryException {
		Inventory CuT = new Inventory();
		CuT.setMilk(0);
		CuT.addMilk("1");
		assertEquals(1,CuT.getMilk());
	}
	
	@Test
	public void testAddMilkNegative() throws InventoryException {
		Inventory CuT = new Inventory();
		CuT.setMilk(0);
		try {
			CuT.addMilk("-15");
		}
		catch(InventoryException ie) {
			;
		}
		assertEquals(0,CuT.getMilk());
	}
	
	@Test
	public void testAddMilkNonNumeric() {
		Inventory CuT = new Inventory();
		CuT.setMilk(0);
		try {
			CuT.addMilk("beebop");
		}
		catch(InventoryException ie) {
			;
		}
		assertEquals(0,CuT.getMilk());
	}
	
	
	@Test
	public void testSetAndGetSugar() {
		Inventory CuT = new Inventory();
		CuT.setSugar(100);
		assertEquals(100,CuT.getSugar());
	}
	
	@Test
	public void testAddSugarNormal() throws InventoryException {
		Inventory CuT = new Inventory();
		CuT.setSugar(0);
		CuT.addSugar("1");
		assertEquals(1,CuT.getSugar());
	}
	
	@Test
	public void testAddSugarNegative() throws InventoryException {
		Inventory CuT = new Inventory();
		CuT.setSugar(0);
		try {
			CuT.addSugar("-15");
		}
		catch(InventoryException ie) {
			;
		}
		assertEquals(0,CuT.getSugar());
	}
	
	@Test
	public void testAddSugarNonNumeric() {
		Inventory CuT = new Inventory();
		CuT.setSugar(0);
		try {
			CuT.addSugar("beebop");
		}
		catch(InventoryException ie) {
			;
		}
		assertEquals(0,CuT.getSugar());
	}
	
	@Test
	public void testEmptyRecipe() {
		Recipe recipe = new Recipe();
		Inventory CuT = new Inventory();
		assertTrue( CuT.enoughIngredients(recipe));
	}
	
	@Test
	public void testHeavyRecipe() throws RecipeException {
		Recipe recipe = new Recipe();
		Inventory CuT = new Inventory();
		recipe.setAmtChocolate("100");
		recipe.setAmtCoffee("100");
		recipe.setAmtMilk("100");
		recipe.setAmtSugar("100");
		assertFalse( CuT.enoughIngredients(recipe));
	}
	
	@Test
	public void testEvenRecipe() throws RecipeException {
		Recipe recipe = new Recipe();
		Inventory CuT = new Inventory();
		recipe.setAmtChocolate("15");
		recipe.setAmtCoffee("15");
		recipe.setAmtMilk("15");
		recipe.setAmtSugar("15");
		assertTrue( CuT.enoughIngredients(recipe));
	}
	

}
