package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.model.*;
import com.github.dugasz1.szoftverteszteles.service.dao.RecipeDAO;
import org.easymock.EasyMock;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class RecipeServiceImplTest {
    private RecipeServiceImpl recipeService;

    @Before
    public void setUp() throws Exception {
        RecipeDAO recipeDAO = EasyMock.createNiceMock(RecipeDAO.class);

        Nutritions nutritions = new Nutritions(2.2f,3.3f,4.4f,5.5f,6.6f);
        IngredientItem ingredientItem = new IngredientItem(1,"test",nutritions,"test");
        Category category = new Category(1,"testCategory");
        Ingredient ingredient = new Ingredient(ingredientItem,2.0f);
        Collection collection= new ArrayList<Ingredient>();
        collection.add(ingredient);
        Recipe recipe = new Recipe(1, category, collection);
        EasyMock.expect(recipeDAO.getRecipe(1)).andReturn(recipe);
        EasyMock.expect(recipeDAO.updateRecipe(1)).andReturn(true);
        EasyMock.expect(recipeDAO.updateRecipe(recipe)).andReturn(true);
        EasyMock.expect(recipeDAO.deleteRecipe(1)).andReturn(true);
        EasyMock.expect(recipeDAO.deleteRecipe(recipe)).andReturn(true);
        EasyMock.replay(recipeDAO);
        recipeService = new RecipeServiceImpl(recipeDAO);
    }
    @Test
    public void testGetRecipe() throws Exception{
        Nutritions nutritions = new Nutritions(2.2f,3.3f,4.4f,5.5f,6.6f);
        IngredientItem ingredientItem = new IngredientItem(1,"test",nutritions,"test");
        Category category = new Category(1,"testCategory");
        Ingredient ingredient = new Ingredient(ingredientItem,2.0f);
        Collection collection= new ArrayList<Ingredient>();
        collection.add(ingredient);
        Recipe recipe = new Recipe(1, category, collection);
        assertEquals(recipeService.getRecipe(1),recipe);
    }
    @Test
    public void testupdateIdRecipe() throws Exception{
        assertEquals(recipeService.updateRecipe(1), true);

    }
    @Test
    public void testupdateRecipeRecipe() throws Exception{
        Nutritions nutritions = new Nutritions(2.2f,3.3f,4.4f,5.5f,6.6f);
        IngredientItem ingredientItem = new IngredientItem(1,"test",nutritions,"test");
        Category category = new Category(1,"testCategory");
        Ingredient ingredient = new Ingredient(ingredientItem,2.0f);
        Collection collection= new ArrayList<Ingredient>();
        collection.add(ingredient);
        Recipe recipe = new Recipe(1, category, collection);
        assertEquals(recipeService.updateRecipe(recipe), true);

    }
    @Test
    public void testdeleteIdRecipe() throws Exception{
        assertEquals(recipeService.deleteRecipe(1), true);
    }
    @Test
    public void testdeleteRecipeRecipe() throws Exception{
        Nutritions nutritions = new Nutritions(2.2f,3.3f,4.4f,5.5f,6.6f);
        IngredientItem ingredientItem = new IngredientItem(1,"test",nutritions,"test");
        Category category = new Category(1,"testCategory");
        Ingredient ingredient = new Ingredient(ingredientItem,2.0f);
        Collection collection= new ArrayList<Ingredient>();
        collection.add(ingredient);
        Recipe recipe = new Recipe(1, category, collection);
        assertEquals(recipeService.deleteRecipe(recipe), true);
    }
}
