package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.TicketMovieDAO;
import com.ict.erp.dao.impl.TicketMovieDAOImpl;
import com.ict.erp.service.TicketMovieService;
import com.ict.erp.vo.TicketMovie;

public class TicketMovieServiceImpl implements TicketMovieService {

	private TicketMovieDAO tdao = new TicketMovieDAOImpl();

	@Override
	public List<TicketMovie> getMovieList(TicketMovie t) throws SQLException {
		tdao.setConnection(DBCon.getCon());
		try {
			return tdao.selectList(t);
		} catch (SQLException e) {
			throw e;
		} finally {
			DBCon.close();
		}

	}

	@Override
	public Map<String, Object> insertTicket(TicketMovie t) throws SQLException {
		Map<String, Object> rMap = new HashMap<>();
		tdao.setConnection(DBCon.getCon());
		try {

			int cnt = tdao.insertTicket(t);
			rMap.put("cnt", cnt);
			rMap.put("msg", "fail..");
			if (cnt == 1) {
				rMap.put("msg", "success");
			}
			return rMap;
		} catch (SQLException e) {
			throw e;
		} finally {
			DBCon.close();
		}

	}

	@Override
	public TicketMovie getTicketMovie(int num) throws SQLException {
		tdao.setConnection(DBCon.getCon());
		try {
			return tdao.selectTicketMovie(num);
		}catch (SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public Map<String, Object> deleteTicket(TicketMovie t) throws SQLException {
		Map<String, Object> rMap = new HashMap<>();
		tdao.setConnection(DBCon.getCon());
		try {

			int cnt = tdao.deleteTicket(t);
			rMap.put("cnt", cnt);
			rMap.put("msg", "fail..");
			if (cnt == 1) {
				rMap.put("msg", "success");
			}
			return rMap;
		} catch (SQLException e) {
			throw e;
		} finally {
			DBCon.close();
		}

	}

	@Override
	public Map<String, Object> updateTicket(TicketMovie t) throws SQLException {
		Map<String, Object> rMap = new HashMap<>();
		tdao.setConnection(DBCon.getCon());
		try {

			int cnt = tdao.updateTicket(t);
			rMap.put("cnt", cnt);
			rMap.put("msg", "fail..");
			if (cnt == 1) {
				rMap.put("msg", "success");
			}
			return rMap;
		} catch (SQLException e) {
			throw e;
		} finally {
			DBCon.close();
		}

	}

}
