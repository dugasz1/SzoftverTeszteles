package com.github.dugasz1.szoftverteszteles.dao.mysql;

import com.github.dugasz1.szoftverteszteles.core.model.MenuItem;
import com.github.dugasz1.szoftverteszteles.core.model.Order;
import com.github.dugasz1.szoftverteszteles.core.model.User;
import com.github.dugasz1.szoftverteszteles.service.dao.OrderDAO;

import java.util.Collection;
import java.util.Dictionary;

/*
 *TODO: Implement it!
 */
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
