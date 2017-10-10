package com.github.dugasz1.szoftverteszteles.core.order;

import com.github.dugasz1.szoftverteszteles.core.menu.MenuItem;

import java.util.Collection;
import java.util.Date;

public class Order {
    private int id;
    private Date date;
    private boolean completed;
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

    /**
     * Calculates the sum of the prices of the ordered meals
     * @return totalprice - the sum of the prices
     */
    public float calculateTotalPrice(){
        float totalprice = 0;
        for (MenuItem menuItem: menuItems) {
            totalprice += menuItem.getPrice();
        }
        return totalprice;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Collection<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(Collection<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}