package OtherIO_Package;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class IOPrintDemo {

	public static void main(String[] args) throws IOException {

		// StreamPrint打印输出流
		PrintStream ps = new PrintStream(new FileOutputStream("FilesTest/Print.txt"));
		ps.print("ABCDFG");
		ps.write("gjgis".getBytes());
		ps.print(true);
		ps.print(17);
		ps.println("wang");
		ps.close();

		// PrintWriter打印输出流,需要自动刷新
		PrintWriter ps2 = new PrintWriter(new FileOutputStream(new File("FilesTest/Print2.txt")),true);
		ps2.write("ABCSF");
		ps2.print(true);
		ps2.println("sgagdaf");
		ps2.print(17);
		ps2.close();

	}

}
