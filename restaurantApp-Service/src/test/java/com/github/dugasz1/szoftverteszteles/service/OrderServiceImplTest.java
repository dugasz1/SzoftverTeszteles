package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.model.*;
import com.github.dugasz1.szoftverteszteles.service.dao.OrderDAO;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class OrderServiceImplTest {
    private OrderServiceImpl orderService;

    private Collection<MenuItem> menuItemCollection = new HashSet<MenuItem>();
    private List<Ingredient> ingredientList = new ArrayList<Ingredient>();

    @Before
    public void setUp() throws Exception {
        OrderDAO orderDAO = EasyMock.createNiceMock(OrderDAO.class);
        ingredientList.add(new Ingredient(new IngredientItem(1, "testingredientitem",
                new Nutritions(1.1f,2.2f,3.3f,4.4f,5.5f), "testunit"), 1.5f));
        ingredientList.add(new Ingredient(new IngredientItem(2, "testingredientitem2",
                new Nutritions(11.1f,22.2f,33.3f,44.4f,55.5f), "testunit2"), 11.5f));

        menuItemCollection.add(new MenuItem(1, 1550f, new Recipe(1, new Category(1, "testCategory1"), ingredientList)));
        menuItemCollection.add(new MenuItem(2,2000f, new Recipe(2, new Category(2, "testCategory2"), ingredientList)));

        Order order = new Order(1, new Date(2017-11-07), menuItemCollection);

        EasyMock.expect(orderDAO.getOrder(1)).andReturn(order);

        EasyMock.replay(orderDAO);
        orderService = new OrderServiceImpl(orderDAO);
    }

    @Test
    public void testCreateOrder() {


    }
    @Test
    public void testGetOrder() throws Exception{
        Collection<MenuItem> menuItemCollection = new HashSet<MenuItem>();
        List<Ingredient> ingredientList = new ArrayList<Ingredient>();

        ingredientList.add(new Ingredient(new IngredientItem(1, "testingredientitem",
                new Nutritions(1.1f,2.2f,3.3f,4.4f,5.5f), "testunit"), 1.5f));
        ingredientList.add(new Ingredient(new IngredientItem(2, "testingredientitem2",
                new Nutritions(11.1f,22.2f,33.3f,44.4f,55.5f), "testunit2"), 11.5f));

        menuItemCollection.add(new MenuItem(1, 1550f, new Recipe(1, new Category(1, "testCategory1"), ingredientList)));
        menuItemCollection.add(new MenuItem(2,2000f, new Recipe(2, new Category(2, "testCategory2"), ingredientList)));

        Order order = new Order(1, new Date(2017-11-07), menuItemCollection);

        assertEquals(orderService.getOrder(1), order);
    }
    @Test
    public void testGetByUser() {

    }
    @Test
    public void testUpdateOrder() {

    }
    @Test
    public void testDeleteOrderone() {

    }
    @Test
    public void testDeleteOrder() {

    }
}
