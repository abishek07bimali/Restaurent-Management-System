package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About_project_help extends JFrame{

    JButton next_btn,prev_btn;
    ImageIcon pic;
    JLabel piclabel;

    int a = 1;

    public About_project_help() {
        this.setBounds(200, 200, 700, 600);
        this.setTitle("Help - About");
        this.setResizable(false);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pic = new ImageIcon("public\\employee_help\\0" + a + ".jpg");
        piclabel = new JLabel(pic);

        // setting next  and  previous button
        next_btn = new JButton("Next");
//        next_btn.setLayout(SOUTH);
        next_btn.setBounds(400, 520, 100, 30);
        next_btn.setFocusable(false);

        prev_btn = new JButton("Previous");
        prev_btn.setBounds(200, 520, 100, 30);
        prev_btn.setFocusable(false);

        JPanel panel = new JPanel();
        this.add(panel);
//        panel.add(prev_btn);
//        panel.add(next_btn);
        panel.add(piclabel);
        // handaction
        prev_btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                if (a > 1) {
                    a = a - 1;
                    ImageIcon pic = new ImageIcon("public\\employee_help\\0"+a+".jpg");
                    piclabel.setIcon(pic);
                }else{
                    next_btn.getDisabledIcon();
                }
            }

        });


        next_btn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {


                if (a<6){
                    a = a + 1;
                    ImageIcon pic = new ImageIcon("public\\employee_help\\0"+a+".jpg");
                    piclabel.setIcon(pic);

                }
                else{
                    next_btn.getDisabledIcon();
                }
            }

        });


        pic_frame();
        this.setVisible(true);
    }

    void pic_frame(){

        add(next_btn);
        add(prev_btn);
        add(piclabel);


    }

}
