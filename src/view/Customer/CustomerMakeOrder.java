/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.Customer;

import controller.OrderController;
import model.OrderFood;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import view.About_project_help;
import view.For_link;
import view.Welcome;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;


public class CustomerMakeOrder extends javax.swing.JFrame {
    JTextArea b;
    JLabel gg,grandt,jLabel1,jLabel2,jLabel3,jLabel4,message,message2,services,ss,to,total;
    JComboBox jComboBox1;
    JTextField F1,F2,F3,F4,F5,F6,F7,F8,F9,F10,F11,F12,tablenumber;
    JButton back,food1,food2,food3,food4,food5,food6,food7,food8,food9,food10,food11,food12,delete,order,print,reset,payment;
    JPanel jPanel1,jPanel2,jPanel3,jPanel4,jPanel5;
    JScrollPane jScrollPane1,jScrollPane2;
    JTable jTable1;

    public CustomerMakeOrder() {
        initComponents();
//        UIThame();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Image icon = Toolkit.getDefaultToolkit().getImage("public\\logo.png");
        setIconImage(icon);
        showMenu();
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

    //    private void UIThame(){
//                try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(CustomerMakeOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CustomerMakeOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CustomerMakeOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CustomerMakeOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        food1 = new javax.swing.JButton();
        food2 = new javax.swing.JButton();
        food3 = new javax.swing.JButton();
        food4 = new javax.swing.JButton();
        food5 = new javax.swing.JButton();
        food6 = new javax.swing.JButton();
        F1 = new javax.swing.JTextField();
        F2 = new javax.swing.JTextField();
        F3 = new javax.swing.JTextField();
        F4 = new javax.swing.JTextField();
        F5 = new javax.swing.JTextField();
        F6 = new javax.swing.JTextField();
        food7 = new javax.swing.JButton();
        food8 = new javax.swing.JButton();
        food9 = new javax.swing.JButton();
        F7 = new javax.swing.JTextField();
        F8 = new javax.swing.JTextField();
        F9 = new javax.swing.JTextField();
        food10 = new javax.swing.JButton();
        food11 = new javax.swing.JButton();
        food12 = new javax.swing.JButton();
        F10 = new javax.swing.JTextField();
        F11 = new javax.swing.JTextField();
        F12 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        b = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        ss = new javax.swing.JLabel();
        to = new javax.swing.JLabel();
        gg = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        services = new javax.swing.JLabel();
        grandt = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tablenumber = new javax.swing.JTextField();
        print = new javax.swing.JButton();
        order = new javax.swing.JButton();
        payment = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        message = new javax.swing.JLabel();
        message2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        food1.setBackground(new java.awt.Color(51, 51, 51));
        food1.setIcon(new javax.swing.ImageIcon("public\\Picture\\chickenSoup.jpg")); // NOI18N
        food1.setForeground(new java.awt.Color(255, 255, 255));
        food1.setFocusable(false);
        food1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                food1ActionPerformed(evt);
            }
        });

        food2.setBackground(new java.awt.Color(51, 51, 51));
        food2.setIcon(new javax.swing.ImageIcon("public\\Picture\\Burgers.jpg")); // NOI18N
        food2.setForeground(new java.awt.Color(255, 255, 255));
        food2.setFocusable(false);
        food2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                food2ActionPerformed(evt);
            }
        });

        food3.setBackground(new java.awt.Color(51, 51, 51));
        food3.setIcon(new javax.swing.ImageIcon("public\\Picture\\Meatloaf.jfif")); // NOI18N
        food3.setForeground(new java.awt.Color(255, 255, 255));
        food3.setFocusable(false);
        food3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                food3ActionPerformed(evt);
            }
        });

        food4.setBackground(new java.awt.Color(51, 51, 51));
        food4.setIcon(new javax.swing.ImageIcon("public\\Picture\\Sekuwa.jfif")); // NOI18N
        food4.setForeground(new java.awt.Color(255, 255, 255));
        food4.setFocusable(false);
        food4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                food4ActionPerformed(evt);
            }
        });

        food5.setBackground(new java.awt.Color(51, 51, 51));
        food5.setIcon(new javax.swing.ImageIcon("public\\Picture\\friedmomo.jpg")); // NOI18N
        food5.setForeground(new java.awt.Color(255, 255, 255));
        food5.setFocusable(false);
        food5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                food5ActionPerformed(evt);
            }
        });

        food6.setBackground(new java.awt.Color(51, 51, 51));
        food6.setIcon(new javax.swing.ImageIcon("public\\Picture\\HotDog.jpg")); // NOI18N
        food6.setForeground(new java.awt.Color(255, 255, 255));
        food6.setFocusable(false);
        food6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                food6ActionPerformed(evt);
            }
        });

        F1.setEditable(false);
        F1.setBackground(new java.awt.Color(51, 51, 51));
        F1.setForeground(new java.awt.Color(255, 255, 255));
        F1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F1.setText("0");
        F1.setActionCommand("<Not Set>");
        F1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));


        F2.setEditable(false);
        F2.setBackground(new java.awt.Color(51, 51, 51));
        F2.setForeground(new java.awt.Color(255, 255, 255));
        F2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F2.setText("0");

        F3.setEditable(false);
        F3.setBackground(new java.awt.Color(51, 51, 51));
        F3.setForeground(new java.awt.Color(255, 255, 255));
        F3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F3.setText("0");

        F4.setEditable(false);
        F4.setBackground(new java.awt.Color(51, 51, 51));
        F4.setForeground(new java.awt.Color(255, 255, 255));
        F4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F4.setText("0");

        F5.setEditable(false);
        F5.setBackground(new java.awt.Color(51, 51, 51));
        F5.setForeground(new java.awt.Color(255, 255, 255));
        F5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F5.setText("0");

        F6.setEditable(false);
        F6.setBackground(new java.awt.Color(51, 51, 51));
        F6.setForeground(new java.awt.Color(255, 255, 255));
        F6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F6.setText("0");


        food7.setBackground(new java.awt.Color(51, 51, 51));
        food7.setIcon(new javax.swing.ImageIcon("public\\Picture\\vegetable.jpg"));
        food7.setForeground(new java.awt.Color(255, 255, 255));
        food7.setFocusable(false);
        food7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                food7ActionPerformed(evt);
            }
        });

        food8.setBackground(new java.awt.Color(51, 51, 51));
        food8.setIcon(new javax.swing.ImageIcon("public\\Picture\\Lasagna.jfif"));
        food8.setForeground(new java.awt.Color(255, 255, 255));
        food8.setFocusable(false);
        food8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                food8ActionPerformed(evt);
            }
        });

        food9.setBackground(new java.awt.Color(51, 51, 51));
        food9.setIcon(new javax.swing.ImageIcon("public\\Picture\\momo.jfif")); // NOI18N
        food9.setForeground(new java.awt.Color(255, 255, 255));
        food9.setFocusable(false);
        food9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                food9ActionPerformed(evt);
            }
        });

        F7.setEditable(false);
        F7.setBackground(new java.awt.Color(51, 51, 51));
        F7.setForeground(new java.awt.Color(255, 255, 255));
        F7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F7.setText("0");

        F8.setEditable(false);
        F8.setBackground(new java.awt.Color(51, 51, 51));
        F8.setForeground(new java.awt.Color(255, 255, 255));
        F8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F8.setText("0");

        F9.setEditable(false);
        F9.setBackground(new java.awt.Color(51, 51, 51));
        F9.setForeground(new java.awt.Color(255, 255, 255));
        F9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F9.setText("0");

        food10.setBackground(new java.awt.Color(51, 51, 51));
        food10.setForeground(new java.awt.Color(255, 255, 255));
        food10.setIcon(new javax.swing.ImageIcon("public\\Picture\\tea.jfif")); // NOI18N
        food10.setFocusable(false);
        food10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                food10ActionPerformed(evt);
            }
        });

        food11.setBackground(new java.awt.Color(51, 51, 51));
        food11.setForeground(new java.awt.Color(255, 255, 255));
        food11.setIcon(new javax.swing.ImageIcon("public\\Picture\\Coffee.jfif")); // NOI18N
        food11.setFocusable(false);
        food11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                food11ActionPerformed(evt);
            }
        });

        food12.setBackground(new java.awt.Color(51, 51, 51));
        food12.setIcon(new javax.swing.ImageIcon("public\\Picture\\Beer.jfif")); // NOI18N
        food12.setForeground(new java.awt.Color(255, 255, 255));
        food12.setFocusable(false);
        food12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                food12ActionPerformed(evt);
            }
        });

        F10.setEditable(false);
        F10.setBackground(new java.awt.Color(51, 51, 51));
        F10.setForeground(new java.awt.Color(255, 255, 255));
        F10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F10.setText("0");

        F11.setEditable(false);
        F11.setBackground(new java.awt.Color(51, 51, 51));
        F11.setForeground(new java.awt.Color(255, 255, 255));
        F11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F11.setText("0");

        F12.setEditable(false);
        F12.setBackground(new java.awt.Color(51, 51, 51));
        F12.setForeground(new java.awt.Color(255, 255, 255));
        F12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F12.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(food1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(food2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(food3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(F1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(F2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(F3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(F10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addComponent(F11, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(F12, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(food4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(food5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(food6, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(F4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(71, 71, 71)
                                                .addComponent(F5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(F6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(25, 25, 25))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(food7, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(food8, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(food9, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(F7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(73, 73, 73)
                                                .addComponent(F8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(F9, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(food10, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(food11, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(food12, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(food1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(food2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(food3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(F1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(F2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(F3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(food4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(food5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(food6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(F4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(F5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(F6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(food7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(food8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(food9, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(F7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(F8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(F9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(food10, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(food11, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(food12, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(F10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(F11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(F12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        b.setEditable(false);
        b.setBackground(new java.awt.Color(51, 51, 51));
        b.setColumns(20);
        b.setForeground(new java.awt.Color(255, 255, 255));
        b.setRows(5);
        jScrollPane2.setViewportView(b);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable1.setBackground(new java.awt.Color(51, 51, 51));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Pro.ID", "Table No", "Name", "Quantity", "Price"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(50);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(1).setMinWidth(10);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(90);
            jTable1.getColumnModel().getColumn(2).setMinWidth(160);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(160);
            jTable1.getColumnModel().getColumn(3).setMinWidth(80);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(4).setMinWidth(100);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 4, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        ss.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ss.setForeground(new java.awt.Color(255, 255, 255));
        ss.setText("Service Tax : ");

        to.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        to.setForeground(new java.awt.Color(255, 255, 255));
        to.setText("Total : ");

        gg.setBackground(new java.awt.Color(255, 255, 255));
        gg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        gg.setForeground(new java.awt.Color(255, 255, 255));
        gg.setText("Grand Total :   Rs");

        total.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        total.setForeground(new java.awt.Color(255, 255, 255));

        services.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        services.setForeground(new java.awt.Color(255, 255, 255));

        grandt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        grandt.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Enter your table number : ");

        tablenumber.setBackground(new java.awt.Color(51, 51, 51));
        tablenumber.setForeground(new java.awt.Color(255, 255, 255));
        tablenumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tablenumber.setText("00");

        print.setBackground(new java.awt.Color(51, 51, 51));
        print.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        print.setForeground(new java.awt.Color(255, 255, 255));
        print.setText("Print");
        print.setFocusable(false);
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        order.setBackground(new java.awt.Color(51, 51, 51));
        order.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        order.setForeground(new java.awt.Color(255, 255, 255));
        order.setText("Order");
        order.setFocusable(false);
        order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderActionPerformed(evt);
            }
        });

        payment.setBackground(new java.awt.Color(51, 51, 51));
        payment.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        payment.setForeground(new java.awt.Color(255, 255, 255));
        payment.setText("Pay");
        payment.setFocusable(false);
        payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentActionPerformed(evt);
            }
        });

        reset.setBackground(new java.awt.Color(51, 51, 51));
        reset.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        reset.setForeground(new java.awt.Color(255, 255, 255));
        reset.setText("Reset");
        reset.setFocusable(false);
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(51, 51, 51));
        delete.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Delete");
        delete.setFocusable(false);
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(51, 51, 51));
        back.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.setFocusable(false);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jComboBox1.setBackground(new java.awt.Color(51, 51, 51));
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Card", "Online", "Cash" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Select Payment Method");

        message.setBackground(new java.awt.Color(51, 51, 51));
        message.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        message.setForeground(new java.awt.Color(255, 0, 0));

        message2.setBackground(new java.awt.Color(51, 51, 51));
        message2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        message2.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tablenumber, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(56, 56, 56)
                                                .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(order, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(payment, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(79, 79, 79)
                                                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(29, 29, 29))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(ss, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(services, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(gg)
                                                .addGap(18, 18, 18)
                                                .addComponent(grandt, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addComponent(message2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(29, 29, 29))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(total)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ss)
                                        .addComponent(services)
                                        .addComponent(message))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(gg)
                                                .addComponent(grandt))
                                        .addComponent(message2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(tablenumber, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(order, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(payment, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("     The Crescent Restaurent");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Estd: 2022, Dillibazar, kathmandu");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setVisible(true);
    }// </editor-fold>

    public void cleartext(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        total.setText("");
        services.setText("");
        grandt.setText("");
        tablenumber.setEditable(true);
    }

    public void addtables(int id ,int TABLE,String Name,int Qty ,Double Price){

        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();

        DecimalFormat df = new DecimalFormat("00.00") ;
        double totPrice = Price * Double.valueOf(Qty) ;

        String TotalPrice = df.format(totPrice);
        for (int row = 0; row < jTable1.getRowCount(); row++) {

            if (Name == jTable1.getValueAt(row, 2)) {

                dt.removeRow(jTable1.convertRowIndexToModel(row));
            }
        }
        Vector v = new Vector();
        v.add(id);
        v.add(TABLE);
        v.add(Name);
        v.add(Qty);
        v.add(TotalPrice); // total price
        dt.addRow(v);
    }
    public void cal(){
        //cal total table values
        double sum=0;
        for(int i=0;i<jTable1.getRowCount();i++){

            sum=sum+ Double.parseDouble((jTable1.getValueAt(i,4).toString()));
        }

        total.setText(Double.toString(sum));
        double cTotal=Double.parseDouble(total.getText());


        double ctax=(cTotal*3)/100;
        String itax=String.format("Rs %.2f", ctax);
        services.setText(itax);


        String subtotal=String.format("Rs %.2f", cTotal);
        total.setText(subtotal);
//

        String total=String.format("%.2f", cTotal+ ctax);
        grandt.setText(total);
//

    }
    private void food1ActionPerformed(java.awt.event.ActionEvent evt) {
        int i = Integer.valueOf(F1.getText());int tab = Integer.valueOf(tablenumber.getText());if(tab==0){            JOptionPane.showMessageDialog(null, "Please select table first!!");}
        else if(tab>15 || tab<0){JOptionPane.showMessageDialog(null, "Table counts between 1 - 15 !!");}
        else{++i;
            F1.setText(String.valueOf(i));
            addtables(1,tab ,"Chicken Soup", i, 299.99); tablenumber.setEditable(false);
            cal();
            showBill();
        }
    }

    private void food2ActionPerformed(java.awt.event.ActionEvent evt) {
        int i = Integer.valueOf(F2.getText());
        int tab = Integer.valueOf(tablenumber.getText());if(tab==0){JOptionPane.showMessageDialog(null, "Please select table first!!");
        }        else if(tab>15 || tab<0){JOptionPane.showMessageDialog(null, "Table counts between 1 - 15 !!");}
        else{++i;F2.setText(String.valueOf(i));
            tablenumber.setEditable(false);
            addtables(2,tab ,"Burgers ", i, 150.0);
            cal();
            showBill();}
    }

    private void food3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int i = Integer.valueOf(F3.getText());
        int tab = Integer.valueOf(tablenumber.getText());if(tab==0){JOptionPane.showMessageDialog(null, "Please select table first!!");
        }        else if(tab>15 || tab<0){JOptionPane.showMessageDialog(null, "Table counts between 1 - 15 !!");}
        else{++i;F3.setText(String.valueOf(i));
            addtables(3,tab ,"Meatloaf", i, 399.99);  tablenumber.setEditable(false);
            cal();
            showBill();}
    }

    private void food4ActionPerformed(java.awt.event.ActionEvent evt) {
        int i = Integer.valueOf(F4.getText());
        int tab = Integer.valueOf(tablenumber.getText());if(tab==0){JOptionPane.showMessageDialog(null, "Please select table first!!");
        }        else if(tab>15 || tab<0){JOptionPane.showMessageDialog(null, "Table counts between 1 - 15 !!");}
        else{++i;F4.setText(String.valueOf(i));
            addtables(4,1 ,"Sekuwa", i, 399.99); tablenumber.setEditable(false);
            cal();
            showBill();}
    }

    private void food5ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int i = Integer.valueOf(F5.getText());
        int tab = Integer.valueOf(tablenumber.getText());if(tab==0){JOptionPane.showMessageDialog(null, "Please select table first!!");
        }        else if(tab>15 || tab<0){JOptionPane.showMessageDialog(null, "Table counts between 1 - 15 !!");}
        else{++i;F5.setText(String.valueOf(i));
            addtables(5,1 ,"Fried MoMo", i, 199.99);  tablenumber.setEditable(false);
            cal();
            showBill();}
    }

    private void food6ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int i = Integer.valueOf(F6.getText());
        int tab = Integer.valueOf(tablenumber.getText());if(tab==0){JOptionPane.showMessageDialog(null, "Please select table first!!");
        }        else if(tab>15 || tab<0){JOptionPane.showMessageDialog(null, "Table counts between 1 - 15 !!");}
        else{++i;F6.setText(String.valueOf(i));
            tablenumber.setEditable(false);
            addtables(6,1 ,"Hot Dog", i, 249.99);
            cal();
            showBill();}
    }

    private void food7ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int i = Integer.valueOf(F7.getText());
        int tab = Integer.valueOf(tablenumber.getText());if(tab==0){JOptionPane.showMessageDialog(null, "Please select table first!!");
        }        else if(tab>15 || tab<0){JOptionPane.showMessageDialog(null, "Table counts between 1 - 15 !!");}
        else{++i;F7.setText(String.valueOf(i));
            tablenumber.setEditable(false);
            addtables(7,1 ,"Chow Mein ", i, 149.99);
            cal();
            showBill();}
    }

    private void food8ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int i = Integer.valueOf(F8.getText());
        int tab = Integer.valueOf(tablenumber.getText());if(tab==0){JOptionPane.showMessageDialog(null, "Please select table first!!");
        }        else if(tab>15 || tab<0){JOptionPane.showMessageDialog(null, "Table counts between 1 - 15 !!");}
        else{++i;F8.setText(String.valueOf(i));
            tablenumber.setEditable(false);
            addtables(8,1 ,"Lasangna", i, 349.99);
            cal();
            showBill();}
    }

    private void food9ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int i = Integer.valueOf(F9.getText());
        int tab = Integer.valueOf(tablenumber.getText());if(tab==0){JOptionPane.showMessageDialog(null, "Please select table first!!");
        }        else if(tab>15 || tab<0){JOptionPane.showMessageDialog(null, "Table counts between 1 - 15 !!");}
        else{++i;F9.setText(String.valueOf(i));
            tablenumber.setEditable(false);
            addtables(9,1 ," MoMo", i, 149.99);
            cal();
            showBill();}
    }

    private void food10ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int i = Integer.valueOf(F10.getText());
        ++i;
        F10.setText(String.valueOf(i));
        int tab = Integer.valueOf(tablenumber.getText());if(tab==0){JOptionPane.showMessageDialog(null, "Please select table first!!");
        }        else if(tab>15 || tab<0){JOptionPane.showMessageDialog(null, "Table counts between 1 - 15 !!");}
        else{tablenumber.setEditable(false);
            addtables(10,1 ,"Tea", i, 29.99);
            cal();
            showBill();}
    }
    private void food11ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int i = Integer.valueOf(F11.getText());
        int tab = Integer.valueOf(tablenumber.getText());if(tab==0){JOptionPane.showMessageDialog(null, "Please select table first!!");
        }        else if(tab>15 || tab<0){JOptionPane.showMessageDialog(null, "Table counts between 1 - 15 !!");}
        else{++i;F11.setText(String.valueOf(i));
            tablenumber.setEditable(false);
            addtables(11,1 ,"Coffee", i, 199.99);
            cal();
            showBill();}
    }
    private void food12ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int i = Integer.valueOf(F12.getText());
        int tab = Integer.valueOf(tablenumber.getText());if(tab==0){JOptionPane.showMessageDialog(null, "Please select table first!!");
        }        else if(tab>15 || tab<0){JOptionPane.showMessageDialog(null, "Table counts between 1 - 15 !!");}
        else{++i;F12.setText(String.valueOf(i));
            tablenumber.setEditable(false);
            addtables(12,1 ,"Beers ", i, 499.99);
            cal();
            showBill();}
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        if(jComboBox1.getSelectedItem().equals("Cash")){
            payment.setEnabled(false);
            message.setText("Note:Please go to Counter to pay by cash.");
            message2.setText("");
        }
        else if(jComboBox1.getSelectedItem().equals("Card")){
            payment.setEnabled(false);
            message.setText("Payment by Card is not available now.");
            message2.setText("We are working on this service.");
        }else{
            payment.setEnabled(true);
            message.setText("");
            message2.setText("");
        }
    }

    private void printActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable1.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Please Select the food first !!");
        }else {try {
            showBill();
            boolean print = b.print();
            if (!print) {
                JOptionPane.showMessageDialog(null, "Unable To Print !!..");
            }} catch (PrinterException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }}
    }

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {
        if(evt.getSource().equals(reset)){
            if (jTable1.getRowCount()==0) {
                JOptionPane.showMessageDialog(null, "Nothing to Reset!! ");
            }
            else{
                String[] options = {"Yes", "No"};
                int jk = JOptionPane.showOptionDialog(null,"Do you want to reset order??",
                        "",JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,null,options,options[0]);

                if(jk == 0){
                    cleartext();
                    b.setText("");
                }
            } }

    }

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
            String r = dt.getValueAt(jTable1.getSelectedRow(), 0).toString();
            //remove product
            int rw = jTable1.getSelectedRow();
            dt.removeRow(rw);
            if (jTable1.getRowCount() == 0) {
                b.setText("");
            }
            else{
                showBill();
            }
            cal();
        }catch (Exception e){

        }
    }

    private void paymentActionPerformed(java.awt.event.ActionEvent evt) {

        if(b.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please order first!!");
        }
        else if(jComboBox1.getSelectedItem().equals("Select")){
            JOptionPane.showMessageDialog(null, "Please select the payment method");
        }
        else if (jComboBox1.getSelectedItem().equals("Online")){
//               Scan and payment
            try{
                File file1 = new File("public\\online.png");
                String data = String.format(gg.getText()+grandt.getText());
                ByteArrayOutputStream out = QRCode.from(data).withSize(250, 250).to(ImageType.PNG).stream();
                FileOutputStream fos = new FileOutputStream(file1);
                out.writeTo(fos);
                out.flush();
                fos.close();

            }
            catch(Exception e){
                System.out.println(e);

            }
            JFrame newframe=new JFrame();
            newframe.setBounds(700,200,350,200);
            newframe.setResizable(false);
            newframe.setLayout(null);

            JButton button = new JButton("Esewa");
            button.setForeground(Color.WHITE);
            button.setBackground(Color.blue);
            button.setFocusable(false);
            button.setCursor(new Cursor(Cursor. HAND_CURSOR));
            button.setBounds(70, 50, 100, 25);
            newframe.add(button);

            JLabel label = new JLabel();
            label.setBounds(40, 90, 500, 50);
            label.setFont(label.getFont().deriveFont(17f));
            label.setForeground(Color.red);
            newframe.add(label);

            JButton button1 = new JButton("Scan");
            button1.setForeground(Color.WHITE);
            button1.setBackground(Color.blue);
            button1.setFocusable(false);
            button1.setCursor(new Cursor(Cursor. HAND_CURSOR));
            button1.setBounds(180, 50, 100, 25);
            button1.setBorder(BorderFactory.createRaisedBevelBorder());
            newframe.add(button1);

            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    newframe.dispose();
                    label.setText("");
                    JFrame scanner=new JFrame();
                    scanner.setBounds(700,200,403,403);
                    scanner.setResizable(false);
                    scanner.setLayout(null);
                    JLabel admin_pic_label = new JLabel(new ImageIcon("public\\online.png"));
                    admin_pic_label.setBounds(0,0,400,400);
                    scanner.add(admin_pic_label);
                    scanner.setVisible(true);
                }});
            button.addActionListener((new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    label.setText("Esewa is currently not available");
                    button.setEnabled(false);
                }}));
            newframe.setVisible(true);}
    }

    private void orderActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        if(evt.getSource().equals(order)){
            if(model.getRowCount()==0){
                JOptionPane.showMessageDialog(null, "Please Select the food first!!");

            }
            else{
                String[] options = {"Yes", "No"};
                int jk = JOptionPane.showOptionDialog(null,"Do you want to Confirm your order??",
                        "",JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,null,options,options[0]);

                if(jk == 0){
                    showBill();
//                    ---------------------------get data from table -----------------------
                    for (int i=0; i<model.getRowCount();i++) {
                        String table = model.getValueAt(i, 1).toString();
                        String name = model.getValueAt(i, 2).toString();
                        String Quantity = model.getValueAt(i, 3).toString();
                        String Total = model.getValueAt(i, 4).toString();


                        OrderController orderController = new OrderController();
                        OrderFood orderFood1 = new OrderFood(table,name, Quantity, Total);
                        int update = orderController.orderFood(orderFood1);

//                    if (update > 0) {
//                    }
                    }
                    String date= new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                    OrderController orderController = new OrderController();
                    OrderFood orderFood1 = new OrderFood(date, grandt.getText());
                    int update = orderController.totalSAles(orderFood1);
                    JOptionPane.showMessageDialog(null, "Order has beem confirmed!!");

                        cleartext();

                    }
                }}
        }


    private void backActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        dispose();
        new Table_Selection().setVisible(true);
    }
    void showBill(){
        if (jTable1.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Please make order first!!");
        } else {
            try {

                b.setText("                                The Crescent Restaurant \n");
                b.setText(b.getText() + "                                     Dilli Bazar \n");
                b.setText(b.getText() + "                                    Kathmandu,Nepal \n");
                b.setText(b.getText() + "                                     +977 ########, \n");
                b.setText(b.getText() + "---------------------------------------------------------------------------------------\n");
                b.setText(b.getText() + "Table number:              "+ tablenumber.getText()+"\n");
                b.setText(b.getText() + "----------------------------------------------------------------------------------------\n");
                b.setText(b.getText() + "  Item \t\tQty \tPrice" +"\n");
                b.setText(b.getText() + "----------------------------------------------------------------------------------------\n");

                DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
                // get table Product details
                for (int i = 0; i < jTable1.getRowCount(); i++) {

                    String Name = df.getValueAt(i, 2).toString();
                    String Qty = df.getValueAt(i, 3).toString();
                    String Price = df.getValueAt(i, 4).toString();

                    b.setText(b.getText() +"  "+ Name+"\t\t"+Qty +"\t"+Price + "\n");
                }

                b.setText(b.getText() + "-----------------------------------------------------------------------------------------\n");
                b.setText(b.getText() + "Total :                                                                 " + total.getText() +"\n");
                b.setText(b.getText() + " Service Tax   :                                                    " + services.getText() +"\n");
                b.setText(b.getText() + "Final Total :                                                       " +"Rs "+ grandt.getText() +"\n");
                b.setText(b.getText() + "----------------------------------------------------------------------------------------\n");
                b.setText(b.getText() + "                            Thanks For Your Order...!"+"\n");
                b.setText(b.getText() + "----------------------------------------------------------------------------------------\n");
                b.setText(b.getText() + "                              Visit Again with Smile"+"\n");

            } catch (Exception e) {
            }}
    }


}
