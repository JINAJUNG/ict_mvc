package com.ict.erp.listener;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.ict.erp.common.ServiceFactory;

/**
 * Application Lifecycle Listener implementation class InitListener
 *
 */
@WebListener
public class InitListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public InitListener() {
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent cte)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent cte)  {
    	ServletContext ctx = cte.getServletContext();
    	Enumeration<String> names = ctx.getInitParameterNames();
    	while(names.hasMoreElements()) {
    		String key = names.nextElement();
    		String className = ctx.getInitParameter(key);
    		System.out.println("key : " + key);
    		System.out.println("className : " + className);
    		ServiceFactory.setService(key, className);
    	}
    }
	
}