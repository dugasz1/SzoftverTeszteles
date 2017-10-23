package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.model.Ingredient;
import com.github.dugasz1.szoftverteszteles.core.model.Order;
import com.github.dugasz1.szoftverteszteles.core.model.User;
import com.github.dugasz1.szoftverteszteles.core.model.WarehouseItem;
import com.github.dugasz1.szoftverteszteles.core.service.WarehouseService;
import com.github.dugasz1.szoftverteszteles.service.dao.WarehouseDAO;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

public class Warehouseimpl implements WarehouseService {

    private WarehouseDAO warehouseDAO = null;

    public Warehouseimpl(WarehouseDAO warehouseDAO) {
        this.warehouseDAO = warehouseDAO;
    }


    public WarehouseItem createWarehouseItem(Ingredient ingredient, User user, Date registered, Date warrant) {
        return warehouseDAO.createWarehouseItem(ingredient, user, registered, warrant);
    }

    public Map<WarehouseItem, Float> calculateOrderConsume(Order order) {
        return warehouseDAO.calculateOrderConsume(order);
    }

    public Collection<WarehouseItem> getCloseToWarrant(Date date) {
        return warehouseDAO.getCloseToWarrant(date);
    }

    public WarehouseItem getWarehouseItem(int id) {
        return warehouseDAO.getWarehouseItem(id);
    }

    public Collection<WarehouseItem> getByUser(User user) {
        return warehouseDAO.getByUser(user);
    }

    public Collection<WarehouseItem> getByRegisteredDate(Date from, Date until) {
        return warehouseDAO.getByRegisteredDate(from, until);
    }

    public Collection<WarehouseItem> getByWarrantDate(Date from, Date until) {
        return warehouseDAO.getByWarrantDate(from, until);
    }

    public boolean updateWarehouseItem(int id) {
        return warehouseDAO.updateWarehouseItem(id);
    }

    public boolean updateWarehouseItem(WarehouseItem warehouseItem) {
        return warehouseDAO.updateWarehouseItem(warehouseItem);
    }

    public boolean deleteWarehouseItem(int id) {
        return warehouseDAO.deleteWarehouseItem(id);
    }

    public boolean deleteWarehouseItem(WarehouseItem warehouseItem) {
        return warehouseDAO.deleteWarehouseItem(warehouseItem);
    }
}
