package com.edutech.progressive.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.entity.Supplier;

public class SupplierDAOImpl implements SupplierDAO{

    @Override
    public int addSupplier(Supplier supplier) throws SQLException {
        // TODO Auto-generated method stub
        return supplier.getSupplierId();
    }

    @Override
    public Supplier getSupplierById(int supplierId) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateSupplier(Supplier supplier) throws SQLException{
        // TODO Auto-generated method stub
    
    }

    @Override
    public void deleteSupplier(int supplierId) throws SQLException{
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Supplier> getAllSuppliers()throws SQLException {
        // TODO Auto-generated method stub
        return new ArrayList<>();
    }

}
