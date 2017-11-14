package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.model.*;
import com.github.dugasz1.szoftverteszteles.service.dao.IngredientDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.MenuDAO;
import org.easymock.EasyMock;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.testng.Assert.*;

public class IngredientServiceimplTest {
    private IngredientServiceimpl ingredientServiceimpl;

    @Before
    public void setUp() throws Exception {
        IngredientDAO ingredientDAO = EasyMock.createNiceMock(IngredientDAO.class);
        Nutritions nutritions = new Nutritions(2.2f,3.3f,4.4f,5.5f,6.6f);
        IngredientItem ingredientItem = new IngredientItem(1,"test",nutritions,"test");
        EasyMock.expect(ingredientDAO.getIngredientItem(1)).andReturn(ingredientItem);
        EasyMock.replay(ingredientDAO);
        ingredientServiceimpl = new IngredientServiceimpl(ingredientDAO);
    }

    @Test
    public void testGetIngredientItem() throws Exception {
        Nutritions nutritions = new Nutritions(2.2f,3.3f,4.4f,5.5f,6.6f);
        IngredientItem ingredientItem = new IngredientItem(1,"test",nutritions,"test");
        assertEquals(ingredientServiceimpl.getIngredientItem(1),ingredientItem);
    }

    @Test
    public void testUpdateIngredientItem() throws Exception {
    }

    @Test
    public void testUpdateIngredientItem1() throws Exception {
    }

    @Test
    public void testDeleteIngredientItem() throws Exception {
    }

    @Test
    public void testDeleteIngredientItem1() throws Exception {
    }

}