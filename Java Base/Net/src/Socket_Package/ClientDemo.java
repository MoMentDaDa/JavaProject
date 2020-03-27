package Socket_Package;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

//客户端
public class ClientDemo {

	public static void main(String[] args) throws Exception, IOException {
		Socket client=new Socket("localhost",8888);
		//接受服务端发送过来的数据
		Scanner sc=new Scanner(client.getInputStream());
		while(sc.hasNext()){
			String line=sc.nextLine();
			System.out.println(line);
		}
		sc.close();
		client.close();

	}

}
