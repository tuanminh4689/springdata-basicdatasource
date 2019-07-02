package com.mkyong.customer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mkyong.customer.dao.EducationMasterDAO;
import com.mkyong.customer.model.EducationMaster;


public class JDBCEducationMasterDAO implements EducationMasterDAO{
	
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource; 
	}

	public EducationMaster findById(int id) {
		String sql = "select * from cvms_demo.educationmaster where cust_id = ?";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			EducationMaster eduMaster = null;
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				eduMaster = new EducationMaster(rs.getInt("Id"), 
						rs.getString("Name"), 
						rs.getString("Desciption"),
						rs.getString("Name_JP"), 
						rs.getString("Desciption_JP"));
			}
			rs.close();
			ps.close();
			return eduMaster;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
