package OtherIO_Package;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableDemo {
	public static void main(String[] args) throws Exception {
		File f = new File("FilesTest/User.txt");
		writeObject(f);
		readObject(f);
	}

	private static void readObject(File f) throws Exception {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
		UserDeom person = (UserDeom) in.readObject();
		System.out.println(person);
		in.close();
	}

	private static void writeObject(File f) throws IOException, IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
		out.writeObject(new UserDeom("Íô", 17));
		out.close();
	}
}
