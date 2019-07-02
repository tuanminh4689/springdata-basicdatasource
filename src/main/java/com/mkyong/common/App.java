package com.mkyong.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceUtils;

import com.mkyong.customer.model.EducationMaster;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
    	DataSource ds = (DataSource) context.getBean("dataSource");
    	
    	//Connection conn = ds.getConnection();
		//Connection conn = DataSourceUtils.doGetConnection(ds);
		Connection conn = DataSourceUtils.getConnection(ds);
		System.out.println("conn : " + conn == null);
    	
    	System.out.println("done");
    	String sql = "select * from cvms_demo.educationmaster where id = ?";
    	int id = 1;
    	try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			EducationMaster eduMaster = null;
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				eduMaster = new EducationMaster(rs.getInt("Id"), 
						rs.getString("Name"), 
						rs.getString("Description"),
						rs.getString("Name_JP"), 
						rs.getString("Description_JP"));
			}
			rs.close();
			ps.close();
			System.out.println(eduMaster.getName());
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
    	
    	
//        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
//        Customer customer = new Customer(1, "mkyong",28);
//        customerDAO.insert(customer);
//    	
//        Customer customer1 = customerDAO.findByCustomerId(1);
//        System.out.println(customer1);
        
    }
}
