package com.edutech.progressive.service;


import com.edutech.progressive.entity.Supplier;

import java.sql.SQLException;
import java.util.List;

public interface SupplierService {
    public List<Supplier> getAllSuppliers() throws SQLException;

    public int addSupplier(Supplier supplier) throws SQLException;

    public List<Supplier> getAllSuppliersSortedByName() throws SQLException;

    default public void emptyArrayList() throws SQLException {
    }

    //Do not implement these methods in SupplierServiceImplArraylist.java class
    default void updateSupplier(Supplier supplier) throws SQLException{
    }

    default void deleteSupplier(int supplierId) throws SQLException {
    }

    default Supplier getSupplierById(int supplierId) throws SQLException {
        return null;
    }

}
