package com.github.dugasz1.szoftverteszteles.dao.mysql;

import com.github.dugasz1.szoftverteszteles.core.authorization.User;
import com.github.dugasz1.szoftverteszteles.core.menu.Ingredient;
import com.github.dugasz1.szoftverteszteles.core.warehouse.WarehouseItem;
import com.github.dugasz1.szoftverteszteles.service.WarehouseDAO;

import java.util.Collection;
import java.util.Date;

public class WarehouseDAOmysql implements WarehouseDAO{

    public WarehouseItem createWarehouseItem(Ingredient ingredient, User user, Date registered, Date warrant) {
        return null;
    }

    public WarehouseItem getWarehouseItem(int id) {
        return null;
    }

    public Collection<WarehouseItem> getByUser(User user) {
        return null;
    }

    public Collection<WarehouseItem> getByRegisteredDate(Date from, Date until) {
        return null;
    }

    public Collection<WarehouseItem> getByWarrantDate(Date from, Date until) {
        return null;
    }

    public boolean updateWarehouseItem(int id) {
        return false;
    }

    public boolean updateWarehouseItem(WarehouseItem warehouseItem) {
        return false;
    }

    public boolean deleteWarehouseItem(int id) {
        return false;
    }

    public boolean deleteWarehouseItem(WarehouseItem warehouseItem) {
        return false;
    }
}
