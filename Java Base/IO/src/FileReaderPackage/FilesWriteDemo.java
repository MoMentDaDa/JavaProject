package FileReaderPackage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FilesWriteDemo {
//文件输出流
	public static void main(String[] args) throws IOException {
		File desFile = new File("FilesReader\\h.txt");
		Writer out=new FileWriter(desFile);
		out.write("A");
		out.write("\n");
		out.write("BBBCC".toCharArray());
		out.write("\n");
		out.write("RRRRR", 2, 3);
		out.write("\n");
		String sb=new String("gggg");
		out.write(sb);
		out.write("\n");
	out.close();
	}

		
	
}
