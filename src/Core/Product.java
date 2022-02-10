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
public class Product {          // Handling informations of each product in central kitchen
    // Store product's informations : ID, name, amount in central kitchen and status indicating is it sale or not
    private int pro_id;
    private String pro_name;
    private int stock;
    private String status;
    
    // Store the product's informations
    public Product(int pro_id, String pro_name, int stock, String status){
        this.pro_id = pro_id;
        this.pro_name = pro_name;
        this.stock = stock;
        this.status = status;
    }
    
    // Get the ID of this product
    public int getProId() {
        return pro_id;
    }
    
    // Set the ID of this product
    public void setProId(int pro_id) {
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
    public int getStock() {
        return stock;
    }
    
    // Set the amount of this product
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    // Get the status of this product
    public String getStatus(){
        return status;
    }
    
    // Set the status of this product
    public void setStatus(String status){
        this.status = status;
    }
    
}
