package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.model.MenuItem;
import com.github.dugasz1.szoftverteszteles.core.model.Order;
import com.github.dugasz1.szoftverteszteles.core.model.User;
import com.github.dugasz1.szoftverteszteles.core.service.OrderService;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.*;
import com.github.dugasz1.szoftverteszteles.service.dao.MenuItemDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.OrderDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.*;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Map;


public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;

    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public Order createOrder(Map<MenuItem, Integer> menuItems) throws StorageProblemException, OrderEmptyOrNullException {
        try {
            return orderDAO.createOrder(menuItems);
        } catch (StorageException | StorageNotAvailableException e) {
            throw new StorageProblemException(e);
        } catch (OrderWrongMapException e) {
            throw new OrderEmptyOrNullException(e);
        }
    }

    public Order getOrder(int id) throws StorageProblemException, OrderNotFoundException {
        try {
            return orderDAO.getOrder(id);
        } catch (NotFoundException e) {
            throw new OrderNotFoundException(e);
        } catch (StorageException | StorageNotAvailableException e) {
            throw new StorageProblemException(e);
        }
    }

    public Collection<Order> getByUser(User user) throws StorageProblemException, OrderNotFoundException {
        try {
            return orderDAO.getByUser(user);
        } catch (StorageException | StorageNotAvailableException e) {
            throw new StorageProblemException(e);
        } catch (NotFoundException e) {
            throw new OrderNotFoundException(e);
        }
    }

    public boolean updateOrder(Order order) throws StorageProblemException, OrderNotFoundException {
        try {
            return orderDAO.updateOrder(order);
        } catch (NotFoundException e) {
            throw new OrderNotFoundException(e);
        } catch (StorageNotAvailableException | StorageException e) {
            throw new StorageProblemException(e);
        }
    }

    public Order deleteOrder(int id) throws StorageProblemException, OrderNotFoundException {
        try {
            return orderDAO.deleteOrder(id);
        } catch (NotFoundException e) {
            throw new OrderNotFoundException(e);
        } catch (StorageNotAvailableException | StorageException e) {
            throw new StorageProblemException(e);
        }
    }

    public Order deleteOrder(Order order) throws StorageProblemException, OrderNotFoundException {
        try {
            return orderDAO.deleteOrder(order);
        } catch (NotFoundException e) {
            throw new OrderNotFoundException(e);
        } catch (StorageNotAvailableException | StorageException e) {
            throw new StorageProblemException(e);
        }
    }
}
