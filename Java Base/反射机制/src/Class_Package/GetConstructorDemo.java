package Class_Package;

import java.lang.reflect.Constructor;

class user {

	public user() {

	}
	public user(String name) {

	}

	private user(String name, int age) {

	}
}

public class GetConstructorDemo {

	public static void main(String[] args) throws Exception {
		getAll();
		getOne();

	}

	private static void getOne() throws Exception, Exception {
		// 1、获取构造器所在类的字节码对象
		Class<user> clz = user.class;
		//需求1、获取公共不带参的构造器
		Constructor<user> con = clz.getConstructor();// 该方法只能获取公共的构造器
		System.out.println(con);
		System.out.println("------------------");
		//3、获取带参数构造器
		con=clz.getDeclaredConstructor(String.class);
		System.out.println(con);
		System.out.println("------------------");
		//4、获取私有权限带参数的构造器
		con=clz.getDeclaredConstructor(String.class,int.class);
		System.out.println(con);
		
	}

	private static void getAll() throws Exception, Exception {
		// 1、获取构造器所在类的字节码对象
		Class<user> clz = user.class;
		// 2、获取类中所有的构造器
		Constructor<?>[] con = clz.getConstructors();// 该方法只能获取公共的构造器
		System.out.println(con.length);
		for (Constructor<?> c : con) {
			System.out.println(c);
		}
		System.out.println("------------------");
		con = clz.getDeclaredConstructors();// 获取类中的所有构造器方法和访问权限无关
		System.out.println(con.length);
		for (Constructor<?> c : con) {
			System.out.println(c);
		}
		System.out.println("------------------");
	}

}
