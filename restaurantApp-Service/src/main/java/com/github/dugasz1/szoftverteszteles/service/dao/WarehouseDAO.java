package com.github.dugasz1.szoftverteszteles.service.dao;

import com.github.dugasz1.szoftverteszteles.core.model.Order;
import com.github.dugasz1.szoftverteszteles.core.model.User;
import com.github.dugasz1.szoftverteszteles.core.model.Ingredient;
import com.github.dugasz1.szoftverteszteles.core.model.WarehouseItem;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

public interface WarehouseDAO {

    WarehouseItem createWarehouseItem(Ingredient ingredient, User user, Date registered, Date warrant);

    Map<WarehouseItem, Float> calculateOrderConsume(Order order);
    WarehouseItem getWarehouseItem(int id);
    Collection<WarehouseItem> getByUser(User user);
    Collection<WarehouseItem> getCloseToWarrant(Date date);

    /**
     * - Gets warehouseitems between registered date.
     * - Or if from null then all item until date.
     * - Or if until null then all item from date.
     * @param from from Date
     * @param until until Date
     * @return Collection of warehouse item
     */
    Collection<WarehouseItem> getByRegisteredDate(Date from, Date until);

    /**
     * - Gets warehouseitems between warrant date.
     * - Or if from null then all item until date.
     * - Or if until null then all item from date.
     * @param from from Date
     * @param until until Date
     * @return Collection of warehouse item
     */
    Collection<WarehouseItem> getByWarrantDate(Date from, Date until);

    boolean updateWarehouseItem(int id);
    boolean updateWarehouseItem(WarehouseItem warehouseItem);

    boolean deleteWarehouseItem(int id);
    boolean deleteWarehouseItem(WarehouseItem warehouseItem);


}