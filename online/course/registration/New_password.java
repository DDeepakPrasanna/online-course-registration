package online.course.registration;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class New_password implements ActionListener{
    
    JFrame f;
    JTextField t1,t2;
    JPasswordField t3;
    JLabel l1,l2,l3,l4;
    JButton b1,b2;
    
    New_password(String text){
        //various GUI components required
        f=new JFrame("New Password");

        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(40,20,100,30);
        f.add(l1);
        
        l3 = new JLabel("Code");
        l3.setBounds(40,70,100,30);
        f.add(l3);
        
        l2 = new JLabel("New Password");
        l2.setBounds(40,120,100,30);
        f.add(l2);
 
        t1=new JTextField();
        t1.setBounds(150,20,150,30);
        f.add(t1);
        t1.setText(text);

        t2=new JTextField();
        t2.setBounds(150,70,150,30);
        f.add(t2);
        
        t3=new JPasswordField();
        t3.setBounds(150,120,150,30);
        f.add(t3);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("online/course/registration/icons/icon5.png"));
        Image i2 = i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,20,150,150);
        f.add(l3);


        b1 = new JButton("Confirm");
        b1.setBounds(40,160,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        f.add(b1);
        
        b2 = new JButton("Login");
        b2.setBounds(180,160,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        f.add(b2);


        f.setVisible(true);
        f.setSize(600,300);
        f.setLocation(400,300);
    }
    
    public void actionPerformed(ActionEvent ae){
        //if button b1 i.e; Confirm button is clicked
        if(ae.getSource()==b1){
        f.setVisible(true);
      
        try{
            //connecting to database and updating new password to database
            conn c1 = new conn();
            String u = t1.getText();
            String v = t2.getText();
            String w = t3.getText();
            
            String q = "update login set login_password='"+w+"' where login_username='"+u+"' and login_id='"+v+"'";
            c1.s.executeUpdate(q); 
            JOptionPane.showMessageDialog(null,"successfully Changed Password");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
        //if button b2 i.e;Login button is clicked
        if(ae.getSource()==b2){
            f.setVisible(false);
            new login();
        }
}  
    public static void main(String args[]){
        New_password n = new New_password("text");
    }
}