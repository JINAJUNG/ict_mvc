package test;

import java.lang.reflect.Method;

public class RefiTest {
	public static void main(String[] args) {
		String classPath="com.ict.erp.Person";
		
		try {
			Class clazz = Class.forName(classPath);
			Object obj = clazz.newInstance(); //생성자 호출 new---,obj에 Person클래스가 담겨있다.
			System.out.println(obj);//Person에 재정의 해놓은 toString이 실행됨
			Method[] methods = clazz.getMethods();
			for(Method m : methods) {
				System.out.println(m.getName());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
