package com.ict.erp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.erp.common.ICTUtils;
import com.ict.erp.service.LevelService;
import com.ict.erp.service.impl.LevelServiceImpl;
import com.ict.erp.vo.LevelInfo;


public class LevelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LevelService ls = new LevelServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = ICTUtils.getCmd(uri);
		uri = "/views" + uri;
		System.out.println(cmd);
		try {
			if(cmd==null|| cmd.equals("")) {
				uri = "/views/notFound";
			}else if(cmd.equals("levelList")) {
				String searchK = request.getParameter("searchK");
				String searchV = request.getParameter("searchV");
				LevelInfo li = null;
				System.out.println(searchK);
				System.out.println(searchV);
				
				if(searchK!=null) {
					if(searchV.length()!=0 && !searchV.equals("") && searchV!=null) {
						li = new LevelInfo();
						if(searchK.equals("liNum")) {
							li.setLiNum(Integer.parseInt(searchV));
						}else if(searchK.equals("liLevel")) {
							li.setLiLevel(Integer.parseInt(searchV));
						}else if(searchK.equals("liName")) {
							li.setLiName(searchV);
						}else if(searchK.equals("liDesc")) {
							li.setLiDesc(searchV);
						}
					}
				}
				
				request.setAttribute("liList", ls.getLiList(li));
			}else if(cmd.equals("saveLevelList")){
				List<LevelInfo> iList = new ArrayList<LevelInfo>();
				String[] liNames = request.getParameterValues("liName");
				String[] liLevels = request.getParameterValues("liLevel");
				String[] liDesc = request.getParameterValues("liDesc");
				for(int i=0;i<liNames.length;i++) {
					LevelInfo li = new LevelInfo(0, Integer.parseInt(liLevels[i]), liNames[i], liDesc[i]);
					iList.add(li);
				}
				String[] liNumStrs =  request.getParameterValues("liNum");
				liNames = request.getParameterValues("uLiName");
				liLevels = request.getParameterValues("uLiLevel");
				liDesc = request.getParameterValues("uLiDesc");
				List<LevelInfo> uList = new ArrayList<LevelInfo>();
				if(liNumStrs!=null) {
					for(int i=0;i<liNumStrs.length;i++) {
						int num = Integer.parseInt(liNumStrs[i]);
						int level = Integer.parseInt(liLevels[i]);
						LevelInfo li = new LevelInfo(num,level,liNames[i],liDesc[i]);
						uList.add(li);
					}
				}
				Map<String,List<LevelInfo>> map = new HashMap<String, List<LevelInfo>>();
				map.put("iList", iList);
				map.put("uList", uList);
				Map<String,Object> rMap = ls.insertNUpdateLiList(map);
				request.setAttribute("rMap", rMap);
				uri="/views/level/levelList";
			}else if(cmd.equals("deletelList")){
				String[] liNumStr = request.getParameterValues("liNum");
				int[] liNums = new int[liNumStr.length];
				for(int i =0 ; i<liNumStr.length;i++) {
					liNums[i]=Integer.parseInt(liNumStr[i]);
				}
				Map<String,Object> rMap = ls.deleteList(liNums);
				request.setAttribute("rMap", rMap);
				uri="/views/level/levelList";				
			}else {
				uri = "/views/notFound";
			}
		}catch(SQLException e) {
			System.out.println(e);
			request.setAttribute("error", e.getMessage());
			uri = "/views/error";
		}
		System.out.println(uri);
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}
//erd
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
