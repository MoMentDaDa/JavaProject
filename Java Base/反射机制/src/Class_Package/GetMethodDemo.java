package Class_Package;

import java.lang.reflect.Method;

class Worker {
	public void dowork() {
		System.out.println("无参数");
	}

	public static void dowork(String name) {
		System.out.println("String:"+name);
	}

	private String sayHello(String name, int age) {
		System.out.println("Hello word");
		return name + "," + age;
	}
}

// 使用反射获取类中的方法
public class GetMethodDemo {

	public static void main(String[] args) throws Exception {
		// getALL();
		// getOne();
		useMethod();
	}

	// 使用获取和使用的方法
	private static void useMethod() throws Exception, Exception {
		// 获取字节码文件
		Class clz = Worker.class;
		// 获取dowork方法
		Method me = clz.getMethod("dowork");
		System.out.println(me);
		Object ret=me.invoke(clz.newInstance());//无参数
		System.out.println(ret);//null
		System.out.println("-------------");
		me=clz.getMethod("dowork", String.class);
		ret=me.invoke(clz.newInstance(), "汪");//String汪
		System.out.println(ret);//null
		System.out.println("-------------");
		me=clz.getDeclaredMethod("sayHello", String.class,int.class);
		me.setAccessible(true);//设置为可以访问私有的成员
		ret=me.invoke(clz.newInstance(), "wang",17);//应该先设置为可访问 Hello word
		System.out.println(ret);
		System.out.println("-------------");
		//执行静态方法
		me=clz.getMethod("dowork", String.class);
		ret=me.invoke(null, "lucy");
		System.out.println("-------------");
		
		
	}

	// 获取类中特定的方法
	private static void getOne() throws Exception, Exception {
		// 获取字节码文件
		Class clz = Worker.class;
		// 获取dowork方法
		Method me = clz.getMethod("dowork");
		System.out.println(me);
		System.out.println("------------");
		// 获取public static void dowork(String name)方法
		me = clz.getMethod("dowork", String.class);
		System.out.println(me);
		System.out.println("------------------------");
		// 获取private String sayHello(String name,int age)方法
		me = clz.getDeclaredMethod("sayHello", String.class, int.class);// 使用Declared可以忽略方法的权限修饰符
		System.out.println(me);
		System.out.println("-----------");
	}

	private static void getALL() {
		Class clz = Worker.class;
		Method[] me = clz.getMethods();// 获取所有公共的方法，包括继承过来的
		System.out.println(me.length);
		for (Method m : me) {
			System.out.println(m);
		}
		System.out.println("-----------");
		me = clz.getDeclaredMethods();// 该方法只会获取本类的方法，不包括继承和访问权限无关
		System.out.println(me.length);
		for (Method m : me) {
			System.out.println(m);
		}
	}

}
