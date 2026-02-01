package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Supplier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        return null;
    }

    @GetMapping("/{supplierId}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable int supplierId) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Integer> addSupplier(@RequestBody Supplier supplier) {
        return null;
    }

    @PutMapping("/{supplierId}")
    public ResponseEntity<Void> updateSupplier(
            @PathVariable int supplierId,
            @RequestBody Supplier supplier) {
        return null;
    }

    @DeleteMapping("/{supplierId}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable int supplierId) {
        return null;
    }

    @GetMapping("/arraylist")
    public ResponseEntity<List<Supplier>> getAllSuppliersFromArrayList() {
        return null;
    }

    @PostMapping("/arraylist")
    public ResponseEntity<Integer> addSupplierToArrayList(
            @RequestBody Supplier supplier) {
        return null;
    }

    @GetMapping("/arraylist/sorted")
    public ResponseEntity<List<Supplier>> getAllSuppliersSortedByNameFromArrayList() {
        return null;
    }
}
