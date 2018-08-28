package com.ict.erp.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class ICTUtils {
	private static final String PRE_FIX = "/WEB-INF";
	private static final String SUF_FIX = ".jsp";
	private static final String SEP_STR = "/";

	public static String getCmd(String uri) {
		int idx = uri.lastIndexOf(SEP_STR);
		if (idx == -1) {
			return null;
		}
		return uri.substring(idx + 1);
	}

	public static String getJSPPage(String uri) {
		return PRE_FIX + uri + SUF_FIX;
	}

	public static <T> T parse(HttpServletRequest req, Class clazz) {
		Map<String, String[]> pMap = req.getParameterMap();
		Iterator<String> it = pMap.keySet().iterator();
		Method[] methods = clazz.getMethods();
		T obj = null;
		try {
			obj = (T) clazz.newInstance();
			while (it.hasNext()) {
				String key = it.next();
				for (Method method : methods) {
					String mName = method.getName();
					if (mName.indexOf("set") == 0) {
						if (mName.toUpperCase().indexOf(key.toUpperCase()) != -1) {
							Class<?>[] types = method.getParameterTypes();
							System.out.println(types[0]);

							if (types[0].getTypeName().equalsIgnoreCase("java.lang.Long")) {
								method.invoke(obj, Long.parseLong(pMap.get(key)[0]));
							} else {
								method.invoke(obj, pMap.get(key)[0]);
							}
						}
					}
				}
			}
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
}
