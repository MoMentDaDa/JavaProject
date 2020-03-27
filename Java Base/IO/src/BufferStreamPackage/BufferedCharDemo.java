package BufferStreamPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//测试字符缓冲流
public class BufferedCharDemo {

	public static void main(String[] args) throws IOException {
		//创建字符缓冲输出流
		BufferedWriter bout=new BufferedWriter(new FileWriter("FilesTest/FileBufferedChar.txt"));
		bout.write("寥落古行宫，宫花寂寞红。");
		bout.newLine();
		bout.write("白头宫女在，闲坐说玄宗。");
		bout.flush();
		bout.close();
		BufferedReader bin=new BufferedReader(new FileReader("FilesTest/FileBufferedChar.txt"));
	//使用传统的方法读取
	/*	char[] buffer=new char[1024];
		int len=-1;
		while((len=bin.read(buffer))!=-1){
			System.out.println(new String(buffer,0,len));
		}
		bin.close();*/
	//使用缓冲流的read方法读取
		String len=null;
		while((len=bin.readLine())!=null){
			System.out.println(len);
		}
		bin.close();
		
		
	}

}
