package com.github.dugasz1.szoftverteszteles.core.model;

public class User {
    private int id;
    private String name;

    /**
     * Creater User object, use the DAO interface instead of this!
     * @param id - authentication number for the user
     * @param name - username
     */
    public User ( int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
