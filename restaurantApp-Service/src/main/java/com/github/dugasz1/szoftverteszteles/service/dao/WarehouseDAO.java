package com.github.dugasz1.szoftverteszteles.service.dao;

import com.github.dugasz1.szoftverteszteles.core.model.Ingredient;
import com.github.dugasz1.szoftverteszteles.core.model.Order;
import com.github.dugasz1.szoftverteszteles.core.model.User;
import com.github.dugasz1.szoftverteszteles.core.model.WarehouseItem;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.*;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

public interface WarehouseDAO {

    WarehouseItem createWarehouseItem(Ingredient ingredient, User user, Date registered, Date warrant) throws StorageException, StorageNotAvailableException, AlreadyExistingException;

    Map<WarehouseItem, Float> calculateOrderConsume(Order order);

    WarehouseItem getWarehouseItem(int id) throws NotFoundException, StorageException, StorageNotAvailableException;

    Collection<WarehouseItem> getByUser(User user) throws NotFoundException, StorageException, StorageNotAvailableException;

    Collection<WarehouseItem> getCloseToWarrant(Date date) throws NotFoundException, StorageException, StorageNotAvailableException;

    /**
     * - Gets warehouseitems between registered date.
     * - Or if from null then all item until date.
     * - Or if until null then all item from date.
     *
     * @param from  from Date
     * @param until until Date
     * @return Collection of warehouse item
     */
    Collection<WarehouseItem> getByRegisteredDate(Date from, Date until) throws NotFoundException, StorageException, StorageNotAvailableException;

    /**
     * - Gets warehouseitems between warrant date.
     * - Or if from null then all item until date.
     * - Or if until null then all item from date.
     *
     * @param from  from Date
     * @param until until Date
     * @return Collection of warehouse item
     */
    Collection<WarehouseItem> getByWarrantDate(Date from, Date until) throws NotFoundException, StorageException, StorageNotAvailableException;

    boolean updateWarehouseItem(int id) throws NotFoundException, StorageNotAvailableException, StorageException, AlreadyExistingException;

    boolean updateWarehouseItem(WarehouseItem warehouseItem) throws NotFoundException, StorageNotAvailableException, StorageException, AlreadyExistingException;

    boolean deleteWarehouseItem(int id) throws NotFoundException, StorageNotAvailableException, StorageException;

    boolean deleteWarehouseItem(WarehouseItem warehouseItem) throws NotFoundException, StorageNotAvailableException, StorageException;


}