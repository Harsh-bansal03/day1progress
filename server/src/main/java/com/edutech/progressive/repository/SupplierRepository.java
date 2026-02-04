package com.edutech.progressive.repository;

import com.edutech.progressive.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    Supplier findBySupplierId(@Param("supplierId") int supplierId);

    void deleteBySupplierId(@Param("supplierId") int supplierId);
}
