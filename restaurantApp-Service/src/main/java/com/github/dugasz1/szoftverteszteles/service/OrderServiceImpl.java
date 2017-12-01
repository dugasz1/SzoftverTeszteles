package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.model.MenuItem;
import com.github.dugasz1.szoftverteszteles.core.model.Order;
import com.github.dugasz1.szoftverteszteles.core.model.User;
import com.github.dugasz1.szoftverteszteles.core.service.OrderService;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.ExistingProblemException;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.MissingArgumentException;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.StorageProblemException;
import com.github.dugasz1.szoftverteszteles.service.dao.OrderDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.*;

import java.util.Collection;
import java.util.Dictionary;


public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;

    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public Order createOrder(Dictionary<MenuItem, Integer> menuItems) throws MissingArgumentException, StorageProblemException, ExistingProblemException {
        try {
            return orderDAO.createOrder(menuItems);
        } catch (NotFoundException | AlreadyExistingException e) {
            throw new ExistingProblemException();
        } catch (StorageException | StorageNotAvailableException e) {
            throw new StorageProblemException();
        } catch (WrongFormatException e) {
            throw new MissingArgumentException();
        }
    }

    public Order getOrder(int id) throws ExistingProblemException, StorageProblemException, MissingArgumentException {
        try {
            return orderDAO.getOrder(id);
        } catch (NotFoundException e) {
            throw new ExistingProblemException();
        } catch (StorageException | StorageNotAvailableException e) {
            throw new StorageProblemException();
        } catch (WrongFormatException e) {
            throw new MissingArgumentException();
        }
    }

    public Collection<Order> getByUser(User user) throws ExistingProblemException, StorageProblemException, MissingArgumentException {
        try {
            return orderDAO.getByUser(user);
        } catch (NotFoundException e) {
            throw new ExistingProblemException();
        } catch (StorageException | StorageNotAvailableException e) {
            throw new StorageProblemException();
        } catch (WrongFormatException e) {
            throw new MissingArgumentException();
        }
    }

    public boolean updateOrder(Order order) throws StorageProblemException, ExistingProblemException {
        try {
            return orderDAO.updateOrder(order);
        } catch (NotFoundException | AlreadyExistingException e) {
            throw new ExistingProblemException();
        } catch (StorageNotAvailableException | StorageException e) {
            throw new StorageProblemException();
        }
    }

    public Order deleteOrder(int id) throws ExistingProblemException, StorageProblemException {
        try {
            return orderDAO.deleteOrder(id);
        } catch (NotFoundException e) {
            throw new ExistingProblemException();
        } catch (StorageNotAvailableException | StorageException e) {
            throw new StorageProblemException();
        }
    }

    public Order deleteOrder(Order order) throws ExistingProblemException, StorageProblemException {
        try {
            return orderDAO.deleteOrder(order);
        } catch (NotFoundException e) {
            throw new ExistingProblemException();
        } catch (StorageNotAvailableException | StorageException e) {
            throw new StorageProblemException();
        }
    }
}
