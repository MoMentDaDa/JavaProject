package FilePackage;

import java.io.*;

public class FilesRenameDemo {
	public static void main(String[] args) {
		// ��ȡҪɾ����Ŀ¼
		File dir = new File("E:\\������\\��ԭ����");
		File[] fs = dir.listFiles();// ͨ�������ļ���Ȼ����ļ�����fs����
		// ��Ҫ���滻����ɾ��������
		String deleteText = "����ע΢�Ź��ں� ���Ŷ������꣨chaocaibook����ȡ����������ϡ�";
		for (File file : fs) {
			if (file.getName().contains(deleteText)) {
				String newFileName = file.getName().replace(deleteText, "");
				file.renameTo(new File(dir, newFileName));
			}
		}
	}
}
