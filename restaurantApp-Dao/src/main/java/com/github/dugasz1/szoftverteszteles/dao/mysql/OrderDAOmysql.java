package com.github.dugasz1.szoftverteszteles.dao.mysql;

import com.github.dugasz1.szoftverteszteles.core.exceptions.*;
import com.github.dugasz1.szoftverteszteles.core.model.*;
import com.github.dugasz1.szoftverteszteles.service.dao.OrderDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.NotFoundException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageNotAvailableException;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Map;

/*
 *TODO: Implement it!
 */
public class OrderDAOmysql implements OrderDAO {
    private Connection conn;

    public OrderDAOmysql(java.sql.Connection conn) {
        this.conn = conn;
    }

    public Order createOrder(Map<MenuItem, Integer> menuItems) {
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
