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
public class Import {       // Handling informations when import a product
    // Store the import's informations : import's ID, product's ID, name and imported amount, import date, branch and order's ID
    private int imp_id;             // Store import's ID
    private int pro_id;             // Store product's ID
    private String pro_name;        // Store product's name
    private int amount;             // Store the amount of product being imported
    private String imp_date;        // Store when the import happened
    private String branch_name;     // Store which branch import the product
    private int order_id;           // Store order's ID
    
    // Store the import's informations
    public Import (int imp_id, int pro_id, String pro_name, int amount, String imp_date, String branch_name, int order_id) {
        this.imp_id = imp_id;
        this.pro_id = pro_id;
        this.pro_name = pro_name;
        this.amount = amount;
        this.imp_date = imp_date;
        this.branch_name = branch_name;
        this.order_id = order_id;
    }
    
    // Get the ID of this import
    public int getImpId() {
        return imp_id;
    }
    // Set the ID of this import
    public void setImpId(int imp_id) {
        this.imp_id = imp_id;
    }
    
    // Get the ID of the imported product
    public int getProId(){
        return pro_id;
    }
    
    // Set the ID of the imported product
    public void setProId(int pro_id){
        this.pro_id = pro_id;
    }
    
    // Get the name of the imported product
    public String getProName() {
        return pro_name;
    }
    
    // Set the name of the imported product
    public void setProName(String pro_name) {
        this.pro_name = pro_name;
    }
    
    // Get the amount of product being imported
    public int getAmount() {
        return amount;
    }
    
    // Set the amount of product being imported
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    // Get the date of this import
    public String getImpDate() {
        return imp_date;
    }
    
    // Set the date of this import
    public void setImpDate(String imp_date) {
        this.imp_date = imp_date;
    }
   
    // Get the name of the branch
    public String getBranchName() {
        return branch_name;
    }
    
    // Set the name of the branch
    public void setBranchName(String branch_name) {
        this.branch_name = branch_name;
    }
        
    // Get the ID of the order
    public int getOrderId() {
        return order_id;
    }
    
    // Set the ID of the order
    public void setOrderId(int order_id) {
        this.order_id = order_id;
    }
}
