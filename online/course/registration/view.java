package online.course.registration;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class view extends JFrame implements ActionListener{
  
    JTable j1;
    JButton b1,b2;
    String h[]={"Course ID","Vacancies"};
    String d[][]=new String[30][2];  
    int i=0,j=0;
    String c,n;
    
    view(){
        //super("View Teachers Attendance");
        setSize(800,300);
        setLocation(450,150);

    
        
        
        try{
            String q="select cour_id,count(cour_id) from student group by cour_id";
            conn c1=new conn();
            ResultSet rs=c1.s.executeQuery(q);
            while(rs.next()){
                d[i][j++]=rs.getString("cour_id");
                String s=rs.getString("cour_id");
                String c= rs.getString("count(cour_id)");
                int num= Integer.parseInt(c);
                int num2=60-num;
                String str=Integer.toString(num2);
                d[i][j++]=str;
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
        new view().setVisible(true);
    }
}