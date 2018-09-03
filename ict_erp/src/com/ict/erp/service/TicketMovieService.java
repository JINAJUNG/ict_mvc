package com.ict.erp.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ict.erp.vo.TicketMovie;

public interface TicketMovieService {
	public List<TicketMovie> getMovieList(TicketMovie t) throws SQLException;
	public Map<String, Object> insertTicket(TicketMovie t) throws SQLException;
}
