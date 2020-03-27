package Junit;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class JunitTestDemo {
	public static void main(String[] args) throws Exception {
		EmployeeDAOTestDemo obj=new EmployeeDAOTestDemo();
		//获取字节码对象
		Class clz = EmployeeDAOTestDemo.class;
		//创建集合用于保存注释对象
		List<Method> before = new ArrayList<>();
		List<Method> test = new ArrayList<>();
		List<Method> after = new ArrayList<>();
		//获得被注释的方法
		Method[] m = clz.getMethods();
		//循环判断是否有注释，并归纳到相应的集合中
		for (Method me : m) {
			if (me.isAnnotationPresent(MyBefore.class)) {
				before.add(me);
			} else if (me.isAnnotationPresent(MyTest.class)) {
				test.add(me);
			} else if (me.isAnnotationPresent(MyAfter.class)) {
				after.add(me);
			}
		}
		System.out.println(before);
		System.out.println(test);
		System.out.println(after);
		for (Method tm : test) {
			for(Method bm:before) {
				bm.invoke(obj);
			}
			tm.invoke(obj);
			for(Method am:after) {
				am.invoke(obj);
			}
		}
	}
}
