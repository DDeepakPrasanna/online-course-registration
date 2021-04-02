package online.course.registration;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class fee extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5,t6,t7;
   // private JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3;
    JButton b1,b2;
    Choice c1;
    String name,cour_id,phone,fee,sem;

    
    
    public static void main(String[] args) {
        new fee().setVisible(true);
    }


    public fee() {
        //super("Student Fee Form");
	setBounds(700, 200, 550, 450);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
	c1 = new Choice();
        c1.setForeground(new Color(47, 79, 79));
	c1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("online/course/registration/icons/icon7.png"));
        Image i2 = i1.getImage().getScaledInstance(75,150,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l10 = new JLabel(i3);
        l10.setBounds(370,100,150,150);
        add(l10);
        
        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()){
                c1.add(rs.getString("stu_id"));
            }
        }catch(Exception e) { }
        
	JLabel l1 = new JLabel("Student ID");
	l1.setForeground(new Color(25, 25, 112));
	l1.setFont(new Font("Tahoma", Font.BOLD, 14));
	l1.setBounds(64, 63, 102, 22);
	contentPane.add(l1);

	JLabel l2 = new JLabel("Name");
	l2.setForeground(new Color(25, 25, 112));
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(64, 97, 102, 22);
	contentPane.add(l2);

	JLabel l3 = new JLabel("Course ID");
	l3.setForeground(new Color(25, 25, 112));
	l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	l3.setBounds(64, 131, 102, 22);
	contentPane.add(l3);

	JLabel l4 = new JLabel("Phone");
	l4.setForeground(new Color(25, 25, 112));
	l4.setFont(new Font("Tahoma", Font.BOLD, 14));
	l4.setBounds(64, 199, 102, 22);
	contentPane.add(l4);

        JLabel l5 = new JLabel("Course Fee");
	l5.setForeground(new Color(25, 25, 112));
	l5.setFont(new Font("Tahoma", Font.BOLD, 14));
	l5.setBounds(64, 233, 102, 22);
	contentPane.add(l5);

	JLabel l6 = new JLabel("Total Payable");
	l6.setForeground(new Color(25, 25, 112));
	l6.setFont(new Font("Tahoma", Font.BOLD, 14));
	l6.setBounds(64, 267, 102, 22);
	contentPane.add(l6);

	c1.setBounds(174, 66, 156, 20);
	contentPane.add(c1);

	t2 = new JTextField();
	t2.setForeground(new Color(47, 79, 79));
	t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t2.setColumns(10);
	t2.setBounds(174, 100, 156, 20);
	contentPane.add(t2);

	t3 = new JTextField();
	t3.setForeground(new Color(47, 79, 79));
	t3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t3.setColumns(10);
	t3.setBounds(174, 134, 156, 20);
	contentPane.add(t3);
        
        
        t4 = new JTextField();
        t4.setForeground(new Color(47, 79, 79));
	t4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t4.setColumns(10);
	t4.setBounds(176, 203, 156, 20);
	contentPane.add(t4);

        
        t6 = new JTextField();
	t6.setForeground(new Color(47, 79, 79));
	t6.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t6.setColumns(10);
	t6.setBounds(176, 237, 154, 20);
        add(t6);
        
        t7 = new JTextField();
	t7.setForeground(new Color(47, 79, 79));
	t7.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t7.setColumns(10);
	t7.setBounds(176, 271, 154, 20);
        add(t7);
        
        
       /* t1 = new JTextField();
	t1.setForeground(new Color(47, 79, 79));
	t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t1.setColumns(10);
	t1.setBounds(176, 275, 154, 20);
        add(t1);*/
        
	b1 = new JButton("Set Details");
	b1.addActionListener(this);
	b1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	b1.setBounds(64, 321, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Pay");
	b2.addActionListener(this);
	b2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	b2.setBounds(198, 321, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);

	JLabel l7 = new JLabel("Semester");
	l7.setForeground(new Color(25, 25, 112));
	l7.setFont(new Font("Tahoma", Font.BOLD, 14));
	l7.setBounds(64, 165, 102, 22);
	contentPane.add(l7);


        t5 = new JTextField();
        t5.setForeground(new Color(47, 79, 79));
	t5.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t5.setColumns(10);
	t5.setBounds(176, 168, 156, 20);
	contentPane.add(t5);

        
	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(102, 205, 170), 2, true), "Fee-Form",
			TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
	panel.setBackground(new Color(211, 211, 211));
	panel.setBounds(10, 38, 358, 348);
        
        contentPane.setBackground(Color.WHITE);
        panel.setBackground(Color.WHITE);
        
	contentPane.add(panel);

    }
    
     String T_id(){
        String dt = new java.util.Date().toString();
        String lt = dt.substring(04,16);
        String lt1=lt.replaceAll("[^a-zA-Z0-9]", "");
        String t_id= c1.getSelectedItem()+""+lt1;
        
        return t_id;
        
    }
    
    
    void setDetails(){
        try{
        conn co = new conn();
        String Query = "select stu_name,sem,phone,cour_id from student where stu_id='"+c1.getSelectedItem()+"'";
        ResultSet result = co.s.executeQuery(Query);
        while(result.next()){
            name = result.getString("stu_name");
            cour_id = result.getString("cour_id");
            phone = result.getString("phone");
            sem = result.getString("sem");
            
            t2.setText(name);
            t3.setText(cour_id);
            t4.setText(phone);
            t5.setText(sem);
            }
            }catch(Exception ee){
               ee.printStackTrace();
            }
            
        try{
            conn co1 = new conn();
            String Query1 = "select c_fee from course where cour_id='"+cour_id+"'";
            ResultSet result1 = co1.s.executeQuery(Query1);
            while(result1.next()){
               fee = result1.getString("c_fee");
            
               t6.setText(fee);
        }
        
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    
    
    public void actionPerformed(ActionEvent ae){
        try{
            
            if(ae.getSource() == b2){
                try{
                conn con = new conn();
                String sql = "update student set t_id='"+T_id()+"' where stu_id='"+c1.getSelectedItem()+"'";
                con.s.executeUpdate(sql);
		 JOptionPane.showMessageDialog(null, "Successfully Paid");
                 JOptionPane.showMessageDialog(null, "Transaction id is "+T_id());
                    this.setVisible(false);
                    new myRegistration(c1.getSelectedItem());
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            
            if(ae.getSource() == b1){
               // this.setVisible(false);
                setDetails();
            }
        }catch(Exception e){
            
        }
    }
}

