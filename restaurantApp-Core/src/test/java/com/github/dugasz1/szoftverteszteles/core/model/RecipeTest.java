package com.github.dugasz1.szoftverteszteles.core.model;

import org.junit.Before;
import org.junit.Test;

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
}
