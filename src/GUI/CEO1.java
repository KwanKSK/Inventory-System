package GUI;

import Core.*;
import DAO.*;
import TableModel.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author witoo
 */
public class CEO1 extends javax.swing.JFrame {
    private SaleDAO saleDAO;
    private RecipeDAO recipeDAO;
    private IngredientDAO ingredientDAO;
    private BranchDAO branchDAO;
    private ProductDAO productDAO;
    private OrderDAO orderDAO;
    private String[] days = {"--", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
                                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", 
                                "21","22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    private int check;
    
    /**
     * Creates new form CEO1
     */
    public CEO1() {
        initComponents();
        try
        {
            saleDAO = new SaleDAO();
            recipeDAO = new RecipeDAO();
            ingredientDAO = new IngredientDAO();
            branchDAO = new BranchDAO();
            productDAO = new ProductDAO();
            orderDAO = new OrderDAO();
            
            // Set the width of each column and populate the table
            List<Product> product_list = productDAO.getAllProducts();
            CEOProductTableModel product_model = new CEOProductTableModel(product_list);
          
            ProductInStock_View_Table.setModel(product_model);
            TableColumnModel Product_View_columnModel = ProductInStock_View_Table.getColumnModel();
            Product_View_columnModel.getColumn(0).setPreferredWidth(20);
            Product_View_columnModel.getColumn(1).setPreferredWidth(250);
            Product_View_columnModel.getColumn(2).setPreferredWidth(20);
            
            product_table_recipe.setModel(product_model);
            TableColumnModel Product_recipe_columnModel = product_table_recipe.getColumnModel();
            Product_recipe_columnModel.getColumn(0).setPreferredWidth(20);
            Product_recipe_columnModel.getColumn(1).setPreferredWidth(250);
            Product_recipe_columnModel.getColumn(2).setPreferredWidth(50);
            
            List<Ingredient> ingredient_list = ingredientDAO.getAllIngredients();
            IngredientTableModel ingredient_model = new IngredientTableModel(ingredient_list);
            
            Ingredient_View_Table.setModel(ingredient_model);
            TableColumnModel Ingredient_View_columnModel = Ingredient_View_Table.getColumnModel();
            Ingredient_View_columnModel.getColumn(0).setPreferredWidth(20);
            Ingredient_View_columnModel.getColumn(1).setPreferredWidth(250);
            Ingredient_View_columnModel.getColumn(2).setPreferredWidth(20);
            
            ingredient_table_recipe.setModel(ingredient_model);
            TableColumnModel Ingredient_table_columnModel = ingredient_table_recipe.getColumnModel();
            Ingredient_table_columnModel.getColumn(0).setPreferredWidth(20);
            Ingredient_table_columnModel.getColumn(1).setPreferredWidth(250);
            Ingredient_table_columnModel.getColumn(2).setPreferredWidth(50);
            
            List<Recipe> recipe_list = recipeDAO.getAllRecipes();
            RecipeTableModel recipe_model = new RecipeTableModel(recipe_list);
            
            Recipe_View_Table.setModel(recipe_model);
            TableColumnModel Recipe_View_columnModel = Recipe_View_Table.getColumnModel();
            Recipe_View_columnModel.getColumn(0).setPreferredWidth(20);
            Recipe_View_columnModel.getColumn(1).setPreferredWidth(150);
            Recipe_View_columnModel.getColumn(2).setPreferredWidth(100);
            Recipe_View_columnModel.getColumn(3).setPreferredWidth(100);
            
            List<Orders> orders_list = orderDAO.getAllOrders();
            CEOOrderTableModel orders_model = new CEOOrderTableModel(orders_list);
            
            View_OrderShipment_Table.setModel(orders_model);
            TableColumnModel OrderShipment_View_columnModel = View_OrderShipment_Table.getColumnModel();
            OrderShipment_View_columnModel.getColumn(0).setPreferredWidth(6);
            OrderShipment_View_columnModel.getColumn(1).setPreferredWidth(80);
            OrderShipment_View_columnModel.getColumn(2).setPreferredWidth(80);
            OrderShipment_View_columnModel.getColumn(3).setPreferredWidth(45);
            OrderShipment_View_columnModel.getColumn(4).setPreferredWidth(100);
            OrderShipment_View_columnModel.getColumn(5).setPreferredWidth(15);
            
            List<Orders> orders_log = orderDAO.getAllCompletedOrders();
            CEOOrderTableModel orders_log_model = new CEOOrderTableModel(orders_log);
            
            View_OrderLog_Table1.setModel(orders_log_model);
            TableColumnModel OrderLog_View_columnModel = View_OrderLog_Table1.getColumnModel();
            OrderLog_View_columnModel.getColumn(0).setPreferredWidth(6);
            OrderLog_View_columnModel.getColumn(1).setPreferredWidth(80);
            OrderLog_View_columnModel.getColumn(2).setPreferredWidth(80);
            OrderLog_View_columnModel.getColumn(3).setPreferredWidth(45);
            OrderLog_View_columnModel.getColumn(4).setPreferredWidth(100);
            OrderLog_View_columnModel.getColumn(5).setPreferredWidth(15);
            
            List<Branch> branch_list = branchDAO.getAllBranches();
            BranchTableModel branch_model = new BranchTableModel(branch_list);
            
            Branch_View_Table.setModel(branch_model);
            TableColumnModel Branch_View_columnModel = Branch_View_Table.getColumnModel();
            Branch_View_columnModel.getColumn(0).setPreferredWidth(75);
            Branch_View_columnModel.getColumn(1).setPreferredWidth(305);
            Branch_View_columnModel.getColumn(2).setPreferredWidth(10);
            
            List<Sales> sales_list = saleDAO.getAllSales();
            CEOSalesTableModel sales_model = new CEOSalesTableModel(sales_list);
            
            Sales_View_Table.setModel(sales_model);
            TableColumnModel Sales_View_columnModel = Sales_View_Table.getColumnModel();
            Sales_View_columnModel.getColumn(0).setPreferredWidth(100);
            Sales_View_columnModel.getColumn(1).setPreferredWidth(100);
            Sales_View_columnModel.getColumn(2).setPreferredWidth(10);
            
        }
        catch(Exception exc)
        {
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CEO_Button_Panel = new javax.swing.JPanel();
        Stock_Button = new javax.swing.JButton();
        Recipe_Button = new javax.swing.JButton();
        Orders_Button = new javax.swing.JButton();
        Branches_Button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        Logout = new javax.swing.JButton();
        CEO_Tabbed_Panel = new javax.swing.JTabbedPane();
        Stock_Tab = new javax.swing.JPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        Stock_Sub_Tab = new javax.swing.JTabbedPane();
        ProductinKitchen_Tab = new javax.swing.JPanel();
        View_ProductInStock_Name_TextField = new javax.swing.JTextField();
        SearchProduct_Button = new javax.swing.JButton();
        ProductInStiock_View_ScrollPanel = new javax.swing.JScrollPane();
        ProductInStock_View_Table = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        UpdateProduct_Button = new javax.swing.JButton();
        InactiveProduct_Button = new javax.swing.JButton();
        AddProduct_Button = new javax.swing.JButton();
        ActiveProduct_Button = new javax.swing.JButton();
        Ingredient_Tab = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        View_Ingredient_Name_TextField = new javax.swing.JTextField();
        SearchIngredient_Button = new javax.swing.JButton();
        Ingredient_View_ScrollPanel = new javax.swing.JScrollPane();
        Ingredient_View_Table = new javax.swing.JTable();
        AddIngredient_Button = new javax.swing.JButton();
        UpdateIngredient_Button = new javax.swing.JButton();
        RemoveIngredient_Button = new javax.swing.JButton();
        Recipe_Tab = new javax.swing.JPanel();
        Add_Sub_Tab = new javax.swing.JTabbedPane();
        Search_Recipe_Tab = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        View_Recipe_Product_Name_TextField = new javax.swing.JTextField();
        SearchRecipe_Button = new javax.swing.JButton();
        Recipe_View_ScrollPanel = new javax.swing.JScrollPane();
        Recipe_View_Table = new javax.swing.JTable();
        RemoveUsedIngredient_Button = new javax.swing.JButton();
        UpdateRecipe_Button = new javax.swing.JButton();
        RemoveRecipe_Button = new javax.swing.JButton();
        Add_Recipe_Tab = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        Add_Recipe_Product_Name_TextField = new javax.swing.JTextField();
        Add_Recipe_Ingredient_Name_TextField = new javax.swing.JTextField();
        Add_Recipe_Ingredient_Amount_TextField = new javax.swing.JTextField();
        AddRecipe_Button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        product_table_recipe = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        ingredient_table_recipe = new javax.swing.JTable();
        SearchRecipeAdd_Button = new javax.swing.JButton();
        SearchUsedIngredient_Button = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        Order_Tab = new javax.swing.JPanel();
        kGradientPanel6 = new keeptoo.KGradientPanel();
        Order_Sub_Tab = new javax.swing.JTabbedPane();
        OrderProduct_Tab = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        View_Order_BranchName_TextField = new javax.swing.JTextField();
        View_Order_ProductName_TextField = new javax.swing.JTextField();
        SearchOrder_Button = new javax.swing.JButton();
        ConfirmShipment_Button = new javax.swing.JButton();
        View_Order_Scroll = new javax.swing.JScrollPane();
        View_OrderShipment_Table = new javax.swing.JTable();
        CompletedOrder_Tab = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        View_Order_BranchName_TextField1 = new javax.swing.JTextField();
        View_Order_ProductName_TextField1 = new javax.swing.JTextField();
        SearchCompletedOrder_Button = new javax.swing.JButton();
        View_Order_Scroll1 = new javax.swing.JScrollPane();
        View_OrderLog_Table1 = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        Branchs_Tab = new javax.swing.JPanel();
        kGradientPanel8 = new keeptoo.KGradientPanel();
        Branchs_Sub_Tab = new javax.swing.JTabbedPane();
        Branch_Tab = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        View_Branch_Name_TextField = new javax.swing.JTextField();
        SearchBranch_Button = new javax.swing.JButton();
        Branch_View_ScrollPanel = new javax.swing.JScrollPane();
        Branch_View_Table = new javax.swing.JTable();
        Sales_Tab = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        View_Sales_Branch_name_TextField1 = new javax.swing.JTextField();
        View_Sales_Product_Name_TextField1 = new javax.swing.JTextField();
        SearchSale_Button = new javax.swing.JButton();
        Sales_View_Scroll = new javax.swing.JScrollPane();
        Sales_View_Table = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome CEO");
        setMinimumSize(new java.awt.Dimension(855, 570));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CEO_Button_Panel.setBackground(new java.awt.Color(88, 171, 255));
        CEO_Button_Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        CEO_Button_Panel.setOpaque(false);

        Stock_Button.setBackground(new java.awt.Color(88, 171, 255));
        Stock_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Stock_Button.setForeground(new java.awt.Color(255, 255, 255));
        Stock_Button.setText("Stock");
        Stock_Button.setToolTipText("");
        Stock_Button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.darkGray));
        Stock_Button.setContentAreaFilled(false);
        Stock_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Stock_ButtonActionPerformed(evt);
            }
        });

        Recipe_Button.setBackground(new java.awt.Color(88, 171, 255));
        Recipe_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Recipe_Button.setForeground(new java.awt.Color(255, 255, 255));
        Recipe_Button.setText("Recipe");
        Recipe_Button.setToolTipText("");
        Recipe_Button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.darkGray));
        Recipe_Button.setContentAreaFilled(false);
        Recipe_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Recipe_ButtonActionPerformed(evt);
            }
        });

        Orders_Button.setBackground(new java.awt.Color(88, 171, 255));
        Orders_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Orders_Button.setForeground(new java.awt.Color(255, 255, 255));
        Orders_Button.setText("Orders");
        Orders_Button.setToolTipText("");
        Orders_Button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.darkGray));
        Orders_Button.setContentAreaFilled(false);
        Orders_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Orders_ButtonActionPerformed(evt);
            }
        });

        Branches_Button.setBackground(new java.awt.Color(88, 171, 255));
        Branches_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Branches_Button.setForeground(new java.awt.Color(255, 255, 255));
        Branches_Button.setText("Branches");
        Branches_Button.setToolTipText("");
        Branches_Button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.darkGray));
        Branches_Button.setContentAreaFilled(false);
        Branches_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Branches_ButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Consolas", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Stocking ");

        jLabel24.setFont(new java.awt.Font("Consolas", 3, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("System");

        Logout.setBackground(new java.awt.Color(88, 171, 255));
        Logout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Logout.setForeground(new java.awt.Color(255, 255, 255));
        Logout.setText("Log out");
        Logout.setToolTipText("");
        Logout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.darkGray));
        Logout.setContentAreaFilled(false);
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CEO_Button_PanelLayout = new javax.swing.GroupLayout(CEO_Button_Panel);
        CEO_Button_Panel.setLayout(CEO_Button_PanelLayout);
        CEO_Button_PanelLayout.setHorizontalGroup(
            CEO_Button_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CEO_Button_PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CEO_Button_PanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(CEO_Button_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(CEO_Button_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Logout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Branches_Button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Orders_Button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Recipe_Button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Stock_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
            .addGroup(CEO_Button_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CEO_Button_PanelLayout.setVerticalGroup(
            CEO_Button_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CEO_Button_PanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(Stock_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Recipe_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(Orders_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Branches_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        getContentPane().add(CEO_Button_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 570));

        CEO_Tabbed_Panel.setToolTipText("");

        Stock_Tab.setBackground(new java.awt.Color(88, 171, 255));
        Stock_Tab.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

        kGradientPanel2.setkGradientFocus(-375);
        kGradientPanel2.setkStartColor(new java.awt.Color(88, 189, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Serif", 1, 35)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Stock");
        jLabel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51))));

        ProductinKitchen_Tab.setBackground(new java.awt.Color(255, 255, 255));

        View_ProductInStock_Name_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                View_ProductInStock_Name_TextFieldActionPerformed(evt);
            }
        });

        SearchProduct_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SearchProduct_Button.setText("Search");
        SearchProduct_Button.setToolTipText("");
        SearchProduct_Button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SearchProduct_Button.setContentAreaFilled(false);
        SearchProduct_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchProduct_ButtonActionPerformed(evt);
            }
        });

        ProductInStock_View_Table.setAutoCreateRowSorter(true);
        ProductInStock_View_Table.setBackground(new java.awt.Color(51, 51, 51));
        ProductInStock_View_Table.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ProductInStock_View_Table.setForeground(new java.awt.Color(255, 255, 255));
        ProductInStock_View_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Amount (Box)", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ProductInStock_View_Table.setGridColor(new java.awt.Color(255, 255, 255));
        ProductInStock_View_Table.setRowHeight(22);
        ProductInStock_View_Table.setVerifyInputWhenFocusTarget(false);
        ProductInStiock_View_ScrollPanel.setViewportView(ProductInStock_View_Table);
        if (ProductInStock_View_Table.getColumnModel().getColumnCount() > 0) {
            ProductInStock_View_Table.getColumnModel().getColumn(0).setResizable(false);
            ProductInStock_View_Table.getColumnModel().getColumn(0).setPreferredWidth(5);
            ProductInStock_View_Table.getColumnModel().getColumn(1).setResizable(false);
            ProductInStock_View_Table.getColumnModel().getColumn(2).setResizable(false);
            ProductInStock_View_Table.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel26.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel26.setText("Product name");

        UpdateProduct_Button.setBackground(new java.awt.Color(88, 171, 255));
        UpdateProduct_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        UpdateProduct_Button.setText("Update");
        UpdateProduct_Button.setToolTipText("");
        UpdateProduct_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        UpdateProduct_Button.setContentAreaFilled(false);
        UpdateProduct_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateProduct_ButtonActionPerformed(evt);
            }
        });

        InactiveProduct_Button.setBackground(new java.awt.Color(88, 171, 255));
        InactiveProduct_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        InactiveProduct_Button.setText("Inactive");
        InactiveProduct_Button.setToolTipText("");
        InactiveProduct_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        InactiveProduct_Button.setContentAreaFilled(false);
        InactiveProduct_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InactiveProduct_ButtonActionPerformed(evt);
            }
        });

        AddProduct_Button.setBackground(new java.awt.Color(51, 51, 51));
        AddProduct_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AddProduct_Button.setText("Add");
        AddProduct_Button.setToolTipText("");
        AddProduct_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        AddProduct_Button.setContentAreaFilled(false);
        AddProduct_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddProduct_ButtonActionPerformed(evt);
            }
        });

        ActiveProduct_Button.setBackground(new java.awt.Color(88, 171, 255));
        ActiveProduct_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ActiveProduct_Button.setText("Active");
        ActiveProduct_Button.setToolTipText("");
        ActiveProduct_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        ActiveProduct_Button.setContentAreaFilled(false);
        ActiveProduct_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActiveProduct_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ProductinKitchen_TabLayout = new javax.swing.GroupLayout(ProductinKitchen_Tab);
        ProductinKitchen_Tab.setLayout(ProductinKitchen_TabLayout);
        ProductinKitchen_TabLayout.setHorizontalGroup(
            ProductinKitchen_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductinKitchen_TabLayout.createSequentialGroup()
                .addGroup(ProductinKitchen_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProductinKitchen_TabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ProductInStiock_View_ScrollPanel))
                    .addGroup(ProductinKitchen_TabLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addComponent(View_ProductInStock_Name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SearchProduct_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 99, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(ProductinKitchen_TabLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(AddProduct_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(UpdateProduct_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ActiveProduct_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(InactiveProduct_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ProductinKitchen_TabLayout.setVerticalGroup(
            ProductinKitchen_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductinKitchen_TabLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(ProductinKitchen_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(View_ProductInStock_Name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchProduct_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ProductInStiock_View_ScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ProductinKitchen_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddProduct_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateProduct_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ActiveProduct_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InactiveProduct_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        Stock_Sub_Tab.addTab("Product", ProductinKitchen_Tab);

        Ingredient_Tab.setBackground(new java.awt.Color(255, 255, 255));
        Ingredient_Tab.setPreferredSize(new java.awt.Dimension(636, 493));

        jLabel7.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel7.setText("Ingredient name");

        View_Ingredient_Name_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                View_Ingredient_Name_TextFieldActionPerformed(evt);
            }
        });

        SearchIngredient_Button.setBackground(new java.awt.Color(51, 51, 51));
        SearchIngredient_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SearchIngredient_Button.setText("Search");
        SearchIngredient_Button.setToolTipText("");
        SearchIngredient_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        SearchIngredient_Button.setContentAreaFilled(false);
        SearchIngredient_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchIngredient_ButtonActionPerformed(evt);
            }
        });

        Ingredient_View_Table.setAutoCreateRowSorter(true);
        Ingredient_View_Table.setBackground(new java.awt.Color(51, 51, 51));
        Ingredient_View_Table.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Ingredient_View_Table.setForeground(new java.awt.Color(255, 255, 255));
        Ingredient_View_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Ingredient ID", "Ingredient Name", "Amount (Kilogram)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Ingredient_View_Table.setRowHeight(22);
        Ingredient_View_ScrollPanel.setViewportView(Ingredient_View_Table);

        AddIngredient_Button.setBackground(new java.awt.Color(88, 171, 255));
        AddIngredient_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AddIngredient_Button.setText("Add");
        AddIngredient_Button.setToolTipText("");
        AddIngredient_Button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        AddIngredient_Button.setContentAreaFilled(false);
        AddIngredient_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddIngredient_ButtonActionPerformed(evt);
            }
        });

        UpdateIngredient_Button.setBackground(new java.awt.Color(88, 171, 255));
        UpdateIngredient_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        UpdateIngredient_Button.setText("Update");
        UpdateIngredient_Button.setToolTipText("");
        UpdateIngredient_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        UpdateIngredient_Button.setContentAreaFilled(false);
        UpdateIngredient_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateIngredient_ButtonActionPerformed(evt);
            }
        });

        RemoveIngredient_Button.setBackground(new java.awt.Color(88, 171, 255));
        RemoveIngredient_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RemoveIngredient_Button.setText("Remove");
        RemoveIngredient_Button.setToolTipText("");
        RemoveIngredient_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        RemoveIngredient_Button.setContentAreaFilled(false);
        RemoveIngredient_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveIngredient_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Ingredient_TabLayout = new javax.swing.GroupLayout(Ingredient_Tab);
        Ingredient_Tab.setLayout(Ingredient_TabLayout);
        Ingredient_TabLayout.setHorizontalGroup(
            Ingredient_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Ingredient_TabLayout.createSequentialGroup()
                .addGroup(Ingredient_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Ingredient_TabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Ingredient_View_ScrollPanel))
                    .addGroup(Ingredient_TabLayout.createSequentialGroup()
                        .addGroup(Ingredient_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Ingredient_TabLayout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(View_Ingredient_Name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SearchIngredient_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Ingredient_TabLayout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(AddIngredient_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(UpdateIngredient_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(RemoveIngredient_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 81, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Ingredient_TabLayout.setVerticalGroup(
            Ingredient_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Ingredient_TabLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(Ingredient_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(View_Ingredient_Name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchIngredient_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Ingredient_View_ScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Ingredient_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddIngredient_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateIngredient_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RemoveIngredient_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        Stock_Sub_Tab.addTab("Ingredient", Ingredient_Tab);

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(263, Short.MAX_VALUE))
            .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Stock_Sub_Tab, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addContainerGap(469, Short.MAX_VALUE))
            .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel2Layout.createSequentialGroup()
                    .addGap(95, 95, 95)
                    .addComponent(Stock_Sub_Tab, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(39, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout Stock_TabLayout = new javax.swing.GroupLayout(Stock_Tab);
        Stock_Tab.setLayout(Stock_TabLayout);
        Stock_TabLayout.setHorizontalGroup(
            Stock_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Stock_TabLayout.setVerticalGroup(
            Stock_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Stock_TabLayout.createSequentialGroup()
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        CEO_Tabbed_Panel.addTab("View", Stock_Tab);

        Recipe_Tab.setBackground(new java.awt.Color(88, 171, 255));
        Recipe_Tab.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

        Search_Recipe_Tab.setBackground(new java.awt.Color(255, 255, 255));
        Search_Recipe_Tab.setForeground(new java.awt.Color(255, 255, 255));
        Search_Recipe_Tab.setToolTipText("");
        Search_Recipe_Tab.setPreferredSize(new java.awt.Dimension(636, 409));

        jLabel6.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel6.setText("Product name");

        View_Recipe_Product_Name_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                View_Recipe_Product_Name_TextFieldActionPerformed(evt);
            }
        });

        SearchRecipe_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SearchRecipe_Button.setText("Search");
        SearchRecipe_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        SearchRecipe_Button.setContentAreaFilled(false);
        SearchRecipe_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchRecipe_ButtonActionPerformed(evt);
            }
        });

        Recipe_View_Table.setAutoCreateRowSorter(true);
        Recipe_View_Table.setBackground(new java.awt.Color(51, 51, 51));
        Recipe_View_Table.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Recipe_View_Table.setForeground(new java.awt.Color(255, 255, 255));
        Recipe_View_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Recipe ID", "Product Name", "Ingredient Name", "Uesd Amount (Kilogram)"
            }
        ));
        Recipe_View_Table.setRowHeight(22);
        Recipe_View_ScrollPanel.setViewportView(Recipe_View_Table);

        RemoveUsedIngredient_Button.setBackground(new java.awt.Color(88, 171, 255));
        RemoveUsedIngredient_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RemoveUsedIngredient_Button.setText("Remove used ingredient");
        RemoveUsedIngredient_Button.setToolTipText("");
        RemoveUsedIngredient_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        RemoveUsedIngredient_Button.setContentAreaFilled(false);
        RemoveUsedIngredient_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveUsedIngredient_ButtonActionPerformed(evt);
            }
        });

        UpdateRecipe_Button.setBackground(new java.awt.Color(88, 171, 255));
        UpdateRecipe_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        UpdateRecipe_Button.setText("Update");
        UpdateRecipe_Button.setToolTipText("");
        UpdateRecipe_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        UpdateRecipe_Button.setContentAreaFilled(false);
        UpdateRecipe_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateRecipe_ButtonActionPerformed(evt);
            }
        });

        RemoveRecipe_Button.setBackground(new java.awt.Color(88, 171, 255));
        RemoveRecipe_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RemoveRecipe_Button.setText("Remove recipe");
        RemoveRecipe_Button.setToolTipText("");
        RemoveRecipe_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        RemoveRecipe_Button.setContentAreaFilled(false);
        RemoveRecipe_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveRecipe_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Search_Recipe_TabLayout = new javax.swing.GroupLayout(Search_Recipe_Tab);
        Search_Recipe_Tab.setLayout(Search_Recipe_TabLayout);
        Search_Recipe_TabLayout.setHorizontalGroup(
            Search_Recipe_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Search_Recipe_TabLayout.createSequentialGroup()
                .addGroup(Search_Recipe_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Search_Recipe_TabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Recipe_View_ScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE))
                    .addGroup(Search_Recipe_TabLayout.createSequentialGroup()
                        .addGroup(Search_Recipe_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Search_Recipe_TabLayout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(View_Recipe_Product_Name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(SearchRecipe_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Search_Recipe_TabLayout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(UpdateRecipe_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(RemoveUsedIngredient_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(RemoveRecipe_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Search_Recipe_TabLayout.setVerticalGroup(
            Search_Recipe_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Search_Recipe_TabLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(Search_Recipe_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(View_Recipe_Product_Name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchRecipe_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Recipe_View_ScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Search_Recipe_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateRecipe_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RemoveUsedIngredient_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RemoveRecipe_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91))
        );

        Add_Sub_Tab.addTab("Recipe", Search_Recipe_Tab);

        Add_Recipe_Tab.setBackground(new java.awt.Color(255, 255, 255));

        jLabel27.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel27.setText("Product name");

        jLabel28.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel28.setText("Ingredient name");

        jLabel29.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel29.setText("Used ingredient amount");

        Add_Recipe_Product_Name_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_Recipe_Product_Name_TextFieldActionPerformed(evt);
            }
        });

        Add_Recipe_Ingredient_Name_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_Recipe_Ingredient_Name_TextFieldActionPerformed(evt);
            }
        });

        Add_Recipe_Ingredient_Amount_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_Recipe_Ingredient_Amount_TextFieldActionPerformed(evt);
            }
        });

        AddRecipe_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AddRecipe_Button.setText("Add Recipe");
        AddRecipe_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        AddRecipe_Button.setContentAreaFilled(false);
        AddRecipe_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRecipe_ButtonActionPerformed(evt);
            }
        });

        product_table_recipe.setAutoCreateRowSorter(true);
        product_table_recipe.setBackground(new java.awt.Color(51, 51, 51));
        product_table_recipe.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        product_table_recipe.setForeground(new java.awt.Color(255, 255, 255));
        product_table_recipe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Amount (Box)", "Status"
            }
        ));
        product_table_recipe.setRowHeight(22);
        jScrollPane1.setViewportView(product_table_recipe);

        ingredient_table_recipe.setAutoCreateRowSorter(true);
        ingredient_table_recipe.setBackground(new java.awt.Color(51, 51, 51));
        ingredient_table_recipe.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ingredient_table_recipe.setForeground(new java.awt.Color(255, 255, 255));
        ingredient_table_recipe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Ingredient ID", "Ingredient Name", "Amount (Kilogram)"
            }
        ));
        ingredient_table_recipe.setRowHeight(22);
        jScrollPane2.setViewportView(ingredient_table_recipe);

        SearchRecipeAdd_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SearchRecipeAdd_Button.setText("Search");
        SearchRecipeAdd_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        SearchRecipeAdd_Button.setContentAreaFilled(false);
        SearchRecipeAdd_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchRecipeAdd_ButtonActionPerformed(evt);
            }
        });

        SearchUsedIngredient_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SearchUsedIngredient_Button.setText("Search");
        SearchUsedIngredient_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        SearchUsedIngredient_Button.setContentAreaFilled(false);
        SearchUsedIngredient_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchUsedIngredient_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Add_Recipe_TabLayout = new javax.swing.GroupLayout(Add_Recipe_Tab);
        Add_Recipe_Tab.setLayout(Add_Recipe_TabLayout);
        Add_Recipe_TabLayout.setHorizontalGroup(
            Add_Recipe_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Add_Recipe_TabLayout.createSequentialGroup()
                .addGroup(Add_Recipe_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Add_Recipe_TabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Add_Recipe_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(Add_Recipe_TabLayout.createSequentialGroup()
                        .addGroup(Add_Recipe_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Add_Recipe_TabLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(Add_Recipe_Ingredient_Name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SearchUsedIngredient_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Add_Recipe_TabLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel27)
                                .addGap(63, 63, 63)
                                .addComponent(Add_Recipe_Product_Name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SearchRecipeAdd_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Add_Recipe_TabLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel29)
                                .addGap(18, 18, 18)
                                .addComponent(Add_Recipe_Ingredient_Amount_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(AddRecipe_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 45, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Add_Recipe_TabLayout.setVerticalGroup(
            Add_Recipe_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Add_Recipe_TabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Add_Recipe_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add_Recipe_Product_Name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchRecipeAdd_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(Add_Recipe_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add_Recipe_Ingredient_Name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchUsedIngredient_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Add_Recipe_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddRecipe_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add_Recipe_Ingredient_Amount_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Add_Sub_Tab.addTab("Add Recipe", Add_Recipe_Tab);

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Serif", 1, 35)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Recipe");
        jLabel17.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));

        kGradientPanel3.setkGradientFocus(-375);
        kGradientPanel3.setkStartColor(new java.awt.Color(88, 189, 255));

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 655, Short.MAX_VALUE)
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Recipe_TabLayout = new javax.swing.GroupLayout(Recipe_Tab);
        Recipe_Tab.setLayout(Recipe_TabLayout);
        Recipe_TabLayout.setHorizontalGroup(
            Recipe_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Recipe_TabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Add_Sub_Tab)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Recipe_TabLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(258, 258, 258))
            .addGroup(Recipe_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Recipe_TabLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        Recipe_TabLayout.setVerticalGroup(
            Recipe_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Recipe_TabLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Add_Sub_Tab, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(Recipe_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Recipe_TabLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        CEO_Tabbed_Panel.addTab("Add", Recipe_Tab);

        Order_Tab.setBackground(new java.awt.Color(88, 171, 255));
        Order_Tab.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

        kGradientPanel6.setkGradientFocus(-375);
        kGradientPanel6.setkStartColor(new java.awt.Color(88, 189, 255));

        OrderProduct_Tab.setBackground(new java.awt.Color(255, 255, 255));
        OrderProduct_Tab.setPreferredSize(new java.awt.Dimension(636, 409));

        jLabel16.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel16.setText("Branch Name");

        jLabel19.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel19.setText("Product Name");

        View_Order_BranchName_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                View_Order_BranchName_TextFieldActionPerformed(evt);
            }
        });

        View_Order_ProductName_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                View_Order_ProductName_TextFieldActionPerformed(evt);
            }
        });

        SearchOrder_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SearchOrder_Button.setText("Search");
        SearchOrder_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        SearchOrder_Button.setContentAreaFilled(false);
        SearchOrder_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchOrder_ButtonActionPerformed(evt);
            }
        });

        ConfirmShipment_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ConfirmShipment_Button.setText("Confirm Shipment");
        ConfirmShipment_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        ConfirmShipment_Button.setContentAreaFilled(false);
        ConfirmShipment_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmShipment_ButtonActionPerformed(evt);
            }
        });

        View_OrderShipment_Table.setBackground(new java.awt.Color(51, 51, 51));
        View_OrderShipment_Table.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        View_OrderShipment_Table.setForeground(new java.awt.Color(255, 255, 255));
        View_OrderShipment_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Branch Name", "Product Name", "Amount (Box)", "Order Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        View_OrderShipment_Table.setRowHeight(22);
        View_Order_Scroll.setViewportView(View_OrderShipment_Table);

        javax.swing.GroupLayout OrderProduct_TabLayout = new javax.swing.GroupLayout(OrderProduct_Tab);
        OrderProduct_Tab.setLayout(OrderProduct_TabLayout);
        OrderProduct_TabLayout.setHorizontalGroup(
            OrderProduct_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderProduct_TabLayout.createSequentialGroup()
                .addGroup(OrderProduct_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OrderProduct_TabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(View_Order_Scroll))
                    .addGroup(OrderProduct_TabLayout.createSequentialGroup()
                        .addGroup(OrderProduct_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(OrderProduct_TabLayout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addGroup(OrderProduct_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel19))
                                .addGap(18, 18, 18)
                                .addGroup(OrderProduct_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(View_Order_BranchName_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(View_Order_ProductName_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(OrderProduct_TabLayout.createSequentialGroup()
                                .addGap(275, 275, 275)
                                .addComponent(SearchOrder_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 138, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(OrderProduct_TabLayout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(ConfirmShipment_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        OrderProduct_TabLayout.setVerticalGroup(
            OrderProduct_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderProduct_TabLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(OrderProduct_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(View_Order_BranchName_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(OrderProduct_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(View_Order_ProductName_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(SearchOrder_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(View_Order_Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ConfirmShipment_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(232, 232, 232))
        );

        Order_Sub_Tab.addTab("Order Shipment", OrderProduct_Tab);

        CompletedOrder_Tab.setBackground(new java.awt.Color(255, 255, 255));

        jLabel20.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel20.setText("Branch Name");

        jLabel25.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel25.setText("Product Name");

        View_Order_BranchName_TextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                View_Order_BranchName_TextField1ActionPerformed(evt);
            }
        });

        View_Order_ProductName_TextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                View_Order_ProductName_TextField1ActionPerformed(evt);
            }
        });

        SearchCompletedOrder_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SearchCompletedOrder_Button.setText("Search");
        SearchCompletedOrder_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        SearchCompletedOrder_Button.setContentAreaFilled(false);
        SearchCompletedOrder_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchCompletedOrder_ButtonActionPerformed(evt);
            }
        });

        View_OrderLog_Table1.setBackground(new java.awt.Color(51, 51, 51));
        View_OrderLog_Table1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        View_OrderLog_Table1.setForeground(new java.awt.Color(255, 255, 255));
        View_OrderLog_Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Branch Name", "Product Name", "Amount (Box)", "Order Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        View_OrderLog_Table1.setRowHeight(22);
        View_Order_Scroll1.setViewportView(View_OrderLog_Table1);

        javax.swing.GroupLayout CompletedOrder_TabLayout = new javax.swing.GroupLayout(CompletedOrder_Tab);
        CompletedOrder_Tab.setLayout(CompletedOrder_TabLayout);
        CompletedOrder_TabLayout.setHorizontalGroup(
            CompletedOrder_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CompletedOrder_TabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CompletedOrder_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(View_Order_Scroll1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(CompletedOrder_TabLayout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(CompletedOrder_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel25))
                        .addGap(18, 18, 18)
                        .addGroup(CompletedOrder_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(View_Order_BranchName_TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(View_Order_ProductName_TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 138, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(CompletedOrder_TabLayout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(SearchCompletedOrder_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CompletedOrder_TabLayout.setVerticalGroup(
            CompletedOrder_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CompletedOrder_TabLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(CompletedOrder_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(View_Order_BranchName_TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(CompletedOrder_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(View_Order_ProductName_TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(SearchCompletedOrder_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(View_Order_Scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        Order_Sub_Tab.addTab("Completed Order", CompletedOrder_Tab);

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Serif", 1, 35)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Orders");
        jLabel21.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));

        javax.swing.GroupLayout kGradientPanel6Layout = new javax.swing.GroupLayout(kGradientPanel6);
        kGradientPanel6.setLayout(kGradientPanel6Layout);
        kGradientPanel6Layout.setHorizontalGroup(
            kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 655, Short.MAX_VALUE)
            .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Order_Sub_Tab)
                        .addGroup(kGradientPanel6Layout.createSequentialGroup()
                            .addGap(246, 246, 246)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap()))
        );
        kGradientPanel6Layout.setVerticalGroup(
            kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
            .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel6Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jLabel21)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(Order_Sub_Tab, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(47, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout Order_TabLayout = new javax.swing.GroupLayout(Order_Tab);
        Order_Tab.setLayout(Order_TabLayout);
        Order_TabLayout.setHorizontalGroup(
            Order_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Order_TabLayout.setVerticalGroup(
            Order_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        CEO_Tabbed_Panel.addTab("Remove", Order_Tab);

        Branchs_Tab.setBackground(new java.awt.Color(88, 171, 255));
        Branchs_Tab.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

        kGradientPanel8.setkGradientFocus(-375);
        kGradientPanel8.setkStartColor(new java.awt.Color(88, 189, 255));

        Branch_Tab.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel8.setText("Branch name");

        View_Branch_Name_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                View_Branch_Name_TextFieldActionPerformed(evt);
            }
        });

        SearchBranch_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SearchBranch_Button.setText("Search");
        SearchBranch_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        SearchBranch_Button.setContentAreaFilled(false);
        SearchBranch_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBranch_ButtonActionPerformed(evt);
            }
        });

        Branch_View_Table.setAutoCreateRowSorter(true);
        Branch_View_Table.setBackground(new java.awt.Color(51, 51, 51));
        Branch_View_Table.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Branch_View_Table.setForeground(new java.awt.Color(255, 255, 255));
        Branch_View_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Branch Name", "Branch Address", "Tel."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Branch_View_Table.setRowHeight(22);
        Branch_View_ScrollPanel.setViewportView(Branch_View_Table);

        javax.swing.GroupLayout Branch_TabLayout = new javax.swing.GroupLayout(Branch_Tab);
        Branch_Tab.setLayout(Branch_TabLayout);
        Branch_TabLayout.setHorizontalGroup(
            Branch_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Branch_TabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Branch_View_ScrollPanel)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Branch_TabLayout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(Branch_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SearchBranch_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(View_Branch_Name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(148, 148, 148))
        );
        Branch_TabLayout.setVerticalGroup(
            Branch_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Branch_TabLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(Branch_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(View_Branch_Name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(SearchBranch_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Branch_View_ScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addContainerGap())
        );

        Branchs_Sub_Tab.addTab("Branch", Branch_Tab);

        Sales_Tab.setBackground(new java.awt.Color(255, 255, 255));
        Sales_Tab.setPreferredSize(new java.awt.Dimension(636, 409));

        jLabel23.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel23.setText("Branch name");

        jLabel22.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel22.setText("Product name");

        View_Sales_Branch_name_TextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                View_Sales_Branch_name_TextField1ActionPerformed(evt);
            }
        });

        View_Sales_Product_Name_TextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                View_Sales_Product_Name_TextField1ActionPerformed(evt);
            }
        });

        SearchSale_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SearchSale_Button.setText("Search");
        SearchSale_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        SearchSale_Button.setContentAreaFilled(false);
        SearchSale_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchSale_ButtonActionPerformed(evt);
            }
        });

        Sales_View_Table.setBackground(new java.awt.Color(51, 51, 51));
        Sales_View_Table.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Sales_View_Table.setForeground(new java.awt.Color(255, 255, 255));
        Sales_View_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Branch Name", "Product Name", "Amount (Piece)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Sales_View_Table.setRowHeight(22);
        Sales_View_Scroll.setViewportView(Sales_View_Table);

        javax.swing.GroupLayout Sales_TabLayout = new javax.swing.GroupLayout(Sales_Tab);
        Sales_Tab.setLayout(Sales_TabLayout);
        Sales_TabLayout.setHorizontalGroup(
            Sales_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Sales_TabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Sales_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Sales_TabLayout.createSequentialGroup()
                        .addGap(0, 147, Short.MAX_VALUE)
                        .addGroup(Sales_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Sales_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(View_Sales_Product_Name_TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(View_Sales_Branch_name_TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchSale_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(141, 141, 141))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Sales_TabLayout.createSequentialGroup()
                        .addComponent(Sales_View_Scroll)
                        .addContainerGap())))
        );
        Sales_TabLayout.setVerticalGroup(
            Sales_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Sales_TabLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(Sales_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(View_Sales_Branch_name_TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Sales_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(View_Sales_Product_Name_TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(SearchSale_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Sales_View_Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(221, 221, 221))
        );

        Branchs_Sub_Tab.addTab("Sales", Sales_Tab);

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Serif", 1, 35)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Branchs");
        jLabel30.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)))));

        javax.swing.GroupLayout kGradientPanel8Layout = new javax.swing.GroupLayout(kGradientPanel8);
        kGradientPanel8.setLayout(kGradientPanel8Layout);
        kGradientPanel8Layout.setHorizontalGroup(
            kGradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 654, Short.MAX_VALUE)
            .addGroup(kGradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel8Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(250, 250, 250))
                .addGroup(kGradientPanel8Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Branchs_Sub_Tab, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(13, Short.MAX_VALUE)))
        );
        kGradientPanel8Layout.setVerticalGroup(
            kGradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
            .addGroup(kGradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel8Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jLabel30)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(Branchs_Sub_Tab, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(22, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout Branchs_TabLayout = new javax.swing.GroupLayout(Branchs_Tab);
        Branchs_Tab.setLayout(Branchs_TabLayout);
        Branchs_TabLayout.setHorizontalGroup(
            Branchs_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Branchs_TabLayout.createSequentialGroup()
                .addComponent(kGradientPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        Branchs_TabLayout.setVerticalGroup(
            Branchs_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Branchs_TabLayout.createSequentialGroup()
                .addComponent(kGradientPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        CEO_Tabbed_Panel.addTab("Update", Branchs_Tab);

        getContentPane().add(CEO_Tabbed_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, -29, 670, 600));

        kGradientPanel1.setkStartColor(new java.awt.Color(102, 204, 255));

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 570));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SearchUsedIngredient_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchUsedIngredient_ButtonActionPerformed
        try
        {
            // Get ingredient name from text field
            String ing_name = Add_Recipe_Ingredient_Name_TextField.getText();
            List<Ingredient> ingredient = null;

            // Check the condition which method to be used
            if(ing_name != null && ing_name.trim().length() > 0)
            {
                ingredient = ingredientDAO.getIngredientsByName(ing_name);
            }
            else
            {
                ingredient = ingredientDAO.getAllIngredients();
            }
            
            // No result
            if(ingredient.size() == 0){
                JOptionPane.showMessageDialog(this, "There is no \"" + ing_name + "\" in ingredient list.");
                return;
            }
            
            // Create table model
            IngredientTableModel model = new IngredientTableModel(ingredient);
            ingredient_table_recipe.setModel(model);
            TableColumnModel Ingredient_table_columnModel = ingredient_table_recipe.getColumnModel();
            Ingredient_table_columnModel.getColumn(0).setPreferredWidth(20);
            Ingredient_table_columnModel.getColumn(1).setPreferredWidth(250);
            Ingredient_table_columnModel.getColumn(2).setPreferredWidth(50);
            
        }
        catch(Exception exc)
        {
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SearchUsedIngredient_ButtonActionPerformed

    private void SearchRecipeAdd_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchRecipeAdd_ButtonActionPerformed
        try
        {
            // Get product name from text field
            String pro_name = Add_Recipe_Product_Name_TextField.getText();
            List<Product> product = null;

            // Check which condition which method to be used
            if(pro_name != null && pro_name.trim().length() > 0)
            {
                product = productDAO.getProductsByName(pro_name);
            }
            else
            {
                product = productDAO.getAllProducts();
            }
            
            // No result
            if(product.size() == 0){
                JOptionPane.showMessageDialog(this, "There is no \"" + pro_name + "\" in product list.");
                return;
            }
            
            // Create table model
            CEOProductTableModel model = new CEOProductTableModel(product);
            product_table_recipe.setModel(model);
            TableColumnModel Product_recipe_columnModel = product_table_recipe.getColumnModel();
            Product_recipe_columnModel.getColumn(0).setPreferredWidth(20);
            Product_recipe_columnModel.getColumn(1).setPreferredWidth(250);
            Product_recipe_columnModel.getColumn(2).setPreferredWidth(50);
            
            
        }
        catch(Exception exc)
        {
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_SearchRecipeAdd_ButtonActionPerformed
    
    private void AddRecipe_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddRecipe_ButtonActionPerformed
        try{
            // Get the selected item
            int pro_row = product_table_recipe.getSelectedRow();
            int ing_row = ingredient_table_recipe.getSelectedRow();
            
            int amount;
            
            // Didn't select any item
            if(pro_row < 0 || ing_row < 0){
                JOptionPane.showMessageDialog(this, "Please select a product and an ingredient.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Didn't input the amount
            if(Add_Recipe_Ingredient_Amount_TextField.getText() == null || Add_Recipe_Ingredient_Amount_TextField.getText().trim().length() == 0){
                JOptionPane.showMessageDialog(this, "Please input ingredient amount.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Get the amount of the used ingredient
            if(isNumeric(Add_Recipe_Ingredient_Amount_TextField.getText())){
                amount = Integer.parseInt(Add_Recipe_Ingredient_Amount_TextField.getText());
            } else {
                JOptionPane.showMessageDialog(this, "Please input a number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // The amount is negative
            if(amount <= 0){
                JOptionPane.showMessageDialog(this, "Amount can't be equal or less than 0.\nPlease input again.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Add the recipe
            Product tempProduct = (Product) product_table_recipe.getValueAt(pro_row, CEOProductTableModel.OBJECT_COL);
            Ingredient tempIngredient = (Ingredient) ingredient_table_recipe.getValueAt(ing_row, IngredientTableModel.OBJECT_COL);
            int pro_id = tempProduct.getProId();
            int ing_id = tempIngredient.getIngId();
            
            // If the ingredient is used already, let the user know
            if(recipeDAO.isUsed(pro_id, ing_id)){   
                JOptionPane.showMessageDialog(this, "This ingredient has already been added.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            recipeDAO.insertRecipe(pro_id, ing_id, amount);
            
            refreshRecipeView();
            refreshIngredientView();
            
            JOptionPane.showMessageDialog(this, "Recipe has been added.", "Add Recipe", JOptionPane.INFORMATION_MESSAGE);

        } catch(Exception exc){
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_AddRecipe_ButtonActionPerformed

    private void Add_Recipe_Ingredient_Amount_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_Recipe_Ingredient_Amount_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Add_Recipe_Ingredient_Amount_TextFieldActionPerformed

    private void Add_Recipe_Ingredient_Name_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_Recipe_Ingredient_Name_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Add_Recipe_Ingredient_Name_TextFieldActionPerformed

    private void Add_Recipe_Product_Name_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_Recipe_Product_Name_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Add_Recipe_Product_Name_TextFieldActionPerformed

    private void ConfirmShipment_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmShipment_ButtonActionPerformed
        try{
            // Get the selected item
            int row = View_OrderShipment_Table.getSelectedRow();
            
            // Didn't select any item
            if(row < 0){
                JOptionPane.showMessageDialog(this, "Please select an order.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Get the info of order
            Orders tempOrder = (Orders) View_OrderShipment_Table.getValueAt(row, CEOOrderTableModel.OBJECT_COL);
            String pro_name = tempOrder.getProName();
            int pro_id = orderDAO.getProductId(tempOrder.getOrderId(), pro_name);
            int order_amount = tempOrder.getAmount() * -1;
            int product_amount = productDAO.getProductAmount(pro_id);
            
            // Not enough product to send
            if(product_amount + order_amount < 0){
                JOptionPane.showMessageDialog(this, "Insufficient amount to ship products.\nPlease check the amount of product again.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Check before confirm
            int response = JOptionPane.showConfirmDialog(this, "Are you sure to ship this ordered product?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            // Not confirm
            if(response != JOptionPane.YES_OPTION){
                return;
            }
            
            // Update
            productDAO.updateProduct(pro_id, order_amount);
            orderDAO.updateOrder(tempOrder);
            
            refreshProductView();
            refreshOrderView();

        }catch(Exception exc){
            exc.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_ConfirmShipment_ButtonActionPerformed

    private void SearchOrder_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchOrder_ButtonActionPerformed
        try
        {
            // Get branch name and product name from text field
            String branch_name = View_Order_BranchName_TextField.getText();
            String pro_name = View_Order_ProductName_TextField.getText();
            List<Orders> orders = null;

            // Check condition which method to be used
            if((pro_name == null || pro_name.trim().length() == 0) &&
                (branch_name == null || branch_name.trim().length() == 0)){
                orders = orderDAO.getAllOrders();
            }
            else if(branch_name == null || branch_name.trim().length() == 0){
                orders = orderDAO.getOrdersByProductName(pro_name);
            }
            else if(pro_name == null || pro_name.trim().length() == 0){
                orders = orderDAO.getOrdersByBranch(branch_name);
            }
            else{
                orders = orderDAO.getOrdersByProductNameBranch(branch_name, pro_name);
            }
            
            // No result
            if(orders.size() == 0){
                if(branch_name == null || branch_name.trim().length() == 0)
                    JOptionPane.showMessageDialog(this, "There is no \"" + pro_name + "\" in order list.");
                else JOptionPane.showMessageDialog(this, "There is no \"" + branch_name + "\" in order list.");
                return;
            }
            
            // Create table model
            CEOOrderTableModel model = new CEOOrderTableModel(orders);
            View_OrderShipment_Table.setModel(model);
            TableColumnModel OrderShipment_View_columnModel = View_OrderShipment_Table.getColumnModel();
            OrderShipment_View_columnModel.getColumn(0).setPreferredWidth(6);
            OrderShipment_View_columnModel.getColumn(1).setPreferredWidth(80);
            OrderShipment_View_columnModel.getColumn(2).setPreferredWidth(80);
            OrderShipment_View_columnModel.getColumn(3).setPreferredWidth(45);
            OrderShipment_View_columnModel.getColumn(4).setPreferredWidth(100);
            OrderShipment_View_columnModel.getColumn(5).setPreferredWidth(15);
        }
        catch(Exception exc)
        {
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_SearchOrder_ButtonActionPerformed

    private void View_Order_ProductName_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_View_Order_ProductName_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_View_Order_ProductName_TextFieldActionPerformed

    private void View_Order_BranchName_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_View_Order_BranchName_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_View_Order_BranchName_TextFieldActionPerformed

    private void SearchBranch_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBranch_ButtonActionPerformed
        try
        {
            // Get branch naem from text field
            String branch_name = View_Branch_Name_TextField.getText();
            List<Branch> branch = null;

            // Check condition which method to be used
            if(branch_name != null && branch_name.trim().length() > 0)
            {
                branch = branchDAO.getBranchesByName(branch_name);
            }
            else
            {
                branch = branchDAO.getAllBranches();
            }
            
            // No result
            if(branch.size() == 0){
                JOptionPane.showMessageDialog(this, "There is no \"" + branch_name + "\" in branch list.");
                return;
            }
            
            // Create table model
            BranchTableModel model = new BranchTableModel(branch);
            Branch_View_Table.setModel(model);
            TableColumnModel Branch_View_columnModel = Branch_View_Table.getColumnModel();
            Branch_View_columnModel.getColumn(0).setPreferredWidth(75);
            Branch_View_columnModel.getColumn(1).setPreferredWidth(305);
            Branch_View_columnModel.getColumn(2).setPreferredWidth(10);
        }
        catch(Exception exc)
        {
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SearchBranch_ButtonActionPerformed

    private void View_Branch_Name_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_View_Branch_Name_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_View_Branch_Name_TextFieldActionPerformed

    private void SearchRecipe_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchRecipe_ButtonActionPerformed
        try
        {
            // Get product name from text field
            String pro_name = View_Recipe_Product_Name_TextField.getText();
            List<Recipe> recipe = null;

            // Check condition which method to be used
            if(pro_name != null && pro_name.trim().length() > 0)
            {
                recipe = recipeDAO.getRecipesByProductName(pro_name);
            }
            else
            {
                recipe = recipeDAO.getAllRecipes();
            }
            
            // No result
            if(recipe.size() == 0){
                JOptionPane.showMessageDialog(this, "There is no \"" + pro_name + "\" in recipe list.");
                return;
            }
            
            // Create table model
            RecipeTableModel model = new RecipeTableModel(recipe);
            Recipe_View_Table.setModel(model);
            TableColumnModel Recipe_View_columnModel = Recipe_View_Table.getColumnModel();
            Recipe_View_columnModel.getColumn(0).setPreferredWidth(20);
            Recipe_View_columnModel.getColumn(1).setPreferredWidth(150);
            Recipe_View_columnModel.getColumn(2).setPreferredWidth(100);
            Recipe_View_columnModel.getColumn(3).setPreferredWidth(100);
        }
        catch(Exception exc)
        {
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SearchRecipe_ButtonActionPerformed

    private void View_Recipe_Product_Name_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_View_Recipe_Product_Name_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_View_Recipe_Product_Name_TextFieldActionPerformed

    private void SearchSale_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchSale_ButtonActionPerformed
        try{
            // get pro name from text field
            String branch = View_Sales_Branch_name_TextField1.getText();
            String pro_name = View_Sales_Product_Name_TextField1.getText();
            List<Sales> sales = null;

            // check condition which method to be used
            if((pro_name == null || pro_name.trim().length() == 0) &&
                (branch == null || branch.trim().length() == 0)){
                sales = saleDAO.getAllSales();
            }
            else if(pro_name == null || pro_name.trim().length() == 0){
                sales = saleDAO.getSalesByBranch(branch);
            }
            else if(branch == null || branch.trim().length() == 0){
                sales = saleDAO.getSalesByProductName(pro_name);
            }
            else{
                sales = saleDAO.getSalesByProductNameBranch(pro_name, branch);
            }
            
            // No result
            if(sales.size() == 0){
                if(branch == null || branch.trim().length() == 0)
                    JOptionPane.showMessageDialog(this, "There is no \"" + pro_name + "\" in sales list.");
                else JOptionPane.showMessageDialog(this, "There is no \"" + branch + "\" in sales list.");
                return;
            }
            
            // create tablemodel
            CEOSalesTableModel model = new CEOSalesTableModel(sales);
            Sales_View_Table.setModel(model);
            TableColumnModel Sales_View_columnModel = Sales_View_Table.getColumnModel();
            Sales_View_columnModel.getColumn(0).setPreferredWidth(100);
            Sales_View_columnModel.getColumn(1).setPreferredWidth(100);
            Sales_View_columnModel.getColumn(2).setPreferredWidth(10);

        } catch(Exception exc){
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_SearchSale_ButtonActionPerformed

    private void View_Sales_Product_Name_TextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_View_Sales_Product_Name_TextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_View_Sales_Product_Name_TextField1ActionPerformed

    private void View_Sales_Branch_name_TextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_View_Sales_Branch_name_TextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_View_Sales_Branch_name_TextField1ActionPerformed

    private void Branches_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Branches_ButtonActionPerformed
        CEO_Tabbed_Panel.setSelectedIndex(3);
    }//GEN-LAST:event_Branches_ButtonActionPerformed

    private void Orders_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Orders_ButtonActionPerformed
        CEO_Tabbed_Panel.setSelectedIndex(2);
    }//GEN-LAST:event_Orders_ButtonActionPerformed

    private void Recipe_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Recipe_ButtonActionPerformed
        // TODO add your handling code here:
        CEO_Tabbed_Panel.setSelectedIndex(1);
    }//GEN-LAST:event_Recipe_ButtonActionPerformed

    private void Stock_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Stock_ButtonActionPerformed
        // TODO add your handling code here:
        CEO_Tabbed_Panel.setSelectedIndex(0);
    }//GEN-LAST:event_Stock_ButtonActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        // Log out from the system
        Login frame = new Login();
        
        setVisible(false);
        frame.setVisible(true);
        
    }//GEN-LAST:event_LogoutActionPerformed

    private void RemoveIngredient_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveIngredient_ButtonActionPerformed
        try{
            int row = Ingredient_View_Table.getSelectedRow();
                
            // The CEO didn't select any ingredient
            if(row < 0){
                JOptionPane.showMessageDialog(this, "Please select a product to remove.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Prepare to delete
            Ingredient tempIngredient = (Ingredient) Ingredient_View_Table.getValueAt(row, IngredientTableModel.OBJECT_COL);
            int ing_id = tempIngredient.getIngId();
            
            // Check before delete
            int response = JOptionPane.showConfirmDialog(this, "Remove this ingredient?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            // If the CEO didn't want to delete, stop this process
            if(response != JOptionPane.YES_OPTION){
                return;
            }
            
            // Delete this ingredient 
            ingredientDAO.deleteIngredient(ing_id);

            refreshIngredientView();

        } catch(Exception exc){
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_RemoveIngredient_ButtonActionPerformed

    private void UpdateIngredient_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateIngredient_ButtonActionPerformed
        // Get the selected item
        int row = Ingredient_View_Table.getSelectedRow();
        
        // Didn't select any item
        if(row < 0){
            JOptionPane.showMessageDialog(this, "Please select an ingredient to update.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Prepare before update
        Ingredient tempIngredient = (Ingredient) Ingredient_View_Table.getValueAt(row, IngredientTableModel.OBJECT_COL);
        
        // Create a dialog
        AddUpdate_Dialog dialog = new AddUpdate_Dialog(this, tempIngredient);
        
        // show dialog
        dialog.setVisible(true);

    }//GEN-LAST:event_UpdateIngredient_ButtonActionPerformed

    private void AddIngredient_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddIngredient_ButtonActionPerformed
        // create dialog
        AddUpdate_Dialog dialog = new AddUpdate_Dialog(this, false);
        dialog.setTitle("Add New Ingredient");
        
        // show dialog
        dialog.setVisible(true);

    }//GEN-LAST:event_AddIngredient_ButtonActionPerformed

    private void SearchIngredient_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchIngredient_ButtonActionPerformed
        try
        {
            // Get ingredient name from text field
            String ing_name = View_Ingredient_Name_TextField.getText();
            List<Ingredient> ingredient = null;

            // Check condition which method to be used
            if(ing_name != null && ing_name.trim().length() > 0)
            {
                ingredient = ingredientDAO.getIngredientsByName(ing_name);
            }
            else
            {
                ingredient = ingredientDAO.getAllIngredients();
            }
            
            // No result
            if(ingredient.size() == 0){
                JOptionPane.showMessageDialog(this, "There is no \"" + ing_name + "\" in ingredient list.");
                return;
            }
            
            // Create table model
            IngredientTableModel model = new IngredientTableModel(ingredient);
            Ingredient_View_Table.setModel(model);
            TableColumnModel Ingredient_View_columnModel = Ingredient_View_Table.getColumnModel();
            Ingredient_View_columnModel.getColumn(0).setPreferredWidth(20);
            Ingredient_View_columnModel.getColumn(1).setPreferredWidth(250);
            Ingredient_View_columnModel.getColumn(2).setPreferredWidth(20);
        }
        catch(Exception exc)
        {
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SearchIngredient_ButtonActionPerformed

    private void View_Ingredient_Name_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_View_Ingredient_Name_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_View_Ingredient_Name_TextFieldActionPerformed

    private void AddProduct_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProduct_ButtonActionPerformed
        // create dialog
        AddUpdate_Dialog dialog = new AddUpdate_Dialog(this, true);
        dialog.setTitle("Add New Product");
        
        // show dialog
        dialog.setVisible(true);
        
    }//GEN-LAST:event_AddProduct_ButtonActionPerformed

    private void InactiveProduct_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InactiveProduct_ButtonActionPerformed
        try{
            // Get the selected item
            int row = ProductInStock_View_Table.getSelectedRow();

            // Didn't select any item
            if(row < 0){
                JOptionPane.showMessageDialog(this, "Please select a product to Inactive.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Prepare to inactive a product
            Product tempProduct = (Product) ProductInStock_View_Table.getValueAt(row, CEOProductTableModel.OBJECT_COL);
            int pro_id = tempProduct.getProId();
            
            // Check before inactive
            int response = JOptionPane.showConfirmDialog(this, "Inactive this product?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            // Not inactive
            if(response != JOptionPane.YES_OPTION){
                return;
            }
            
            // Inactive
            productDAO.InActiveProduct(pro_id);

            refreshProductView();

        } catch(Exception exc){
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_InactiveProduct_ButtonActionPerformed

    private void UpdateProduct_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateProduct_ButtonActionPerformed
        // Get the selected item
        int row = ProductInStock_View_Table.getSelectedRow();
        
        // Didn't select any item
        if(row < 0){
            JOptionPane.showMessageDialog(this, "Please select a product to update.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Prepare for update
        Product tempProduct = (Product) ProductInStock_View_Table.getValueAt(row, CEOProductTableModel.OBJECT_COL);
        
        // Create a dialog
        AddUpdate_Dialog dialog = new AddUpdate_Dialog(this, tempProduct);
        
        // show dialog
        dialog.setVisible(true);

    }//GEN-LAST:event_UpdateProduct_ButtonActionPerformed

    private void SearchProduct_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchProduct_ButtonActionPerformed
        try
        {
            // Get product name from text field
            String pro_name = View_ProductInStock_Name_TextField.getText();
            List<Product> product = null;

            // Check condition which method to be used
            if(pro_name != null && pro_name.trim().length() > 0)
            {
                product = productDAO.getProductsByName(pro_name);
            }
            else
            {
                product = productDAO.getAllProducts();
            }
            
            // No result
            if(product.size() == 0){
                JOptionPane.showMessageDialog(this, "There is no \"" + pro_name + "\" in product list.");
                return;
            }
            
            // Create table model
            CEOProductTableModel model = new CEOProductTableModel(product);
            ProductInStock_View_Table.setModel(model);
        }
        catch(Exception exc)
        {
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SearchProduct_ButtonActionPerformed

    private void View_ProductInStock_Name_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_View_ProductInStock_Name_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_View_ProductInStock_Name_TextFieldActionPerformed

    private void RemoveUsedIngredient_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveUsedIngredient_ButtonActionPerformed
        try{
            // Get the selected item
            int row = Recipe_View_Table.getSelectedRow();

            // Didn't select any item
            if(row < 0){
                JOptionPane.showMessageDialog(this, "Please select a recipe to remove.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Prepare to delete
            Recipe tempRecipe = (Recipe) Recipe_View_Table.getValueAt(row, RecipeTableModel.OBJECT_COL);
            int rep_id = tempRecipe.getRepId();
            String ing_name = tempRecipe.getIngName();
            int ing_id = recipeDAO.getIngredientId(rep_id, ing_name);
            
            // Check before delete
            int response = JOptionPane.showConfirmDialog(this, "Remove this used ingredient?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            // Not delete
            if(response != JOptionPane.YES_OPTION){
                return;
            }
            
            // Delete
            recipeDAO.deleteUsedIngredient(rep_id, ing_id);

            refreshRecipeView();

        } catch(Exception exc){
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_RemoveUsedIngredient_ButtonActionPerformed

    private void View_Order_BranchName_TextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_View_Order_BranchName_TextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_View_Order_BranchName_TextField1ActionPerformed

    private void View_Order_ProductName_TextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_View_Order_ProductName_TextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_View_Order_ProductName_TextField1ActionPerformed

    private void SearchCompletedOrder_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchCompletedOrder_ButtonActionPerformed
        try
        {
            // Get branch name and product name from text field
            String branch_name = View_Order_BranchName_TextField1.getText();
            String pro_name = View_Order_ProductName_TextField1.getText();
            List<Orders> orders = null;

            // Check condition which method to be used
            if((pro_name == null || pro_name.trim().length() == 0) &&
                (branch_name == null || branch_name.trim().length() == 0)){
                orders = orderDAO.getAllCompletedOrders();
            }
            else if(branch_name == null || branch_name.trim().length() == 0){
                orders = orderDAO.getCompletedOrdersByProductName(pro_name);
            }
            else if(pro_name == null || pro_name.trim().length() == 0){
                orders = orderDAO.getCompletedOrdersByBranch(branch_name);
            }
            else{
                orders = orderDAO.getCompletedOrdersByProductNameBranch(branch_name, pro_name);
            }
            
            // No result
            if(orders.size() == 0){
                if(branch_name == null || branch_name.trim().length() == 0)
                    JOptionPane.showMessageDialog(this, "There is no \"" + pro_name + "\" in completed order list.");
                else JOptionPane.showMessageDialog(this, "There is no \"" + branch_name + "\" in completed order list.");
                return;
            }
            
            // Create table model
            CEOOrderTableModel model = new CEOOrderTableModel(orders);
            View_OrderLog_Table1.setModel(model);
            TableColumnModel OrderLog_View_columnModel = View_OrderLog_Table1.getColumnModel();
            OrderLog_View_columnModel.getColumn(0).setPreferredWidth(6);
            OrderLog_View_columnModel.getColumn(1).setPreferredWidth(80);
            OrderLog_View_columnModel.getColumn(2).setPreferredWidth(80);
            OrderLog_View_columnModel.getColumn(3).setPreferredWidth(45);
            OrderLog_View_columnModel.getColumn(4).setPreferredWidth(100);
            OrderLog_View_columnModel.getColumn(5).setPreferredWidth(15);
        }
        catch(Exception exc)
        {
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_SearchCompletedOrder_ButtonActionPerformed

    private void UpdateRecipe_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateRecipe_ButtonActionPerformed
        // Get the selected item
        int row = Recipe_View_Table.getSelectedRow();
        
        // Didn't select any row
        if(row < 0){
            JOptionPane.showMessageDialog(this, "Please select a recipe to update.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Prepare to update
        Recipe tempRecipe = (Recipe) Recipe_View_Table.getValueAt(row, RecipeTableModel.OBJECT_COL);
        
        // Create a dialog
        UpdateRecipe_Dialog dialog = new UpdateRecipe_Dialog(this, tempRecipe);
        dialog.setVisible(true);
        
    }//GEN-LAST:event_UpdateRecipe_ButtonActionPerformed

    private void RemoveRecipe_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveRecipe_ButtonActionPerformed
        try{
            // Get the selected item
            int row = Recipe_View_Table.getSelectedRow();

            // Didn't select any item
            if(row < 0){
                JOptionPane.showMessageDialog(this, "Please select a recipe to remove.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Prepare to delete
            Recipe tempRecipe = (Recipe) Recipe_View_Table.getValueAt(row, RecipeTableModel.OBJECT_COL);
            int rep_id = tempRecipe.getRepId();
            
            // Check before delete
            int response = JOptionPane.showConfirmDialog(this, "Remove this recipe?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            // Not delete
            if(response != JOptionPane.YES_OPTION){
                return;
            }
            
            // Delete
            recipeDAO.deleteRecipe(rep_id);

            refreshRecipeView();

        } catch(Exception exc){
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_RemoveRecipe_ButtonActionPerformed

    private void ActiveProduct_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActiveProduct_ButtonActionPerformed
        try{
            // Get the selected item
            int row = ProductInStock_View_Table.getSelectedRow();

            // Didn't select any item
            if(row < 0){
                JOptionPane.showMessageDialog(this, "Please select a product to active.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Prepare to active a product
            Product tempProduct = (Product) ProductInStock_View_Table.getValueAt(row, CEOProductTableModel.OBJECT_COL);
            int pro_id = tempProduct.getProId();
            
            // Check before active
            int response = JOptionPane.showConfirmDialog(this, "Active this product?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            // Not active
            if(response != JOptionPane.YES_OPTION){
                return;
            }
            
            // Active
            productDAO.ActiveProduct(pro_id);

            refreshProductView();

        } catch(Exception exc){
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ActiveProduct_ButtonActionPerformed
    
    // Check if the text can be converted to numbers
    public boolean isNumeric(String str){
        try {
            int num = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CEO1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CEO1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CEO1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CEO1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CEO1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActiveProduct_Button;
    private javax.swing.JButton AddIngredient_Button;
    private javax.swing.JButton AddProduct_Button;
    private javax.swing.JButton AddRecipe_Button;
    private javax.swing.JTextField Add_Recipe_Ingredient_Amount_TextField;
    private javax.swing.JTextField Add_Recipe_Ingredient_Name_TextField;
    private javax.swing.JTextField Add_Recipe_Product_Name_TextField;
    private javax.swing.JPanel Add_Recipe_Tab;
    private javax.swing.JTabbedPane Add_Sub_Tab;
    private javax.swing.JPanel Branch_Tab;
    private javax.swing.JScrollPane Branch_View_ScrollPanel;
    private javax.swing.JTable Branch_View_Table;
    private javax.swing.JButton Branches_Button;
    private javax.swing.JTabbedPane Branchs_Sub_Tab;
    private javax.swing.JPanel Branchs_Tab;
    private javax.swing.JPanel CEO_Button_Panel;
    private javax.swing.JTabbedPane CEO_Tabbed_Panel;
    private javax.swing.JPanel CompletedOrder_Tab;
    private javax.swing.JButton ConfirmShipment_Button;
    private javax.swing.JButton InactiveProduct_Button;
    private javax.swing.JPanel Ingredient_Tab;
    private javax.swing.JScrollPane Ingredient_View_ScrollPanel;
    private javax.swing.JTable Ingredient_View_Table;
    private javax.swing.JButton Logout;
    private javax.swing.JPanel OrderProduct_Tab;
    private javax.swing.JTabbedPane Order_Sub_Tab;
    private javax.swing.JPanel Order_Tab;
    private javax.swing.JButton Orders_Button;
    private javax.swing.JScrollPane ProductInStiock_View_ScrollPanel;
    private javax.swing.JTable ProductInStock_View_Table;
    private javax.swing.JPanel ProductinKitchen_Tab;
    private javax.swing.JButton Recipe_Button;
    private javax.swing.JPanel Recipe_Tab;
    private javax.swing.JScrollPane Recipe_View_ScrollPanel;
    private javax.swing.JTable Recipe_View_Table;
    private javax.swing.JButton RemoveIngredient_Button;
    private javax.swing.JButton RemoveRecipe_Button;
    private javax.swing.JButton RemoveUsedIngredient_Button;
    private javax.swing.JPanel Sales_Tab;
    private javax.swing.JScrollPane Sales_View_Scroll;
    private javax.swing.JTable Sales_View_Table;
    private javax.swing.JButton SearchBranch_Button;
    private javax.swing.JButton SearchCompletedOrder_Button;
    private javax.swing.JButton SearchIngredient_Button;
    private javax.swing.JButton SearchOrder_Button;
    private javax.swing.JButton SearchProduct_Button;
    private javax.swing.JButton SearchRecipeAdd_Button;
    private javax.swing.JButton SearchRecipe_Button;
    private javax.swing.JButton SearchSale_Button;
    private javax.swing.JButton SearchUsedIngredient_Button;
    private javax.swing.JPanel Search_Recipe_Tab;
    private javax.swing.JButton Stock_Button;
    private javax.swing.JTabbedPane Stock_Sub_Tab;
    private javax.swing.JPanel Stock_Tab;
    private javax.swing.JButton UpdateIngredient_Button;
    private javax.swing.JButton UpdateProduct_Button;
    private javax.swing.JButton UpdateRecipe_Button;
    private javax.swing.JTextField View_Branch_Name_TextField;
    private javax.swing.JTextField View_Ingredient_Name_TextField;
    private javax.swing.JTable View_OrderLog_Table1;
    private javax.swing.JTable View_OrderShipment_Table;
    private javax.swing.JTextField View_Order_BranchName_TextField;
    private javax.swing.JTextField View_Order_BranchName_TextField1;
    private javax.swing.JTextField View_Order_ProductName_TextField;
    private javax.swing.JTextField View_Order_ProductName_TextField1;
    private javax.swing.JScrollPane View_Order_Scroll;
    private javax.swing.JScrollPane View_Order_Scroll1;
    private javax.swing.JTextField View_ProductInStock_Name_TextField;
    private javax.swing.JTextField View_Recipe_Product_Name_TextField;
    private javax.swing.JTextField View_Sales_Branch_name_TextField1;
    private javax.swing.JTextField View_Sales_Product_Name_TextField1;
    private javax.swing.JTable ingredient_table_recipe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel6;
    private keeptoo.KGradientPanel kGradientPanel8;
    private javax.swing.JTable product_table_recipe;
    // End of variables declaration//GEN-END:variables

    // Refresh the viwe of order's table
    private void refreshOrderView() {
        try{
            List<Orders> Orders = orderDAO.getAllOrders();
            
            // create new table model
            CEOOrderTableModel model = new CEOOrderTableModel(Orders);
            
            View_OrderShipment_Table.setModel(model);
            TableColumnModel OrderShipment_View_columnModel = View_OrderShipment_Table.getColumnModel();
            OrderShipment_View_columnModel.getColumn(0).setPreferredWidth(6);
            OrderShipment_View_columnModel.getColumn(1).setPreferredWidth(80);
            OrderShipment_View_columnModel.getColumn(2).setPreferredWidth(80);
            OrderShipment_View_columnModel.getColumn(3).setPreferredWidth(45);
            OrderShipment_View_columnModel.getColumn(4).setPreferredWidth(100);
            OrderShipment_View_columnModel.getColumn(5).setPreferredWidth(15);
            
        } catch(Exception exc){
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Refresh the view of product's table
    public void refreshProductView(){
        try{
            List<Product> Product = productDAO.getAllProducts();
            TableColumnModel Product_View_columnModel;
            
            // create new table model
            CEOProductTableModel model = new CEOProductTableModel(Product);
            
            product_table_recipe.setModel(model);
            Product_View_columnModel = product_table_recipe.getColumnModel();
            Product_View_columnModel.getColumn(0).setPreferredWidth(20);
            Product_View_columnModel.getColumn(1).setPreferredWidth(250);
            Product_View_columnModel.getColumn(2).setPreferredWidth(50);
            
            ProductInStock_View_Table.setModel(model);
            Product_View_columnModel = ProductInStock_View_Table.getColumnModel();
            Product_View_columnModel.getColumn(0).setPreferredWidth(20);
            Product_View_columnModel.getColumn(1).setPreferredWidth(250);
            Product_View_columnModel.getColumn(2).setPreferredWidth(20);
            
        } catch(Exception exc){
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Refresh the view of ingredient's table
    public void refreshIngredientView(){
        try{
            List<Ingredient> ingredient = ingredientDAO.getAllIngredients();
            TableColumnModel Ingredient_View_columnModel;
            
            // create new table model
            IngredientTableModel model = new IngredientTableModel(ingredient);
            
           ingredient_table_recipe.setModel(model);
           Ingredient_View_columnModel = ingredient_table_recipe.getColumnModel();
           Ingredient_View_columnModel.getColumn(0).setPreferredWidth(20);
           Ingredient_View_columnModel.getColumn(1).setPreferredWidth(250);
           Ingredient_View_columnModel.getColumn(2).setPreferredWidth(20);
           
           Ingredient_View_Table.setModel(model);
           Ingredient_View_columnModel = Ingredient_View_Table.getColumnModel();
           Ingredient_View_columnModel.getColumn(0).setPreferredWidth(20);
           Ingredient_View_columnModel.getColumn(1).setPreferredWidth(250);
           Ingredient_View_columnModel.getColumn(2).setPreferredWidth(20);
            
        } catch(Exception exc){
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Refresh the view of recipe's table
    public void refreshRecipeView(){
        try{
            List<Recipe> recipe = recipeDAO.getAllRecipes();
            
            // create new table model
            RecipeTableModel model = new RecipeTableModel(recipe);
            
           Recipe_View_Table.setModel(model);
           TableColumnModel Recipe_View_columnModel = Recipe_View_Table.getColumnModel();
           Recipe_View_columnModel.getColumn(0).setPreferredWidth(20);
           Recipe_View_columnModel.getColumn(1).setPreferredWidth(150);
           Recipe_View_columnModel.getColumn(2).setPreferredWidth(100);
           Recipe_View_columnModel.getColumn(3).setPreferredWidth(100);
            
        } catch(Exception exc){
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
