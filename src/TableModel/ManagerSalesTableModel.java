/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import Core.Sales;

/**
 *
 * @author User
 */
public class ManagerSalesTableModel extends AbstractTableModel {
    // For switch function
    public static final int OBJECT_COL = -1;
    private static final int ID_COL = 0;
    private static final int PRODUCT_NAME_COL = 1;
    private static final int AMOUNT_PIECE_COL = 2;
    private static final int SALE_DATE_COL = 3;
    
    // Name of each attribute
    private String[] columnNames = {"Sales ID", "Product Name", "Amount (Piece)", "Sale Date"};
    private List<Sales> sales;  // Store data of this table
    
    // Get the data for this table
    public ManagerSalesTableModel(List<Sales> sales)
    {
        this.sales = sales;
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
        return sales.size();
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
        Sales tempSales = sales.get(row);
        
        switch(col) {
            case ID_COL:                // Get sale's ID
                return tempSales.getSalesId();
            case PRODUCT_NAME_COL:      // Get product's name
                return tempSales.getProName();
            case AMOUNT_PIECE_COL:      // Get product's sold amount
                return tempSales.getAmount();
            case SALE_DATE_COL:         // Get sale date
                return tempSales.getSalesDate();
            case OBJECT_COL:            // Get "Sales" class
                return tempSales;
            default:                    // Get sale's ID
                return tempSales.getSalesId();
        }
    }
    
    @Override
    // Get the class of the tuple
    public Class getColumnClass(int col)
    {
        return getValueAt(0, col).getClass();
    }
}
