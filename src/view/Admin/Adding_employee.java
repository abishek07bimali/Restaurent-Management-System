package view.Admin;//package view.Admin;
import controller.AdminController;
import model.AdminModel;
import controller.EmployeeController;
import model.Employee_model;
import view.Welcome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Pattern;

public class Adding_employee extends JFrame implements ActionListener {

    // stating the element and objects
    JLabel crms_Logo, rectangle_dash, rectangle_menu, chef_icon,dash_icon;
    JLabel emp_name_label, ctz_no_label, dob_lbl,address_lbl, gender_lbl, marital_lbl, e_mail_lbl, phone_no_lbl, position_lbl, vaccinate_lbl,username;
    JTextField emp_name, citizinship_no, address1, e_mail, phone_no, position_txt,sal_amt,user_n;
    JPasswordField dob_txt;
    JCheckBox vaccinated,password;
    JComboBox gender;
    JComboBox marital_status;
    JButton dashboard, add_employee_btn, staffList, statistics, product,setting, logOut,save_btn,back_btn;
    AdminController adminController;
    AdminModel adminModel;

    public Adding_employee() {
        this.adminController= new AdminController();
        this.adminModel=adminController.fetchLoggedInAdmin();
        // initializing the GUI
        initialize_add_GUI();
        // initialize elements
        initialize_GUI_elements();

        handAction();    }

    public void initialize_add_GUI() {
        setTitle("Crescent RMS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(0, 0, 1280, 700);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);

        Image icon = Toolkit.getDefaultToolkit().getImage("public\\logo.png");
        setIconImage(icon);
        // Selecting color
        Color n = new Color(0x2E3337);
        getContentPane().setBackground(n);
    }

    public void initialize_GUI_elements() {


        dashboard_side();

        text_field_side();
        setVisible(true);

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

        JLabel staff_title = new JLabel("Add Staff");
        staff_title.setBounds(350,30,200,40);
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
        dashboard.setForeground(Color.white);
        dashboard.setFocusable(false);
        rectangle_dash.add(dashboard);

        add_employee_btn = new JButton("Add Staff");
        add_employee_btn.setBounds(85, 305, 140, 25);
        add_employee_btn.setFont(new Font("times", Font.PLAIN, 20));
        add_employee_btn.setBackground(Color.white);
//        add_employee_btn.setBorderPainted(false);
        add_employee_btn.setForeground(Color.pink);
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
        product.setBackground(b_c);
        product.setBorderPainted(false);
        product.setForeground(Color.white);
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

//        back_btn = new JButton(new ImageIcon("public\\backBtn (1).png"));
//        back_btn.setBounds(10, 5, 45, 45);
//        back_btn.setOpaque(false);
//        back_btn.setContentAreaFilled(false);
//        back_btn.setBorderPainted(false);
//        rectangle_dash.add(back_btn);


    }

    public void text_field_side() {
        // label for text field
        rectangle_menu = new JLabel(new ImageIcon("public\\chef_icon\\Rectangle_Employee_add.png"));
        rectangle_menu.setBounds(220, 170, 860, 520);
        add(rectangle_menu);

        // img icon to the frame
        chef_icon = new JLabel(new ImageIcon("public\\chef_icon\\malemale_pes_owner.png"));
        chef_icon.setBounds(340, 25, 800, 900);
        rectangle_menu.add(chef_icon);

        JLabel text_newEmployee = new JLabel("Add new Employee");
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

        gender_lbl = new JLabel("Gender");
        gender_lbl.setBounds(360, 120, 140, 40);
        gender_lbl.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(gender_lbl);

        address_lbl = new JLabel("Address");
        address_lbl.setBounds(65, 170, 140, 40);
        address_lbl.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(address_lbl);

        phone_no_lbl = new JLabel("Phone no.");
        phone_no_lbl.setBounds(360, 170, 140, 40);
        phone_no_lbl.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(phone_no_lbl);

        e_mail_lbl = new JLabel("E-Mail");
        e_mail_lbl.setBounds(65, 220, 140, 40);
        e_mail_lbl.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(e_mail_lbl);

        username = new JLabel("Username");
        username.setBounds(65, 270, 140, 40);
        username.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(username);

        dob_lbl = new JLabel("Password");
        dob_lbl.setBounds(370, 270, 140, 40);
        dob_lbl.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(dob_lbl);

        position_lbl = new JLabel("Position");
        position_lbl.setBounds(65, 320, 140, 40);
        position_lbl.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(position_lbl);


        marital_lbl = new JLabel("Marital status");
        marital_lbl.setBounds(65, 370, 140, 40);
        marital_lbl.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(marital_lbl);


        // Text Field
        emp_name = new JTextField("Employee name");
        emp_name.setBounds(170, 70, 320, 35);
        emp_name.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(emp_name.getText().equals("Employee name")){
                    emp_name.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(emp_name.getText().equals("")){
                    emp_name.setText("Employee name");
                }
            }
        });
        rectangle_menu.add(emp_name);

        citizinship_no = new JTextField("Citizenship no.");
        citizinship_no.setBounds(170, 120, 160, 35);
        citizinship_no.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(citizinship_no.getText().equals("Citizenship no.")){
                    citizinship_no.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(citizinship_no.getText().equals("")){
                    citizinship_no.setText("Citizenship no.");
                }
            }
        });
        rectangle_menu.add(citizinship_no);


        address1 = new JTextField("Address");
        address1.setBounds(170, 170, 160, 35);
        address1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(address1.getText().equals("Address")){
                    address1.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(address1.getText().equals("")){
                    address1.setText("Address");
                }
            }
        });
        rectangle_menu.add(address1);




        e_mail = new JTextField("E-mail");
        e_mail.setBounds(170, 220, 320, 35);
        e_mail.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(e_mail.getText().equals("E-mail")){
                    e_mail.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(e_mail.getText().equals("")){
                    e_mail.setText("E-mail");
                }
            }
        });
        rectangle_menu.add(e_mail);



        phone_no = new JTextField("Phone no.");
        phone_no.setBounds(450, 170, 160, 35);
        phone_no.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(phone_no.getText().equals("Phone no.")){
                    phone_no.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(phone_no.getText().equals("")){
                    phone_no.setText("Phone no.");
                }
            }
        });
        rectangle_menu.add(phone_no);


        user_n = new JTextField("Username");
        user_n.setBounds(170, 270, 160, 35);
        user_n.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(user_n.getText().equals("Username")){
                    user_n.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(user_n.getText().equals("")){
                    user_n.setText("Username");
                }
            }
        });
        rectangle_menu.add(user_n);




        dob_txt = new JPasswordField("Password");
        dob_txt.setBounds(460, 270, 160, 35);
        dob_txt.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(dob_txt.getText().equals("Password")){
                    dob_txt.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(dob_txt.getText().equals("")){
                    dob_txt.setText("Password");
                }
            }
        });
        rectangle_menu.add(dob_txt);


        password = new JCheckBox("Show");
        password.setForeground(Color.BLACK);
        password.setBounds(630, 270, 100, 25);
        password.setOpaque(false);
        rectangle_menu.add(password);

        position_txt = new JTextField("Position");
        position_txt.setBounds(170, 320, 160, 35);
        position_txt.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(position_txt.getText().equals("Position")){
                    position_txt.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(position_txt.getText().equals("")){
                    position_txt.setText("Position");
                }
            }
        });
        rectangle_menu.add(position_txt);

        // checkbox for menu
        vaccinated = new JCheckBox("Vaccinated");
        vaccinated.setBounds(370, 375, 200, 30);
        vaccinated.setBackground(Color.white);
        rectangle_menu.add(vaccinated);

        String g1[] = {"Gender", "Male", "Female", "Other"};
        String ms1[] = {"Status", "Married", "Not Married"};
        // Combo box
        gender = new JComboBox(g1);
        gender.setBounds(450, 130, 100, 20);
        rectangle_menu.add(gender);

        marital_status = new JComboBox(ms1);
        marital_status.setBounds(170, 380, 100, 20);
        rectangle_menu.add(marital_status);

        // Salary
        JLabel sal_lbl = new JLabel("Salary");
        sal_lbl.setBounds(370, 320, 140, 40);
        sal_lbl.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(sal_lbl);

        sal_amt = new JTextField("Salary");  // enter validation for entering number only
        sal_amt.setBounds(460, 320, 160, 30);
        sal_amt.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(sal_amt.getText().equals("Salary")){
                    sal_amt.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(sal_amt.getText().equals("")){
                    sal_amt.setText("Salary");
                }
            }
        });
        rectangle_menu.add(sal_amt);

        JLabel sal_lbl_note = new JLabel("* Rs. ");
        sal_lbl_note.setBounds(460, 340, 100, 40);
        sal_lbl_note.setFont(new Font("times", Font.ITALIC, 10));
        sal_lbl_note.setForeground(Color.GRAY);
        rectangle_menu.add(sal_lbl_note);

        // save button
        save_btn = new JButton(new ImageIcon("public\\chef_icon\\save_btn.png"));
        save_btn.setBounds(480, 420, 100, 40);
        save_btn.setBackground(Color.WHITE);
        save_btn.setBorderPainted(false);
        rectangle_menu.add(save_btn);
    }
    void handAction(){

        save_btn.addActionListener(this);
        password.addActionListener(this::checkboxActionerformed);
        dashboard.addActionListener(this);
        add_employee_btn.addActionListener(this);
        staffList.addActionListener(this);
        statistics.addActionListener(this);
        product.addActionListener(this);
        setting.addActionListener(this);
        logOut.addActionListener(this);
//        back_btn.addActionListener(this);


    }





    @Override
    public void actionPerformed(ActionEvent e) {


        String t1 = emp_name.getText();
        String t2 = citizinship_no.getText();
        String t4 = address1.getText();
        String t6 = e_mail.getText();
        String t5 = phone_no.getText();
        String t7 = dob_txt.getText();
        String t8 = position_txt.getText();
        String t9 = sal_amt.getText();
        String t3 = user_n.getText();

        String emailRegex = "[a-zA-Z]+[.]?[0-9]{0,6}[@]{1,2}[a-z]+[.]{1,2}[a-z]{2,4}";
        Pattern.compile(emailRegex);
        String phoneregex = "([0-9]{10})";
        Pattern.compile(phoneregex);

        if (e.getSource().equals(save_btn)) {
            if ((t1.isBlank() || t1.equals("Employee name")) && (t2.isBlank() || t2.equals("Citizenship no."))
                    && (t6.isBlank() || t6.equals("E-mail")) && (t7.isBlank() || t7.equals("Password")) &&
                    (t8.isBlank() || t8.equals("Position")) && (t4.isBlank() || t4.equals("Address")) &&
                    (t5.isBlank() || t5.equals("Phone no.")) && (t9.isBlank() || t9.equals("Salary")) &&
                    (t3.isBlank() || t3.equals("Username")) && (gender.getSelectedItem().equals("Gender")) &&
                    (marital_status.getSelectedItem().equals("Status"))) {

                JOptionPane.showMessageDialog(null, "Please Fill All \nThe Detail Below");
            } else if (t1.isBlank() || t1.equals("Employee name")) {
                JOptionPane.showMessageDialog(null, "Please Enter the Employee name");
            } else if (t2.isBlank() || t2.equals("Citizenship no.")) {
                JOptionPane.showMessageDialog(null, "Please Enter the Citizenship no.");
            } else if (t4.isBlank() || t4.equals("Address")) {
                JOptionPane.showMessageDialog(null, "Please Enter the Address");
            } else if (t6.isBlank() || t6.equals("E-mail")) {
                JOptionPane.showMessageDialog(null, "Please Enter the E-mail");
            } else if (!(t6.matches(emailRegex))) {
                JOptionPane.showMessageDialog(null, "Please enter your valid email");
            } else if (t5.isBlank() || t5.equals("Phone no.")) {
                JOptionPane.showMessageDialog(null, "Please Enter the Phone no.");
            } else if (!(t5.matches(phoneregex))) {
                JOptionPane.showMessageDialog(null, "Please enter valid no");
            } else if (t8.isBlank() || t8.equals("Position")) {
                JOptionPane.showMessageDialog(null, "Please Enter the Position");
            } else if (t3.isBlank() || t3.equals("Username")) {
                JOptionPane.showMessageDialog(null, "Please Enter the Username.");
            } else if (t7.isBlank() || t7.equals("Password")) {
                JOptionPane.showMessageDialog(null, "Please Enter the Password.");
            } else if (t9.isBlank() || t9.equals("Salary")) {
                JOptionPane.showMessageDialog(null, "Please Enter the Salary.");
            } else if (gender.getSelectedItem().equals("Gender")) {
                JOptionPane.showMessageDialog(null, "Please select gender.");
            } else if (marital_status.getSelectedItem().equals("Status")) {
                JOptionPane.showMessageDialog(null, "Please select marital Status.");
            } else {
                Employee_model employee_Model = new Employee_model(t1,t2, gender.getSelectedItem().toString(),t4,t6,t5,t3,t7,t8,t9, marital_status.getSelectedItem().toString());
                EmployeeController employeeController = new EmployeeController();
                int insert = employeeController.employeeRegistration(employee_Model);

                if (insert > 0) {
                    JOptionPane.showMessageDialog(null, "Your Employee account \nHas Been Registered!!");


                }


            }

        }


        if (e.getSource().equals(dashboard)) {
            Adding_employee.this.setVisible(false);
            Admin_dashboard adm = new Admin_dashboard();
            adm.setVisible(true);
        } else if (e.getSource().equals(add_employee_btn)) {

        } else if (e.getSource().equals(staffList)) {
            Adding_employee.this.setVisible(false);
            Staff_list staffList_btn = new Staff_list();
            staffList_btn.setVisible(true);
        } else if (e.getSource().equals(statistics)) {
            Adding_employee.this.setVisible(false);
            new Graphs().setVisible(true);
        } else if (e.getSource().equals(product)) {
            Adding_employee.this.setVisible(false);
            Product_Inventory product_btn = new Product_Inventory();
            product_btn.setVisible(true);

        }else if(e.getSource().equals(back_btn)){
            Adding_employee.this.setVisible(false);
            Welcome back = new Welcome();
            back.setVisible(true);
        }else if (e.getSource().equals(setting)) {
            Adding_employee.this.setVisible(false);
            Admin_setting ad_set = new Admin_setting(new AdminModel());
            ad_set.setVisible(true);
        } else if (e.getSource().equals(logOut)) {
            String[] options = {"Yes", "No"};
            int jk = JOptionPane.showOptionDialog(null, "Do You Want To Logout??",
                    "Yes or No", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            if (jk == 0) {
                Adding_employee.this.setVisible(false);
                Welcome well = new Welcome();
                well.setVisible(true);

            }


        }

    }

    public void checkboxActionerformed(java.awt.event.ActionEvent evt){

        if (password.isSelected()) {
            dob_txt.setEchoChar((char) 0);
        } else {

            dob_txt.setEchoChar('*');

        }
    }

}