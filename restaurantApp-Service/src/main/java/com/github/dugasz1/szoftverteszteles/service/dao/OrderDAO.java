package com.github.dugasz1.szoftverteszteles.service.dao;

import com.github.dugasz1.szoftverteszteles.core.model.MenuItem;
import com.github.dugasz1.szoftverteszteles.core.model.Order;
import com.github.dugasz1.szoftverteszteles.core.model.User;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.*;

import java.util.Collection;
import java.util.Dictionary;

public interface OrderDAO {

    Order createOrder(Dictionary<MenuItem, Integer> menuItems) throws NotFoundException, StorageException, StorageNotAvailableException, AlreadyExistingException;

    Order getOrder(int id) throws NotFoundException, StorageException, StorageNotAvailableException;

    Collection<Order> getByUser(User user) throws NotFoundException, StorageException, StorageNotAvailableException;

    boolean updateOrder(Order order) throws NotFoundException, StorageNotAvailableException, StorageException, AlreadyExistingException;

    Order deleteOrder(int id) throws NotFoundException, StorageNotAvailableException, StorageException;

    Order deleteOrder(Order order) throws NotFoundException, StorageNotAvailableException, StorageException;
}
