package com.github.dugasz1.szoftverteszteles.core.model;

import com.github.dugasz1.szoftverteszteles.core.exceptions.NoCategoryException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NoIngredientException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashSet;

import static org.junit.Assert.*;

public class RecipeTest {
    private Recipe testRecipe = null;
    private Collection<Ingredient> ingredients = new HashSet<Ingredient>();


    @Before
    public void setUp() throws Exception{
        ingredients.add(new Ingredient ( new IngredientItem(1, "testingredientitem1",
                new Nutritions(0.1f,0.2f,0.3f,0.4f,0.5f), "testunit1"), 1.5f));
        ingredients.add(new Ingredient(new IngredientItem(2, "testingredientitem2",
                        new Nutritions(1.1f,1.2f,1.3f,1.4f,1.5f), "testunit2"), 1.6f));

        testRecipe = new Recipe(1, new Category(1,"testcategory"), ingredients);
    }

    @Test(expected = NoCategoryException.class)
    public void constructorNoCategoryException () throws Exception{
        Recipe recipe = new Recipe(1, null, ingredients);
    }

    @Test(expected = NoIngredientException.class)
    public void constructorNoIngredientException () throws Exception{
        Recipe recipe = new Recipe(1, new Category(1, "a"), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorEmptryIngredients () throws Exception{
        Recipe recipe = new Recipe(1, new Category(1, "a"), new ArrayDeque<Ingredient>());
    }

    @Test
    public void getId() throws Exception{
        assertEquals(testRecipe.getId(),1);
    }

    @Test
    public void getCategory() throws Exception{
        assertEquals(testRecipe.getCategory(), new Category(1,"testcategory"));
    }

    @Test
    public void setCategory() throws Exception{
        Recipe localRecipe = new Recipe(2, new Category(2, "testsetcategory"), ingredients);
        Category localCategory = new Category(1, "localCategory");
        localRecipe.setCategory(localCategory);
        assertEquals(localRecipe.getCategory(), localCategory);
    }

    @Test
    public void getIngredients() throws Exception{
        Collection<Ingredient> localIngredients = new HashSet<Ingredient>();
        localIngredients.add(new Ingredient ( new IngredientItem(1, "localtestingredientitem1",
                new Nutritions(0.1f,0.2f,0.3f,0.4f,0.5f), "localtestunit1"), 1.5f));
        localIngredients.add(new Ingredient(new IngredientItem(2, "localtestingredientitem2",
                new Nutritions(1.1f,1.2f,1.3f,1.4f,1.5f), "localtestunit2"), 1.6f));
        Recipe localRecipe = new Recipe(3, new Category(3,"localCategory"), localIngredients);
        assertEquals(localRecipe.getIngredients(), localIngredients);
    }

    @Test
    public void setIngredients() throws Exception{
        Collection<Ingredient> localIngredients = new HashSet<Ingredient>();
        localIngredients.add(new Ingredient ( new IngredientItem(1, "localtestingredientitem1",
                new Nutritions(0.1f,0.2f,0.3f,0.4f,0.5f), "localtestunit1"), 1.5f));
        localIngredients.add(new Ingredient(new IngredientItem(2, "localtestingredientitem2",
                new Nutritions(1.1f,1.2f,1.3f,1.4f,1.5f), "localtestunit2"), 1.6f));
        testRecipe.setIngredients(localIngredients);
        assertEquals(testRecipe.getIngredients(), localIngredients);
    }

    @Test
    public void notEquals() throws Exception {
        Recipe notSameRecipe = new Recipe(22, new Category(22, "Notsame"), ingredients);
        assertFalse(notSameRecipe.equals(testRecipe));
    }

    @Test
    public void equalsWrongObj() throws Exception {
        User user = new User(1, "teszt");
        assertFalse(testRecipe.equals(user));
    }

    @Test
    public void equalsNull() throws Exception {
        assertFalse(testRecipe.equals(null));
    }

    @Test
    public void equalsSameObject() throws Exception {
        assertTrue(testRecipe.equals(testRecipe));
    }

    @Test
    public void equals() throws Exception{
        Collection<Ingredient> localIngredients = new HashSet<Ingredient>();
        localIngredients.add(new Ingredient ( new IngredientItem(1, "localtestingredientitem1",
                new Nutritions(0.1f,0.2f,0.3f,0.4f,0.5f), "localtestunit1"), 1.5f));
        localIngredients.add(new Ingredient(new IngredientItem(2, "localtestingredientitem2",
                new Nutritions(1.1f,1.2f,1.3f,1.4f,1.5f), "localtestunit2"), 1.6f));

        Recipe localRecipe1 = new Recipe(4, new Category(4, "localCategory"), localIngredients);
        Recipe localRecipe2 = new Recipe(4, new Category(4, "localCategory"), localIngredients);

        assertTrue(localRecipe2.equals(localRecipe1));
    }
}
