package com.github.dugasz1.szoftverteszteles.service.dao;

import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.AlreadyExistingException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.NotFoundException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageNotAvailableException;
import com.github.dugasz1.szoftverteszteles.core.model.User;

public interface UserDAO {
    /**
     * Create a user and save it in the database.
     * @param name
     * @return The user. null if username already exist.
     * @exception StorageNotAvailableException If can't reach data.
     */
    User createUser(String name ) throws StorageNotAvailableException, AlreadyExistingException, StorageException;

    /**
     * Get the user from the database
     * @param id
     * @return The user. If user is not exist then null.
     * @throws StorageNotAvailableException If can't reach date.
     */
    User getUser( int id ) throws StorageNotAvailableException, StorageException, NotFoundException;
    User getUser( String name ) throws StorageNotAvailableException, NotFoundException, StorageException;

    boolean updateUser(User user) throws StorageNotAvailableException, AlreadyExistingException, StorageException, NotFoundException;

    /**
     *
     * @param id
     * @return True if delete was successfull, false if id does not exist.
     * @throws StorageNotAvailableException If can't reach data.
     */
    boolean deleteUser (int id ) throws StorageNotAvailableException, StorageException, NotFoundException;
    boolean deleteUser( User user ) throws StorageNotAvailableException, NotFoundException, StorageException;

}
