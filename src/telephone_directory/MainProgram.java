/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telephone_directory;


import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class MainProgram extends JFrame {

    Container ct;
    JMenuBar bar;
    JMenu f1,f2,f3;
    JMenuItem m1,m2,m3,m4,m5,m6,m7,m8,m9,m10;
    
    CardLayout CL;
    
    Admin ad;
    Employee emp;
    Login log;
    Manage_admin mad;
    Manage_emp memp;
    Update_directory upser;
    Customer cus;
    Search ser;
    Welcome wel;
    
    public MainProgram()
    {
        ct=getContentPane();
        
        ad=new Admin() ;
        emp=new Employee();
        log=new Login();
        mad=new Manage_admin();
        memp= new Manage_emp();
        upser= new Update_directory();
        cus= new Customer();
        ser= new Search();
        wel= new Welcome();
        
        bar=new JMenuBar();
        f1=new JMenu("Home");
        f2=new JMenu("Admin");
        f3=new JMenu("Employee");
        
        m1=new JMenuItem("Welcome");
        m2=new JMenuItem("Login");
        m3=new JMenuItem("Exit");
        
        m4=new JMenuItem("Add Admin");
        m5=new JMenuItem("Update Admin");
        m6=new JMenuItem("Add Employee");
        m7=new JMenuItem("Update Employee");
        
        m8=new JMenuItem("Insert");
        m9=new JMenuItem("Search");
        m10=new JMenuItem("Update Directory");
        
        CL = new CardLayout();
        ct.setLayout(CL);
        setJMenuBar(bar);
        setSize(500,500);
        setVisible(true);
        //add menu
        bar.add(f1);
        bar.add(f2);
        bar.add(f3);
        
        //add menuitems
        f1.add(m1);
        //f1.addSeparator();
        f1.add(m2);
        f1.add(m3);
        
        f2.add(m4);
        f2.add(m5);
        f2.add(m6);
        f2.add(m7);
        
        f3.add(m8);
        f3.add(m9);
        f3.add(m10);
        //add panels
        ct.add(wel,"wel");
        ct.add(cus,"cus");
        ct.add(log,"log");
        ct.add(upser,"upser");
        ct.add(ser,"ser");
        ct.add(ad,"ad");
        ct.add(mad,"mad");
        ct.add(memp,"memp");
        ct.add(emp,"emp");
        
        m1.addActionListener(new A());
        m2.addActionListener(new A());
        m3.addActionListener(new A());
        m4.addActionListener(new A());
        m5.addActionListener(new A());
        m6.addActionListener(new A());
        m7.addActionListener(new A());
        m8.addActionListener(new A());
        m9.addActionListener(new A());
        m10.addActionListener(new A());
        
        //f2.setEnabled(false);
        //f3.setEnabled(false);
    }
    
    class A implements ActionListener
    {
        
    
    public void actionPerformed(ActionEvent e) {
        JMenuItem mt=(JMenuItem) e.getSource();
        if(mt==m1)
        {
            CL.show(ct, "wel");
        }
        else if(mt==m2)
        {
            CL.show(ct, "log");
        }
        else if(mt==m3)
        {
            System.exit(0);
        }else if(mt==m4)
        {
            CL.show(ct, "ad");
        }
        else if(mt==m5)
        {
            CL.show(ct, "mad");
        }
        else if(mt==m6)
        {
            CL.show(ct, "emp");
        }else if(mt==m7)
        {
            CL.show(ct, "memp");
        }
        else if(mt==m8)
        {
            CL.show(ct, "cus");
        }
        else if(mt==m9)
        {
            CL.show(ct, "ser");
        }else if(mt==m10)
        {
            CL.show(ct, "upser");
        }
        /*
        JButton bt=(JButton) e.getSource();
        if(bt==log.jButton1)
        {
            try
            {
                //String email=jTextField1.getText();
                Class.forName("com.mysql.jdbc.Driver");
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/directory","root","");
                String sql="select * from logindata where email=? and password=?";
                PreparedStatement p1=cn.prepareStatement(sql);
                p1.setString(1,log.jTextField1.getText());
                p1.setString(2,log.jTextField2.getText());
                ResultSet r1= p1.executeQuery();
                if(r1.next())
                {
                    JOptionPane.showMessageDialog(null, "LOgin Successful");
                    if("admin".equalsIgnoreCase(r1.getString("usertype")))
                    {
                        //m2.setLabel("Log Out");
                        f2.setEnabled(true);
                        //f3.setEnabled(true);
                    }else if("employee".equalsIgnoreCase(r1.getString("usertype")))
                    {
                        f3.setEnabled(true);
                        //m2.setLabel("Logout");
                    }
                }
            }catch(Exception t)
            {
                JOptionPane.showMessageDialog(null,""+e);
            }
        }
            
        */
    }
    }
    public static void main(String args[])
    {
        MainProgram obj=new MainProgram();
    }
    
}
