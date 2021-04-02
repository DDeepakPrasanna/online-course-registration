package online.course.registration;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Forgot_Password implements ActionListener{
JFrame f;
JTextField t;
JLabel l1,l2;
JButton b1,b2;


Forgot_Password()
{
        //various GUI components required
        f=new JFrame("Forgot Password");

        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(40,20,100,30);
        f.add(l1);
        
 
        t=new JTextField();
        t.setBounds(150,20,150,30);
        f.add(t);

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("online/course/registration/icons/forgot_password.png"));
        Image i2 = i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(350,20,150,150);
        f.add(l2);


        b1 = new JButton("Old Password");
        b1.setBounds(40,140,150,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        f.add(b1);
        
        b2 = new JButton("New Password");
        b2.setBounds(40,190,150,30);
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
    //if button b1 i.e;Old Password button is clicked
         if(ae.getSource()==b1){
        f.setVisible(false);
        new Old_password(t.getText());
   }
         //if button b2 i.e;New Password button is clicked
   if(ae.getSource()==b2){
        f.setVisible(false);
        new New_password(t.getText());
    }
}
public static void main(String[]args){
    Forgot_Password f=new Forgot_Password();
    }
}