package com.github.dugasz1.szoftverteszteles.core.service;

import com.github.dugasz1.szoftverteszteles.core.model.Ingredient;
import com.github.dugasz1.szoftverteszteles.core.model.Order;
import com.github.dugasz1.szoftverteszteles.core.model.User;
import com.github.dugasz1.szoftverteszteles.core.model.WarehouseItem;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

public interface WarehouseService {
    public WarehouseItem createWarehouseItem(Ingredient ingredient, User user, Date registered, Date warrant);

    /**
     * Collects how much ingredient will be consumed by the order.
     * @param order The order.
     * @return
     */
    public Map<WarehouseItem, Float> calculateOrderConsume(Order order);

    public Collection<WarehouseItem> getCloseToWarrant(Date date);

    public WarehouseItem getWarehouseItem(int id);
    public Collection<WarehouseItem> getByUser( User user);

    public Collection<WarehouseItem> getByRegisteredDate(Date from, Date until);
    public Collection<WarehouseItem> getByWarrantDate(Date from, Date until);

    public boolean updateWarehouseItem(int id);
    public boolean updateWarehouseItem(WarehouseItem warehouseItem);

    public boolean deleteWarehouseItem(int id);
    public boolean deleteWarehouseItem(WarehouseItem warehouseItem);
    
}
