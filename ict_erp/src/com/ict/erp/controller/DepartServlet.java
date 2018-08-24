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
import com.ict.erp.vo.PageInfo;

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
		System.out.println(cmd);
		try {
			if(cmd.equals("departList")) {
				String pageStr = request.getParameter("page");
				if(pageStr==null || pageStr.equals("")) {
					pageStr = "1"; 
				}
				int page = Integer.parseInt(pageStr);
				PageInfo pi = new PageInfo();
				pi.setPage(page);
				DepartInfo di = new DepartInfo();
				di.setPi(pi);
				request.setAttribute("diList",ds.getDepartInfoList(di));
				request.setAttribute("page", pi);
			}else if(cmd.equals("depart")) {
				
			}else {
				
			}
		}catch(SQLException e) {
			
		}
		doService(request,response);
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
