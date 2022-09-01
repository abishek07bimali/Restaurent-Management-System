package view.Admin;

import controller.AdminController;
import model.AdminModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Pattern;



public class AdminRegistration extends JFrame implements ActionListener {
    JLabel label, label1, label2, label3, label4, label5, label6, bgg;
    JTextField text1, text2, text3;
    JPasswordField text4,text5;
    JRadioButton radioMale, radioFemale,radioOther;
    JCheckBox check, check1;
    JButton button, button1;

    AdminRegistration() {
        initialized();
        uiInitialize();
        handAction();
    }

    public void initialized() {
        setTitle("Admin Registration Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(0, 0, 1280, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        Image icon = Toolkit.getDefaultToolkit().getImage("public\\logo.png");
        setIconImage(icon);
        bgg = new JLabel((new ImageIcon("public\\dark.jpg")));
        bgg.setBounds(0, 0, 1280, 700);
        add(bgg);
        setVisible(true);

    }

    public void uiInitialize() {
        label1 = new JLabel("Admin Registration Page");
        label1.setBounds(450, 10, 500, 50);
        label1.setFont(label1.getFont().deriveFont(35f));
        label1.setForeground(Color.LIGHT_GRAY);
        bgg.add(label1);

//
//            logo of restaurent
        JLabel bggLogo = new JLabel((new ImageIcon("public\\logo.png")));
        bggLogo.setBounds(5, 5, 200, 150);
        bgg.add(bggLogo);

//            image background image food
        JLabel bggfood = new JLabel((new ImageIcon("public\\food.jpg")));
        bggfood.setBounds(300, 100, 400, 440);
        bgg.add(bggfood);

//            White background
        JLabel bgg1 = new JLabel((new ImageIcon("public\\bgg.jpg")));
        bgg1.setBounds(680, 89, 440, 470);
        bgg.add(bgg1);
//
//            Fullname icon
        JLabel icon5 = new JLabel((new ImageIcon("public\\icon\\user.png")));
        icon5.setBounds(715, 91, 40, 40);
        bgg.add(icon5);
//            label
        label2 = new JLabel("Fullname");
        label2.setBounds(750, 100, 300, 25);
        label2.setFont(label2.getFont().deriveFont(20f));
        label2.setForeground(Color.black);
        bgg.add(label2);
//            field
        text1 = new JTextField();
        text1.setBounds(715, 130, 300, 25);
        text1.setText("Fullname");
        text1.setOpaque(false);
        text1.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.black));
        text1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(text1.getText().equals("Fullname")){
                    text1.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(text1.getText().equals("")){
                    text1.setText("Fullname");
                }
            }
        });
        bgg.add(text1);

//            gender icon
        JLabel icon4 = new JLabel((new ImageIcon("public\\icon\\gender.png")));
        icon4.setBounds(715, 151, 40, 40);
        bgg.add(icon4);
//            label
        label = new JLabel("Gender");
        label.setForeground(Color.black);
        label.setFont(label.getFont().deriveFont(20f));
        label.setBounds(750, 160, 200, 25);
        bgg.add(label);


//            radio male
        radioMale = new JRadioButton("Male");
        radioMale.setForeground(Color.black);
        radioMale.setBounds(750, 190, 90, 25);
        radioMale.setOpaque(false);
        bgg.add(radioMale);


//            radio Female
        radioFemale = new JRadioButton("Female");
        radioFemale.setForeground(Color.black);
        radioFemale.setOpaque(false);
        radioFemale.setBounds(850, 190, 90, 25);
        bgg.add(radioFemale);


        //            radio Other
        radioOther = new JRadioButton("Other");
        radioOther.setForeground(Color.black);
        radioOther.setOpaque(false);
        radioOther.setBounds(950, 190, 90, 25);
        bgg.add(radioOther);


//            selecting only one radiobutton
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioMale);
        bg.add(radioFemale);
        bg.add(radioOther);



//            Email
        JLabel icon = new JLabel((new ImageIcon("public\\icon\\phone-call.png")));
        icon.setBounds(715, 211, 40, 40);
        bgg.add(icon);
//            email Label
        label3 = new JLabel("Phone");
        label3.setBounds(750, 220, 300, 25);
        label3.setFont(label3.getFont().deriveFont(20f));
        label3.setForeground(Color.black);

        bgg.add(label3);
//            field
        text2 = new JTextField();
        text2.setBounds(715, 250, 300, 25);
        text2.setText("Phone");
        text2.setOpaque(false);
        text2.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.black));
        text2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(text2.getText().equals("Phone")){
                    text2.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(text2.getText().equals("")){
                    text2.setText("Phone");
                }
            }
        });
        bgg.add(text2);
////
        JLabel icon1 = new JLabel((new ImageIcon("public\\icon\\id-card.png")));
        icon1.setBounds(715, 271, 40, 40);
        bgg.add(icon1);
        label4 = new JLabel("Username");
        label4.setBounds(750, 280, 300, 25);
        label4.setFont(label4.getFont().deriveFont(20f));
        label4.setForeground(Color.black);
        bgg.add(label4);


        text3 = new JTextField();
        text3.setBounds(715, 310, 300, 25);
        text3.setOpaque(false);
        text3.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.black));
        text3.setText("Username");
        text3.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(text3.getText().equals("Username")){
                    text3.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(text3.getText().equals("")){
                    text3.setText("Username");
                }
            }
        });
        bgg.add(text3);
////
        JLabel icon2 = new JLabel((new ImageIcon("public\\icon\\password.png")));
        icon2.setBounds(715, 331, 40, 40);
        bgg.add(icon2);
//            label
        label5 = new JLabel("Password");
        label5.setBounds(750, 340, 300, 25);
        label5.setFont(label5.getFont().deriveFont(20f));
        label5.setForeground(Color.black);
        bgg.add(label5);
//            field
        text4 = new JPasswordField();
        text4.setBounds(715, 370, 300, 25);
        text4.setText("Password");
        text4.setOpaque(false);
        text4.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.black));
        text4.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(text4.getText().equals("Password")){
                    text4.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(text4.getText().equals("")){
                    text4.setText("Password");
                }
            }
        });
        bgg.add(text4);
//
        check = new JCheckBox("Show");
        check.setForeground(Color.BLACK);
        check.setBounds(1030, 370, 100, 25);
        check.setOpaque(false);
        bgg.add(check);

        JLabel icon3 = new JLabel((new ImageIcon("public\\icon\\password.png")));
        icon3.setBounds(715, 391, 40, 40);
        bgg.add(icon3);
        label6 = new JLabel("Confirm Password");
        label6.setBounds(750, 400, 300, 25);
        label6.setFont(label6.getFont().deriveFont(20f));
        label6.setForeground(Color.black);
        bgg.add(label6);
        text5 = new JPasswordField();
        text5.setBounds(715, 430, 300, 25);
        text5.setText("Confirm Password");
        text5.setOpaque(false);
        text5.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.black));
        text5.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(text5.getText().equals("Confirm Password")){
                    text5.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(text5.getText().equals("")){
                    text5.setText("Confirm Password");
                }
            }
        });
        bgg.add(text5);
//
        check1 = new JCheckBox("Show");
        check1.setForeground(Color.black);
        check1.setBounds(1030, 430, 100, 25);
        check1.setOpaque(false);
        bgg.add(check1);

        button = new JButton("Sign Up");
        button.setForeground(Color.WHITE);
        button.setBackground(Color.blue);
        button.setFocusable(false);
        button.setCursor(new Cursor(Cursor. HAND_CURSOR));
        button.setBounds(750, 500, 100, 25);
        bgg.add(button);



        button1 = new JButton("Back");
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.blue);
        button1.setFocusable(false);
        button1.setCursor(new Cursor(Cursor. HAND_CURSOR));
        button1.setBounds(950, 500, 100, 25);
        button1.setBorder(BorderFactory.createRaisedBevelBorder());
        bgg.add(button1);

        bgg.add(bgg1);
        bgg.add(bggLogo);
        bgg.add(bggfood);

    }
    public void back(ActionEvent e){
        if (e.getSource().equals(button1)){
            this.setVisible(false);
            new AdminLoginForm().setVisible(true);
        }

    }

    void handAction(){

        button.addActionListener(this);
        check.addActionListener(this::checkboxActionPerformed);
        check1.addActionListener(this::checkboxActionPerformed);
        button1.addActionListener(this::back);

    }



    @Override
    public void actionPerformed (ActionEvent e) {


        String fullname = text1.getText();
        String email = text2.getText();
        String username = text3.getText();
        String password = text4.getText();
        String gender;
        if (radioMale.isSelected()) {
            gender = "Male";
        }
        else if (radioFemale.isSelected()) {
            gender = "Female";
        }

        else{
            gender = "Other";
        }

        String EmailPattern = "([0-9]{10})";
        Pattern.compile(EmailPattern);
        String PasswordPattern = "[[a-zA-z]*[0-9]+[a-zA-Z]*[0-9]*]{6,12}";
        Pattern.compile(PasswordPattern);

        if (e.getSource().equals(button)) {

            if ((fullname.isBlank() || fullname.equals("Fullname")) && (email.isBlank() || email.equals("Phone"))
                    && (username.isBlank() || username.equals("Username"))) {

                JOptionPane.showMessageDialog(null, "Please Fill All \nThe Details Below");

            } else if (fullname.isBlank() || fullname.equals("Fullname")) {
                JOptionPane.showMessageDialog(null, "Please Enter Your FullName");

            } else if (!radioMale.isSelected() && !radioFemale.isSelected() && !radioOther.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please Select Your Gender");

            } else if (email.isBlank() || email.equals("Phone")) {
                JOptionPane.showMessageDialog(null, "Please Enter Your Phone");

            } else if (!(email.matches(EmailPattern))) {
                JOptionPane.showInternalMessageDialog(null, "Please Enter valid Phone!");
            } else if (username.isBlank() || username.equals("Username")) {
                JOptionPane.showMessageDialog(null, "Please Enter Your Username");

            } else if ((password.isBlank() || password.equals("Password"))) {
                JOptionPane.showMessageDialog(null, "Please Enter Your Password");

            } else if (!(password.matches(PasswordPattern))) {

                JOptionPane.showInternalMessageDialog(null, "Your password must contain\n 6 to 14 characters including a number");
            } else if (!(text4.getText()).equals((text5.getText()))) {
                JOptionPane.showMessageDialog(null, "Your Password Does not Match");

            } else {
                AdminModel adminModel = new AdminModel(fullname, gender, email, username, password);
                AdminController adminController = new AdminController();
                int insert = adminController.adminRegistration(adminModel);

                if (insert > 0) {
                    JOptionPane.showMessageDialog(null, "Your Account Has Been \nRegistered!!");
                    dispose();
                    new AdminLoginForm().setVisible(true);
                    JOptionPane.showMessageDialog(null, "Please Login Now");
                }}}}

        public void checkboxActionPerformed (java.awt.event.ActionEvent evt){
            if (check.isSelected()) {
                text4.setEchoChar((char) 0);
            } else {
                text4.setEchoChar('*');
            }

            if (check1.isSelected()) {
                text5.setEchoChar((char) 0);
            } else {
                text5.setEchoChar('*');
            }
        }


}