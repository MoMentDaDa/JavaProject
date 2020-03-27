package JDBC_Apart.Dao;

/**
 * @ClassName: MouseDir
 * @Description: 商品的分类对象
 * @author: 汪哒哒
 * @date: 2019年6月26日 下午5:15:20
 */

public class MouseDir {
	private int id;
	private String dirName;

	

	public int getId() {
		return id;
	}



	@Override
	public String toString() {
		return "MouseDir [id=" + id + ", dirName=" + dirName + "]";
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getDirName() {
		return dirName;
	}



	public void setDirName(String dirName) {
		this.dirName = dirName;
	}



	public MouseDir() {
	}

}
