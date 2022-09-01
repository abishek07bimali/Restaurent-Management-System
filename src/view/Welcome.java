package view;

import view.Admin.AdminLoginForm;
import view.Customer.Table_Selection;
import view.Employee.Employeelogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

public class Welcome extends JFrame implements ActionListener {
    JLabel bg_welcome,welcome_img,crescent_text,chef_icon,crms_Logo;
    JLabel cs_side_img, ad_side_img;
    JButton customer_btn,ad_em_btn;
    public Welcome(){
        // setting up the UI
        initialize_wel_UI();

        // adding menu tab
//        MenuClass mc = new MenuClass();
//        mc.showMenuDemo();
        showMenu();

        // adding the elements
        initialize_wel_element();

        // Button Clicks
        Customer_click();
        Admin_Employee_click();

        // clock
        new MyPanel();
    }

    public void initialize_wel_UI(){
        setTitle("Crescent RMS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(0,0,1280,700);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);

        Image icon = Toolkit.getDefaultToolkit().getImage("public\\logo.png");
        setIconImage(icon);
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
                new About_project_help().setVisible(true);
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


    public void initialize_wel_element(){
        // For the background
        bg_welcome = new JLabel(new ImageIcon("public\\Welcome_bg.png"));
        bg_welcome.setBounds(0,0,1270,700);
        add(bg_welcome);



//        // img for sides
//        cs_side_img = new JLabel(new ImageIcon("public\\chef_icon\\customer_side1.png"));
//        cs_side_img.setBounds(270,240,350,400);
//        bg_welcome.add(cs_side_img);

//        ad_side_img = new JLabel(new ImageIcon("public\\chef_icon\\admin_emp_img.png"));
//        ad_side_img.setBounds(890,240,350,400);
//        bg_welcome.add(ad_side_img);
//
        // adding the fem chef icon
        chef_icon = new JLabel(new ImageIcon("public\\chef_icon\\Femalefem_res_owner.png"));
        chef_icon.setBounds(920,-80,400,900);
        bg_welcome.add(chef_icon);

        // label text
//        crescent_text = new JLabel("The Crescent Restaurant");
//        crescent_text.setBounds(520,110,500,50);
//        crescent_text.setForeground(Color.white);
//        crescent_text.setFont(new Font("forte",Font.PLAIN,35));
//        bg_welcome.add(crescent_text);

        // adding buttons
        // selecting button color
        Color btn_color = Color.decode("#D5CDF7");
        //customer
        customer_btn = new JButton("Customer");
        customer_btn.setBounds(200,500,250,50);
        customer_btn.setFont(new Font("Times",Font.BOLD,20));
        customer_btn.setForeground(Color.decode("270082"));
        customer_btn.setBackground(Color.decode("#D5CDF7"));
        customer_btn.setFocusable(false);
        customer_btn.setCursor(new Cursor(Cursor. HAND_CURSOR));
        bg_welcome.add(customer_btn);

        //Admin and Employee
        ad_em_btn = new JButton("Admin & Employee");
        ad_em_btn.setBounds(700,500,250,50);
        ad_em_btn.setFont(new Font("Times",Font.BOLD,20));
        ad_em_btn.setForeground(Color.decode("270082"));
        ad_em_btn.setBackground(Color.decode("#D5CDF7"));
        ad_em_btn.setFocusable(false);
        ad_em_btn.setCursor(new Cursor(Cursor. HAND_CURSOR));
        bg_welcome.add(ad_em_btn);

    }
    Object Customer_click(){

        customer_btn.addActionListener(this);
        return null;
    }
    void Admin_Employee_click(){

        ad_em_btn.addActionListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(customer_btn)) {
            Welcome.this.setVisible(false);

            Table_Selection select_table =  new Table_Selection();
            select_table.setVisible(true);


        }else if(e.getSource().equals(ad_em_btn)){
            String[] options = {"Admin", "Employee"};
            int x = JOptionPane.showOptionDialog(null,"Are you Admin or Employee ?","Admin or Employee",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);

            if (x == 0){
//                this.hide();
                Welcome.this.setVisible(false);
                AdminLoginForm admin_login = new AdminLoginForm();
                admin_login.setVisible(true);
            }else if(x == 1){
//                this.hide();
                Welcome.this.setVisible(false);
                Employeelogin emp_login = new Employeelogin();
                emp_login.setVisible(true);
            }
        }
    }


    public class MyPanel extends JPanel
    {
        private JLabel horloge;
        public MyPanel() {
            setLayout(new BorderLayout());
            horloge = new JLabel();
            horloge.setHorizontalAlignment(JLabel.CENTER);
            horloge.setFont(
                    UIManager.getFont("Label.font").deriveFont(Font.BOLD, 30f)
            );
            horloge.setText(
                    DateFormat.getDateTimeInstance().format(new Date())
            );
            add(horloge);
            Timer t = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    horloge.setText(
                            DateFormat.getDateTimeInstance().format(new Date())
                    );
                }
            });
            t.setRepeats(true);
            t.setCoalesce(true);
            t.setInitialDelay(0);
            t.start();
            bg_welcome.add(horloge);
            horloge.setForeground(Color.pink);
            horloge.setBounds(1,120,380,100);
            horloge.setVisible(true);
        }
    }


    public static void main(String[] args) {
        new Welcome().setVisible(true);
    }
}
