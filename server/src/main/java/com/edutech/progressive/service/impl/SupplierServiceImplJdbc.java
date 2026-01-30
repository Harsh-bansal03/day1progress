package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.edutech.progressive.dao.SupplierDAO;
import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.service.SupplierService;

public class SupplierServiceImplJdbc implements SupplierDAO,SupplierService {

    SupplierDAO supplierDAO;

    public SupplierServiceImplJdbc(SupplierDAO supplierDAO)throws SQLException {
        this.supplierDAO = supplierDAO;
    }

    @Override
    public int addSupplier(Supplier supplier)  {
        // TODO Auto-generated method stub
        return -1;
    }

    @Override
    public Supplier getSupplierById(int supplierId) throws SQLException{
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateSupplier(Supplier supplier) throws SQLException{
        // TODO Auto-generated method stub
     
    }

    @Override
    public void deleteSupplier(int supplierId)throws SQLException {
        // TODO Auto-generated method stub
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Supplier> getAllSuppliersSortedByName() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
}