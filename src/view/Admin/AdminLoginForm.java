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

public class AdminLoginForm extends JFrame implements ActionListener {
    JLabel label1,label5,label4,bgg;
    JTextField text3;
    JPasswordField text4;
    JCheckBox check;
    JButton button,button1,button2, back_btn;
    AdminController adminController;
    AdminModel adminModel;
    Color n;
    public static int USER_ID=0;
    public  AdminLoginForm() {
        initialized();
        uiInitialize();
        register_code();
        handAction();
    }
    public void initialized() {
        setTitle("Login page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(150, 50, 1280, 700);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setSize(1280,700);

        Image icon = Toolkit.getDefaultToolkit().getImage("public\\logo.png");
        setIconImage(icon);

        bgg=new JLabel((new ImageIcon("public\\employee2.jpg")));
        bgg.setBounds(0,0,1280,700);
        add(bgg);
        setVisible(true);
    }

    public void uiInitialize () {
        label1 = new JLabel("Admin Login Here");
        label1.setBounds(720, 100, 500, 50);
        label1.setFont(label1.getFont().deriveFont(30f));
        label1.setForeground(Color.black);
        bgg.add(label1);

//
//            logo of restaurent
        JLabel bggLogo=new JLabel((new ImageIcon("public\\logo.png")));
        bggLogo.setBounds(5,5,200,150);
        bgg.add(bggLogo);
        JLabel profile=new JLabel((new ImageIcon("public\\icon\\profile.png")));
        profile.setBounds(800,140,80,80);
        bgg.add(profile);
        JLabel icon1=new JLabel((new ImageIcon("public\\icon\\id-card.png")));
        icon1.setBounds(715,211,40,40);
        bgg.add(icon1);


        label4 = new JLabel("Username");
        label4.setBounds(750, 220, 300, 25);
        label4.setFont(label4.getFont().deriveFont(20f));
        label4.setForeground(Color.black);
        bgg.add(label4);
        text3 = new JTextField();
        text3.setBounds(715, 250, 220, 25);
        text3.setText("Username");
        text3.setOpaque(false);
        text3.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.black));
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
        JLabel icon2=new JLabel((new ImageIcon("public\\icon\\password.png")));
        icon2.setBounds(715,281,40,40);
        bgg.add(icon2);
        label5 = new JLabel("Password");
        label5.setBounds(750, 290, 300, 25);
        label5.setFont(label5.getFont().deriveFont(20f));
        label5.setForeground(Color.black);
        bgg.add(label5);
        text4 = new JPasswordField();
        text4.setBounds(715, 320, 220, 25);
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
        check=new JCheckBox("Show");
        check.setForeground(Color.BLACK);
        check.setBounds(940,320,100,25);
        check.setOpaque(false);
        bgg.add(check);


        button=new JButton("LogIn");
        button.setForeground(Color.WHITE);
        button.setBackground(Color.blue);
        button.setCursor(new Cursor(Cursor. HAND_CURSOR));
        button.setFocusable(false);
        button.setBounds(740,430,100,25);
        button.setBorder(BorderFactory.createRaisedBevelBorder());
        bgg.add(button);

        button2 = new JButton("Forgot Password?");
        button2.setForeground(Color.black);
        button2.setContentAreaFilled(false);
        button2.setBorderPainted(false);
        button2.setFocusable(false);
        button2.setCursor(new Cursor(Cursor. HAND_CURSOR));
        button2.setBounds(855, 355, 141, 18);
        bgg.add(button2);

        button1=new JButton("Register");
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.blue);
        button1.setFocusable(false);
        button1.setCursor(new Cursor(Cursor. HAND_CURSOR));
        button1.setBounds(890,430,100,25);
        button1.setBorder(BorderFactory.createRaisedBevelBorder());
        bgg.add(button1);
        bgg.add(bggLogo);

        back_btn = new JButton(new ImageIcon("public\\bk_btn.png"));
        back_btn.setBounds(150, 110, 40, 40);
        back_btn.setOpaque(false);
        back_btn.setContentAreaFilled(false);
        back_btn.setBorderPainted(false);
        bgg.add(back_btn);
    }
    void handAction(){

        button1.addActionListener(this::Register);
        check.addActionListener(this::ckboxActionerformed);
        button2.addActionListener(this::ForgetPassword);
        button.addActionListener(this);
        back_btn.addActionListener(this::back_Button);


    }

//    JFrame reg_code;
JFrame reg_code = new JFrame();
    public void register_code(){

        reg_code.setTitle("Enter code");
        reg_code.setBounds(150, 50, 400, 200);
        reg_code.setResizable(false);
        reg_code.setLayout(null);
        reg_code.setLocationRelativeTo(null);

        // Selecting color
        n = new Color(0x2E3337);
//        b_c = new Color(0x212429);
        reg_code.setBackground(n);

        JLabel ent_code = new JLabel("Enter code");
        ent_code.setBounds(10,50,150,40);
        ent_code.setForeground(Color.BLACK);
        ent_code.setFont(new Font("times",Font.PLAIN,25));
        reg_code.add(ent_code);

        JTextField check_code = new JTextField("enter code");
        check_code.setBounds(200, 50, 150, 40);
        check_code.setOpaque(false);
        check_code.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.black));
        check_code.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(check_code.getText().equals("enter code")){
                    check_code.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(check_code.getText().equals("")){
                    check_code.setText("enter code");
                }
            }
        });
        reg_code.add(check_code);

        JButton check_btn = new JButton("Verify");
        check_btn.setBounds(100,110,120,40);
        check_btn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(check_btn)){
                    if (check_code.getText().equals("123123")){
                        reg_code.dispose();
                        setVisible(false);
                        new AdminRegistration().setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null,"To register please enter the correct\n " +
                                " registration code");
                    }
                }
            }
        });
        reg_code.add(check_btn);
    }


    public void Register(ActionEvent e){
        if (e.getSource().equals(button1)){
            reg_code.setVisible(true);

        }
    }

    public void back_Button(java.awt.event.ActionEvent e){
        if (e.getSource().equals(back_btn)){
            dispose();
            Welcome wel = new Welcome();
            wel.setVisible(true);
        }
    }
    public void ForgetPassword(ActionEvent e){
        if (e.getSource().equals(button2)){
            this.setVisible(false);
            new AdminForget().setVisible(true);
        }

    }
    public void ckboxActionerformed(java.awt.event.ActionEvent evt){
        if (check.isSelected()) {
            text4.setEchoChar((char) 0);

        } else {
            text4.setEchoChar('*');

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String usern = text3.getText();
        String passwd = text4.getText();
        if (e.getSource().equals(button)){

            if((usern.isBlank()||usern.equals("Username")&&(passwd.isBlank()||passwd.equals("Password")))){
                JOptionPane.showMessageDialog(null,"Please Enter Your Username and Password");

            }
            else if (usern.isBlank()||usern.equals("Username")){
                JOptionPane.showMessageDialog(null,"Please Enter Your Username");
            }

            else if (passwd.isBlank()||passwd.equals("Password")){
                JOptionPane.showMessageDialog(null,"Please Enter Your Password");
            }

            else{
                adminController = new AdminController();
                adminModel = adminController.loginAdminPreparedStatement(usern,passwd);
                if (adminModel != null) {
                    AdminLoginForm.this.setVisible(false);
                    new Admin_dashboard().setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            }
        }
    }


}

