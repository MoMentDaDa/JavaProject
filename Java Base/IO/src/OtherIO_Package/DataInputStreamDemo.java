package OtherIO_Package;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//数据流
public class DataInputStreamDemo {

	public static void main(String[] args) throws IOException {
		File f=new File("D:/JAVA/Java Base/IO/FilesTest/DataStream");
		writer(f);
		read(f);

	}
//读入数据
	private static void read(File f) throws IOException {
		DataInputStream in=new DataInputStream(new FileInputStream(f));
		System.out.println(in.readByte());
		System.out.println(in.readChar());
		System.out.println(in.readUTF());
		in.close();
		
	}
//写入数据
	private static void writer(File f) throws IOException {
		DataOutputStream out=new DataOutputStream(new FileOutputStream(f));
		out.writeByte(65);
		out.writeChar('哥');
		out.writeUTF("王哥哥");
		out.close();
	}

}
