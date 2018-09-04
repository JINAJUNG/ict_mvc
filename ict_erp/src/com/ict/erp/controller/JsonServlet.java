package com.ict.erp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ict.erp.service.DepartService;
import com.ict.erp.service.MusicService;
import com.ict.erp.service.TicketMovieService;
import com.ict.erp.service.impl.DepartServiceImpl;
import com.ict.erp.service.impl.MusicServiceImpl;
import com.ict.erp.service.impl.TicketMovieServiceImpl;
import com.ict.erp.vo.DepartInfo;
import com.ict.erp.vo.TicketMovie;

@WebServlet(urlPatterns = "/json/*")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gs = new Gson();

	/*
	 * private getMapType(Class keyType, Class valueType) {
	 * 
	 * }
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String> pMap = gs.fromJson(request.getParameter("param"), Map.class);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		DepartService ds = new DepartServiceImpl();
		try {
			List<DepartInfo> departList = ds. getDepartInfoListNonPage(null);

			String resStr = gs.toJson(departList);
			pw.println(resStr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/* response.getWriter().append("Served at: ").append(pMap.toString()); */
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		TicketMovieService ms = new TicketMovieServiceImpl();
		try {
			String resStr = gs.toJson(ms.getMovieList(new TicketMovie()));
			pw.println(resStr);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		//doGet(request, response);
	}

	public static void main(String[] args) {
		String jsonStr = "{\"a\":\"1\"}";
		/*
		 * Map<String, String> map = gs.fromJson(jsonStr, Map.class);
		 * System.out.println(map);
		 */

	}
}
