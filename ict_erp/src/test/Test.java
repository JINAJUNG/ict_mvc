package test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.ict.erp.Person;


public class Test {

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "고영찬");
		map.put("age", 27);
		Person p = new Person();
		BeanUtils.populate(p, map);
		System.out.println(p);
	}
}
