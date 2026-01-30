package com.edutech.progressive.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.entity.Product;

public class ProductDAOImpl implements ProductDAO{

    
    @Override
    public int addProduct(Product product) throws SQLException{
        // TODO Auto-generated method stub
        return -1;
    }

    @Override
    public Product getProductById(int productId) throws SQLException{
        // TODO Auto-generated method stub
        return null;
        
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
    public List<Product> getAllProducts() throws SQLException{
        // TODO Auto-generated method stub
        return new ArrayList<>();
    }
    

}
