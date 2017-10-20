package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.exceptions.AlreadyExistingException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NotFoundException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.StorageException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.StorageNotAvaibleException;
import com.github.dugasz1.szoftverteszteles.core.model.User;
import com.github.dugasz1.szoftverteszteles.core.service.UserService;
import com.github.dugasz1.szoftverteszteles.service.dao.UserDAO;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = null;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User createUser(String name) throws StorageNotAvaibleException, AlreadyExistingException, StorageException {
        return userDAO.createUser(name);
    }

    public User getUser(int id) throws StorageNotAvaibleException, StorageException, NotFoundException {
        return userDAO.getUser(id);
    }

    public User getUser(String name) throws StorageNotAvaibleException, NotFoundException, StorageException {
        return userDAO.getUser(name);
    }

    public boolean updateUser(User user) throws StorageNotAvaibleException, AlreadyExistingException, StorageException, NotFoundException {
        return userDAO.updateUser(user);
    }

    public boolean deleteUser(int id) throws StorageNotAvaibleException, StorageException, NotFoundException {
        return userDAO.deleteUser(id);
    }

    public boolean deleteUser(User user) throws StorageNotAvaibleException, NotFoundException, StorageException {
        return userDAO.deleteUser(user);
    }
}
