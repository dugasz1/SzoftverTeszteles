package com.github.dugasz1.szoftverteszteles.service.dao;

import com.github.dugasz1.szoftverteszteles.core.model.MenuItem;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.*;

public interface MenuItemDAO {

    void createMenuItem(MenuItem menuItem) throws StorageException, StorageNotAvailableException, AlreadyExistingException;

    MenuItem getMenuItem(int id) throws NotFoundException, StorageException, StorageNotAvailableException;

    boolean updateMenuItem(int id) throws NotFoundException, StorageNotAvailableException, StorageException, AlreadyExistingException;

    boolean updateMenuItem(MenuItem menuItem) throws NotFoundException, StorageNotAvailableException, StorageException, AlreadyExistingException;

    boolean deleteMenuItem(int id) throws NotFoundException, StorageNotAvailableException, StorageException;

    boolean deleteMenuItem(MenuItem menuItem) throws NotFoundException, StorageNotAvailableException, StorageException;
}
