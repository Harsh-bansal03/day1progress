package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.edutech.progressive.dao.WarehouseDAO;
import com.edutech.progressive.entity.Warehouse;
import com.edutech.progressive.service.WarehouseService;

public class WarehouseServiceImplJdbc implements WarehouseDAO,WarehouseService {

    private WarehouseDAO warehouseDAO;
    
    public WarehouseServiceImplJdbc(WarehouseDAO warehouseDAO)throws SQLException {
        this.warehouseDAO = warehouseDAO;
    }

    @Override
    public int addWarehouse(Warehouse warehouse){
        // TODO Auto-generated method stub
        return -1;
    }

    @Override
    public Warehouse getWarehouseById(int warehouseId) throws SQLException{
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateWarehouse(Warehouse warehouse)throws SQLException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteWarehouse(int warehouseId) throws SQLException{
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Warehouse> getAllWarehouse() throws SQLException{
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public List<Warehouse> getWarehousesSortedByCapacity()throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Warehouse> getAllWarehouses() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Warehouse> getWarehousesSortedByName()throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}