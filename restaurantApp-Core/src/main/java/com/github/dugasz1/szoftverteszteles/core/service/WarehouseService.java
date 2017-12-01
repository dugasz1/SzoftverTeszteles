package com.github.dugasz1.szoftverteszteles.core.service;

import com.github.dugasz1.szoftverteszteles.core.model.Ingredient;
import com.github.dugasz1.szoftverteszteles.core.model.Order;
import com.github.dugasz1.szoftverteszteles.core.model.User;
import com.github.dugasz1.szoftverteszteles.core.model.WarehouseItem;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.ExistingProblemException;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.MissingArgumentException;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.StorageProblemException;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

public interface WarehouseService {

    WarehouseItem createWarehouseItem(Ingredient ingredient, User user, Date registered, Date warrant) throws StorageProblemException, ExistingProblemException, MissingArgumentException;

    /**
     * Collects how much ingredient will be consumed by the order.
     *
     * @param order The order.
     * @return
     */
    Map<WarehouseItem, Float> calculateOrderConsume(Order order);

    Collection<WarehouseItem> getCloseToWarrant(Date date) throws StorageProblemException, ExistingProblemException, MissingArgumentException;

    WarehouseItem getWarehouseItem(int id) throws StorageProblemException, ExistingProblemException, MissingArgumentException;

    Collection<WarehouseItem> getByUser(User user) throws StorageProblemException, ExistingProblemException, MissingArgumentException;

    Collection<WarehouseItem> getByRegisteredDate(Date from, Date until) throws StorageProblemException, ExistingProblemException, MissingArgumentException;

    Collection<WarehouseItem> getByWarrantDate(Date from, Date until) throws StorageProblemException, ExistingProblemException, MissingArgumentException;

    boolean updateWarehouseItem(int id) throws StorageProblemException, ExistingProblemException;

    boolean updateWarehouseItem(WarehouseItem warehouseItem) throws StorageProblemException, ExistingProblemException;

    boolean deleteWarehouseItem(int id) throws StorageProblemException, ExistingProblemException;

    boolean deleteWarehouseItem(WarehouseItem warehouseItem) throws StorageProblemException, ExistingProblemException;
}
