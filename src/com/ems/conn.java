package com.ems;

import java.sql.*;

import javax.swing.JButton;

public class conn{
    
    public Connection c;
    public Statement s;
 
    public conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///project2","root","12345");
            s = c.createStatement();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

	public JButton getsource() {
		return null;
	}
}