/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import Core.Ingredient;

/**
 *
 * @author User
 */
public class IngredientTableModel extends AbstractTableModel {
    // For switch function
    public static final int OBJECT_COL = -1;
    private static final int ID_COL = 0;
    private static final int INGREDIENT_NAME_COL = 1;
    private static final int AMOUNT_KG_COL = 2;
    
    // Name of each attribute
    private String[] columnNames = {"Ingredient ID", "Ingredient Name", "Amount (Kilogram)"};
    private List<Ingredient> ingredient;    // Store data of this table
    
    // Get the data for this table
    public IngredientTableModel(List<Ingredient> ingredient)
    {
        this.ingredient = ingredient;
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
        return ingredient.size();
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
        Ingredient tempIngredient = ingredient.get(row);
        
        switch(col) {
            case ID_COL:                    // Get ingredient's ID
                return tempIngredient.getIngId();
            case INGREDIENT_NAME_COL:       // Get ingredient's name
                return tempIngredient.getIngName();
            case AMOUNT_KG_COL:             // Get ingredient's amount in central kitchen
                return tempIngredient.getStock();
            case OBJECT_COL:                // Get "Ingredient" class
                return tempIngredient;
            default:                        // Get ingredient's ID
                return tempIngredient.getIngId();
        }
    }
    
    @Override
// Get the class of the tuple
    public Class getColumnClass(int col)
    {
        return getValueAt(0, col).getClass();
    }
}
