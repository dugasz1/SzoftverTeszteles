package com.github.dugasz1.szoftverteszteles.core.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientItemTest {
    private IngredientItem testIngredientItem = null;
    @Before
    public void setUp() throws Exception {
        testIngredientItem = new IngredientItem(1, "testingredientitem",
                new Nutritions(1.1f,2.2f,3.3f,4.4f,5.5f), "testunit");
    }

    @Test
    public void getId() throws Exception {
        assertEquals(testIngredientItem.getId(), 1);
    }

    @Test
    public void getName() throws Exception{
        assertEquals(testIngredientItem.getName(), "testingredientitem");
    }

    @Test
    public void getNutrions() throws Exception {
        assertEquals((long) testIngredientItem.getNutrions().getEnergy(),(long) 1.1f);
        assertEquals((long) testIngredientItem.getNutrions().getFat(),(long) 2.2f);
        assertEquals((long) testIngredientItem.getNutrions().getCarbohydrate(),(long) 3.3f);
        assertEquals((long) testIngredientItem.getNutrions().getProtein(),(long) 4.4f);
        assertEquals((long) testIngredientItem.getNutrions().getSalt(),(long) 5.5f);
    }

    @Test
    public void getUnit() throws Exception {
        assertEquals(testIngredientItem.getUnit(), "testunit");
    }

    @Test
    public void setNutrions() throws Exception {
        IngredientItem localIngredientItem = new IngredientItem(2, "localTingredientItem",
                new Nutritions(1.1f,2.2f,3.3f,4.4f,5.5f), "localTunit");

        localIngredientItem.setNutrions(new Nutritions(10.1f,20.2f,30.3f,40.4f,50.5f));

        assertEquals((long) testIngredientItem.getNutrions().getEnergy(), (long) 10.1f);
        assertEquals((long) testIngredientItem.getNutrions().getFat(),(long) 20.2f);
        assertEquals((long) testIngredientItem.getNutrions().getCarbohydrate(),(long) 30.3f);
        assertEquals((long) testIngredientItem.getNutrions().getProtein(),(long) 40.4f);
        assertEquals((long) testIngredientItem.getNutrions().getSalt(),(long) 50.5f);
    }

    @Test
    public void setName() throws Exception {
        IngredientItem localIngredientItem = new IngredientItem(2, "localTingredientItem",
                new Nutritions(1.1f,2.2f,3.3f,4.4f,5.5f), "localTunit");

        localIngredientItem.setName("renamed");
        assertEquals(localIngredientItem.getName(), "renamed");
    }

    @Test
    public void setUnit() throws Exception {
        IngredientItem localIngredientItem = new IngredientItem(2, "localTingredientItem",
                new Nutritions(1.1f,2.2f,3.3f,4.4f,5.5f), "localTunit");
        
        localIngredientItem.setUnit("renamed");
        assertEquals(localIngredientItem.getUnit(), "renamed");
    }
}
