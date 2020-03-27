package MemoryArray_Package;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;
//字符内存流/数组流
public class CharArrayDemo {

	public static void main(String[] args) throws IOException {
		//字符数组输出流
		CharArrayWriter writer=new  CharArrayWriter();
		writer.write("汪哥棒棒哒");
		char[] data=writer.toCharArray();
		//字符数组输入流
		CharArrayReader reader=new CharArrayReader(data);
		System.out.println((char)reader.read());
		System.out.println((char)reader.read());
		System.out.println((char)reader.read());
		System.out.println((char)reader.read());
		System.out.println((char)reader.read());
		
	}

}
