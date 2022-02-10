/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Core.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author gurum
 */
public class ProductDAO extends JDBC{
    
    public ProductDAO() throws Exception{
        super();    // Connect to the database
    }
    
    // Get every product's informations
    public List<Product> getAllProducts() throws Exception{
        List<Product> list = new ArrayList<>();        // Store every product's informations from the result
        
        try{
            // Prepare, execute and get the result from the query
            mystm = myconn.createStatement();
            myres = mystm.executeQuery("select * from Product");

            while(myres.next()){    // Read through the result and store it
                Product tempProduct = getDataFromRow(myres);
                list.add(tempProduct);
            }
            
            return list;
            
        } finally{  // Close the connector
            mystm.close();
            myres.close();
        }
           
    }
    
    // Get every selling product's informations
    public List<Product> getAllActiveProducts() throws Exception{
        List<Product> list = new ArrayList<>();         // Store every product's informations from the result
        
        try{
            // Prepare, execute and get the result from the query
            mystm = myconn.createStatement();
            myres = mystm.executeQuery("select * from Product where status = 'Active'");

            while(myres.next()){    // Read through the result and store it
                Product tempProduct = getDataFromRow(myres);
                list.add(tempProduct);
            }
            
            return list;
            
        } finally{  // Close the connector
            mystm.close();
            myres.close();
        }
           
    }
    
    // Get every product's informations by name
    public List<Product> getProductsByName(String pro_name) throws Exception {
	List<Product> list = new ArrayList<>();  // Store every product's informations from the result

	try {
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("select * from Product where product_name like ?");	
            // Set the query to search for any product with its name similar to the one user search
            pro_name = "%" + pro_name + "%";		
            myprestm.setString(1, pro_name);
            myres = myprestm.executeQuery();
			
            while (myres.next()) {  // Read through the result and store it
                Product tempProduct = getDataFromRow(myres);
		list.add(tempProduct);
            }		
            
            return list;
            
	}finally {  // Close the connector
            myprestm.close();
            myres.close();
        }
    }
    
    // Get every selling product's informations by name
    public List<Product> getActiveProductsByName(String pro_name) throws Exception {
	List<Product> list = new ArrayList<>();	// Store every product's informations from the result

	try {
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("select * from Product where product_name like ? and status = 'Active'");
            // Set the query to search for any selling product with its name similar to the one user search
            pro_name = "%" + pro_name + "%";		
            myprestm.setString(1, pro_name);
            myres = myprestm.executeQuery();
			
            while (myres.next()) {  // Read through the result and store it
                Product tempProduct = getDataFromRow(myres);
		list.add(tempProduct);
            }		

            return list;
            
	}finally {  // Close the connector
            myprestm.close();
            myres.close();
        }
    }
    
    // Add new product
    public void insertProduct(String pro_name, int amount) throws Exception{
        
        try{
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("insert into product" 
                    + " (product_name, stock)"
                    + " value (?, ?)");
            // Set the query to add new product in central kitchen
            myprestm.setString(1, pro_name);
            myprestm.setInt(2, amount);
            myprestm.executeUpdate();
            
        }finally {  // Close the connector
            myprestm.close();
        }
    }
    
    // Update the amount of this product
    public void updateProduct(int pro_id, int stock) throws SQLException{
        
        try{
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("update product"
                    + " set stock = stock + ?"
                    + " where product_id = ?");
            // Set the query to update the amount of product in the central kitchen
            myprestm.setInt(1, stock);
            myprestm.setInt(2, pro_id);
            myprestm.executeUpdate();
            
        } finally{  // Close the connector
            myprestm.close();
        }
    }
    
    // Update the informations of this product
    public void updateProduct(int pro_id, String pro_name, int stock) throws SQLException{
        
        try{
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("update product"
                    + " set stock = ?, product_name = ?"
                    + " where product_id = ?");
            // Set the query to update the informations of the product in central kitchen that user want to update
            myprestm.setInt(1, stock);
            myprestm.setString(2, pro_name);
            myprestm.setInt(3, pro_id);
            myprestm.executeUpdate();
            
        } finally{  // Close the connector
            myprestm.close();
        }
    }

    // Inactivate the product : Stop selling
    public void InActiveProduct(int pro_id) throws SQLException{
        
        try{
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("update product"
                    + " set status = 'In-Active'"
                    + " where product_id = ?");
            // Set the query to inactive this product
            myprestm.setInt(1, pro_id);
            myprestm.executeUpdate();
            
        } finally{  // Close the connector
            myprestm.close();
        }
    }
    
    // Activate the product : Sell this product
    public void ActiveProduct(int pro_id) throws SQLException{
        
        try{
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("update product"
                    + " set status = 'Active'"
                    + " where product_id = ?");
            // Set the query to active this product
            myprestm.setInt(1, pro_id);
            myprestm.executeUpdate();
            
        } finally{  // Close the connector
            myprestm.close();
        }
        
    }

    // Get the data from the tuple
    private Product getDataFromRow(ResultSet myres) throws SQLException {
        // Get the informations : ID, name, amount in the central kitchen, its status
	int pro_id = myres.getInt("product_id");
        String pro_name = myres.getString("product_name");
        int stock = myres.getInt("stock");
        String status = myres.getString("status");
        
	Product tempProduct = new Product(pro_id, pro_name, stock, status);
		
	return tempProduct;
        
    }
    
    // Get the amount of this product in central kitchen
    public int getProductAmount(int pro_id) throws SQLException{
        int ProductAmount = 0;      // Store the amount of this product in central kitchen
		
	try {
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("select stock from product where product_id = ?");
            // Set the query to get the amount of this product
            myprestm.setInt(1, pro_id);
            myres = myprestm.executeQuery();

            if (myres.next()) { // If there is a product of this ID
                // Store the amount of this product 
                ProductAmount = myres.getInt("stock");
            }
            
            return ProductAmount;
            
	}
	finally {   // Close the connector
            myprestm.close();
            myres.close();
	}
    }
    
}
