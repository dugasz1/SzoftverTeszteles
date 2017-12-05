package com.github.dugasz1.szoftverteszteles.dao.mysql;

import com.github.dugasz1.szoftverteszteles.core.model.Ingredient;
import com.github.dugasz1.szoftverteszteles.core.model.Order;
import com.github.dugasz1.szoftverteszteles.core.model.User;
import com.github.dugasz1.szoftverteszteles.core.model.WarehouseItem;
import com.github.dugasz1.szoftverteszteles.service.dao.WarehouseDAO;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

public class WarehouseDAOmysql implements WarehouseDAO {

    public WarehouseDAOmysql() {
    }

    public WarehouseItem createWarehouseItem(Ingredient ingredient, User user, Date registered, Date warrant) {
        //IngredientItem ingredientItem = ingredientDAO.getIngredientItem(0);
        return null;
    }

    public Map<WarehouseItem, Float> calculateOrderConsume(Order order) {
        return null;
    }

    public Collection<WarehouseItem> getCloseToWarrant(Date date) {
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
