package Socket_Package;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

//�����
public class ServerDemo {

	public static void main(String[] args) throws Exception {
		//����˵�����
		String data="�����ˣ��Է���������������";
		//��������ˣ�ָ���˿�Ϊ8888
		ServerSocket server =new ServerSocket(8888);
		System.out.println("������Ѿ�׼�����ˡ���������");
		//�������Ӹ÷���Ŀͻ��˶���
		Socket client =server.accept();
		System.out.println("���ӹ����Ŀͻ��ˣ�"+client.getInetAddress());
		
		PrintStream out=new PrintStream(client.getOutputStream());
		out.println(data);
		out.close();
		server.close();
		

	}

}
