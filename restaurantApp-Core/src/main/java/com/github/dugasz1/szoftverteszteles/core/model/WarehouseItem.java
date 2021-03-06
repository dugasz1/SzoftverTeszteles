package com.github.dugasz1.szoftverteszteles.core.model;

import com.github.dugasz1.szoftverteszteles.core.exceptions.NoIngredientItemException;
import com.github.dugasz1.szoftverteszteles.core.model.User;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NoDateException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NoUserException;
import com.github.dugasz1.szoftverteszteles.core.model.IngredientItem;

import java.util.Date;

public class WarehouseItem {
    private int id;
    private IngredientItem ingredientItem;
    private User user;
    private Date registered;
    private Date warrant;

    public WarehouseItem(int id, IngredientItem ingredientItem, User user, Date registered, Date warrant) throws NoIngredientItemException, NoDateException, NoUserException {
        this.id = id;
        setIngredientItem(ingredientItem);
        setUser(user);
        setRegistered(registered);
        setWarrant(warrant);
    }

    public int getId(){
        return this.id;
    }

    public IngredientItem getIngredientItem() {
        return ingredientItem;
    }

    public void setIngredientItem(IngredientItem ingredientItem) throws NoIngredientItemException {
        if ( ingredientItem == null )
            throw new NoIngredientItemException("Ingredient item can not be null.");
        this.ingredientItem = ingredientItem;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) throws NoUserException {
        if( user == null )
            throw new NoUserException("User can not be null.");
        this.user = user;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) throws NoDateException {
        if( registered == null)
            throw new NoDateException("Registered date can not be null.");
        this.registered = registered;
    }

    public Date getWarrant() {
        return warrant;
    }

    public void setWarrant(Date warrant) throws NoDateException {
        if( warrant == null )
            throw new NoDateException("Warrant date can not be null.");
        this.warrant = warrant;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;

        WarehouseItem wItem = (WarehouseItem)obj;
        if(this.id != wItem.id || !this.ingredientItem.equals(wItem.ingredientItem) || !this.registered.equals(wItem.registered) ||
                !this.warrant.equals(wItem.warrant) || !this.user.equals(wItem.user))
            return false;
        return true;
    }
}
