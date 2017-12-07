package com.github.dugasz1.szoftverteszteles.service.dao;

import com.github.dugasz1.szoftverteszteles.core.model.MenuItem;
import com.github.dugasz1.szoftverteszteles.core.model.Order;
import com.github.dugasz1.szoftverteszteles.core.model.User;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.*;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Map;

public interface OrderDAO {

    Order createOrder(Map<MenuItem, Integer> menuItems) throws StorageException, StorageNotAvailableException, OrderWrongMapException;

    Order getOrder(int id) throws NotFoundException, StorageException, StorageNotAvailableException;

    Collection<Order> getByUser(User user) throws StorageException, StorageNotAvailableException, NotFoundException;

    boolean updateOrder(Order order) throws NotFoundException, StorageNotAvailableException, StorageException;

    Order deleteOrder(int id) throws NotFoundException, StorageNotAvailableException, StorageException;

    Order deleteOrder(Order order) throws NotFoundException, StorageNotAvailableException, StorageException;
}
