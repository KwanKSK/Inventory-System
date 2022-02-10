/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Core.Branch;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gurum
 */
public class BranchDAO extends JDBC {   // Connect the application to the database : "Branch"
    
    public BranchDAO() throws Exception{
        super();    // Connect to the database
    }
    
    // Get every branch's informations
    public List<Branch> getAllBranches() throws SQLException { 
        List<Branch> list = new ArrayList<>();  // Store every branch's informations from the result
        
        try{
            // Prepare and execute the query, get the result from this query
            mystm = myconn.createStatement();
            myres = mystm.executeQuery("select * from Branch where branch_name not like 'central kitchen'");
            
            while(myres.next()){    // Read through the result and store it
                Branch tempBranch = getDataFromRow(myres);
                list.add(tempBranch);
            }
            
            return list;
            
        } finally{  // Close the connector
            mystm.close();
            myres.close();
        }
           
    }
    
    // Get every branch's informations by name
    public List<Branch> getBranchesByName(String branch_name) throws SQLException {
	List<Branch> list = new ArrayList<>();    // Store every branch's informations from the result

	try {
            // Prepare and execute the query, get the result from this query            
            myprestm = myconn.prepareStatement("select * from Branch where branch_name not like 'central kitchen' and branch_name like ?");
            // Set the query to search for any branch with its name similar to the one user search
            branch_name = "%" + branch_name + "%";
            myprestm.setString(1, branch_name);
            myres = myprestm.executeQuery();
			
            while (myres.next()) {  // Read through the result and store it
                Branch tempBranch = getDataFromRow(myres);
		list.add(tempBranch);
            }
            
            return list;
            
	}finally {  // Close the connector
            myprestm.close();
            myres.close();
        }
    }
    
    // Get the data from the tuple
    private Branch getDataFromRow(ResultSet myRs) throws SQLException {
        // Get the informations : name, address, telephone number
        String branch_name = myRs.getString("branch_name");  
	String branch_add = myRs.getString("branch_address");
        String branch_tel = myRs.getString("branch_tel");       
		
        Branch tempBranch = new Branch(branch_name, branch_add, branch_tel);
		
        return tempBranch;
    }
}
