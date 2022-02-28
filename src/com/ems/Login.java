package com.ems;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
 
class login  implements ActionListener{

	
	JFrame f;
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    //public Connection c;
    //public Statement s;
	

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
        
        //ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("C:\\\\Users\\\\dell_\\\\Downloads\\eight.jpg"));
        //Image i2 = i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        //ImageIcon i3 =  new ImageIcon(i2);
       
    		
    		//Image img = Toolkit.getDefaultToolkit().getImage("D:\\New folder\\pet3.jpg");
    		//Image i2 = img.getScaledInstance(150,150,Image.SCALE_DEFAULT);
    		//@SuppressWarnings("unused")
			//ImageIcon i3 = new ImageIcon(i2);
    		

        
        JLabel l3 = new JLabel();
        l3.setBounds(350,20,150,150);
        f.add(l3);


        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        f.add(b1);

        /*b3=new JButton("Sign Up");
        b3.setBounds(320,140,120,30);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        f.add(b3);
        b3.addActionListener(this);*/
        
        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        f.add(b2);

        b2.addActionListener(this);
        
        f.getContentPane().setBackground(Color.ORANGE);

        f.setVisible(true);
        f.setSize(600,300);
        f.setLocation(400,300);

    }

    @SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent ae){

        try{
            conn c1 = new conn();
            String u = t1.getText();
            String v = t2.getText();
            
            String q = "select * from login where username='"+u+"' and password='"+v+"'";
            
            ResultSet rs = c1.s.executeQuery(q); 
            if(rs.next()){
                new Details().f.setVisible(true);
                f.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Invalid login");
                f.setVisible(false);
            }
           if (c1.getsource()==b2){
               t1.setText("");
               t2.setText("");
            }
           /* else if (c1.getsource()==b3){
            	 new AddEmployee();
                f.setVisible(false);*/
               
        }catch(Exception ex){
            ex.printStackTrace();
            Logger.getLogger(login.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public static void main(String[] arg){
        new login();
    }
}