package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.edutech.progressive.dao.SupplierDAO;
import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.service.SupplierService;

public class SupplierServiceImplArraylist  implements SupplierService{

    private List<Supplier> supplierList=new ArrayList<>();
    @Override
    public List<Supplier> getAllSuppliers() {
        // TODO Auto-generated method stub
        return supplierList;
    }

    @Override
    public int addSupplier(Supplier supplier) {
        supplierList.add(supplier);
        return supplierList.size();
    }

    @Override
    public List<Supplier> getAllSuppliersSortedByName() {
        // TODO Auto-generated method stub
        ArrayList<Supplier> sortedList=new ArrayList<>(supplierList);
        Collections.sort(sortedList);
        return sortedList;

    }

    @Override
    public void emptyArrayList() {
        // TODO Auto-generated method stub
        supplierList.clear();;
    }

}