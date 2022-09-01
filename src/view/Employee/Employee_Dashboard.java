package view.Employee;

import controller.EmployeeController;
import database.Dbconnection;
import model.Employee_model;
import view.About_project_help;
import view.For_link;
import view.Welcome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Employee_Dashboard extends JFrame implements ActionListener {
    // stating the element and objects
    JLabel crms_Logo,rectangle_dash,rectangle_menu,employee_pic,employee_pic_label,small_profile,dash_icon;
    JLabel name_label, ctz_no_label, address_lbl, gender_lbl, marital_lbl, e_mail_lbl, phone_no_lbl, dob_lbl, position_lbl;
    JTextField emp_name;
    JCheckBox atsys;
    private JLabel fusername,fcitizenship,faddress,f_email,fphone,fposition,fmaritial,fgender,fdob;
    JButton dashboard,order_history,setting_emp,logOut,back_btn;
    EmployeeController employeeController;
    Employee_model employee_model;
    Dbconnection db;

    public Employee_Dashboard(){
        this.employeeController = new EmployeeController();
        this.employee_model = employeeController.fetchLoggedInEmployee();
//


//      initializing the GUI
        initialize_dash_GUI();

        showMenu();

        dashboard_side();

        dashboard_elements();
        employeeData();
        handAction();
//

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
        setVisible(true);

    }

    public void showMenu() {
        //create a menu bar
        final JMenuBar menuBar = new JMenuBar();

        //create menus of file
        JMenu fileMenu = new JMenu("File");
        //create menu items
        JMenuItem welMenuItem = new JMenuItem("Welcome page");
        welMenuItem.setActionCommand("Welcome");

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setActionCommand("Exit");

        //add menu to menubar
        menuBar.add(fileMenu);
        //add menu items to menubar fileMenu
        fileMenu.add(welMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);


        class exitAction implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }
        class welAction implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Welcome().setVisible(true);
            }
        }
        welMenuItem.addActionListener(new welAction());
        exitMenuItem.addActionListener(new exitAction());

        final JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.setActionCommand("About");
        JMenuItem teamMenuItem = new JMenuItem("Team");
        teamMenuItem.setActionCommand("Team");


        class aboutAction implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                new About_project_help();
            }
        }
        class teamAction implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "The following project was completed \n " +
                        "by Group1 of 31'A' batch from Softwarica college.\n The members of the team are:\n\n" +
                        " Abishek Bimali, Abishek Bhatta, Rakshit Shrestha, \n Rabindra Wagle, Mukesh Shah and Alisha  ");
            }
        }
        aboutMenuItem.addActionListener(new aboutAction());
        teamMenuItem.addActionListener(new teamAction());

        //add menu items to menubar help Menu
        menuBar.add(helpMenu);
        helpMenu.add(aboutMenuItem);
        helpMenu.add(teamMenuItem);

        final JMenu linkMenu = new JMenu("Links");
        JMenuItem gitHubLink = new JMenuItem("GitHub Link");
        gitHubLink.setActionCommand("GitHub link");
        JMenuItem youTubeLink = new JMenuItem("YouTube Link");
        youTubeLink.setActionCommand("Youtube link");

        //add menu items to menubar link Menu
        menuBar.add(linkMenu);
        linkMenu.add(gitHubLink);
        linkMenu.add(youTubeLink);

        class gitHubAction implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                new For_link().gitLink_frame();
            }
        }

        class youTubeAction implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                new For_link().youTubeLink_frame();
            }
        }
        gitHubLink.addActionListener(new gitHubAction());
        youTubeLink.addActionListener(new youTubeAction());

//        //add menubar to the frame
        setJMenuBar(menuBar);



    }


    public void dashboard_side(){

        // color selection for the button
        Color b_c = new Color(0x212429);

        // label for dashboard
        rectangle_dash = new JLabel(new ImageIcon("public\\chef_icon\\Rectangle 47.png"));
        rectangle_dash.setBounds(0,0,250,900);
        add(rectangle_dash);

        // adding logo to the dashboard label
        crms_Logo = new JLabel(new ImageIcon("public\\chef_icon\\Crescent_RMS_logo1.png"));
        crms_Logo.setBounds(20,30,200,200);
        rectangle_dash.add(crms_Logo);

        JLabel staff_title = new JLabel("Dashboard");
        staff_title.setBounds(350,30,200,40);
        staff_title.setFont(new Font("forte",Font.PLAIN,25));
        staff_title.setForeground(Color.PINK);
        add(staff_title);


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


        order_history = new JButton("Orders");
        order_history.setBounds(85, 300, 130,25);
        order_history.setFont(new Font("times",Font.PLAIN,20));
        order_history.setBackground(b_c);
        order_history.setBorderPainted(false);
        order_history.setForeground(Color.white);
        order_history.setFocusable(false);
        order_history.setCursor(new Cursor(Cursor. HAND_CURSOR));
        rectangle_dash.add(order_history);

        setting_emp = new JButton("Setting");
        setting_emp.setBounds(85, 350, 130,25);
        setting_emp.setFont(new Font("times",Font.PLAIN,20));
        setting_emp.setBackground(b_c);
        setting_emp.setBorderPainted(false);
        setting_emp.setForeground(Color.white);
        setting_emp.setFocusable(false);
        setting_emp.setCursor(new Cursor(Cursor. HAND_CURSOR));
        rectangle_dash.add(setting_emp);


        logOut = new JButton("Log Out");
        logOut.setBounds(85, 400, 130,25);
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
//        rectangle_dash.add(back_btn);

    }

    public void dashboard_elements(){

        // profile side
        employee_pic_label = new JLabel(new ImageIcon("public\\chef_icon\\Rectangle_Employee_add.png"));
        employee_pic_label.setBounds(280,200,250,440);
        add(employee_pic_label);

        // emp pic
        employee_pic= new JLabel(new ImageIcon(employee_model.getPicture()));
        employee_pic.setBounds(20,10,200,200);
        employee_pic_label.add(employee_pic);

//        JLabel username_lbl = new JLabel("Username :");
//        username_lbl.setBounds(10, 230, 140, 40);
//        username_lbl.setFont(new Font("times", Font.BOLD, 13));
//        employee_pic_label.add(username_lbl);
//
//        JLabel password_lbl = new JLabel("Password : ");
//        password_lbl.setBounds(10, 260, 140, 40);
//        password_lbl.setFont(new Font("times", Font.BOLD, 13));
//        employee_pic_label.add(password_lbl);

        // small profile icon
        small_profile = new JLabel(new ImageIcon("public\\chef_icon\\Small_profile.png"));
        small_profile.setBounds(900,10,50,50);
        add(small_profile);

        JLabel small_emp_title = new JLabel(employee_model.getName());
        small_emp_title.setBounds(950, 10, 140,40);
        small_emp_title.setFont(new Font("times",Font.BOLD,13));
        small_emp_title.setForeground(Color.white);
        add(small_emp_title);

        // Emp Info background
        rectangle_menu = new JLabel(new ImageIcon("public\\chef_icon\\Rectangle_Employee_add.png"));
        rectangle_menu.setBounds(600,180,520,460);
        add(rectangle_menu);


        // label to the frame
        name_label = new JLabel("Fullname");
        name_label.setBounds(65, 70, 140,40);
        name_label.setFont(new Font("times",Font.BOLD,13));
        rectangle_menu.add(name_label);


        ctz_no_label = new JLabel("Citizenship");
        ctz_no_label.setBounds(65, 120, 140, 40);
        ctz_no_label.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(ctz_no_label);

        gender_lbl = new JLabel("Gender");
        gender_lbl.setBounds(370, 120, 140, 40);
        gender_lbl.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(gender_lbl);

        address_lbl = new JLabel("Address");
        address_lbl.setBounds(65, 170, 140, 40);
        address_lbl.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(address_lbl);

        e_mail_lbl = new JLabel("E-Mail");
        e_mail_lbl.setBounds(65, 220, 140, 40);
        e_mail_lbl.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(e_mail_lbl);

        phone_no_lbl = new JLabel("Phone No.");
        phone_no_lbl.setBounds(65, 270, 140, 40);
        phone_no_lbl.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(phone_no_lbl);

        position_lbl = new JLabel("Position");
        position_lbl.setBounds(65, 320, 140, 40);
        position_lbl.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(position_lbl);

        marital_lbl = new JLabel("Marital status");
        marital_lbl.setBounds(65, 370, 140, 40);
        marital_lbl.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(marital_lbl);



    }



    void handAction(){
        dashboard.addActionListener(this);
        order_history.addActionListener(this);
        setting_emp.addActionListener(this);
        logOut.addActionListener(this);

//        back_btn.addActionListener(this);
    }


    public void employeeData(){

        fusername = new JLabel(employee_model.getName());
        fusername.setBounds(165, 70, 140,40);
        fusername.setFont(new Font("times",Font.BOLD,13));
        rectangle_menu.add(fusername);

        fcitizenship = new JLabel(employee_model.getCitizen_no());
        fcitizenship.setBounds(165, 120, 140, 40);
        fcitizenship.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(fcitizenship);


        fgender = new JLabel(employee_model.getGender());
        fgender.setBounds(440, 120, 100, 40);
        fgender.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(fgender);


        faddress = new JLabel(employee_model.getAddress());
        faddress.setBounds(165, 170, 140, 40);
        faddress.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(faddress);

        f_email = new JLabel(employee_model.getMail());
        f_email.setBounds(165, 220, 140, 40);
        f_email.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(f_email);

        fphone = new JLabel(employee_model.getPhone());
        fphone.setBounds(165, 270, 140, 40);
        fphone.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(fphone);


        fposition = new JLabel(employee_model.getPosition());
        fposition.setBounds(165, 320, 140, 40);
        fposition.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(fposition);


        fmaritial = new JLabel(employee_model.getMarried());
        fmaritial.setBounds(165, 370, 140, 40);
        fmaritial.setFont(new Font("times", Font.BOLD, 13));
        rectangle_menu.add(fmaritial);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(dashboard)){

        }
        else if (e.getSource().equals(order_history)){
            Employee_Dashboard.this.setVisible(false);
            EmployeeWork orders = new EmployeeWork();
            orders.setVisible(true);
//            JOptionPane.showMessageDialog(null,"Orders In Development Process");
        }
         else if (e.getSource().equals(setting_emp)){
            Employee_Dashboard.this.setVisible(false);
            Employee_setting emp_set = new Employee_setting();
            emp_set.setVisible(true);
//            JOptionPane.showMessageDialog(null,"Settings In Development Process");
        }
        else if(e.getSource().equals(back_btn)){
            Employee_Dashboard.this.setVisible(false);
            Welcome back = new Welcome();
            back.setVisible(true);
        }
        else if (e.getSource().equals(logOut)){
            String[] options = {"Yes", "No"};
            int jk = JOptionPane.showOptionDialog(null,"Do You Want To Logout??",
                    "Yes or No",JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null,options,options[0]);

            if(jk == 0){
                Employee_Dashboard.this.setVisible(false);
                Welcome well = new Welcome();
                well.setVisible(true);
            }


        }

    }
}


