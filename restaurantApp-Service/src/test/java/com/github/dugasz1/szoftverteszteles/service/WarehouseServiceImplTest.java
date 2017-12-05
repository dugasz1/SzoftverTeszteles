package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.model.*;
import com.github.dugasz1.szoftverteszteles.core.service.WarehouseService;
import com.github.dugasz1.szoftverteszteles.service.dao.WarehouseDAO;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

public class WarehouseServiceImplTest {
    private WarehouseDAO warehouseDAO = null;
    private Nutritions nutritions;
    private Ingredient ingredient;
    private IngredientItem ingredientItem;

    private User user;

    private Date registered;
    private Date warrant;

    private Order order;
    private MenuItem menuItem;
    private WarehouseItem warehouseItem;

    private Map<WarehouseItem, Float> consume;

    private WarehouseService warehouseService;

    @Before
    public void setUp() throws Exception {
        registered = new Date(2017-5-10);
        warrant = new Date(2018-10-15);
        user = new User(1, "Teszt Elek");

        nutritions = new Nutritions(10,10,10,10,10);
        ingredientItem = new IngredientItem(1, "Datoja", nutritions, "kg");
        ingredient = new Ingredient(ingredientItem, 10);

        warehouseDAO = EasyMock.createMock(WarehouseDAO.class);
        warehouseItem = new WarehouseItem(1, ingredientItem, user, registered, warrant);
        EasyMock.expect(warehouseDAO.createWarehouseItem(ingredient, user, registered, warrant)).andReturn(warehouseItem);


        Collection<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredients.add(ingredient);
        menuItem = new MenuItem(1, 10, new Recipe(1, new Category(1,"Teszt"),
                ingredients));
        Collection<MenuItem> menuItems = new ArrayList<MenuItem>();
        menuItems.add(menuItem);
        order = new Order(1, warrant, menuItems);

        //Calculate order
        consume = new HashMap<WarehouseItem, Float>();
        consume.put(warehouseItem, new Float(10));
        EasyMock.expect(warehouseDAO.calculateOrderConsume(order)).andReturn(consume);

        EasyMock.replay(warehouseDAO);

        warehouseService = new WarehouseServiceImpl(warehouseDAO);

    }

    @Test
    public void createWarehouseItemTest () throws Exception {
        //org.junit.Assert.assertEquals(warehouseService.createWarehouseItem(ingredient, user, registered, warrant), warehouseItem);
    }

    @Test
    public void calculateOrderConsume() throws Exception {
        org.junit.Assert.assertEquals(warehouseService.calculateOrderConsume(order), consume);
    }

}
