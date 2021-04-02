package online.course.registration;

import java.awt.*;
import javax.swing.*;
import java.lang.Thread;
import java.awt.event.*;

public class firstpage  implements ActionListener{
    JFrame f;
    JLabel id,ll;
    JButton b1,b2,b3,b4;
    
    firstpage(){
        f=new JFrame("Front");
        f.setBackground(Color.red);
        f.setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("online/course/registration/icons/front.jpg"));
        Image i2=i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel ll = new JLabel(i3);
        ll.setBounds(0,0,1300,1000);
        f.add(ll);
        
        b1 = new JButton("Register");
        b1.setBackground(Color.magenta);
        b1.setForeground(Color.black);
        b1.setFont(new Font("serif",Font.PLAIN,30));
        b1.setForeground(Color.black);
        
        b1.setBounds(800,130,200,70);
        b1.addActionListener(this);
        
        
        b2 = new JButton("Admin Login");
        b2.setBackground(Color.MAGENTA);
        b2.setForeground(Color.black);
        b2.setFont(new Font("serif",Font.PLAIN,30));
        b2.setForeground(Color.black);
        
        b2.setBounds(1050,130,200,70);
        b2.addActionListener(this);
        
        b3 = new JButton("View Course");
        b3.setBackground(Color.MAGENTA);
        b3.setForeground(Color.black);
        b3.setFont(new Font("serif",Font.PLAIN,30));
        b3.setForeground(Color.black);
        
        b3.setBounds(550,130,200,70);
        b3.addActionListener(this);
        
        b4 = new JButton("View Vacancies");
        b4.setBackground(Color.MAGENTA);
        b4.setForeground(Color.black);
        b4.setFont(new Font("serif",Font.PLAIN,25));
        b4.setForeground(Color.black);
        
        b4.setBounds(300,130,200,70);
        b4.addActionListener(this);
        
        
        id=new JLabel();
        id.setBounds(0,0,1360,750);
        id.setLayout(null);
        
        JLabel lid = new JLabel("ONLINE COURSE REGISTRATION");
        lid.setBounds(80,0,1500,100);
        lid.setFont(new Font("serif",Font.PLAIN,70));
        lid.setForeground(Color.blue);
        id.add(lid);
        
        id.add(b1);
        id.add(b2);
        id.add(b3);
        id.add(b4);
        //f.add(b2);
        f.add(id);
        
        f.getContentPane().setBackground(Color.white);
        
        f.setVisible(true);
        f.setSize(1360,750);
        f.setLocation(200,100);
  
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            f.setVisible(false);
              new Registration();
        }
        if(ae.getSource()==b2){
            f.setVisible(false);
            new login();
        }
        if(ae.getSource()==b3){
            f.setVisible(false);
             new viewCourse().setVisible(true);
        }
        if(ae.getSource()==b4){
            f.setVisible(false);
             new view().setVisible(true);
        }
    }
    public static void main(String args[]){
        firstpage f= new firstpage();
    }
}

 

