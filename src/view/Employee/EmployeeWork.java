package view.Employee;

import controller.EmployeeController;
import controller.OrderController;
import database.Dbconnection;
import model.Employee_model;
import model.OrderFood;
import view.Welcome;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeeWork extends javax.swing.JFrame implements ActionListener {

    JLabel crms_Logo,rectangle_dash,dash_icon,small_profile;
    JButton dashboard,order_history,setting_emp,logOut;
    JPanel pan;
OrderFood orderFood;
OrderController orderController;
    PreparedStatement ps;
    Dbconnection db;
    int var=1;

    public static final String[] columns = {

            "Product Id","Table ID","Product","Quantity","Price"

    };

    private final DefaultTableModel model = new DefaultTableModel(columns, 0);
    // Create the JTable
    private final JTable table = new JTable(model);

    JPanel mainPanel = new JPanel();
    EmployeeController employeeController;
    Employee_model employee_model;


    public EmployeeWork() {
        this.db = new Dbconnection();
        this.employeeController = new EmployeeController();
        this.orderController=new OrderController();
        this.employee_model = employeeController.fetchLoggedInEmployee();
        initialize_dash_GUI();
        UI();
        handAction();
        database();

        Orderside();
    }

//
    void database(){
        OrderController orderController=new OrderController();
        ResultSet resultSet= orderController.extractintoTable();
        int number=orderController.extractTable();
        try{
        while(resultSet.next()){
            int id=resultSet.getInt("OrderId");
            String table=resultSet.getString("TabelID");
            String name=resultSet.getString("Name");
            String quantity=resultSet.getString("Quantity");
            String total=resultSet.getString("Total");
            model.addRow(new Object[]{
                    id,table,name,quantity,total

            });
        }

    }catch(SQLException e){
        e.printStackTrace();
    }

    }

    public void initialize_dash_GUI(){
        setTitle("Crescent RMS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(0,0,1280,700);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);

        // Selecting color
        Color n = new Color(0x2E3337);
        getContentPane().setBackground(n);
        Image icon = Toolkit.getDefaultToolkit().getImage("public\\logo.png");
        setIconImage(icon);
        JLabel staff_title = new JLabel("Customer's orders");
        staff_title.setBounds(330,30,320,40);
        staff_title.setFont(new Font("forte",Font.PLAIN,25));
        staff_title.setForeground(Color.PINK);
        add(staff_title);
        setVisible(true);

        //        mainPanel.setSize(400,300);
        mainPanel.setBounds(280,180,500,600);
        mainPanel.setBackground(new Color(0x2E3337));
        mainPanel.setVisible(true);
        add(mainPanel);

    }


    public void UI() {
        // color selection for the button
        Color b_c = new Color(0x212429);
        getContentPane().setBackground(new Color(0x2E3337));

        // label for dashboard
        rectangle_dash = new JLabel(new ImageIcon("public\\chef_icon\\Rectangle 47.png"));
        rectangle_dash.setBounds(0, 0, 250, 900);
        add(rectangle_dash);

        // adding logo to the dashboard label
        crms_Logo = new JLabel(new ImageIcon("public\\chef_icon\\Crescent_RMS_logo1.png"));
        crms_Logo.setBounds(20, 30, 200, 200);
        rectangle_dash.add(crms_Logo);

        // icon for buttons
        dash_icon = new JLabel(new ImageIcon("public\\icons\\profile.png"));
        dash_icon.setBounds(40, 250, 40, 40);
        rectangle_dash.add(dash_icon);

        dash_icon = new JLabel(new ImageIcon("public\\icons\\order.png"));
        dash_icon.setBounds(40, 300, 40, 40);
        rectangle_dash.add(dash_icon);

        dash_icon = new JLabel(new ImageIcon("public\\icons\\settings.png"));
        dash_icon.setBounds(40, 350, 40, 40);
        rectangle_dash.add(dash_icon);

        dash_icon = new JLabel(new ImageIcon("public\\icons\\logout.png"));
        dash_icon.setBounds(40, 400, 40, 40);
        rectangle_dash.add(dash_icon);

        small_profile = new JLabel(new ImageIcon("public\\chef_icon\\Small_profile.png"));
        small_profile.setBounds(900, 10, 50, 50);
        add(small_profile);

        JLabel small_emp_title = new JLabel(employee_model.getName());
        small_emp_title.setBounds(950, 10, 140, 40);
        small_emp_title.setFont(new Font("times", Font.BOLD, 13));
        small_emp_title.setForeground(Color.white);
        add(small_emp_title);


        // button for dashboard
        dashboard = new JButton("Dashboard");
        dashboard.setBounds(85, 250, 150, 30);
        dashboard.setFont(new Font("times", Font.PLAIN, 20));
        dashboard.setBackground(b_c);
        dashboard.setBorderPainted(false);
        dashboard.setForeground(Color.WHITE);
        dashboard.setFocusable(false);
        dashboard.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rectangle_dash.add(dashboard);


        order_history = new JButton("Orders");
        order_history.setBounds(85, 300, 130, 25);
        order_history.setFont(new Font("times", Font.PLAIN, 20));
        order_history.setBackground(Color.WHITE);
//            order_history.setBorderPainted(false);
        order_history.setForeground(Color.pink);
        order_history.setFocusable(false);
        order_history.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rectangle_dash.add(order_history);

        setting_emp = new JButton("Setting");
        setting_emp.setBounds(85, 350, 130, 25);
        setting_emp.setFont(new Font("times", Font.PLAIN, 20));
        setting_emp.setBackground(b_c);
        setting_emp.setBorderPainted(false);
        setting_emp.setForeground(Color.white);
        setting_emp.setFocusable(false);
        setting_emp.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rectangle_dash.add(setting_emp);


        logOut = new JButton("Log Out");
        logOut.setBounds(85, 400, 130, 25);
        logOut.setFont(new Font("times", Font.PLAIN, 20));
        logOut.setBackground(b_c);
        logOut.setBorderPainted(false);
        logOut.setForeground(Color.white);
        logOut.setFocusable(false);
        logOut.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rectangle_dash.add(logOut);

        //Add panels and table to the main panel
        table.setBounds(10, 10, 900, 600);
        mainPanel.add(table, BorderLayout.EAST);
        JScrollPane sp = new JScrollPane(table);
        mainPanel.add(sp);

    }
        JPanel newPanel = new JPanel();


        public void Orderside () {

//        mainPanel.setSize(400,300);
            newPanel.setBounds(280, 180, 500, 600);
            newPanel.setBackground(new Color(0x2E3337));
            newPanel.setVisible(true);
            add(newPanel);



            JButton deleteProduct = new JButton("Delete Order");
            deleteProduct.setBounds(800, 185, 180, 40);
            deleteProduct.setBackground(new Color(0xD5CDF7));
            add(deleteProduct);
            deleteProduct.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = table.getSelectedRow();
                    String cell = table.getModel().getValueAt(row, 0).toString();
                    try {
                        String query = "select * from ordertable";
                        ResultSet resultSet = db.retrieve(query);
                        while (resultSet.next()) {
                            orderFood=new OrderFood();
                            String proid = String.valueOf((resultSet.getInt("OrderId")));
                            int proids = (resultSet.getInt("OrderId"));
                            String proname = (resultSet.getString("Name"));

                            if (cell.equals(proid)) {
                                var = 1;
                                int qstn = JOptionPane.showConfirmDialog(null,
                                        "Do you really want to delete\n" + proname + "?",
                                        "Delete Order", JOptionPane.YES_NO_OPTION);
                                if (qstn == JOptionPane.YES_OPTION) {
                                    int stat = orderController.deleteProduct(proids);
                                    if (stat > 0) {
                                        JOptionPane.showMessageDialog(null,
                                                proname + "\nis deleted succesfully");
                                        dispose();
                                        new EmployeeWork().setVisible(true);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "not deleted");
                                    }
                                }
                            }

                        if (var == 0) {
                            JOptionPane.showMessageDialog(null,
                                    "Sorry The order Doesn't Exist");

                        }}

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });

        }

    void handAction(){
        dashboard.addActionListener(this);
        order_history.addActionListener(this);
        setting_emp.addActionListener(this);
        logOut.addActionListener(this);
//        back_btn.addActionListener(this);
    }

    // Variables declaration - do not modify
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(dashboard)) {
            EmployeeWork.this.setVisible(false);
            Employee_Dashboard dash_emp = new Employee_Dashboard();
            dash_emp.setVisible(true);

        } else if (e.getSource().equals(order_history)) {

        } else if (e.getSource().equals(setting_emp)) {
            EmployeeWork.this.setVisible(false);
            Employee_setting orders = new Employee_setting();
            orders.setVisible(true);
        } else if (e.getSource().equals(logOut)) {
            String[] options = {"Yes", "No"};
            int jk = JOptionPane.showOptionDialog(null, "Do You Want To Logout??",
                    "Yes or No", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            if (jk == 0) {
                EmployeeWork.this.setVisible(false);
                Welcome well = new Welcome();
                well.setVisible(true);
            }


        }
        // End of variables declaration
    }
}
