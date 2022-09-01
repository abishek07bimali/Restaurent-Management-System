//package view.Customer;
//
//import com.sbix.jnotify.NPosition;
//import com.sbix.jnotify.NoticeType;
//import com.sbix.jnotify.NoticeWindow;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//public class Notification extends JFrame {
//    JButton setting_emp;
//    Notification(){
//        initialize_dash_GUI();
//        hand();
//    }
//    public void initialize_dash_GUI(){
//        setTitle("Crescent RMS");
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setBounds(0,00,400,300);
//        setResizable(false);
//        setLayout(null);
//
//        setting_emp = new JButton("Notification");
//        setting_emp.setBounds(85, 30, 130,25);
//        setting_emp.setBackground(Color.black);
//        setting_emp.setFocusable(false);
//        setting_emp.setFont(new Font("times",Font.PLAIN,20));
//        setting_emp.setBorderPainted(false);
//        setting_emp.setForeground(Color.white);
//        add(setting_emp);
//
//    }
//    void hand(){
//        setting_emp.addActionListener(this::actionButton);
//    }
//    public void actionButton(ActionEvent event){
//        if(event.getSource().equals(setting_emp)){
//            new NoticeWindow(NoticeType.SUCCESS_NOTIFICATION,"Success",
//                    NoticeWindow.LONG_DELAY, NPosition.BOTTOM_LEFT);
//        }
//    }
//    public static void main(String[] args) {
//        new Notification().setVisible(true);
//    }
//}
//
