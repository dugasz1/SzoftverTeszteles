package com.github.dugasz1.szoftverteszteles.core.service;

import com.github.dugasz1.szoftverteszteles.core.model.Ingredient;
import com.github.dugasz1.szoftverteszteles.core.model.Order;
import com.github.dugasz1.szoftverteszteles.core.model.User;
import com.github.dugasz1.szoftverteszteles.core.model.WarehouseItem;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

public interface WarehouseService {
    WarehouseItem createWarehouseItem(Ingredient ingredient, User user, Date registered, Date warrant);

    /**
     * Collects how much ingredient will be consumed by the order.
     * @param order The order.
     * @return
     */
    Map<WarehouseItem, Float> calculateOrderConsume(Order order);

    Collection<WarehouseItem> getCloseToWarrant(Date date);

    WarehouseItem getWarehouseItem(int id);
    Collection<WarehouseItem> getByUser(User user);

    Collection<WarehouseItem> getByRegisteredDate(Date from, Date until);
    Collection<WarehouseItem> getByWarrantDate(Date from, Date until);

    boolean updateWarehouseItem(int id);
    boolean updateWarehouseItem(WarehouseItem warehouseItem);

    boolean deleteWarehouseItem(int id);
    boolean deleteWarehouseItem(WarehouseItem warehouseItem);
    
}
