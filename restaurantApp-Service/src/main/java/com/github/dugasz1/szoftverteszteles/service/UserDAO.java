package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.model.User;

public interface UserDAO {
    /**
     * Create a user and save it in the database.
     * @param name
     * @return The user. null if username already exist.
     * @exception DatabaseNotAvaibleException If can't reach database.
     */
    User createUser(String name, String password ) throws DatabaseNotAvaibleException, AlreadyExistingException, DatabaseException;

    /**
     * Get the user from the database
     * @param id
     * @return The user. If user is not exist then null.
     * @throws DatabaseNotAvaibleException If can't reach database.
     */
    User getUser( int id ) throws DatabaseNotAvaibleException, DatabaseException, NotFoundException;
    User getUser( String name ) throws DatabaseNotAvaibleException, NotFoundException, DatabaseException;

    boolean Update(User id) throws DatabaseNotAvaibleException, AlreadyExistingException, DatabaseException, NotFoundException;

    /**
     *
     * @param id
     * @return True if delete was successfull, false if id does not exist.
     * @throws DatabaseNotAvaibleException If can't reach database.
     */
    boolean deleteUser (int id ) throws DatabaseNotAvaibleException, DatabaseException, NotFoundException;
    boolean deleteUser( User user ) throws DatabaseNotAvaibleException, NotFoundException, DatabaseException;

    /*User LoginUser ( String name, String password );
    boolean LogoutUser ( User user ); //Don't know is it needed. How sessions works?*/
}
