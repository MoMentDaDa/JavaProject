package OtherIO_Package;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) throws IOException {
		//ɨ���ļ��е�����
		Scanner in=new Scanner(new File("FilesTest/FileBufferedChar.txt"),"GBK");
		//ɨ��������������
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextLine()){
			String line=sc.nextLine();
			System.out.println("Echo��"+line);
		}
		in.close();
		sc.close();
	}

}
