package com.ict.erp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
public class AuthFilter implements Filter {
	private Log log = LogFactory.getLog(this.getClass());
    public AuthFilter() {
        // TODO Auto-generated constructor stub
    }
	public void destroy() {
		// TODO Auto-generated method stub
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hsr = (HttpServletRequest)request;
		HttpSession hs = hsr.getSession();
		
		//트레이스-연계된 정보 표현
		log.trace(hsr.getRequestURI());
		//디버그-디버그
		log.debug(hsr.getRequestURI());
		//인포-운영에 가까운 정보
		log.info(hsr.getRequestURI());
		//워닝-애매한데 안지켜도 되는거 지적
		log.warn(hsr.getRequestURI());
		//에러-에러(익셉션에서 일어난일들)
		log.error(hsr.getRequestURI());
		//엄청심각한에러(치명적인에러)
		log.fatal(hsr.getRequestURI());
		
		if(hs.getAttribute("user")==null) {
			//권한처리필요(로그인페이지이동로직추가필요)
			System.out.println("너 권한 없음");
		}
		chain.doFilter(request, response);
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
