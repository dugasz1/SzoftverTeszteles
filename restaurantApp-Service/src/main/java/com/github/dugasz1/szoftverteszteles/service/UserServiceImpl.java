package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.model.User;
import com.github.dugasz1.szoftverteszteles.core.service.UserService;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.*;
import com.github.dugasz1.szoftverteszteles.service.dao.UserDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.*;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User createUser(String name) throws UserAlreadyExistExpection, StorageProblemException, MissingArgumentException {
        try {
            return userDAO.createUser(name);
        } catch (AlreadyExistingException e) {
            throw new UserAlreadyExistExpection(e);
        } catch (StorageException | StorageNotAvailableException e) {
            throw new StorageProblemException();
        }
    }

    public User getUser(int id) throws UserNotFoundExpection, StorageProblemException, MissingArgumentException {
        try {
            return userDAO.getUser(id);
        } catch (NotFoundException e) {
            throw new UserNotFoundExpection(e);
        } catch (StorageException | StorageNotAvailableException e) {
            throw new StorageProblemException(e);
        }
    }

    public User getUser(String name) throws UserNotFoundExpection, StorageProblemException, MissingArgumentException {
        try {
            return userDAO.getUser(name);
        } catch (NotFoundException e) {
            throw new UserNotFoundExpection(e);
        } catch (StorageException | StorageNotAvailableException e) {
            throw new StorageProblemException();
        }
    }

    public boolean updateUser(User user) throws UserNotFoundExpection, StorageProblemException {
        try {
            return userDAO.updateUser(user);
        } catch (NotFoundException | AlreadyExistingException e) {
            throw new UserNotFoundExpection(e);
        } catch (StorageNotAvailableException | StorageException e) {
            throw new StorageProblemException(e);
        }
    }

    public boolean deleteUser(int id) throws UserNotFoundExpection, StorageProblemException {
        try {
            return userDAO.deleteUser(id);
        } catch (NotFoundException e) {
            throw new UserNotFoundExpection(e);
        } catch (StorageNotAvailableException | StorageException e) {
            throw new StorageProblemException(e);
        }
    }

    public boolean deleteUser(User user) throws UserNotFoundExpection, StorageProblemException {
        try {
            return userDAO.deleteUser(user);
        } catch (NotFoundException e) {
            throw new UserNotFoundExpection(e);
        } catch (StorageNotAvailableException | StorageException e) {
            throw new StorageProblemException();
        }
    }
}