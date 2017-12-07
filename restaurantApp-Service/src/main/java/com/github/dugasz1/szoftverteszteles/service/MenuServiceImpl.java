package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.exceptions.NoCategoryException;
import com.github.dugasz1.szoftverteszteles.core.model.MenuItem;
import com.github.dugasz1.szoftverteszteles.core.service.MenuService;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.*;
import com.github.dugasz1.szoftverteszteles.service.dao.MenuItemDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.*;

import java.awt.*;

/*
 *TODO: Implement it!
 */
public class MenuServiceImpl implements MenuService {

    private MenuItemDAO menuDao;

    public MenuServiceImpl(MenuItemDAO menuDAO) {
        this.menuDao = menuDAO;
    }

    @Override
    public void createMenuItem(MenuItem menuItem) throws MenuItemAlreadyExistException, StorageProblemException, MissingArgumentException {
        try {
            menuDao.createMenuItem(menuItem);
        } catch (AlreadyExistingException e) {
            throw new MenuItemAlreadyExistException(e);
        } catch (StorageException | StorageNotAvailableException e) {
            throw new StorageProblemException(e);
        }
    }

    @Override
    public MenuItem getMenuItem(int id) throws MenuItemNotFoundException, StorageProblemException, MissingArgumentException {
        try {
            return menuDao.getMenuItem(id);
        } catch (NotFoundException e) {
            throw new MenuItemNotFoundException(e);
        } catch (StorageException | StorageNotAvailableException e) {
            throw new StorageProblemException(e);
        } catch (NoCategoryException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateMenuItem(int id) throws StorageProblemException, MenuItemNotFoundException {
        return false;
    }

    @Override
    public boolean updateMenuItem(MenuItem menuItem) throws MenuItemNotFoundException, StorageProblemException {
        try {
            return menuDao.updateMenuItem(menuItem);
        } catch (NotFoundException | AlreadyExistingException e) {
            throw new MenuItemNotFoundException(e);
        } catch (StorageNotAvailableException | StorageException e) {
            throw new StorageProblemException(e);
        }
    }

    @Override
    public boolean deleteMenuItem(int id) throws MenuItemNotFoundException, StorageProblemException {
        try {
            return menuDao.deleteMenuItem(id);
        } catch (NotFoundException e) {
            throw new MenuItemNotFoundException(e);
        } catch (StorageNotAvailableException | StorageException e) {
            throw new StorageProblemException(e);
        }
    }

    @Override
    public boolean deleteMenuItem(MenuItem menuItem) throws MenuItemNotFoundException, StorageProblemException {
        try {
            return menuDao.deleteMenuItem(menuItem);
        } catch (NotFoundException e) {
            throw new MenuItemNotFoundException(e);
        } catch (StorageNotAvailableException | StorageException e) {
            throw new StorageProblemException(e);
        }
    }
}
