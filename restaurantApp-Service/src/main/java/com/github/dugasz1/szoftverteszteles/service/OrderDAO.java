package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.authorization.User;
import com.github.dugasz1.szoftverteszteles.core.menu.MenuItem;
import com.github.dugasz1.szoftverteszteles.core.order.Order;

import java.util.Collection;
import java.util.Dictionary;

public interface OrderDAO {
    public Order CreateOrder(Dictionary<MenuItem, Integer> menuItems);

    public Order Get(int id);
    public Collection<Order> GetByUser(User user);

    public boolean Update(Order order);

    public Order Delete(int id);
    public Order Delete(Order order);
}
