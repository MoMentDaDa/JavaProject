package NetBase;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class URLDemo {
//URL对象
	public static void main(String[] args) throws Throwable {
/*		//创建URL对象
		URL url1=new URL("http","localhost",8080,"/tomcat.png");
		//打开URL的连接对象
		URLConnection conn=url1.openConnection();
		//网络-->输入-->程序中
		InputStream in=conn.getInputStream();
		Scanner sc=new Scanner(in);
		while (sc.hasNext()){
			String line=sc.nextLine();
			System.out.println(line);
		}
		sc.close();
		*/
		//把tomcat.png保存到本地
		URL url1=new URL("http","localhost",8080,"/tomcat.png");
		//打开URL的连接对象
		URLConnection conn=url1.openConnection();
		InputStream in=conn.getInputStream();
		Files.copy(in, Paths.get("download_tomcat.png"));
		
		

	}

}
