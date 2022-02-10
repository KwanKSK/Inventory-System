/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import Core.Employee;

/**
 *
 * @author User
 */
public class EmployeeTableModel extends AbstractTableModel {
    // For switch function
    public static final int OBJECT_COL = -1;
    private static final int ID_COL = 0;
    private static final int NAME_COL = 1;
    private static final int POSITION_COL = 2;
    private static final int TELEPHONE_NUMBER_COL = 3;
    
    // Name of each attribute
    private String[] columnNames = {"ID", "Name", "Position", "Tel."};
    private List<Employee> employee;    // Store data of this table
    
    // Get the data for this table
    public EmployeeTableModel(List<Employee> employee)
    {
        this.employee = employee;
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
        return employee.size();
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
        Employee tempEmployee = employee.get(row);
        
        switch(col) {
            case ID_COL:                    // Get employee's ID
                return tempEmployee.getEmpId();
            case NAME_COL:                  // Get employee's name
                return tempEmployee.getEmpName();
            case POSITION_COL:              // Get employee's position
                return tempEmployee.getEmpPos();
            case TELEPHONE_NUMBER_COL:      // Get employee's phone number
                return tempEmployee.getEmpTel();
            case OBJECT_COL:                // Get "Employee" class
                return tempEmployee;
            default:                        // Get employee's ID
                return tempEmployee.getEmpId();
        }
    }
    
    @Override
    // Get the class of the tuple
    public Class getColumnClass(int col)
    {
        return getValueAt(0, col).getClass();
    }
}
