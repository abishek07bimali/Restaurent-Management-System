package view.Admin;

import controller.AdminController;
import controller.OrderController;
import database.Dbconnection;
import model.AdminModel;
import model.OrderFood;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import view.Welcome;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class Graphs extends JFrame implements ActionListener {
    JLabel dash_icon,rectangle_dash, crms_Logo;
    Color n;
    JButton dashboard, add_employee_btn, staffList, statistics, product,setting, logOut,back_btn;
    JLabel total,total1,total2,total3;
    // Database
    Dbconnection db;
    AdminModel adminModel;
    AdminController adminController;

    JDatePickerImpl datePicker;

    OrderController orderController;
    OrderFood orderFood;
    OrderFood orderFood1;

    public Graphs(){
        this.adminController = new AdminController();
        this.adminModel = adminController.fetchLoggedInAdmin();

        this.orderController= new OrderController();
        this.orderFood1=orderController.fetchTotalsalesweekly();


        // initializing the GUI
        initialize_stats_GUI();
        // initialize elements
//        stats_GUI_elements();

        dashboard_side();
        menu_side();
        handAction();
        Newjframe();
        LineChart();
        Image icon = Toolkit.getDefaultToolkit().getImage("public\\logo.png");
        setIconImage(icon);
    }


    public void initialize_stats_GUI(){
        setTitle("Crescent RMS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(0,0,1280,700);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        // Selecting color
        n = new Color(0x2E3337);
        getContentPane().setBackground(n);
        setVisible(true);
    }

    public void dashboard_side() {

        // color selection for the button
        Color b_c = new Color(0x212429);

        // small profile icon
        JLabel small_profile = new JLabel(new ImageIcon("public\\chef_icon\\Small_profile.png"));
        small_profile.setBounds(900,10,50,50);
        add(small_profile);

        JLabel small_emp_title = new JLabel(adminModel.getFullName());
//        JLabel small_emp_title = new JLabel(adminModel.getFullName());
        small_emp_title.setBounds(955, 15, 140,40);
        small_emp_title.setFont(new Font("times",Font.BOLD,13));
        small_emp_title.setForeground(Color.white);
        add(small_emp_title);

//        JLabel staff_title = new JLabel("Statistics");
//        staff_title.setBounds(350,25,200,40);
//        staff_title.setFont(new Font("forte",Font.PLAIN,25));
//        staff_title.setForeground(Color.PINK);
//        add(staff_title);

        // label for dashboard
        rectangle_dash = new JLabel(new ImageIcon("public\\chef_icon\\Rectangle 47.png"));
        rectangle_dash.setBounds(0, 0, 250, 900);
        add(rectangle_dash);

        // adding logo to the dashboard label
        crms_Logo = new JLabel(new ImageIcon("public\\chef_icon\\Crescent_RMS_logo1.png"));
        crms_Logo.setBounds(20, 30, 200, 200);
        rectangle_dash.add(crms_Logo);

        // employee dashboard icon for button
        dash_icon = new JLabel(new ImageIcon("public\\icons\\profile.png"));
        dash_icon.setBounds(40,250,40,40);
        rectangle_dash.add(dash_icon);

        dash_icon = new JLabel(new ImageIcon("public\\icon\\profile.png"));
        dash_icon.setBounds(40,300,40,40);
        rectangle_dash.add(dash_icon);

        dash_icon = new JLabel(new ImageIcon("public\\icons\\staff_list.png"));
        dash_icon.setBounds(40,350,40,40);
        rectangle_dash.add(dash_icon);

        dash_icon = new JLabel(new ImageIcon("public\\icons\\stat.png"));
        dash_icon.setBounds(40,400,40,40);
        rectangle_dash.add(dash_icon);

        dash_icon = new JLabel(new ImageIcon("public\\icons\\product_list.png"));
        dash_icon.setBounds(40,450,40,40);
        rectangle_dash.add(dash_icon);

        dash_icon = new JLabel(new ImageIcon("public\\icons\\settings.png"));
        dash_icon.setBounds(40,500,40,40);
        rectangle_dash.add(dash_icon);

        dash_icon = new JLabel(new ImageIcon("public\\icons\\logout.png"));
        dash_icon.setBounds(40,550,40,40);
        rectangle_dash.add(dash_icon);


        // button for dashboard
        dashboard = new JButton("Dashboard");
        dashboard.setBounds(85, 255, 140, 25);
        dashboard.setFont(new Font("times", Font.PLAIN, 20));
        dashboard.setBackground(b_c);
        dashboard.setBorderPainted(false);
        dashboard.setForeground(Color.white);
        dashboard.setFocusable(false);
        dashboard.setCursor(new Cursor(Cursor. HAND_CURSOR));
        rectangle_dash.add(dashboard);

        add_employee_btn = new JButton("Add Staff");
        add_employee_btn.setBounds(85, 305, 140, 25);
        add_employee_btn.setFont(new Font("times", Font.PLAIN, 20));
        add_employee_btn.setBackground(b_c);
        add_employee_btn.setBorderPainted(false);
        add_employee_btn.setForeground(Color.white);
        add_employee_btn.setFocusable(false);
        add_employee_btn.setCursor(new Cursor(Cursor. HAND_CURSOR));
        rectangle_dash.add(add_employee_btn);

        staffList = new JButton("Staff List");
        staffList.setBounds(85, 355, 130, 25);
        staffList.setFont(new Font("times", Font.PLAIN, 20));
        staffList.setBackground(b_c);
        staffList.setBorderPainted(false);
        staffList.setForeground(Color.white);
        staffList.setFocusable(false);
        staffList.setCursor(new Cursor(Cursor. HAND_CURSOR));
        rectangle_dash.add(staffList);

        statistics = new JButton("Statistics");
        statistics.setBounds(85, 405, 130, 25);
        statistics.setFont(new Font("times", Font.PLAIN, 20));
        statistics.setBackground(Color.white);
        statistics.setBorderPainted(false);
        statistics.setForeground(Color.pink);
        statistics.setFocusable(false);
        statistics.setCursor(new Cursor(Cursor. HAND_CURSOR));
        rectangle_dash.add(statistics);

        product = new JButton("Products");
        product.setBounds(85, 455, 130, 25);
        product.setFont(new Font("times", Font.PLAIN, 20));
        product.setBackground(b_c);
        product.setBorderPainted(false);
        product.setForeground(Color.white);
        product.setFocusable(false);
        product.setCursor(new Cursor(Cursor. HAND_CURSOR));
        rectangle_dash.add(product);

        setting = new JButton("Setting");
        setting.setBounds(85, 505, 130,25);
        setting.setFont(new Font("times",Font.PLAIN,20));
        setting.setBackground(b_c);
        setting.setBorderPainted(false);
        setting.setForeground(Color.white);
        setting.setFocusable(false);
        setting.setCursor(new Cursor(Cursor. HAND_CURSOR));
        rectangle_dash.add(setting);

        logOut = new JButton("Log Out");
        logOut.setBounds(85, 555, 130, 25);
        logOut.setFont(new Font("times", Font.PLAIN, 20));
        logOut.setBackground(b_c);
        logOut.setBorderPainted(false);
        logOut.setForeground(Color.white);
        logOut.setFocusable(false);
        logOut.setCursor(new Cursor(Cursor. HAND_CURSOR));
        rectangle_dash.add(logOut);

        back_btn = new JButton(new ImageIcon("public\\backBtn (1).png"));
        back_btn.setBounds(10, 5, 45, 45);
        back_btn.setOpaque(false);
        back_btn.setContentAreaFilled(false);
        back_btn.setBorderPainted(false);
        rectangle_dash.add(back_btn);

    }
    public void Newjframe(){
        Color b_c = new Color(0x6380AD);

        JPanel jpanel=new JPanel();
        jpanel.setBounds(1050,170,180,100);
        jpanel.setBackground(b_c);
        jpanel.setVisible(true);
        add(jpanel);

        JPanel jpanel1=new JPanel();
        jpanel1.setBounds(1050,300,180,100);
        jpanel1.setBackground(b_c);
        jpanel1.setVisible(true);
        add(jpanel1);


        total=new JLabel(" Weekly Total ");
        total.setBounds(20,10,100,40);
        total.setFont(new Font("DIALOG_INPUT",Font.BOLD,25));
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        total.setBorder(border);
        total.setForeground(Color.black);
        jpanel.add(total);

        total1=new JLabel(String.valueOf(orderFood1.getTotalsales()));
        total1.setBounds(10,15,100,40);
        total1.setFont(new Font("DIALOG_INPUT",Font.BOLD,25));
        total.setBackground(Color.WHITE);
        total1.setForeground(Color.black);
        jpanel.add(total1);


        total2=new JLabel(" Daily Total ");
        total2.setBounds(20,10,100,40);
        total2.setFont(new Font("DIALOG_INPUT",Font.BOLD,28));
        Border border1 = BorderFactory.createLineBorder(Color.BLACK, 2);
        total2.setBorder(border);
        total2.setForeground(Color.black);
        jpanel1.add(total2);

        total3=new JLabel(String.valueOf(stats_GUI_elements()));
        total3.setBounds(10,15,100,40);
        total3.setFont(new Font("DIALOG_INPUT",Font.BOLD,25));
        total3.setForeground(Color.black);
        jpanel1.add(total3);


    }
    public void menu_side(){
        JLabel staff_title = new JLabel(" Statistics");
        staff_title.setBounds(350,30,200,40);
        staff_title.setFont(new Font("forte",Font.PLAIN,25));
        staff_title.setForeground(Color.PINK);
        add(staff_title);
        rectangle_dash = new JLabel(new ImageIcon("public\\chef_icon\\Rectangle 47.png"));
        rectangle_dash.setBounds(0,0,250,900);
        add(rectangle_dash);

    }

    public int stats_GUI_elements(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int daily_total = 0;
            Calendar cal = Calendar.getInstance();
            Date todate1 = cal.getTime();
            String fromdate = dateFormat.format(todate1);
            ResultSet rs = new OrderController().daily_total(fromdate);
            try {
                while (rs.next()) {
                    int total = rs.getInt("totalsales");
                    daily_total = daily_total + total;
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        return daily_total;
    }

    private CategoryDataset createDatasets() {
        var dataset = new DefaultCategoryDataset();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/dd");
        int count = 7;
        while ((count > -1)) {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -count);
            Date todate1 = cal.getTime();
            String fromdate = dateFormat.format(todate1);
            String setdate = dateFormat1.format(todate1);
            ResultSet rs = new OrderController().daily_total(fromdate);
            int daily_total = 0;
            try {
                while (rs.next()) {
                    int total = rs.getInt("totalsales");
                    daily_total = daily_total + total;
                }
                dataset.addValue(daily_total,"Daily Sales",setdate);
            }catch (Exception e){
                e.printStackTrace();
            }
            count--;

        }

        return dataset;
    }


    public void LineChart(){
        CategoryDataset datasets = createDatasets();

        //Create chart
        JFreeChart chart= ChartFactory.createLineChart(
                "Daily sales", //Chart Title
                "Date",// Category axis
                "Sales", // Value axis
                datasets,
                PlotOrientation.VERTICAL,
                true,true,false
        );

        final CategoryPlot plot = (CategoryPlot) chart.getPlot();
        //CUSTOMIZE THE RENDERER
        final LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();



        //  renderer.setDrawShapes(true);
        renderer.setBaseShapesFilled(true);
        renderer.setBaseShapesVisible(true);

        Stroke stroke = new BasicStroke(1f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        renderer.setBaseOutlineStroke(stroke);


        chart.setBackgroundPaint(new Color(0,255,51,0));

        ChartPanel panel=new ChartPanel(chart);
        panel.setBounds(300,180,600,350);
        add(panel);
    }


    void handAction(){
        dashboard.addActionListener(this);
        add_employee_btn.addActionListener(this);
        staffList.addActionListener(this);
        statistics.addActionListener(this);
        setting.addActionListener(this);
        product.addActionListener(this);
        logOut.addActionListener(this);
        back_btn.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(dashboard)){
            Graphs.this.setVisible(false);
            Admin_dashboard adm = new Admin_dashboard();
            adm.setVisible(true);

        }
        else if (e.getSource().equals(add_employee_btn)){
            Graphs.this.setVisible(false);
            Adding_employee add_btn = new Adding_employee();
            add_btn.setVisible(true);
//            JOptionPane.showMessageDialog(null,"Orders In Development Process");
        }
        else if (e.getSource().equals(staffList)){
            Graphs.this.setVisible(false);
            Staff_list staffList_btn = new Staff_list();
            staffList_btn.setVisible(true);
        }
        else if (e.getSource().equals(statistics)){
            new Graphs().setVisible(true);
        }
        else if (e.getSource().equals(product)){
            Graphs.this.setVisible(false);
            Product_Inventory product_btn = new Product_Inventory();
            product_btn.setVisible(true);
        }
        else if (e.getSource().equals(setting)){
            Graphs.this.setVisible(false);
            new Admin_setting(new AdminModel()).setVisible(true);

        }
        else if (e.getSource().equals(logOut)){
            String[] options = {"Yes", "No"};
            int jk = JOptionPane.showOptionDialog(null,"Do You Want To Logout??",
                    "Yes or No",JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null,options,options[0]);

            if(jk == 0){
                Graphs.this.setVisible(false);
                Welcome well = new Welcome();
                well.setVisible(true);
            }

        }else if(e.getSource().equals(back_btn)) {
            Graphs.this.setVisible(false);
            Admin_dashboard back = new Admin_dashboard();
            back.setVisible(true);
        }

    }

}
