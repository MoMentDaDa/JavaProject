package FileReaderPackage;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
//使用纯文本完成文件拷贝
public class FilesCopyDemo {

	public static void main(String[] args) throws IOException {
		File srcFiles=new File("FilesReader\\ch.txt");
		File decFiles=new File("FilesReader\\ch_copy.txt");
		Reader in=new FileReader(srcFiles);
		Writer out=new FileWriter(decFiles);
		char[] ch=new char[100];
		int len=-1;
		len=in.read(ch);
		while(len!=-1){
			System.out.println(ch);
			out.write(ch, 0, len);
			len=in.read(ch);
		}
		in.close();
		out.close();
		

	}

}
