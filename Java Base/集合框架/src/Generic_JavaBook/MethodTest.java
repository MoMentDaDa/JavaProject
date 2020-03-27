package Generic_JavaBook;

public class MethodTest {
//泛型类中的泛型只适用于非静态方法，要给静态方法设置泛型，必须为静态泛型方法
//泛型方法 printArray()
	public static <E> void printArray(E[] array) {// l类型参数E
		for (E element : array) {
			System.out.println(element);
		}
	}

// 泛型方法max()
	public static <T extends Comparable<T>> T max(T x, T y) {// 参数x,y 都为T类型
		return x.compareTo(y) > 0 ? x : y;
	}

	public static void main(String[] args) {
		Integer[] intArray = { 1, 2, 3, 4, 5 };
		printArray(intArray);
		System.out.println();
		System.out.println(max(12, 24));

	}

}
