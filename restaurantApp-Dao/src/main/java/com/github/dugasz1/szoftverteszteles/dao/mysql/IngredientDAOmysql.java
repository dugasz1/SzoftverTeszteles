package com.github.dugasz1.szoftverteszteles.dao.mysql;

import com.github.dugasz1.szoftverteszteles.core.model.IngredientItem;
import com.github.dugasz1.szoftverteszteles.service.IngredientDAO;

import java.sql.Connection;

public class IngredientDAOmysql implements IngredientDAO {
    private Connection conn;

    public IngredientDAOmysql (Connection conn){
        this.conn = conn;
    }

    public IngredientItem getIngredientItem(int id) {
        return null;
    }

    public boolean updateIngredientItem(int id) {
        return false;
    }

    public boolean updateIngredientItem(IngredientItem recipe) {
        return false;
    }

    public boolean deleteIngredientItem(int id) {
        return false;
    }

    public boolean deleteIngredientItem(IngredientItem recipe) {
        return false;
    }
}
