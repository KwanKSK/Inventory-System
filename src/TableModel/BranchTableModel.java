/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import Core.Branch;

/**
 *
 * @author User
 */
public class BranchTableModel extends AbstractTableModel {
    // For switch function
    public static final int OBJECT_COL = -1;
    private static final int BRANCH_NAME_COL = 0;
    private static final int BRANCH_ADDRESS_COL = 1;
    private static final int TELEPHONE_NUMBER_COL = 2;
    
    // Name of each attribute
    private String[] columnNames = {"Branch Name", "Branch Address", "Tel."};
    private List<Branch> branch;    // Store data of this table
    
    // Get the data for this table
    public BranchTableModel(List<Branch> branch)
    {
        this.branch = branch;
    }
    
    @Override
    // Count the attributes of this table
    public int getColumnCount()
    {
        return columnNames.length;
    }
    
    @Override
    // Count the tuples of this table
    public int getRowCount()
    {
        return branch.size();
    }
    
    @Override
    // Get the attribute's name of this column
    public String getColumnName(int col)
    {
        return columnNames[col];
    }
    
    @Override
    // Get the attribute of this tuple
    public Object getValueAt(int row, int col)
    {
        Branch tempBranch = branch.get(row);
        
        switch(col) {
            case BRANCH_NAME_COL:           // Get branch's name
                return tempBranch.getBranchName();
            case BRANCH_ADDRESS_COL:        // Get branch's address
                return tempBranch.getBranchAdd();
            case TELEPHONE_NUMBER_COL:      // Get branch's phone number
                return tempBranch.getBranchTel();
            case OBJECT_COL:                // Get "Branch" class
                return tempBranch;
            default:                        // Get branch's name
                return tempBranch.getBranchName();
        }
    }
    
    @Override
    // Get the class of the tuple
    public Class getColumnClass(int col)
    {
        return getValueAt(0, col).getClass();
    }
}
