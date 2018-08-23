package com.ict.erp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.erp.common.ICTUtils;
import com.ict.erp.service.DepartService;
import com.ict.erp.service.impl.DepartServiceImpl;
import com.ict.erp.vo.DepartInfo;

@WebServlet(urlPatterns = "/depart/*", name = "DepartServlet", loadOnStartup = 1)

public class DepartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DepartService ds = new DepartServiceImpl();

	public DepartServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = ICTUtils.getCmd(request.getRequestURI());
		try {
			if (cmd.equals("departList")) {
				DepartInfo di = null;

				request.setAttribute("diList", ds.getDepartInfoList(di));

			} else if (cmd.equals("depart")) {

			} else {

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		doService(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doService(request, response);
	}

	public void doService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = "/views" + request.getRequestURI();
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}
}
