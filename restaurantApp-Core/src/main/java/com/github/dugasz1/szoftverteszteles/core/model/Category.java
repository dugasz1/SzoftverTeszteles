package com.github.dugasz1.szoftverteszteles.core.model;

import com.github.dugasz1.szoftverteszteles.core.exceptions.IllegalIdException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NoNameException;

public class Category {
    private int id;
    private String name;

    /**
     * Creates Category object, do not use this use the dao interface.
     *
     * @param id
     * @param name
     */
    public Category(int id, String name) throws NoNameException, IllegalIdException {
        setId(id);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws NoNameException {
        if (name == null)
            throw new NoNameException("Name cannot be empty.");
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws IllegalIdException {
        if (id < 0)
            throw new IllegalIdException("Illegal ID number.");
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Category category = (Category) obj;
        if (this.id != category.id || !this.name.equals(category.name))
            return false;
        return true;
    }
}
