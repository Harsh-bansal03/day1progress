package com.edutech.progressive.service.impl;

import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.repository.SupplierRepository;
import com.edutech.progressive.service.SupplierService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Service
public class SupplierServiceImplJpa implements SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierServiceImplJpa(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public int addSupplier(Supplier supplier) {
        Supplier saved = supplierRepository.save(supplier);
        return saved.getSupplierId();
    }

    @Override
    public List<Supplier> getAllSuppliersSortedByName() {
        List<Supplier> suppliers = supplierRepository.findAll();
        Collections.sort(suppliers);
        return suppliers;
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public void deleteSupplier(int supplierId) {
        supplierRepository.deleteBySupplierId(supplierId);
    }

    @Override
    public Supplier getSupplierById(int supplierId) {
        return supplierRepository.findBySupplierId(supplierId);
    }

    @Override
    public void emptyArrayList() {
        // not applicable for JPA
    }
}
