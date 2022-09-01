package view.Admin;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import controller.AdminController;
import model.AdminModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Random;
import java.util.regex.Pattern;


public class AdminForget extends JFrame {
    JLabel label1, label2, label4, label5, bgg, label6;
    JTextField text1, text4;
    JPasswordField text5, text6;
    JCheckBox check, check1;
    JButton button;
    static JButton button1,back;
    Otp onetime= new Otp();
    int pass=onetime.generatePassword();
    AdminController adminController;
    AdminModel adminModel;
    public static int USER_ID=0;

    AdminForget() {
//        dark();
        initialized();
        uiInitialize();
        handAction();
    }

    public void initialized() {
        setTitle("Recover Your Password");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(0, 0, 1290, 700);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);

        Image icon = Toolkit.getDefaultToolkit().getImage("public\\logo.png");
        setIconImage(icon);
        bgg=new JLabel((new ImageIcon("public\\bgg1.png")));
        bgg.setBounds(0,0,1290,700);
        add(bgg);
        setVisible(true);

    }

    public void uiInitialize() {
        label1 = new JLabel("Reset Your Password");
        label1.setBounds(730, 115, 350, 50);
        label1.setFont(label1.getFont().deriveFont(30f));
        label1.setForeground(Color.BLACK);
        bgg.add(label1);
//        add(label1);


        JLabel icon5 = new JLabel((new ImageIcon("public\\icon\\phone-call.png")));
        icon5.setBounds(750, 181, 40, 40);
        bgg.add(icon5);
        label2 = new JLabel("Phone");
        label2.setBounds(785, 190, 300, 25);
        label2.setFont(label2.getFont().deriveFont(20f));
        label2.setForeground(Color.black);
        bgg.add(label2);
//            field
        text1 = new JTextField();
        text1.setBounds(750, 220, 300, 25);
        text1.setText("Phone");
        text1.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.black));
        text1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (text1.getText().equals("Phone")) {
                    text1.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (text1.getText().equals("")) {
                    text1.setText("Phone");
                }
            }
        });
        bgg.add(text1);


        JLabel icon2 = new JLabel((new ImageIcon("public\\icon\\user.png")));
        icon2.setBounds(750, 241, 40, 40);
        bgg.add(icon2);
//            label
        label4 = new JLabel("Username");
        label4.setBounds(785, 250, 300, 25);
        label4.setFont(label4.getFont().deriveFont(20f));
        label4.setForeground(Color.black);
        bgg.add(label4);
//            fiel5
        text4 = new JTextField();
        text4.setBounds(750, 280, 300, 25);
        text4.setText("Username");
        text4.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.black));
        text4.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (text4.getText().equals("Username")) {
                    text4.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (text4.getText().equals("")) {
                    text4.setText("Username");
                }
            }
        });
        bgg.add(text4);


//        New Password

        JLabel icon3 = new JLabel((new ImageIcon("public\\icon\\password.png")));
        icon3.setBounds(750, 301, 40, 40);
        bgg.add(icon3);
//            label
        label5 = new JLabel("New Password");
        label5.setBounds(785, 310, 300, 25);
        label5.setFont(label5.getFont().deriveFont(20f));
        label5.setForeground(Color.black);

        bgg.add(label5);
//            field
        text5 = new JPasswordField();
        text5.setBounds(750, 340, 300, 25);
        text5.setText("New Password");
        text5.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.black));
        text5.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (text5.getText().equals("New Password")) {
                    text5.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (text5.getText().equals("")) {
                    text5.setText("New Password");
                }
            }
        });
        bgg.add(text5);

        check1 = new JCheckBox("Show");
        check1.setForeground(Color.BLACK);
        check1.setBounds(1050, 400, 100, 25);
        check1.setOpaque(false);
        bgg.add(check1);

        //        confirm Password
        JLabel icon4 = new JLabel((new ImageIcon("public\\icon\\password.png")));
        icon4.setBounds(750, 361, 40, 40);
        bgg.add(icon4);
//            label
        label6 = new JLabel("OTP");
        label6.setBounds(785, 370, 300, 25);
        label6.setFont(label5.getFont().deriveFont(20f));
        label6.setForeground(Color.black);
        bgg.add(label6);
//            field
        text6 = new JPasswordField();
        text6.setBounds(750, 400, 300, 25);
        text6.setText("OTP");
        text6.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.black));
        text6.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (text6.getText().equals("OTP")) {
                    text6.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (text6.getText().equals("")) {
                    text6.setText("OTP");
                }
            }
        });
        bgg.add(text6);


// button to reset
        button = new JButton(" Reset Password ");
        button.setForeground(Color.WHITE);
        button.setBackground(Color.blue);
        button.setBounds(780, 450, 120, 25);
        button.setBorder(BorderFactory.createRaisedBevelBorder());
        button.setFocusable(false);
        bgg.add(button);


        back = new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.blue);
        back.setBounds(10, 10, 100, 25);
        back.setBorder(BorderFactory.createRaisedBevelBorder());
        back.setFocusable(false);
        bgg.add(back);

        button1 = new JButton("Verify");
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.blue);
        button1.setBounds(940, 450, 100, 25);
        button1.setBorder(BorderFactory.createRaisedBevelBorder());
         button1.setFocusable(false);
        bgg.add(button1);
    }


    void handAction() {

        button.addActionListener(this::verifyOtp);
        check1.addActionListener(this::ckbox1Actionerformed);
        button1.addActionListener(this::actionPerformedForget);
        back.addActionListener(this::backAction);

    }

    public void SendOTP(){
        try{

            String ACCOUNT_SID = "AC1bf73b3e7fd23f099f5f83dfebab7978";
            String AUTH_TOKEN = "3b0fe0bcbb00ae7ceeb6b71f91a12435";
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            String num = text1.getText();

            Message message = Message.creator(
                            new com.twilio.type.PhoneNumber("+977" + num),
                            new com.twilio.type.PhoneNumber("+12056513866"),

                            "Your New OTP is : " + pass)
                    .create();
        }
        catch (Exception e){

        }
    }


    //    @Override
    public void actionPerformedForget(ActionEvent e) {


        String phone = text1.getText();
        String username = text4.getText();
        String t3 = text5.getText();
        String t4 = text6.getText();

        String PasswordPattern = "([a-zA-z]*[0-9]+[a-zA-Z]*[0-9]*)";
        Pattern.compile(PasswordPattern);

        if (e.getSource().equals(button1)) {
            if ((phone.isBlank() || phone.equals("Phone")) && (username.isBlank() || username.equals("Username"))
                    && (t3.isBlank() || t3.equals("New Password")) && (t4.isBlank() || t4.equals("OTP"))) {

                JOptionPane.showMessageDialog(null, "Please Fill All The Detail");
            } else if (phone.isBlank() || phone.equals("Phone")) {
                JOptionPane.showMessageDialog(null, "Please Enter the E-mail");
            } else if (username.isBlank() || username.equals("Username")) {
                JOptionPane.showMessageDialog(null, "Please Enter your Username");
            } else if (t3.isBlank() || t3.equals("New Password")) {
                JOptionPane.showMessageDialog(null, "Please Enter the Password!");
            } else if (!(t3.matches(PasswordPattern))) {
                JOptionPane.showInternalMessageDialog(null, "Your password must contain\n 6 to 14 characters including a number");
            }else {
                adminController = new AdminController();
                adminModel = adminController.Forgetpssword(phone,username);
                if (adminModel != null) {
                    SendOTP();
                    JOptionPane.showMessageDialog(null, "OTP has been Sent!!");
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Phone or Username");
                }

            }
        }
    }

    public void verifyOtp(java.awt.event.ActionEvent e){

        String phone = text1.getText();
        String username = text4.getText();

        String password = text5.getText();
        String otp = text6.getText();

        if(e.getSource().equals(button)) {
            if ((phone.isBlank() || phone.equals("Phone")) && (username.isBlank() || username.equals("Username"))
                    && (password.isBlank() || password.equals("New Password")) && (otp.isBlank() || otp.equals("OTP"))) {

                JOptionPane.showMessageDialog(null, "Please Verify First!!");
            } else if (text6.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Please enter the OTP");
            } else if ((Integer.parseInt(text6.getText())) == (pass)) {
                AdminController adminController = new AdminController();
                AdminModel adminModel1 = new AdminModel(adminModel.getAdminId(),password,username);
                int update = adminController.updateAdminPassword(adminModel1);
                if (update > 0) {
                    JOptionPane.showMessageDialog(null, "Successfully updated");
                    dispose();
                    new AdminLoginForm().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "OTP does not matched!");

                }
            }
        }}

    public void ckbox1Actionerformed(java.awt.event.ActionEvent evt) {
        if (check1.isSelected()) {
            text6.setEchoChar((char) 0);
            text5.setEchoChar((char) 0);
        } else {
            text6.setEchoChar('*');
            text5.setEchoChar('*');
        }
    }

    public void backAction(ActionEvent e){
        if (e.getSource().equals(back)){
            dispose();
            new AdminLoginForm().setVisible(true);
        }
    }
}

