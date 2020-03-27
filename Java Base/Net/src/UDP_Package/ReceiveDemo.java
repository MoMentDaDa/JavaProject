package UDP_Package;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveDemo {

	public static void main(String[] args) throws Exception {
		//创建接收端对象
		DatagramSocket receive=new DatagramSocket(10086);
		byte[] buffer=new byte[1024];
		//接受数据
		DatagramPacket dp=new DatagramPacket(buffer, 1024);
		receive.receive(dp);
		String msg=new String(dp.getData(),0,dp.getLength());
		System.out.println("发送过来的数据为："+msg);

	}

}
