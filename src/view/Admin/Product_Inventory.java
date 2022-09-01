package view.Admin;

import controller.AdminController;
import controller.Product_controller;
import database.Dbconnection;
import model.AdminModel;
import model.Employee_model;
import model.Product_model;
import view.Welcome;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Product_Inventory extends JFrame implements ActionListener {
    JButton dashboard, add_employee_btn, staffList, statistics, product,setting, logOut,back_btn;
    private JButton addButton,clearButton;
    JLabel dash_icon,rectangle_dash, crms_Logo;
//    JLabel dash_icon,rectangle_dash, crms_Logo,rectangle_menu;
    JLabel sn_label,product_name,product_code,product_available,product_price,product_action;
    JButton product_edit,product_delete,searchProduct;
    JTextField searchText;
    int var = 0;
    private JTextField pro_name_text,pro_code_text,pro_price_text,edit_text;
    private JCheckBox avai_text;
    Color n;
    Product_model product_model;
    Product_controller product_controller;
    PreparedStatement ps;
    Dbconnection db;
    AdminController adminController;
    AdminModel adminModel;

    // JTable Header
    public static final String[] columns = {
            "S.N.","ProductName","ProductCode","Available","ProductPrice"
    };

    private DefaultTableModel model = new DefaultTableModel(columns, 0);
    // Create the JTable
    private final JTable table = new JTable(model);

    public Product_Inventory() {
        this.adminController= new AdminController();
        this.adminModel=adminController.fetchLoggedInAdmin();
        this.product_controller = new Product_controller();
        this.product_model = product_controller.fetchProductdata();
        this.db = new Dbconnection();

        // initializing the GUI
        initialize_product_GUI();
        // initialize elements
        initialize_GUI_elements();

        try{
            ResultSet resultSet= product_controller.extractProduct();
            while(resultSet.next()){
                int id=resultSet.getInt("product_id");
                String name=resultSet.getString("product_name");
                String code=resultSet.getString("product_code");
                String available=resultSet.getString("product_available");
                String price=resultSet.getString("product_price");
                model.addRow(new Object[]{
                        id,name,code,available,price
                });

            }
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
    public void search(String search){
        model=(DefaultTableModel) table.getModel();
        TableRowSorter <DefaultTableModel > trs= new TableRowSorter<>(model);
        table.setRowSorter((trs));
        trs.setRowFilter(RowFilter.regexFilter(search));
    }

    public void initialize_product_GUI(){

        setTitle("Crescent RMS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(0,0,1280,700);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setLocationRelativeTo(null);

        // Selecting color
        n = new Color(0x2E3337);
        getContentPane().setBackground(n);
        Image icon = Toolkit.getDefaultToolkit().getImage("public\\logo.png");
        setIconImage(icon);
        setVisible(true);
    }

    public void initialize_GUI_elements() {

        dashboard_side();

        product_side();

//        Hand action();
        handAction();

    }

    public void dashboard_side() {

        // color selection for the button
        Color b_c = new Color(0x212429);

        // small profile icon
        JLabel small_profile = new JLabel(new ImageIcon("public\\chef_icon\\Small_profile.png"));
        small_profile.setBounds(900,10,50,50);
        add(small_profile);

        JLabel small_emp_title = new JLabel(adminModel.getFullName());
        small_emp_title.setBounds(955, 15, 140,40);
        small_emp_title.setFont(new Font("times",Font.BOLD,13));
        small_emp_title.setForeground(Color.white);
        add(small_emp_title);

        JLabel staff_title = new JLabel("Product Inventory");
        staff_title.setBounds(350,25,200,40);
        staff_title.setFont(new Font("forte",Font.PLAIN,25));
        staff_title.setForeground(Color.PINK);
        add(staff_title);

        // label for dashboard
        rectangle_dash = new JLabel(new ImageIcon("public\\chef_icon\\Rectangle 47.png"));
        rectangle_dash.setBounds(0, 0, 250, 900);
        add(rectangle_dash);

        // adding logo to the dashboard label
        crms_Logo = new JLabel(new ImageIcon("public\\chef_icon\\Crescent_RMS_logo1.png"));
        crms_Logo.setBounds(20, 30, 200, 200);
        rectangle_dash.add(crms_Logo);

        // employee dashboard icon for button
        dash_icon = new JLabel(new ImageIcon("public\\icons\\profile.png"));
        dash_icon.setBounds(40,250,40,40);
        rectangle_dash.add(dash_icon);

        dash_icon = new JLabel(new ImageIcon("public\\icon\\profile.png"));
        dash_icon.setBounds(40,300,40,40);
        rectangle_dash.add(dash_icon);

        dash_icon = new JLabel(new ImageIcon("public\\icons\\staff_list.png"));
        dash_icon.setBounds(40,350,40,40);
        rectangle_dash.add(dash_icon);

        dash_icon = new JLabel(new ImageIcon("public\\icons\\stat.png"));
        dash_icon.setBounds(40,400,40,40);
        rectangle_dash.add(dash_icon);

        dash_icon = new JLabel(new ImageIcon("public\\icons\\product_list.png"));
        dash_icon.setBounds(40,450,40,40);
        rectangle_dash.add(dash_icon);

        dash_icon = new JLabel(new ImageIcon("public\\icons\\settings.png"));
        dash_icon.setBounds(40,500,40,40);
        rectangle_dash.add(dash_icon);

        dash_icon = new JLabel(new ImageIcon("public\\icons\\logout.png"));
        dash_icon.setBounds(40,550,40,40);
        rectangle_dash.add(dash_icon);


        // button for dashboard
        dashboard = new JButton("Dashboard");
        dashboard.setBounds(85, 255, 140, 25);
        dashboard.setFont(new Font("times", Font.PLAIN, 20));
        dashboard.setBackground(b_c);
        dashboard.setBorderPainted(false);
        dashboard.setForeground(Color.white);
        dashboard.setFocusable(false);
        dashboard.setCursor(new Cursor(Cursor. HAND_CURSOR));
        rectangle_dash.add(dashboard);

        add_employee_btn = new JButton("Add Staff");
        add_employee_btn.setBounds(85, 305, 140, 25);
        add_employee_btn.setFont(new Font("times", Font.PLAIN, 20));
        add_employee_btn.setBackground(b_c);
        add_employee_btn.setBorderPainted(false);
        add_employee_btn.setForeground(Color.white);
        add_employee_btn.setFocusable(false);
        add_employee_btn.setCursor(new Cursor(Cursor. HAND_CURSOR));
        rectangle_dash.add(add_employee_btn);

        staffList = new JButton("Staff List");
        staffList.setBounds(85, 355, 130, 25);
        staffList.setFont(new Font("times", Font.PLAIN, 20));
        staffList.setBackground(b_c);
        staffList.setBorderPainted(false);
        staffList.setForeground(Color.white);
        staffList.setFocusable(false);
        staffList.setCursor(new Cursor(Cursor. HAND_CURSOR));
        rectangle_dash.add(staffList);

        statistics = new JButton("Statistics");
        statistics.setBounds(85, 405, 130, 25);
        statistics.setFont(new Font("times", Font.PLAIN, 20));
        statistics.setBackground(b_c);
        statistics.setBorderPainted(false);
        statistics.setForeground(Color.white);
        statistics.setFocusable(false);
        statistics.setCursor(new Cursor(Cursor. HAND_CURSOR));
        rectangle_dash.add(statistics);

        product = new JButton("Products");
        product.setBounds(85, 455, 130, 25);
        product.setFont(new Font("times", Font.PLAIN, 20));
        product.setBackground(Color.white);
        product.setBorderPainted(false);
        product.setForeground(Color.pink);
        product.setFocusable(false);
        product.setCursor(new Cursor(Cursor. HAND_CURSOR));
        rectangle_dash.add(product);

        setting = new JButton("Setting");
        setting.setBounds(85, 505, 130,25);
        setting.setFont(new Font("times",Font.PLAIN,20));
        setting.setBackground(b_c);
        setting.setBorderPainted(false);
        setting.setForeground(Color.white);
        setting.setFocusable(false);
        setting.setCursor(new Cursor(Cursor. HAND_CURSOR));
        rectangle_dash.add(setting);

        logOut = new JButton("Log Out");
        logOut.setBounds(85, 555, 130, 25);
        logOut.setFont(new Font("times", Font.PLAIN, 20));
        logOut.setBackground(b_c);
        logOut.setBorderPainted(false);
        logOut.setForeground(Color.white);
        logOut.setFocusable(false);
        logOut.setCursor(new Cursor(Cursor. HAND_CURSOR));
        rectangle_dash.add(logOut);

        back_btn = new JButton(new ImageIcon("public\\backBtn (1).png"));
        back_btn.setBounds(10, 5, 45, 45);
        back_btn.setOpaque(false);
        back_btn.setContentAreaFilled(false);
        back_btn.setBorderPainted(false);
        rectangle_dash.add(back_btn);

    }

        JPanel mainPanel = new JPanel();

        public void product_side(){

//        mainPanel.setSize(400,300);
        mainPanel.setBounds(280,180,500,600);
        mainPanel.setBackground(new Color(0x2E3337));
        mainPanel.setVisible(true);
        add(mainPanel);

        // Making new frame from adding  item
        JFrame add_window = new JFrame();
        add_window.setTitle("Add Product");
        add_window.setLayout(null);
        add_window.setBounds(600,300,320,300);
        add_window.setLocationRelativeTo(null);
        add_window.setBackground(n);
        add_window.setResizable(false);

        // Making new frame for updating product item
        JFrame update_window = new JFrame();
        update_window.setLayout(null);
        update_window.setTitle("UpdateProduct");
        update_window.setBounds(600,300,320,300);
        update_window.setLocationRelativeTo(null);
        update_window.setBackground(n);
        update_window.setResizable(false);

//       Update Button in the update window for product
        JButton updateButton = new JButton("UpdateItem");
        updateButton.setSize(30,30);
        updateButton.setBounds(20,200,110,30);
        updateButton.setBackground(new Color(0xD5CDF7));
        //Clear button
        JButton clearBtn = new JButton("Clear");
        clearBtn.setSize(30,30);
        clearBtn.setBounds(170,200,110,30);
        clearBtn.setBackground(new Color(0xD5CDF7));
        //Button panel
        update_window.add(updateButton);
        update_window.add(clearBtn);

 //Create the JTextFields panel
        pro_name_text  = new JTextField();
        pro_code_text  = new JTextField();
        avai_text = new JCheckBox();
        pro_price_text = new JTextField();
//        edit_text = new JTextField();
        //Add JTextFields to the panel
        pro_name_text.setBounds(120, 35, 140, 20);
        pro_code_text.setBounds(120,60 , 140, 20);
        avai_text.setBounds(120, 85, 140, 20);
        pro_price_text.setBounds(120, 110, 140, 20);

        add_window.add(pro_name_text);
        add_window.add(pro_code_text);
        add_window.add(avai_text);
        add_window.add(pro_price_text);


        JLabel sn_label = new JLabel("S.N.");
        sn_label.setBounds(5, 0, 140, 40);
        sn_label.setFont(new Font("times", Font.BOLD, 15));
        add_window.add(sn_label);

        JLabel pro_name = new JLabel("Product Name");
        pro_name.setBounds(5, 25, 140, 40);
        pro_name.setFont(new Font("times", Font.BOLD, 15));
        add_window.add(  pro_name);

        JLabel pro_code = new JLabel("Product code");
        pro_code.setBounds(5, 50, 140, 40);
        pro_code.setFont(new Font("times", Font.BOLD, 15));
        add_window.add(pro_code);

        JLabel avai = new JLabel("Available");
        avai.setBounds(5, 75, 140, 40);
        avai.setFont(new Font("times", Font.BOLD, 15));
        add_window.add( avai);

        JLabel pro_price = new JLabel("Product Price");
        pro_price.setBounds(5, 100, 140, 40);
        pro_price.setFont(new Font("times", Font.BOLD, 15));
        add_window.add(pro_price);


        JButton open_frame = new JButton("Add Product");
        open_frame.setBounds(800,185,180,40);
        open_frame.setBackground(new Color(0xD5CDF7));
        add(open_frame);

        JButton deleteProduct = new JButton("Delete Product");
        deleteProduct.setBounds(800,260,180,40);
        deleteProduct.setBackground(new Color(0xD5CDF7));
        add(deleteProduct);

        searchText = new JTextField("SearchProduct");
        searchText.setBounds(800,335,180,30);
        searchText.setBackground(new Color(0xFAFFFFFF, true));
            searchText.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    String searching=searchText.getText();
                    search(searching);
                }
            });
            searchText.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if(searchText.getText().equals("SearchProduct")){
                        searchText.setText("");
                    }
                }
                @Override
                public void focusLost(FocusEvent e) {
                    if(searchText.getText().equals("")){
                        searchText.setText("SearchProduct");
                    }
                }
            });
        add(searchText);

//
//        searchProduct = new JButton("SearchProduct");
//        searchProduct.setBounds(800,375,180,40);
//        searchProduct.setBackground(new Color(0xD5CDF7));
//        add(searchProduct);

        // Making new frame from adding  item
        JFrame delete_window = new JFrame();
        delete_window.setLayout(null);
        delete_window.setTitle("Delete Product");
        delete_window.setBounds(600,300,320,320);
        delete_window.setBackground(n);
        delete_window.setResizable(true);

        deleteProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete_window.setVisible(true);

            }

        });

        //Add button

        JLabel delete_label = new JLabel("Enter Product to delete:");
        delete_label.setBounds(0,0,250,30);

        JButton deletbtn = new JButton("Search");
        deletbtn.setBounds(20,200,110,30);
        deletbtn.setBackground(new Color(0xD5CDF7));

        JTextField searchptfield = new JTextField();
        searchptfield.setBounds(20,100,200,30);


        delete_window.add(deletbtn);
        delete_window.add(searchptfield);
        delete_window.add(delete_label);

        deletbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String query = "select * from product";
                    ResultSet resultSet = db.retrieve(query);
                    while (resultSet.next()) {
                        product_model = new Product_model();
                        String proid = String.valueOf((resultSet.getInt("product_id")));
                        int proids = (resultSet.getInt("product_id"));
                        String proname = (resultSet.getString("product_name"));

                        if (searchptfield.getText().equals(proid)) {
                            var = 1;
                            int qstn = JOptionPane.showConfirmDialog(null,
                                    "Do you really want to delete\n" + proname + "?",
                                    "Delete Account", JOptionPane.YES_NO_OPTION);
                            if (qstn == JOptionPane.YES_OPTION) {
                                int stat = product_controller.deleteCustomer(proids);
                                if (stat > 0) {
                                    JOptionPane.showMessageDialog(null,
                                            proname + "\nis deleted succesfully");
                                    dispose();
                                    new Product_Inventory().setVisible(true);
                                } else {
                                    JOptionPane.showMessageDialog(null, "not deleted");
                                }
                            }
                        }
                    }
                    if (var == 0){
                        JOptionPane.showMessageDialog(null,
                                "Sorry The Product Doesn't Exist");

                    }

                }catch (SQLException ex) {
                    ex.printStackTrace();
                }}
        });



        open_frame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                add_window.setVisible(true);
            }
        });



        //Add button
        addButton = new JButton("Add Item");
        addButton.setSize(30,30);
        addButton.setBounds(20,200,110,30);
        addButton.setBackground(new Color(0xD5CDF7));
        //Clear button
        clearButton = new JButton("Clear");
        clearButton.setSize(30,30);
        clearButton.setBounds(170,200,110,30);
        clearButton.setBackground(new Color(0xD5CDF7));
        //Button panel
        add_window.add(addButton);
        add_window.add(clearButton);


        // This code is called when the Add button is clicked.
        addButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String pro_name=pro_name_text.getText();
                String pro_code=pro_code_text.getText();
                String checkbox = null;
                if(avai_text.isSelected()){
                    checkbox = "available";
                }else if (!(avai_text.isSelected())){
                    checkbox = "Not available";
                }
                String pro_price=pro_price_text.getText();



                if (e.getSource().equals(addButton)) {
                    if (pro_name.isBlank() && pro_code.isBlank() && pro_price.isBlank()  /* &&t5.isBlank()*/){
                        JOptionPane.showMessageDialog(null, "Please Fill All \nThe Detail Below");
                    }

                    else if (pro_name.isBlank() ){
                        JOptionPane.showMessageDialog(null, "Please Fill  \nProduct Name");

                    }
                    else if (pro_code.isBlank() ){
                        JOptionPane.showMessageDialog(null, "Please Fill  \nProduct Code");

                    }
                    else if (pro_price.isBlank() ){
                        JOptionPane.showMessageDialog(null, "Please Fill  \nProduct Price");

                    }
                    else{
                        Product_model product_model = new Product_model(pro_name,pro_code,checkbox,pro_price);
                        Product_controller product_controller = new Product_controller();
                        int insert = product_controller.adding_food(product_model);

                        if (insert > 0) {
                            JOptionPane.showMessageDialog(null, "Product have been added!!");
                            product_controller=new Product_controller();
                            product_model=product_controller.fetchProductdata();
                            model.addRow(new Object[]{
                                    product_model.getProduct_id(),
                                    product_model.getProduct_name(),
                                    product_model.getProduct_code(),
                                    product_model.getProduct_available(),
                                    product_model.getProduct_price()});
                            add_window.dispose();
                        }}

                }
            }
        });

        // This code is called when the Clear button is clicked.
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Clear the form
                pro_name_text.setText("");
                pro_code_text.setText("");
                pro_price_text.setText("");
                edit_text.setText("");
            }
        });

        //
        JLabel snlabel = new JLabel("S.N.");
        snlabel.setBounds(5, 0, 140, 40);
        snlabel.setFont(new Font("times", Font.BOLD, 15));
        update_window.add(snlabel);

        JLabel proname = new JLabel("Product Name");
        proname.setBounds(5, 25, 140, 40);
        proname.setFont(new Font("times", Font.BOLD, 15));
        update_window.add(proname);

        JLabel procode = new JLabel("Product code");
        procode.setBounds(5, 50, 140, 40);
        procode.setFont(new Font("times", Font.BOLD, 15));
        update_window.add(procode);

        JLabel available = new JLabel("Available");
        available.setBounds(5, 75, 140, 40);
        available.setFont(new Font("times", Font.BOLD, 15));
        update_window.add(available);

        JLabel proprice = new JLabel("Product Price");
        proprice.setBounds(5, 100, 140, 40);
        proprice.setFont(new Font("times", Font.BOLD, 15));
        update_window.add(proprice);

        //Add panels and table to the main panel
        table.setBounds(10,10,900,600);
        mainPanel.add(table,BorderLayout.EAST);
        JScrollPane sp =new JScrollPane(table);
        mainPanel.add(sp);



        JButton update_productbtn = new JButton("UpdateProduct");
        update_productbtn.setBounds(800,550,180,40);


        update_productbtn.setBackground(new Color(0xD5CDF7));
        add(update_productbtn);

        JFrame updateFrame = new JFrame();
        updateFrame.setLayout(null);
        updateFrame.setTitle("UpdateFrame");
        updateFrame.setBounds(0,0,300,300);
        updateFrame.setLocationRelativeTo(null);
        updateFrame.setResizable(false);

        JLabel updateLabel = new JLabel("Enter Product_Id You Want To Update:");
        updateLabel.setBounds(0,0,250,30);

        JTextField updateField = new JTextField();
        updateField.setBounds(20,50,200,30);

        JButton updateBtn = new JButton("Update");
        updateBtn.setBounds(50,100,110,30);
        updateBtn.setBackground(new Color(0xD5CDF7));

        updateFrame.add(updateLabel);
        updateFrame.add(updateField);
        updateFrame.add(updateBtn);

        update_productbtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateFrame.setVisible(true);
        }
        });
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String query = "select * from product where product_id=?";
                    ps = db.connection.prepareStatement(query);
                    ps.setInt(1, Integer.parseInt(updateField.getText()));
                    ResultSet resultSet = db.retrieve(ps);
                    while (resultSet.next()){
                        String proid = String.valueOf((resultSet.getInt("product_id")));
                        int proids = (resultSet.getInt("product_id"));
                        String proName = (resultSet.getString("product_name"));
                        String proCode = (resultSet.getString("product_code"));
                        String proPrice = (resultSet.getString("product_price"));

                        Product_model product_model = new Product_model(proName,proCode,proPrice);
                        if (updateField.getText().equals(proid)) {
                            var = 1;
                            updateFrame.setVisible(false);
                            update_window.setVisible(true);

                            //Create the JTextFields panel
                            JTextField pronametext  = new JTextField(product_model.getProduct_name());
                            pronametext.setBounds(120, 35, 140, 20);

                            JTextField procodetext  = new JTextField(product_model.getProduct_code());
                            JCheckBox avaitext = new JCheckBox(product_model.getProduct_available());
                            JTextField propricetext = new JTextField(product_model.getProduct_price());

                            //Add JTextFields to the panel
                            procodetext.setBounds(120,60 , 140, 20);
                            avaitext.setBounds(120, 85, 140, 20);
                            propricetext.setBounds(120, 110, 140, 20);

                            update_window.add(pronametext);
                            update_window.add(procodetext);
                            update_window.add(avaitext);
                            update_window.add(propricetext);

                            updateButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    String proname = pronametext.getText();
                                    String procode = procodetext.getText();
                                    String cbox = null;
                                    if (avaitext.isSelected()) {
                                        cbox = "available";
                                    } else if (!(avaitext.isSelected())) {
                                        cbox = "Not available";
                                    }
                                    String proprice = propricetext.getText();


                                    if (e.getSource().equals(updateButton)) {
                                        if (proname.isBlank() && procode.isBlank() && proprice.isBlank()) {
                                            JOptionPane.showMessageDialog(null, "Please Fill All \nThe Detail Below");
                                        } else if (proname.isBlank()) {
                                            JOptionPane.showMessageDialog(null, "Please Fill  \nProduct Name");

                                        } else if (procode.isBlank()) {
                                            JOptionPane.showMessageDialog(null, "Please Fill  \nProduct Code");
                                        } else if (proprice.isBlank()) {
                                            JOptionPane.showMessageDialog(null, "Please Fill  \nProduct Price");

                                        } else {
                                            adminController = new AdminController();
                                            Product_model product_model1 = new Product_model(proids, proname, procode, cbox, proprice);
                                            int update = adminController.updateProduct(product_model1);
                                            if (update > 0) {
                                                JOptionPane.showMessageDialog(null, "Successfully updated");
                                                updateFrame.dispose();
                                                dispose();
                                                new Product_Inventory().setVisible(true);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Failed to update");
                                            }
                                        }
                                    }
                                }
                            });


                        }}}catch (SQLException ef){
                    ef.printStackTrace();
                }
            }
        });
        }




    void handAction(){
        dashboard.addActionListener(this);
        add_employee_btn.addActionListener(this);
        staffList.addActionListener(this);
        statistics.addActionListener(this);
        setting.addActionListener(this);
        product.addActionListener(this);
        logOut.addActionListener(this);
        back_btn.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(dashboard)){
            Product_Inventory.this.setVisible(false);
            Admin_dashboard adm = new Admin_dashboard();
            adm.setVisible(true);

        }
        else if (e.getSource().equals(add_employee_btn)){
            Product_Inventory.this.setVisible(false);
            Adding_employee add_btn = new Adding_employee();
            add_btn.setVisible(true);
//            JOptionPane.showMessageDialog(null,"Orders In Development Process");
        }
        else if (e.getSource().equals(staffList)){
            Product_Inventory.this.setVisible(false);
            Staff_list staffList_btn = new Staff_list();
            staffList_btn.setVisible(true);
//            JOptionPane.showMessageDialog(null,"Orders In Development Process");
        }
        else if (e.getSource().equals(statistics)){
            Product_Inventory.this.setVisible(false);
            new Graphs().setVisible(true);
        }
        else if (e.getSource().equals(product)){
        }
        else if (e.getSource().equals(setting)){
            Product_Inventory.this.setVisible(false);
            Admin_setting ad_set = new Admin_setting(new AdminModel());
            ad_set.setVisible(true);
        }
        else if (e.getSource().equals(logOut)){
            String[] options = {"Yes", "No"};
            int jk = JOptionPane.showOptionDialog(null,"Do You Want To Logout??",
                    "Yes or No",JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null,options,options[0]);

            if(jk == 0){
                Product_Inventory.this.setVisible(false);
                Welcome well = new Welcome();
                well.setVisible(true);
            }

        }else if(e.getSource().equals(back_btn)) {
            Product_Inventory.this.setVisible(false);
            Admin_dashboard back = new Admin_dashboard();
            back.setVisible(true);
        }

    }
}


