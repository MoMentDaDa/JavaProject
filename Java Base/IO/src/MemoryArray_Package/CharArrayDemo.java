package MemoryArray_Package;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;
//�ַ��ڴ���/������
public class CharArrayDemo {

	public static void main(String[] args) throws IOException {
		//�ַ����������
		CharArrayWriter writer=new  CharArrayWriter();
		writer.write("���������");
		char[] data=writer.toCharArray();
		//�ַ�����������
		CharArrayReader reader=new CharArrayReader(data);
		System.out.println((char)reader.read());
		System.out.println((char)reader.read());
		System.out.println((char)reader.read());
		System.out.println((char)reader.read());
		System.out.println((char)reader.read());
		
	}

}
