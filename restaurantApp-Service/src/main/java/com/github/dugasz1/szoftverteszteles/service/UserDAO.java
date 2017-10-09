package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.authorization.*;

public interface UserDAO {
    /**
     * Create a user and save it in the database.
     * @param name
     * @return The user. null if username already exist.
     * @exception DatabaseNotAvaibleException If can't reach database.
     */
    User createUser( String name, String password ) throws DatabaseNotAvaibleException;

    /**
     * Get the user from the database
     * @param id
     * @return The user. If user is not exist then null.
     * @throws DatabaseNotAvaibleException If can't reach database.
     */
    User getUser( int id ) throws DatabaseNotAvaibleException;
    User getUser( String name ) throws MultipleResultException, DatabaseNotAvaibleException;

    boolean Update(User id);

    /**
     *
     * @param id
     * @return True if delete was successfull, false if id does not exist.
     * @throws DatabaseNotAvaibleException If can't reach database.
     */
    boolean deleteUser (int id ) throws DatabaseNotAvaibleException;
    boolean deleteUser( User user ) throws DatabaseNotAvaibleException;

    /*User LoginUser ( String name, String password );
    boolean LogoutUser ( User user ); //Don't know is it needed. How sessions works?*/
}
