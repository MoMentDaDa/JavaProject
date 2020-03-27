package OtherIO_Package;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

//标准的输入输出
public class StandardDemo {

	public static void main(String[] args) throws IOException {
		System.out.println("请输入内容：");
		//重定向输入流
		System.setIn(new FileInputStream("FilesTest/FileBufferedChar.txt"));
		System.setOut(new PrintStream("FilesTest/Standar.txt"));
		int data=System.in.read();
		System.out.println("你输入的是："+data);

	}

}
