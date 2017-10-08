package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.authorization.User;
import com.github.dugasz1.szoftverteszteles.core.menu.Ingredient;
import com.github.dugasz1.szoftverteszteles.core.order.Order;
import com.github.dugasz1.szoftverteszteles.core.warehouse.WarehouseItem;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

public interface WarehouseDAO {

    public WarehouseItem Create(Ingredient ingredient, User user, Date registered, Date warrant);

    public WarehouseItem Get(int id);
    public Collection<WarehouseItem> GetByUser( User user);

    /**
     * - Gets warehouseitems between registered date.
     * - Or if from null then all item until date.
     * - Or if until null then all item from date.
     * @param from from Date
     * @param until until Date
     * @return Collection of warehouse item
     */
    public Collection<WarehouseItem> GetByRegisteredDate(Date from, Date until);

    /**
     * - Gets warehouseitems between warrant date.
     * - Or if from null then all item until date.
     * - Or if until null then all item from date.
     * @param from from Date
     * @param until until Date
     * @return Collection of warehouse item
     */
    public Collection<WarehouseItem> GetByWarrantDate(Date from, Date until);

    public boolean Update(int id);
    public boolean Update(WarehouseItem warehouseItem);

    public boolean Delete(int id);
    public boolean Delete(WarehouseItem warehouseItem);


}