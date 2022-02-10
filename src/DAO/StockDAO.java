/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Core.Stock;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author gurum
 */
public class StockDAO extends JDBC{
    
    public StockDAO() throws Exception{
        super();        // Connect to the database
    }
    
    // Get every stock's informations
    public List<Stock> getAllStocks(String branch_name) throws Exception{
        List<Stock> list = new ArrayList<>();       // Store every stock's informations from the result
        
        try{
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("select * from Stock natural join product where branch_name like ?");
            // Set the query to search for any product in the branch user in
            myprestm.setString(1, branch_name);
            myres = myprestm.executeQuery();
            
            while(myres.next()){    // Read through the result and store it
                Stock tempStock = getDataFromRow(myres);
                list.add(tempStock);
            }
            
            return list;
            
        } finally{  // Close the connector
            myprestm.close();
            myres.close();
        }
           
    }
    
    // Get every stock's information by name
    public List<Stock> getStocksByName(String pro_name, String branch_name) throws Exception {
	List<Stock> list = new ArrayList<>();      // Store every stock's informations from the result

	try {
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("select * from Stock natural join product where product_name like ? and branch_name like ?");	
            // Set the query to search for any product with its name similar to the one user search in the branch user in
            pro_name = "%" + pro_name + "%";	
            myprestm.setString(1, pro_name);
            myprestm.setString(2, branch_name);
            myres = myprestm.executeQuery();
			
            while (myres.next()) {  // Read through the result and store it
                Stock tempStock = getDataFromRow(myres);
		list.add(tempStock);
            }	
            
            return list;
            
	}finally {  // Close the connector
            myprestm.close();
            myres.close();
        }
    }
    
    // Add new product into the branch
    public void insertStock(int pro_id, int amount, String branch_name) throws Exception{
        try{
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("insert into stock" 
                    + " (product_id, amount, branch_name)"
                    + " value (?, ?, ?)");
            // Set the query to add new product in the branch user in the branch user in
            myprestm.setInt(1, pro_id);
            myprestm.setInt(2, amount);
            myprestm.setString(3, branch_name);
            myprestm.executeUpdate();
            
        }
        finally{    // Close the connector
            myprestm.close();
        }
    }
    
    // Update the amount of this branch's product
    public void updateStock(int id, String branch_name, int amount) throws Exception{
        try{
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("update stock"
                    + " set amount = amount + ?"
                    + " where product_id = ? and branch_name like ?");
            // Set the query to update the amount of this product in the branch user in
            myprestm.setInt(1, amount);
            myprestm.setInt(2, id);
            myprestm.setString(3, branch_name);
            myprestm.executeUpdate();
            
        } finally{  // Close the connector
            myprestm.close();
        }
    
    }
    
    // Delete a product from this branch
    public void deleteStock(int pro_id, String branch_name) throws SQLException{
        try{
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("delete from stock where product_id = ? and branch_name like ?");
            // Set the query to delete this product
            myprestm.setInt(1, pro_id);
            myprestm.setString(2, branch_name);
            myprestm.executeUpdate();
            
        } finally { // Close the connector
            myprestm.close();
        }
        
    }
    
    // Get data from the tuple
    private Stock getDataFromRow(ResultSet myres) throws SQLException {
        // Get the informations : branch's name, product's ID, name, and amount in this branch
	String branch_name = myres.getString("branch_name");
        int pro_id = myres.getInt("product_id");
        String pro_name = myres.getString("product_name");
        int amount = myres.getInt("amount");

	Stock tempStock = new Stock(branch_name, pro_id, pro_name, amount);
		
	return tempStock;
        
    }
    
    public boolean isStock(int pro_id, String branch_name) throws SQLException{
        List<Stock> list = new ArrayList<>();      // Store every stock's informations from the result
        boolean isStock = false;
        
        try{
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("select * from stock natural join product where branch_name like ? and product_id = ?");
            // Set the query to search for the product in the branch user in
            myprestm.setString(1, branch_name);
            myprestm.setInt(2, pro_id);
            myres = myprestm.executeQuery();
            
            if(myres.next()) isStock = true;   // If it can find, in the stock
            
            return isStock;
            
        } finally { // Close the connector
            myprestm.close();
        }
    }
    
}
