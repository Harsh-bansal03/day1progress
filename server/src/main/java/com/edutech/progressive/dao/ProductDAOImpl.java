package com.edutech.progressive.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Product;
public class ProductDAOImpl implements ProductDAO {

    @Override
    public int addProduct(Product product) throws SQLException {
        String sql = "INSERT INTO product (warehouse_id, product_name, product_description, quantity, price) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, product.getWarehouseId());
            ps.setString(2, product.getProductName());
            ps.setString(3, product.getProductDescription());
            ps.setInt(4, product.getQuantity());
            ps.setLong(5, product.getPrice());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            return rs.next() ? rs.getInt(1) : -1;
        }
    }

    @Override
    public Product getProductById(int productId) throws SQLException {
        String sql = "SELECT * FROM product WHERE product_id=?";
        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Product(
                        rs.getInt("product_id"),
                        rs.getInt("warehouse_id"),
                        rs.getString("product_name"),
                        rs.getString("product_description"),
                        rs.getInt("quantity"),
                        rs.getLong("price")
                );
            }
        }
        return null;
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        String sql = "UPDATE product SET warehouse_id=?, product_name=?, product_description=?, quantity=?, price=? WHERE product_id=?";
        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, product.getWarehouseId());
            ps.setString(2, product.getProductName());
            ps.setString(3, product.getProductDescription());
            ps.setInt(4, product.getQuantity());
            ps.setLong(5, product.getPrice());
            ps.setInt(6, product.getProductId());
            ps.executeUpdate();
        }
    }

    @Override
    public void deleteProduct(int productId) throws SQLException {
        String sql = "DELETE FROM product WHERE product_id=?";
        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, productId);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Product> getAllProducts() throws SQLException {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product";

        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("product_id"),
                        rs.getInt("warehouse_id"),
                        rs.getString("product_name"),
                        rs.getString("product_description"),
                        rs.getInt("quantity"),
                        rs.getLong("price")
                ));
            }
        }
        return list;
    }
}
