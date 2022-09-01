package view.Employee;//package view.Employee;//package Employee;

import com.sbix.jnotify.NPosition;
import com.sbix.jnotify.NoticeType;
import com.sbix.jnotify.NoticeWindow;
import controller.EmployeeController;
import model.Attendance_model;
import model.Employee_model;
import view.Welcome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Employeelogin extends JFrame {
    JLabel  label1, label2,  label3, bgg;
    JTextField text1;
    JPasswordField text2;
    JCheckBox check;
    JButton button, button1,button2, back_btn;

    EmployeeController employeeController;
    Employee_model employee_model;
    public static int Cust_ID=0;


    public Employeelogin() {
        initialized();
        uiInitialize();
        handAction();

    }

    public void initialized() {
        setTitle("Employee Login Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(0, 0, 1280, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        Image icon = Toolkit.getDefaultToolkit().getImage("public\\logo.png");
        setIconImage(icon);

        bgg = new JLabel((new ImageIcon("public\\employee2.jpg")));
        bgg.setBounds(0, 0, 1280, 700);
        add(bgg);

    }
    public void uiInitialize() {
        label1 = new JLabel("Employee Login Page");
        label1.setBounds(400, 15, 500, 50);
        label1.setFont(label1.getFont().deriveFont(40f));
        label1.setForeground(Color.DARK_GRAY);
        bgg.add(label1);

        JLabel bggLogo = new JLabel((new ImageIcon("public\\logo.png")));
        bggLogo.setBounds(5, 5, 200, 150);
        bgg.add(bggLogo);

/*
        JLabel bggd = new JLabel((new ImageIcon("C:\\Users\\DELL\\Documents\\IdeaProjects\\OOPprojects\\src\\employee\\OIP(1).jpg")));
        bggd.setBounds(200, 100, 400, 440);
        bgg.add(bggd);

*/

        JLabel icon5 = new JLabel((new ImageIcon("public\\icon\\user.png")));
        icon5.setBounds(805, 131, 40, 40);
        bgg.add(icon5);

        label2 = new JLabel("Username");
        label2.setBounds(713, 140, 250, 25);
        label2.setFont(label2.getFont().deriveFont(20f));
        label2.setForeground(Color.black);
        bgg.add(label2);

        text1 = new JTextField();
        text1.setBounds(715, 170, 220, 25);
        text1.setText("Username");
        text1.setOpaque(false);
        text1.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.black));
        text1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(text1.getText().equals("Username")){
                    text1.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(text1.getText().equals("")){
                    text1.setText("Username");
                }
            }
        });
        bgg.add(text1);


        JLabel icon2 = new JLabel((new ImageIcon("public\\icon\\password.png")));
        icon2.setBounds(805, 231, 40, 40);
        bgg.add(icon2);

        label3 = new JLabel("Password");
        label3.setBounds(713, 240, 300, 25);
        label3.setFont(label3.getFont().deriveFont(20f));
        label3.setForeground(Color.black);
        bgg.add(label3);

        text2 = new JPasswordField("Password");
        text2.setBounds(715, 270, 220, 25);
        text2.setOpaque(false);
        text2.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.black));
        text2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(text2.getText().equals("Password")){
                    text2.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(text2.getText().equals("")){
                    text2.setText("Password");
                }
            }
        });
        bgg.add(text2);

        check = new JCheckBox("Show");
        check.setForeground(Color.BLACK);
        check.setBounds(940, 270, 100, 25);
        check.setOpaque(false);
        bgg.add(check);



        button2 = new JButton("Forgot Password?");
        button2.setForeground(Color.black);
        button2.setContentAreaFilled(false);
        button2.setBorderPainted(false);
        button2.setFocusable(false);
        button2.setCursor(new Cursor(Cursor. HAND_CURSOR));
        button2.setBounds(850, 300, 141, 18);
        bgg.add(button2);



        button1 = new JButton("Log In");
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.black);
        button1.setFocusable(false);
        button1.setCursor(new Cursor(Cursor. HAND_CURSOR));
        button1.setBounds(820, 370, 90, 30);
        bgg.add(button1);

        back_btn = new JButton(new ImageIcon("public\\bk_btn.png"));
        back_btn.setBounds(150, 110, 40, 40);
        back_btn.setOpaque(false);
        back_btn.setContentAreaFilled(false);
        back_btn.setBorderPainted(false);
        bgg.add(back_btn);

        bgg.add(bggLogo);
        setVisible(true);

    }
    void handAction(){

        button1.addActionListener(this::actionPerformed);
        check.addActionListener(this::ckboxActionerformed);
        button2.addActionListener(this::ForgetPassword);
        back_btn.addActionListener(this::back_Button);
    }
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(button1)){
            String t1 = text1.getText();
            String t2 = text2.getText();


            if ((t1.isBlank()||t1.equals("Username") )&& (t2.isBlank()|| t2.equals("Password")) ){
                JOptionPane.showMessageDialog(null,"Please Fill All \nThe Detail Below");
            }

            else if (t1.isBlank()) {
                JOptionPane.showMessageDialog(null,"Please Enter Username");

            }

            else if (t2.isBlank()) {
                JOptionPane.showMessageDialog(null, "Please Enter The password");
            }
            else{
                employeeController = new EmployeeController();
                employee_model = employeeController.loginAdminPreparedStatement(t1,t2);
                if (employee_model != null) {
                    Employeelogin.this.setVisible(false);
                    new Employee_Dashboard().setVisible(true);
                    new NoticeWindow(NoticeType.SUCCESS_NOTIFICATION,"New orders are there!!! ",
                    NoticeWindow.LONG_DELAY, NPosition.CENTER);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            }

//            ========Attandance for employeeee=============

            this.employeeController = new EmployeeController();
            this.employee_model = employeeController.fetchLoggedInEmployee();
            String date= new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(Calendar.getInstance().getTime());
            EmployeeController employeeController = new EmployeeController();
            Attendance_model attendance_model1 = new Attendance_model(employee_model.getName(),date);
            int update = employeeController.attendance(attendance_model1);
        }
    }

    public void back_Button(java.awt.event.ActionEvent e){
        if (e.getSource().equals(back_btn)){
            dispose();
            Welcome wel = new Welcome();
            wel.setVisible(true);
        }
    }

    public void ForgetPassword(java.awt.event.ActionEvent e){
        if (e.getSource().equals(button2)){
            dispose();
            EmployeeForgetPassword employeeForget=new EmployeeForgetPassword();
            employeeForget.setVisible(true);
        }
    }


    public void ckboxActionerformed(java.awt.event.ActionEvent evt){
        if (check.isSelected()) {
            text2.setEchoChar((char) 0);
        } else {

            text2.setEchoChar('*');

        }
    }

}
