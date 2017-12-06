package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.exceptions.NoCategoryException;
import com.github.dugasz1.szoftverteszteles.core.model.MenuItem;
import com.github.dugasz1.szoftverteszteles.core.service.MenuService;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.ExistingProblemException;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.MissingArgumentException;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.StorageProblemException;
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

    public void createMenuItem(MenuItem menuItem) throws ExistingProblemException, StorageProblemException, MissingArgumentException {
        try {
            menuDao.createMenuItem(menuItem);
        } catch (AlreadyExistingException e) {
            throw new ExistingProblemException();
        } catch (StorageException | StorageNotAvailableException e) {
            throw new StorageProblemException();
        }
    }

    public MenuItem getMenuItem(int id) throws ExistingProblemException, StorageProblemException, MissingArgumentException {
        try {
            return menuDao.getMenuItem(id);
        } catch (NotFoundException e) {
            throw new ExistingProblemException();
        } catch (StorageException | StorageNotAvailableException e) {
            throw new StorageProblemException();
        } catch (NoCategoryException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateMenuItem(int id) throws StorageProblemException, ExistingProblemException {
        return false;
    }

    public boolean updateMenuItem(MenuItem menuItem) throws ExistingProblemException, StorageProblemException {
        try {
            return menuDao.updateMenuItem(menuItem);
        } catch (NotFoundException | AlreadyExistingException e) {
            throw new ExistingProblemException();
        } catch (StorageNotAvailableException | StorageException e) {
            throw new StorageProblemException();
        }
    }

    public boolean deleteMenuItem(int id) throws ExistingProblemException, StorageProblemException {
        try {
            return menuDao.deleteMenuItem(id);
        } catch (NotFoundException e) {
            throw new ExistingProblemException();
        } catch (StorageNotAvailableException | StorageException e) {
            throw new StorageProblemException();
        }
    }

    public boolean deleteMenuItem(MenuItem menuItem) throws ExistingProblemException, StorageProblemException {
        try {
            return menuDao.deleteMenuItem(menuItem);
        } catch (NotFoundException e) {
            throw new ExistingProblemException();
        } catch (StorageNotAvailableException | StorageException e) {
            throw new StorageProblemException();
        }
    }
}
