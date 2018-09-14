package com.ict.erp.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_PATH = "C:\\jsp_study\\workspace\\file_upload\\WebContent\\upload";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getRequestURI());
		request.setCharacterEncoding("utf-8");
		if (!ServletFileUpload.isMultipartContent(request)) {
			throw new ServletException("확인플리즈");
		}
		String path = System.getProperty("java.io.tmpdir");
		System.out.println("서버의 임시 경로" + path);
		DiskFileItemFactory dfc = new DiskFileItemFactory();
		dfc.setRepository(new File(path));
		dfc.setSizeThreshold(1024 * 1024 * 5);

		ServletFileUpload sfu = new ServletFileUpload(dfc);
		try {
			List<FileItem> flist = sfu.parseRequest(request);
			Map<String, String> param = new HashMap<String, String>();
			for (FileItem f : flist) {
				if (!f.isFormField()) {
					param.put(f.getFieldName(), f.getName());
					File file = new File(UPLOAD_PATH+File.separator+f.getName());//실제 저장되는 곳
					f.write(file);
					System.out.println("in");
				} else {
					param.put(f.getFieldName(), f.getString("utf-8"));
				}
			}
			String realPath =getServletContext().getRealPath("/upload");
			System.out.println("실제 경로 : " +realPath); //temp라 서버 clean껏다키면사라짐
			System.out.println(param);
		} catch (Exception e) {

		}
		doGet(request, response);
	}

}
