package view.Admin;

import controller.EmployeeController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Attendance extends JFrame {
Color n;
    public static final String[] column = {
            "IdNo.","StaffName ", "Date"};
    private final DefaultTableModel model1 = new DefaultTableModel(column, 0);
    private final JTable table1= new JTable(model1);
    JPanel mainPanel1= new JPanel();
    Color b_c = new Color(0x212429);


    public  Attendance(){
    initialize_list_GUI();
    attandance();
    databaseAttandance();

}
    public void initialize_list_GUI() {
        setTitle("Attandance");
        setBounds(0, 0, 600, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setLocationRelativeTo(null);
        // Selecting color
        n = new Color(0x2E3337);
        getContentPane().setBackground(n);
        Image icon = Toolkit.getDefaultToolkit().getImage("public\\logo.png");
        setIconImage(icon);
    }
    public void attandance(){
        mainPanel1.setBounds(10,10,580,390);
        mainPanel1.setBackground(b_c);
        mainPanel1.setVisible(true);
        add(mainPanel1);
        //Add panels and table to the main panel
        table1.setBounds(100,10,560,370);
        table1.setMinimumSize(new Dimension(560,370));
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        mainPanel1.add(table1);
        JScrollPane sp1 =new JScrollPane(table1);
        mainPanel1.add(sp1);

        TableColumnModel tcm = table1.getColumnModel();
        tcm.getColumn(0).setPreferredWidth(70);     //Name
        tcm.getColumn(1).setPreferredWidth(200);    //Title
        tcm.getColumn(2).setPreferredWidth(200);    //Surname

    }
    void databaseAttandance(){
        EmployeeController employeeController=new EmployeeController();
        ResultSet resultSet= employeeController.extractintoTableAttandance();
        try{
            while(resultSet.next()){
                int id=resultSet.getInt("att_id");
                String name=resultSet.getString("name");
                String date=resultSet.getString("date");
                model1.addRow(new Object[]{
                        id,name,date
                });
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

}
