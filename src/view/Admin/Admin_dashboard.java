package view.Admin;

import controller.AdminController;
import database.Dbconnection;
import model.AdminModel;
import view.Welcome;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin_dashboard extends JFrame implements ActionListener {
    // stating the element and objects
    JLabel crms_Logo,rectangle_dash,rectangle_menu,chef_icon,dash_icon;
    JLabel name_label,ctz_no_label,address_lbl,phone_no_lbl,password_lbl;
    //    JTextField emp_name,citizinship_no,address,e_mail,phone_no,position_txt,dob_txt;
    private JLabel fullname_lbl,gender_lbl,e_mail_lbl,username_lbl;
    JCheckBox vaccinated;
    JComboBox gender,marital_status;
    JButton dashboard,add_employee_btn,staffList,statistics,setting,product,logOut,back_btn;

    AdminController adminController;
    AdminModel adminModel;
    Dbconnection db;

    public Admin_dashboard(){
        this.adminController= new AdminController();
        this.adminModel=adminController.fetchLoggedInAdmin();
        // initializing the GUI
        initialize_dash_GUI();
        // initialize elements
        initialize_GUI_elements();
    }

    public void initialize_dash_GUI(){
        setTitle("Crescent RMS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(150,50,1280,700);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);

        Image icon = Toolkit.getDefaultToolkit().getImage("public\\logo.png");
        setIconImage(icon);
        // Selecting color
        Color n = new Color(0x2E3337);
        getContentPane().setBackground(n);
    }

    public void initialize_GUI_elements(){

//      menu side
        dashboard_side();

//      admin dashboard contents
        dashboard_elements();

        //      calling method admin-data
        adminData();

        handAction();



    }
    public void dashboard_side(){

        // color selection for the button
        Color b_c = new Color(0x212429);

        // label for dashboard
        rectangle_dash = new JLabel(new ImageIcon("public\\chef_icon\\Rectangle 47.png"));
        rectangle_dash.setBounds(0,0,250,900);
        add(rectangle_dash);

        JLabel staff_title = new JLabel("Dashboard");
        staff_title.setBounds(350,30,200,40);
        staff_title.setFont(new Font("forte",Font.PLAIN,25));
        staff_title.setForeground(Color.PINK);
        add(staff_title);


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
        dashboard.setBounds(85, 250, 160,30);
        dashboard.setFont(new Font("times",Font.PLAIN,20));
        dashboard.setBackground(Color.WHITE);
//        dashboard.setBorderPainted(false);
        dashboard.setForeground(Color.PINK);
        dashboard.setFocusable(false);
        dashboard.setCursor(new Cursor(Cursor. HAND_CURSOR));
        rectangle_dash.add(dashboard);

        add_employee_btn = new JButton("Add Staff");
        add_employee_btn.setBounds(85, 300, 140,25);
        add_employee_btn.setFont(new Font("times",Font.PLAIN,20));
        add_employee_btn.setBackground(b_c);
        add_employee_btn.setBorderPainted(false);
        add_employee_btn.setForeground(Color.white);
        add_employee_btn.setFocusable(false);
        add_employee_btn.setCursor(new Cursor(Cursor. HAND_CURSOR));
        rectangle_dash.add(add_employee_btn);

        staffList = new JButton("Staff List");
        staffList.setBounds(85, 350, 130,25);
        staffList.setFont(new Font("times",Font.PLAIN,20));
        staffList.setBackground(b_c);
        staffList.setBorderPainted(false);
        staffList.setForeground(Color.white);
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

    public void dashboard_elements(){


        // profile side
        JLabel admin_pic_label = new JLabel(new ImageIcon("public\\chef_icon\\Rectangle_Employee_add.png"));
        admin_pic_label.setBounds(280,200,250,440);
        add(admin_pic_label);

        // emp pic
        JLabel admin_pic= new JLabel(new ImageIcon(adminModel.getPic_address()));
        admin_pic.setBounds(20,40,200,200);
        admin_pic_label.add(admin_pic);


        // small profile icon
        JLabel small_profile = new JLabel(new ImageIcon("public\\chef_icon\\Small_profile.png"));
        small_profile.setBounds(900,10,50,50);
        add(small_profile);

        JLabel small_admin_title = new JLabel(adminModel.getFullName());
        small_admin_title.setBounds(950, 10, 140,40);
        small_admin_title.setFont(new Font("times",Font.BOLD,15));
        small_admin_title.setForeground(Color.WHITE);
        add(small_admin_title);




        // Background for the data
        rectangle_menu = new JLabel(new ImageIcon("public\\chef_icon\\Rectangle_Employee_add.png"));
        rectangle_menu.setBounds(600,280,560,360);
        add(rectangle_menu);

        // label to the frame
        name_label = new JLabel("Name");
        name_label.setBounds(65, 70, 140,40);
        name_label.setFont(new Font("times",Font.BOLD,13));
        rectangle_menu.add(name_label);


        gender_lbl = new JLabel("Gender");
        gender_lbl.setBounds(65, 120, 140, 40);
        gender_lbl.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(gender_lbl);


        e_mail_lbl = new JLabel("E-Mail");
        e_mail_lbl.setBounds(65, 170, 140, 40);
        e_mail_lbl.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(e_mail_lbl);

        username_lbl = new JLabel("Username :");
        username_lbl.setBounds(65, 220, 140, 40);
        username_lbl.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(username_lbl);



    }
    public void adminData(){

        fullname_lbl = new JLabel(adminModel.getFullName());
        fullname_lbl.setBounds(160, 70, 140,40);
        fullname_lbl.setFont(new Font("times",Font.BOLD,13));
        rectangle_menu.add(fullname_lbl);

        gender_lbl = new JLabel(adminModel.getGender());
        gender_lbl.setBounds(160, 120, 140, 40);
        gender_lbl.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(gender_lbl);

        e_mail_lbl = new JLabel(adminModel.getEmail());
        e_mail_lbl.setBounds(160, 170, 200, 40);
        e_mail_lbl.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(e_mail_lbl);

        username_lbl = new JLabel(adminModel.getUsername());
        username_lbl.setBounds(160, 220, 140, 40);
        username_lbl.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(username_lbl);

    }

    void handAction(){
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

        if (e.getSource().equals(dashboard)){

        }
        else if (e.getSource().equals(add_employee_btn)){
            Admin_dashboard.this.setVisible(false);
            Adding_employee add_btn = new Adding_employee();
            add_btn.setVisible(true);
        }
        else if (e.getSource().equals(staffList)){
            Admin_dashboard.this.setVisible(false);
            Staff_list staffList_btn = new Staff_list();
            staffList_btn.setVisible(true);
        }
        else if (e.getSource().equals(statistics)){
            Admin_dashboard.this.setVisible(false);
            new Graphs().setVisible(true);
        }
        else if (e.getSource().equals(product)){
            Admin_dashboard.this.setVisible(false);
            Product_Inventory product_btn  = new Product_Inventory();
            product_btn.setVisible(true);
        }
        else if (e.getSource().equals(setting)){
            Admin_dashboard.this.setVisible(false);
            Admin_setting ad_set = new Admin_setting(new AdminModel());
            ad_set.setVisible(true);
        }
        else if(e.getSource().equals(back_btn)) {
            Admin_dashboard.this.setVisible(false);
            Welcome back = new Welcome();
            back.setVisible(true);
        }
        else if (e.getSource().equals(logOut)){
            String[] options = {"Yes", "No"};
            int jk = JOptionPane.showOptionDialog(null,"Do You Want To Logout??",
                    "Yes or No",JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null,options,options[0]);

            if(jk == 0){
                Admin_dashboard.this.setVisible(false);
                Welcome well = new Welcome();
                well.setVisible(true);
            }



        }

    }

}


