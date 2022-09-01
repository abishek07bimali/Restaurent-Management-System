package view.Customer;

import view.About_project_help;
import view.For_link;
import view.Welcome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Table_Selection extends JFrame implements ActionListener {
    JButton[] tb = new JButton[16];
    JLabel table_bg,table_field,Table_title;
    JButton tb1,tb2,tb3,tb4,tb5,tb6,tb7,tb8,tb9,tb10,tb11,tb12,tb13,tb14,tb15,tb16,back_btn;
    String tNum;
    String tableNum;
    public Table_Selection(){
        // initializing the GUI
        initialize_table_GUI();
        // initialize elements
        initialize_GUI_elements();
        table_btn();

        showMenu();

        handAction();

        select_tablebtn();
    }

    public void initialize_table_GUI(){
        setTitle("Crescent RMS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(200,20,1100,700);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
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


    public void initialize_GUI_elements() {

//        // color selection for the button
//        Color b_c = new Color(0x212429);
        table_field = new JLabel(new ImageIcon("public\\table_bg.png"));
        table_field.setBounds(0, 0, 1100, 700);
        add(table_field);

        // Title Text
        Table_title = new JLabel(" Select the table you are on: ");
        Table_title.setBounds(380, 5, 600, 50);
        Table_title.setForeground(Color.PINK);
        Table_title.setFont(new Font("Forte", Font.BOLD, 30));
        table_field.add(Table_title);

        back_btn = new JButton(new ImageIcon("public\\backBtn (1).png"));
        back_btn.setBounds(40, 30, 40, 40);
        back_btn.setOpaque(false);
        back_btn.setContentAreaFilled(false);
        back_btn.setBorderPainted(false);
        table_field.add(back_btn);

    }


    // for loop buttons
    public void table_btn() {

        int k = 1;
        for(int i=1; i<=3; i++)
        {
            for(int j=1; j<=5; j++,k++)
            {
                tb[k] = new JButton("Table " + k);
                tb[k].setBackground(new Color(0x242446));
                tb[k].setForeground(Color.pink);
                tb[k].setFont(new Font("forte",Font.PLAIN,20));
                tb[k].setBounds(80+(i*210), 100 * j, 110, 80);
//                tb[k].setOpaque(false);
                tb[k].setBorder(BorderFactory.createLineBorder(Color.pink));
                tb[k].setCursor(new Cursor(Cursor. HAND_CURSOR));
//                tb[i].setFocusPainted(false);
                // removing the button area lines and focus
                tb[k].setFocusable(false);
                table_field.add(tb[k]);
            }


        }

    }
    void handAction(){
        for(int i=1;i<=15;i++) {
            tb[i].addActionListener(this);

        }
        back_btn.addActionListener(this);

    }
    public String getTableNum() {
        return tableNum;
    }

    public void setTableNum(String tNum) {
        tableNum = tNum;
    }

    void select_tablebtn(){
        for (int i=1;i<=15;i++){
            int a =i;
            int finalI = i;
            tb[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource().equals(tb[a])) {
                        setTableNum(""+ finalI +"");
                        Table_Selection.this.setVisible(false);
                        new CustomerMakeOrder().setVisible(true);
                    }
                    else if (e.getSource().equals(tb1)) {
                        setTableNum("1");
                        Table_Selection.this.setVisible(false);
                        new CustomerMakeOrder().setVisible(true);
                    }
                    else if (e.getSource().equals(tb2)) {
                        setTableNum("2");
                        Table_Selection.this.setVisible(false);
                        new CustomerMakeOrder().setVisible(true);
                    }


                }
            });
        }
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(back_btn)) {
            dispose();
            Welcome back = new Welcome();
            back.setVisible(true);
        }

    }
}
