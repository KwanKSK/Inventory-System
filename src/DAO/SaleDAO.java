/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Core.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author gurum
 */
public class SaleDAO extends JDBC{
    
    public SaleDAO() throws Exception{
        super();        // Connect to the database
    }
    
    // Get every sale's informations
    public List<Sales> getAllSales() throws Exception{
        List<Sales> list = new ArrayList<>();       // Store every sale's informations from the result
        
        try{
            // Prepare, execute and get the result from the query
            mystm = myconn.createStatement();
            myres = mystm.executeQuery("select sales_id, branch_name, product_id, product_name, sum(amount) amount, sales_date "
                    + "from sales natural join product group by product_id, branch_name;");
            
            while(myres.next()){    // Read through the result
                Sales tempSales = getDataFromRow(myres);
                list.add(tempSales);
            }

            return list;
            
        } finally{  // Close the connector
            mystm.close();
            myres.close();
        }
           
    }
    
    // Get every sale's informations by branch's name 
    public List<Sales> getSalesByBranchName(String branch_name) throws Exception{
        List<Sales> list = new ArrayList<>();       // Store every sale's informations from the result
        
        try{
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("select * from Sales natural join product where branch_name like ?");
            // Set the query to search for any sales with its branch's name similar to the one user search
            branch_name = "%" + branch_name + "%";
            myprestm.setString(1, branch_name);
            myres = myprestm.executeQuery();
            
            while(myres.next()){    // Read through the result and store it
                Sales tempSales = getDataFromRow(myres);
                list.add(tempSales);
            }
            
            return list;
            
        } finally{  // Close the connector
            myprestm.close();
            myres.close();
        }
           
    }
    
    // Get every sale's informations by product's name
    public List<Sales> getSalesByProductName(String pro_name) throws Exception {
	List<Sales> list = new ArrayList<>();  // Store every sale's informations from the result
                
	try {
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("select sales_id, branch_name, product_id, product_name, sum(amount) amount, sales_date from sales natural join product "
                                        + "where product_name like ? group by product_id, branch_name;");	
            // Set the query to search for any sale with its product's name similar to the one user search
            pro_name = "%" + pro_name + "%";		
            myprestm.setString(1, pro_name);
            myres = myprestm.executeQuery();
            
            while (myres.next()) {  // Read through the result and store it
                Sales tempSales = getDataFromRow(myres);
		list.add(tempSales);
            }		
            
            return list;
            
	}finally {  // Close the connector
            myprestm.close();
            myres.close();
        }
    }
    
    // Get every sale's informations by product's name and branch's name
    public List<Sales> getSalesByProductNameBranch(String pro_name, String branch_name) throws Exception {
	List<Sales> list = new ArrayList<>();  // Store every sale's informations from the result
        
	try {
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("select sales_id, branch_name, product_id, product_name, sum(amount) amount, sales_date from sales natural join product "
                                        + "where product_name like ? and branch_name like ? group by product_id, branch_name;");	
            // Set the query to search for any sales with its product's name is similar to the one user search in the branch with its name similar to the one user search
            pro_name = "%" + pro_name + "%";
            branch_name = "%" + branch_name + "%";		
            myprestm.setString(1, pro_name);
            myprestm.setString(2, branch_name);
            myres = myprestm.executeQuery();
			
            while (myres.next()) {  // Read through the result and store it
                Sales tempSales = getDataFromRow(myres);
		list.add(tempSales);
            }	
            
            return list;
            
	}finally {  // Close the connector
            myprestm.close();
            myres.close();
        }
    }
    
    // Get every sale's informations by product's name and date in the branch user in
    public List<Sales> getSalesByProductNameDate(String pro_name, String year, String month, String day, String branch_name) throws Exception {
	List<Sales> list = new ArrayList<>();  // Store every sale's informations from the result
        String prestm = "select * from sales natural join product where branch_name = '"  // Prepare statement text
                        + branch_name + "' and product_name like '%" + pro_name 
                        + "%' and extract(year from sales_date) = " + year;
               
	try {
            // If the user input year, month and day
            if(month != "--")
                prestm += " and extract(month from sales_date) = " + month;
            // If user input day
            if(day != "--")
                prestm += " and extract(day from sales_date) = " + day;
            // create, execute statement
            mystm = myconn.createStatement();
            myres = mystm.executeQuery(prestm);
			
            while (myres.next()) {  // Read through the result and store it
                Sales tempSales = getDataFromRow(myres);
		list.add(tempSales);
            }
            
            return list;
            
	}finally {  // Close the connector
            mystm.close();
            myres.close();
        }
    }
    
    // 
    public List<Sales> getSalesByBranch(String branch_name) throws Exception {
	List<Sales> list = new ArrayList<>();      // Store every sale's informations from the result
        
	try {
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("select sales_id, branch_name, product_id, product_name, sum(amount) amount, sales_date from sales natural join product "
                                        + "where branch_name like ? group by product_id, branch_name;");	
            // Set the query to search for any sales with its branch's name similar to the one user search
            branch_name = "%" + branch_name + "%";
            myprestm.setString(1, branch_name);
            myres = myprestm.executeQuery();
			
            while (myres.next()) {  // Read through the result and store it
                Sales tempSales = getDataFromRow(myres);
		list.add(tempSales);
            }		
            
            return list;
            
	}finally {  // Close the connector
            myprestm.close();
            myres.close();
        }
    }
    
    // Get every sale's informations by date
    public List<Sales> getSalesByDate(String year, String month, String day, String branch_name) throws Exception {
	List<Sales> list = new ArrayList<>();      // Store every sale's informations from the result
        String prestm = "select * from sales natural join product where branch_name = '"  // Prepare statement text
                        + branch_name + "' and extract(year from sales_date) = " + year;
        
	try {
            // If user input month
            if(month != "--")
                prestm += " and extract(month from sales_date) = " + month;
            // If user input day
            if(day != "--")
                prestm += " and extract(day from sales_date) = " + day;
            // create, execute statement
            mystm = myconn.createStatement();
            myres = mystm.executeQuery(prestm);
			
            while (myres.next()) {  // Read through the result and store it
                Sales tempSales = getDataFromRow(myres);
		list.add(tempSales);
            }
            
            return list;
            
	}finally {  // Close the connector
            mystm.close();
            myres.close();
        }
    }
    
    // Add new sale
    public void insertSale(int id, String branch_name, int amount) throws Exception{
        try{
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("insert into sales"
                    + "(product_id, branch_name, amount)"
                    + " values(?, ?, ?)");
            // Set the query to add a new sale
            myprestm.setInt(1, id);
            myprestm.setString(2, branch_name);
            myprestm.setInt(3, amount);
            myprestm.executeUpdate();
            
        } finally{  // Close the connector
            myprestm.close();
        }
    
    }
    
    // Get data from the tuple
    private Sales getDataFromRow(ResultSet myres) throws SQLException {
        // Get the informations : sale's ID, branch's name, product's ID, name and sold amount, sale date
	int sales_id = myres.getInt("sales_id");
        String branch_name = myres.getString("branch_name");
        int pro_id = myres.getInt("product_id");
        String pro_name = myres.getString("product_name");
        int amount = myres.getInt("amount");
        String sales_date = myres.getString("sales_date");

	Sales tempProduct = new Sales(sales_id, branch_name, pro_id, pro_name, amount, sales_date);
		
	return tempProduct;
        
    }
}
