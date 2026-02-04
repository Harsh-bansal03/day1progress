package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.service.impl.SupplierServiceImplArraylist;
import com.edutech.progressive.service.impl.SupplierServiceImplJpa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    private final SupplierServiceImplJpa jpaService;
    private final SupplierServiceImplArraylist arrayListService;

    public SupplierController(SupplierServiceImplJpa jpaService,
                              SupplierServiceImplArraylist arrayListService) {
        this.jpaService = jpaService;
        this.arrayListService = arrayListService;
    }

    // ---------- JPA ENDPOINTS ----------

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        return ResponseEntity.ok(jpaService.getAllSuppliers());
    }

    @GetMapping("/{supplierId}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable int supplierId) {
        Supplier supplier = jpaService.getSupplierById(supplierId);
        if (supplier == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(supplier);
    }

    @PostMapping
    public ResponseEntity<Integer> addSupplier(@RequestBody Supplier supplier) {
        try {
            int id = jpaService.addSupplier(supplier);
            return ResponseEntity.status(HttpStatus.CREATED).body(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{supplierId}")
    public ResponseEntity<Void> updateSupplier(
            @PathVariable int supplierId,
            @RequestBody Supplier supplier) {
        try {
            supplier.setSupplierId(supplierId);
            jpaService.updateSupplier(supplier);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{supplierId}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable int supplierId) {
        try {
            jpaService.deleteSupplier(supplierId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // ---------- ARRAYLIST ENDPOINTS ----------

    // @GetMapping("/fromArrayList")
    // public ResponseEntity<List<Supplier>> getAllSuppliersFromArrayList() {
    //     return ResponseEntity.ok(arrayListService.getAllSuppliers());
    // }

    // @PostMapping("/toArrayList")
    // public ResponseEntity<Integer> addSupplierToArrayList(@RequestBody Supplier supplier) {
    //     int size = arrayListService.addSupplier(supplier);
    //     return ResponseEntity.status(HttpStatus.CREATED).body(size);
    // }

    // @GetMapping("/fromArrayList/all")
    // public ResponseEntity<List<Supplier>> getAllSuppliersSortedByNameFromArrayList() {
    //     return ResponseEntity.ok(arrayListService.getAllSuppliersSortedByName());
    // }
}
