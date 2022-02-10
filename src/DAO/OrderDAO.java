/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Core.Orders;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author gurum
 */
public class OrderDAO extends JDBC{
    
    public OrderDAO() throws Exception{
        super();        // Connect to the database
    }
    
    // Get every order's informations : (for CEO)
    public List<Orders> getAllOrders() throws Exception{
        List<Orders> list = new ArrayList<>();  // Store every order's informations from the result
        
        try{
            // Prepare, execute and get the result from the query
            mystm = myconn.createStatement();
            myres = mystm.executeQuery("select * from Orders natural join product where order_status like 'ordered'");
            
            while(myres.next()){    // Read through the result and store it
                Orders tempOrder = getDataFromRow(myres);
                list.add(tempOrder);
            }
            
            return list;
            
        } finally{  // Close the connector
            mystm.close();
            myres.close();
        }
           
    }
    
    // Get every completed order's informations : (for CEO)
    public List<Orders> getAllCompletedOrders() throws Exception{
        List<Orders> list = new ArrayList<>();  // Store every order's informations from the result
        
        try{
            // Prepare, execute and get the result from the query
            mystm = myconn.createStatement();
            myres = mystm.executeQuery("select * from Orders natural join product where order_status like 'Confirmed'");
            
            while(myres.next()){    // Read through the result and store it
                Orders tempOrder = getDataFromRow(myres);
                list.add(tempOrder);
            }
            
            return list;
            
        } finally{  // Close the connector
            mystm.close();
            myres.close();
        }
           
    }
    
    // Get every order's informations : (for Employee and Manager)
    public List<Orders> getAllOrdersOfBranch(String branch_name, boolean isManager) throws Exception{
        List<Orders> list = new ArrayList<>();  // Store every order's informations from the result
        
        try{
            // Prepare, execute and get the result from the query
            if(isManager){  // If the user is the manager of this branch
                myprestm = myconn.prepareStatement("select * from import natural join product join orders using(order_id) "
                        + "where import.amount != orders.amount and import.branch_name like ? and order_status like 'Received'");
            }
            else{           // If the user is the employee
                myprestm = myconn.prepareStatement("select * from Orders natural join product where branch_name like ? and order_status like 'Exported'");
            }
            // Set the query to search for any order 
            myprestm.setString(1, branch_name);
            myres = myprestm.executeQuery();
            
            while(myres.next()){    // Read through the result and store it
                Orders tempOrder = getDataFromRow(myres);
                list.add(tempOrder);
            }
            
            return list;
            
        } finally{  // Close the connector
            myprestm.close();
            myres.close();
        }
           
    }
    
    // Get every order's informations : (for CEO)
    public List<Orders> getOrdersByProductName(String pro_name) throws Exception {
	List<Orders> list = new ArrayList<>();    // Store every order's informations from the result

	try {
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("select * from Orders natural join product where product_name like ? and order_status like 'Ordered'");	
            // Set the query to search for any order 
            pro_name = "%" + pro_name + "%";		
            myprestm.setString(1, pro_name);
            myres = myprestm.executeQuery();
			
            while (myres.next()) {  // Read through the result and store it
                Orders tempOrder = getDataFromRow(myres);
		list.add(tempOrder);
            }		
            
            return list;
            
	}finally {  // Close the connector
            myprestm.close();
            myres.close();
        }
    }
    
    // Get every completed order's informations : (for CEO)
    public List<Orders> getCompletedOrdersByProductName(String pro_name) throws Exception {
	List<Orders> list = new ArrayList<>();    // Store every order's informations from the result

	try {
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("select * from Orders natural join product where product_name like ? and order_status like 'Confirmed'");
            // Set the query to search for any order 
            pro_name = "%" + pro_name + "%";		
            myprestm.setString(1, pro_name);
            myres = myprestm.executeQuery();
			
            while (myres.next()) {  // Read through the result and store it
                Orders tempOrder = getDataFromRow(myres);
		list.add(tempOrder);
            }	
            
            return list;
            
	}finally {  // Close the connector
            myprestm.close();
            myres.close();
        }
    }
    
    // Get every order's informations : (for CEO)
    public List<Orders> getOrdersByProductNameBranch(String branch_name, String pro_name) throws Exception {
	List<Orders> list = new ArrayList<>();    // Store every order's informations from the result
        
	try {
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("select * from Orders natural join product where product_name like ? and branch_name like ? and order_status like 'Ordered'");
            // Set the query to search for any order 
            pro_name = "%" + pro_name + "%";
            branch_name = "%" + branch_name + "%";			
            myprestm.setString(1, pro_name);
            myprestm.setString(2, branch_name);
            myres = myprestm.executeQuery();
	    
            while (myres.next()) {  // Read through the result and store it
                Orders tempOrder = getDataFromRow(myres);
		list.add(tempOrder);
            }	
            
            return list;
            
	}finally {  // Close the connector
            myprestm.close();
            myres.close();
        }
    }
    
    // Get every order's informations : (for CEO)
    public List<Orders> getCompletedOrdersByProductNameBranch(String branch_name, String pro_name) throws Exception {
	List<Orders> list = new ArrayList<>();    // Store every order's informations from the result

	try {
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("select * from Orders natural join product where product_name like ? and branch_name like ? and order_status like 'Confirmed'");	
            // Set the query to search for any order 
            pro_name = "%" + pro_name + "%";
            branch_name = "%" + branch_name + "%";		
            myprestm.setString(1, pro_name);
            myprestm.setString(2, branch_name);
            myres = myprestm.executeQuery();
			
            while (myres.next()) {  // Read through the result and store it
                Orders tempOrder = getDataFromRow(myres);
		list.add(tempOrder);
            }	
            
            return list;
            
	}finally {  // Close the connector
            myprestm.close();
            myres.close();
        }
    }
    
    // Get every order's informations : (for Employee and Manager)
    public List<Orders> getOrdersByProductNameOfBranch(String branch_name, String pro_name, boolean isManager) throws Exception {
	List<Orders> list = new ArrayList<>();    // Store every order's informations from the result

	try {
            // Prepare, execute and get the result from the query
            if(isManager){  // If the user is the manager of this branch
                myprestm = myconn.prepareStatement("select * from import natural join product join orders using(order_id) "
                                        + " where import.amount != orders.amount and product_name like ? and import.branch_name like ? and order_status like 'Received'");
            }
            else{           // If the user is the employee
                myprestm = myconn.prepareStatement("select * from Orders natural join product where product_name like ? and branch_name like ? and order_status like 'Exported'");
            }		
            // Set the query to search for any order 
            pro_name = "%" + pro_name + "%";
            myprestm.setString(1, pro_name);
            myprestm.setString(2, branch_name);
            myres = myprestm.executeQuery();
			
            while (myres.next()) {  // Read through the result and store it
                Orders tempOrder = getDataFromRow(myres);
		list.add(tempOrder);
            }		
            
            return list;
            
	}finally {  // Close the connector
            myprestm.close();
            myres.close();
        }
    }
    
    // Get every order's informations : (for CEO)
    public List<Orders> getOrdersByBranch(String branch_name) throws Exception {
	List<Orders> list = new ArrayList<>();    // Store every order's informations from the result

	try {
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("select * from Orders natural join product where branch_name like ? and order_status like 'Ordered'");
            // Set the query to search for any order 
            branch_name = "%" + branch_name + "%";	
            myprestm.setString(1, branch_name);
            myres = myprestm.executeQuery();
			
            while (myres.next()) {  // Read through the list
                // Store the informations of each order
                Orders tempOrder = getDataFromRow(myres);
		list.add(tempOrder);
            }	
            
            // Return every order's informations from the result to the caller
            return list;
            
	}finally {  // Close the connector
            myprestm.close();
            myres.close();
        }
    }
    
    // Get every order's informations : (for CEO)
    public List<Orders> getCompletedOrdersByBranch(String branch_name) throws Exception {
	List<Orders> list = new ArrayList<>();    // Store every order's informations from the result

	try {
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("select * from Orders natural join product where branch_name like ? and order_status like 'Confirmed'");			
            // Set the query to search for any order 
            branch_name = "%" + branch_name + "%";
            myprestm.setString(1, branch_name);
            myres = myprestm.executeQuery();
			
            while (myres.next()) {  // Read through the list
                // Store the informations of each order
                Orders tempOrder = getDataFromRow(myres);
		list.add(tempOrder);
            }		
            
            // Return every order's informations from the result to the caller
            return list;
            
	}finally {  // Close the connector
            myprestm.close();
            myres.close();
        }
    }
    
    // Add new order
    public void insertOrder(int pro_id, int amount, String branch_name) throws Exception{
        try{
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("insert into orders" 
                    + " (product_id, amount, branch_name)"
                    + " value (?, ?, ?)");
            // Set the query to add a new order
            myprestm.setInt(1, pro_id);
            myprestm.setInt(2, amount);
            myprestm.setString(3, branch_name);
            myprestm.executeUpdate();
            
        }
        finally{    // Close the connector
            myprestm.close();
        }
    }
    
    // Update order's status
    public void updateOrder(Orders theOrder) throws SQLException{
        try{
            // Prepare, execute and get the result from the query
            switch (theOrder.getOrderStatus()) {
                case "Exported":
                    myprestm = myconn.prepareStatement("update orders"
                            + " set order_status = 'Received', order_date = order_date, received_date = current_timestamp()"
                            + " where order_id = ?");
                    break;
                case "Received":
                    myprestm = myconn.prepareStatement("update orders"
                            + " set order_status = 'Confirmed'"
                            + " where order_id = ?");
                    break;
                case "Ordered": 
                    myprestm = myconn.prepareStatement("update orders"
                            + " set order_status = 'Exported'"
                            + " where order_id = ?");
                    break;
                default:
                    break;
            }

            // Set the query to update the status of this order
            myprestm.setInt(1, theOrder.getOrderId());
            myprestm.executeUpdate();
            
        } finally{  // Close the connector
            myprestm.close();
        }
    }
    
    // Get data of the tuple
    private Orders getDataFromRow(ResultSet myres) throws SQLException {
        // Get the informations : order's ID and status, product's ID and ordered amount, order date, received date, branch's name
	int order_id = myres.getInt("order_id");
        String pro_name = myres.getString("product_name");
        int amount = myres.getInt("orders.amount");
        String order_date = myres.getString("order_date");
        String received_date = myres.getString("received_date");
        String branch_name = myres.getString("branch_name");
        String order_status = myres.getString("order_status");

	Orders tempOrder = new Orders(order_id, pro_name, amount, order_date, received_date, branch_name, order_status);
		
	return tempOrder;
        
    }
    
    // Get product's ID by name and order's ID
    public int getProductId(int order_id, String pro_name) throws SQLException{
        int ProductId = 0;
	
	try {
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("select product_id from orders natural join product where order_id = ? and product_name like ?");
            // Set the query to search for any product with its name similar to the one user search from order's ID
            myprestm.setInt(1, order_id);
            myprestm.setString(2, pro_name);
            myres = myprestm.executeQuery();

            if (myres.next()) { // If there is a product
                ProductId = myres.getInt("product_id");
            }

            return ProductId;
            
	}
	finally {   // Close the connector
            myprestm.close();
            myres.close();
	}
    }
}
