package com.github.dugasz1.szoftverteszteles.service.dao;

import com.github.dugasz1.szoftverteszteles.core.exceptions.AlreadyExistingException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NotFoundException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.StorageException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.StorageNotAvaibleException;
import com.github.dugasz1.szoftverteszteles.core.model.User;

public interface UserDAO {
    /**
     * Create a user and save it in the database.
     * @param name
     * @return The user. null if username already exist.
     * @exception StorageNotAvaibleException If can't reach data.
     */
    User createUser(String name ) throws StorageNotAvaibleException, AlreadyExistingException, StorageException;

    /**
     * Get the user from the database
     * @param id
     * @return The user. If user is not exist then null.
     * @throws StorageNotAvaibleException If can't reach date.
     */
    User getUser( int id ) throws StorageNotAvaibleException, StorageException, NotFoundException;
    User getUser( String name ) throws StorageNotAvaibleException, NotFoundException, StorageException;

    boolean updateUser(User user) throws StorageNotAvaibleException, AlreadyExistingException, StorageException, NotFoundException;

    /**
     *
     * @param id
     * @return True if delete was successfull, false if id does not exist.
     * @throws StorageNotAvaibleException If can't reach data.
     */
    boolean deleteUser (int id ) throws StorageNotAvaibleException, StorageException, NotFoundException;
    boolean deleteUser( User user ) throws StorageNotAvaibleException, NotFoundException, StorageException;

}
