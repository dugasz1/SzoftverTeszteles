package com.github.dugasz1.szoftverteszteles.core.service;

import com.github.dugasz1.szoftverteszteles.core.model.MenuItem;

public interface MenuService {

    void createMenuItem(MenuItem menuItem);

    MenuItem getMenuItem(int id);

    boolean updateMenuItem(int id);

    boolean updateMenuItem(MenuItem recipe);

    boolean deleteMenuItem(int id);

    boolean deleteMenuItem(MenuItem recipe);
}
