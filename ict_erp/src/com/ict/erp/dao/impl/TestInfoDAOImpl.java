package com.ict.erp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.TestInfoDAO;
import com.ict.erp.vo.TestInfo;

public class TestInfoDAOImpl implements TestInfoDAO {
	private static Connection con = null;

	@Override
	public List<TestInfo> selectTestInfo(TestInfo ti) throws SQLException {
		try {
			con = DBCon.getCon();
			List<TestInfo> tiList = new ArrayList<TestInfo>();
			String sql = "select * from test_info";
			if (ti != null) {
				if (ti.getTiNum() != 0) {
					sql += " where tiNum=?";
				} else if (ti.getTiName() != null) {
					sql += " where tiName like '%' || ? || '%'";
				} else if (ti.getTiId() != null) {
					sql += " where tiId like '%' || ? || '%'";
				} else if (ti.getTiText() != null) {
					sql += " where tiText like '%' || ? || '%'";
				}
			}

			PreparedStatement ps = con.prepareStatement(sql);
			if (ti != null) {
				if (ti.getTiNum() != 0) {
					ps.setString(1, ti.getTiNum() + "");
				} else if (ti.getTiName() != null) {
					ps.setString(1, ti.getTiName());
				} else if (ti.getTiId() != null) {
					ps.setString(1, ti.getTiId());
				} else if (ti.getTiText() != null) {
					ps.setString(1, ti.getTiText());
				}
			}
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int tiNum = rs.getInt("tiNum");
				String tiName = rs.getString("tiName");
				String tiText = rs.getString("tiText");
				String tiId = rs.getString("tiId");
				ti = new TestInfo(tiNum, tiName, tiText, tiId);
				tiList.add(ti);
			}
			ps.close();
			rs.close();
			return tiList;
		} catch (SQLException e) {
			throw e;
		} finally {
			DBCon.close();
		}

	}

	@Override
	public TestInfo selectTestInfo(int tiNum) throws SQLException {
		try {
			con = DBCon.getCon();
			TestInfo ti=null;
			String sql = "select * from test_info where tiNum=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, tiNum);

			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				ti = new TestInfo(rs.getInt("tiNum"), rs.getString("tiName"), rs.getString("tiText"),
						rs.getString("tiId"));
			}
			ps.close();
			rs.close();
			return ti;
		} catch (SQLException e) {
			throw e;
		} finally {
			DBCon.close();
		}
	}
//	public static void main(String[] args) {
//		TestInfoDAOImpl d = new TestInfoDAOImpl();
//		try {
//			System.out.println(d.selectTestInfo(1));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
