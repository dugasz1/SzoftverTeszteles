package com.github.dugasz1.szoftverteszteles.core.service;

import com.github.dugasz1.szoftverteszteles.core.model.MenuItem;
import com.github.dugasz1.szoftverteszteles.core.model.Order;
import com.github.dugasz1.szoftverteszteles.core.model.User;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.*;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Map;

public interface OrderService {

    Order createOrder(Map<MenuItem, Integer> menuItems) throws StorageProblemException, OrderEmptyOrNullException;

    Order getOrder(int id) throws StorageProblemException, OrderNotFoundException;

    /**
     * Get all order by user
      * @param user
     * @return If ther is no order return empty list
     * @throws StorageProblemException
     */
    Collection<Order> getByUser(User user) throws StorageProblemException;

    boolean updateOrder(Order order) throws StorageProblemException, OrderNotFoundException;

    Order deleteOrder(int id) throws StorageProblemException, OrderNotFoundException;

    Order deleteOrder(Order order) throws StorageProblemException, OrderNotFoundException;
}
