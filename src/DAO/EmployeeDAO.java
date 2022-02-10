/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Core.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author gurum
 */
public class EmployeeDAO extends JDBC{  // Connect the application to the database : "Employee"
    
    public EmployeeDAO() throws Exception{
        super();    // Connect to the database
    }
    
    // Get every employee's informations
    public List<Employee> getAllEmployees(String branch_name) throws Exception{
        List<Employee> list = new ArrayList<>();    // Store every employee's informations from the result
        
        try{
            // Prepare and execute the query. get the results from this query
            myprestm = myconn.prepareStatement("select * from Employee where branch_name like ?");
            // Set the query to search inside the branch the user in
            myprestm.setString(1, branch_name);
            myres = myprestm.executeQuery();
            
            while(myres.next()){    // Read through the result and store it
                Employee tempEmployee = getDataFromRow(myres);
                list.add(tempEmployee);
            }
            
            return list;
            
        } finally{  // Close the connector
            myprestm.close();
            myres.close();
        }
           
    }
    
    // Get every employee's informations by name
    public List<Employee> getEmployeesByName(String emp_name, String branch_name) throws Exception {
	List<Employee> list = new ArrayList<>();    // Store every employee's informations from the result

	try {
            // Prepare and execute the query, get the result from this query
            myprestm = myconn.prepareStatement("select * from Employee where employee_name like ? and branch_name like ?");
            // Set the query to search for any employee with their name similar to the one user search in the branch user in
            emp_name += "%";
            myprestm.setString(1, emp_name);
            myprestm.setString(2, branch_name);
            myres = myprestm.executeQuery();
			
            while (myres.next()) {  // Read through the result and store it
                Employee tempEmployee = getDataFromRow(myres);
		list.add(tempEmployee);
            }
            
            return list;
            
	}finally {  // Close the connector
            myprestm.close();
            myres.close();
        }
    }
    
    // Get the data from the tuple
    private Employee getDataFromRow(ResultSet myres) throws SQLException {
	// Get the informations : ID, name, password, telephone number, position, branch	
	int emp_id = myres.getInt("employee_id");
        String emp_name = myres.getString("employee_name");
        String emp_pass = myres.getString("employee_password");
        String emp_tel = myres.getString("employee_tel");
        String emp_pos = myres.getString("employee_pos");
        String branch_name = myres.getString("branch_name");

        // Store the informations
	Employee tempEmployee = new Employee(emp_id, emp_name, emp_pass, emp_tel, emp_pos, branch_name);

	return tempEmployee;
    }
    
    // Check the password between the one in the database and the one user search
    public boolean authenticate(Employee theEmployee) throws Exception {
	boolean result = false;     // authenticate checker
		
        // Get the password 
        String plainTextPassword = theEmployee.getEmpPass();
        // Get the encrypted password from database for this user
	String encryptedPasswordFromDatabase = getEncrpytedPassword(theEmployee.getEmpId());
		
        // Compare the passwords
        if(plainTextPassword.equals(encryptedPasswordFromDatabase)){
            result = true;      // Inputted password is correct
        }
               
        return result;
                	
    }
    
    // Get the encrypted password of this employee
    private String getEncrpytedPassword(int id) throws Exception {
	String encryptedPassword = null;    // Store the encrypted password
		
	try {
            // Prepare and execute the query, get the result from this query
            mystm = myconn.createStatement();
            myres = mystm.executeQuery("select employee_password from employee where employee_id = " + id);

            if (myres.next()) { // If there is an employee with this ID
                // Get the encrypted password of this employee
                encryptedPassword = myres.getString("employee_password");
            }
            else {              // If not
                // Let the user know there is no employee of this ID
                throw new Exception("User id not found: " + id);
            }

            return encryptedPassword;		
	}
	finally {   // Close the connector
            mystm.close();
            myres.close();
	}		
    }
    
    // Get the name of the branch this employee is in
    public String getEmployeeBranch(int id) throws Exception{
        String EmployeeBranch = null;       // Store the branch's name of this employee
		
	try {
            // Prepare and execute the query, get the result from this query
            mystm = myconn.createStatement();
            myres = mystm.executeQuery("select branch_name from employee where employee_id = " + id);

            if (myres.next()) { // If there is an employee with this ID
                // Get the branch's name of this employee
                EmployeeBranch = myres.getString("branch_name");
            }
            else {              // If not
                // Let the user know there is no employee of this ID
                throw new Exception("User id not found: " + id);
            }
            
            return EmployeeBranch;
            
	}
	finally {   // Close the connector
            mystm.close();
            myres.close();
	}
    }
    
    // Get this employee's position
    public String getEmployeePosition(int id) throws Exception{
        String EmployeePosition = null;         // Store this employee's position
		
	try {
            // Prepare and execute the query, get the result from this query
            mystm = myconn.createStatement();
            myres = mystm.executeQuery("select employee_pos from employee where employee_id = " + id);

            if (myres.next()) { // If there is an employee with this ID
                // Get the position of this employee
                EmployeePosition = myres.getString("employee_pos");
            }
            else {              // If not
                // Let the user know there is no employee of this ID
                throw new Exception("User id not found: " + id);
            }
            
            return EmployeePosition;	
            
	}
	finally {   // Close the connector
            mystm.close();
            myres.close();
	}
    }
    
}
