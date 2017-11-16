package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.model.MenuItem;
import com.github.dugasz1.szoftverteszteles.core.service.MenuService;
import com.github.dugasz1.szoftverteszteles.service.dao.MenuDAO;

public class MenuServiceImpl implements MenuService{
    private MenuDAO menuDao = null;

    public MenuServiceImpl(MenuDAO menuDAO){this.menuDao = menuDAO;}

    public void createMenuItem(MenuItem menuItem) {
        menuDao.createMenuItem(menuItem);
    }

    public MenuItem getMenuItem(int id){
        return menuDao.getMenuItem(id);
    }

    public boolean updateMenuItem(int id) {
        return menuDao.updateMenuItem(id);
    }

    public boolean updateMenuItem(MenuItem menuItem) {
        return menuDao.updateMenuItem(menuItem);
    }

    public boolean deleteMenuItem(int id) {
        return deleteMenuItem(id);
    }

    public boolean deleteMenuItem(MenuItem menuItem) {
        return deleteMenuItem(menuItem);
    }
}
