package FileStreamPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFilesAndRenameDemo {

	public static void main(String[] args) throws IOException {
		File srcDir = new File("FilesTest");//源路径
		File desDir = new File("desFiles");//目的路径
		File[] fs = srcDir.listFiles(new FilenameFilter() {//过滤器
			public boolean accept(File Dir, String name) {
				return new File(Dir, name).isFile() && name.endsWith(".java");
			}
		});
		//迭代对象并拷贝
		for (File srcFile : fs) {
			InputStream in = new FileInputStream(srcFile);
			OutputStream out = new FileOutputStream(new File(desDir, srcFile.getName()));
			byte[] buffer = new byte[1024];
			int len = -1;
			len = in.read(buffer);
			while (len != -1) {
				out.write(buffer, 0, len);
				len = in.read(buffer);
			}
			//修改文件后缀名
			File[] fs2=desDir.listFiles();
			String deleteText =".java";
			for(int i=0;i<fs2.length;i++){
				if (fs2[i].getName().contains(deleteText)) {
					String newFileName = fs2[i].getName().replace(deleteText, ".txt");
					fs2[i].renameTo(new File(desDir, newFileName));
				}
			/*	String name=file.getName();
				String newEndsWith=name.replace(".java", ".txt");
				File newFile=new File(desDir,newEndsWith);
				file.renameTo(newFile);*/
				
				
			}
			
			in.close();
			out.close();
		}

	}

}
