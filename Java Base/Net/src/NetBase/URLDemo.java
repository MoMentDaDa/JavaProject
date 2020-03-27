package NetBase;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class URLDemo {
//URL����
	public static void main(String[] args) throws Throwable {
/*		//����URL����
		URL url1=new URL("http","localhost",8080,"/tomcat.png");
		//��URL�����Ӷ���
		URLConnection conn=url1.openConnection();
		//����-->����-->������
		InputStream in=conn.getInputStream();
		Scanner sc=new Scanner(in);
		while (sc.hasNext()){
			String line=sc.nextLine();
			System.out.println(line);
		}
		sc.close();
		*/
		//��tomcat.png���浽����
		URL url1=new URL("http","localhost",8080,"/tomcat.png");
		//��URL�����Ӷ���
		URLConnection conn=url1.openConnection();
		InputStream in=conn.getInputStream();
		Files.copy(in, Paths.get("download_tomcat.png"));
		
		

	}

}
