package FilePackage;

import java.io.*;

//ͨ���ݹ�ʵ���ļ���Ŀ¼�ı���
public class FiesTraversingDemo {
	public static void main(String[] args) {
		File dir = new File("D:\\JAVA����\\Java����");
		listAllFiles(dir);

	}

	// �ݹ鷽�������ļ�
	private static void listAllFiles(File f) {
		// ��һ���ļ�
		File[] fs = f.listFiles();
		for (File file : fs) {
			// ��ӡĿ¼���ļ�
			System.out.println(fs);
			// �����Ŀ¼���ݹ����ʵ�ֱ���
			if (file.isDirectory()) {
				listAllFiles(file);
			}
		}
	}
	// ��ʹ�õݹ�
	/*
	 * private static void listAllFiles(File f) { System.out.println(f);
	 * //��һ�����ļ� File[] fs = f.listFiles(); for (File file : fs) {
	 * System.out.println(file); //�ڶ������ļ� if (file.isDirectory()) { File[] fs2 =
	 * file.listFiles(); for (File file2 : fs2) { System.out.println(file2);
	 * //���������ļ� if (file2.isDirectory()) { File[] fs3 = file2.listFiles(); for
	 * (File file3 : fs3) { System.out.println(fs3); } } } } } }
	 */
}
