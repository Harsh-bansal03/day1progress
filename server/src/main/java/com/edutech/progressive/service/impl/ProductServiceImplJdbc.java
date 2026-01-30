package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.edutech.progressive.dao.ProductDAO;
import com.edutech.progressive.entity.Product;

public class ProductServiceImplJdbc implements ProductDAO {

    @Override
    public int addProduct(Product product) throws SQLException {
        return 0;
        // TODO Auto-generated method stub 
    }

    @Override
    public Product getProductById(int productId) throws SQLException {
        return null;
        // TODO Auto-generated method stub
    }

    @Override
    public void updateProduct(Product product) throws SQLException{
        // TODO Auto-generated method stub
    
    }

    @Override
    public void deleteProduct(int productId) throws SQLException{
        // TODO Auto-generated method stub

    }

    @Override
    public List<Product> getAllProducts()throws SQLException {
        return null;
        // TODO Auto-generated method stub
        
    }
}