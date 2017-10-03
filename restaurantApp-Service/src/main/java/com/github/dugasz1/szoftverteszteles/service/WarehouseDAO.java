package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.authorization.User;
import com.github.dugasz1.szoftverteszteles.core.order.Order;
import com.github.dugasz1.szoftverteszteles.core.warehouse.WarehouseItem;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

public interface WarehouseDAO {

    public WarehouseItem Get(int id);

    public boolean Update(int id);
    public boolean Update(WarehouseItem warehouseItem);

    public boolean Delete(int id);
    public boolean Delete(WarehouseItem warehouseItem);


    /**
     * Collets How much ingredient will be consumed by the order.
     * @param order The order.
     * @return
     */
    public Map<WarehouseItem, Float> CalculateOrderConsume(Order order);

    public Collection<WarehouseItem> GetCloseToWarrant(Date date);

    public Collection<WarehouseItem> GetAddedByUser( User user);


}