package online.course.registration;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class details implements ActionListener{
    JFrame f;
    JLabel l1,l2;
    JButton b1,b2,b3,b4,b5,b6,b7;
    
    details(){
        f=new JFrame ("Course Details");
        f.setBackground(Color.white);
        f.setLayout(null);
        
        l1 = new JLabel();
        l1.setBounds(0,0,700,500);
        l1.setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("online/course/registration/icons/details.jpg"));
        l1.setIcon(i1);
        f.add(l1);        
        l2=new JLabel("");
        l2.setBounds(430,20,200,40);
        l2.setFont(new Font("serif",Font.BOLD,25));
        l2.setBackground(Color.black);
        l1.add(l2);
        
        b1=new JButton("Add Course");
        b1.setBounds(20,100, 170,40);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        l1.add(b1);
        
        b2=new JButton("Remove Course");
        b2.setBounds(300,100, 170,40);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        l1.add(b2);
        
        b3=new JButton("Add Instructor");
        b3.setBounds(20,250, 170,40);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.addActionListener(this);
        l1.add(b3);
        
        b4=new JButton("Remove Instrucor");
        b4.setBounds(300,250, 170,40);
        b4.setFont(new Font("serif",Font.BOLD,15));
        b4.addActionListener(this);
        l1.add(b4);
        
        
        f.setVisible(true);
        f.setSize(700,500);
        f.setLocation(450,200);
        
        b5=new JButton("Exit");
        b5.setBounds(200,350, 100,40);
        b5.setFont(new Font("serif",Font.BOLD,15));
        b5.addActionListener(this);
        l1.add(b5);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            f.setVisible(false);
            new Add_Course();
         }
        if(ae.getSource()==b2){
            f.setVisible(false);
            new Remove_Course();
         }
        if(ae.getSource()==b3){
            f.setVisible(false);
            new Add_Instructor();
         }
        if(ae.getSource()==b4){
            f.setVisible(false);
            new Remove_Instructor();
         }
        if(ae.getSource()==b5){
            f.setVisible(false);
            System.exit(1);
         }
    }
    public static void main(String args[]){
        details d = new details();
    }
}

