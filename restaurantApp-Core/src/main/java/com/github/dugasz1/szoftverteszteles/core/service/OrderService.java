package com.github.dugasz1.szoftverteszteles.core.service;

import com.github.dugasz1.szoftverteszteles.core.model.MenuItem;
import com.github.dugasz1.szoftverteszteles.core.model.Order;
import com.github.dugasz1.szoftverteszteles.core.model.User;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.ExistingProblemException;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.MissingArgumentException;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.StorageProblemException;

import java.util.Collection;
import java.util.Dictionary;

public interface OrderService {
    Order createOrder(Dictionary<MenuItem, Integer> menuItems) throws StorageProblemException, ExistingProblemException, MissingArgumentException;

    Order getOrder(int id) throws StorageProblemException, ExistingProblemException, MissingArgumentException;

    Collection<Order> getByUser(User user) throws ExistingProblemException, StorageProblemException, MissingArgumentException;

    boolean updateOrder(Order order) throws StorageProblemException, ExistingProblemException;

    Order deleteOrder(int id) throws StorageProblemException, ExistingProblemException;

    Order deleteOrder(Order order) throws StorageProblemException, ExistingProblemException;
}
