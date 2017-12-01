package com.github.dugasz1.szoftverteszteles.core.service;

import com.github.dugasz1.szoftverteszteles.core.model.User;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.ExistingProblemException;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.MissingArgumentException;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.StorageProblemException;

public interface UserService {

    /**
     * Create a user and save it in the database.
     *
     * @param name
     * @return The user. null if username already exist.
     * @throws StorageProblemException  If can't reach data.
     * @throws ExistingProblemException If can't reach data.
     * @throws MissingArgumentException If the format or the value of the <param>name</param> is wrong
     */
    User createUser(String name) throws StorageProblemException, ExistingProblemException, MissingArgumentException;

    /**
     * Get the user from the database
     *
     * @param id
     * @return The user. If user is not exist then null.
     * @throws - If can't reach date.
     */
    User getUser(int id) throws StorageProblemException, ExistingProblemException, MissingArgumentException;

    User getUser(String name) throws StorageProblemException, ExistingProblemException, MissingArgumentException;

    boolean updateUser(User id) throws StorageProblemException, ExistingProblemException;

    /**
     * @param id
     * @return True if delete was successfull, false if id does not exist.
     * @throws - If can't reach data.
     */
    boolean deleteUser(int id) throws StorageProblemException, ExistingProblemException;

    boolean deleteUser(User user) throws StorageProblemException, ExistingProblemException;

}
