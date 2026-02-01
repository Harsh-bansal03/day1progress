package com.edutech.progressive.service.impl;

import com.edutech.progressive.dao.WarehouseDAO;
import com.edutech.progressive.entity.Warehouse;
import com.edutech.progressive.service.WarehouseService;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

public class WarehouseServiceImplJdbc implements WarehouseService {

    private WarehouseDAO warehouseDAO;

    public WarehouseServiceImplJdbc(WarehouseDAO warehouseDAO) {
        this.warehouseDAO = warehouseDAO;
    }

    @Override
    public List<Warehouse> getAllWarehouses() throws SQLException {
        return warehouseDAO.getAllWarehouse();
    }

    @Override
    public int addWarehouse(Warehouse warehouse) throws SQLException {
        int id = warehouseDAO.addWarehouse(warehouse);
        warehouse.setWarehouseId(id); // REQUIRED
        return id;
    }

    @Override
    public void updateWarehouse(Warehouse warehouse) throws SQLException {
        warehouseDAO.updateWarehouse(warehouse);
    }

    @Override
    public void deleteWarehouse(int warehouseId) throws SQLException {
        warehouseDAO.deleteWarehouse(warehouseId);
    }

    @Override
    public Warehouse getWarehouseById(int warehouseId) throws SQLException {
        return warehouseDAO.getWarehouseById(warehouseId);
    }

    @Override
    public List<Warehouse> getWarehousesSortedByCapacity() throws SQLException {
        List<Warehouse> warehouses = warehouseDAO.getAllWarehouse();
        warehouses.sort(Comparator.comparingInt(Warehouse::getCapacity)); // ASCENDING
        return warehouses;
    }

    @Override
    public List<Warehouse> getWarehousesSortedByName() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getWarehousesSortedByName'");
    }
}
