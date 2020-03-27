package Generic_JavaBook;

import java.util.*;
import java.util.List;

public class WildCastTest {

	public static void main(String[] args) throws Exception {
		List<Integer> listInteger = new ArrayList<Integer>();
		listInteger.add(11);
		//print(listInteger);  编译出错，不兼容类型，
		printNew(listInteger);//因为collection<?>表示通配符，所以可以传递给方法
	}

	public static void print(Collection<Object> collection) {
		for (Object obj : collection) {
			System.err.println(obj);
		}
	}

	public static void printNew(Collection<?> collection) {
		//通配符还可以与extends、super连用，用来限制上限和下限   Tree<?extends 类型1>x=new TreeSet<类型2>();类型表示特定类型，类型2位其子类或者是类型1
		for (Object obj : collection) {
			System.err.println(obj);
		}
	}

}
