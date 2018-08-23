package com.ict.erp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.DepartDAO;
import com.ict.erp.vo.DepartInfo;

public class DepartDAOImpl implements DepartDAO {
	private Connection con=null;
	@Override
	public List<DepartInfo> selectDepartInfoList(DepartInfo di) throws SQLException {
		List<DepartInfo> diList = new ArrayList<>();
		try {
			con=DBCon.getCon();
			String sql = "select * from Depart_Info";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				di = new DepartInfo(rs.getInt("diNum"),rs.getString("diCode"),rs.getString("diName"),rs.getString("diDesc"));	
				diList.add(di);
			}	
			rs.close();
			ps.close();
		}catch (SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
		
		
		return diList;
	}

	@Override
	public DepartInfo selectDepartInfo(int diNum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> insertDepartInfo(DepartInfo di) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> updateDepartInfo(DepartInfo di) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> deleteDepartInfo(DepartInfo di) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
