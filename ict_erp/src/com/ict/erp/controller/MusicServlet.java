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
import com.ict.erp.service.MusicService;
import com.ict.erp.service.impl.MusicServiceImpl;

@WebServlet(urlPatterns = "/music/*", name = "MusicServlet", loadOnStartup = 1)
public class MusicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MusicService ms = new MusicServiceImpl();
	private String uri="";
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		uri = request.getRequestURI();
		String cmd = ICTUtils.getCmd(uri);

		try {
			if (cmd.equals("musicList")) {
				request.setAttribute("musicList", ms.getMusicList(null));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		doService(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	
	public void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		uri = "/views"+uri;
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}
}
