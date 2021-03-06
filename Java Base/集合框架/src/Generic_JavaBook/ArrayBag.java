package Generic_JavaBook;

public class ArrayBag<T> {
//定义泛型数组
	// private T[] content=new T[10]; 不能用泛型来创建数组实例
	private T[] content;// content表示泛型数组

	public ArrayBag(T[] content) {
		this.content = content;
	}

	public void setContent(T[] content) {
		this.content = content;
	}

	public T[] getContent() {
		return this.content;
	}

	public static void main(String[] args) {
		String[] content = { "book1", "book2", "book3" };// 创建一个String类型数组
		ArrayBag<String> bag = new ArrayBag<String>(content);// 传递给ArrayBag类的构造方法，构造方法为String类型
		for (String c : bag.getContent()) {
			System.out.println(c);
		}

	}

}
