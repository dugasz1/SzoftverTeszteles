package com.github.dugasz1.szoftverteszteles.core.order;

import com.github.dugasz1.szoftverteszteles.core.menu.MenuItem;

import java.util.Collection;
import java.util.Date;
import java.util.Dictionary;

public class Order {
    private int id;
    private Date date;
    private int complited;      //suggesting variable name change to "completed" and type to "boolean"
    private Collection<MenuItem> menuItems;

    public Order(int id, Date date, Collection<MenuItem> menuItems){
        if(date == null)
            throw new NullPointerException("Date can not be null.");
        if(menuItems == null)
            throw new NullPointerException("Menuitem collection can not be null.");
        if(menuItems.isEmpty())
            throw new IllegalArgumentException("Menuitem collection can not be empty.");

        this.id = id;
        this.date = date;
        this.menuItems = menuItems;
    }

    float CalculateTotalPrice(){
        float totalprice = 0;
        for (MenuItem menuItem: menuItems) {
            totalprice += menuItem.getPrice();
        }
        return totalprice;
    }
}
