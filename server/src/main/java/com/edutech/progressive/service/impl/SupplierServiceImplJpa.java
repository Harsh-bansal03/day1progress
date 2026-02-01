package com.edutech.progressive.service.impl;

import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.service.SupplierService;

import java.util.ArrayList;
import java.util.List;

public class SupplierServiceImplJpa implements SupplierService {

    @Override
    public List<Supplier> getAllSuppliers() {
        return new ArrayList<>();
    }

    @Override
    public int addSupplier(Supplier supplier) {
        return -1;
    }

    @Override
    public List<Supplier> getAllSuppliersSortedByName() {
        return new ArrayList<>();
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        // placeholder
    }

    @Override
    public void deleteSupplier(int supplierId) {
        // placeholder
    }

    @Override
    public Supplier getSupplierById(int supplierId) {
        return null;
    }

    @Override
    public void emptyArrayList() {
        // not applicable here
    }
}
