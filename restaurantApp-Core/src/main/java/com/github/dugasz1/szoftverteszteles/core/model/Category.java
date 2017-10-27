package com.github.dugasz1.szoftverteszteles.core.model;

import com.github.dugasz1.szoftverteszteles.core.exceptions.NoCategoryException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NoNameException;

public class Category {
    private int id;
    private String name;

    /**
     * Creates Category object, do not use this use the dao interface.
     * @param id
     * @param name
     */
    public Category(int id, String name)throws NoNameException{
        if(name == null)
            throw new NoNameException("Name cannot be empty.");
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

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Category category = (Category)obj;
        if(this.id != category.id || this.name != category.name)
            return false;
        return true;
    }
}
