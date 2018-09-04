package com.ict.erp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ict.erp.common.IBean;
import com.ict.erp.dao.TicketMovieDAO;
import com.ict.erp.vo.MusicInfo;
import com.ict.erp.vo.TicketMovie;

public class TicketMovieDAOImpl extends CommonDAOImpl implements TicketMovieDAO {

	@Override
	public List<TicketMovie> selectList(TicketMovie t) throws SQLException {
		String sql = "select * from ticket_movie";
		List<TicketMovie> tList = new ArrayList<>();
		try {

			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			tList = IBean.convertList(rs, t.getClass());

			return tList;
		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}
	}

	@Override
	public int insertTicket(TicketMovie t) throws SQLException {
		String sql = "insert into ticket_movie(tmNum,tmname,tmprice," + "tmstartdat,tmenddat,tmcredat,"
				+ "tmdesc,tmimg)" + "values(seq_tmnum.nextval,?,?," + "?,?,TO_CHAR(sysdate,'YYYYMMDD')," + "?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, t.getTmName());
			ps.setInt(2, t.getTmPrice());

			String start = t.getTmStartDat().replaceAll("-", "");
			ps.setString(3, start);
			String end = t.getTmEndDat().replaceAll("-", "");
			ps.setString(4, end);

			ps.setString(5, t.getTmDesc());
			ps.setString(6, t.getTmImg());

			return ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}

	}

	@Override
	public TicketMovie selectTicketMovie(int num) throws SQLException {
		String sql = "select * from ticket_movie where tmNum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1,num);
			rs = ps.executeQuery();
			TicketMovie ti = null;
			if (rs.next()) {
				ti = new TicketMovie(rs.getInt("tmNum"),rs.getString("tmName"),rs.getInt("tmPrice"),rs.getString("tmStartDat"),rs.getString("tmEndDat"),rs.getString("tmCreDat"),rs.getString("tmDesc"),rs.getInt("tmCnt"),rs.getString("tmImg"));				
			}
			return ti;
		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}

	}

	@Override
	public int deleteTicket(TicketMovie t) throws SQLException {
		String sql = "delete from ticket_movie where tmNum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1,t.getTmNum());
			return ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}

	}

	@Override
	public int updateTicket(TicketMovie t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
