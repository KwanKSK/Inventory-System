/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import Core.Recipe;

/**
 *
 * @author User
 */
public class RecipeTableModel extends AbstractTableModel{
    // For switch function
    public static final int OBJECT_COL = -1;
    private static final int ID_COL = 0;
    private static final int PRODUCT_NAME_COL = 1;
    private static final int INGREDIENT_NAME_COL = 2;
    private static final int USED_AMOUNT_KG_COL = 3;
    
    // Name of each attribute
    private String[] columnNames = {"Recipe ID", "Product Name", "Ingredient Name", "Used Amount (Kilogram)"};
    private List<Recipe> recipe;    // Store data of this table
    
    // Get the data for this table
    public RecipeTableModel(List<Recipe> recipe)
    {
        this.recipe = recipe;
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
        return recipe.size();
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
        Recipe tempRecipe = recipe.get(row);
        
        switch(col) {
            case ID_COL:                        // Get recipe's ID
                return tempRecipe.getRepId();
            case PRODUCT_NAME_COL:              // Get product's name
                return tempRecipe.getProName();
            case INGREDIENT_NAME_COL:           // Get ingredient's name
                return tempRecipe.getIngName();
            case USED_AMOUNT_KG_COL:            // Get ingredient's used amount
                return tempRecipe.getAmount();
            case OBJECT_COL:                    // Get "Recipe" class
                return tempRecipe;
            default:                            // Get recipe's ID
                return tempRecipe.getRepId();
        }
    }
    
    @Override
    // Get the class of the tuple
    public Class getColumnClass(int col)
    {
        return getValueAt(0, col).getClass();
    }
}
