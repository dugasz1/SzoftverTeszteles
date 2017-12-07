package com.github.dugasz1.szoftverteszteles.dao.mysql;

import com.github.dugasz1.szoftverteszteles.core.exceptions.*;
import com.github.dugasz1.szoftverteszteles.core.model.*;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.OrderNotFoundException;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.StorageProblemException;
import com.github.dugasz1.szoftverteszteles.service.dao.MenuItemDAO;
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
    private MenuItemDAO menuItemDAO;

    public OrderDAOmysql(java.sql.Connection conn, MenuItemDAO menuItemDAO) {
        this.conn = conn;
        this.menuItemDAO = menuItemDAO;
    }

    public Order createOrder(Map<MenuItem, Integer> menuItems) {
        return null;
    }

    public Order getOrder(int id) throws StorageException, NotFoundException, StorageNotAvailableException {
        ResultSet orderRS;
        Collection<MenuItem> menuItems;
        try {
            PreparedStatement orderPS = conn.prepareStatement("SELECT * FROM `order` WHERE `id`=?");
            orderPS.setInt(1, id);

            orderRS = orderPS.executeQuery();
            if(!orderRS.isBeforeFirst()){
                throw new NotFoundException("Order not found with id:" + id);
            }

            PreparedStatement orderMenuPS = conn.prepareStatement("SELECT * FROM `order_menu` WHERE `order_id`=?");
            orderMenuPS.setInt(1, id);

            ResultSet orderMenuRS = orderMenuPS.executeQuery();
            menuItems = new ArrayList<>();
            while (orderMenuRS.next()){
                try {
                    MenuItem menuItem = menuItemDAO.getMenuItem(orderMenuRS.getInt("menu_id"));
                    menuItems.add(menuItem);
                } catch (NoCategoryException e) {
                    throw new StorageException(e);
                }
            }

            orderRS.next();
            return new Order(orderRS.getInt("id"), orderRS.getTimestamp("date"), menuItems);
        } catch (SQLException | EmptyMenuitemException | NoMenuitemException | NoDateException e) {
            throw new StorageException(e);
        }

    }

    public Collection<Order> getByUser(User user) throws StorageException, StorageNotAvailableException {
        Collection<Order> orders = new ArrayList<>();
        try {
            PreparedStatement userOrderPS = conn.prepareStatement("SELECT * FROM `user_order` WHERE `user_id`=?");
            userOrderPS.setInt(1, user.getId());
            ResultSet userOrderRS = userOrderPS.executeQuery();
            if(!userOrderRS.isBeforeFirst()){ //There is no order for this user
                return orders;
            }

            while (userOrderRS.next()){
                Order order = getOrder(userOrderRS.getInt("order_id"));
                orders.add(order);
            }
        } catch (SQLException e) {
            throw new StorageException(e);
        } catch (NotFoundException e) {
            throw new StorageException(e);
        }

        return orders;
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
