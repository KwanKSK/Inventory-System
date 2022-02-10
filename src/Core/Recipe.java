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
public class Recipe {           // Handling informations of recipe
    // Store the recipe's informations : recipe's ID, product's ID and name, ingredient's ID, name and used amount
    private int rep_id;
    private int pro_id;
    private String pro_name;
    private int ing_id;
    private String ing_name;
    private int amount;
    
    // Store the recipe's informations
    public Recipe (int rep_id, int pro_id, String pro_name, int ing_id, String ing_name, int amount) {
        this.rep_id = rep_id;
        this.pro_id = pro_id;
        this.pro_name = pro_name;
        this.ing_id = ing_id;
        this.ing_name = ing_name;
        this.amount = amount;
    }
    
    // Get the ID of this recipe
    public int getRepId() {
        return rep_id;
    }
    
    // Set the ID of this recipe
    public void setRepId(int rep_id) {
        this.rep_id = rep_id;
    }
    
    // Get the ID of the product
    public int getProId(){
        return pro_id;
    }
    
    // Set the ID of the product
    public void setProId(int pro_id){
        this.pro_id = pro_id;
    }
    
    // Get the name of the product
    public String getProName() {
        return pro_name;
    }
    
    // Set the name of the product
    public void setProId(String pro_name) {
        this.pro_name = pro_name;
    }
    
    // Get the ID of the used ingredient
    public int getIngId(){
        return ing_id;
    }
    
    // Set the ID of the used ingredient
    public void setIngId(int ing_id){
        this.ing_id = ing_id;
    }
    
    // Get the name of the used ingredient
    public String getIngName() {
        return ing_name;
    }
    // Set the name of the used ingredient
    public void setIngName(String ing_name) {
        this.ing_name = ing_name;
    }
    
    // Get the amount of ingredient being used
    public int getAmount() {
        return amount;
    }
    
    // Set the amount of ingredient being used
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
