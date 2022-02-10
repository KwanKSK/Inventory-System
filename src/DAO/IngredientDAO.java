/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Core.Ingredient;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gurum
 */
public class IngredientDAO extends JDBC{
    
    public IngredientDAO() throws Exception{
        super();        // Connect to the database
    }
    
    // get every ingredient's informations
    public List<Ingredient> getAllIngredients() throws Exception{
        List<Ingredient> list = new ArrayList<>();  // Store every ingredient's informations from the result
        
        try{
            // Prepare, execute and get the result from the query
            mystm = myconn.createStatement();
            myres = mystm.executeQuery("select * from Ingredient");
            
            while(myres.next()){    // Read through the result and store it
                Ingredient tempIngredient = getDataFromRow(myres);
                list.add(tempIngredient);
            }
            
            return list;
            
        } finally{
            mystm.close();
            myres.close();
        }
           
    }
    
    // Get every ingredient's informations by name
    public List<Ingredient> getIngredientsByName(String ing_name) throws Exception {
	List<Ingredient> list = new ArrayList<>();    // Store every ingredient's informations from the result

	try {
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("select * from Ingredient where ingredient_name like ?");
            // Set the query to search for any ingredient with its name similar to the one user search 
            ing_name = "%" + ing_name + "%";		
            myprestm.setString(1, ing_name);
            myres = myprestm.executeQuery();
			
            while (myres.next()) {  // Read through the result and store it
                Ingredient tempIngredient = getDataFromRow(myres);
		list.add(tempIngredient);
            }	
            
            return list;
            
	}finally {
            myprestm.close();
            myres.close();
        }
    }
    
    // Add new ingredient
    public void insertIngredient(String ing_name, int amount) throws Exception{
        try{
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("insert into Ingredient" 
                    + " (Ingredient_name, stock)"
                    + " value (?, ?)");
            // Set the query to add new ingredients
            myprestm.setString(1, ing_name);
            myprestm.setInt(2, amount);
            myprestm.executeUpdate();
            
        }
        finally{    // Close the connector
            myprestm.close();
        }
    }
    
    // Update the informations of the ingredient
    public void updateIngredient(int ing_id, String ing_name, int amount) throws SQLException{
        try{
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("update Ingredient"
                    + " set stock = ?, ingredient_name = ?"
                    + " where Ingredient_id = ?");
            // Set the query to update the informations of the ingredient user want to update
            myprestm.setInt(1, amount);
            myprestm.setString(2, ing_name);
            myprestm.setInt(3, ing_id);
            myprestm.executeUpdate();
            
        } finally{  // Close the connector
            myprestm.close();
        }
    }
    
    // Delete this ingredient
    public void deleteIngredient(int ing_id) throws SQLException{
        try{
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("delete from Ingredient where Ingredient_id = ?");
            // Set the query to delete this ingredient
            myprestm.setInt(1, ing_id);
            myprestm.executeUpdate();
            
        } finally { // Close the connector
            myprestm.close();
        }
        
    }
    
    // Get data from the tuple
    private Ingredient getDataFromRow(ResultSet myres) throws SQLException {
        // Get the informations : ID, name, amount in central kitchen
	int ing_id = myres.getInt("ingredient_id");
        String ing_name = myres.getString("ingredient_name");
        int stock = myres.getInt("stock");
        
	Ingredient tempIngredient = new Ingredient(ing_id, ing_name, stock);

	return tempIngredient;
        
    }
}
