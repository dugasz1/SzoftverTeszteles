package com.github.dugasz1.szoftverteszteles.core.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MenuItemTest {
    private MenuItem testMenuItem = null;
    List<Ingredient> testIngredientList = new ArrayList<Ingredient>();

    @Before
    public void setUp() throws Exception {
        testIngredientList.add(new Ingredient(new IngredientItem(1, "testingredientitem",
                new Nutritions(1.1f,2.2f,3.3f,4.4f,5.5f), "testunit"), 1.5f));

        testIngredientList.add(new Ingredient(new IngredientItem(2, "testingredientitem2",
                new Nutritions(11.1f,22.2f,33.3f,44.4f,55.5f), "testunit2"), 11.5f));

        testMenuItem = new MenuItem(1, 1550f, new Recipe(1, new Category(1, "testCategory"), testIngredientList));
    }

    @Test
    public void getId() throws Exception {
        assertEquals(testMenuItem.getId(), 1);
    }

    @Test
    public void getPrice() throws Exception {
        assertEquals((long)testMenuItem.getPrice(), (long) 1550f);
    }

    @Test
    public void getRecipe() throws Exception {
        Recipe localTestRecipe = new Recipe(1, new Category(1, "testCategory"), testIngredientList);

        assertEquals(testMenuItem.getRecipe(), localTestRecipe);
    }

    @Test
    public void setPrice() throws Exception {
        MenuItem localTestMenuItem = new MenuItem(2, 1550f, new Recipe(1, new Category(1, "testCategory"), testIngredientList));
        localTestMenuItem.setPrice(1450f);

        assertEquals((long) localTestMenuItem.getPrice(), (long) 1450f);
    }

    @Test
    public void setRecipe() throws Exception {
        MenuItem localTestMenuItem = new MenuItem(2, 1550f, new Recipe(1, new Category(1, "testCategory"), testIngredientList));
        localTestMenuItem.setRecipe(new Recipe(2, new Category(3, "testCategory2"), testIngredientList));

        MenuItem newLocalTestMenuItem = new MenuItem(2, 1550f, new Recipe(2, new Category(3, "testCategory2"), testIngredientList));
        assertEquals(localTestMenuItem.getRecipe(), newLocalTestMenuItem.getRecipe());
    }

    @Test
    public void equals() throws Exception {
        MenuItem sameMenuItem = new MenuItem(1, 1550f, new Recipe(1, new Category(1, "testCategory"), testIngredientList));
        assertTrue(sameMenuItem.equals(sameMenuItem));
    }


}
