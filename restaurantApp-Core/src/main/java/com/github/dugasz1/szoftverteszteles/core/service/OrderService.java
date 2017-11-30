package com.github.dugasz1.szoftverteszteles.core.service;

import com.github.dugasz1.szoftverteszteles.core.model.MenuItem;
import com.github.dugasz1.szoftverteszteles.core.model.Order;
import com.github.dugasz1.szoftverteszteles.core.model.User;

import java.util.Collection;
import java.util.Dictionary;

public interface OrderService {
    Order createOrder(Dictionary<MenuItem, Integer> menuItems);

    Order getOrder(int id);

    Collection<Order> getByUser(User user);

    boolean updateOrder(Order order);

    Order deleteOrder(int id);

    Order deleteOrder(Order order);

}
