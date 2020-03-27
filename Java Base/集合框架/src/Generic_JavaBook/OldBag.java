package Generic_JavaBook;

public class OldBag<T> {

//无泛型之前示例
	/*
	 * private Object content;
	 * 
	 * public OldBag(Object content) { this.content = content; }
	 * 
	 * public Object get() { return this.content; }
	 * 
	 * public void set(Object content) { this.content = content; }
	 * 
	 * public static void main(String[] args) { OldBag bag = new OldBag("maybook");
	 * Object content = (Integer)
	 * bag.get();//OldBag引用为String类型，强转为Integer抛出java.lang.ClassCastException }
	 */

//泛型定义和使用
	private T content;// 把content定义为泛型,T为类型参数，用来泛指content实例变量类型

	public OldBag(T content) {
		this.content = (T) content;
	}

	public T get() {
		return this.content;
	}

	public void set(T content) {
		this.content = content;
	}

	public static void main(String[] args) {
		OldBag<String> bag = new OldBag<String>("maybook");// 把OldBag定义为String类型
		String content2 = bag.get();
		System.out.println(content2);
		// OldBag定义为String类型，Integer接受不会抛出java.lang.ClassCastException，但是不合法
		//Integer content1 = bag.get();
	}

}
