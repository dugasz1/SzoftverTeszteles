package com.github.dugasz1.szoftverteszteles.dao.mysql;

import com.github.dugasz1.szoftverteszteles.core.model.MenuItem;
import com.github.dugasz1.szoftverteszteles.service.dao.MenuDAO;

public class MenuDAOmysql implements MenuDAO{

    @Override
    public void createMenuItem(MenuItem menuItem) {

    }

    public MenuItem getMenuItem(int id) {
        return null;
    }

    public boolean updateMenuItem(int id) {
        return false;
    }

    public boolean updateMenuItem(MenuItem menuItem) {
        return false;
    }

    public boolean deleteMenuItem(int id) {
        return false;
    }

    public boolean deleteMenuItem(MenuItem menuItem) {
        return false;
    }
}
