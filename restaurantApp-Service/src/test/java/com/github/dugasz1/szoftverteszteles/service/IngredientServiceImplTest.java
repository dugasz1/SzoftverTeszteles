package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.model.Ingredient;
import com.github.dugasz1.szoftverteszteles.core.model.IngredientItem;
import com.github.dugasz1.szoftverteszteles.core.model.Nutritions;
import com.github.dugasz1.szoftverteszteles.service.dao.IngredientDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.NotFoundException;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.testng.Assert.assertEquals;

public class IngredientServiceImplTest {
    private IngredientServiceImpl ingredientServiceImpl;

    @Before
    public void setUp() throws Exception {
        IngredientDAO ingredientDAO = EasyMock.createNiceMock(IngredientDAO.class);
        Nutritions nutritions = new Nutritions(2.2f,3.3f,4.4f,5.5f,6.6f);
        IngredientItem ingredientItem = new IngredientItem(1,"test",nutritions,"test");
        Ingredient ingredient = new Ingredient(ingredientItem, 2f);
        EasyMock.expect(ingredientDAO.getIngredient(1)).andReturn(ingredient);
        EasyMock.replay(ingredientDAO);
        ingredientServiceImpl = new IngredientServiceImpl(ingredientDAO);
    }

    @Test
    public void testGetIngredient() throws Exception {
        Nutritions nutritions = new Nutritions(2.2f,3.3f,4.4f,5.5f,6.6f);
        IngredientItem ingredientItem = new IngredientItem(1,"test",nutritions,"test");
        Ingredient ingredient = new Ingredient(ingredientItem, 2f);
        assertEquals(ingredientServiceImpl.getIngredient(1), ingredient);
    }

    @Test
    public void getIngredientCollectionByRecipe() throws Exception {
        Collection<Ingredient> ingredients = new ArrayList<>();
        Nutritions nutritions = new Nutritions(2.2f,3.3f,4.4f,5.5f,6.6f);
        IngredientItem ingredientItem = new IngredientItem(1,"test",nutritions,"test");
        Ingredient ingredient = new Ingredient(ingredientItem, 2f);

        assertEquals(ingredientServiceImpl.getIngredientCollectionByRecipe(1), null);
    }

}
