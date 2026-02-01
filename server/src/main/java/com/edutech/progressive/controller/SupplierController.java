package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.service.SupplierService;
import com.edutech.progressive.service.impl.SupplierServiceImplArraylist;
import com.edutech.progressive.service.impl.SupplierServiceImplJpa;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    private final SupplierService jpaService = new SupplierServiceImplJpa();
    private final SupplierService arrayListService = new SupplierServiceImplArraylist();

    // JPA-based endpoints

    @GetMapping
    public List<Supplier> getAllSuppliers() {
        return jpaService.getAllSuppliers();
    }

    @GetMapping("/{supplierId}")
    public Supplier getSupplierById(@PathVariable int supplierId) {
        return jpaService.getSupplierById(supplierId);
    }

    @PostMapping
    public int addSupplier(@RequestBody Supplier supplier) {
        return jpaService.addSupplier(supplier);
    }

    @PutMapping("/{supplierId}")
    public void updateSupplier(
            @PathVariable int supplierId,
            @RequestBody Supplier supplier) {
        supplier.setSupplierId(supplierId);
        jpaService.updateSupplier(supplier);
    }

    @DeleteMapping("/{supplierId}")
    public void deleteSupplier(@PathVariable int supplierId) {
        jpaService.deleteSupplier(supplierId);
    }

    // ArrayList-based endpoints (Day-2 data exposure)

    @GetMapping("/fromArrayList")
    public List<Supplier> getAllSuppliersFromArrayList() {
        return arrayListService.getAllSuppliers();
    }

    @GetMapping("/fromArrayList/all")
    public List<Supplier> getAllSuppliersSortedByNameFromArrayList() {
        return arrayListService.getAllSuppliersSortedByName();
    }

    @PostMapping("/toArrayList")
    public int addSupplierToArrayList(@RequestBody Supplier supplier) {
        return arrayListService.addSupplier(supplier);
    }
}
