package online.course.registration;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class myRegistration implements ActionListener{
    JFrame f;
    JLabel id,id1,id2,id3,id4,id5,id8,id9,id10,aid,aid1,aid2,aid3,aid4,aid5,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    String stu_id,stu_name,sem,mail,phone,age,cour_name,cour_type,cour_id,cour_dur,ins_name,ins_id;
    JButton b1,b2;
    ImageIcon icon;

    myRegistration(String stu_id){
        try{
            conn con = new conn();
            String str = "select * from student where stu_id = '"+stu_id+"'";
            ResultSet rs= con.s.executeQuery(str);

            while(rs.next()){
                stu_id = rs.getString("Stu_id");
                stu_name = rs.getString("stu_name");
                sem = rs.getString("sem");
                mail = rs.getString("mail");
                phone = rs.getString("phone");
                age = rs.getString("age");
                cour_id=rs.getString("cour_id");
                }
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            conn c = new conn();
            String s = "Select * from course where cour_id='"+cour_id+"'";
            ResultSet rs1= c.s.executeQuery(s);

            while(rs1.next()){
                cour_name = rs1.getString("cour_name");
                cour_type = rs1.getString("cour_type");
                cour_dur = rs1.getString("cour_dur");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
         try{
            conn c1 = new conn();
            String s1 = "Select ins_name,ins_id from instructor where cour_id='"+cour_id+"'";
            ResultSet rs2= c1.s.executeQuery(s1);

            while(rs2.next()){
                ins_id=rs2.getString("ins_id");
                ins_name = rs2.getString("ins_name");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
 
        f=new JFrame("My Registration");
        f.setVisible(true);
        f.setSize(900,700);
        f.setLocation(400,150);
        f.setBackground(Color.white);
        f.setLayout(null);


        id9=new JLabel();   
        id9.setBounds(0,0,900,700);
        id9.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("online/course/registration/icons/add.jpg"));
        id9.setIcon(img);

        id8 = new JLabel("Student Details");
        id8.setBounds(250,10,350,30);
        f.add(id8);
        id8.setFont(new Font("serif",Font.BOLD,25));
        id9.add(id8);
        f.add(id9);

        id = new JLabel("Student ID:");
        id.setBounds(50,70,120,30);
        id.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id);

        aid = new JLabel(stu_id);
        aid.setBounds(200,70,200,30);
        aid.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid);

        id1 = new JLabel("Student Name:");
        id1.setBounds(400,70,150,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id1);

        aid1 = new JLabel(stu_name);
        aid1.setBounds(600,70,300,30);
        aid1.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid1);

  
        id2 = new JLabel("Semester:"); 
        id2.setBounds(50,150,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id2);

        aid2 = new JLabel(sem);
        aid2.setBounds(200,150,300,30);
        aid2.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid2);

        id3= new JLabel("Email:");
        id3.setBounds(400,150,100,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id3);

        aid3= new JLabel(mail);
        aid3.setBounds(600,150,300,30);
        aid3.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid3);


        id4= new JLabel("Mobile No:");  
        id4.setBounds(50,230,100,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id4);

        aid4= new JLabel(phone);
        aid4.setBounds(200,230,300,30); 
        aid4.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid4);

        
        id5= new JLabel("Age:");
        id5.setBounds(400,230,100,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id5);

        aid5= new JLabel(age);
        aid5.setBounds(600,230,300,30);
        aid5.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid5);

        l1= new JLabel("Course Name:");
        l1.setBounds(50,330,150,30);
        l1.setFont(new Font("serif",Font.BOLD,20));
        id9.add(l1);

        l2= new JLabel(cour_name);
        l2.setBounds(200,330,300,30);
        l2.setFont(new Font("serif",Font.BOLD,20));
        id9.add(l2);

        l3= new JLabel("Course ID:");
        l3.setBounds(400,330,150,30);
        l3.setFont(new Font("serif",Font.BOLD,20));
        id9.add(l3);

        l4= new JLabel(cour_id);
        l4.setBounds(600,330,300,30);
        l4.setFont(new Font("serif",Font.BOLD,20));
        id9.add(l4);
        
        l5= new JLabel("Course Type:");
        l5.setBounds(50,410,150,30);
        l5.setFont(new Font("serif",Font.BOLD,20));
        id9.add(l5);

        l6= new JLabel(cour_type);
        l6.setBounds(200,410,300,30);
        l6.setFont(new Font("serif",Font.BOLD,20));
        id9.add(l6);
        
        l7= new JLabel("Course Duration:");
        l7.setBounds(400,410,150,30);
        l7.setFont(new Font("serif",Font.BOLD,20));
        id9.add(l7);

        l8= new JLabel(cour_dur);
        l8.setBounds(600,410,300,30);
        l8.setFont(new Font("serif",Font.BOLD,20));
        id9.add(l8);

        l9= new JLabel("Instructor ID:");
        l9.setBounds(50,490,150,30);
        l9.setFont(new Font("serif",Font.BOLD,20));
        id9.add(l9);

        l10= new JLabel(ins_id);
        l10.setBounds(200,490,300,30);
        l10.setFont(new Font("serif",Font.BOLD,20));
        id9.add(l10);
        
        l11= new JLabel("Instructor Name:");
        l11.setBounds(400,490,150,30);
        l11.setFont(new Font("serif",Font.BOLD,20));
        id9.add(l11);

        l12= new JLabel(ins_name);
        l12.setBounds(600,490,300,30);
        l12.setFont(new Font("serif",Font.BOLD,20));
        id9.add(l12);

        
        b1=new JButton("Exit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(200,570,100,30);
        b1.addActionListener(this);
        id9.add(b1);
        
        b2=new JButton("Pay fee");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(400,570,100,30);
        b2.addActionListener(this);
        id9.add(b2);

        id10 = new JLabel("Course Details");
        id10.setBounds(250,280,350,30);
        f.add(id10);
        id10.setFont(new Font("serif",Font.BOLD,25));
        id9.add(id10);
        f.add(id9);

     


    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b1){
            f.setVisible(false);
            System.exit(1);
        }
        if(ae.getSource()==b2){
            f.setVisible(false);
            new fee().setVisible(true);
        }

    }
    public static void main(String[] args){
        new myRegistration("myRegistration");
    }

}
