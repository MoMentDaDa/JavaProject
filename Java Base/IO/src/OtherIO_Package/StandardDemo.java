package OtherIO_Package;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

//��׼���������
public class StandardDemo {

	public static void main(String[] args) throws IOException {
		System.out.println("���������ݣ�");
		//�ض���������
		System.setIn(new FileInputStream("FilesTest/FileBufferedChar.txt"));
		System.setOut(new PrintStream("FilesTest/Standar.txt"));
		int data=System.in.read();
		System.out.println("��������ǣ�"+data);

	}

}
