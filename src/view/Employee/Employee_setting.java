package view.Employee;

import controller.EmployeeController;
import model.Employee_model;
import view.Welcome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.regex.Pattern;

public class Employee_setting extends JFrame implements ActionListener {
    // stating the element and objects
    JLabel crms_Logo,rectangle_dash,rectangle_menu,chef_icon,dash_icon;
    JLabel name_label,ctz_no_label,address_lbl,gender_lbl,e_mail_lbl,phone_no_lbl,username_lbl,password_lbl;
    JLabel employee_pic;
    JLabel filelabel;
    JPasswordField pass;
    JCheckBox password;
    JComboBox gender,marital_status;
    JTextField emp_name, citizinship_no, address1, e_mail, phone_no,user_n;
    JButton dashboard,order_history,setting_emp,logOut,update_btn,prof_update,pic_up;
    String filename;

    Employee_model employeeModel;
    EmployeeController employeeController;

    public Employee_setting(){
        this.employeeController=new EmployeeController();
        this.employeeModel= employeeController.fetchLoggedInEmployee();




        // initializing the GUI
        initialize_dash_GUI();
        // initialize elements
        initialize_GUI_elements();
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
    }

    public void initialize_GUI_elements(){

        // menu side
        dashboard_side();

        // admin dashboard contents
        dashboard_elements();
        handAction();
        Employeedata();


        Image icon = Toolkit.getDefaultToolkit().getImage("public\\logo.png");
        setIconImage(icon);
        setVisible(true);
    }


    public void dashboard_side(){

        // color selection for the button
        Color b_c = new Color(0x212429);

        // label for dashboard
        rectangle_dash = new JLabel(new ImageIcon("public\\chef_icon\\Rectangle 47.png"));
        rectangle_dash.setBounds(0,0,250,900);
        add(rectangle_dash);

        JLabel staff_title = new JLabel("Setting / Edit Profile");
        staff_title.setBounds(330,30,320,40);
        staff_title.setFont(new Font("forte",Font.PLAIN,25));
        staff_title.setForeground(Color.PINK);
        add(staff_title);


        // employee dashboard icon for button
        // icon for buttons
        dash_icon = new JLabel(new ImageIcon("public\\icons\\profile.png"));
        dash_icon.setBounds(40,250,40,40);
        rectangle_dash.add(dash_icon);

        dash_icon = new JLabel(new ImageIcon("public\\icons\\order.png"));
        dash_icon.setBounds(40,300,40,40);
        rectangle_dash.add(dash_icon);

        dash_icon = new JLabel(new ImageIcon("public\\icons\\settings.png"));
        dash_icon.setBounds(40,350,40,40);
        rectangle_dash.add(dash_icon);

        dash_icon = new JLabel(new ImageIcon("public\\icons\\logout.png"));
        dash_icon.setBounds(40,400,40,40);
        rectangle_dash.add(dash_icon);



        // adding logo to the dashboard label
        crms_Logo = new JLabel(new ImageIcon("public\\chef_icon\\Crescent_RMS_logo1.png"));
        crms_Logo.setBounds(20,30,200,200);
        rectangle_dash.add(crms_Logo);

        // button for dashboard
        dashboard = new JButton("Dashboard");
        dashboard.setBounds(85, 250, 140,25);
        dashboard.setFont(new Font("times",Font.PLAIN,20));
        dashboard.setBackground(b_c);
//        dashboard.setBorderPainted(false);
        dashboard.setForeground(Color.white);
        dashboard.setFocusable(false);
        dashboard.setCursor(new Cursor(Cursor. HAND_CURSOR));
        rectangle_dash.add(dashboard);


        order_history = new JButton("Orders");
        order_history.setBounds(85, 305, 140,25);
        order_history.setFont(new Font("times",Font.PLAIN,20));
        order_history.setBackground(b_c);
        order_history.setBorderPainted(false);
        order_history.setForeground(Color.white);
        order_history.setFocusable(false);
        order_history.setCursor(new Cursor(Cursor. HAND_CURSOR));
        rectangle_dash.add(order_history);

        setting_emp = new JButton("Setting");
        setting_emp.setBounds(85, 355, 160,25);
        setting_emp.setFont(new Font("times",Font.PLAIN,20));
        setting_emp.setBackground(Color.white);
        setting_emp.setBorderPainted(false);
        setting_emp.setForeground(Color.pink);
        setting_emp.setFocusable(false);
        setting_emp.setCursor(new Cursor(Cursor. HAND_CURSOR));
        rectangle_dash.add(setting_emp);


        logOut = new JButton("Log Out");
        logOut.setBounds(85, 405, 140,25);
        logOut.setFont(new Font("times",Font.PLAIN,20));
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
//        back_btn.setForeground(Color.white);
//        back_btn.setFocusable(false);
//        rectangle_dash.add(back_btn);

    }

    public void dashboard_elements() {

        // profile side
        JLabel admin_pic_label = new JLabel(new ImageIcon("public\\chef_icon\\Rectangle_Employee_add.png"));
        admin_pic_label.setBounds(280, 200, 250, 440);
        add(admin_pic_label);

        // emp pic
        employee_pic = new JLabel(new ImageIcon(employeeModel.getPicture()));
        employee_pic.setBounds(20, 10, 200, 200);
        admin_pic_label.add(employee_pic);

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
        // code for database to update pic

//        username_lbl = new JLabel("Username :");
//        username_lbl.setBounds(5, 180, 140, 40);
//        username_lbl.setFont(new Font("times", Font.BOLD, 13));
//        admin_pic_label.add(username_lbl);
//
//        password_lbl = new JLabel("Password : ");
//        password_lbl.setBounds(5, 260, 140, 40);
//        password_lbl.setFont(new Font("times", Font.BOLD, 13));
//        admin_pic_label.add(password_lbl);


        // small profile icon
        JLabel small_profile = new JLabel(new ImageIcon("public\\chef_icon\\Small_profile.png"));
        small_profile.setBounds(900, 10, 50, 50);
        add(small_profile);

        JLabel small_admin_title = new JLabel(employeeModel.getName());
        small_admin_title.setBounds(950, 10, 140, 40);
        small_admin_title.setFont(new Font("times", Font.BOLD, 13));
        small_admin_title.setForeground(Color.white);
        add(small_admin_title);


        // Background for the data
        rectangle_menu = new JLabel(new ImageIcon("public\\chef_icon\\Rectangle_Employee_add.png"));
        rectangle_menu.setBounds(600, 180, 520, 460);
        add(rectangle_menu);

        // label to the frame
        name_label = new JLabel("Name");
        name_label.setBounds(34, 50, 140, 40);
        name_label.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(name_label);

        ctz_no_label = new JLabel("Citizenship");
        ctz_no_label.setBounds(34, 100, 140, 40);
        ctz_no_label.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(ctz_no_label);


        address_lbl = new JLabel("Address");
        address_lbl.setBounds(34, 150, 140, 40);
        address_lbl.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(address_lbl);

        e_mail_lbl = new JLabel("E-Mail");
        e_mail_lbl.setBounds(34, 200, 140, 40);
        e_mail_lbl.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(e_mail_lbl);

//        JLabel marital_lbl = new JLabel("Marital status");
//        marital_lbl.setBounds(300, 150, 140, 40);
//        marital_lbl.setFont(new Font("times", Font.BOLD, 13));
//        rectangle_menu.add(marital_lbl);
//
//        String ms1[] = {"Status", "Married", "Not Married"};
//        marital_status = new JComboBox(ms1);
//        marital_status.setBounds(390, 160, 100, 20);
//        rectangle_menu.add(marital_status);

        phone_no_lbl = new JLabel("Phone No.");
        phone_no_lbl.setBounds(34, 250, 140, 40);
        phone_no_lbl.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(phone_no_lbl);

        username_lbl = new JLabel("Username :");
        username_lbl.setBounds(34, 300, 140, 40);
        username_lbl.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(username_lbl);
        password_lbl = new JLabel("Password : ");
        password_lbl.setBounds(34, 350, 140, 40);
        password_lbl.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(password_lbl);
//        JLabel confirm_password_lbl = new JLabel("Password : ");
//        confirm_password_lbl.setBounds(370, 370, 140, 40);
//        confirm_password_lbl.setFont(new Font("times", Font.BOLD, 13));
//        rectangle_menu.add(confirm_password_lbl);

        update_btn = new JButton("Update");
        update_btn.setBounds(370, 400, 120, 40);
        update_btn.setFont(new Font("times", Font.BOLD, 15));
        update_btn.setBackground(new Color(0xD5CDF7));
//        update_btn.setBorderPainted(false);
        update_btn.setForeground(Color.black);
        update_btn.setFocusable(false);
        update_btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rectangle_menu.add(update_btn);

        password = new JCheckBox("Show");
        password.setForeground(Color.BLACK);
        password.setBounds(330, 350, 100, 25);
        password.setOpaque(false);
        rectangle_menu.add(password);

    }


    public void Employeedata(){
        // Text Field
        emp_name = new JTextField(employeeModel.getName());
        emp_name.setBounds(120, 50, 320, 35);
        rectangle_menu.add(emp_name);

        citizinship_no = new JTextField(employeeModel.getCitizen_no());
        citizinship_no.setBounds(120, 100, 160, 35);
        rectangle_menu.add(citizinship_no);


        address1 = new JTextField(employeeModel.getAddress());
        address1.setBounds(120, 150, 160, 35);
        rectangle_menu.add(address1);

        e_mail = new JTextField(employeeModel.getMail());
        e_mail.setBounds(120, 200, 160, 35);
        rectangle_menu.add(e_mail);



        phone_no = new JTextField(employeeModel.getPhone());
        phone_no.setBounds(120, 250, 160, 35);
        rectangle_menu.add(phone_no);


        user_n = new JTextField(employeeModel.getUsername());
        user_n.setBounds(120, 300, 160, 35);
        rectangle_menu.add(user_n);

        pass = new JPasswordField(employeeModel.getPassword());
        pass.setBounds(120, 350, 160, 35);
        rectangle_menu.add(pass);


    }

    public void checkboxActionPerformed(java.awt.event.ActionEvent evt){

        if (password.isSelected()) {
            pass.setEchoChar((char) 0);
        } else {

            pass.setEchoChar('*');

        }
    }


    public void insertPic(ActionEvent e){
        String file=filelabel.getText();
        if(e.getSource().equals(pic_up)){
            if(file==null){
            }
            else if(file==""){
                JOptionPane.showMessageDialog(null, "Please choose the picture First");
            }
            else{
                EmployeeController employeeController = new EmployeeController();
                Employee_model employee_model1 = new Employee_model(employeeModel.getId(),file);
                int insert = employeeController.Picture(employee_model1);
                if (insert > 0) {
                    JOptionPane.showMessageDialog(null, "Successfully updated");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to update");
                }
            }

        }

    }

    public void changePicture(ActionEvent e) {
        try {
            filelabel = new JLabel();
            JFileChooser choose = new JFileChooser();
            choose.showOpenDialog(null);
            File f = choose.getSelectedFile();
            filename = f.getAbsolutePath();
            filelabel.setText(filename);
            ImageIcon icon = new ImageIcon(filename);
            Image image = icon.getImage().getScaledInstance(employee_pic.getWidth(), employee_pic.getHeight(), Image.SCALE_SMOOTH);
            employee_pic.setIcon(icon);

        }
        catch (Exception evt){

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        String name = emp_name.getText();
        String citizen = citizinship_no.getText();
        String address = address1.getText();
        String mail = e_mail.getText();
        String phone = phone_no.getText();
        String password = pass.getText();
        String username = user_n.getText();

        String emailRegex = "[a-zA-Z]+[.]?[0-9]{0,6}[@]{1,2}[a-z]+[.]{1,2}[a-z]{2,4}";
        Pattern.compile(emailRegex);
        String phoneregex = "([0-9]{10})";
        Pattern.compile(phoneregex);


        if (e.getSource().equals(update_btn)) {
            if ((name.isBlank() || name.equals(employeeModel.getName())) && (citizen.isBlank() || citizen.equals(employeeModel.getCitizen_no()))
                    && (phone.isBlank() || phone.equals(employeeModel.getPhone())) && (password.isBlank() || password.equals(employeeModel.getPassword())) &&
                    (address.isBlank() || address.equals(employeeModel.getAddress())) &&
                    (mail.isBlank() || mail.equals(employeeModel.getMail())) && (username.isBlank() || username.equals(employeeModel.getUsername()))) {
                JOptionPane.showMessageDialog(null, "Make Some changes first!!");
            } else {
                EmployeeController employeeController = new EmployeeController();
                Employee_model employee_model = new Employee_model(employeeModel.getId(), name, citizen, address, mail, phone, username, password);
                int update = employeeController.updateEmployee(employee_model);
                if (update > 0) {
                    JOptionPane.showMessageDialog(null, "Successfully updated");
                    dispose();
                    new Employee_Dashboard().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to update");
                }
            }
        }

        if (e.getSource().equals(dashboard)){
            Employee_setting.this.setVisible(false);
            Employee_Dashboard dash_emp = new Employee_Dashboard ();
            dash_emp.setVisible(true);

        }
        else if (e.getSource().equals(order_history)){
            Employee_setting.this.setVisible(false);
            EmployeeWork orders = new EmployeeWork();
            orders.setVisible(true);
//            JOptionPane.showMessageDialog(null,"Order history In Development Process");
        }
        else if (e.getSource().equals(setting_emp)){
        }
        else if (e.getSource().equals(logOut)){
            String[] options = {"Yes", "No"};
            int jk = JOptionPane.showOptionDialog(null,"Do You Want To Logout??",
                    "Yes or No",JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null,options,options[0]);

            if(jk == 0){
                Employee_setting.this.setVisible(false);
                Welcome well = new Welcome();
                well.setVisible(true);
            }



        }

    }

    void handAction(){
        dashboard.addActionListener(this);
        order_history.addActionListener(this);
        setting_emp.addActionListener(this);
        password.addActionListener(this::checkboxActionPerformed);
        update_btn.addActionListener(this);
        logOut.addActionListener(this);
        prof_update.addActionListener(this::changePicture);
        pic_up.addActionListener(this::insertPic);
//        back_btn.addActionListener(this);
    }
}


