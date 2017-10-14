package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.model.User;
import com.github.dugasz1.szoftverteszteles.core.model.MenuItem;
import com.github.dugasz1.szoftverteszteles.core.model.Order;

import java.util.Collection;
import java.util.Dictionary;

public interface OrderDAO {
    public Order createOrder(Dictionary<MenuItem, Integer> menuItems);

    public Order getOrder(int id);
    public Collection<Order> getByUser(User user);

    public boolean updateOrder(Order order);

    public Order deleteOrder(int id);
    public Order deleteOrder(Order order);
}
