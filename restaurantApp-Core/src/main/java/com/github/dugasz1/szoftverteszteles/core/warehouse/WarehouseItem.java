package com.github.dugasz1.szoftverteszteles.core.warehouse;

import com.github.dugasz1.szoftverteszteles.core.authorization.User;
import com.github.dugasz1.szoftverteszteles.core.menu.Ingredient;
import com.github.dugasz1.szoftverteszteles.core.menu.IngredientItem;

import java.util.Date;

public class WarehouseItem {
    private int id;
    private IngredientItem ingredientItem;
    private User user;
    private Date registered;
    private Date warrant;

    public WarehouseItem(int id, IngredientItem ingredientItem, User user, Date registered, Date warrant){
        if ( ingredientItem == null )
            throw new NullPointerException("Ingredient item can not be null.");
        if( user == null )
            throw new NullPointerException("User can not be null.");
        if( registered == null)
            throw new NullPointerException("Registered date can not be null.");
        if( warrant == null )
            throw new NullPointerException("Warrant date can not be null.");

        this.id = id;
        this.ingredientItem = ingredientItem;
        this.user = user;
        this.registered = registered;
        this.warrant = warrant;
    }

    public int getId(){
        return this.id;
    }

    public IngredientItem getIngredientItem() {
        return ingredientItem;
    }

    public void setIngredientItem(IngredientItem ingredientItem) {
        this.ingredientItem = ingredientItem;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public Date getWarrant() {
        return warrant;
    }

    public void setWarrant(Date warrant) {
        this.warrant = warrant;
    }
}
