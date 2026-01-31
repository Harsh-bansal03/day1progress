package com.edutech.progressive.dao;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Warehouse;
public class WarehouseDAOImpl implements WarehouseDAO {

    @Override
    public int addWarehouse(Warehouse warehouse) throws SQLException {
        String sql = "INSERT INTO warehouse (supplier_id, warehouse_name, location, capacity) VALUES (?,?,?,?)";
        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, warehouse.getSupplierId());
            ps.setString(2, warehouse.getWarehouseName());
            ps.setString(3, warehouse.getLocation());
            ps.setInt(4, warehouse.getCapacity());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            return rs.next() ? rs.getInt(1) : -1;
        }
    }

    @Override
    public Warehouse getWarehouseById(int warehouseId) throws SQLException {
        String sql = "SELECT * FROM warehouse WHERE warehouse_id=?";
        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, warehouseId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Warehouse(
                        rs.getInt("warehouse_id"),
                        rs.getInt("supplier_id"),
                        rs.getString("warehouse_name"),
                        rs.getString("location"),
                        rs.getInt("capacity")
                );
            }
        }
        return null;
    }

    @Override
    public void updateWarehouse(Warehouse warehouse) throws SQLException {
        String sql = "UPDATE warehouse SET supplier_id=?, warehouse_name=?, location=?, capacity=? WHERE warehouse_id=?";
        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, warehouse.getSupplierId());
            ps.setString(2, warehouse.getWarehouseName());
            ps.setString(3, warehouse.getLocation());
            ps.setInt(4, warehouse.getCapacity());
            ps.setInt(5, warehouse.getWarehouseId());
            ps.executeUpdate();
        }
    }

    @Override
    public void deleteWarehouse(int warehouseId) throws SQLException {
        String sql = "DELETE FROM warehouse WHERE warehouse_id=?";
        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, warehouseId);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Warehouse> getAllWarehouse() throws SQLException {
        List<Warehouse> list = new ArrayList<>();
        String sql = "SELECT * FROM warehouse";

        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Warehouse(
                        rs.getInt("warehouse_id"),
                        rs.getInt("supplier_id"),
                        rs.getString("warehouse_name"),
                        rs.getString("location"),
                        rs.getInt("capacity")
                ));
            }
        }
        return list;
    }
}
