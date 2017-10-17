package com.github.dugasz1.szoftverteszteles.core.service;

import com.github.dugasz1.szoftverteszteles.core.model.MenuItem;

public interface MenuService {

    public MenuItem getMenuItem(int id);

    public boolean updateMenuItem(int id);
    public boolean updateMenuItem(MenuItem recipe);

    public boolean deleteMenuItem(int id);
    public boolean deleteMenuItem(MenuItem recipe);
}
