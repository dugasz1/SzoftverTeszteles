package com.github.dugasz1.szoftverteszteles.dao.mysql;

import com.github.dugasz1.szoftverteszteles.core.authorization.User;
import com.github.dugasz1.szoftverteszteles.core.menu.MenuItem;
import com.github.dugasz1.szoftverteszteles.core.order.Order;
import com.github.dugasz1.szoftverteszteles.service.OrderDAO;

import java.util.Collection;
import java.util.Dictionary;

public class OrderDAOmysql implements OrderDAO {
    public Order createOrder(Dictionary<MenuItem, Integer> menuItems) {
        return null;
    }

    public Order getOrder(int id) {
        return null;
    }

    public Collection<Order> getByUser(User user) {
        return null;
    }

    public boolean updateOrder(Order order) {
        return false;
    }

    public Order deleteOrder(int id) {
        return null;
    }

    public Order deleteOrder(Order order) {
        return null;
    }
}
