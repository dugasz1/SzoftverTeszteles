package com.github.dugasz1.szoftverteszteles.core.order;

import com.github.dugasz1.szoftverteszteles.core.menu.MenuItem;

import java.util.Collection;
import java.util.Date;
import java.util.Dictionary;

public class Order {
    private int id;
    private Date date;
    private int complited;
    private Collection<MenuItem> menuItems;

    public Order(int id, Date date, Collection<MenuItem> menuItems){

    }

    float CalculateTotalPrice(){
        //TODO: implement
        return 0;
    }
}
