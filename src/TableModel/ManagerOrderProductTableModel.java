/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModel;

import Core.Product;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gurum
 */
public class ManagerOrderProductTableModel extends AbstractTableModel{
    // For switch function
    public static final int OBJECT_COL = -1;
    private static final int ID_COL = 0;
    private static final int PRODUCT_NAME_COL = 1;
    
    // Name of each attribute
    private String[] columnNames = {"Product ID", "Product Name"};
    private List<Product> product;  // Store data of this table
    
    // Get the data for this table
    public ManagerOrderProductTableModel(List<Product> product)
    {
        this.product = product;
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
        return product.size();
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
        Product tempProduct = product.get(row);
        
        switch(col) {
            case ID_COL:                // Get product's ID
                return tempProduct.getProId();
            case PRODUCT_NAME_COL:      // Get product's name
                return tempProduct.getProName();
            case OBJECT_COL:            // Get "Product" class
                return tempProduct;
            default:                    // Get product's ID
                return tempProduct.getProId();
        }
    }
    
    @Override
    // Get the class of the tuple
    public Class getColumnClass(int col)
    {
        return getValueAt(0, col).getClass();
    }
}
