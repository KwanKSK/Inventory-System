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
public class Branch {   // Handling informations of each branch
    // Store the branch's informations : name, address, phone number
    private String branch_name;
    private String branch_add;
    private String branch_tel;
    
    // Store the branch's informations
    public Branch (String branch_name, String branch_add, String branch_tel) {
        this.branch_name = branch_name;
        this.branch_add = branch_add;
        this.branch_tel = branch_tel;
    }
    
    // Get the name of this branch
    public String getBranchName() {
        return branch_name;
    }
    
    // Set the name of this branch
    public void setBranchName(String branch_name) {
        this.branch_name = branch_name;
    }
    
    // Get the address of this branch
    public String getBranchAdd() {
        return branch_add;
    }
    
    // Set the address of this branch
    public void setBranchAdd(String branch_add) {
        this.branch_add = branch_add;
    }
    
    // Get the telephone number of this branch
    public String getBranchTel() {
        return branch_tel;
    }
    
    // Set the telephone number of this branch
    public void setBranchTel(String branch_tel) {
        this.branch_tel = branch_tel;
    }
}


