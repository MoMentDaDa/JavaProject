package Socket_Package;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务端
public class ServerDemo {

	public static void main(String[] args) throws Exception {
		//服务端的数据
		String data="你来了，吃饭啦，吃了再走呗";
		//创建服务端，指定端口为8888
		ServerSocket server =new ServerSocket(8888);
		System.out.println("服务端已经准备好了。。。。。");
		//接受连接该服务的客户端对象
		Socket client =server.accept();
		System.out.println("连接过来的客户端："+client.getInetAddress());
		
		PrintStream out=new PrintStream(client.getOutputStream());
		out.println(data);
		out.close();
		server.close();
		

	}

}
