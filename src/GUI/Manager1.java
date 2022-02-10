package GUI;

import Core.*;
import DAO.*;
import TableModel.EmployeeManagerOrderTableModel;
import TableModel.EmployeeTableModel;
import TableModel.ImportTableModel;
import TableModel.ManagerOrderProductTableModel;
import TableModel.ManagerSalesTableModel;
import TableModel.CEOProductTableModel;
import TableModel.StockTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
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
public class Manager1 extends javax.swing.JFrame {
    private String branch_name;
    private StockDAO stockDAO;
    private SaleDAO saleDAO;
    private ImportDAO importDAO;
    private OrderDAO orderDAO;
    private EmployeeDAO employeeDAO;
    private ProductDAO productDAO;
    private String[] days = {"--", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
                                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", 
                                "21","22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    private int check;
    
    /**
     * Creates new form Manager1
     */
    public Manager1(){
        initComponents();
    }
    
    
    public Manager1(String EmployeeBranchName) {
        this();
        try {
            this.branch_name = EmployeeBranchName;
            stockDAO = new StockDAO();
            saleDAO = new SaleDAO();
            importDAO = new ImportDAO();
            orderDAO = new OrderDAO();
            employeeDAO = new EmployeeDAO();
            productDAO = new ProductDAO();
            
            // Set the width of each column and populate the table
            List<Stock> stock_list = stockDAO.getAllStocks(branch_name);
            StockTableModel stock_model = new StockTableModel(stock_list);
            
            stock_table_remove.setModel(stock_model);
            TableColumnModel stock_remove_columnModel = stock_table_remove.getColumnModel();
            stock_remove_columnModel.getColumn(0).setPreferredWidth(20);
            stock_remove_columnModel.getColumn(1).setPreferredWidth(250);
            stock_remove_columnModel.getColumn(2).setPreferredWidth(20);
            
            stock_table_Order.setModel(stock_model);
            TableColumnModel stock_Order_columnModel = stock_table_Order.getColumnModel();
            stock_Order_columnModel.getColumn(0).setPreferredWidth(10);
            stock_Order_columnModel.getColumn(1).setPreferredWidth(55);
            stock_Order_columnModel.getColumn(2).setPreferredWidth(20);
            
            List<Import> import_list = importDAO.getAllImports(branch_name);
            ImportTableModel import_model = new ImportTableModel(import_list);
                    
            Import_View_Table.setModel(import_model);
            TableColumnModel Import_View_columnModel = Import_View_Table.getColumnModel();
            Import_View_columnModel.getColumn(0).setPreferredWidth(10);
            Import_View_columnModel.getColumn(2).setPreferredWidth(10);
            
            List<Import> incorrect_import_list = importDAO.getAllIncorrectImports(branch_name);
            ImportTableModel incorrect_import_model = new ImportTableModel(incorrect_import_list);
            
            Incorrect_Import_Update_Table.setModel(incorrect_import_model);
            TableColumnModel Incorrect_Import_Update_columnModel = Incorrect_Import_Update_Table.getColumnModel();
            Incorrect_Import_Update_columnModel.getColumn(0).setPreferredWidth(15);
            
            
            List<Sales> sales_list = saleDAO.getSalesByBranchName(branch_name);
            ManagerSalesTableModel sales_model = new ManagerSalesTableModel(sales_list);
            
            Sales_View_Table.setModel(sales_model);
            TableColumnModel Sales_View_columnModel = Sales_View_Table.getColumnModel();
            Sales_View_columnModel.getColumn(0).setPreferredWidth(10);
            Sales_View_columnModel.getColumn(2).setPreferredWidth(10);
            
            
            List<Product> product_list = productDAO.getAllActiveProducts();
            ManagerOrderProductTableModel product_model = new ManagerOrderProductTableModel(product_list);
            
            Product_Order_Table.setModel(product_model);
            TableColumnModel Product_Order_columnModel = Product_Order_Table.getColumnModel();
            Product_Order_columnModel.getColumn(0).setPreferredWidth(10);
            Product_Order_columnModel.getColumn(1).setPreferredWidth(55);
            
            
            List<Employee> employee_list = employeeDAO.getAllEmployees(branch_name);
            EmployeeTableModel employee_model = new EmployeeTableModel(employee_list);
            
            Employee_View_Table.setModel(employee_model);
            TableColumnModel Employee_View_columnModel = Employee_View_Table.getColumnModel();
            Employee_View_columnModel.getColumn(0).setPreferredWidth(10);
            Employee_View_columnModel.getColumn(1).setPreferredWidth(150);
            Employee_View_columnModel.getColumn(2).setPreferredWidth(15);
            Employee_View_columnModel.getColumn(3).setPreferredWidth(10);
            
            
            List<Orders> orders_list = orderDAO.getAllOrdersOfBranch(branch_name, true);
            EmployeeManagerOrderTableModel orders_model = new EmployeeManagerOrderTableModel(orders_list);
            
            Incorrect_Order_Update_Table.setModel(orders_model);
            TableColumnModel Incorrect_Order_Update_columnModel = Incorrect_Order_Update_Table.getColumnModel();
            Incorrect_Order_Update_columnModel.getColumn(0).setPreferredWidth(6);
            Incorrect_Order_Update_columnModel.getColumn(1).setPreferredWidth(80);
            Incorrect_Order_Update_columnModel.getColumn(2).setPreferredWidth(80);
            Incorrect_Order_Update_columnModel.getColumn(3).setPreferredWidth(45);
            Incorrect_Order_Update_columnModel.getColumn(4).setPreferredWidth(100);
            Incorrect_Order_Update_columnModel.getColumn(5).setPreferredWidth(15);
            
            
        } catch (Exception exc) {
            exc.printStackTrace();
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

        Button_Panel = new javax.swing.JPanel();
        Product_Button = new javax.swing.JButton();
        BranchLogs_Button = new javax.swing.JButton();
        Order_Button = new javax.swing.JButton();
        EmployeesList_Button = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Logout = new javax.swing.JButton();
        Tabbed_Panel = new javax.swing.JTabbedPane();
        Product_Tab = new javax.swing.JPanel();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jLabel11 = new javax.swing.JLabel();
        Remove_Product_Name_TextField = new javax.swing.JTextField();
        RemoveProduct_Button = new javax.swing.JButton();
        Product_Remove_ScrollPanel = new javax.swing.JScrollPane();
        Product_Remove_Status = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        stock_table_remove = new javax.swing.JTable();
        SearchStock_Button = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        Branche_Log_Tab = new javax.swing.JPanel();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        View_Sub_Tab = new javax.swing.JTabbedPane();
        Sale_Tab = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        View_Sales_Name_TextField = new javax.swing.JTextField();
        SearchSale_Button = new javax.swing.JButton();
        Sales_View_ScrollPanel = new javax.swing.JScrollPane();
        Sales_View_Table = new javax.swing.JTable();
        sales_year = new javax.swing.JComboBox<>();
        sales_month = new javax.swing.JComboBox<>();
        sales_day = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Import__Tab = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        View_import_Name_TextField = new javax.swing.JTextField();
        SearchImport_Button = new javax.swing.JButton();
        Import_View_SP = new javax.swing.JScrollPane();
        Import_View_Table = new javax.swing.JTable();
        import_year = new javax.swing.JComboBox<>();
        import_month = new javax.swing.JComboBox<>();
        import_day = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Order_Tab = new javax.swing.JPanel();
        kGradientPanel5 = new keeptoo.KGradientPanel();
        jLabel22 = new javax.swing.JLabel();
        Order_Sub_Tab = new javax.swing.JTabbedPane();
        Order_Product = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        Order_Product_Name_TextField = new javax.swing.JTextField();
        SearchOrder_Button = new javax.swing.JButton();
        Product_Order_ScrollPanel = new javax.swing.JScrollPane();
        Product_Order_Table = new javax.swing.JTable();
        Stock_Table_Order = new javax.swing.JScrollPane();
        stock_table_Order = new javax.swing.JTable();
        Order_Product_Amount_TextField = new javax.swing.JTextField();
        OrderProduct_Button = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        Incorrect_Order_Tab = new javax.swing.JPanel();
        SearchIncorrectOrder_Button = new javax.swing.JButton();
        Product_Update_ScrollPanel = new javax.swing.JScrollPane();
        Incorrect_Order_Update_Table = new javax.swing.JTable();
        Update_Product_Name_TextField = new javax.swing.JTextField();
        ConfirmOrder_Button = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        Product_Update_ScrollPanel1 = new javax.swing.JScrollPane();
        Incorrect_Import_Update_Table = new javax.swing.JTable();
        Employee_Tab = new javax.swing.JPanel();
        kGradientPanel6 = new keeptoo.KGradientPanel();
        jLabel8 = new javax.swing.JLabel();
        View_Employee_Name_TextField = new javax.swing.JTextField();
        SearchEmployee_Button = new javax.swing.JButton();
        Employee_View_ScrollPanel = new javax.swing.JScrollPane();
        Employee_View_Table = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome Manager");
        setFocusable(false);
        setIconImages(null);
        setLocation(new java.awt.Point(650, 250));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(730, 499));
        setResizable(false);
        setSize(new java.awt.Dimension(730, 499));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Button_Panel.setBackground(new java.awt.Color(88, 171, 255));
        Button_Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        Button_Panel.setOpaque(false);
        Button_Panel.setPreferredSize(new java.awt.Dimension(180, 570));

        Product_Button.setBackground(new java.awt.Color(88, 171, 255));
        Product_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Product_Button.setForeground(new java.awt.Color(255, 255, 255));
        Product_Button.setText("Product");
        Product_Button.setToolTipText("");
        Product_Button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.darkGray));
        Product_Button.setContentAreaFilled(false);
        Product_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Product_ButtonActionPerformed(evt);
            }
        });

        BranchLogs_Button.setBackground(new java.awt.Color(88, 171, 255));
        BranchLogs_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BranchLogs_Button.setForeground(new java.awt.Color(255, 255, 255));
        BranchLogs_Button.setText("Branch Logs");
        BranchLogs_Button.setToolTipText("");
        BranchLogs_Button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.darkGray));
        BranchLogs_Button.setContentAreaFilled(false);
        BranchLogs_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BranchLogs_ButtonActionPerformed(evt);
            }
        });

        Order_Button.setBackground(new java.awt.Color(88, 171, 255));
        Order_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Order_Button.setForeground(new java.awt.Color(255, 255, 255));
        Order_Button.setText("Order");
        Order_Button.setToolTipText("");
        Order_Button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.darkGray));
        Order_Button.setContentAreaFilled(false);
        Order_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Order_ButtonActionPerformed(evt);
            }
        });

        EmployeesList_Button.setBackground(new java.awt.Color(88, 171, 255));
        EmployeesList_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        EmployeesList_Button.setForeground(new java.awt.Color(255, 255, 255));
        EmployeesList_Button.setText("Employee List");
        EmployeesList_Button.setToolTipText("");
        EmployeesList_Button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.darkGray));
        EmployeesList_Button.setContentAreaFilled(false);
        EmployeesList_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeesList_ButtonActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Consolas", 3, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("System");

        jLabel1.setFont(new java.awt.Font("Consolas", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Stocking ");

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

        javax.swing.GroupLayout Button_PanelLayout = new javax.swing.GroupLayout(Button_Panel);
        Button_Panel.setLayout(Button_PanelLayout);
        Button_PanelLayout.setHorizontalGroup(
            Button_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Button_PanelLayout.createSequentialGroup()
                .addGroup(Button_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Button_PanelLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Button_PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Button_PanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(Button_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BranchLogs_Button, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(Product_Button, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(EmployeesList_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Order_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        Button_PanelLayout.setVerticalGroup(
            Button_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Button_PanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(jLabel24)
                .addGap(33, 33, 33)
                .addComponent(Product_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BranchLogs_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Order_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EmployeesList_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        getContentPane().add(Button_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Tabbed_Panel.setToolTipText("");

        Product_Tab.setBackground(new java.awt.Color(88, 171, 255));
        Product_Tab.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        Product_Tab.setForeground(new java.awt.Color(255, 255, 255));

        kGradientPanel3.setkGradientFocus(-375);
        kGradientPanel3.setkStartColor(new java.awt.Color(88, 189, 255));

        jLabel11.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel11.setText("Product name");

        Remove_Product_Name_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Remove_Product_Name_TextFieldActionPerformed(evt);
            }
        });

        RemoveProduct_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RemoveProduct_Button.setText("Remove Product");
        RemoveProduct_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        RemoveProduct_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveProduct_ButtonActionPerformed(evt);
            }
        });

        Product_Remove_Status.setEditable(false);
        Product_Remove_Status.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Product_Remove_ScrollPanel.setViewportView(Product_Remove_Status);

        stock_table_remove.setAutoCreateRowSorter(true);
        stock_table_remove.setBackground(new java.awt.Color(51, 51, 51));
        stock_table_remove.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        stock_table_remove.setForeground(new java.awt.Color(255, 255, 255));
        stock_table_remove.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Amount (Piece)"
            }
        ));
        stock_table_remove.setRowHeight(22);
        jScrollPane2.setViewportView(stock_table_remove);

        SearchStock_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SearchStock_Button.setText("Search");
        SearchStock_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        SearchStock_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchStock_ButtonActionPerformed(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(102, 153, 255));
        jLabel16.setFont(new java.awt.Font("Serif", 1, 35)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Product");
        jLabel16.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 655, Short.MAX_VALUE)
            .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel3Layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2)
                        .addGroup(kGradientPanel3Layout.createSequentialGroup()
                            .addGap(243, 243, 243)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(kGradientPanel3Layout.createSequentialGroup()
                            .addGap(90, 90, 90)
                            .addComponent(jLabel11)
                            .addGap(18, 18, 18)
                            .addComponent(Remove_Product_Name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(SearchStock_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(kGradientPanel3Layout.createSequentialGroup()
                            .addGap(107, 107, 107)
                            .addComponent(Product_Remove_ScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(kGradientPanel3Layout.createSequentialGroup()
                            .addGap(235, 235, 235)
                            .addComponent(RemoveProduct_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(6, 6, 6)))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
            .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel3Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jLabel16)
                    .addGap(18, 18, 18)
                    .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Remove_Product_Name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SearchStock_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(RemoveProduct_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(Product_Remove_ScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(24, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout Product_TabLayout = new javax.swing.GroupLayout(Product_Tab);
        Product_Tab.setLayout(Product_TabLayout);
        Product_TabLayout.setHorizontalGroup(
            Product_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Product_TabLayout.createSequentialGroup()
                .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Product_TabLayout.setVerticalGroup(
            Product_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Product_TabLayout.createSequentialGroup()
                .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Tabbed_Panel.addTab("Remove", Product_Tab);

        Branche_Log_Tab.setBackground(new java.awt.Color(88, 171, 255));
        Branche_Log_Tab.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

        kGradientPanel4.setkGradientFocus(-375);
        kGradientPanel4.setkStartColor(new java.awt.Color(88, 189, 255));

        jLabel2.setBackground(new java.awt.Color(102, 153, 255));
        jLabel2.setFont(new java.awt.Font("Serif", 1, 35)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Branch Logs");
        jLabel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));

        Sale_Tab.setBackground(new java.awt.Color(255, 255, 255));
        Sale_Tab.setForeground(new java.awt.Color(255, 255, 255));
        Sale_Tab.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel6.setText("Enter Date");

        jLabel18.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel18.setText("Product Name");

        View_Sales_Name_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                View_Sales_Name_TextFieldActionPerformed(evt);
            }
        });

        SearchSale_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SearchSale_Button.setText("Search");
        SearchSale_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Sales ID", "Product name", "Amount (Piece)", "Sale Date"
            }
        ));
        Sales_View_Table.setRowHeight(22);
        Sales_View_ScrollPanel.setViewportView(Sales_View_Table);

        sales_year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----", "2020" }));
        sales_year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sales_yearActionPerformed(evt);
            }
        });

        sales_month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        sales_month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sales_monthActionPerformed(evt);
            }
        });

        sales_day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--" }));

        jLabel9.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel9.setText("Year:");

        jLabel10.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel10.setText("Month:");

        jLabel12.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel12.setText("Day:");

        javax.swing.GroupLayout Sale_TabLayout = new javax.swing.GroupLayout(Sale_Tab);
        Sale_Tab.setLayout(Sale_TabLayout);
        Sale_TabLayout.setHorizontalGroup(
            Sale_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Sale_TabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Sales_View_ScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(Sale_TabLayout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(Sale_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Sale_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SearchSale_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Sale_TabLayout.createSequentialGroup()
                        .addComponent(sales_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sales_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sales_day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(View_Sales_Name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        Sale_TabLayout.setVerticalGroup(
            Sale_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Sale_TabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Sale_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sales_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sales_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sales_day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addGap(8, 8, 8)
                .addGroup(Sale_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(View_Sales_Name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SearchSale_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Sales_View_ScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );

        View_Sub_Tab.addTab("Sales Logs", Sale_Tab);

        Import__Tab.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel7.setText("Product Name");

        jLabel19.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel19.setText("Enter Date");

        View_import_Name_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                View_import_Name_TextFieldActionPerformed(evt);
            }
        });

        SearchImport_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SearchImport_Button.setText("Search");
        SearchImport_Button.setToolTipText("");
        SearchImport_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        SearchImport_Button.setContentAreaFilled(false);
        SearchImport_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchImport_ButtonActionPerformed(evt);
            }
        });

        Import_View_Table.setBackground(new java.awt.Color(51, 51, 51));
        Import_View_Table.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Import_View_Table.setForeground(new java.awt.Color(255, 255, 255));
        Import_View_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Import ID", "Product Name", "Amount (Box)", "Import Date"
            }
        ));
        Import_View_Table.setRowHeight(22);
        Import_View_SP.setViewportView(Import_View_Table);

        import_year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----", "2020" }));
        import_year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                import_yearActionPerformed(evt);
            }
        });

        import_month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        import_month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                import_monthActionPerformed(evt);
            }
        });

        import_day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--" }));

        jLabel3.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel3.setText("Year:");

        jLabel4.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel4.setText("Month:");

        jLabel5.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel5.setText("Day:");

        javax.swing.GroupLayout Import__TabLayout = new javax.swing.GroupLayout(Import__Tab);
        Import__Tab.setLayout(Import__TabLayout);
        Import__TabLayout.setHorizontalGroup(
            Import__TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Import__TabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Import_View_SP, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Import__TabLayout.createSequentialGroup()
                .addGap(0, 95, Short.MAX_VALUE)
                .addGroup(Import__TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Import__TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SearchImport_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(View_import_Name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Import__TabLayout.createSequentialGroup()
                        .addComponent(import_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(import_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(import_day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(104, 104, 104))
        );
        Import__TabLayout.setVerticalGroup(
            Import__TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Import__TabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Import__TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(import_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(import_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(import_day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Import__TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(View_import_Name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SearchImport_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Import_View_SP, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(218, 218, 218))
        );

        View_Sub_Tab.addTab("Import Logs", Import__Tab);

        javax.swing.GroupLayout kGradientPanel4Layout = new javax.swing.GroupLayout(kGradientPanel4);
        kGradientPanel4.setLayout(kGradientPanel4Layout);
        kGradientPanel4Layout.setHorizontalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 655, Short.MAX_VALUE)
            .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel4Layout.createSequentialGroup()
                    .addGap(218, 218, 218)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(224, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(View_Sub_Tab, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        kGradientPanel4Layout.setVerticalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
            .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel4Layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(View_Sub_Tab, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(26, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout Branche_Log_TabLayout = new javax.swing.GroupLayout(Branche_Log_Tab);
        Branche_Log_Tab.setLayout(Branche_Log_TabLayout);
        Branche_Log_TabLayout.setHorizontalGroup(
            Branche_Log_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Branche_Log_TabLayout.setVerticalGroup(
            Branche_Log_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Tabbed_Panel.addTab("View", Branche_Log_Tab);

        Order_Tab.setBackground(new java.awt.Color(88, 171, 255));
        Order_Tab.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

        kGradientPanel5.setkGradientFocus(-375);
        kGradientPanel5.setkStartColor(new java.awt.Color(88, 189, 255));

        jLabel22.setBackground(new java.awt.Color(102, 153, 255));
        jLabel22.setFont(new java.awt.Font("Serif", 1, 35)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Order");
        jLabel22.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));

        Order_Product.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel15.setText("Product name");

        jLabel20.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel20.setText("Order amount");

        Order_Product_Name_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Order_Product_Name_TextFieldActionPerformed(evt);
            }
        });

        SearchOrder_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SearchOrder_Button.setText("Search");
        SearchOrder_Button.setToolTipText("");
        SearchOrder_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        SearchOrder_Button.setContentAreaFilled(false);
        SearchOrder_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchOrder_ButtonActionPerformed(evt);
            }
        });

        Product_Order_Table.setAutoCreateRowSorter(true);
        Product_Order_Table.setBackground(new java.awt.Color(51, 51, 51));
        Product_Order_Table.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Product_Order_Table.setForeground(new java.awt.Color(255, 255, 255));
        Product_Order_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Product ID", "Product Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Product_Order_Table.setRowHeight(22);
        Product_Order_ScrollPanel.setViewportView(Product_Order_Table);

        stock_table_Order.setAutoCreateRowSorter(true);
        stock_table_Order.setBackground(new java.awt.Color(51, 51, 51));
        stock_table_Order.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        stock_table_Order.setForeground(new java.awt.Color(255, 255, 255));
        stock_table_Order.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Amount (Piece)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        stock_table_Order.setRowHeight(22);
        Stock_Table_Order.setViewportView(stock_table_Order);

        Order_Product_Amount_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Order_Product_Amount_TextFieldActionPerformed(evt);
            }
        });

        OrderProduct_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        OrderProduct_Button.setText("Order");
        OrderProduct_Button.setToolTipText("");
        OrderProduct_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        OrderProduct_Button.setContentAreaFilled(false);
        OrderProduct_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderProduct_ButtonActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel23.setText("Product In Stock");

        jLabel25.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel25.setText("Select Product");

        javax.swing.GroupLayout Order_ProductLayout = new javax.swing.GroupLayout(Order_Product);
        Order_Product.setLayout(Order_ProductLayout);
        Order_ProductLayout.setHorizontalGroup(
            Order_ProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Order_ProductLayout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addGroup(Order_ProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Order_ProductLayout.createSequentialGroup()
                        .addComponent(Stock_Table_Order, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Product_Order_ScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Order_ProductLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Order_Product_Amount_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(OrderProduct_Button)
                        .addGap(88, 88, 88))))
            .addGroup(Order_ProductLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(Order_ProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Order_ProductLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(28, 28, 28)
                        .addComponent(Order_Product_Name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SearchOrder_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(Order_ProductLayout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel25)
                        .addGap(96, 96, 96))))
        );

        Order_ProductLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {OrderProduct_Button, SearchOrder_Button});

        Order_ProductLayout.setVerticalGroup(
            Order_ProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Order_ProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Order_ProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Order_Product_Name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchOrder_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Order_ProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Order_ProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Stock_Table_Order, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(Product_Order_ScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Order_ProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OrderProduct_Button)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Order_Product_Amount_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        Order_ProductLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {OrderProduct_Button, SearchOrder_Button});

        Order_Sub_Tab.addTab("Order", Order_Product);

        Incorrect_Order_Tab.setBackground(new java.awt.Color(255, 255, 255));

        SearchIncorrectOrder_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SearchIncorrectOrder_Button.setText("Search");
        SearchIncorrectOrder_Button.setToolTipText("");
        SearchIncorrectOrder_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        SearchIncorrectOrder_Button.setContentAreaFilled(false);
        SearchIncorrectOrder_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchIncorrectOrder_ButtonActionPerformed(evt);
            }
        });

        Incorrect_Order_Update_Table.setBackground(new java.awt.Color(51, 51, 51));
        Incorrect_Order_Update_Table.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Incorrect_Order_Update_Table.setForeground(new java.awt.Color(255, 255, 255));
        Incorrect_Order_Update_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Product Name", "Amount (Box)", "Order Date", "Received Date", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Incorrect_Order_Update_Table.setRowHeight(22);
        Product_Update_ScrollPanel.setViewportView(Incorrect_Order_Update_Table);

        Update_Product_Name_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update_Product_Name_TextFieldActionPerformed(evt);
            }
        });

        ConfirmOrder_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ConfirmOrder_Button.setText("Confirm order");
        ConfirmOrder_Button.setToolTipText("");
        ConfirmOrder_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        ConfirmOrder_Button.setContentAreaFilled(false);
        ConfirmOrder_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmOrder_ButtonActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel21.setText("Product Name");

        Incorrect_Import_Update_Table.setBackground(new java.awt.Color(51, 51, 51));
        Incorrect_Import_Update_Table.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Incorrect_Import_Update_Table.setForeground(new java.awt.Color(255, 255, 255));
        Incorrect_Import_Update_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Import ID", "Product Name", "Amount (Box)", "Import Date"
            }
        ));
        Incorrect_Import_Update_Table.setRowHeight(22);
        Product_Update_ScrollPanel1.setViewportView(Incorrect_Import_Update_Table);

        javax.swing.GroupLayout Incorrect_Order_TabLayout = new javax.swing.GroupLayout(Incorrect_Order_Tab);
        Incorrect_Order_Tab.setLayout(Incorrect_Order_TabLayout);
        Incorrect_Order_TabLayout.setHorizontalGroup(
            Incorrect_Order_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Incorrect_Order_TabLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ConfirmOrder_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(234, 234, 234))
            .addGroup(Incorrect_Order_TabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Incorrect_Order_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Product_Update_ScrollPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                    .addComponent(Product_Update_ScrollPanel1))
                .addContainerGap())
            .addGroup(Incorrect_Order_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Incorrect_Order_TabLayout.createSequentialGroup()
                    .addGap(106, 106, 106)
                    .addComponent(jLabel21)
                    .addGap(18, 18, 18)
                    .addComponent(Update_Product_Name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(SearchIncorrectOrder_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(76, Short.MAX_VALUE)))
        );
        Incorrect_Order_TabLayout.setVerticalGroup(
            Incorrect_Order_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Incorrect_Order_TabLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(Product_Update_ScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Product_Update_ScrollPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ConfirmOrder_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(Incorrect_Order_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Incorrect_Order_TabLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(Incorrect_Order_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Update_Product_Name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SearchIncorrectOrder_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(280, Short.MAX_VALUE)))
        );

        Order_Sub_Tab.addTab("Incorrect Order", Incorrect_Order_Tab);

        javax.swing.GroupLayout kGradientPanel5Layout = new javax.swing.GroupLayout(kGradientPanel5);
        kGradientPanel5.setLayout(kGradientPanel5Layout);
        kGradientPanel5Layout.setHorizontalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 655, Short.MAX_VALUE)
            .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel5Layout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(kGradientPanel5Layout.createSequentialGroup()
                            .addGap(249, 249, 249)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(Order_Sub_Tab, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(18, Short.MAX_VALUE)))
        );
        kGradientPanel5Layout.setVerticalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
            .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel5Layout.createSequentialGroup()
                    .addGap(66, 66, 66)
                    .addComponent(jLabel22)
                    .addGap(18, 18, 18)
                    .addComponent(Order_Sub_Tab, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .addGap(66, 66, 66)))
        );

        javax.swing.GroupLayout Order_TabLayout = new javax.swing.GroupLayout(Order_Tab);
        Order_Tab.setLayout(Order_TabLayout);
        Order_TabLayout.setHorizontalGroup(
            Order_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Order_TabLayout.createSequentialGroup()
                .addComponent(kGradientPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Order_TabLayout.setVerticalGroup(
            Order_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Order_TabLayout.createSequentialGroup()
                .addComponent(kGradientPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Tabbed_Panel.addTab("Order", Order_Tab);

        Employee_Tab.setBackground(new java.awt.Color(88, 171, 255));
        Employee_Tab.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

        kGradientPanel6.setkGradientFocus(-375);
        kGradientPanel6.setkStartColor(new java.awt.Color(88, 189, 255));

        jLabel8.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel8.setText("Employee name");

        View_Employee_Name_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                View_Employee_Name_TextFieldActionPerformed(evt);
            }
        });

        SearchEmployee_Button.setBackground(new java.awt.Color(255, 255, 255));
        SearchEmployee_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SearchEmployee_Button.setText("Search");
        SearchEmployee_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        SearchEmployee_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchEmployee_ButtonActionPerformed(evt);
            }
        });

        Employee_View_Table.setAutoCreateRowSorter(true);
        Employee_View_Table.setBackground(new java.awt.Color(51, 51, 51));
        Employee_View_Table.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Employee_View_Table.setForeground(new java.awt.Color(255, 255, 255));
        Employee_View_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Position", "Tel."
            }
        ));
        Employee_View_Table.setRowHeight(22);
        Employee_View_ScrollPanel.setViewportView(Employee_View_Table);

        jLabel17.setBackground(new java.awt.Color(102, 153, 255));
        jLabel17.setFont(new java.awt.Font("Serif", 1, 35)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Employee List");
        jLabel17.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));

        javax.swing.GroupLayout kGradientPanel6Layout = new javax.swing.GroupLayout(kGradientPanel6);
        kGradientPanel6.setLayout(kGradientPanel6Layout);
        kGradientPanel6Layout.setHorizontalGroup(
            kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 655, Short.MAX_VALUE)
            .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel6Layout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(kGradientPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(18, 18, 18)
                            .addComponent(View_Employee_Name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addComponent(SearchEmployee_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(111, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Employee_View_ScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        kGradientPanel6Layout.setVerticalGroup(
            kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
            .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel6Layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(jLabel17)
                    .addGap(28, 28, 28)
                    .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(View_Employee_Name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SearchEmployee_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(Employee_View_ScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(50, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout Employee_TabLayout = new javax.swing.GroupLayout(Employee_Tab);
        Employee_Tab.setLayout(Employee_TabLayout);
        Employee_TabLayout.setHorizontalGroup(
            Employee_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Employee_TabLayout.createSequentialGroup()
                .addComponent(kGradientPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        Employee_TabLayout.setVerticalGroup(
            Employee_TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Employee_TabLayout.createSequentialGroup()
                .addComponent(kGradientPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Tabbed_Panel.addTab("Update", Employee_Tab);

        getContentPane().add(Tabbed_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, -29, 670, 600));

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

    private void Product_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Product_ButtonActionPerformed
        // TODO add your handling code here:
        Tabbed_Panel.setSelectedIndex(0);
    }//GEN-LAST:event_Product_ButtonActionPerformed

    private void EmployeesList_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployeesList_ButtonActionPerformed
        Tabbed_Panel.setSelectedIndex(3);
    }//GEN-LAST:event_EmployeesList_ButtonActionPerformed

    private void BranchLogs_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BranchLogs_ButtonActionPerformed
        Tabbed_Panel.setSelectedIndex(1);
    }//GEN-LAST:event_BranchLogs_ButtonActionPerformed

    private void SearchSale_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchSale_ButtonActionPerformed
        try{
            // get pro name from text field
            String pro_name = View_Sales_Name_TextField.getText();
            String year = sales_year.getSelectedItem().toString();
            String month = sales_month.getSelectedItem().toString();
            String day = sales_day.getSelectedItem().toString();
            List<Sales> sale = null;
            
            // Didn't put year
            if(year == "----" && month != "--"){
                JOptionPane.showMessageDialog(this, "Please select year.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // check condition which method to be used
            if((pro_name == null || pro_name.trim().length() == 0) && (year == "----" && month == "--" && day == "--")){
                sale = saleDAO.getSalesByBranchName(branch_name);
            } 
            else if(pro_name == null || pro_name.trim().length() == 0){
                sale = saleDAO.getSalesByDate(year, month, day, branch_name);
            }
            else if(year == "----" && month == "--" && day == "--"){
                sale = saleDAO.getSalesByProductNameBranch(pro_name, branch_name);
            }
            else {
                sale = saleDAO.getSalesByProductNameDate(pro_name, year, month, day, branch_name);
            }
            
            // No result
            if(sale.size() == 0){
                // Beacuse there is no product of this name
                if(year == "----" && month == "--" && day == "--")
                    JOptionPane.showMessageDialog(this, "There is no \"" + pro_name + "\" in sale.");
                else{
                    // Because there is no sale of this product in this year
                    if(month == "--" && day == "--") JOptionPane.showMessageDialog(this, "There is no sale of this product in \"" + year + "\".");
                    // Because there is no sale of this product in this year and month
                    else if(day == "--") JOptionPane.showMessageDialog(this, "There is no sale of this product in \"" + year + ":" + month + "\".");
                    // Because there is no sale of this product in this date
                    else JOptionPane.showMessageDialog(this, "There is no sale of this product in \"" + year + ":" + month + ":" + day + "\".");
                }
                return;
            }
            
            // create tablemodel
            ManagerSalesTableModel model = new ManagerSalesTableModel(sale);
            Sales_View_Table.setModel(model);
            TableColumnModel Sales_View_columnModel = Sales_View_Table.getColumnModel();
            Sales_View_columnModel.getColumn(0).setPreferredWidth(10);
            Sales_View_columnModel.getColumn(2).setPreferredWidth(10);
            
        } catch(Exception exc){
            exc.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_SearchSale_ButtonActionPerformed

    private void View_import_Name_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_View_import_Name_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_View_import_Name_TextFieldActionPerformed

    private void SearchImport_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchImport_ButtonActionPerformed
        try{
            // get pro name from text field
            String pro_name = View_import_Name_TextField.getText();
            String year = import_year.getSelectedItem().toString();
            String month = import_month.getSelectedItem().toString();
            String day = import_day.getSelectedItem().toString();
            List<Import> Import = null;
            
            // Didn't put year
            if(year == "----" && (month != "--" || day != "--")){
                JOptionPane.showMessageDialog(this, "Please select year.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // check condition which method to be used
            if((pro_name == null || pro_name.trim().length() == 0) && (year == "----" && month == "--" && day == "--")){
                Import = importDAO.getAllImports(branch_name);
            } 
            else if(pro_name == null || pro_name.trim().length() == 0){
                Import = importDAO.getImportsByDate(year, month, day, branch_name);
            }
            else if(year == "----" && month == "--" && day == "--"){
                Import = importDAO.getImportsByProductName(pro_name, branch_name);
            }
            else {
                Import = importDAO.getImportsByProductNameDate(year, month, day, pro_name, branch_name);
            }
            
            // No result
            if(Import.size() == 0){
                // Beacuse there is no product of this name
                if(year == "----" && month == "--" && day == "--")
                    JOptionPane.showMessageDialog(this, "There is no \"" + pro_name + "\" in import.");
                else{
                    // Because there is no sale of this product in this year
                    if(month == "--" && day == "--") JOptionPane.showMessageDialog(this, "There is no import of this product in \"" + year + "\".");
                    // Because there is no sale of this product in this year and month
                    else if(day == "--") JOptionPane.showMessageDialog(this, "There is no import of this product in \"" + year + ":" + month + "\".");
                    // Because there is no sale of this product in this date
                    else JOptionPane.showMessageDialog(this, "There is no import of this product in \"" + year + ":" + month + ":" + day + "\".");
                }
                return;
            }
            
            // create tablemodel
            ImportTableModel model = new ImportTableModel(Import);
            Import_View_Table.setModel(model);
            TableColumnModel Import_View_columnModel = Import_View_Table.getColumnModel();
            Import_View_columnModel.getColumn(0).setPreferredWidth(10);
            Import_View_columnModel.getColumn(2).setPreferredWidth(10);
            
        } catch(Exception exc){
            exc.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
    }//GEN-LAST:event_SearchImport_ButtonActionPerformed

    private void View_Employee_Name_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_View_Employee_Name_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_View_Employee_Name_TextFieldActionPerformed

    private void SearchEmployee_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchEmployee_ButtonActionPerformed
        try{
            // get pro name from text field
            String emp_name = View_Employee_Name_TextField.getText();
            List<Employee> employee = null;
            
            // check condition which method to be used
            if(emp_name != null && emp_name.trim().length() > 0){
                employee = employeeDAO.getEmployeesByName(emp_name, branch_name);
            } else {
                employee = employeeDAO.getAllEmployees(branch_name);
            }
            
            // No result
            if(employee.size() == 0){
                JOptionPane.showMessageDialog(this, "There is no \"" + emp_name + "\" in employee list.");
                return;
            }
            
            // create tablemodel
            EmployeeTableModel model = new EmployeeTableModel(employee);
            Employee_View_Table.setModel(model);
            TableColumnModel Employee_View_columnModel = Employee_View_Table.getColumnModel();
            Employee_View_columnModel.getColumn(0).setPreferredWidth(10);
            Employee_View_columnModel.getColumn(1).setPreferredWidth(150);
            Employee_View_columnModel.getColumn(2).setPreferredWidth(15);
            Employee_View_columnModel.getColumn(3).setPreferredWidth(10);
            
            
        } catch(Exception exc){
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SearchEmployee_ButtonActionPerformed

    private void Order_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Order_ButtonActionPerformed
        // TODO add your handling code here:
        Tabbed_Panel.setSelectedIndex(2);
    }//GEN-LAST:event_Order_ButtonActionPerformed

    private void Remove_Product_Name_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Remove_Product_Name_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Remove_Product_Name_TextFieldActionPerformed

    private void RemoveProduct_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveProduct_ButtonActionPerformed
        try{
            // Get the selected item
            int row = stock_table_remove.getSelectedRow();
            
            // Didn't select any item
            if(row < 0){
                JOptionPane.showMessageDialog(this, "Please select a product to remove.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Confirm to delete
            int response = JOptionPane.showConfirmDialog(this, "Remove this product?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            // Not delete
            if(response != JOptionPane.YES_OPTION){
                return;
            }
            
            // Prepare to delete
            Stock tempStock = (Stock) stock_table_remove.getValueAt(row, StockTableModel.OBJECT_COL);
            int pro_id = tempStock.getProId();
            String pro_name = tempStock.getProName();
            
            // Delete
            stockDAO.deleteStock(pro_id, branch_name);
            
            refreshStockView();
            
            Product_Remove_Status.setText(Product_Remove_Status.getText() + "Product: " + pro_name + " has Been removed.\n");
            
        } catch(Exception exc){
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_RemoveProduct_ButtonActionPerformed

    private void Order_Product_Name_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Order_Product_Name_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Order_Product_Name_TextFieldActionPerformed

    private void SearchOrder_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchOrder_ButtonActionPerformed
        try{
            // get pro name from text field
            String pro_name = Order_Product_Name_TextField.getText();
            List<Stock> stock = null;
            List<Product> product = null;
            
            // check condition which method to be used
            if(pro_name != null && pro_name.trim().length() > 0){
                stock = stockDAO.getStocksByName(pro_name, branch_name);
                product = productDAO.getActiveProductsByName(pro_name);
            } else {
                stock = stockDAO.getAllStocks(branch_name);
                product = productDAO.getAllActiveProducts();
            }
            
            // No result
            if(product.size() == 0){
                JOptionPane.showMessageDialog(this, "There is no \"" + pro_name + "\" in product list.");
                return;
            }
            
            StockTableModel stock_model = new StockTableModel(stock);
            stock_table_Order.setModel(stock_model);
            TableColumnModel stock_Order_columnModel = stock_table_Order.getColumnModel();
            stock_Order_columnModel.getColumn(0).setPreferredWidth(10);
            stock_Order_columnModel.getColumn(1).setPreferredWidth(55);
            stock_Order_columnModel.getColumn(2).setPreferredWidth(20);
            
            ManagerOrderProductTableModel product_model = new ManagerOrderProductTableModel(product);
            Product_Order_Table.setModel(product_model);
            TableColumnModel Product_Order_columnModel = Product_Order_Table.getColumnModel();
            Product_Order_columnModel.getColumn(0).setPreferredWidth(10);
            Product_Order_columnModel.getColumn(1).setPreferredWidth(55);
                
        } catch(Exception exc){
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_SearchOrder_ButtonActionPerformed

    
    private void OrderProduct_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderProduct_ButtonActionPerformed
        try{
            // Get the selected item
            int row = Product_Order_Table.getSelectedRow();
            int amount;
            
            // Didn't select any item
            if(row < 0){
                JOptionPane.showMessageDialog(this, "Please select a product from central kitchen to order.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Didn't input the amount
            if(Order_Product_Amount_TextField.getText() == null || Order_Product_Amount_TextField.getText().trim().length() == 0){
                JOptionPane.showMessageDialog(this, "Please input order amount.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Get the amount of ordered product
            if(isNumeric(Order_Product_Amount_TextField.getText())){
                amount = Integer.parseInt(Order_Product_Amount_TextField.getText());
            } else {
                JOptionPane.showMessageDialog(this, "Please input a number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // The amount is negative
            if(amount <= 0){
                JOptionPane.showMessageDialog(this, "Amount can't be equal or less than 0.\nPlease input again.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
                            
            // Prepare to order
            Product tempProduct = (Product) Product_Order_Table.getValueAt(row, CEOProductTableModel.OBJECT_COL);
            int pro_id = tempProduct.getProId();
            
            // Check before order
            int response = JOptionPane.showConfirmDialog(this, "Order this product?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            // Not order
            if(response != JOptionPane.YES_OPTION){
                return;
            }
            
            // Order
            orderDAO.insertOrder(pro_id, amount, branch_name);
            
            JOptionPane.showMessageDialog(this, "Order successful", "Order product", JOptionPane.INFORMATION_MESSAGE);
            
        } catch(Exception exc){
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_OrderProduct_ButtonActionPerformed

    private void View_Sales_Name_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_View_Sales_Name_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_View_Sales_Name_TextFieldActionPerformed

    private void Order_Product_Amount_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Order_Product_Amount_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Order_Product_Amount_TextFieldActionPerformed

    private void Update_Product_Name_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update_Product_Name_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Update_Product_Name_TextFieldActionPerformed

    private void SearchIncorrectOrder_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchIncorrectOrder_ButtonActionPerformed
        try{
            // get pro name from text field
            String pro_name = Update_Product_Name_TextField.getText();
            List<Orders> orders = null;
            List<Import> Import = null;
            
            // check condition which method to be used
            if(pro_name != null && pro_name.trim().length() > 0){
                orders = orderDAO.getOrdersByProductNameOfBranch(branch_name, pro_name, true);
                Import = importDAO.getAllIncorrectImportsByProductName(branch_name, pro_name);
            } else {
                Import = importDAO.getAllIncorrectImports(branch_name);
                orders = orderDAO.getAllOrdersOfBranch(branch_name, true);
            }
            
            // No result
            if(orders.size() == 0){
                JOptionPane.showMessageDialog(this, "There is no \"" + pro_name + "\" in incorrect order.");
                return;
            }
            
            ImportTableModel import_model = new ImportTableModel(Import);
            Incorrect_Import_Update_Table.setModel(import_model);
            TableColumnModel Import_View_columnModel = Incorrect_Import_Update_Table.getColumnModel();
            Import_View_columnModel.getColumn(0).setPreferredWidth(10);
            Import_View_columnModel.getColumn(2).setPreferredWidth(10);
            
            // create tablemodel
            EmployeeManagerOrderTableModel order_model = new EmployeeManagerOrderTableModel(orders);
            Incorrect_Order_Update_Table.setModel(order_model);
            TableColumnModel Incorrect_Order_Update_columnModel = Incorrect_Order_Update_Table.getColumnModel();
            Incorrect_Order_Update_columnModel.getColumn(0).setPreferredWidth(6);
            Incorrect_Order_Update_columnModel.getColumn(1).setPreferredWidth(80);
            Incorrect_Order_Update_columnModel.getColumn(2).setPreferredWidth(80);
            Incorrect_Order_Update_columnModel.getColumn(3).setPreferredWidth(45);
            Incorrect_Order_Update_columnModel.getColumn(4).setPreferredWidth(100);
            Incorrect_Order_Update_columnModel.getColumn(5).setPreferredWidth(15);
            
            
        } catch(Exception exc){
            exc.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
    }//GEN-LAST:event_SearchIncorrectOrder_ButtonActionPerformed

    private void ConfirmOrder_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmOrder_ButtonActionPerformed
        try{
            // Get the selected item
            int row = Incorrect_Order_Update_Table.getSelectedRow();
            int response = 0;
            
            // Didn't select any item
            if(row < 0){
                JOptionPane.showMessageDialog(this, "Please select an order to confirm.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Prepare to confirm
            Orders tempOrders = (Orders) Incorrect_Order_Update_Table.getValueAt(row, EmployeeManagerOrderTableModel.OBJECT_COL);
            String pro_name = tempOrders.getProName();
            int pro_id = orderDAO.getProductId(tempOrders.getOrderId(), pro_name);
            int amount = importDAO.getAmount(tempOrders.getOrderId());
            
            // Check before confirm
            if(tempOrders.getAmount() != amount){
                response = JOptionPane.showConfirmDialog(this, "Are you sure to confirm this order?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);  
            }
            
            // Not confirm
            if(response != JOptionPane.YES_OPTION){
                return;
            }
            
            // Confirm
            orderDAO.updateOrder(tempOrders);
            
            // There is this product in the branch's stock
            if(stockDAO.isStock(pro_id, branch_name))
                stockDAO.updateStock(pro_id, branch_name, amount);
            // No product of this name in the branch
            else
                stockDAO.insertStock(pro_id, amount, branch_name);
            
            JOptionPane.showMessageDialog(this, "Order complete.");
            
            refreshOrderView();
            refreshImportView();
            refreshStockView();
            
        } catch(Exception exc){
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        } 
        
    }//GEN-LAST:event_ConfirmOrder_ButtonActionPerformed

    private void SearchStock_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchStock_ButtonActionPerformed
        try{
            // get pro name from text field
            String pro_name = Remove_Product_Name_TextField.getText();
            List<Stock> stock = null;
            
            // check condition which method to be used
            if(pro_name != null && pro_name.trim().length() > 0){
                stock = stockDAO.getStocksByName(pro_name, branch_name);
            } else {
                stock = stockDAO.getAllStocks(branch_name);
            }
            
            // No result
            if(stock.size() == 0){
                JOptionPane.showMessageDialog(this, "There is no \"" + pro_name + "\" in stock.");
                return;
            }
            
            // create tablemodel
            StockTableModel model = new StockTableModel(stock);
            stock_table_remove.setModel(model);
            TableColumnModel stock_remove_columnModel = stock_table_remove.getColumnModel();
            stock_remove_columnModel.getColumn(0).setPreferredWidth(20);
            stock_remove_columnModel.getColumn(1).setPreferredWidth(250);
            stock_remove_columnModel.getColumn(2).setPreferredWidth(20);
            
        } catch(Exception exc){
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SearchStock_ButtonActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        // Log out from the system
        Login frame = new Login();
        
        setVisible(false);
        frame.setVisible(true);

    }//GEN-LAST:event_LogoutActionPerformed

    private void import_yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_import_yearActionPerformed
        // Convert the data type of year
        if(import_year.getSelectedItem() != "----") check = Integer.parseInt(import_year.getSelectedItem().toString());
    }//GEN-LAST:event_import_yearActionPerformed

    private void import_monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_import_monthActionPerformed
        // Handling the number of days based on month
        List<String> list = new ArrayList<String>(Arrays.asList(days));
        String[] day = null;

        if(import_month.getSelectedItem() == "02"){
            list.remove("30");
            list.remove("31");
            if(!((check % 4 == 0) && (check % 100 != 0) || (check % 400 == 0))) list.remove("29");
        }
        else if(import_month.getSelectedItem() == "04" || import_month.getSelectedItem() == "06"
                || import_month.getSelectedItem() == "09" || import_month.getSelectedItem() == "11"){
            list.remove("31");
        }
        
        day = list.toArray(new String[0]);
        DefaultComboBoxModel model = new DefaultComboBoxModel(day);
        import_day.setModel(model);

    }//GEN-LAST:event_import_monthActionPerformed

    private void sales_monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sales_monthActionPerformed
        // Handling the number of days based on month
        List<String> list = new ArrayList<String>(Arrays.asList(days));
        String[] day = null;

        if(sales_month.getSelectedItem() == "02"){
            list.remove("30");
            list.remove("31");
            if(!((check % 4 == 0) && (check % 100 != 0) || (check % 400 == 0))) list.remove("29");
        }
        else if(sales_month.getSelectedItem() == "04" || sales_month.getSelectedItem() == "06"
                || sales_month.getSelectedItem() == "09" || sales_month.getSelectedItem() == "11"){
            list.remove("31");
        }
        
        day = list.toArray(new String[0]);
        DefaultComboBoxModel model = new DefaultComboBoxModel(day);
        sales_day.setModel(model);
    }//GEN-LAST:event_sales_monthActionPerformed

    private void sales_yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sales_yearActionPerformed
        if(sales_year.getSelectedItem() != "----") check = Integer.parseInt(sales_year.getSelectedItem().toString());
    }//GEN-LAST:event_sales_yearActionPerformed
    
    // Check if the text can be converted to numbers
    public boolean isNumeric(String str){
        try {
            int num = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public boolean CheckDateFormat(String date){
        // check date format
        return !(date.trim().length() != 10 || date.charAt(4) != '-' || date.charAt(7) != '-');
    }
    
    // Refresh the view of stock's table
    private void refreshStockView() {
        
        try{
            List<Stock> stock = stockDAO.getAllStocks(branch_name);
            
            // create new table model
            StockTableModel model = new StockTableModel(stock);
            
            stock_table_Order.setModel(model);
            TableColumnModel stock_Order_columnModel = stock_table_Order.getColumnModel();
            stock_Order_columnModel.getColumn(0).setPreferredWidth(10);
            stock_Order_columnModel.getColumn(1).setPreferredWidth(55);
            stock_Order_columnModel.getColumn(2).setPreferredWidth(20);
            
            stock_table_remove.setModel(model);
            TableColumnModel stock_remove_columnModel = stock_table_remove.getColumnModel();
            stock_remove_columnModel.getColumn(0).setPreferredWidth(20);
            stock_remove_columnModel.getColumn(1).setPreferredWidth(250);
            stock_remove_columnModel.getColumn(2).setPreferredWidth(20);
            
        } catch(Exception exc){
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Refresh the view of incorrect order's table
    private void refreshOrderView() {
        try{
            List<Orders> Orders = orderDAO.getAllOrdersOfBranch(branch_name, true);
            
            // create new table model
            EmployeeManagerOrderTableModel model = new EmployeeManagerOrderTableModel(Orders);
            
            Incorrect_Order_Update_Table.setModel(model);
            TableColumnModel Incorrect_Order_Update_columnModel = Incorrect_Order_Update_Table.getColumnModel();
            Incorrect_Order_Update_columnModel.getColumn(0).setPreferredWidth(6);
            Incorrect_Order_Update_columnModel.getColumn(1).setPreferredWidth(80);
            Incorrect_Order_Update_columnModel.getColumn(2).setPreferredWidth(80);
            Incorrect_Order_Update_columnModel.getColumn(3).setPreferredWidth(45);
            Incorrect_Order_Update_columnModel.getColumn(4).setPreferredWidth(100);
            Incorrect_Order_Update_columnModel.getColumn(5).setPreferredWidth(15);
            
        } catch(Exception exc){
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Refresh the view of incorrect import's table
    private void refreshImportView() {
        try{
            List<Import> Import = importDAO.getAllIncorrectImports(branch_name);
            
            // create new table model
            ImportTableModel model = new ImportTableModel(Import);
            
            Incorrect_Import_Update_Table.setModel(model);
            TableColumnModel Incorrect_Import_Update_columnModel = Incorrect_Import_Update_Table.getColumnModel();
            Incorrect_Import_Update_columnModel.getColumn(0).setPreferredWidth(15);
            
        } catch(Exception exc){
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manager1().setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BranchLogs_Button;
    private javax.swing.JPanel Branche_Log_Tab;
    private javax.swing.JPanel Button_Panel;
    private javax.swing.JButton ConfirmOrder_Button;
    private javax.swing.JPanel Employee_Tab;
    private javax.swing.JScrollPane Employee_View_ScrollPanel;
    private javax.swing.JTable Employee_View_Table;
    private javax.swing.JButton EmployeesList_Button;
    private javax.swing.JScrollPane Import_View_SP;
    private javax.swing.JTable Import_View_Table;
    private javax.swing.JPanel Import__Tab;
    private javax.swing.JTable Incorrect_Import_Update_Table;
    private javax.swing.JPanel Incorrect_Order_Tab;
    private javax.swing.JTable Incorrect_Order_Update_Table;
    private javax.swing.JButton Logout;
    private javax.swing.JButton OrderProduct_Button;
    private javax.swing.JButton Order_Button;
    private javax.swing.JPanel Order_Product;
    private javax.swing.JTextField Order_Product_Amount_TextField;
    private javax.swing.JTextField Order_Product_Name_TextField;
    private javax.swing.JTabbedPane Order_Sub_Tab;
    private javax.swing.JPanel Order_Tab;
    private javax.swing.JButton Product_Button;
    private javax.swing.JScrollPane Product_Order_ScrollPanel;
    private javax.swing.JTable Product_Order_Table;
    private javax.swing.JScrollPane Product_Remove_ScrollPanel;
    private javax.swing.JTextPane Product_Remove_Status;
    private javax.swing.JPanel Product_Tab;
    private javax.swing.JScrollPane Product_Update_ScrollPanel;
    private javax.swing.JScrollPane Product_Update_ScrollPanel1;
    private javax.swing.JButton RemoveProduct_Button;
    private javax.swing.JTextField Remove_Product_Name_TextField;
    private javax.swing.JPanel Sale_Tab;
    private javax.swing.JScrollPane Sales_View_ScrollPanel;
    private javax.swing.JTable Sales_View_Table;
    private javax.swing.JButton SearchEmployee_Button;
    private javax.swing.JButton SearchImport_Button;
    private javax.swing.JButton SearchIncorrectOrder_Button;
    private javax.swing.JButton SearchOrder_Button;
    private javax.swing.JButton SearchSale_Button;
    private javax.swing.JButton SearchStock_Button;
    private javax.swing.JScrollPane Stock_Table_Order;
    private javax.swing.JTabbedPane Tabbed_Panel;
    private javax.swing.JTextField Update_Product_Name_TextField;
    private javax.swing.JTextField View_Employee_Name_TextField;
    private javax.swing.JTextField View_Sales_Name_TextField;
    private javax.swing.JTabbedPane View_Sub_Tab;
    private javax.swing.JTextField View_import_Name_TextField;
    private javax.swing.JComboBox<String> import_day;
    private javax.swing.JComboBox<String> import_month;
    private javax.swing.JComboBox<String> import_year;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel4;
    private keeptoo.KGradientPanel kGradientPanel5;
    private keeptoo.KGradientPanel kGradientPanel6;
    private javax.swing.JComboBox<String> sales_day;
    private javax.swing.JComboBox<String> sales_month;
    private javax.swing.JComboBox<String> sales_year;
    private javax.swing.JTable stock_table_Order;
    private javax.swing.JTable stock_table_remove;
    // End of variables declaration//GEN-END:variables

}
