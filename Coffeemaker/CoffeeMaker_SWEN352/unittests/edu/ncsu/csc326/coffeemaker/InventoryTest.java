package edu.ncsu.csc326.coffeemaker;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import junit.framework.TestCase;

public class InventoryTest extends TestCase {
	private Inventory CuT = new Inventory();

	protected void setUp() throws Exception {
		this.CuT = new Inventory();
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void testSetAndGetCoffee() {
		this.CuT.setCoffee(100);
		assertEquals(100,this.CuT.getCoffee());
	}
	
	@Test
	public void testAddCoffeeNormal() throws InventoryException {
		this.CuT.setCoffee(0);
		this.CuT.addCoffee("1");
		assertEquals(1,this.CuT.getCoffee());
	}
	
	@Test
	public void testAddCoffeeNegative() throws InventoryException {
		this.CuT.setCoffee(0);
		try {
			this.CuT.addCoffee("-15");
		}
		catch(InventoryException ie) {
			;
		}
		assertEquals(0,this.CuT.getCoffee());
	}
	
	@Test
	public void testAddCoffeeNonNumeric() {
		this.CuT.setCoffee(0);
		try {
			this.CuT.addCoffee("beebop");
		}
		catch(InventoryException ie) {
			;
		}
		assertEquals(0,this.CuT.getCoffee());
	}
	
	@Test
	public void testSetAndGetChocolate() {
		this.CuT.setChocolate(100);
		assertEquals(100,this.CuT.getChocolate());
	}
	
	@Test
	public void testAddChocolateNormal() throws InventoryException {
		this.CuT.setChocolate(0);
		this.CuT.addChocolate("1");
		assertEquals(1,this.CuT.getChocolate());
	}
	
	@Test
	public void testAddChocolateNegative() throws InventoryException {
		this.CuT.setChocolate(0);
		try {
			this.CuT.addChocolate("-15");
		}
		catch(InventoryException ie) {
			;
		}
		assertEquals(0,this.CuT.getChocolate());
	}
	
	@Test
	public void testAddChocolateNonNumeric() {
		this.CuT.setChocolate(0);
		try {
			this.CuT.addChocolate("beebop");
		}
		catch(InventoryException ie) {
			;
		}
		assertEquals(0,this.CuT.getChocolate());
	}
	
	@Test
	public void testSetAndGetMilk() {
		this.CuT.setMilk(100);
		assertEquals(100,this.CuT.getMilk());
	}
	
	@Test
	public void testAddMilkNormal() throws InventoryException {
		this.CuT.setMilk(0);
		this.CuT.addMilk("1");
		assertEquals(1,this.CuT.getMilk());
	}
	
	@Test
	public void testAddMilkNegative() throws InventoryException {
		this.CuT.setMilk(0);
		try {
			this.CuT.addMilk("-15");
		}
		catch(InventoryException ie) {
			;
		}
		assertEquals(0,this.CuT.getMilk());
	}
	
	@Test
	public void testAddMilkNonNumeric() {
		this.CuT.setMilk(0);
		try {
			this.CuT.addMilk("beebop");
		}
		catch(InventoryException ie) {
			;
		}
		assertEquals(0,this.CuT.getMilk());
	}
	
	
	
	@Test
	public void testSetAndGetSugar() {
		this.CuT.setSugar(100);
		assertEquals(100,this.CuT.getSugar());
	}
	
	@Test
	public void testAddSugarNormal() throws InventoryException {
		this.CuT.setSugar(0);
		this.CuT.addSugar("1");
		assertEquals(1,this.CuT.getSugar());
	}
	
	@Test
	public void testAddSugarNegative() throws InventoryException {
		this.CuT.setSugar(0);
		try {
			this.CuT.addSugar("-15");
		}
		catch(InventoryException ie) {
			;
		}
		assertEquals(0,this.CuT.getSugar());
	}
	
	@Test
	public void testAddSugarNonNumeric() {
		this.CuT.setSugar(0);
		try {
			this.CuT.addSugar("beebop");
		}
		catch(InventoryException ie) {
			;
		}
		assertEquals(0,this.CuT.getSugar());
	}
	
	@Test
	public void testEmptyRecipe() {
		Recipe recipe = new Recipe();
		assertTrue( this.CuT.enoughIngredients(recipe));
	}
	
	@Test
	public void testHeavyRecipe() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtChocolate("100");
		recipe.setAmtCoffee("100");
		recipe.setAmtMilk("100");
		recipe.setAmtSugar("100");
		assertFalse( this.CuT.enoughIngredients(recipe));
	}
	
	@Test
	public void testEvenRecipe() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtChocolate("15");
		recipe.setAmtCoffee("15");
		recipe.setAmtMilk("15");
		recipe.setAmtSugar("15");
		assertTrue( this.CuT.enoughIngredients(recipe));
	}
	
	@Test
	public void testChocolateOverRecipe() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtChocolate("100");
		recipe.setAmtCoffee("15");
		recipe.setAmtMilk("15");
		recipe.setAmtSugar("15");
		assertFalse( this.CuT.enoughIngredients(recipe));
	}
	
	@Test
	public void testCoffeeOverRecipe() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtChocolate("15");
		recipe.setAmtCoffee("100");
		recipe.setAmtMilk("15");
		recipe.setAmtSugar("15");
		assertFalse( this.CuT.enoughIngredients(recipe));
	}
	
	@Test
	public void testMilkOverRecipe() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtChocolate("15");
		recipe.setAmtCoffee("15");
		recipe.setAmtMilk("100");
		recipe.setAmtSugar("15");
		assertFalse( this.CuT.enoughIngredients(recipe));
	}
	
	@Test
	public void testSugarOverRecipe() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtChocolate("15");
		recipe.setAmtCoffee("15");
		recipe.setAmtMilk("15");
		recipe.setAmtSugar("100");
		assertFalse( this.CuT.enoughIngredients(recipe));
	}
	
	@Test
	public void testSugarAndChocolateOverRecipe() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtChocolate("100");
		recipe.setAmtCoffee("15");
		recipe.setAmtMilk("15");
		recipe.setAmtSugar("100");
		assertFalse( this.CuT.enoughIngredients(recipe));
	}
	
	@Test
	public void testSugarAndMilkOverRecipe() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtChocolate("15");
		recipe.setAmtCoffee("15");
		recipe.setAmtMilk("100");
		recipe.setAmtSugar("100");
		assertFalse( this.CuT.enoughIngredients(recipe));
	}
	
	@Test
	public void testSugarAndCoffeeAndMilkOverRecipe() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtChocolate("15");
		recipe.setAmtCoffee("100");
		recipe.setAmtMilk("100");
		recipe.setAmtSugar("100");
		assertFalse( this.CuT.enoughIngredients(recipe));
	}
	
	@Test
	public void testSugarAndCoffeeOverRecipe() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtChocolate("15");
		recipe.setAmtCoffee("100");
		recipe.setAmtMilk("15");
		recipe.setAmtSugar("100");
		assertFalse( this.CuT.enoughIngredients(recipe));
	}
	
	@Test
	public void testSubtractNormal() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtChocolate("15");
		recipe.setAmtCoffee("15");
		recipe.setAmtMilk("15");
		recipe.setAmtSugar("15");
		assertTrue( this.CuT.useIngredients(recipe));
	}
	
	@Test
	public void testSubtractNotEnoughChocolate() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtChocolate("25");
		recipe.setAmtCoffee("15");
		recipe.setAmtMilk("15");
		recipe.setAmtSugar("15");
		assertFalse( this.CuT.useIngredients(recipe));
	}
	
	@Test
	public void testSubtractNotEnoughCoffee() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtChocolate("15");
		recipe.setAmtCoffee("25");
		recipe.setAmtMilk("15");
		recipe.setAmtSugar("15");
		assertFalse( this.CuT.useIngredients(recipe));
	}
	
	@Test
	public void testSubtractNotEnoughMilk() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtChocolate("15");
		recipe.setAmtCoffee("15");
		recipe.setAmtMilk("25");
		recipe.setAmtSugar("15");
		assertFalse( this.CuT.useIngredients(recipe));
	}
	
	@Test
	public void testSubtractNotEnoughSugar() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtChocolate("15");
		recipe.setAmtCoffee("15");
		recipe.setAmtMilk("15");
		recipe.setAmtSugar("25");
		assertFalse( this.CuT.useIngredients(recipe));
	}
	
	@Test
	public void testRecipeSubtractsChocolateRight() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtChocolate("10");
		recipe.setAmtCoffee("5");
		recipe.setAmtMilk("5");
		recipe.setAmtSugar("5");
		this.CuT.useIngredients(recipe);
		assertEquals(5,this.CuT.getChocolate());
	}
	
	@Test
	public void testRecipeSubtractsCoffeeRight() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtChocolate("5");
		recipe.setAmtCoffee("10");
		recipe.setAmtMilk("5");
		recipe.setAmtSugar("5");
		this.CuT.useIngredients(recipe);
		assertEquals(5,this.CuT.getCoffee());
	}
	
	@Test
	public void testRecipeSubtractsMilkRight() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtChocolate("5");
		recipe.setAmtCoffee("5");
		recipe.setAmtMilk("10");
		recipe.setAmtSugar("5");
		this.CuT.useIngredients(recipe);
		assertEquals(5,this.CuT.getMilk());
	}
	
	@Test
	public void testRecipeSubtractsSugarRight() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtChocolate("5");
		recipe.setAmtCoffee("5");
		recipe.setAmtMilk("5");
		recipe.setAmtSugar("10");
		this.CuT.useIngredients(recipe);
		assertEquals(5,this.CuT.getSugar());
	}
	
	@Test
	public void testHugeNumbersDontCount() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtChocolate("15");
		recipe.setAmtCoffee("15");
		recipe.setAmtMilk("15");
		try {
			recipe.setAmtSugar("1000000000000000000");
		}
		catch(RecipeException re) {
			;
		}
		assertTrue( this.CuT.enoughIngredients(recipe));
	}
	
	
	@Test
	public void testSubtractingZeroDoesntChangeCoffee() {
		this.CuT.useIngredients(new Recipe());
		assertEquals(15,this.CuT.getCoffee());
	}
	
	@Test
	public void testSubtractingZeroDoesntChangeSugar() {
		this.CuT.useIngredients(new Recipe());
		assertEquals(15,this.CuT.getSugar());
	}
	
	@Test
	public void testSubtractingZeroDoesntChangeMilk() {
		this.CuT.useIngredients(new Recipe());
		assertEquals(15,this.CuT.getMilk());
	}
	
	@Test
	public void testSubtractingZeroDoesntChangeChocolate() {
		this.CuT.useIngredients(new Recipe());
		assertEquals(15,this.CuT.getChocolate());
	}
	
	@Test
	public void testHandleHugeMilk() throws InventoryException {
		try {
			this.CuT.addMilk("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
		}
		catch(InventoryException ie) {
			;
		}
	}
	
	@Test
	public void testHandleHugeSugar() throws InventoryException {
		try {
			this.CuT.addSugar("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
		}
		catch(InventoryException ie) {
			;
		}
	}
	
	@Test
	public void testHandleHugeCoffee() throws InventoryException {
		try {
			this.CuT.addCoffee("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
		}
		catch(InventoryException ie) {
			;
		}
	}
	
	@Test
	public void testHandleHugeChocolate() throws InventoryException {
		try {
			this.CuT.addChocolate("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
		}
		catch(InventoryException ie) {
			;
		}
	}
	
	@Test
	public void testHandleLargeRecipeMilk() throws RecipeException, InventoryException {
		this.CuT.addMilk("1000000");
		Recipe bigRecipe = new Recipe();
		bigRecipe.setAmtMilk("100000");
		assertTrue(this.CuT.enoughIngredients(bigRecipe));
	}
	
	@Test
	public void testHandleLargeRecipeSugar() throws RecipeException, InventoryException {
		this.CuT.addSugar("1000000");
		Recipe bigRecipe = new Recipe();
		bigRecipe.setAmtSugar("100000");
		assertTrue(this.CuT.enoughIngredients(bigRecipe));
	}
	
	@Test
	public void testHandleLargeRecipeChocolate() throws RecipeException, InventoryException {
		this.CuT.addChocolate("1000000");
		Recipe bigRecipe = new Recipe();
		bigRecipe.setAmtChocolate("100000");
		assertTrue(this.CuT.enoughIngredients(bigRecipe));
	}
	
	@Test
	public void testHandleLargeRecipeCoffee() throws RecipeException, InventoryException {
		this.CuT.addCoffee("1000000");
		Recipe bigRecipe = new Recipe();
		bigRecipe.setAmtCoffee("100000");
		assertTrue(this.CuT.enoughIngredients(bigRecipe));
	}
	
	
	
	
	@Test public void testToString() {
		this.CuT.toString();
	}

	

}
