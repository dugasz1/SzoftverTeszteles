package com.github.dugasz1.szoftverteszteles.service.dao;

import com.github.dugasz1.szoftverteszteles.core.model.User;
import com.github.dugasz1.szoftverteszteles.core.model.MenuItem;
import com.github.dugasz1.szoftverteszteles.core.model.Order;

import java.util.Collection;
import java.util.Dictionary;

public interface OrderDAO {
    Order createOrder(Dictionary<MenuItem, Integer> menuItems);

    Order getOrder(int id);
    Collection<Order> getByUser(User user);

    boolean updateOrder(Order order);

    Order deleteOrder(int id);
    Order deleteOrder(Order order);
}
