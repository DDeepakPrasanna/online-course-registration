package online.course.registration;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class viewCourse extends JFrame implements ActionListener{
  
    JTable j1;
    JButton b1,b2;
    String h[]={"Course Type","Course Duration","Course Name","Course Fee","Course ID","Vacancies"};
    String d[][]=new String[15][6];  
    int i=0,j=0;
    String c;  
    
    
    viewCourse(){
        //super("View Teachers Attendance");
        setSize(800,300);
        setLocation(450,150);

    
        
        
        try{
            String q="select * from course";
            conn c1=new conn();
            ResultSet rs=c1.s.executeQuery(q);
            while(rs.next()){
                //d[i][j++]=rs.getString("cour_id");
                d[i][j++]=rs.getString("cour_type");
                d[i][j++]=rs.getString("cour_dur");
                d[i][j++]=rs.getString("cour_name");
                d[i][j++]=rs.getString("c_fee");
    
                i++;
                j=0;
            }
        
            j1=new JTable(d,h);

        }catch(Exception e){}
        
        b1=new JButton("Print");
        add(b1,"South");
        //b2=new JButton("Back");
        //add(b2,"South");
        JScrollPane s1=new JScrollPane(j1);
        add(s1);
        
        b1.addActionListener(this);
        //b2.addActionListener(this);
        
        }
    public void actionPerformed(ActionEvent ae){
        try{
            j1.print();
        }catch(Exception e){}
    }
    
    public static void main(String[] args){
        new viewCourse().setVisible(true);
    }
}