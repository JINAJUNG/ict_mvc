package com.ict.erp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.erp.common.ICTUtils;
import com.ict.erp.service.DepartService;
import com.ict.erp.service.LevelService;
import com.ict.erp.service.MemberService;
import com.ict.erp.service.impl.DepartServiceImpl;
import com.ict.erp.service.impl.LevelServiceImpl;
import com.ict.erp.service.impl.MemberServiceImpl;
import com.ict.erp.vo.MemberInfo;

public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService ms = new MemberServiceImpl();
	private LevelService ls = new LevelServiceImpl();
	private DepartService ds = new DepartServiceImpl();
	public String uri = "";
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		uri = request.getRequestURI();
		String cmd = ICTUtils.getCmd(uri);
		System.out.println(uri);
		try {
			if (cmd.equals("memberList")) {
				request.setAttribute("miList", ms.getMemberList(null));
			}else if(cmd.equals("memberView")) {
				String num= request.getParameter("minum");
				int miNum = Integer.parseInt(num);
				System.out.println(miNum);
				request.setAttribute("mi", ms.getMi(miNum));
			}else if(cmd.equals("memberInsert")) {
				request.setAttribute("liList", ls.getLiList(null));
/*				request.setAttribute("diList", ds.getDepartInfoList(null));*/
			}else if(cmd.equals("memberUpdate")){
				String num= request.getParameter("miNum");
				int miNum = Integer.parseInt(num);
				System.out.println(miNum);
				request.setAttribute("mi", ms.getMi(miNum));
				request.setAttribute("liList", ls.getLiList(null));
			}else {

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		doService(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		uri = request.getRequestURI();
		String cmd = ICTUtils.getCmd(uri);
		System.out.println(cmd);
		try {
			if (cmd.equals("memberInsert")) {
				String name = request.getParameter("miName");
				String id = request.getParameter("miId");
				String pwd = request.getParameter("miPwd");
				String dicode = request.getParameter("dicode");
				String lilevelStr = request.getParameter("liLevel");
				int lilevelInt = Integer.parseInt(lilevelStr);
				Long lilevel = (long) lilevelInt;
				String email = request.getParameter("miEmail");
				String desc = request.getParameter("miDesc");
				String phone = request.getParameter("miPhone");
				String zipcode = request.getParameter("miZipcode");
				String address1 = request.getParameter("miAddress1");
				String address2 = request.getParameter("miAddress2");

				MemberInfo mi = new MemberInfo((long) 0, id, name, pwd, dicode, lilevel, email, desc, phone, zipcode,
						address1, address2, "", "");
				request.setAttribute("rMap", ms.insertMi(mi));
				MemberInfo miT = ICTUtils.parse(request, MemberInfo.class);
				System.out.println(mi);
				System.out.println("in");
			}else if(cmd.equals("memberDelete")) {
				String miNumStr = request.getParameter("miNum");
				int miNum = Integer.parseInt(miNumStr);
				MemberInfo mi = new MemberInfo();
				mi.setMiNum((long)miNum);
				request.setAttribute("rMap", ms.deleteMi(mi));
				uri = "/member/memberView";
			}else if(cmd.equals("memberUpdate")) {
				MemberInfo miT = ICTUtils.parse(request, MemberInfo.class);
				System.out.println(miT);
				System.out.println("in");
				request.setAttribute("rMap", ms.updateMi(miT));
			}else {
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		doService(request, response);
	}

	public void doService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		uri = "/views" + uri;
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}
}
