package com.edutech.progressive.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Supplier;
import java.sql.*;

public class SupplierDAOImpl implements SupplierDAO {

    @Override
    public int addSupplier(Supplier supplier) throws SQLException {
        String sql = "INSERT INTO supplier (supplier_name,email,phone,address,username,password,role) VALUES (?,?,?,?,?,?,?)";
        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, supplier.getSupplierName());
            ps.setString(2, supplier.getEmail());
            ps.setString(3, supplier.getPhone());
            ps.setString(4, supplier.getAddress());
            ps.setString(5, supplier.getUsername());
            ps.setString(6, supplier.getPassword());
            ps.setString(7, supplier.getRole());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            return rs.next() ? rs.getInt(1) : -1;
        }
    }

    @Override
    public Supplier getSupplierById(int supplierId) throws SQLException {
        String sql = "SELECT * FROM supplier WHERE supplier_id=?";
        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, supplierId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Supplier s = new Supplier();
                s.setSupplierId(rs.getInt("supplier_id"));
                s.setSupplierName(rs.getString("supplier_name"));
                s.setEmail(rs.getString("email"));
                s.setPhone(rs.getString("phone"));
                s.setAddress(rs.getString("address"));
                s.setUsername(rs.getString("username"));
                s.setPassword(rs.getString("password"));
                s.setRole(rs.getString("role"));
                return s;
            }
        }
        return null;
    }

    @Override
    public void updateSupplier(Supplier supplier) throws SQLException {
        String sql = "UPDATE supplier SET supplier_name=?, email=?, phone=?, address=?, username=?, password=?, role=? WHERE supplier_id=?";
        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, supplier.getSupplierName());
            ps.setString(2, supplier.getEmail());
            ps.setString(3, supplier.getPhone());
            ps.setString(4, supplier.getAddress());
            ps.setString(5, supplier.getUsername());
            ps.setString(6, supplier.getPassword());
            ps.setString(7, supplier.getRole());
            ps.setInt(8, supplier.getSupplierId());
            ps.executeUpdate();
        }
    }

    @Override
    public void deleteSupplier(int supplierId) throws SQLException {
        String sql = "DELETE FROM supplier WHERE supplier_id=?";
        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, supplierId);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Supplier> getAllSuppliers() throws SQLException {
        List<Supplier> list = new ArrayList<>();
        String sql = "SELECT * FROM supplier";

        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Supplier s = new Supplier();
                s.setSupplierId(rs.getInt("supplier_id"));
                s.setSupplierName(rs.getString("supplier_name"));
                s.setEmail(rs.getString("email"));
                s.setPhone(rs.getString("phone"));
                s.setAddress(rs.getString("address"));
                s.setUsername(rs.getString("username"));
                s.setPassword(rs.getString("password"));
                s.setRole(rs.getString("role"));
                list.add(s);
            }
        }
        return list;
    }
}
