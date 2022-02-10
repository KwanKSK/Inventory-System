/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Core.Import;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author gurum
 */
public class ImportDAO extends JDBC{    // Connect the application to the database : "Import"
    
    public ImportDAO() throws Exception{
        super();    // Connect to the database
    }
    
    // Get every import's informations
    public List<Import> getAllImports(String branch_name) throws Exception{
        List<Import> list = new ArrayList<>();  // Store every import's informations
        
        try{
            // Prepare and execute the query, get the result from this query
            myprestm = myconn.prepareStatement("select * from Import natural join product where branch_name like ?");
            // Set the query to search inside the branch the user in
            myprestm.setString(1, branch_name);
            myres = myprestm.executeQuery();
            
            while(myres.next()){    // Read through the result and store it
                Import tempImport = getDataFromRow(myres);
                list.add(tempImport);
            }
            
            return list;
            
        } finally{  // Close the connector
            myprestm.close();
            myres.close();
        }
           
    }
    
    // Get every import's informations by product's name
    public List<Import> getImportsByProductName(String pro_name, String branch_name) throws Exception {
	List<Import> list = new ArrayList<>();    // Store every import's informations from the result

	try { 
            // Prepare and execute the query, get the result from this query
            myprestm = myconn.prepareStatement("select * from Import natural join product where branch_name like ? and product_name like ?");
            // Set the query to search for any product with its name similar to the one user search in the branch user in
            pro_name = "%" + pro_name + "%";
            myprestm.setString(1, branch_name);
            myprestm.setString(2, pro_name);
            myres = myprestm.executeQuery();
			
            while (myres.next()) {  // Read through the result and store it
                Import tempImport = getDataFromRow(myres);
		list.add(tempImport);
            }		
            
            return list;
            
	}finally {  // Close the connector
            myprestm.close();
            myres.close();
        }
    }
    
    // Get every import's informations by date
    public List<Import> getImportsByDate(String year, String month, String day, String branch_name) throws Exception {
	List<Import> list = new ArrayList<>();    // Store every import's informations from the result
        String prestm = "select * from import natural join product where branch_name = '"  // Prepare statement text
                        + branch_name + "' and extract(year from import_date) = " + year;
        
	try {
            // If user input month   
            if(month != "--")
                prestm += " and extract(month from import_date) = " + month;
            // If user input day
            if(day != "--")
                prestm += " and extract(day from import_date) = " + day;
            // create, execute statement 
            mystm = myconn.createStatement();
            myres = mystm.executeQuery(prestm);
			
            while (myres.next()) {  // Read through the result and store it
                Import tempImport = getDataFromRow(myres);
		list.add(tempImport);
            }	
            
            return list;
            
	}finally {  // Close the connector
            mystm.close();
            myres.close();
        }
    }
    
    // Get every import's informations by product's name and date
    public List<Import> getImportsByProductNameDate(String year, String month, String day, String pro_name, String branch_name) throws Exception {
	List<Import> list = new ArrayList<>();    // Store every import's informations from the result
        String prestm = "select * from import natural join product where branch_name = '"  // Prepare statement text
                        + branch_name + "' and product_name like '%" + pro_name 
                        + "%' and extract(year from import_date) = " + year;
        
	try {
            // If the user input year, month and day
            if(month != "--")
                prestm += " and extract(month from import_date) = " + month;
            // If user input day
            if(day != "--")
                prestm += " and extract(day from import_date) = " + day;
            // create, execute statement
            mystm = myconn.createStatement();
            myres = mystm.executeQuery(prestm);
			
            while (myres.next()) {  // Read through the result and store it
                Import tempImport = getDataFromRow(myres);
		list.add(tempImport);
            }		
            
            return list;
            
	}finally {  // Close the connector
            mystm.close();
            myres.close();
        }
    }
    
    // Get every import's informations with incorrect imported amount
    public List<Import> getAllIncorrectImports(String branch_name) throws Exception{
        List<Import> list = new ArrayList<>();      // Store every import's informations from the result
        
        try{
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("select * from import natural join product join orders using(order_id) "
                    + "where import.amount != orders.amount and import.branch_name like ? and order_status like 'Received'");
            // Set the query to search inside the branch user in
            myprestm.setString(1, branch_name);
            myres = myprestm.executeQuery();
            
            while(myres.next()){    // Read through the result and store it
                Import tempImport = getDataFromRow(myres);
                list.add(tempImport);
            }
            
            return list;
            
        } finally{  // Close the connector
            myprestm.close();
            myres.close();
        }
           
    }
    
    // Get every import's informations with incorrect imported amount by product's name
    public List<Import> getAllIncorrectImportsByProductName(String branch_name, String pro_name) throws Exception{
        List<Import> list = new ArrayList<>();      // Store every import's informations from the result
        
        try{
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("select * from import natural join product join orders using(order_id) "
                    + "where import.amount != orders.amount and import.branch_name like ? and product_name like ? and order_status like 'Received'");
            // Set the query to search for any product with its name similar to the one user search in the branch user in
            pro_name = "%" + pro_name + "%";
            myprestm.setString(1, branch_name);
            myprestm.setString(2, pro_name);
            myres = myprestm.executeQuery();
            
            while(myres.next()){    // Read through the result and store it
                Import tempImport = getDataFromRow(myres);
                list.add(tempImport);
            }
            
            return list;
            
        } finally{  // Close the connector
            myprestm.close();
            myres.close();
        }
           
    }
    
    
    // Add new import
    public void insertImport(int pro_id, int amount, String branch_name, int order_id) throws Exception{
        try{
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("insert into Import" 
                    + " (product_id, amount, branch_name, order_id)"
                    + " value (?, ?, ?, ?)");
            // Set the query to insert new import with this product's ID, product's amount, branch's name and order's ID
            myprestm.setInt(1, pro_id);
            myprestm.setInt(2, amount);
            myprestm.setString(3, branch_name);
            myprestm.setInt(4, order_id);
            myprestm.executeUpdate();
            
        }
        finally{    // Close the connector
            myprestm.close();
        }
    }
    
    // Update the informations of the import
    public void updateImport(int imp_id, int amount) throws Exception{
        try{
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("update Import" 
                    + " set amount = ?, import_date = import_date"
                    + " where import_id = ?");
            // Set the query to update the amount of product being imported of this import
            myprestm.setInt(1, amount);
            myprestm.setInt(2, imp_id);
            myprestm.executeUpdate();
            
        }
        finally{    // Close the connector
            myprestm.close();
        }
    
    }
    
    // Get the data from the tuple
    private Import getDataFromRow(ResultSet myres) throws SQLException {
        // Get the informations : import's ID, product's ID, name and imported amount, branch's name, order's ID, import date
	int imp_id = myres.getInt("import_id");
        int pro_id = myres.getInt("product_id");
        String pro_name = myres.getString("product_name");
        int amount = myres.getInt("amount");
        String imp_date = myres.getString("import_date");
        String branch_name = myres.getString("branch_name");
        int order_id = myres.getInt("order_id");
        
	Import tempImport = new Import(imp_id, pro_id, pro_name, amount, imp_date, branch_name, order_id);
		
	return tempImport;
        
    }
    
    // Get the amount of imported product from order's ID
    public int getAmount(int order_id) throws SQLException{
        int amount = 0;
		
	try {
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("select amount from import where order_id = ?");
            // Set the query get the amount of imported product by this order's ID
            myprestm.setInt(1, order_id);
            myres = myprestm.executeQuery();

            if (myres.next()) { // If there is this order's ID
                // Store the amount of this imported product
                amount = myres.getInt("amount");
            }
            
            return amount;
            
	}
	finally {   // Close the connector
            myprestm.close();
            myres.close();
	}
    }
}
