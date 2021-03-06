package edu.ncsu.csc326.coffeemaker;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import junit.framework.TestCase;

public class RecipeTest extends TestCase {
	private Recipe CuT;

	protected void setUp() throws Exception {
		CuT = new Recipe();
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void testGetAmtChocolate() {
		int amtChocolate = CuT.getAmtChocolate();
		assertEquals(0, amtChocolate);
	}
	
	@Test
	public void testSetAmtChocolatePositiveInteger() throws RecipeException{
		
		CuT.setAmtChocolate("1");
		assertEquals(1, CuT.getAmtChocolate());
	}
	
	@Test
	public void testSetAmtChocolateZero() throws RecipeException{
		
		CuT.setAmtChocolate("0");
		assertEquals(0, CuT.getAmtChocolate());
	}
	
	@Test
	public void testSetAmtChocolateNegativeInteger() throws RecipeException{
		
		try {
		CuT.setAmtChocolate("-1");
		}
		catch(RecipeException ie) {
			;
		}
		assertEquals(0, CuT.getAmtChocolate());
	}
	
	@Test
	public void testSetAmtChocolateRandomString() throws RecipeException{
		
		try {
			CuT.setAmtChocolate("fdasjkl;");
		}
		catch(RecipeException ie) {
			;
		}
		assertEquals(0, CuT.getAmtChocolate());
	}
	
	@Test
	public void testgetAmtCoffee() {
		
		int amtCoffee = CuT.getAmtCoffee();
		assertEquals(0, amtCoffee);
	}
	
	@Test
	public void testSetAmtCoffeePositiveInteger() throws RecipeException{
		
		CuT.setAmtCoffee("1");
		assertEquals(1, CuT.getAmtCoffee());
	}
	
	@Test
	public void testSetAmtCoffeeZero() throws RecipeException{
		
		CuT.setAmtCoffee("0");
		assertEquals(0, CuT.getAmtCoffee());
	}
	@Test
	public void testSetAmtCoffeeNegativeInteger() throws RecipeException{
		
		try {
		CuT.setAmtCoffee("-1");
		}
		catch (RecipeException ie) {
			;
		}
		assertEquals(0, CuT.getAmtCoffee());
	}
	
	@Test
	public void testSetAmtCoffeeRandomString() throws RecipeException{
		
		try {
		CuT.setAmtCoffee("fdasjkl;");
		}
		catch (RecipeException ie) {
			;
		}
		assertEquals(0, CuT.getAmtCoffee());
	}
	
	@Test
	public void testGetAmtMilk() {
		
		int amtMilk = CuT.getAmtMilk();
		assertEquals(0, amtMilk);
	}
	
	@Test
	public void testSetAmtMilkPositiveInteger() throws RecipeException{
		
		CuT.setAmtMilk("1");
		assertEquals(1, CuT.getAmtMilk());
	}
	
	@Test
	public void testSetAmtMilkZero() throws RecipeException{
		
		CuT.setAmtMilk("0");
		assertEquals(0, CuT.getAmtMilk());
	}
	
	@Test
	public void testSetAmtMilkNegativeInteger() throws RecipeException{
		
		try {
		CuT.setAmtMilk("-1");
		}
		catch (RecipeException ie) {
			;
		}
		assertEquals(0, CuT.getAmtMilk());
	}
	
	@Test
	public void testSetAmtMilkRandomString() throws RecipeException{
		
		try {
		CuT.setAmtMilk("fdasjkl;");
		}
		catch (RecipeException ie) {
			;
		}
		assertEquals(0, CuT.getAmtMilk());
	}
	
	@Test
	public void testGetAmtSugar() {
		
		int amtSugar = CuT.getAmtSugar();
		assertEquals(0, amtSugar);
	}
	
	@Test
	public void testSetAmtSugarPositiveInteger() throws RecipeException{
		
		CuT.setAmtSugar("1");
		assertEquals(1, CuT.getAmtSugar());
	}
	
	@Test
	public void testSetAmtSugarZero() throws RecipeException{
		
		CuT.setAmtSugar("0");
		assertEquals(0, CuT.getAmtSugar());
	}
	
	@Test
	public void testSetAmtSugarNegativeInteger() throws RecipeException{
		
		try {
		CuT.setAmtSugar("-1");
		}
		catch (RecipeException ie) {
			;
		}
		assertEquals(0, CuT.getAmtSugar());
	}
	
	@Test
	public void testSetAmtSugarRandomString() throws RecipeException{
		
		try {
		CuT.setAmtSugar("fdasjkl;");
		}
		catch (RecipeException ie) {
			;
		}
		assertEquals(0, CuT.getAmtSugar());
	}
	
	@Test
	public void testGetName() {
		
		String name = CuT.getName();
		assertEquals("", name);
	}
	
	@Test
	public void testSetName() {
		
		CuT.setName("Latte");
		assertEquals("Latte", CuT.getName());
	}
	
	@Test
	public void testSetNameBlank() {
		
		CuT.setName("Initial");
		CuT.setName("");
		assertEquals("Initial", CuT.getName());
	}
	@Test
	public void testSetNameNull() {
		
		CuT.setName(null);
		assertEquals("", CuT.getName());
	}
	
	@Test
	public void testGetPrice() {
		
		int price = CuT.getPrice();
		assertEquals(0, price);
	}
	
	@Test
	public void testSetPricePositiveInteger() {
		
		try {
			CuT.setPrice("1");
		}
		catch(RecipeException ie) {
			;
		}
		assertEquals(1, CuT.getPrice());
	}
	
	@Test
	public void testSetPriceZero() {
		
		try {
			CuT.setPrice("0");
		}
		catch(RecipeException ie) {
			;
		}
		assertEquals(0, CuT.getPrice());
	}
	
	
	@Test
	public void testSetPriceNegativeInteger() {
		
		try {
			CuT.setPrice("-1");
		}
		catch(RecipeException ie) {
			;
		}
		assertEquals(0, CuT.getPrice());
	}
	
	@Test
	public void testSetPriceRandomString() {
		
		try {
			CuT.setPrice("fdasjkl;");
		}
		catch(RecipeException ie) {
			;
		}
		assertEquals(0, CuT.getPrice());
	}
	
	@Test
	public void testToString() {
		
		assertEquals("", CuT.toString());
	}
	
	@Test
	public void testHashCode() {
		
		assertEquals(31, CuT.hashCode());
	}
	
	@Test
	public void testHashCodeNameChange() {
		
		CuT.setName("A");
		assertEquals(96, CuT.hashCode());
	}
	
	@Test
	public void testEqualsSelf() {
		
		assertEquals(true, CuT.equals(CuT));
	}
	
	@Test
	public void testEqualsNull() {
		
		assertEquals(false, CuT.equals(null));
	}
	
	@Test
	public void testEqualsInt() {
		
		assertEquals(false, CuT.equals(1));
	}
	
	@Test
	public void testEqualsDifferentName(){
		
		Recipe differentName = new Recipe();
		differentName.setName("other");
		assertEquals(false, CuT.equals(differentName));
	}
	
	@Test
	public void testEquals() {
		
		Recipe other = new Recipe();
		assertEquals(true, CuT.equals(other));
	}
}
