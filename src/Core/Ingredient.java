/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

/**
 *
 * @author Kwan KSK
 */
public class Ingredient {       // Handling informations of each ingredient in central kitchen
    // Store the ingredient's informations : ID, name, amount in central kitchen
    private int ing_id;
    private String ing_name;
    private int stock; 
    
    
    // Store the ingredient's informations
    public Ingredient(int ing_id, String ing_name, int stock){
        this.ing_id = ing_id;
        this.ing_name = ing_name;
        this.stock = stock;      
    }
    
    // Get the ID of this ingredient
    public int getIngId() {
        return ing_id;
    }
    
    // Set the ID of this ingredient
    public void setIngId(int ing_id) {
        this.ing_id = ing_id;
    }
    
    // Get the name of this ingredient
    public String getIngName() {
        return ing_name;
    }
    
    // Set the name of this ingredient
    public void setIngName(String ing_name) {
        this.ing_name = ing_name;
    }
    
    // Get the amount of this ingredient
    public int getStock() {
        return stock;
    }
    
    // Set the amount of this ingredient
    public void setStock(int stock) {
        this.stock = stock;
    }
    
}
