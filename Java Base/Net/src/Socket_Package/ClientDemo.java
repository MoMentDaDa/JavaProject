package Socket_Package;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

//�ͻ���
public class ClientDemo {

	public static void main(String[] args) throws Exception, IOException {
		Socket client=new Socket("localhost",8888);
		//���ܷ���˷��͹���������
		Scanner sc=new Scanner(client.getInputStream());
		while(sc.hasNext()){
			String line=sc.nextLine();
			System.out.println(line);
		}
		sc.close();
		client.close();

	}

}
