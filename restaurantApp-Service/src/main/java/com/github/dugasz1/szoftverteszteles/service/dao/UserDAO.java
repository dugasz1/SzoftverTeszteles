package com.github.dugasz1.szoftverteszteles.service.dao;

import com.github.dugasz1.szoftverteszteles.core.model.User;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.*;

public interface UserDAO {

    /**
     * Create a user and save it in the database.
     *
     * @param name
     * @return The user. null if username already exist.
     * @throws StorageNotAvailableException If can't reach data.
     * @throws StorageException             If the storage having problems
     * @throws WrongFormatException         If the format or the value of the <param>name</param> is wrong
     * @throws AlreadyExistingException     If the user already exist
     */
    User createUser(String name) throws StorageException, StorageNotAvailableException, WrongFormatException, AlreadyExistingException;

    /**
     * Get the user from the database
     *
     * @param id
     * @return The user. If user is not exist then null.
     * @throws StorageNotAvailableException If can't reach date.
     */
    User getUser(int id) throws NotFoundException, StorageException, StorageNotAvailableException, WrongFormatException;

    User getUser(String name) throws NotFoundException, StorageException, StorageNotAvailableException, WrongFormatException;

    boolean updateUser(User user) throws NotFoundException, StorageNotAvailableException, StorageException, AlreadyExistingException;

    /**
     * @param id
     * @return True if delete was successfull, false if id does not exist.
     * @throws StorageNotAvailableException If can't reach data.
     */
    boolean deleteUser(int id) throws NotFoundException, StorageNotAvailableException, StorageException;

    boolean deleteUser(User user) throws NotFoundException, StorageNotAvailableException, StorageException;

}
