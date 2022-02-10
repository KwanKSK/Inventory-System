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
public class Orders {           // Handling informations when ordering some products
    // Store the order's informations : order's ID and status, product's name and ordered amount, branch's name, order and received date
    private int order_id;
    private String pro_name;    
    private int amount;          
    private String order_date;    
    private String received_date;  
    private String branch_name;     
    private String order_status;    
    
    // Store the order's informations
    public Orders (int order_id, String pro_name, int amount, String order_date, String received_date, String branch_name, String order_status) {
        this.order_id = order_id;
        this.pro_name = pro_name;
        this.amount = amount;
        this.order_date = order_date;
        if(received_date == null) this.received_date = "null"; 
        else this.received_date = received_date;
        this.branch_name = branch_name;
        this.order_status = order_status;
    }
    
    // Get the ID of this order
    public int getOrderId() {
        return order_id;
    }
    
    // Set the ID of this order
    public void setOrderId(int order_id) {
        this.order_id = order_id;
    }
    
    // Get the name of the ordered product
    public String getProName() {
        return pro_name;
    }
    
    // Set the name of the ordered product
    public void setProName(String pro_name) {
        this.pro_name = pro_name;
    }
    
    // Get the amount of product being ordered
    public int getAmount() {
        return amount;
    }
    
    // Set the amount of product being ordered
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    // Get the date of this order
    public String getOrderDate() {
        return order_date;
    }
    
    // Set the date of this order
    public void setOrderDate(String order_date) {
        this.order_date = order_date;
    }
    
    // Get the date when the product is received
    public String getReceivedDate() {
        return received_date;
    }
    
    // Set the date when the product is received
    public void setReceivedDate(String received_date) {
        this.received_date = received_date;
    }
    
    // Get the name of the branch
    public String getBranchName() {
        return branch_name;
    }
    
    // Set the name of the branch
    public void setBranchName(String branch_name) {
        this.branch_name = branch_name;
    }
    
    // Get the status of this order
    public String getOrderStatus() {
        return order_status;
    }
    
    // Set the status of this order
    public void setOrderStatus(String order_status) {
        this.order_status = order_status;
    }
    
}
