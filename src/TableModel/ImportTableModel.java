/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import Core.Import;

/**
 *
 * @author User
 */
public class ImportTableModel extends AbstractTableModel {
    // For switch function
    public static final int OBJECT_COL = -1;
    private static final int ID_COL = 0;
    private static final int PRODUCT_NAME_COL = 1;
    private static final int AMOUNT_BOX_COL = 2;
    private static final int IMPORT_DATE_COL = 3;
    
    // Name of each attribute
    private String[] columnNames = {"Import ID", "Product Name", "Amount (Box)", "Import Date"};
    private List<Import> import_pro;    // Store data of this table
    
    // Get the data for this table
    public ImportTableModel(List<Import> import_pro)
    {
        this.import_pro = import_pro;
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
        return import_pro.size();
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
        Import tempImport = import_pro.get(row);
        
        switch(col) {
            case ID_COL:                // Get import's ID
                return tempImport.getImpId();
            case PRODUCT_NAME_COL:      // Get product's ID
                return tempImport.getProName();
            case AMOUNT_BOX_COL:        // Get product's imported amount
                return tempImport.getAmount();
            case IMPORT_DATE_COL:       // Get import date
                return tempImport.getImpDate();
            case OBJECT_COL:            // Get "Import" class
                return tempImport;
            default:                    // Get import's ID
                return tempImport.getImpId();
        }
    }
    
    @Override
    // Get the class of the tuple
    public Class getColumnClass(int col)
    {
        return getValueAt(0, col).getClass();
    }
}
