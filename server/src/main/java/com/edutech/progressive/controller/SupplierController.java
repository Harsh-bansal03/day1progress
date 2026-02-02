package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.service.SupplierService;
import com.edutech.progressive.service.impl.SupplierServiceImplArraylist;
import com.edutech.progressive.service.impl.SupplierServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    private final SupplierService jpaService = new SupplierServiceImplJpa();
    // private final SupplierService arrayListService = new SupplierServiceImplArraylist();
    @Autowired
    private final SupplierServiceImplArraylist arrayListService;

    // JPA-based endpoints

    public SupplierController(SupplierServiceImplArraylist arrayListService) {
        this.arrayListService = arrayListService;
    }

    @GetMapping
    public List<Supplier> getAllSuppliers() throws SQLException {
        return jpaService.getAllSuppliers();
    }

    @GetMapping("/{supplierId}")
    public Supplier getSupplierById(@PathVariable int supplierId) throws SQLException {
        return jpaService.getSupplierById(supplierId);
    }

    @PostMapping
    public int addSupplier(@RequestBody Supplier supplier) throws SQLException {
        return jpaService.addSupplier(supplier);
    }

    @PutMapping("/{supplierId}")
    public void updateSupplier(
            @PathVariable int supplierId,
            @RequestBody Supplier supplier) throws SQLException {
        supplier.setSupplierId(supplierId);
        jpaService.updateSupplier(supplier);
    }

    @DeleteMapping("/{supplierId}")
    public void deleteSupplier(@PathVariable int supplierId) throws SQLException {
        jpaService.deleteSupplier(supplierId);
    }

    // ArrayList-based endpoints (Day-2 data exposure)

    @GetMapping("/fromArrayList")
    public List<Supplier> getAllSuppliersFromArrayList() throws SQLException {
        return arrayListService.getAllSuppliers();
    }

    @GetMapping("/fromArrayList/all")
    public List<Supplier> getAllSuppliersSortedByNameFromArrayList() throws SQLException {
        return arrayListService.getAllSuppliersSortedByName();
    }

    @PostMapping("/toArrayList")
    @ResponseStatus(HttpStatus.CREATED)
    public int addSupplierToArrayList(@RequestBody Supplier supplier) throws SQLException {
        return arrayListService.addSupplier(supplier);
    }
    
}
