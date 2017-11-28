package com.github.dugasz1.szoftverteszteles.core.model;

import com.github.dugasz1.szoftverteszteles.core.exceptions.EmptyMenuitemException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NoDateException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NoMenuitemException;
import com.github.dugasz1.szoftverteszteles.core.model.MenuItem;

import java.util.Collection;
import java.util.Date;

public class Order {
    private int id;
    private Date date;
    private boolean completed;
    private Collection<MenuItem> menuItems;

    public Order(int id, Date date, Collection<MenuItem> menuItems) throws NoDateException, NoMenuitemException, EmptyMenuitemException {
        this.id = id;
        setDate(date);
        setMenuItems(menuItems);
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

    public void setDate(Date date) throws NoDateException {
        if(date == null)
            throw new NoDateException("Date can not be null.");
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

    public void setMenuItems(Collection<MenuItem> menuItems) throws NoMenuitemException, EmptyMenuitemException {
        if(menuItems == null)
            throw new NoMenuitemException("Menuitem collection can not be null.");
        if(menuItems.isEmpty())
            throw new EmptyMenuitemException("Menuitem collection can not be empty.");
        this.menuItems = menuItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (completed != order.completed) return false;
        if (date != null ? !date.equals(order.date) : order.date != null) return false;
        return menuItems != null ? menuItems.equals(order.menuItems) : order.menuItems == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (completed ? 1 : 0);
        result = 31 * result + (menuItems != null ? menuItems.hashCode() : 0);
        return result;
    }
}