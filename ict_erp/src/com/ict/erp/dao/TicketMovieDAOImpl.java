package com.ict.erp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ict.erp.common.IBean;
import com.ict.erp.dao.impl.CommonDAOImpl;
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

}
