package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.model.MenuItem;
import com.github.dugasz1.szoftverteszteles.core.model.User;
import com.github.dugasz1.szoftverteszteles.service.dao.OrderDAO;
import com.github.dugasz1.szoftverteszteles.core.model.Order;
import com.github.dugasz1.szoftverteszteles.core.service.OrderService;

import java.util.Collection;
import java.util.Dictionary;


public class OrderServiceImpl implements OrderService{
    private OrderDAO orderDAO = null;

    public OrderServiceImpl(OrderDAO orderDAO){this.orderDAO = orderDAO;}

    public Order createOrder(Dictionary<MenuItem, Integer> menuItems) {
        return orderDAO.createOrder(menuItems);
    }

    public Order getOrder(int id) {
        return orderDAO.getOrder(id);
    }

    public Collection<Order> getByUser(User user) {
        return orderDAO.getByUser(user);
    }

    public boolean updateOrder(Order order) {
        return orderDAO.updateOrder(order);
    }

    public Order deleteOrder(int id) {
        return orderDAO.deleteOrder(id);
    }

    public Order deleteOrder(Order order) {
        return orderDAO.deleteOrder(order);
    }
}
