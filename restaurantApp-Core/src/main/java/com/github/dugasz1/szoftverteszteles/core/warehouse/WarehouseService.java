package com.github.dugasz1.szoftverteszteles.core.warehouse;

import com.github.dugasz1.szoftverteszteles.core.order.Order;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

public interface WarehouseService {

    /**
     * Collets How much ingredient will be consumed by the order.
     * @param order The order.
     * @return
     */
    public Map<WarehouseItem, Float> CalculateOrderConsume(Order order);

    public Collection<WarehouseItem> GetCloseToWarrant(Date date);
    
}
