package com.ict.erp.dao;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.TicketMovie;

public interface TicketMovieDAO extends CommonDAO{
	public List<TicketMovie> selectList(TicketMovie t)throws SQLException;
	public int insertTicket(TicketMovie t)throws SQLException;
}
