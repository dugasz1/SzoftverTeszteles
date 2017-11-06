package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.model.*;
import com.github.dugasz1.szoftverteszteles.core.model.MenuItem;
import com.github.dugasz1.szoftverteszteles.core.service.MenuService;
import com.github.dugasz1.szoftverteszteles.service.dao.MenuDAO;
import org.easymock.EasyMock;
import org.junit.Assume;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

import static org.testng.Assert.*;

public class MenuServiceImplTest {
    private MenuServiceImpl menuService;


    @BeforeMethod
    public void setUp() throws Exception {
        MenuDAO menuDAO = EasyMock.createNiceMock(MenuDAO.class);
        Nutritions nutritions = new Nutritions(1.1f,2.2f,3.3f,4.4f,5.5f);
        IngredientItem ingredientItem = new IngredientItem(1,"testIngredientItem",nutritions,"testUnit");
        Ingredient ingredient = new Ingredient(ingredientItem,2.0f);
        Category category = new Category(1,"testCategory");
        Collection collection= new ArrayList<Ingredient>();
        collection.add(ingredient);
        Recipe recipe = new Recipe(1,category,collection);
        MenuItem menuItem = new MenuItem(1,2000.0f,recipe);


        try {
            EasyMock.expect(menuDAO.getMenuItem(1)).andReturn(menuItem);
        } catch (Exception e) {
            Assume.assumeNoException(e);
        }
        EasyMock.replay(menuDAO);
        menuService = new MenuServiceImpl(menuDAO);
    }

    @Test
    public void testCreateMenuItem() throws Exception {
    }

    @Test
    public void testGetMenuItem() throws Exception {
        //IDK is it good ?
        Nutritions nutritions = new Nutritions(1.1f,2.2f,3.3f,4.4f,5.5f);
        IngredientItem ingredientItem = new IngredientItem(1,"testIngredientItem",nutritions,"testUnit");
        Ingredient ingredient = new Ingredient(ingredientItem,2.0f);
        Category category = new Category(1,"testCategory");
        Collection collection= new ArrayList<Ingredient>();
        collection.add(ingredient);
        Recipe recipe = new Recipe(1,category,collection);
        MenuItem menuItem = new MenuItem(1,2000.0f,recipe);
        assertEquals(menuService.getMenuItem(1),menuItem);
    }

    @Test
    public void testUpdateMenuItem() throws Exception {
    }

    @Test
    public void testUpdateMenuItem1() throws Exception {
    }

    @Test
    public void testDeleteMenuItem() throws Exception {
    }

    @Test
    public void testDeleteMenuItem1() throws Exception {
    }

}