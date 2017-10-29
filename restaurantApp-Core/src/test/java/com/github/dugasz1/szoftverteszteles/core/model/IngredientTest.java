package com.github.dugasz1.szoftverteszteles.core.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IngredientTest {

    private Ingredient testIngredient = null;

    @Before
    public void setUp() throws Exception {
        testIngredient = new Ingredient(new IngredientItem(1, "testingredientitem",
                new Nutritions(1.1f,2.2f,3.3f,4.4f,5.5f), "testunit"), 1.5f);
    }

    @Test
    public void getQuantity() throws Exception {
        assertEquals((long) testIngredient.getQuantity(),(long) 1.5f);
    }

    @Test
    public void getIngredientItem() throws Exception {
        IngredientItem localTestIngredientItem = new IngredientItem(1, "testingredientitem",
                new Nutritions(1.1f,2.2f,3.3f,4.4f,5.5f), "testunit");

        assertEquals(testIngredient.getIngredientItem(), localTestIngredientItem);
    }

    @Test
    public void setIngredientItem() throws Exception {
        Ingredient localIngredient = new Ingredient(new IngredientItem(2, "testingredientitem",
                new Nutritions(1.1f,2.2f,3.3f,4.4f,5.5f), "testunit"), 1.5f);

        localIngredient.setIngredientItem(new IngredientItem(3, "newtestingredientitem",
                new Nutritions(10.1f,20.2f,30.3f,40.4f,50.5f), "newtestunit"));


        Ingredient newLocalIngredient = new Ingredient(new IngredientItem(3, "newtestingredientitem",
                new Nutritions(10.1f,20.2f,30.3f,40.4f,50.5f), "newtestunit"), 1.5f);

        assertEquals(localIngredient.getIngredientItem(), newLocalIngredient);
    }

    @Test
    public void setQuantity() throws Exception {
        Ingredient localIngredient = new Ingredient(new IngredientItem(2, "testingredientitem",
                new Nutritions(1.1f,2.2f,3.3f,4.4f,5.5f), "testunit"), 1.5f);

        localIngredient.setQuantity(20.5f);

        assertEquals((long) localIngredient.getQuantity(), (long) 20.5f);
    }

    @Test
    public void equals() throws Exception {
        Ingredient sameIngredient = new Ingredient(new IngredientItem(1, "testingredientitem",
                new Nutritions(1.1f,2.2f,3.3f,4.4f,5.5f), "testunit"), 1.5f);

        assertTrue(testIngredient.equals(sameIngredient));
    }

}
