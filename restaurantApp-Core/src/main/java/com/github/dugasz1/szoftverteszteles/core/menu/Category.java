package com.github.dugasz1.szoftverteszteles.core.menu;

public class Category {
    private int id;
    private String name;

    /**
     * Creates Category object, do not use this use the dao interface.
     * @param id
     * @param name
     */
    public Category(int id, String name){
        if(name == null)
            throw new NullPointerException("Name cannot be null.");
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
