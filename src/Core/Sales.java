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
public class Sales {                // Handling informations when product is sold
    // Store the sales informations : sale's ID, branch's name, product's ID, name and sold amount, sale date
    private int sales_id;     
    private String branch_name;   
    private int pro_id;     
    private String pro_name;    
    private int amount;    
    private String sales_date;    
    
    // Store the sale's informations
    public Sales (int sales_id, String branch_name, int pro_id, String pro_name, int amount, String sales_date) {
        this.sales_id = sales_id;
        this.branch_name = branch_name;
        this.pro_id = pro_id;
        this.pro_name = pro_name;
        this.amount = amount;
        this.sales_date = sales_date;
    }

    // Get the ID of this sale
    public int getSalesId() {
        return sales_id;
    }
    
    // Set the ID of this sale
    public void setSalesId(int sales_id) {
        this.sales_id = sales_id;
    }
    
    // Get the ID of the sold product
    public int getProId(){
        return pro_id;
    }
    
    // Set the ID of the sold product
    public void setProId(int pro_id){
        this.pro_id = pro_id;
    }
    
    // Get the name of the sold product
    public String getProName() {
        return pro_name;
    }
    
    // Set the name of the sold product
    public void setProName(String pro_name) {
        this.pro_name = pro_name;
    }
    
    // Get the name of the branch
    public String getBranchName() {
        return branch_name;
    }
    
    // Set the name of the branch
    public void setBranchName(String branch_name) {
        this.branch_name = branch_name;
    }
    
    // Get the amount of product being sold
    public int getAmount() {
        return amount;
    }
    
    // Set the amount of product being sold
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    // Get the date when the product sold
    public String getSalesDate() {
        return sales_date;
    }
    
    // Set the date when the product sold
    public void setSalesDate(String sales_date) {
        this.sales_date = sales_date;
    }
}
