package com.github.dugasz1.szoftverteszteles.service.dao;

import com.github.dugasz1.szoftverteszteles.core.model.MenuItem;

public interface MenuDAO {
    public void createMenuItem(MenuItem menuItem);

    public MenuItem getMenuItem(int id);

    public boolean updateMenuItem(int id);
    public boolean updateMenuItem(MenuItem menuItem);

    public boolean deleteMenuItem(int id);
    public boolean deleteMenuItem(MenuItem menuItem);
}
