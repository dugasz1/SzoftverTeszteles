package com.github.dugasz1.szoftverteszteles.core.service;

import com.github.dugasz1.szoftverteszteles.core.model.MenuItem;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.*;

public interface MenuService {

    void createMenuItem(MenuItem menuItem) throws StorageProblemException, MenuItemAlreadyExistException, MissingArgumentException;

    MenuItem getMenuItem(int id) throws StorageProblemException, MenuItemNotFoundException, MissingArgumentException;

    boolean updateMenuItem(MenuItem recipe) throws StorageProblemException, MenuItemNotFoundException;

    boolean deleteMenuItem(int id) throws StorageProblemException, MenuItemNotFoundException;

    boolean deleteMenuItem(MenuItem recipe) throws StorageProblemException, MenuItemNotFoundException;
}
