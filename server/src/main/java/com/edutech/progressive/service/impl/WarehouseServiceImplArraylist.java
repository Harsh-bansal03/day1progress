package com.edutech.progressive.service.impl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.edutech.progressive.entity.Warehouse;
import com.edutech.progressive.service.WarehouseService;

public class WarehouseServiceImplArraylist implements WarehouseService {

    private List<Warehouse> warehouses = new ArrayList<>();

    public List<Warehouse> getAllWarehouses() {
        return warehouses;
    }

    public int addWarehouse(Warehouse warehouse) {
        warehouses.add(warehouse);
        return warehouses.size();
    }

    public List<Warehouse> getWarehousesSortedByCapacity() {
        List<Warehouse> list = new ArrayList<>(warehouses);
        Collections.sort(list);
        return list;
    }

    public void emptyArrayList() {
        warehouses.clear();
    }

    @Override
    public List<Warehouse> getWarehousesSortedByName() {
        // TODO Auto-generated method stub
       // List<Warehouse> sortedList=new ArrayList<>(warehouseList);
        Comparator<Warehouse> wareHouseNameComp = new Comparator<Warehouse>() {
            @Override
            public int compare(Warehouse arg0, Warehouse arg1) {
                return arg0.getWarehouseName().compareTo(arg1.getWarehouseName());
            }
        };
        Collections.sort(warehouses,wareHouseNameComp);
        return warehouses;
    }
}
