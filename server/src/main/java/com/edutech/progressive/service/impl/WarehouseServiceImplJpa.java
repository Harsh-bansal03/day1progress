package com.edutech.progressive.service.impl;

import com.edutech.progressive.entity.Warehouse;
import com.edutech.progressive.service.WarehouseService;

import java.sql.SQLException;
import java.util.List;

public class WarehouseServiceImplJpa implements WarehouseService {

    @Override
    public List<Warehouse> getAllWarehouses() {
        return List.of();
    }

    @Override
    public int addWarehouse(Warehouse warehouse) {
        return -1;
    }

    @Override
    public List<Warehouse> getWarehousesSortedByCapacity() {
        return List.of();
    }

    @Override
    public void updateWarehouse(Warehouse warehouse) {
        // placeholder
    }

    @Override
    public void deleteWarehouse(int warehouseId) {
        // placeholder
    }

    @Override
    public Warehouse getWarehouseById(int warehouseId) {
        return null;
    }

    @Override
    public List<Warehouse> getWarehouseBySupplier(int supplierId) {
        return null;
    }

    @Override
    public void emptyArrayList() {
        // not applicable for JPA
    }

    @Override
    public List<Warehouse> getWarehousesSortedByName() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getWarehousesSortedByName'");
    }
}
