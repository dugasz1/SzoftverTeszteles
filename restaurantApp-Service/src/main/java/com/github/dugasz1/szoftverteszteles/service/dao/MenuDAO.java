package com.github.dugasz1.szoftverteszteles.service.dao;

import com.github.dugasz1.szoftverteszteles.core.model.MenuItem;

public interface MenuDAO {
    void createMenuItem(MenuItem menuItem);

    MenuItem getMenuItem(int id);

    boolean updateMenuItem(int id);
    boolean updateMenuItem(MenuItem menuItem);

    boolean deleteMenuItem(int id);
    boolean deleteMenuItem(MenuItem menuItem);
}
