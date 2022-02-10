/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import Core.Orders;

/**
 *
 * @author User
 */
public class CEOOrderTableModel extends AbstractTableModel {
    // For switch function
    public static final int OBJECT_COL = -1;
    private static final int ID_COL = 0;
    private static final int BRANCH_NAME_COL = 1;
    private static final int PRODUCT_NAME_COL = 2;
    private static final int AMOUNT_BOX_COL = 3;
    private static final int ORDER_DATE_COL = 4;
    private static final int STATUS_COL = 5;
    
    // Name of each attribute
    private String[] columnNames = {"Order ID", "Branch Name", "Product Name", "Amount (Box)", "Order Date", "Status"};
    private List<Orders> orders;    // Store data of this table
    
    // Get the data for this table
    public CEOOrderTableModel(List<Orders> orders)
    {
        this.orders = orders;
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
        return orders.size();
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
        Orders tempOrders = orders.get(row);
        
        switch(col) {
            case ID_COL:                // Get order's ID
                return tempOrders.getOrderId();
            case BRANCH_NAME_COL:       // Get branch's name
                return tempOrders.getBranchName();
            case PRODUCT_NAME_COL:      // Get product's name
                return tempOrders.getProName();
            case AMOUNT_BOX_COL:        // Get product's ordered amount
                return tempOrders.getAmount();
            case ORDER_DATE_COL:        // Get order date
                return tempOrders.getOrderDate();
            case STATUS_COL:            // Get order's status
                return tempOrders.getOrderStatus();
            case OBJECT_COL:            // Get "Orders" class
                return tempOrders;
            default:                    // Get order's ID
                return tempOrders.getOrderId();
        }
    }
    
    @Override
    // Get the class of the tuple
    public Class getColumnClass(int col)
    {
        return getValueAt(0, col).getClass();
    }
}
