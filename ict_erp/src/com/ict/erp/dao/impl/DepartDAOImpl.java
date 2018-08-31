package com.ict.erp.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ict.erp.dao.DepartDAO;
import com.ict.erp.vo.DepartInfo;

public class DepartDAOImpl extends CommonDAOImpl implements DepartDAO {

	@Override
	public List<DepartInfo> selectDepartInfoList(DepartInfo di) throws SQLException {
		List<DepartInfo> diList = new ArrayList<DepartInfo>();
		String sql = "select * from (";
		sql += "select di.*, rownum as rNum from (";
		sql += "select * from depart_info order by diNum desc) di";
		sql += " where rownum<=?)";
		sql += " where rNum>=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, di.getPi().getlNum());
			ps.setInt(2, di.getPi().getsNum());
			rs = ps.executeQuery();
			while (rs.next()) {
				di = new DepartInfo(rs.getInt("diNum"), rs.getString("diCode"), rs.getString("diName"),
						rs.getString("diDesc"));
				diList.add(di);
			}
			return diList;
		} catch (SQLException e) {
			throw e;
		} finally {
			close();// commonDAOImpl의 close
		}
	}

	@Override
	public DepartInfo selectDepartInfo(int diNum) throws SQLException {
		String sql = "select * from depart_info where diNum=?";
		DepartInfo di = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, diNum);
			rs = ps.executeQuery();
			if (rs.next()) {
				di = new DepartInfo(rs.getInt("diNum"), rs.getString("diCode"), rs.getString("diName"),
						rs.getString("diDesc"));
			}
			return di;
		} catch (SQLException e) {
			throw e;
		} finally {
			close();// commonDAOImpl의 close
		}
	}

	@Override
	public int insertDepartInfo(DepartInfo di) throws SQLException {
		String sql = "insert into depart_info(diNum,diCode,diName,diDesc) values(seq_diNum.nextval,?,?,?) ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, di.getDiCode());
			ps.setString(2, di.getDiName());
			ps.setString(3, di.getdiDesc());

			return ps.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}

	@Override
	public int updateDepartInfo(DepartInfo di) throws SQLException {
		String sql = "update depart_info set diCode=?, diName=?, diDesc=? where diNum=? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, di.getDiCode());
			ps.setString(2, di.getDiName());
			ps.setString(3, di.getdiDesc());
			ps.setInt(4, di.getDiNum());

			return ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}
	}

	@Override
	public int deleteDepartInfo(DepartInfo di) throws SQLException {
		String sql = "delete from depart_info where diNum=? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, di.getDiNum());
			System.out.println(di.getDiNum());
			return ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}
	}

}
