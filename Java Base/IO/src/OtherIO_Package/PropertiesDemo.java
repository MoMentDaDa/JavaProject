package OtherIO_Package;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

//����properties�����ļ�
public class PropertiesDemo {

	public static void main(String[] args) throws Exception {
		Properties p=new Properties();
		InputStream in=new FileInputStream("D:/JAVA/Java Base/IO/FilesTest/db.properties");
		p.load(in);
		System.out.println(p);
		System.out.println("�˺�:"+p.getProperty("username"));
		System.out.println("����:"+p.getProperty("password"));

	}

}
