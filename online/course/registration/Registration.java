package online.course.registration;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.Random;

public class Registration implements ActionListener{
    JFrame f;
    JLabel id1,id2,id3,id4,id5,id6,id7,id8,id9,id15,id10,id11,id12;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JButton b1,b2,b3,b4;
    JComboBox c1;
    String displ;
    String Captcha=captcha(6);
    int num2;
    
    //Generating 3 digit random number for student id
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    long first = Math.abs(first4);
    
    //extracting year(yy) from present date for student ID
    String dt = new java.util.Date().toString();
    String lt = dt.substring(dt.length()-2);
    
   Registration(){ 
       //various GUI components required
        f = new JFrame("Course Registration");
        f.setBackground(Color.white);
        f.setLayout(null);

        id15=new JLabel();
        id15.setBounds(0,0,900,700);
        id15.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("online/course/registration/icons/add.jpg"));
        id15.setIcon(img);

        id8 = new JLabel("New Registration");
        id8.setBounds(320,30,500,50);
        id8.setFont(new Font("serif",Font.ITALIC,25));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);

 
        id1 = new JLabel("Student id");
        id1.setBounds(50,120,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id1);

        t1=new JTextField();
        t1.setBounds(200,120,150,30);
        t1.setText(lt+"S"+first);
        id15.add(t1);

        id2 = new JLabel("Student Name");
        id2.setBounds(400,120,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id2);

        t2=new JTextField();
        t2.setBounds(600,120,150,30);
        id15.add(t2);

        id3= new JLabel("Semester");
        id3.setBounds(50,200,100,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id3);

        t3=new JTextField();
        t3.setBounds(200,200,150,30);
        id15.add(t3);

        id4= new JLabel("Email");  
        id4.setBounds(400,200,200,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id4);

        t4=new JTextField();
        t4.setBounds(600,200,150,30);
        id15.add(t4);

        id5= new JLabel("Phone");
        id5.setBounds(50,280,100,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id5);

        t5=new JTextField();
        t5.setBounds(200,280,150,30);
        id15.add(t5);

        id6= new JLabel("Age");
        id6.setBounds(400,280,100,30);
        id6.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id6);

        t6=new JTextField();
        t6.setBounds(600,280,150,30);
        id15.add(t6);
        
        id7=new JLabel("Course");
        id7.setBounds(50,360,150,30);
	id7.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id7);
            
        String course[] = {"JAVA","PYTHON","UNIX","Computer Networks"}; //various courses can be added
        c1 = new JComboBox(course);
        c1.setBackground(Color.WHITE);
        c1.setBounds(200,360,150,30);
        id15.add(c1);

        id9= new JLabel("Course Code");
        id9.setBounds(400,360,130,30);
        id9.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id9);

        t7=new JTextField();
        t7.setBounds(600,360,150,30);
        id15.add(t7);
        
        id10= new JLabel("Captcha");
        id10.setBounds(50,440,130,30);
        id10.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id10);

        id11= new JLabel(Captcha);
        id11.setBounds(200,440,130,30);
        id11.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id11);

        id12= new JLabel("Enter Captcha");
        id12.setBounds(400,440,130,30);
        id12.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id12);

        
        t8=new JTextField();
        t8.setBounds(600,440,150,30);
        id15.add(t8);
        
        b1 = new JButton("Verify");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(250,550,150,40);
        
        id15.add(b1);

        b2=new JButton("Submit");   
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(450,550,150,40);
        b2.setVisible(false);
        
        id15.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        b3=new JButton("View Details");   
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(450,550,150,40);
        b3.setVisible(false);
        
        id15.add(b3);
        
        b3.addActionListener(this);
        
        
        b4=new JButton("Cancel");   
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setBounds(350,600,150,40);
       
        
        id15.add(b4);
        
        b4.addActionListener(this);
       
       
        
        f.setVisible(true);
        f.setSize(900,700);
        f.setLocation(400,150);

}
   //Generating captcha
   public static String captcha(int len) {
	String chars ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}
    
   //Checking if captcha and entered text are same
     boolean check(String str){
        if(str.equals(Captcha)){
            return true;
        }else{
        return false;}
    }
    
   
   //Checking if age is more than 18
   public static String Check(String check2){
       int check3 = Integer.parseInt(check2);
       if(check3<18){
           return  "Your age is below 18";
       }
       else{
           return "Your eligible to take this course";
           
       }
   }
   
   //checking for vacancies 
   public String Checkv(String check2){
       
        try{
            String q="select cour_id,count(cour_id) from student where cour_id='"+check2+"'";
            conn c1=new conn();
            ResultSet rs=c1.s.executeQuery(q);
            while(rs.next()){
                String s=rs.getString("cour_id");
                String c= rs.getString("count(cour_id)");
                int num= Integer.parseInt(c);
                num2=60-num;
            }
        }catch(Exception e){}
       if(num2==0){
           return  "No vacancies";
       }
       else{
           return "Only "+num2+"slots are left";
           
       }
   }
   
    
public void actionPerformed(ActionEvent ae){
        
    //storing textfield values in strings
        String a = t1.getText();
        String bb = t2.getText();
        String c = t3.getText();
        String d = t4.getText();
        String e = t5.getText();
        String ff = t6.getText(); 
        String g = "";
        String cour_id="";
        String t_id="";
        if(check(t8.getText())){
            
            //connecting to database and inserting the values
        if(ae.getSource() == b2){
            try{
                conn cc = new conn();
                String q = "insert into student values('"+a+"','"+bb+"','"+c+"','"+d+"','"+e+"','"+ff+"','"+g+"','"+t_id+"')";
                cc.s.executeUpdate(q);
                f.setVisible(true);
                
                String value = c1.getSelectedItem().toString();
                conn c2 = new conn();
                String q1="select cour_id from course where cour_name='"+value+"'";
                ResultSet rs = c2.s.executeQuery(q1); 
                while(rs.next()){
                     cour_id = rs.getString("cour_id");
                }
                t7.setText(cour_id);
                String displ1 = Checkv(t7.getText());
                JOptionPane.showMessageDialog(null,"Vacancies: " +displ1);
                if(displ1 == "No vacancies"){
                f.setVisible(false);
                System.exit(0);
            }
                
                conn c1 = new conn();
                String q2 = "update student set cour_id='"+cour_id+"' where stu_id='"+a+"'";
                c1.s.executeUpdate(q2);
                JOptionPane.showMessageDialog(null,"Registered Successfully");
                b2.setVisible(false);
                b3.setVisible(true);
                
            }catch(Exception ee){
                System.out.println("The error is:"+ee);
            }
        }
         else{
                JOptionPane.showMessageDialog(null,"Captcha incorrect");
             }
        }else if(ae.getSource() == b4){
            f.setVisible(false);
            new firstpage();
        }else if(ae.getSource()==b3){
            f.setVisible(false);
            myRegistration m = new myRegistration(t1.getText());
        }else if(ae.getSource() == b1){
            String displ = Check(t6.getText());
            JOptionPane.showMessageDialog(null,"Eligibility: " +displ);
            
            if(displ == "Your eligible to take this course"){
                b2.setVisible(true);
            }   
        }
    }
    public static void main(String[ ] arg){
        new Registration(); 
    }
}
