/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import Core.Stock;

/**
 *
 * @author User
 */
public class StockTableModel extends AbstractTableModel {
    // For switch function
    public static final int OBJECT_COL = -1;
    private static final int ID_COL = 0;
    private static final int PRODUCT_NAME_COL = 1;
    private static final int AMOUNT_PIECE_COL = 2;
    
    // Name of each attribute
    private String[] columnNames = {"Product ID", "Product Name", "Amount (Piece)"};
    private List<Stock> stock;  // Store data of this table
    
    // Get the data for this table
    public StockTableModel(List<Stock> stock)
    {
        this.stock = stock;
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
        return stock.size();
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
        Stock tempStock = stock.get(row);
        
        switch(col) {
            case ID_COL:                // Get product's ID
                return tempStock.getProId();
            case PRODUCT_NAME_COL:      // Get product's name
                return tempStock.getProName();
            case AMOUNT_PIECE_COL:      // Get product's amount in the branch
                return tempStock.getAmount();
            case OBJECT_COL:            // Get "stock" class
                return tempStock;
            default:                    // Get product's ID
                return tempStock.getProId();
        }
    }
    
    @Override
    // Get the class of the tuple
    public Class getColumnClass(int col)
    {
        return getValueAt(0, col).getClass();
    }
}
