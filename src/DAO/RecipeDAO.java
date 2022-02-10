/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Core.Recipe;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gurum
 */
public class RecipeDAO extends JDBC{
    
    public RecipeDAO() throws Exception{
        super();        // Connect to the database
    }
    
    // Get every recipe's informations
    public List<Recipe> getAllRecipes() throws Exception{
        List<Recipe> list = new ArrayList<>();      // Store every recipe's informations from the result
        
        try{
            // Prepare, execute and get the result from the query
            mystm = myconn.createStatement();
            myres = mystm.executeQuery("select * from Recipe natural join product join ingredient using(ingredient_id)");
            while(myres.next()){    // Read through the result and store it
                Recipe tempRecipe = getDataFromRow(myres);
                list.add(tempRecipe);
            }
            
            return list;
            
        } finally{  // Close the connector
            mystm.close();
            myres.close();
        }
           
    }
    
    // Get every recipe's informations by product's name
    public List<Recipe> getRecipesByProductName(String pro_name) throws Exception {
	List<Recipe> list = new ArrayList<>();    // Store every recipe's informations from the result

	try {
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("select * from Recipe natural join product join ingredient using(ingredient_id) where product_name like ?");	
            // Set the query to search for any product with its name similar to the one user search
            pro_name = "%" + pro_name + "%";		
            myprestm.setString(1, pro_name);
            myres = myprestm.executeQuery();
			
            while (myres.next()) {  // Read through the result and store it
                Recipe tempRecipe = getDataFromRow(myres);
		list.add(tempRecipe);
            }		
            
            return list;
            
	}finally {  // Close the connector
            myprestm.close();
            myres.close();
        }
    }
    
    // Add new recipe
    public void insertRecipe(int pro_id, int ing_id, int amount) throws Exception{
        try{
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("insert into Recipe" 
                    + " (rep_id, product_id, ingredient_id, amount)"
                    + " value (?, ?, ?, ?)");
            // Set the query to add a new recipe with its ID is the same of the product of this recipe
            myprestm.setInt(1, pro_id);
            myprestm.setInt(2, pro_id);
            myprestm.setInt(3, ing_id);
            myprestm.setInt(4, amount);
            myprestm.executeUpdate();
            
        }
        finally{    // Close the connector
            myprestm.close();
        }
    }
    
    // Update the used amount of this ingredient
    public void updateRecipe(int rep_id, int ing_id, int amount) throws SQLException{
        try{
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("update recipe"
                    + " set amount = ?"
                    + " where rep_id = ? and ingredient_id = ?");
            // Set the query to update the used amount of this ingredient in this recipe
            myprestm.setInt(1, amount);
            myprestm.setInt(2, rep_id);
            myprestm.setInt(3, ing_id);
            myprestm.executeUpdate();
            
        } finally{  // Close the connector
            myprestm.close();
        }
    }
    
    // Delete this recipe
    public void deleteRecipe(int rep_id) throws SQLException{
        try{
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("delete from recipe where rep_id = ?");
            // Set the query to delete this whole recipe
            myprestm.setInt(1, rep_id);
            myprestm.executeUpdate();
            
        } finally { // Close the connector
            myprestm.close();
        }
        
    }
    
    // Delete the used ingredient of the recipe
    public void deleteUsedIngredient(int rep_id, int ing_id) throws SQLException{
        try{
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("delete from recipe where rep_id = ? and ingredient_id = ?");
            // Set the query to delete this ingredient from this recipe
            myprestm.setInt(1, rep_id);
            myprestm.setInt(2, ing_id);
            myprestm.executeUpdate();
            
        } finally { // Close the connector
            myprestm.close();
        }
        
    }
    
    // Get the data from the tuple
    private Recipe getDataFromRow(ResultSet myres) throws SQLException {
	// Get the informations : recipe's ID, product's ID and name, ingredient's ID, name and used amount
	int rep_id = myres.getInt("rep_id");
        int pro_id = myres.getInt("product_id");
        String pro_name = myres.getString("product_name");
        int ing_id = myres.getInt("ingredient_id");
        String ing_name = myres.getString("ingredient_name");
        int amount = myres.getInt("amount");
        
	Recipe tempRecipe = new Recipe(rep_id, pro_id, pro_name, ing_id, ing_name, amount);
	
	return tempRecipe;
        
    }
    
    // Get the ID of this ingredient 
    public int getIngredientId(int rep_id, String ing_name) throws SQLException{
        int IngredientId = 0;       //Store the ID of used ingredient
		
	try {
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("select ingredient_id from recipe natural join ingredient where rep_id = ? and ingredient_name like ?");
            // Set the query to get the ID of the ingredient with its name similar to the one user search
            myprestm.setInt(1, rep_id);
            myprestm.setString(2, ing_name);
            myres = myprestm.executeQuery();

            if(myres.next()) {  // If theere is this ingredient in this recipe
                // Get this ingredient's ID 
                IngredientId = myres.getInt("ingredient_id");
            }

            return IngredientId;
            
	}
	finally {   // Close the connector
            myprestm.close();
            myres.close();
	}
    }
    
    // Check if this ingredient is used to make this product
    public boolean isUsed(int pro_id, int ing_id) throws SQLException{
        boolean isUsed = false;
		
	try {
            // Prepare, execute and get the result from the query
            myprestm = myconn.prepareStatement("select * from recipe where product_id = ? and ingredient_id = ?");
            // Set the query to check if this ingredient is to make this product
            myprestm.setInt(1, pro_id);
            myprestm.setInt(2, ing_id);
            myres = myprestm.executeQuery();

            if (myres.next()) { // If it is used
                isUsed = true;
            }

            return isUsed;
            
	}
	finally {   // Close the connector
            myprestm.close();
            myres.close();
	}
    }
    
}
