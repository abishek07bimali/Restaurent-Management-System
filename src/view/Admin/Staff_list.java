package view.Admin;

import controller.AdminController;
import controller.EmployeeController;
import database.Dbconnection;
import model.AdminModel;
import model.Employee_model;
import view.Welcome;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Staff_list extends JFrame implements ActionListener {

    // for the update of staff
    JLabel rectangle_menu, chef_icon;
    JLabel emp_name_label, ctz_no_label, e_mail_lbl, phone_no_lbl, position_lbl;
    JTextField emp_name, citizinship_no,e_mail, phone_no, position_txt, sal_amt, searchText;   JButton update_btn;
    // for the Staff list
    JLabel crms_Logo, rectangle_dash, dash_icon; // image JLabel
    JButton dashboard, add_employee_btn, staffList, statistics, product, setting, logOut, back_btn; // Menu side Buttons
    JButton delete_frame, update_frame,attendance;
    PreparedStatement ps;
    Dbconnection db;
    int var = 1;
    public static final String[] columns = {
            "IdNo.","StaffName ", "CitizenNo","PhoneNo", "Email","Position","Salary"};
    private DefaultTableModel model = new DefaultTableModel(columns, 0);
    // Create the JTable
    private final JTable table = new JTable(model);
    Color n, b_c;

    JFrame frame = new JFrame();
    EmployeeController employeeController;
    Employee_model employee_model;
    AdminModel adminModel;
    AdminController adminController;

    public Staff_list() {
        this.employeeController = new EmployeeController();
        this.employee_model = employeeController.fetchRegisteredEmployee();
        this.db = new Dbconnection();
        this.adminController = new AdminController();
        this.adminModel = adminController.fetchLoggedInAdmin();

        // initializing the GUI
        initialize_list_GUI();
        // initialize elements
        initialize_GUI_elements();
        handAction();
        dataExtractTable();
        Image icon = Toolkit.getDefaultToolkit().getImage("public\\logo.png");
        setIconImage(icon);
    }


    public void initialize_list_GUI() {
        setTitle("Crescent RMS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(0, 0, 1280, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);



        // Selecting color
        n = new Color(0x2E3337);
        b_c = new Color(0x212429);
        getContentPane().setBackground(n);

        n= new Color(0x2E3337);
        frame.setTitle("Crescent RMS");
        frame.getContentPane().setBackground(n);
        frame.setBackground(n);
//        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setBounds(0, 0, 860, 580);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
    }

    public void initialize_GUI_elements(){

        dashboard_side();
        staff_list_side();

    }
    public void dataExtractTable(){
        this.adminModel = adminController.fetchLoggedInAdmin();
        ResultSet resultSet= adminController.extractEmployee();

        try {
            while (resultSet.next()) {
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String date=resultSet.getString("citizen_no");
                String phone=resultSet.getString("phone");
                String mail=resultSet.getString("mail");
                String position=resultSet.getString("position");
                String salary=resultSet.getString("salary");
                model.addRow(new Object[]{
                        id,name,date,phone,mail,position,salary
                });
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    public void search(String search){
        model=(DefaultTableModel) table.getModel();
        TableRowSorter<DefaultTableModel > trs= new TableRowSorter<>(model);
        table.setRowSorter((trs));
        trs.setRowFilter(RowFilter.regexFilter(search));
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

        JLabel staff_title = new JLabel("Staff List");
        staff_title.setBounds(350,30,200,40);
        staff_title.setFont(new Font("forte",Font.PLAIN,25));
        staff_title.setForeground(Color.PINK);
        add(staff_title);


        // label for dashboard
        rectangle_dash = new JLabel(new ImageIcon("public\\chef_icon\\Rectangle 47.png"));
        rectangle_dash.setBounds(0,0,250,900);
        add(rectangle_dash);

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


        // adding logo to the dashboard label
        crms_Logo = new JLabel(new ImageIcon("public\\chef_icon\\Crescent_RMS_logo1.png"));
        crms_Logo.setBounds(20,30,200,200);
        rectangle_dash.add(crms_Logo);



        // button for dashboard
        dashboard = new JButton("Dashboard");
        dashboard.setBounds(85, 250,140,25);
        dashboard.setFont(new Font("times",Font.PLAIN,20));
        dashboard.setBackground(b_c);
        dashboard.setBorderPainted(false);
        dashboard.setForeground(Color.white);
        dashboard.setFocusable(false);
        dashboard.setCursor(new Cursor(Cursor. HAND_CURSOR));
        rectangle_dash.add(dashboard);

        add_employee_btn = new JButton("Add Staff");
        add_employee_btn.setBounds(85, 300,  140,30);
        add_employee_btn.setFont(new Font("times",Font.PLAIN,20));
        add_employee_btn.setBackground(b_c);
        add_employee_btn.setBorderPainted(false);
        add_employee_btn.setForeground(Color.white);
        add_employee_btn.setFocusable(false);
        add_employee_btn.setCursor(new Cursor(Cursor. HAND_CURSOR));
        rectangle_dash.add(add_employee_btn);

        staffList = new JButton("Staff List");
        staffList.setBounds(85, 350, 160,25);
        staffList.setFont(new Font("times",Font.PLAIN,20));
        staffList.setBackground(Color.white);
        staffList.setBorderPainted(false);
        staffList.setForeground(Color.pink);
        staffList.setFocusable(false);
        staffList.setCursor(new Cursor(Cursor. HAND_CURSOR));
        rectangle_dash.add(staffList);

        statistics = new JButton("Statistics");
        statistics.setBounds(85, 400, 130,25);
        statistics.setFont(new Font("times",Font.PLAIN,20));
        statistics.setBackground(b_c);
        statistics.setBorderPainted(false);
        statistics.setForeground(Color.white);
        statistics.setFocusable(false);
        statistics.setCursor(new Cursor(Cursor. HAND_CURSOR));
        rectangle_dash.add(statistics);

        product = new JButton("Products");
        product.setBounds(85, 450, 130,25);
        product.setFont(new Font("times",Font.PLAIN,20));
        product.setBackground(b_c);
        product.setBorderPainted(false);
        product.setForeground(Color.white);
        product.setFocusable(false);
        product.setCursor(new Cursor(Cursor. HAND_CURSOR));
        rectangle_dash.add(product);

        setting = new JButton("Settings");
        setting.setBounds(85, 500, 130,25);
        setting.setFont(new Font("times",Font.PLAIN,20));
        setting.setBackground(b_c);
        setting.setBorderPainted(false);
        setting.setForeground(Color.white);
        setting.setFocusable(false);
        setting.setCursor(new Cursor(Cursor. HAND_CURSOR));
        rectangle_dash.add(setting);

        logOut = new JButton("Log Out");
        logOut.setBounds(85, 550, 130,25);
        logOut.setFont(new Font("times",Font.PLAIN,20));
        logOut.setBackground(b_c);
        logOut.setBorderPainted(false);
        logOut.setForeground(Color.white);
        logOut.setFocusable(false);
        logOut.setCursor(new Cursor(Cursor. HAND_CURSOR));
        rectangle_dash.add(logOut);


    }




    JPanel mainPanel = new JPanel();
    public void staff_list_side(){

//        mainPanel.setSize(400,300);
        mainPanel.setBounds(300,180,550,500);
        mainPanel.setBackground(b_c);
        mainPanel.setVisible(true);
        add(mainPanel);
        //Add panels and table to the main panel
        table.setBounds(10,10,900,600);
        mainPanel.add(table);
        JScrollPane sp =new JScrollPane(table);
        mainPanel.add(sp);

        delete_frame = new JButton("DeleteStaff");
        delete_frame.setBounds(900,260,200,40);
        delete_frame.setFocusable(false);
        delete_frame.setBackground(new Color(0xD5CDF7));
        add(delete_frame);

        searchText = new JTextField("Search Employee");
        searchText.setBounds(900,390,200,30);
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
                if(searchText.getText().equals("Search Employee")){
                    searchText.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(searchText.getText().equals("")){
                    searchText.setText("Search Employee");
                }
            }
        });
        add(searchText);

        delete_frame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                String cell = table.getModel().getValueAt(row, 0).toString();
                try {
                    String query = "select * from employee";
                    ResultSet resultSet = db.retrieve(query);
                    while (resultSet.next()) {
                        employee_model = new Employee_model();
                        String empid = String.valueOf((resultSet.getInt("id")));
                        int empids = (resultSet.getInt("id"));
                        String empName = (resultSet.getString("name"));
                        if (cell.equals(empid)) {
                            var = 1;
                            int confirm = JOptionPane.showConfirmDialog(null,
                                    "The Employee Is:\n"+empName+"\nAre U Sure You Want To\n Delete This Account?",
                                    "Delete Account", JOptionPane.YES_NO_OPTION);
                            if (confirm == JOptionPane.YES_OPTION) {
//                                delete employee ID
                                int status = employeeController.deleteEmployee(empids);
                                if (status > 0) {
                                    JOptionPane.showMessageDialog(null, "The Account Has Been \nDeleted Successfully");
                                    dispose();
                                    delete_frame.setVisible(false);
                                    new Staff_list().setVisible(true);
                                } else {
                                    JOptionPane.showMessageDialog(null, "not deleted");
                                }
                            }

                        }
                    }
                    if (var == 0) {
                        JOptionPane.showMessageDialog(null,
                                "Sorry The employee Doesn't Exist");
                    }
                } catch (SQLException ep) {
                    ep.printStackTrace();
                }
            }
                    });



        update_frame = new JButton("UpdateStaffDetails");
        update_frame.setBounds(900,190,200,40);
        update_frame.setFocusable(false);
        update_frame.setBackground(new Color(0xD5CDF7));
        add(update_frame);


        JFrame updateFrame = new JFrame();
        updateFrame.setLayout(null);
        updateFrame.setTitle("UpdateFrame");
        updateFrame.setBounds(0,0,300,300);
        updateFrame.setLocationRelativeTo(null);
        updateFrame.setResizable(false);


        JLabel updateLabel = new JLabel("Enter Employee Id You Want To Update:");
        updateLabel.setBounds(0,0,250,30);

        JTextField updateField = new JTextField();
        updateField.setBounds(20,50,200,30);

        JButton updateBtn = new JButton("Update");
        updateBtn.setBounds(50,100,110,30);
        updateBtn.setBackground(new Color(0xD5CDF7));

        updateFrame.add(updateLabel);
        updateFrame.add(updateField);
        updateFrame.add(updateBtn);

            // label for text field
            rectangle_menu = new JLabel(new ImageIcon("public\\chef_icon\\Rectangle_Employee_add.png"));
            rectangle_menu.setBounds(0, 10, 860, 520);
            frame.add(rectangle_menu);

            // img icon to the frame
            chef_icon = new JLabel(new ImageIcon("public\\chef_icon\\malemale_pes_owner.png"));
            chef_icon.setBounds(340, 25, 800, 900);
            rectangle_menu.add(chef_icon);

            JLabel text_newEmployee = new JLabel("Update Employee");
            text_newEmployee.setBounds(75, 15, 200, 40);
            text_newEmployee.setFont(new Font("times", Font.BOLD, 16));
            text_newEmployee.setForeground(Color.GRAY);
            rectangle_menu.add(text_newEmployee);

            emp_name_label = new JLabel("Employee Name");
            emp_name_label.setBounds(65, 70, 140, 40);
            emp_name_label.setFont(new Font("times", Font.BOLD, 13));
            rectangle_menu.add(emp_name_label);

            ctz_no_label = new JLabel("Citizenship");
            ctz_no_label.setBounds(65, 120, 140, 40);
            ctz_no_label.setFont(new Font("times", Font.BOLD, 13));
            rectangle_menu.add(ctz_no_label);

            phone_no_lbl = new JLabel("Phone no.");
            phone_no_lbl.setBounds(65, 170, 140, 40);
            phone_no_lbl.setFont(new Font("times", Font.BOLD, 13));
            rectangle_menu.add(phone_no_lbl);

            e_mail_lbl = new JLabel("E-Mail");
            e_mail_lbl.setBounds(65, 220, 140, 40);
            e_mail_lbl.setFont(new Font("times", Font.BOLD, 13));
            rectangle_menu.add(e_mail_lbl);

            position_lbl = new JLabel("Position");
            position_lbl.setBounds(65, 270, 140, 40);
            position_lbl.setFont(new Font("times", Font.BOLD, 13));
            rectangle_menu.add(position_lbl);
            // Salary
            JLabel sal_lbl = new JLabel("Salary");
            sal_lbl.setBounds(370, 270, 140, 40);
            sal_lbl.setFont(new Font("times", Font.BOLD, 13));
            rectangle_menu.add(sal_lbl);

            JLabel sal_lbl_note = new JLabel("* Rs. ");
            sal_lbl_note.setBounds(460, 298, 100, 40);
            sal_lbl_note.setFont(new Font("times", Font.ITALIC, 10));
            sal_lbl_note.setForeground(Color.GRAY);
            rectangle_menu.add(sal_lbl_note);


            // save button
            update_btn = new JButton("UpdateEmployee");
            update_btn.setBounds(480, 420, 200, 40);
            update_btn.setBackground(b_c);
            update_btn.setForeground(Color.white);
            update_btn.setBorderPainted(false);
            updateBtn.setFocusable(false);
            rectangle_menu.add(update_btn);


        update_frame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFrame.setVisible(true);
            }
        });

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String query = "select * from employee where id =?";
                    ps = db.connection.prepareStatement(query);
                    ps.setInt(1, Integer.parseInt(updateField.getText()));
                    ResultSet resultSet = db.retrieve(ps);
                    while (resultSet.next()){
                        String empid = String.valueOf((resultSet.getInt("id")));
                        int empids = (resultSet.getInt("id"));
                        String empName = (resultSet.getString("name"));
                        String empcitizen = (resultSet.getString("citizen_no"));
                        String empmail= (resultSet.getString("mail"));
                        String empphone = (resultSet.getString("phone"));
                        String empposition = (resultSet.getString("position"));
                        String empsalary = (resultSet.getString("salary"));

                        Employee_model employee_model = new Employee_model(empName,empcitizen,empmail,empphone,empposition,empsalary);
                        if (updateField.getText().equals(empid)) {
                            var = 1;
                            int confirm = JOptionPane.showConfirmDialog(null,
                                    "The Employee Is:\n" + empName + "\nAre U Sure You Want To\n Update This Account?",
                                    "UpdateAccount", JOptionPane.YES_NO_OPTION);
                            if (confirm == JOptionPane.YES_OPTION) {
                                staffList.setVisible(false);
                                updateFrame.dispose();
                                frame.setVisible(true);


                                // Text Field
                                emp_name = new JTextField(employee_model.getName());
                                emp_name.setBounds(170, 70, 320, 35);
                                emp_name.setOpaque(false);
                                emp_name.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
                                rectangle_menu.add(emp_name);

                                citizinship_no = new JTextField(employee_model.getCitizen_no());
                                citizinship_no.setBounds(170, 120, 160, 35);
                                citizinship_no.setOpaque(false);
                                citizinship_no.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
                                rectangle_menu.add(citizinship_no);

                                e_mail = new JTextField(employee_model.getMail());
                                e_mail.setBounds(170, 220, 320, 35);
                                e_mail.setOpaque(false);
                                e_mail.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
                                rectangle_menu.add(e_mail);

                                phone_no = new JTextField(employee_model.getPhone());
                                phone_no.setBounds(170, 170, 160, 35);
                                phone_no.setOpaque(false);
                                phone_no.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
                                rectangle_menu.add(phone_no);

                                position_txt = new JTextField(employee_model.getPosition());
                                position_txt.setBounds(170, 270, 160, 35);
                                position_txt.setOpaque(false);
                                position_txt.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
                                rectangle_menu.add(position_txt);

                                sal_amt = new JTextField(employee_model.getSalary());  // enter validation for entering number only
                                sal_amt.setBounds(450, 270, 140, 40);
                                sal_amt.setOpaque(false);
                                sal_amt.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
                                rectangle_menu.add(sal_amt);


                                update_btn.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        String name = emp_name.getText();
                                        String citizen = citizinship_no.getText();
                                        String phone = phone_no.getText();
                                        String mail = e_mail.getText();
                                        String position = position_txt.getText();
                                        String salary = sal_amt.getText();

                                        if(e.getSource().equals(update_btn)){
                                            if ((name.isBlank() || name.equals(employee_model.getName())) &&
                                                    (citizen.isBlank() || citizen.equals(employee_model.getCitizen_no()))
                                                    && (phone.isBlank() || phone.equals(employee_model.getPhone())) &&
                                                    (mail.isBlank() || mail.equals(employee_model.getMail())) &&
                                                    (position.isBlank() || position.equals(employee_model.getPosition())) &&
                                                    (salary.isBlank() || salary.equals(employee_model.getSalary())))
                                            {
                                                JOptionPane.showMessageDialog(null, "Please Get Some Changes First");
                                            }

                                            else {
                                                adminController = new AdminController();
                                                Employee_model employee_model1 = new Employee_model(empids ,name,citizen,phone,mail,position,salary);
                                                int update = adminController.updateEmployeeAdmin(employee_model1);
                                                if (update>0){
                                                    JOptionPane.showMessageDialog(null, "Successfully updated");
                                                    updateFrame.dispose();
                                                    frame.dispose();
                                                    dispose();
                                                    new Staff_list().setVisible(true);
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Failed to update");
                                                }
                                            }}}
                                });

                                update_frame.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        frame.setVisible(true);
                                    }
                                });
                            }

                        }
                    }
                    if (var == 0){
                        JOptionPane.showMessageDialog(null,
                                "Sorry The Product Doesn't Exist");
                    }

                }catch (SQLException ex){
                    ex.printStackTrace();
                }
            }
        });


        attendance = new JButton("Show Attendance");
        attendance.setBounds(900,330,200,40);
        attendance.setBackground(new Color(0xD5CDF7));
        attendance.setFocusable(false);
        add(attendance);
        attendance.addActionListener(this::attendance);

    }

    public void attendance(ActionEvent e){
        if(e.getSource().equals(attendance)){
            new Attendance().setVisible(true);
        }

    }
    void handAction() {
//        update_frame.addActionListener(this::updateEmployee);
        dashboard.addActionListener(this);
        add_employee_btn.addActionListener(this);
        staffList.addActionListener(this);
        statistics.addActionListener(this);
        setting.addActionListener(this);
        product.addActionListener(this);
        logOut.addActionListener(this);
//        back_btn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(dashboard)) {
            Staff_list.this.setVisible(false);
            Admin_dashboard adm = new Admin_dashboard();
            adm.setVisible(true);
        } else if (e.getSource().equals(add_employee_btn)) {
            Staff_list.this.setVisible(false);
            Adding_employee add_btn = new Adding_employee();
            add_btn.setVisible(true);
        } else if (e.getSource().equals(staffList)) {
            new Staff_list().setVisible(true);

        } else if (e.getSource().equals(statistics)) {
            Staff_list.this.setVisible(false);
            new Graphs().setVisible(true);
        } else if (e.getSource().equals(product)) {
            Staff_list.this.setVisible(false);
            Product_Inventory product_btn = new Product_Inventory();
            product_btn.setVisible(true);
        } else if (e.getSource().equals(setting)) {
            Staff_list.this.setVisible(false);
            Admin_setting ad_set = new Admin_setting(new AdminModel());
            ad_set.setVisible(true);
        } else if (e.getSource().equals(logOut)) {
            String[] options = {"Yes", "No"};
            int jk = JOptionPane.showOptionDialog(null, "Do You Want To Logout??",
                    "Yes or No", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            if (jk == 0) {
                Staff_list.this.setVisible(false);
                Welcome well = new Welcome();
                well.setVisible(true);

            }

        }else if(e.getSource().equals(back_btn)){
            Staff_list.this.setVisible(false);
            Welcome back = new Welcome();
            back.setVisible(true);
        }
    }

}
