package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.model.*;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.OrderEmptyOrNullException;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.OrderNotFoundException;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.StorageProblemException;
import com.github.dugasz1.szoftverteszteles.service.dao.OrderDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.NotFoundException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.OrderWrongMapException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageException;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrderServiceImplTest {
    private OrderServiceImpl orderService;

    private Collection<MenuItem> menuItemCollection = new HashSet<MenuItem>();
    private List<Ingredient> ingredientList = new ArrayList<Ingredient>();

    private MenuItem menuItem1;
    private MenuItem menuItem2;

    private Order order;
    private Order createdOrder;

    private User user;
    private Collection<Order> ordersForUser;

    private Map<MenuItem, Integer> map;
    @Before
    public void setUp() throws Exception {
        OrderDAO orderDAO = EasyMock.createNiceMock(OrderDAO.class);
        ingredientList.add(new Ingredient(new IngredientItem(1, "testingredientitem",
                new Nutritions(1.1f,2.2f,3.3f,4.4f,5.5f), "testunit"), 1.5f));
        ingredientList.add(new Ingredient(new IngredientItem(2, "testingredientitem2",
                new Nutritions(11.1f,22.2f,33.3f,44.4f,55.5f), "testunit2"), 11.5f));

        menuItem1 = new MenuItem(1, 1550f, new Recipe(1,"name",  new Category(1, "testCategory1"), ingredientList));
        menuItem2 = new MenuItem(2,2000f, new Recipe(2,"name",  new Category(2, "testCategory2"), ingredientList));
        menuItemCollection.add(menuItem1);
        menuItemCollection.add(menuItem2);

        order = new Order(1, new Date(2017-11-07), menuItemCollection);
        EasyMock.expect(orderDAO.getOrder(1)).andReturn(order);
        EasyMock.expect(orderDAO.getOrder(111)).andThrow(new NotFoundException());

        createdOrder = new Order(2, new Date(2017-12-06), menuItemCollection);
        map = new HashMap<MenuItem, Integer>();
        map.put(menuItem1, 1);
        map.put(menuItem2, 1);
        EasyMock.expect(orderDAO.createOrder(map)).andReturn(createdOrder);
        EasyMock.expect(orderDAO.createOrder(null)).andThrow(new OrderWrongMapException());

        user = new User(1, "Teszt");
        ordersForUser = new ArrayList<>();
        ordersForUser.add(order);
        EasyMock.expect(orderDAO.getByUser(user)).andReturn(ordersForUser);

        EasyMock.expect(orderDAO.updateOrder(createdOrder)).andReturn(true);

        EasyMock.replay(orderDAO);
        orderService = new OrderServiceImpl(orderDAO);
    }

    @Test
    public void testCreateOrder() throws Exception{
        Order order = orderService.createOrder(map);
        assertEquals(order, createdOrder);
    }

    @Test(expected = OrderEmptyOrNullException.class)
    public void testCreateOrderStorateProblem() throws Exception{
        orderService.createOrder(null);
    }

    @Test
    public void testGetOrder() throws Exception{
        Collection<MenuItem> menuItemCollection = new HashSet<MenuItem>();
        List<Ingredient> ingredientList = new ArrayList<Ingredient>();

        assertEquals(orderService.getOrder(1), order);
    }

    @Test(expected = OrderNotFoundException.class)
    public void testGetOrderNotFound() throws Exception{
        orderService.getOrder(111);
    }

    @Test
    public void testGetByUser() throws Exception{
        Collection<Order> orders = orderService.getByUser(user);
        assertEquals(orders, ordersForUser);
    }
    @Test
    public void testUpdateOrder() throws Exception{
        assertTrue(orderService.updateOrder(createdOrder));
    }
    @Test
    public void testDeleteOrderone() {

    }
    @Test
    public void testDeleteOrder() {

    }
}
