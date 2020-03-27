package BufferStreamPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class TransformStreamDemo {

	public static void main(String[] args) throws IOException {
		File src=new File("FilesTest/FileBufferedChar.txt");
		File des=new File("desFiles/FileBufferedChar_copy.txt");
		FileOutputStream out2=new FileOutputStream(des);
		FileInputStream in1=new FileInputStream(src);
		Reader in=new InputStreamReader(in1, "GBK");
		Writer out=new OutputStreamWriter(out2,"GBK");
		char[] buffer=new char[1024];
		int len=-1;
		while((len=in.read(buffer))!=-1){
			out.write(buffer, 0, len);
		}
		in.close();
		out.close();
		

	}

}
