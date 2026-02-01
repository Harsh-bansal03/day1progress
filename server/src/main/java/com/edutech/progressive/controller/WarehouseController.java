package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Warehouse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouses")
public class WarehouseController {

    @GetMapping
    public ResponseEntity<List<Warehouse>> getAllWarehouses() {
        return null;
    }

    @GetMapping("/{warehouseId}")
    public ResponseEntity<Warehouse> getWarehouseById(@PathVariable int warehouseId) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Integer> addWarehouse(@RequestBody Warehouse warehouse) {
        return null;
    }

    @PutMapping("/{warehouseId}")
    public ResponseEntity<Void> updateWarehouse(
            @PathVariable int warehouseId,
            @RequestBody Warehouse warehouse) {
        return null;
    }

    @DeleteMapping("/{warehouseId}")
    public ResponseEntity<Void> deleteWarehouse(@PathVariable int warehouseId) {
        return null;
    }

    @GetMapping("/supplier/{supplierId}")
    public ResponseEntity<List<Warehouse>> getWarehousesBySupplier(
            @PathVariable int supplierId) {
        return null;
    }
}
