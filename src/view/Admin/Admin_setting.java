package view.Admin;

import controller.AdminController;
import model.AdminModel;
import view.Welcome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.util.regex.Pattern;

public class Admin_setting extends JFrame implements ActionListener {
    // stating the element and objects
    JLabel crms_Logo, rectangle_dash, rectangle_menu, dash_icon;
    JLabel name_label, gender_lbl, e_mail_lbl, username_lbl, password_lbl,admin_pic,file_label;
    JCheckBox password;
    JTextField user_n;
    JPasswordField pass;
    JButton dashboard, add_employee_btn, staffList, statistics, setting, product, logOut, back_btn, update_btn,delete_btn;
    JButton prof_update, pic_up;
    private static JTextField fetchName, fetchEmail, fetchUsername;
    private static JComboBox fetchGender;
    private static JPasswordField fetchPassword;
    JFrame uChange_frame;
    AdminModel adminModel;
    AdminController adminController;
    String filename;

    public Admin_setting(AdminModel adminModel) {

        this.adminModel = adminModel;
        this.adminController = new AdminController();
        this.adminModel = adminController.fetchLoggedInAdmin();


        // initializing the GUI
        initialize_dash_GUI();
        // initialize elements
        initialize_GUI_elements();

    }

    public void initialize_dash_GUI() {
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

        // menu side
        dashboard_side();

        // admin dashboard contents
        dashboard_elements();

        // update pass frame
        update_password();

        handAction();

        fetchAdminData1();

    }

    public void dashboard_side() {

        // color selection for the button
        Color b_c = new Color(0x212429);

        // label for dashboard
        rectangle_dash = new JLabel(new ImageIcon("public\\chef_icon\\Rectangle 47.png"));
        rectangle_dash.setBounds(0, 0, 250, 900);
        add(rectangle_dash);

        JLabel staff_title = new JLabel("Setting / Edit Profile");
        staff_title.setBounds(330, 30, 320, 40);
        staff_title.setFont(new Font("forte", Font.PLAIN, 25));
        staff_title.setForeground(Color.PINK);
        add(staff_title);


        // employee dashboard icon for button
        dash_icon = new JLabel(new ImageIcon("public\\icons\\profile.png"));
        dash_icon.setBounds(40, 250, 40, 40);
        rectangle_dash.add(dash_icon);

        dash_icon = new JLabel(new ImageIcon("public\\icon\\profile.png"));
        dash_icon.setBounds(40, 300, 40, 40);
        rectangle_dash.add(dash_icon);

        dash_icon = new JLabel(new ImageIcon("public\\icons\\staff_list.png"));
        dash_icon.setBounds(40, 350, 40, 40);
        rectangle_dash.add(dash_icon);

        dash_icon = new JLabel(new ImageIcon("public\\icons\\stat.png"));
        dash_icon.setBounds(40, 400, 40, 40);
        rectangle_dash.add(dash_icon);

        dash_icon = new JLabel(new ImageIcon("public\\icons\\product_list.png"));
        dash_icon.setBounds(40, 450, 40, 40);
        rectangle_dash.add(dash_icon);

        dash_icon = new JLabel(new ImageIcon("public\\icons\\settings.png"));
        dash_icon.setBounds(40, 500, 40, 40);
        rectangle_dash.add(dash_icon);

        dash_icon = new JLabel(new ImageIcon("public\\icons\\logout.png"));
        dash_icon.setBounds(40, 550, 40, 40);
        rectangle_dash.add(dash_icon);


        // adding logo to the dashboard label
        crms_Logo = new JLabel(new ImageIcon("public\\chef_icon\\Crescent_RMS_logo1.png"));
        crms_Logo.setBounds(20, 30, 200, 200);
        rectangle_dash.add(crms_Logo);


        // button for dashboard
        dashboard = new JButton("Dashboard");
        dashboard.setBounds(85, 250, 140, 30);
        dashboard.setFont(new Font("times", Font.PLAIN, 20));
        dashboard.setBackground(b_c);
//        dashboard.setBorderPainted(false);
        dashboard.setForeground(Color.white);
        dashboard.setFocusable(false);
        dashboard.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rectangle_dash.add(dashboard);

        add_employee_btn = new JButton("Add Staff");
        add_employee_btn.setBounds(85, 300, 140, 25);
        add_employee_btn.setFont(new Font("times", Font.PLAIN, 20));
        add_employee_btn.setBackground(b_c);
        add_employee_btn.setBorderPainted(false);
        add_employee_btn.setForeground(Color.white);
        add_employee_btn.setFocusable(false);
        add_employee_btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rectangle_dash.add(add_employee_btn);

        staffList = new JButton("Staff List");
        staffList.setBounds(85, 350, 140, 25);
        staffList.setFont(new Font("times", Font.PLAIN, 20));
        staffList.setBackground(b_c);
        staffList.setBorderPainted(false);
        staffList.setForeground(Color.white);
        staffList.setFocusable(false);
        staffList.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rectangle_dash.add(staffList);

        statistics = new JButton("Statistics");
        statistics.setBounds(85, 400, 140, 25);
        statistics.setFont(new Font("times", Font.PLAIN, 20));
        statistics.setBackground(b_c);
        statistics.setBorderPainted(false);
        statistics.setForeground(Color.white);
        statistics.setFocusable(false);
        statistics.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rectangle_dash.add(statistics);

        product = new JButton("Products");
        product.setBounds(85, 450, 140, 25);
        product.setFont(new Font("times", Font.PLAIN, 20));
        product.setBackground(b_c);
        product.setBorderPainted(false);
        product.setForeground(Color.white);
        product.setFocusable(false);
        product.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rectangle_dash.add(product);

        setting = new JButton("Settings");
        setting.setBounds(85, 500, 160, 25);
        setting.setFont(new Font("times", Font.PLAIN, 20));
        setting.setBackground(Color.white);
        setting.setBorderPainted(false);
        setting.setForeground(Color.pink);
        setting.setFocusable(false);
        setting.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rectangle_dash.add(setting);

        logOut = new JButton("Log Out");
        logOut.setBounds(85, 550, 140, 25);
        logOut.setFont(new Font("times", Font.PLAIN, 20));
        logOut.setBackground(b_c);
        logOut.setBorderPainted(false);
        logOut.setForeground(Color.white);
        logOut.setFocusable(false);
        logOut.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rectangle_dash.add(logOut);

//        back_btn = new JButton(new ImageIcon("public\\backBtn (1).png"));
//        back_btn.setBounds(10, 5, 45, 45);
//        back_btn.setOpaque(false);
//        back_btn.setContentAreaFilled(false);
//        back_btn.setBorderPainted(false);
//        back_btn.setForeground(Color.white);
//        back_btn.setFocusable(false);
//        rectangle_dash.add(back_btn);

    }

    public void update_password() {
        uChange_frame = new JFrame();
        uChange_frame.setBounds(280, 180, 500, 400);
        uChange_frame.setBackground(new Color(0x434748));


//        JButton open_frame = new JButton("Add Product");
//        open_frame.setBounds(800,185,180,40);
//        open_frame.setBackground(new Color(0xD5CDF7));
//        add(open_frame);


        user_n = new JTextField("Username");
        user_n.setBounds(120, 120, 160, 35);
        user_n.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (user_n.getText().equals("Username")) {
                    user_n.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (user_n.getText().equals("")) {
                    user_n.setText("Username");
                }
            }
        });
        uChange_frame.add(user_n);

        pass = new JPasswordField("Password");
        pass.setBounds(120, 170, 160, 35);
        pass.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (pass.getText().equals("Password")) {
                    pass.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (pass.getText().equals("")) {
                    pass.setText("Password");
                }
            }
        });
        uChange_frame.add(pass);

        password = new JCheckBox("Show");
        password.setForeground(Color.BLACK);
        password.setBounds(320, 350, 100, 25);
        password.setOpaque(false);
        uChange_frame.add(password);

    }

    //      Action to set show password to *******
    public void checkboxActionerformed(java.awt.event.ActionEvent evt) {

        if (password.isSelected()) {
            pass.setEchoChar((char) 0);
        } else {

            pass.setEchoChar('*');

        }

    }

    public void dashboard_elements() {

        // profile side
        JLabel admin_pic_label = new JLabel(new ImageIcon("public\\chef_icon\\Rectangle_Employee_add.png"));
        admin_pic_label.setBounds(280, 200, 250, 440);
        add(admin_pic_label);

        // admin pic
        admin_pic = new JLabel(new ImageIcon(adminModel.getPic_address()));
        admin_pic.setBounds(20, 10, 200, 200);
        admin_pic_label.add(admin_pic);
        // button for dashboard
        prof_update = new JButton("Change Profile pic");
        prof_update.setBounds(25, 240, 160, 40);
        prof_update.setFont(new Font("times", Font.BOLD, 13));
        prof_update.setBackground(new Color(0xD5CDF7));
        prof_update.setBorderPainted(false);
        prof_update.setForeground(Color.black);
        prof_update.setFocusable(false);
        prof_update.setCursor(new Cursor(Cursor.HAND_CURSOR));
        admin_pic_label.add(prof_update);



        pic_up = new JButton("Update");
        pic_up.setBounds(25, 290, 160, 40);
        pic_up.setFont(new Font("times", Font.BOLD, 13));
        pic_up.setBackground(new Color(0xD5CDF7));
        pic_up.setBorderPainted(false);
        pic_up.setForeground(Color.black);
        pic_up.setFocusable(false);
        pic_up.setCursor(new Cursor(Cursor.HAND_CURSOR));
        admin_pic_label.add(pic_up);

        // small profile icon
        JLabel small_profile = new JLabel(new ImageIcon("public\\chef_icon\\Small_profile.png"));
        small_profile.setBounds(900, 10, 50, 50);
        add(small_profile);

        JLabel small_admin_title = new JLabel(adminModel.getFullName());
        small_admin_title.setBounds(950, 10, 140, 40);
        small_admin_title.setFont(new Font("times", Font.BOLD, 13));
        small_admin_title.setForeground(Color.white);
        add(small_admin_title);


        // Background for the data
        rectangle_menu = new JLabel(new ImageIcon("public\\chef_icon\\Rectangle_Employee_add.png"));
        rectangle_menu.setBounds(600, 240, 570, 400);
        add(rectangle_menu);

        // label to the frame
        name_label = new JLabel("Name");
        name_label.setBounds(34, 50, 140, 40);
        name_label.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(name_label);

        e_mail_lbl = new JLabel("E-Mail");
        e_mail_lbl.setBounds(34, 150, 140, 40);
        e_mail_lbl.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(e_mail_lbl);

        username_lbl = new JLabel("Username :");
        username_lbl.setBounds(34, 200, 140, 40);
        username_lbl.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(username_lbl);

        password_lbl = new JLabel("Password : ");
        password_lbl.setBounds(34, 250, 140, 40);
        password_lbl.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(password_lbl);

        update_btn = new JButton("Update");
        update_btn.setBounds(100, 320, 120, 40);
        update_btn.setFont(new Font("times", Font.BOLD, 15));
        update_btn.setBackground(new Color(0xD5CDF7));
//        update_btn.setBorderPainted(false);
        update_btn.setForeground(Color.black);
        update_btn.setFocusable(false);
        update_btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rectangle_menu.add(update_btn);

        delete_btn = new JButton("DeleteYourID");
        delete_btn.setBounds(370, 320, 180, 40);
        delete_btn.setFont(new Font("times", Font.BOLD, 15));
        delete_btn.setBackground(new Color(0xD5CDF7));
//        update_btn.setBorderPainted(false);
        delete_btn.setForeground(Color.black);
        delete_btn.setFocusable(false);
        delete_btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rectangle_menu.add(delete_btn);

    }

    public void fetchAdminData1() {
        gender_lbl = new JLabel("Gender");
        gender_lbl.setBounds(34, 100, 140, 40);
        gender_lbl.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(gender_lbl);

        fetchName = new JTextField(adminModel.getFullName());
        fetchName.setBounds(120, 50, 180, 35);
        rectangle_menu.add(fetchName);

        if (adminModel.getGender().equals("Male")) {
            String g1[] = {adminModel.getGender(), "Female", "Other"};
            fetchGender = new JComboBox(g1);
            fetchGender.setBounds(120, 110, 100, 20);
            rectangle_menu.add(fetchGender);
        } else if (adminModel.getGender().equals("Female")) {
            String g1[] = {adminModel.getGender(), "Male", "Other"};
            fetchGender = new JComboBox(g1);
            fetchGender.setBounds(120, 110, 100, 20);
            rectangle_menu.add(fetchGender);
        } else {
            String g1[] = {adminModel.getGender(), "Male", "Female"};
            fetchGender = new JComboBox(g1);
            fetchGender.setBounds(120, 110, 100, 20);
            rectangle_menu.add(fetchGender);
        }

        fetchEmail = new JTextField(adminModel.getEmail());
        fetchEmail.setBounds(120, 150, 180, 35);
        rectangle_menu.add(fetchEmail);

        fetchUsername = new JTextField(adminModel.getUsername());
        fetchUsername.setBounds(120, 200, 140, 40);
        fetchUsername.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(fetchUsername);

        fetchPassword = new JPasswordField(adminModel.getPassword());
        fetchPassword.setBounds(120, 250, 140, 40);
        fetchPassword.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(fetchPassword);

    }


    void handAction() {
        dashboard.addActionListener(this);
        password.addActionListener(this::checkboxActionerformed);
        add_employee_btn.addActionListener(this);
        staffList.addActionListener(this);
        statistics.addActionListener(this);
        setting.addActionListener(this);
        product.addActionListener(this);
        logOut.addActionListener(this);
        update_btn.addActionListener(this);
        delete_btn.addActionListener(this::deleteAction);
        update_btn.addActionListener(this::updateAction);
        prof_update.addActionListener(this::changePicture);
        pic_up.addActionListener(this::insertPic);


    }
    public void deleteAction(ActionEvent e) {
        if (e.getSource().equals(delete_btn)) {
            int dialogButton = JOptionPane.showConfirmDialog(null,
                    "Are U Sure You Want To \n Delete Your Account?",
                    "Delete Account!!", JOptionPane.YES_NO_OPTION);
            try {
                if (dialogButton == JOptionPane.YES_OPTION) {
                    int stat = adminController.deleteAdmin(AdminLoginForm.USER_ID);
                    if(stat>0){
                        JOptionPane.showMessageDialog(null,"Your Account Has Been \nDeleted Successfully");
                        dispose();
                        new AdminLoginForm().setVisible(true);
                    }

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }}


    public void insertPic(ActionEvent e){
        try {
            String file = file_label.getText();
            if (e.getSource().equals(pic_up)) {
                if (file == null) {
                } else if (file == "") {
                    JOptionPane.showMessageDialog(null, "Please choose the picture First");
                } else {
                    AdminController adminController = new AdminController();
                    AdminModel adminModel1 = new AdminModel(adminModel.getAdminId(), file);
                    int insert = adminController.Picture(adminModel1);
                    if (insert > 0) {
                        JOptionPane.showMessageDialog(null, "Successfully updated");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to update");
                    }
                }

            }
        }
        catch (Exception evt) {

        }
    }

        public void updateAction(ActionEvent e) {
            String fname = fetchName.getText();
            String fgender;
            if (fetchGender.getSelectedItem().equals("Male")) {
                fgender = "Male";

            } else if (fetchGender.getSelectedItem().equals("Female")) {
                fgender = "Female";

            } else {
                fgender = "Other";

            }
            String femail = fetchEmail.getText();
            String fusername = fetchUsername.getText();
            String fpassword = fetchPassword.getText();

            String emailRegex = "[a-zA-Z]+[.]?[0-9]{0,6}[@]{1,2}[a-z]+[.]{1,2}[a-z]{2,4}";
            Pattern.compile(emailRegex);
            String phoneregex = "([0-9]{10})";
            Pattern.compile(phoneregex);




            if (e.getSource().equals(update_btn)) {
                if ((fname.isBlank() || fname.equals(adminModel.getFullName())) && (femail.isBlank() || femail.equals(adminModel.getEmail())) &&
                        (fusername.isBlank() || fetchUsername.equals(adminModel.getUsername()))) {
                    JOptionPane.showMessageDialog(null, "You Haven't Change Anything");
                } else {

                    AdminController adminController = new AdminController();
                    AdminModel adminModel1 = new AdminModel(adminModel.getAdminId(), fname, fgender, femail, fusername, fpassword);
                    int update = adminController.updateAdminProfile(adminModel1);
                    if (update > 0) {
                        JOptionPane.showMessageDialog(null, "Successfully updated");
                        dispose();
                        new Admin_dashboard().setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to update");
                    }
                }
            }
        }

    public void changePicture(ActionEvent e) {
        try {
            file_label = new JLabel();
            JFileChooser choose = new JFileChooser();
            choose.showOpenDialog(null);
            File f = choose.getSelectedFile();
            filename = f.getAbsolutePath();
            file_label.setText(filename);
            ImageIcon icon = new ImageIcon(filename);
            Image image = icon.getImage().getScaledInstance(admin_pic.getWidth(), admin_pic.getHeight(), Image.SCALE_SMOOTH);
            admin_pic.setIcon(icon);

        }
        catch (Exception evt){

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

            if (e.getSource().equals(dashboard)) {
                Admin_setting.this.setVisible(false);
                Admin_dashboard dash_btn = new Admin_dashboard();
                dash_btn.setVisible(true);
            } else if (e.getSource().equals(add_employee_btn)) {
                Admin_setting.this.setVisible(false);
                Adding_employee add_btn = new Adding_employee();
                add_btn.setVisible(true);
            } else if (e.getSource().equals(staffList)) {
                Admin_setting.this.setVisible(false);
                Staff_list staffList_btn = new Staff_list();
                staffList_btn.setVisible(true);
            } else if (e.getSource().equals(statistics)) {
                Admin_setting.this.setVisible(false);
                new Graphs().setVisible(true);
            } else if (e.getSource().equals(product)) {
                Admin_setting.this.setVisible(false);
                Product_Inventory product_btn = new Product_Inventory();
                product_btn.setVisible(true);
            } else if (e.getSource().equals(setting)) {

            } else if (e.getSource().equals(back_btn)) {
                Admin_setting.this.setVisible(false);
                Welcome back = new Welcome();
                back.setVisible(true);
            } else if (e.getSource().equals(logOut)) {
                String[] options = {"Yes", "No"};
                int jk = JOptionPane.showOptionDialog(null, "Do You Want To Logout??",
                        "Yes or No", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                if (jk == 0) {
                    Admin_setting.this.setVisible(false);
                    Welcome well = new Welcome();
                    well.setVisible(true);
                }
            }
        }
    }
