package Class_Package;

import java.lang.reflect.Method;
import java.util.Arrays;

class Employee {
	public static void dowork(int... arr) {
		System.out.println("静态方法1调用：" + Arrays.toString(arr));
	}

	public void dowork2(String... arr) {
		System.out.println("非静态方法2调用," + Arrays.toString(arr));
	}
	private String sayHello(String name, int age) {
		System.out.println("Hello word:"+name+age);
		return name + "," + age;
	}
}

// 使用反射调用数组参数（可变参数）
public class ArrayInvokeMethodDemo {

	public static void main(String[] args) throws Exception, Exception {
		Class clz = Employee.class;
		// 情况一：数组元素为基本类型
		Method me = clz.getMethod("dowork", int[].class);
		// me.invoke(null, 1,2,3,4,5);提示错误参数
		me.invoke(null, new int[] { 1, 2, 3, 4, 5 });
		me.invoke(null, new Object[]{new int[]{1,2,3,4,5}});
		// 情况2：数组元素为引用类型
		me=clz.getMethod("dowork2", String[].class);
		System.out.println(me);
		//me.invoke(null, "A","B","C");错误
		//me.invoke(null, new String[]{"A","B","C"});错误
		me.invoke(clz.newInstance(), new Object[]{new String[]{"A","B","C"}});
		//调用多参数形式
		me=clz.getDeclaredMethod("sayHello",String.class,int.class);
		System.out.println(me);
		me.setAccessible(true);
		me.invoke(clz.newInstance(),new Object[]{"Lucy",18});//使用Object数组传递参数
	}

}
