package com.github.dugasz1.szoftverteszteles.core.warehouse;

import com.github.dugasz1.szoftverteszteles.core.order.Order;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

public interface WarehouseService {

    /**
     * Collects how much ingredient will be consumed by the order.
     * @param order The order.
     * @return
     */
    public Map<WarehouseItem, Float> calculateOrderConsume(Order order);

    public Collection<WarehouseItem> getCloseToWarrant(Date date);
    
}
