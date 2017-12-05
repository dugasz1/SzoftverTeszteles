package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.service.exceptions.ExistingProblemException;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.IngredientItemNotFoundException;
import com.github.dugasz1.szoftverteszteles.service.dao.IngredientItemDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.NotFoundException;
import com.github.dugasz1.szoftverteszteles.core.model.*;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import static org.testng.Assert.*;

public class IngredientItemServiceImplTest {
    private IngredientItemServiceImpl ingredientItemServiceImpl;

    @Before
    public void setUp() throws Exception {
        IngredientItemDAO ingredientItemDAO = EasyMock.createNiceMock(IngredientItemDAO.class);
        Nutritions nutritions = new Nutritions(2.2f,3.3f,4.4f,5.5f,6.6f);
        IngredientItem ingredientItem = new IngredientItem(1,"test",nutritions,"test");
        EasyMock.expect(ingredientItemDAO.getIngredientItem(1)).andReturn(ingredientItem);
        EasyMock.expect(ingredientItemDAO.updateIngredientItem(1)).andReturn(false);
        EasyMock.expect(ingredientItemDAO.updateIngredientItem(ingredientItem)).andReturn(true);
        EasyMock.expect(ingredientItemDAO.deleteIngredientItem(2)).andThrow(new NotFoundException());
        EasyMock.expect(ingredientItemDAO.deleteIngredientItem(1)).andReturn(true);
        EasyMock.expect(ingredientItemDAO.deleteIngredientItem(ingredientItem)).andReturn(true);
        EasyMock.replay(ingredientItemDAO);
        ingredientItemServiceImpl = new IngredientItemServiceImpl(ingredientItemDAO);
    }

    @Test
    public void testGetIngredientItem() throws Exception {
        Nutritions nutritions = new Nutritions(2.2f,3.3f,4.4f,5.5f,6.6f);
        IngredientItem ingredientItem = new IngredientItem(1,"test",nutritions,"test");
        assertEquals(ingredientItemServiceImpl.getIngredientItem(1),ingredientItem);
    }

    @Test
    public void testUpdateIngredientItem() throws Exception {
        assertEquals(ingredientItemServiceImpl.updateIngredientItem(1),false);
    }

    @Test
    public void testUpdateIngredientItem1() throws Exception {
        Nutritions nutritions = new Nutritions(2.2f,3.3f,4.4f,5.5f,6.6f);
        IngredientItem ingredientItem = new IngredientItem(1,"test",nutritions,"test");
        assertTrue(ingredientItemServiceImpl.updateIngredientItem(ingredientItem) == true);
    }

    @Test(expected = IngredientItemNotFoundException.class)
    public void testDeleteIngredientItem() throws Exception {
        ingredientItemServiceImpl.deleteIngredientItem(2);

    }
    @Test
    public void testDeleteIngredientItem2() throws Exception{
        assertTrue(ingredientItemServiceImpl.deleteIngredientItem(1)== true);
    }

    @Test
    public void testDeleteIngredientItem1() throws Exception {
        Nutritions nutritions = new Nutritions(2.2f,3.3f,4.4f,5.5f,6.6f);
        IngredientItem ingredientItem = new IngredientItem(1,"test",nutritions,"test");
        assertEquals(ingredientItemServiceImpl.deleteIngredientItem(ingredientItem),true);
    }

}