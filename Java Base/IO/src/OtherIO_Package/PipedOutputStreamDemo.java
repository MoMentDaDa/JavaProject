package OtherIO_Package;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

//Ïß³ÌÁ÷
class BThread extends Thread {
	PipedInputStream in = null;

	public BThread(AThread aThread) throws IOException {
		in = new PipedInputStream(aThread.getOut());
	}

	public void run() {
		int len = -1;
		try {
			while ((len = in.read()) != -1) {
				System.out.print((char) len);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class AThread extends Thread {
	public static PipedOutputStream out = new PipedOutputStream();

	public PipedOutputStream getOut() {
		return out;
	}

	public void run() {
		try {
			for (int i = 65; i < 65 + 26; i++) {
				out.write(i);
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

public class PipedOutputStreamDemo {

	public static void main(String[] args) throws IOException {
		AThread a = new AThread();
		BThread b = new BThread(a);
		a.start();
		b.start();

	}
}
