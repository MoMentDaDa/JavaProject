package FileReaderPackage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

//ÎÄ¼þ×Ö·ûÁ÷
public class FileReaderDemo {

	public static void main(String[] args) throws IOException {
		File srcFile = new File("FilesReader/ch.txt");
		Reader in = new FileReader(srcFile);
		char[] buffer = new char[5];
		int len = -1;
		len = in.read(buffer);
		System.out.println(len);
		System.out.println(buffer);
		while (len != -1) {
			System.out.println(buffer);
			System.out.println(len);
			len = in.read(buffer);
			System.out.println(buffer);
			System.out.println(len);
		}
		in.close();

	}

}
