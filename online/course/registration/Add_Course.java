package online.course.registration;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.Random;
import java.io.FileWriter;
import java.io.File; 


class Add_Course implements ActionListener{
    JFrame f;
    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id15,id16,id17,lab,lab1,f1;
    JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15;
    JButton b,b1,b2,b3;
    String c;
   
    
    Add_Course(int i){}
    
    //adding all the code in constructor
    //various gui components required
    Add_Course() {
        f = new JFrame("Add Course");
        f.setBackground(Color.white);
        f.setLayout(null);

        
       id15=new JLabel();
        id15.setBounds(0,0,900,700);
        id15.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("online/course/registration/icons/add.jpg"));
        id15.setIcon(img);


        id8 = new JLabel("New Course");
        id8.setBounds(320,30,500,50);
        id8.setFont(new Font("serif",Font.ITALIC,25));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);

 
        id1 = new JLabel("Course ID");
        id1.setBounds(50,150,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id1);
           
        t1=new JTextField();
        t1.setBounds(200,150,150,30);
        id15.add(t1);
        


        id2 = new JLabel("Course Type");
        id2.setBounds(400,150,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id2);

        t2=new JTextField();
        t2.setBounds(600,150,150,30);
        id15.add(t2);

        id7= new JLabel("Course Name");
        id7.setBounds(50,300,150,30);
        id7.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id7);

        t7=new JTextField();
        t7.setBounds(200,300,150,30);
        id15.add(t7);

        id9= new JLabel("Course Duration");
        id9.setBounds(400,300,150,30);
        id9.setFont(new Font("serif",Font.BOLD,20));    
        id15.add(id9);

        t8=new JTextField();
        t8.setBounds(600,300,150,30);
        id15.add(t8);


        f1= new JLabel("Course Fee");
        f1.setBounds(225,450,150,30);
        f1.setFont(new Font("serif",Font.BOLD,20));    
        id15.add(f1);

        t14=new JTextField();
        t14.setBounds(400,450,150,30);
        id15.add(t14);

        
        lab=new JLabel();
        lab.setBounds(200,450,250,200);
	id15.add(lab);

        lab1=new JLabel("");
        lab1.setBounds(600,450,250,200);
        id15.add(lab1);

        b = new JButton("Submit");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(250,550,150,40);
        
        id15.add(b);

        b1=new JButton("Cancel");   
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(450,550,150,40);
        
        id15.add(b1);
        
        b.addActionListener(this);
        b1.addActionListener(this);
        
        f.setVisible(true);
        f.setSize(900,700);
        f.setLocation(400,150);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        //storing TextField values in strings
        String a = t1.getText();
        String bb = t2.getText();
        String g = t7.getText();
        String h = t8.getText();
        String i=t14.getText();        
        
        //if button b i.e;Submit button is clicked
        if(ae.getSource() == b){
            try{
                //connecting to database and inserting values into table employee
                conn cc = new conn();
                String q = "insert into course values('"+a+"','"+bb+"','"+h+"','"+g+"','"+i+"')";
                cc.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                f.setVisible(false);
                new details();
            }catch(Exception ee){
                System.out.println("The error is:"+ee);
            }
            //if button b1 i.e; cancel button is clicked
        }else if(ae.getSource() == b1){
            f.setVisible(false);
            new details();  
        }
    }
    public static void main(String[ ] arg){
        new Add_Course();
       
    }
}