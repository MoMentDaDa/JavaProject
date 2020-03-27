package Tomcat_Package;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//超级简单模拟Tomcat服务器,浏览器为客户端
public class SuperSimpleTomcatDemo {

	public static void main(String[] args) throws Exception {
		ServerSocket server=new ServerSocket(9999);
		while(true){
		Socket client=server.accept();
		PrintStream ps=new PrintStream(client.getOutputStream());
		Scanner sc=new Scanner(new FileInputStream("D:/JAVA/Java Base/Net/腾讯课堂_专业的在线教育平台.html"));
		while(sc.hasNext()){
			ps.println(sc.nextLine());
		}
		sc.close();
		}
		
	}

}
