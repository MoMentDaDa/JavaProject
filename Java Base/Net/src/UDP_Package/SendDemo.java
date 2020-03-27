package UDP_Package;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendDemo {

	public static void main(String[] args) throws Exception {
		
		String data="苍茫的天涯是我的爱";
		//创建发送端对象
		DatagramSocket sender=new DatagramSocket(10010);
		DatagramPacket dp=new DatagramPacket(data.getBytes(),
				data.getBytes().length,
				InetAddress.getLocalHost(),
				10086);
		sender.send(dp);
		sender.close();

	}

}
