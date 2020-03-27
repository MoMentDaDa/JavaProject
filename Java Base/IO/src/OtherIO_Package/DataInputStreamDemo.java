package OtherIO_Package;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//������
public class DataInputStreamDemo {

	public static void main(String[] args) throws IOException {
		File f=new File("D:/JAVA/Java Base/IO/FilesTest/DataStream");
		writer(f);
		read(f);

	}
//��������
	private static void read(File f) throws IOException {
		DataInputStream in=new DataInputStream(new FileInputStream(f));
		System.out.println(in.readByte());
		System.out.println(in.readChar());
		System.out.println(in.readUTF());
		in.close();
		
	}
//д������
	private static void writer(File f) throws IOException {
		DataOutputStream out=new DataOutputStream(new FileOutputStream(f));
		out.writeByte(65);
		out.writeChar('��');
		out.writeUTF("�����");
		out.close();
	}

}
