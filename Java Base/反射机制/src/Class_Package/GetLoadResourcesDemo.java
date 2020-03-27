package Class_Package;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//������Դ�ļ�
public class GetLoadResourcesDemo {

	public static void main(String[] args) throws Exception {
		//1��ʹ�þ���·��,
		//test1();
		//2��ʹ�������classpath�ĸ�·����Ѱ���ļ����أ�resources�ļ��кͱ���һ������
		//test2();
		//3��ʹ������ڵ�ǰ������Դ�ļ����ֽ���·��
		test3();
	}

	private static void test3() throws Exception {
		Properties p=new Properties();
		InputStream in=GetLoadResourcesDemo.class.getResourceAsStream("db.properties");//�Ӹ��ֽ����·��ȥѰ�Ҹ��ļ������ֽ��������ļ�·��
		p.load(in);//�����ļ�
		System.out.println(p);
		
	}

	private static void test2() throws Exception {
		Properties p=new Properties();
		ClassLoader loader=Thread.currentThread().getContextClassLoader();//���߳����л�ȡһ���������
		InputStream in=loader.getResourceAsStream("db.properties");
		p.load(in);//�����ļ�
		System.out.println(p);
		
	}

	private static void test1() throws Exception {
		Properties p=new Properties();
		InputStream in=new FileInputStream("D:/JAVA/Java Base/�������/resources/db.properties");
		p.load(in);//�����ļ�
		System.out.println(p);
		
	}
	

}
