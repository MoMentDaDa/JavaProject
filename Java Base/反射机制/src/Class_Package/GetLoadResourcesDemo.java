package Class_Package;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//加载资源文件
public class GetLoadResourcesDemo {

	public static void main(String[] args) throws Exception {
		//1、使用绝对路径,
		//test1();
		//2、使用相对于classpath的根路径中寻找文件加载，resources文件夹和编译一起编译的
		//test2();
		//3、使用相对于当前加载资源文件的字节码路径
		test3();
	}

	private static void test3() throws Exception {
		Properties p=new Properties();
		InputStream in=GetLoadResourcesDemo.class.getResourceAsStream("db.properties");//从该字节码的路径去寻找该文件，即字节码所在文件路径
		p.load(in);//加载文件
		System.out.println(p);
		
	}

	private static void test2() throws Exception {
		Properties p=new Properties();
		ClassLoader loader=Thread.currentThread().getContextClassLoader();//从线程类中获取一个类加载器
		InputStream in=loader.getResourceAsStream("db.properties");
		p.load(in);//加载文件
		System.out.println(p);
		
	}

	private static void test1() throws Exception {
		Properties p=new Properties();
		InputStream in=new FileInputStream("D:/JAVA/Java Base/反射机制/resources/db.properties");
		p.load(in);//加载文件
		System.out.println(p);
		
	}
	

}
