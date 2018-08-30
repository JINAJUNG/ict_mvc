package com.ict.erp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.MemberDAO;
import com.ict.erp.vo.MemberInfo;

public class MemberDAOImpl extends CommonDAOImpl implements MemberDAO {

	@Override
	public List<MemberInfo> selectMemberList(MemberInfo mi) throws SQLException {
		String sql = "select mi.*, di.diname, li.liname from member_info mi, depart_info di, level_info li where di.DICODE=mi.DICODE and li.LILEVEL=mi.LILEVEL";
		List<MemberInfo> miList = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				MemberInfo mmi = new MemberInfo();
				mmi.setMiNum(rs.getLong("miNum"));
				mmi.setMiId(rs.getString("miid"));
				mmi.setMiName(rs.getString("miname"));
				mmi.setMiAddress1(rs.getString("miAddress1"));
				mmi.setMiAddress2(rs.getString("miAddress2"));
				mmi.setMiDesc(rs.getString("miDesc"));
				mmi.setMiId(rs.getString("miId"));
				mmi.setMiPhone(rs.getString("miPhone"));
				mmi.setMiZipcode(rs.getString("mizipcode"));
				mmi.setMiEmail(rs.getString("miEmail"));
				mmi.setDiName(rs.getString("diName"));
				mmi.setLiName(rs.getString("liname"));
				miList.add(mmi);
			}
			return miList;
		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}
	}

	@Override
	public MemberInfo selectMi(int miNum) throws SQLException {
		String sql = "select mi.*, di.diname, li.liname from member_info mi, depart_info di, level_info li where di.DICODE=mi.DICODE and li.LILEVEL=mi.LILEVEL and miNum = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, miNum);
			rs = ps.executeQuery();
			MemberInfo mmi = null;
			if (rs.next()) {
				mmi = new MemberInfo();
				mmi.setMiNum(rs.getLong("miNum"));
				mmi.setMiId(rs.getString("miid"));
				mmi.setMiName(rs.getString("miname"));
				mmi.setMiAddress1(rs.getString("miAddress1"));
				mmi.setMiAddress2(rs.getString("miAddress2"));
				mmi.setMiDesc(rs.getString("miDesc"));
				mmi.setMiId(rs.getString("miId"));
				mmi.setMiPhone(rs.getString("miPhone"));
				mmi.setMiZipcode(rs.getString("mizipcode"));
				mmi.setMiEmail(rs.getString("miEmail"));
				mmi.setDiName(rs.getString("diName"));
				mmi.setLiName(rs.getString("liname"));

			}
			return mmi;
		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}

	}

	@Override
	public int insertMi(MemberInfo mi) throws SQLException {
		String sql = "insert into member_info values(seq_miNum.nextval, ";
		sql += "?,?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mi.getMiId());
			ps.setString(2, mi.getMiName());
			ps.setString(3, mi.getMiPwd());
			ps.setString(4, mi.getDiCode());
			ps.setLong(5, mi.getLiLevel());
			ps.setString(6, mi.getMiEmail());
			ps.setString(7, mi.getMiDesc());
			ps.setString(8, mi.getMiPhone());
			ps.setString(9, mi.getMiZipcode());
			ps.setString(10, mi.getMiAddress1());
			ps.setString(11, mi.getMiAddress2());

			return ps.executeUpdate();

		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}
	}

	@Override
	public int updateMi(MemberInfo mi) throws SQLException {
		String sql = "update member_info set miName =? ,"
				+ "miPwd=?,"
				+ "Dicode=?,"
				+ "lilevel=?,"
				+ "miemail=?,"
				+ "midesc=?,"
				+ "miphone=?,"
				+ "mizipcode=?,"
				+ "miaddress1=?,"
				+ "miaddress2=?"
				+ "where miNum=?";
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, mi.getMiName());
			ps.setString(2, mi.getMiPwd());
			ps.setString(3, mi.getDiCode());
			ps.setLong(4, mi.getLiLevel());
			ps.setString(5, mi.getMiEmail());
			ps.setString(6, mi.getMiDesc());
			ps.setString(7, mi.getMiPhone());
			ps.setString(8, mi.getMiZipcode());
			ps.setString(9, mi.getMiAddress1());
			ps.setString(10, mi.getMiAddress2());
			ps.setLong(11,mi.getMiNum());
			
			return ps.executeUpdate();

		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}
	}

	@Override
	public int deleteMi(MemberInfo mi) throws SQLException {
		String sql = "delete from member_Info where miNum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, mi.getMiNum());

			return ps.executeUpdate();
		} catch (SQLException e) {
			DBCon.rollback();
			throw e;
		} finally {
			close();
		}

	}

	public static void main(String[] args) {
		MemberDAO d = new MemberDAOImpl();
		d.setConnection(DBCon.getCon());
		try {
			if (d.selectMemberList(null).size() == 0) {

				System.out.println("성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
