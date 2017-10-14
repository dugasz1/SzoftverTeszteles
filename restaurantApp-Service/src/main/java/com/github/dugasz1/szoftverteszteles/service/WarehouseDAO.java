package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.model.User;
import com.github.dugasz1.szoftverteszteles.core.model.Ingredient;
import com.github.dugasz1.szoftverteszteles.core.model.WarehouseItem;

import java.util.Collection;
import java.util.Date;

public interface WarehouseDAO {

    public WarehouseItem createWarehouseItem(Ingredient ingredient, User user, Date registered, Date warrant);

    public WarehouseItem getWarehouseItem(int id);
    public Collection<WarehouseItem> getByUser( User user);

    /**
     * - Gets warehouseitems between registered date.
     * - Or if from null then all item until date.
     * - Or if until null then all item from date.
     * @param from from Date
     * @param until until Date
     * @return Collection of warehouse item
     */
    public Collection<WarehouseItem> getByRegisteredDate(Date from, Date until);

    /**
     * - Gets warehouseitems between warrant date.
     * - Or if from null then all item until date.
     * - Or if until null then all item from date.
     * @param from from Date
     * @param until until Date
     * @return Collection of warehouse item
     */
    public Collection<WarehouseItem> getByWarrantDate(Date from, Date until);

    public boolean updateWarehouseItem(int id);
    public boolean updateWarehouseItem(WarehouseItem warehouseItem);

    public boolean deleteWarehouseItem(int id);
    public boolean deleteWarehouseItem(WarehouseItem warehouseItem);


}