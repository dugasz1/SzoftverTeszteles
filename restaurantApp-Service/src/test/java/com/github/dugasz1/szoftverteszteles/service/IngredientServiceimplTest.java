package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.NotFoundException;
import com.github.dugasz1.szoftverteszteles.core.model.*;
import com.github.dugasz1.szoftverteszteles.service.dao.IngredientDAO;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import static org.testng.Assert.*;

public class IngredientServiceImplTest {
    private IngredientServiceImpl ingredientServiceImpl;

    @Before
    public void setUp() throws Exception {
        IngredientDAO ingredientDAO = EasyMock.createNiceMock(IngredientDAO.class);
        Nutritions nutritions = new Nutritions(2.2f,3.3f,4.4f,5.5f,6.6f);
        IngredientItem ingredientItem = new IngredientItem(1,"test",nutritions,"test");
        EasyMock.expect(ingredientDAO.getIngredientItem(1)).andReturn(ingredientItem);
        EasyMock.expect(ingredientDAO.updateIngredientItem(1)).andReturn(false);
        EasyMock.expect(ingredientDAO.updateIngredientItem(ingredientItem)).andReturn(true);
        EasyMock.expect(ingredientDAO.deleteIngredientItem(2)).andThrow(new NotFoundException());
        EasyMock.expect(ingredientDAO.deleteIngredientItem(1)).andReturn(true);
        EasyMock.expect(ingredientDAO.deleteIngredientItem(ingredientItem)).andReturn(true);
        EasyMock.replay(ingredientDAO);
        ingredientServiceImpl = new IngredientServiceImpl(ingredientDAO);
    }

    @Test
    public void testGetIngredientItem() throws Exception {
        Nutritions nutritions = new Nutritions(2.2f,3.3f,4.4f,5.5f,6.6f);
        IngredientItem ingredientItem = new IngredientItem(1,"test",nutritions,"test");
        assertEquals(ingredientServiceImpl.getIngredientItem(1),ingredientItem);
    }

    @Test
    public void testUpdateIngredientItem() throws Exception {
        assertEquals(ingredientServiceImpl.updateIngredientItem(1),false);
    }

    @Test
    public void testUpdateIngredientItem1() throws Exception {
        Nutritions nutritions = new Nutritions(2.2f,3.3f,4.4f,5.5f,6.6f);
        IngredientItem ingredientItem = new IngredientItem(1,"test",nutritions,"test");
        assertTrue(ingredientServiceImpl.updateIngredientItem(ingredientItem) == true);
    }

    @Test(expected = NotFoundException.class)
    public void testDeleteIngredientItem() throws Exception {
        ingredientServiceImpl.deleteIngredientItem(2);

    }
    @Test
    public void testDeleteIngredientItem2() throws Exception{
        assertTrue(ingredientServiceImpl.deleteIngredientItem(1)== true);
    }

    @Test
    public void testDeleteIngredientItem1() throws Exception {
        Nutritions nutritions = new Nutritions(2.2f,3.3f,4.4f,5.5f,6.6f);
        IngredientItem ingredientItem = new IngredientItem(1,"test",nutritions,"test");
        assertEquals(ingredientServiceImpl.deleteIngredientItem(ingredientItem),true);
    }

}