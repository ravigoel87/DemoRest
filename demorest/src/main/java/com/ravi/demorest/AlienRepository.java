package com.ravi.demorest;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;



import javax.sql.DataSource;

import java.sql.*;

public class AlienRepository {
	
	
	Connection con = null;
	
	
	
	public AlienRepository()
	{

		
		
		
		String url = "jdbc:mysql://localhost:3306/restdb?autoReconnect=true&useSSL=false";
		String username = "ravi";
		String password = "ravi";
				
	
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				con = DriverManager.getConnection(url,username,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
	}
	
	public List<Alien> getAliens()
	{
		List<Alien> aliens= new ArrayList<>();
		String sql = "select * from alien";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				Alien a = new Alien();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
				
				aliens.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aliens;
	} 

	public Alien getAlien(int id)
	{
		Alien a = new Alien();
		String sql = "select * from alien where id ="+id;
		try {
			Statement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
					
					a.setId(rs.getInt(1));  
					a.setName(rs.getString(2));
					a.setPoints(rs.getInt(3));
					
					return a;
				
					
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
		return null	;
	}

	public void create(Alien a1) {
		
		String sql = "insert into alien values (?,?,?)";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, a1.getId());
			st.setString(2, a1.getName());
			st.setInt(3, a1.getPoints());
			
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
public void update(Alien a1) {
		
		String sql = "update alien set point= ? where id = ?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, a1.getPoints());
			//st.setString(2, a1.getName());
			st.setInt(2, a1.getId());
			
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

public void aliendel(int id1) {
	// TODO Auto-generated method stub
String sql = "delete from Alien where id = ?";
	
	try {
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, id1);
		
		st.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}


}