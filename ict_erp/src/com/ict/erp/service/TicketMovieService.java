package com.ict.erp.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ict.erp.vo.TicketMovie;

public interface TicketMovieService extends CommonService{
	public List<TicketMovie> getMovieList(TicketMovie t) throws SQLException;
	public TicketMovie getTicketMovie(int num) throws SQLException;
	public Map<String, Object> insertTicket(TicketMovie t) throws SQLException;
	public Map<String, Object> deleteTicket(TicketMovie t) throws SQLException;
	public Map<String, Object> updateTicket(TicketMovie t) throws SQLException;
}
