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
public class Stock {                // Handling informations of each product in each branch
    // Store the stock's informations : branch's name, product's ID, name, amount in this branch
    private String branch_name;     // Store branch's name
    private int pro_id;             // Store product's ID
    private String pro_name;        // Store product's name
    private int amount;             // Store the amount of product in this branch
    
    // Store the stock's informations
    public Stock (String branch_name, int pro_id, String pro_name, int amount) {
        this.branch_name = branch_name;
        this.pro_id = pro_id;
        this.pro_name = pro_name;
        this.amount = amount;
    }
    
    // Get the name of the branch
    public String getBranchName() {
        return branch_name;
    }
    
    // Set the name of the branch
    public void setBranchName(String branch_name) {
        this.branch_name = branch_name;
    }
    
    // Get the ID of this product
    public int getProId(){
        return pro_id;
    }
    
    // Set the ID of this porduct
    public void setProId(int pro_id){
        this.pro_id = pro_id;
    }
    
    // Get the name of this product
    public String getProName() {
        return pro_name;
    }
    
    // Set the name of this product
    public void setProName(String pro_name) {
        this.pro_name = pro_name;
    }
    
    // Get the amount of this product
    public int getAmount() {
        return amount;
    }
    
    // Set the amount of this product
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
    
}
