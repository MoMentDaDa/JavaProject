package CookieApply;

import java.io.Serializable;
import java.util.LinkedHashMap;

public class Book implements Serializable {
	private String id;
	private String name;
	private String author;

	public Book() {
	}

	public Book(String id, String name, String author) {
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	private static LinkedHashMap<String, Book> linkedHashMap = new LinkedHashMap();
	// 简化开发复杂度，book的id和商品的id相同
	static {
		linkedHashMap.put("1", new Book("1", "javaweb", "zhong"));
		linkedHashMap.put("2", new Book("2", "java", "fu"));
		linkedHashMap.put("3", new Book("3", "oracle", "cheng"));
		linkedHashMap.put("4", new Book("4", "mysql", "ou"));
		linkedHashMap.put("5", new Book("5", "ajax", "zi"));
	}

	// 获取到所有书籍
	public static LinkedHashMap getAll() {
		return linkedHashMap;
	}

}
