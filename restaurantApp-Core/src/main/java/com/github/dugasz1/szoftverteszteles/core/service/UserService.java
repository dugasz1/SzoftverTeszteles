package com.github.dugasz1.szoftverteszteles.core.service;

import com.github.dugasz1.szoftverteszteles.core.model.User;

public interface UserService {
    /**
     * Create a user and save it in the database.
     *
     * @param name
     * @return The user. null if username already exist.
     * @throws - If can't reach data.
     */
    User createUser(String name);

    /**
     * Get the user from the database
     *
     * @param id
     * @return The user. If user is not exist then null.
     * @throws - If can't reach date.
     */
    User getUser(int id);

    User getUser(String name);

    boolean updateUser(User id);

    /**
     * @param id
     * @return True if delete was successfull, false if id does not exist.
     * @throws - If can't reach data.
     */
    boolean deleteUser(int id);

    boolean deleteUser(User user);

}
