package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.model.Ingredient;
import com.github.dugasz1.szoftverteszteles.core.model.Order;
import com.github.dugasz1.szoftverteszteles.core.model.User;
import com.github.dugasz1.szoftverteszteles.core.model.WarehouseItem;
import com.github.dugasz1.szoftverteszteles.core.service.WarehouseService;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.ExistingProblemException;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.MissingArgumentException;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.StorageProblemException;
import com.github.dugasz1.szoftverteszteles.service.dao.WarehouseDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.*;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

public class WarehouseServiceImpl implements WarehouseService {

    private WarehouseDAO warehouseDAO;

    public WarehouseServiceImpl(WarehouseDAO warehouseDAO) {
        this.warehouseDAO = warehouseDAO;
    }

    public WarehouseItem createWarehouseItem(Ingredient ingredient, User user, Date registered, Date warrant) throws ExistingProblemException, StorageProblemException, MissingArgumentException {
        try {
            return warehouseDAO.createWarehouseItem(ingredient, user, registered, warrant);
        } catch (AlreadyExistingException e) {
            throw new ExistingProblemException();
        } catch (StorageException | StorageNotAvailableException e) {
            throw new StorageProblemException();
        }
    }

    public Map<WarehouseItem, Float> calculateOrderConsume(Order order) {
        return warehouseDAO.calculateOrderConsume(order);
    }

    public Collection<WarehouseItem> getCloseToWarrant(Date date) throws ExistingProblemException, StorageProblemException, MissingArgumentException {
        try {
            return warehouseDAO.getCloseToWarrant(date);
        } catch (NotFoundException e) {
            throw new ExistingProblemException();
        } catch (StorageException | StorageNotAvailableException e) {
            throw new StorageProblemException();
        }
    }

    public WarehouseItem getWarehouseItem(int id) throws ExistingProblemException, StorageProblemException, MissingArgumentException {
        try {
            return warehouseDAO.getWarehouseItem(id);
        } catch (NotFoundException e) {
            throw new ExistingProblemException();
        } catch (StorageException | StorageNotAvailableException e) {
            throw new StorageProblemException();
        }
    }

    public Collection<WarehouseItem> getByUser(User user) throws ExistingProblemException, StorageProblemException, MissingArgumentException {
        try {
            return warehouseDAO.getByUser(user);
        } catch (NotFoundException e) {
            throw new ExistingProblemException();
        } catch (StorageException | StorageNotAvailableException e) {
            throw new StorageProblemException();
        }
    }

    public Collection<WarehouseItem> getByRegisteredDate(Date from, Date until) throws ExistingProblemException, StorageProblemException, MissingArgumentException {
        try {
            return warehouseDAO.getByRegisteredDate(from, until);
        } catch (NotFoundException e) {
            throw new ExistingProblemException();
        } catch (StorageException | StorageNotAvailableException e) {
            throw new StorageProblemException();
        }
    }

    public Collection<WarehouseItem> getByWarrantDate(Date from, Date until) throws ExistingProblemException, StorageProblemException, MissingArgumentException {
        try {
            return warehouseDAO.getByWarrantDate(from, until);
        } catch (NotFoundException e) {
            throw new ExistingProblemException();
        } catch (StorageException | StorageNotAvailableException e) {
            throw new StorageProblemException();
        }
    }

    public boolean updateWarehouseItem(int id) throws ExistingProblemException, StorageProblemException {
        try {
            return warehouseDAO.updateWarehouseItem(id);
        } catch (NotFoundException | AlreadyExistingException e) {
            throw new ExistingProblemException();
        } catch (StorageNotAvailableException | StorageException e) {
            throw new StorageProblemException();
        }
    }

    public boolean updateWarehouseItem(WarehouseItem warehouseItem) throws ExistingProblemException, StorageProblemException {
        try {
            return warehouseDAO.updateWarehouseItem(warehouseItem);
        } catch (NotFoundException | AlreadyExistingException e) {
            throw new ExistingProblemException();
        } catch (StorageNotAvailableException | StorageException e) {
            throw new StorageProblemException();
        }
    }

    public boolean deleteWarehouseItem(int id) throws ExistingProblemException, StorageProblemException {
        try {
            return warehouseDAO.deleteWarehouseItem(id);
        } catch (NotFoundException e) {
            throw new ExistingProblemException();
        } catch (StorageNotAvailableException | StorageException e) {
            throw new StorageProblemException();
        }
    }

    public boolean deleteWarehouseItem(WarehouseItem warehouseItem) throws ExistingProblemException, StorageProblemException {
        try {
            return warehouseDAO.deleteWarehouseItem(warehouseItem);
        } catch (NotFoundException e) {
            throw new ExistingProblemException();
        } catch (StorageNotAvailableException | StorageException e) {
            throw new StorageProblemException();
        }
    }
}
