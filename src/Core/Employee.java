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
public class Employee {     // Handling informations of each employee
    // Store the employee's informations : ID, name, password, phone number, position, branch
    private int emp_id;
    private String emp_name;
    private String emp_pass;
    private String emp_tel;
    private String emp_pos;
    private String branch_name;
    
    // Store the employee's informations
    public Employee (int emp_id, String emp_name, String emp_pass, String emp_tel, String emp_pos, String branch_name) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_pass = emp_pass;
        this.emp_pos = emp_pos;
        this.emp_tel = emp_tel;
        this.branch_name = branch_name;
    }
    
    // For checking ID and password of the user (employee) when log in
    public Employee (int emp_id, String emp_pass){
        this.emp_id = emp_id;
        this.emp_pass = emp_pass;
    }
    
    // Get the ID of this employee
    public int getEmpId() {
        return emp_id;
    }
    
    // Set the ID of this employee
    public void setEmpId(int emp_id) {
        this.emp_id = emp_id;
    }
    
    // Get the name of this employee
    public String getEmpName() {
        return emp_name;
    }
    
    // Set the name of this employee
    public void setEmpName(String emp_name) {
        this.emp_name = emp_name;
    }
    
    // Get the password of this employee
    public String getEmpPass() {
        return emp_pass;
    }
    
    // Set the password of this employee
    public void setEmpPass(String emp_pass) {
        this.emp_pass = emp_pass;
    }
    
    // Get the telephone number of this employee
    public String getEmpTel() {
        return emp_tel;
    }
    
    // Set the telephone number of this employee
    public void setEmpTel(String emp_tel) {
        this.emp_tel = emp_tel;
    }
    
    // Get the position of this employee
    public String getEmpPos() {
        return emp_pos;
    }
    
    // Set the position of this employee
    public void setEmpPos(String emp_pos) {
        this.emp_pos = emp_pos;
    }
    
    // Get the branch of this employee
    public String getBranchName() {
        return branch_name;
    }
    
    // Set the branch of this employee
    public void setBranchName(String branch_name) {
        this.branch_name = branch_name;
    }
}
