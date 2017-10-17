package com.github.dugasz1.szoftverteszteles.core.service;

import com.github.dugasz1.szoftverteszteles.core.model.MenuItem;
import com.github.dugasz1.szoftverteszteles.core.model.Order;
import com.github.dugasz1.szoftverteszteles.core.model.User;

import java.util.Collection;
import java.util.Dictionary;

public interface OrderService {
    public Order createOrder(Dictionary<MenuItem, Integer> menuItems);

    public Order getOrder(int id);
    public Collection<Order> getByUser(User user);

    public boolean updateOrder(Order order);

    public Order deleteOrder(int id);
    public Order deleteOrder(Order order);

}
