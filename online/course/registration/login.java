package online.course.registration;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class login  implements ActionListener{

    JFrame f;
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2,b3;

    login(){

        f=new JFrame("Login");

        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(40,20,100,30);
        f.add(l1);
        
        l2 = new JLabel("Password");
        l2.setBounds(40,70,100,30);
        f.add(l2);
        
       
 
        t1=new JTextField();
        t1.setBounds(150,20,150,30);
        f.add(t1);

        t2=new JPasswordField();
        t2.setBounds(150,70,150,30);
        f.add(t2);
        
       
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("online/course/registration/icons/login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,20,150,150);
        f.add(l3);


        b1 = new JButton("Login");
        b1.setBounds(40,160,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        f.add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,160,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        f.add(b2);
        b2.addActionListener(this);
        
        b3=new JButton("Forgot Password");
        b3.setBounds(110,200,150,30);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        f.add(b3);
        b3.addActionListener(this);
        
        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);
        f.setSize(600,300);
        f.setLocation(400,300);

    }

    public void actionPerformed(ActionEvent ae){

        try{
            //connecting to database and verifying the login details
            conn c1 = new conn();
            String u = t1.getText();
            String v = t2.getText();
            
            String q = "select * from login where login_username='"+u+"' and login_password='"+v+"'";
            
            ResultSet rs = c1.s.executeQuery(q); 
            if(rs.next()){
                new details().f.setVisible(true);
                f.setVisible(false);
            }else if(ae.getSource()==b3){
                f.setVisible(false);
                new Forgot_Password();
              }
            else {
                JOptionPane.showMessageDialog(null, "Invalid login");
                f.setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public static void main(String[] arg){
        login l=new login();
    }
}